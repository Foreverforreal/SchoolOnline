<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" href="resources/styles/jqx.base.css" type="text/css" />
	<link rel="stylesheet" href="resources/styles/jqx.ui-lightness.css" type="text/css" />
	<link rel="stylesheet" href="resources/styles/bootstrap.min.css" type="text/css" />
	
	<script type="text/javascript" src="resources/js/jquery-1.11.1.min.js"></script>
	<script type="text/javascript" src="resources/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="resources/js/jqxcore.js"></script>
	<script type="text/javascript" src="resources/js/jqxribbon.js"></script>
	<script type="text/javascript" src="resources/js/jqxwindow.js"></script>
	<script type="text/javascript" src="resources/js/jqxlayout.js"></script>
	<script type="text/javascript" src="resources/js/jqxdockinglayout.js"></script>
	<script type="text/javascript" src="resources/js/jqxdata.js"></script>
    <script type="text/javascript" src="resources/js/jqxbuttons.js"></script>
    <script type="text/javascript" src="resources/js/jqxscrollbar.js"></script>
    <script type="text/javascript" src="resources/js/jqxlistbox.js"></script>
    <script type="text/javascript" src="resources/js/jqxmenu.js"></script>
    <script type="text/javascript" src="resources/js/jqxgrid.js"></script>
    <script type="text/javascript" src="resources/js/jqxgrid.selection.js"></script>
    <script type="text/javascript" src="resources/js/jqxgrid.columnsresize.js"></script>
    <script type="text/javascript" src="resources/js/jqxgrid.filter.js"></script>
    <script type="text/javascript" src="resources/js/jqxgrid.sort.js"></script>
    <script type="text/javascript" src="resources/js/jqxdropdownlist.js"></script>
    <script type="text/javascript" src="resources/js/jqxcheckbox.js"></script>
    <script type="text/javascript" src="resources/js/jqxgrid.edit.js"></script>
    <script type="text/javascript" src="resources/js/jqxnotification.js"></script>
    <script type="text/javascript" src="resources/js/jqxnavbar.js"></script>
    <script type="text/javascript" src="resources/js/jqxloader.js"></script>
    <script type="text/javascript" src="resources/js/jqxcombobox.js"></script>
    <script type="text/javascript" src="resources/js/jqxinput.js"></script>
		<title>学校上线</title>
	</head>
	
	<style type="text/css">
			#content{
					position: absolute;
		   			top: 30%;
		   			left: 50%;
		    		margin-left: -250px;
				}
			 
			label {
			  width: 120px;
			  font-size: 14px;
			  line-height: 30px;
			  display: inline-block;
			  text-align: right;
			}
			input[type=text]{
			  height: 25px;
			  border: 1px solid #ddd;
			  padding-left: 10px;
			  font-size: 13px;
			  border-radius: 3px;
			  width: 140px;
			  display: inline-block;
			}
	</style>
	
	 
	<body >
		<div id="content">
			<form action="addSchool">
				<label for="school">校名 :</label>
				<input type="text" class="f_input" id="school" name="schoolName">
				<br/>
				<label for="symbol">symbol :</label>
				<input type="text" class="f_input" id="symbol" name="symbol" ><span id='validator' style='color:red'></span>
				<br/>
				<label for="category">类型 :</label>
				<div id='category' class="f_input" style="display: inline-block;"></div>
				<br/>
				<label for="database">数据库 :</label>
				<div id='database' class="f_input" style="display: inline-block;"></div>
				<br/>
				<input type="button" value="提交" id='submit'/>
			</form>
		</div>
	</body>
	
	<script type="text/javascript"> 
	var categorySource=[
	       {
	    	   label:"成教",
	    	   value:1
	       },
	       {
	    	   label:"培训",
	    	   value:0
	       },

	        ]
	var databaseSource=[
           {
	    	   label:"instance1",
	    	   value:1
   	       },
           {
	    	   label:"instance2",
	    	   value:2
   	       },
           {
	    	   label:"instance3",
	    	   value:3
   	       }
	 ]
	
	 var validate=true;
	
	 $(document).ready(function () { 
		 $("#school").jqxInput({
			 placeHolder: "输入校名",  minLength: 1, width: '200px'
		 });
		 $("#symbol").jqxInput({
			 placeHolder: "输入学校缩写",  minLength: 1 , width: '200px'
		 });

		 $("#category").jqxDropDownList({ source: categorySource, selectedIndex: 0 , width: '200px'});
		 $("#database").jqxDropDownList({ source: databaseSource, selectedIndex: 2 , width: '200px'});

	})
	
	  $('#symbol').on('keyup', function (event){
		    var schoolSymbol = $('#symbol').val(); 
		 	$.get("AuthenticateSymbol?schoolSymbol="+schoolSymbol, function(result){
				if(result == true){					
					$("#validator").text("已经存在");
					validate=false;
				}else{
					$("#validator").text("");
					validate=true;
				}
			});
	 }); 
	 
	 $('#submit').on('click', function () { 
		 	var schoolName=$('#school').val().trim(); 
		 	var schoolSymbol = $('#symbol').val().trim(); 
		 	var category = $('#category').jqxDropDownList('getSelectedItem').value; 
		 	var database = $('#database').jqxDropDownList('getSelectedItem').value; 
		 	
		 	if(schoolName=='' || schoolSymbol==''){
		 		alert("填上必须信息");
		 		return null;
		 	}else if(validate){
	 		    var schoolSymbol = $('#symbol').val(); 
			 	$.get("AuthenticateSymbol?schoolSymbol="+schoolSymbol, function(result){
					if(result == true){					
						$("#validator").text("已经存在");
						validate=false;
					}else{
						$("#validator").text("");
						$.get("addSchool?schoolName="+schoolName+"&schoolSymbol="+schoolSymbol+"&category="+category+"&database="+database, function(result){
							if(result == 'success'){					
								alert("学校添加成功");
							}
						});
					}
				});
		 	}else{
		 		alert("symbol已经存在");
		 	}
	  })
	  
	</script>
	
</html>
