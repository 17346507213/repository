<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort() +request.getContextPath()+"/";
%>
<!DOCTYPE html>
<html>
<head>
	<base href="<%=basePath %>">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	
	<title>登录</title>
	
</head>
<body>
	<table id="menuTable"></table>
	<script type="text/javascript">
		$("#menuTable").datagrid({
			url:'<%=basePath%>/sysMenu/getAllSysMenuByPage.do',
			columns:[[{checkbox:true},
				{field:"menu_name",title:"菜单名称",width:100,align:'center',formatter:function(value,row,index){
					if(row.parent_id=="-1"){
						return "<span style='color:red'>"+value+"</span>";
					}else{
						return value;
					}
				}},
				{field:"menu_code",title:"菜单编号",width:100,align:'center'},
				{field:"state",title:"状态",width:100,align:'center',formatter:function(value,row,index){
					if(value=="closed"){
						return '关闭';
					}else if(value=="open"){
						return "展开";
					}else{
						return "未知";
					}
				}},
				{field:"iconCls",title:"图标",width:100,align:'center'},
				{field:"parent_id",title:"父id",width:100,align:'center'},
				{field:"href",title:"地址",width:200,align:'center',formatter:function(value,row,index){
					if(value){
						return value;
					}else{
						return "无连接";
					}
				}},
				{field:"order_by",title:"排序",width:50,align:'center'}
				]],
			pagination:true,
			fit:true,
			rownumbers:true,
			toolbar:[
				{iconCls:'icon-add',text:"添加菜单",handler:function(){
					$('#menuForm').form('reset');
					$('#parent_id').combobox('reload','<%=basePath%>/sysMenu/getSysMenuByNotId.do');
					$("#add").window({
						width:400,
						height:400,
						title:"添加菜单",
						iconCls:"icon-add",
						modal:true
					});
					
				}}
			,'-',{iconCls:'icon-remove',text:"删除菜单",handler:function(){
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
								url:'<%=basePath%>/sysMenu/deleteSysMenu.do',
								type:'post',
								dataType:'json',
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
			,'-',{iconCls:'icon-edit',text:"修改菜单",handler:function(){
				var rows = $("#menuTable").datagrid("getSelections");
				if(rows.length==1){
					$("#menuForm").form("reset");
					$("#add").window({
						width:400,
						height:400,
						title:"修改菜单",
						iconCls:"icon-add",
						modal:true
					});
					$("#menuForm").form("load","<%=basePath%>/sysMenu/getSysMenuById.do?id="+rows[0].id);
					$('#parent_id').combobox('reload','<%=basePath%>/sysMenu/getSysMenuByNotId.do?id='+rows[0].id);
				}else if(rows.length==0){
					$.messager.alert("系统提示","请选择记录！");
				}else{
					$.messager.alert("系统提示","只能选择一条记录！");
				}
		}}]
		});
	</script>
	<div id="add" style="padding-top: 30px;">
		<form id="menuForm">
			<center>
				<input type="text" name="id" hidden="hidden" />
				<div style="margin:10px auto;">
					<label for="menu_code">编号:</label> <input class="easyui-validatebox"
						type="text" name="menu_code" data-options="required:true" />
				</div>
				<div style="margin:10px auto;">
					<label for="menu_name">名称:</label> <input class="easyui-validatebox"
						type="text" name="menu_name" data-options="required:true" />
				</div>

				<p>
					状态： <select id="state" name="state" class="easyui-combobox" data-options="editable:false,panelHeight:'auto'">
						<option value="open">展开</option>
						<option value="closed" selected="selected">关闭</option>
					</select>
				</p>
				<p>
					图标：<input type="text" name="iconCls" />
				</p>
				<p>
					父级：<input type="text" name="parent_id" id="parent_id"/>
				</p>
				<p>
					路径：<input type="text" name="href" />
				</p>
				<p>
					排序：<input type="text" name="order_by" />
				</p>
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
					url:'<%=basePath%>/sysMenu/insertSysMenu.do',
					type : 'post',
					data : $("#menuForm").serializeObject(),
					dataType : 'json',
					cache : false,
					contentType : 'application/json',
					success : function(result) {
						if (result == 1) {
							$("#add").window("close");
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
			$("#add").window("close");
		});
		$('#parent_id').combobox({    
		    url:'<%=basePath%>/sysMenu/getSysMenuByNotId.do',    
		    valueField:'id',    
		    textField:'menu_name',
		    panelHeight:'auto',
		    editable:false
		});  
	</script>
</body>
</html>