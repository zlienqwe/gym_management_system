<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
  <title>user login</title>
</head>
<body>
<h1>用户注册</h1>

<form id="register"  method="post" action="">
  用户名:<br/>
  <input type="text"  name="name" /><br/>
  密码:<br/>
  <input type="password" name="password" /><br/>
  真实名字:<br/>
  <input type="text" name="employeeName" /><br/>
  身份:<br/>
  <input type="radio" name="role" value="OPs" checked>OPs
  <input type="radio" name="role" value="coach"} >coach
  <input type="radio" name="role" value="HR"} >HR
  <br/>
  <input type="submit" value="登陆"/>
</form>
</body>
</html>
