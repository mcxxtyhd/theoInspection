<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form name="testLogin" id="testLogin" action="${pageContext.request.contextPath}/theoSystem/testAction!testOutput.action" method=post>
		<input name="username" id="username" title="用户名" type="text"/>
		<input name="password" id="password" title="密码"  type="password"/>
		<input name="submit" type="submit" value="提交">
		<button id="clear" name="clear" >重置</button>
	</form>
</body>
</html>