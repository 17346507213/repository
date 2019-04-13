<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%
String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
+ request.getContextPath() + "/";
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
<body style="overflow-y:hidden;">

<div style="margin-top: 100px;margin-bottom: 100px;background:#4F92ED;">
	<div style="background:url('<%=basePath %>static/images/login01.jpg') no-repeat;width:900px;height:441px;">
		<div id="panel" class="easyui-panel" title="登陆" style="background:#fafafa;width:400px;height:341px;" data-options="iconCls:'icon-login',style:{position:'absolute',left:600,top:200}">
			<center style="padding-top: 30px;">
				<form  id="loginFrom">
				<p><label>用户名：</label><input type="text" name="loginName"/></p>
				<p><label>密&nbsp;&nbsp;&nbsp;码：</label><input name="password" type="password" /></p>
				<p><label>验证码：</label>			<input name="authCode" type="text"  />
				<p><img type="image" src="<%=basePath %>/auth/code" id="codeImage"  style="cursor:pointer;"/>
				<a id="codeSwitch" href="javascript:void(0)">换一张</a></p>
				</p>
				<a id="loginBtn" href="javascript:void(0)" class="easyui-linkbutton" style="width:150px;height:30px;margin-left: 50px;" data-options="iconCls:'icon-ok'">&nbsp;登  陆&nbsp;&nbsp;</a>
				</form>
			</center>
		</div>
	</div>
</div>
	<script type="text/javascript">
	$(function(){
		$("input[name=password]").keyup(function(event){
			  if(event.keyCode ==13){
				  $("#loginBtn").click();
			  }
			});
		$("input[name=authCode]").keyup(function(event){
			  if(event.keyCode ==13){
				  $("#loginBtn").click();
			  }
			});
		//换一张验证码
		$("#codeSwitch").click(function(){
			$("#codeImage").attr("src",'<%=basePath %>/auth/code?time=' + new Date().getTime());
			
		});	
		$("#loginBtn").click(function(){
				var loginName = $("input[name=loginName]").val();
				var password = $("input[name=password]").val();
				var authCode = $("input[name=authCode]").val();
				loginName = loginName ? loginName.trim() :"";
				password = password ? password.trim() :"";
				authCode = authCode ? authCode.trim() :"";
				if(loginName){
					if(password){
						if(authCode){
							$.ajax({
								url:'<%=basePath%>/auth/getCurrentCode',
								success:function(code){
									if(code==authCode.toLowerCase()){
										$.ajax({
											url:'<%=basePath%>/sysUser/login.do',
											type : 'post',
											data:{loginName:$("input[name=loginName]").val(),password:$("input[name=password]").val(),code:authCode},
											success:function(result){
												if(result=="ok"){//登陆成功
													window.location.href="<%=basePath%>/pages/login/main.jsp"; 
												}else if(result=="userMsg"){
													$.messager.alert("系统提示","用户名或密码错误！","error",function(){
														$("input[name=loginName]").val("");
														$("input[name=password]").val("");
														$("input[name=loginName]").focus();
													});
												}else{
													$("#codeSwitch").click();
													$.messager.alert("系统提示","验证码错误！","error",function(){
														$("input[name=authCode]").val("");
														$("input[name=authCode]").focus();
													});
												}
											}
										});
									}else{
										$("#codeSwitch").click();
										$.messager.alert("系统提示","验证码错误！","error",function(){
											$("input[name=authCode]").val("");
											$("input[name=authCode]").focus();
										});
									}
								}
							});
						}else{
							$.messager.alert("系统提示","请填写验证码！");
						}
					}else{
						$.messager.alert("系统提示","请填写密码！");
					}
				}else{
					$.messager.alert("系统提示","请填写用户名！");
				}
		});
		
	});
	 
	</script>
</body>
</html>