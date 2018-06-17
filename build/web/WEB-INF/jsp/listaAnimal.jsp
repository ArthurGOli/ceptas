<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>CEPTAS - Sistema de cadastro - Lista de animais</title>
        <link href="${pageContext.request.contextPath}/estilo/estilo.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>

        <jsp:include page="menu.jsp" />
        <div id="corpo">
           
        <div id="tituloCorpo">LISTA DE ANIMAIS</div> </br>
        <div>
            
            <form action="mvc?logica=AnimalLogica&acao=buscar" method="post">
                
                
                    
                    <div>
                        <label for="animalMarcacao">Digite Marcação Animal:</label> <input type="text"
                                                                                   name="animalMarcacao" value="<c:out value="${animal.marcacao}" />"
                                                                                   />
                    </div></br>
                                                                                   <div>
                        <input type="submit" value="Consultar" />
                                                                                   </div></br>
                
            </form>
        </div>
        <c:choose>
            <c:when test="${empty animais}">
                <div>Não há animais</div>
            </c:when>
            <c:otherwise>
                <table class="lista">
                    <thead>
                        <tr>
                            <th>Animal ID</th>
                            <th>Especie</th>
                            <th>Nome Popular</th>
                            <th>Grupo Taxonomico</th>
                            <th>Sexo</th>
                            <th>Idade</th>
                            <th>Marcacao</th>
                            <th colspan="2" class="botoes"></th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${animais}" var="animal">

                            <tr>
                                <td><c:out value="${animal.id}" /></td>
                                <td><c:out value="${animal.especie}" /></td>
                                <td><c:out value="${animal.nomePopular}" /></td>
                                <td><c:out value="${animal.grupoTaxonomico}" /></td>
                                <td><c:out value="${animal.sexo}" /></td>
                                <td><c:out value="${animal.idade}" /></td>
                                <td><c:out value="${animal.marcacao}" /></td>
                                <td><a
                                        href="mvc?logica=AnimalLogica&acao=editar&animalId=<c:out value="${animal.id }"/>"><img src="<c:url value="/img/edit.png" />" class="imgEditar" title="Editar"/></a></td>
                                <td><!--<a
                                        href="mvc?logica=AnimalLogica&acao=apagar&animalId=<c:out value="${animal.id }"/>"><img src="<c:url value="/img/delete.png" />" class="imgApagar" title="Apagar"/></a>--></td> 
                                    
                            </tr>
                        </c:forEach>
                    </c:otherwise>    
                </c:choose>
            </tbody>
        </table>
        </div>
    </body>
</html>
