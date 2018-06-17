<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>CEPTAS - Sistema de cadastro - Lista de prontuarios</title>
        <link href="${pageContext.request.contextPath}/estilo/estilo.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>

        <jsp:include page="menu.jsp" />
        
        <div id="corpo">
            
            <div id="tituloCorpo">LISTA DE PRONTUARIOS</div> </br>
            
            <form action="mvc?logica=ProntuarioLogica&acao=buscar" method="post">
                
                    <div>
                        <label for="animalMarcacao">Digite o ID do prontuario:</label> <input type="number" max="999999999"
                                                                                   name="prontuarioId" value="<c:out value="${prontuario.id}" />"
                                                                                   />
                    </div></br>
                                                                                   <div>
                        <input type="submit" value="Consultar" />
                                                                                   </div></br>
                
            </form>
        </div>
 
        <c:choose>
            <c:when test="${empty prontuarios}">
                <div>Não há prontuarios</div>
            </c:when>
            <c:otherwise>
                <table class="lista">
                    <thead>
                        <tr>
                            <th>Prontuario ID</th>
                            <th>Animal ID / Marcacao</th>
                            <th>Data entrada</th>
                            <th>Apreensao</th>
                            <th>Localizacao</th>
                            <th>Diagnostico</th>
                            <th>Procedimento</th>
                            <th>Data saida</th>
                            <th colspan="2" class="botoes"></th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${prontuarios}" var="prontuario">

                            <tr>
                                <td><c:out value="${prontuario.id}" /></td>
                                <td><c:out value="${prontuario.animal.id}" /> <c:out value="${prontuario.animal.marcacao}" /></td>
                                <td><c:out value="${prontuario.dtEntrada}" /></td>
                                <td><c:out value="${prontuario.apreensao}" /></td>
                                <td><c:out value="${prontuario.localizacao}" /></td>
                                <td><c:out value="${prontuario.diagnostico}" /></td>
                                <td><c:out value="${prontuario.descProcedimento}" /></td>
                                <td><c:out value="${prontuario.dtSaida}" /></td>

                                <td><a
                                        href="mvc?logica=ProntuarioLogica&acao=editar&prontuarioId=<c:out value="${prontuario.id }"/>"><img src="<c:url value="/img/edit.png" />" class="imgEditar" title="Editar"/></a></td>
                                <td><a
                                        href="mvc?logica=ProntuarioLogica&acao=apagar&prontuarioId=<c:out value="${prontuario.id }"/>"><img src="<c:url value="/img/delete.png" />" class="imgApagar" title="Apagar"/></a></td>
                            </tr>
                        </c:forEach>
                    </c:otherwise>    
                </c:choose>
            </tbody>
        </table>
    </body>
</html>
