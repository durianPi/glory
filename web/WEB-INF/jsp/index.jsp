<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>欢迎</title>
</head>
<body>
${data }
    <h2>Hello World!</h2>

    <form action="/login.action">
        用户名：<input type="text" id="username" name="username"/>
        密码：<input type="password" id="password" name="password"/>
        <input type="submit" value="提交"/>
    </form>
</body>
</html>