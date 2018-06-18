<%-- 
    Document   : sucess
    Created on : 18/06/2018, 10:03:20
    Author     : DESENV
--%>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
    <title>Login Success</title>
</head>
<body>
    <p>Login efetuado com sucesso.</p>

    <p>Bem vindo <bean:write name="LoginForm" property="usuario" /></p>
</body>