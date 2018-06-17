<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>CEPTAS - Sistema de cadastro - Prontuarios pendentes</title>
        <link href="${pageContext.request.contextPath}/estilo/estilo.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>

        <jsp:include page="menu.jsp" />

        <c:choose>
            <c:when test="${empty prontuarios}">
                <div>Não há prontuarios pendentes</div>
            </c:when>
            <c:otherwise>
                <table class="lista">
                    <thead>
                        <tr>
                            <th>Prontuario ID</th>
                            <th>Marcação Animal</th>
                            <th>Animal</th>
                            <th>Data entrada</th>
                            <th>Localizacao</th>
                            <th colspan="2" class="botoes"></th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${prontuarios}" var="prontuario">

                            <tr>
                                <td><c:out value="${prontuario.id}" /></td>
                                <td><c:out value="${prontuario.animal.marcacao}" /></td>
                                <td><c:out value="${prontuario.animal.especie}" /></td>
                                <td><c:out value="${prontuario.dtEntrada}" /></td>
                                <td><c:out value="${prontuario.localizacao}" /></td>
                                <td><a
                                        href="mvc?logica=ProntuarioLogica&acao=editar&prontuarioId=<c:out value="${prontuario.id }"/>"><img src="<c:url value="/img/edit.png" />" class="imgEditar" title="Editar"/></a></td>
                                <td><a
                                        href="UsuarioController?action=delete&usuarioId=<c:out value="${prontuario.id }"/>"><img src="<c:url value="/img/delete.png" />" class="imgApagar" title="Apagar"/></a></td>
                            </tr>
                        </c:forEach>
                    </c:otherwise>    
                </c:choose>
            </tbody>
        </table>
    </body>
</html>
