<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>CEPTAS - Sistema de cadastro - Lista de usuarios</title>
        <link href="${pageContext.request.contextPath}/estilo/estilo.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>

        <jsp:include page="menu.jsp" />
 
        <c:choose>
            <c:when test="${empty usuarios}">
                <div>Não há usuarios</div>
            </c:when>
            <c:otherwise>
                <table class="lista">
                    <thead>
                        <tr>
                            <th>Usuario ID</th>
                            <th>Login</th>
                            <th>Ativo</th>
                            <th colspan="2" class="botoes"></th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${usuarios}" var="usuario">

                            <tr>
                                <td><c:out value="${usuario.id}" /></td>
                                <td><c:out value="${usuario.login}"  /></td>
                                <td><c:out value="${usuario.ativo ? 'Ativo' : 'Desativado'}" /></td>
                               
                                <td><a
                                        href="mvc?logica=UsuarioLogica&acao=editar&usuarioId=<c:out value="${usuario.id }"/>"><img src="<c:url value="/img/edit.png" />" class="imgEditar" title="Editar"/></a></td>
                                <td><a
                                        href="mvc?logica=UsuarioLogica&acao=apagar&usuarioId=<c:out value="${usuario.id }"/>"><img src="<c:url value="/img/delete.png" />" class="imgApagar" title="Apagar"/></a></td>
                            </tr>
                        </c:forEach>
                    </c:otherwise>    
                </c:choose>
            </tbody>
        </table>
    </body>
</html>
