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
	<!-- 导入easyui的资源文件 -->
	<link rel="stylesheet" type="text/css" href="<%=basePath %>/static/js/easyui/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="<%=basePath %>/static/js/easyui/themes/icon.css">
	<script type="text/javascript" src="<%=basePath %>/static/js/easyui/jquery.min.js"></script>
	<script type="text/javascript" src="<%=basePath %>/static/js/easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="<%=basePath %>/static/js/jsonHandler.js"></script>
</head>
<body>
	
	<div id="win">
		<center style="padding-top: 30px">
			<p><label>用户名：</label><input type="text" name="loginName"/></p>
			<p><label>密&nbsp;&nbsp;码：</label><input name="password" type="password"/></p>
			<a id="loginBtn" href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-ok'">登陆</a>&nbsp;&nbsp;&nbsp;&nbsp;
			<a id="btn" href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-no'">取消</a>
		</center>
	</div>
	<script type="text/javascript">
	$(function(){
		$('#win').window({    
		    width:300,    
		    height:200,    
		    modal:true,
		    title:"登陆",
		     resizable:false,
		     collapsible:false
		}); 	
		$("#loginBtn").click(function(){
			$.ajax({
				url:'<%=basePath%>/sysUser/login.do',
				data:{loginName:$("input[name=loginName]").val(),password:$("input[name=password]").val()},
				dataType:'json',
				type:'post',
				success:function(result){
					if(result){
						window.location.href="<%=basePath%>/pages/login/main.jsp"; 
					}else{
						$.messager.alert("系统提示","用户名或密码错误！","error",function(){
							$("input[name=loginName]").val("");
							$("input[name=password]").val("");
							$("input[name=loginName]").focus();
						});
					}
				}
			})	  
		});
		
	});
	 
	</script>
</body>
</html>