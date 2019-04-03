<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ request.getContextPath() + "/";
%>
<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>系统首页</title>
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
<body class="easyui-layout">
	<div data-options="region:'north',title:'North Title',split:true"
		style="height: 100px;"></div>
	<div data-options="region:'south',title:'South Title',split:true"
		style="height: 100px;"></div>
	<div
		data-options="region:'west',title:'West',split:true,iconCls:'icon-world'"
		style="width: 150px;">
		<ul id="menu"></ul>
	</div>
	<div data-options="region:'center',title:'center title',noheader:true"
		style="padding: 5px; background: #eee;">
		<div id="centerTabs" class="easyui-tabs" data-options="fit:true">
			<div title="首页" style="padding: 20px;"
				data-options="iconCls:'icon-house'">首页</div>
		</div>
	</div>
</body>
<script type="text/javascript">
 	$(function(){
 		$("#menu").tree({
 			url:"<%=basePath%>/sysMenu/loadMenu.do",
 			lines:true,
 			animate:true,
 			onClick:function(node){
 				if(node.href){
 					var flag = $("#centerTabs").tabs("exists",node.text);
 	 				if(!flag){
 	 					  var content = "<iframe scrolling='no' frameborder='0'  src='"+node.href+"' style='width:100%;height:99%;'></iframe>";  
 					         $("#centerTabs").tabs('add',{  
 					            title:node.text,  
 					            closable:true,  
 					            content:content,  
 					            iconCls:node.iconCls  
 					        });  
 					} else {
 						$("#centerTabs").tabs("select", node.text);
 					}	
 				}
			},
			onLoadSuccess : function(node, data) {
				var t = $(this);
				if (data) {
					$(data).each(function(index, d) {
						if (this.state == 'closed') {
							t.tree('expandAll');
						}
					});
				}
			}
		});
	})
</script>
</html>