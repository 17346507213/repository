<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort() +request.getContextPath()+"/";
%>
<!DOCTYPE html>
<html>
<head>
	<base href="<%=basePath %>">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>出版社管理</title>
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
			url:'<%=basePath%>/booksPress/getBooksPressByPage.do',
			columns:[[{checkbox:true},
				{field:"pressName",title:"出版社",width:100,align:'center'},
				{field:"pressAddress",title:"地址",width:200,align:'center'}
				]],
			fit:true,
			pagination:true,
			rownumbers:true,
			toolbar:[
				{iconCls:'icon-add',text:"添加出版社",handler:function(){
					$('#menuForm').form('reset');
					$("#typeAdd").window({
						width:400,
						height:300,
						title:"添加出版社",
						iconCls:"icon-add",
						modal:true
					});
					
				}}
			,'-',{iconCls:'icon-remove',text:"删除出版社",handler:function(){
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
								url:'<%=basePath%>/booksPress/deleteBooksPress.do',
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
			,'-',{iconCls:'icon-edit',text:"修改出版社",handler:function(){
				var rows = $("#menuTable").datagrid("getSelections");
				if(rows.length==1){
					$("#menuForm").form("reset");
					$("#typeAdd").window({
						width:400,
						height:300,
						title:"修改出版社",
						iconCls:"icon-add",
						modal:true
					});
					$("#menuForm").form("load","<%=basePath%>/booksPress/getBooksPressById.do?id="+rows[0].id);
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
			<center>
				<input type="text" name="id" hidden="hidden" />
				<div style="margin:10px auto;">
					<label for="menu_code">出版社:</label> <input class="easyui-validatebox"
						type="text" name="pressName" data-options="required:true" />
				</div>
				<div style="margin:10px auto;">
					<label for="menu_name">地&nbsp;&nbsp;&nbsp;址:</label> <input class="easyui-validatebox"
						type="text" name="pressAddress" />
				</div>
				<p>
					<a href="javascript:void(0)" class="easyui-linkbutton"
						id="saveButton" data-options="iconCls:'icon-ok'">确认</a>&nbsp;&nbsp;
					<a href="javascript:void(0)" class="easyui-linkbutton"
						id="cancelButton" data-options="iconCls:'icon-cancel'">取消</a>
				</p>
			</center>
		</form>
	</div>
	<script type="text/javascript">
		$("#saveButton").click(function(){
			var validate = $("#menuForm").form("validate");
			if(validate){
				$.ajax({
					url:'<%=basePath%>/booksPress/insertOrUpdateBooksPress.do',
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
	</script>
</body>
</html>