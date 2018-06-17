<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>CEPTAS - Sistema de cadastro - Registro de usuário</title>
        <link href="${pageContext.request.contextPath}/estilo/estilo.css" rel="stylesheet" type="text/css"/>
    </head>

    <body>

        <jsp:include page="menu.jsp"/>

        <div id="corpo">

            <div id="tituloCorpo"> CADASTRO DE USUÁRIO </div> 

            <form action="mvc?logica=UsuarioLogica&acao=cadastrar" method="post">
                <table id="formulario">

                     <tr hidden>
                        <td><label for="usuarioId">ID:</label></td> 
                        <td><input type="text" name="usuarioId" value="<c:out value="${usuario.id}" />" readonly="readonly" placeholder="Usuario ID" /> </td>
                    </tr>
                    <tr>
                        <td><label for="usuarioLogin">Login:</label></td> 
                        <td><input type="text" name="usuarioLogin" value="<c:out value="${usuario.login}" />"/> </td>
                    </tr>
                    <tr>
                        <td><label for="usuarioSenha">Senha:</label> </td>
                        <td><input type="text" name="usuarioSenha" value="<c:out value="${usuario.senha}" />"/></td>
                    </tr>
                    <tr>
                        <td><label for="usuarioAtivo">Ativo:</label> </td>
                        <td><input type="checkBox" name="usuarioAtivo" value="<c:out value="${usuario.ativo}" />"
                                   <c:choose>
                                        <c:when test="${usuario.ativo}">
                                            checked
                                        </c:when>
                                    </c:choose>
                                   /></td>
                    </tr>


                    <tr><td id="btnAcaoRodape" colspan="2"><input type="submit" value="Cadastrar"/></td></tr>

                </table>
            </form>
        </div> 

    </body>

</html>