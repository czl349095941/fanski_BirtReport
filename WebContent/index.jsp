<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>菲时特ERP报表平台</title>
<s:head/>
</head>
<body>

<s:form action="login" >

<s:textfield  name="Person.userName" label="用户名"></s:textfield>
<s:textfield name="Person.passWord" label="密码"></s:textfield>
<s:submit label="提交"></s:submit>
</s:form>

   
</body>
</html>