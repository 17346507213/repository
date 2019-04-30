<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort() +request.getContextPath()+"/";
%>
<!DOCTYPE html>
<html>
<head>
	<base href="<%=basePath %>">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>图书管理</title>
	<!-- 导入easyui的资源文件 -->
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>/static/js/easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>/static/js/easyui/themes/icon.css">
<script type="text/javascript"
	src="<%=basePath%>/static/js/easyui/jquery.min.js"></script>
<script type="text/javascript"
	src="<%=basePath%>/static/js/easyui/jquery.easyui.min.js"></script>
<!-- 汉化 -->
<script type="text/javascript"
	src="<%=basePath%>/static/js/easyui/locale/easyui-lang-zh_CN.js"></script>
<!-- 处理JSon -->
<script type="text/javascript"
	src="<%=basePath%>/static/js/jsonHandler.js"></script>
</head>
<body>
<table id="menuTable"></table>
	<script type="text/javascript">
		$("#menuTable").datagrid({
			url:'<%=basePath%>/booksInfo/getAllBooksByPage.do',
			columns:[[{checkbox:true},
				{field:"bookType",title:"图书分类",width:60,align:'center'},
				{field:"bookCode",title:"图书编号",width:50,align:'center'},
				{field:"bookName",title:"图书名称",width:100,align:'center'},
				{field:"bookAuthor",title:"图书图书",width:100,align:'center'},
				{field:"bookState",title:"状态",width:200,align:'center'},
				{field:"registerDate",title:"登记日期",width:200,align:'center'}
				]],
			fit:true,
			fitColumns:true,
			pagination:true,
			rownumbers:true,
			toolbar:[
				{iconCls:'icon-add',text:"添加图书",handler:function(){
					$('#menuForm').form('reset');
					$("#typeAdd").window({
						width:600,
						height:380,
						title:"添加图书",
						iconCls:"icon-add",
						modal:true
					});
					
				}}
			,'-',{iconCls:'icon-remove',text:"删除图书",handler:function(){
				$.messager.confirm('确认','您确认想要删除记录吗？',function(r){    
				    if (r){    
				    	var selections = $("#menuTable").datagrid("getSelections");
						if(selections.length==0){
							$.messager.alert("系统提示","请选择记录！");
						}else{
							var ids="";
							for(var i in selections){
								ids+="'"+selections[i].id+"',";
							}
							ids=ids.substr(0,ids.length-1);
							$.ajax({
								url:'<%=basePath%>/booksInfo/deleteBooksInfo.do',
								type:'post',
								data:{'ids':ids},
								success:function(result){
									if(result){
										$("#menuTable").datagrid("reload");
										$.messager.show({
											title:'系统提示',
											msg:'删除成功！',
											timeout:5000,
											showType:"slide"
										});
									}else{
										$.messager.show({
											title:'系统提示',
											msg:'删除失败！',
											timeout:5000,
											showType:"slide"
										});
									}
								}
							});
						} 
				    }    
				});
				
			}}
			,'-',{iconCls:'icon-edit',text:"修改图书",handler:function(){
				var rows = $("#menuTable").datagrid("getSelections");
				if(rows.length==1){
					$("#menuForm").form("reset");
					$("#typeAdd").window({
						width:600,
						height:380,
						title:"修改图书",
						iconCls:"icon-add",
						modal:true
					});
					$("#menuForm").form("load","<%=basePath%>/booksInfo/getBooksInfoById.do?id="+rows[0].id);
				}else if(rows.length==0){
					$.messager.alert("系统提示","请选择记录！");
				}else{
					$.messager.alert("系统提示","只能选择一条记录！");
				}
		}}]
		});
	</script>
	<div id="typeAdd" style="padding-top: 30px;">
		<form id="menuForm">
			
				<input type="text" name="id" hidden="hidden" />
				<input type="text" name="bookImage" hidden="hidden" />
				<input type="text" name="uploadImage" hidden="hidden" />
				<input type="text" name="bookState" hidden="hidden" />
				<input type="text" name="registerDate" hidden="hidden" />
			
				<div style="margin:20px 70px;">
					<label for="menu_code">编号:</label> <input  class="easyui-validatebox"
						type="text" name="bookCode" data-options="required:true" />
				
					<label for="menu_name">名称:</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="text" name="bookName" class="easyui-validatebox" data-options="required:true"  />
					
				</div>
				<div style="margin:20px 70px;">
					<label for="menu_name">作者:</label> <input class="easyui-validatebox"
						type="text" name="bookAuthor" id="bookAuthor" />
						<label for="menu_name">出版社:</label> <input class="easyui-validatebox"
						type="text" name="bookPress" id="bookPress" />
				</div>
				<div style="margin:20px 50px;">
					<label for="menu_name">图书分类:</label> <input class="easyui-validatebox"
						type="text" name="bookType" id="bookType" />
						<label for="menu_name">图书定价:</label> <input class="easyui-validatebox"
						type="text" name="bookPrice" />
				</div>
				<div style="margin:20px 50px;">
					<label for="menu_name">图书位置:</label> <input class="easyui-validatebox"
						type="text" name="bookAddress" />
						<label for="menu_name">图书简介:</label> <input class="easyui-validatebox"
						type="text" name="bookProfile" />
				</div>
				<p style="margin:20px 200px;">
					<a href="javascript:void(0)" class="easyui-linkbutton"
						id="saveButton" data-options="iconCls:'icon-ok'">确认</a>&nbsp;&nbsp;
					<a href="javascript:void(0)" class="easyui-linkbutton"
						id="cancelButton" data-options="iconCls:'icon-cancel'">取消</a>
				</p>
			
		</form>
	</div>
	<script type="text/javascript">
		$("#saveButton").click(function(){
			var validate = $("#menuForm").form("validate");
			if(validate){
				$.ajax({
					url:'<%=basePath%>/booksInfo/insertOrUpdateBooksInfo.do',
					type : 'post',
					data : $("#menuForm").serializeObject(),
					dataType : 'json',
					cache : false,
					contentType : 'application/json',
					success : function(result) {
						if (result == 1) {
							$("#typeAdd").window("close");
							$("#menuTable").datagrid("reload");
							$.messager.show({
								title:'我的消息',
								msg:'保存成功！',
								timeout:5000,
								showType:'slide'
							});
						}
					}
				});
			}
		});
		$("#cancelButton").click(function() {
			$("#typeAdd").window("close");
		});
		//下拉列表图书分类
		$('#bookType').combobox({    
		    url:'<%=basePath%>/booksType/getAllBooksType.do',    
		    valueField:'name',    
		    textField:'name',
		    panelHeight:'auto',
		    editable:false
		});  
		//图书作者
		$('#bookAuthor').combogrid({    
			    panelWidth:330,
			    panelHeight:300,
			    idField:'authorName',    
			    textField:'authorName',    
			    url:'<%=basePath%>/booksAuthor/getAllBooksAuthorByPage.do',    
			    columns:[[    
			        {field:'authorName',title:'姓名',width:60},       
			        {field:'authorProfile',title:'简介',width:200}    
			    ]],
			    fit:true,
				pagination:true,
				rownumbers:true,
				toolbar:[
					{text:'<label>姓名：</label><input id="searchText" type="text" />'}
				,{iconCls:'icon-search',text:"查询",id:"searchBtn",handler:function(){
					var authorName = $('#searchText').val();
					authorName = authorName ? authorName.trim() : "";
					if(authorName){
						$("#bookAuthor").combogrid("grid").datagrid("load",{
							name:authorName
						});
					}else{
						$("#bookAuthor").combogrid("grid").datagrid("load",{});
					}
			}}]
		}); 
		//
		$("#searchText").keyup(function(event){
			if(event.keyCode==13){
				$("#searchBtn").click();
			}
		});
		$('#bookAuthor').combogrid('textbox').bind('focus',function(){
			$('#bookAuthor').combogrid("showPanel");
		});
		//出版社
		$('#bookPress').combogrid({    
			    panelWidth:330,
			    panelHeight:300,
			    idField:'pressName',    
			    textField:'pressName',    
			    url:'<%=basePath%>/booksPress/getBooksPressByPage.do',    
			    columns:[[    
			        {field:'pressName',title:'出版社',width:100},       
			        {field:'pressAddress',title:'地址',width:160}    
			    ]],
			    fit:true,
				pagination:true,
				rownumbers:true,
				toolbar:[
					{text:'<label>出版社：</label><input id="searchPressName" type="text" />'}
				,{iconCls:'icon-search',text:"查询",id:"searchPressBtn",handler:function(){
					var pressName = $('#searchPressName').val();
					pressName = pressName ? pressName.trim() : "";
					if(pressName){
						$("#bookPress").combogrid("grid").datagrid("load",{
							pressName:pressName
						});
					}else{
						$("#bookPress").combogrid("grid").datagrid("load",{});
					}
			}}]
		}); 
		$("#searchPressName").keyup(function(event){
			if(event.keyCode==13){
				$("#searchPressBtn").click();
			}
		});
		$('#bookPress').combogrid('textbox').bind('focus',function(){
			$('#bookPress').combogrid("showPanel");
		});
		
	</script>
</body>
</html>