<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort() +request.getContextPath()+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript"
	src="<%=basePath%>/static/js/easyui/jquery.min.js"></script>
<link rel="stylesheet" href="<%=basePath %>/static/js/kindeditor-master/themes/default/default.css"/>
    <script charset="utf-8" src="<%=basePath %>/static/js/kindeditor-master/kindeditor-all.js"></script>
    <script charset="utf-8" src="<%=basePath %>/static/js/kindeditor-master/lang/zh_CN.js"></script>
   <script type="text/javascript">
   $(function () {
       //详情编辑器
       KindEditor.ready(function (K) {
           this.editor
               = K.create('textarea[id="editor"]', {
               items: ['source', '|', 'undo', 'redo', '|', 'preview', 'print', 'template', 'code', 'cut', 'copy', 'paste',
                   'plainpaste', 'wordpaste', '|', 'justifyleft', 'justifycenter', 'justifyright',
                   'justifyfull', 'insertorderedlist', 'insertunorderedlist', 'indent', 'outdent', 'subscript',
                   'superscript', 'clearhtml', 'quickformat', 'selectall', '|', 'fullscreen', '/',
                   'formatblock', 'fontname', 'fontsize', '|', 'forecolor', 'hilitecolor', 'bold',
                   'italic', 'underline', 'strikethrough', 'lineheight', 'removeformat', '|', 'multiimage',
                   'table', 'hr', 'emoticons', 'baidumap', 'pagebreak',
                   'anchor', 'link', 'unlink'],
               uploadJson: '/images',//指定上传图片的服务器端程序
               fileManagerJson: '/images',//指定浏览远程图片的服务器端程序
               allowFileManager: true
           });
       });
       $("#tan").click(function(){
    	  alert(editor.html()); 
       });
   });
</script>
</head>
<body>
   <div id = "gridDiv">
   		<textarea id="editor" style="width:600px;height:400px;visibility:hidden;">
   		
</textarea>
<button id="tan">弹出</button>
   </div>

</body>
</html>