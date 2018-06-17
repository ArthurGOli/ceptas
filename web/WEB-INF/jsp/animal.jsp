<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <title>CEPTAS - Sistema de cadastro - Registro de Animal</title>
        <link href="${pageContext.request.contextPath}/estilo/estilo.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>

        <jsp:include page="menu.jsp" />
        <div id="corpo">

            <div id="tituloCorpo"> CADASTRO DE ANIMAL </div> </br>
            <form action="mvc?logica=AnimalLogica&acao=cadastrar" method="post">
                <table id="formulario">
                    <tr hidden>
                        <td id="tdLabel"><label for="animalId">Animal ID:</label></td> 
                        <td><input type="text" name="animalId" value="<c:out value="${animal.id}" />"
                                   readonly="readonly" placeholder="Animal ID" /></td>
                    </tr>    
                    <tr>
                        <td id="tdLabel"><label for="animalEspecie">Especie:</label></td> 
                        <td><input type="text" name="animalEspecie" value="<c:out value="${animal.especie}" />"/></td>
                    </tr>
                    <tr>
                        <td id="tdLabel"><label for="animalNomePopular">Nome Popular:</label> </td> 
                        <td><input type="text" name="animalNomePopular" value="<c:out value="${animal.nomePopular}" />"/></td>
                    </tr>
                    <tr>
                        <td id="tdLabel"><label for="animalGrupoTaxonomico">Grupo Taxonomico: </label></td> 
                        <td><input type="text" name="animalGrupoTaxonomico" value="<c:out value="${animal.grupoTaxonomico}" />"/></td>
                    </tr>

                    <tr>
                        <td id="tdLabel"><label  for="animalSexo">Sexo:</label></td> 

                        <td><input type="radio" name="animalSexo" value="M"
                                   <c:choose><c:when test="${animal.sexo == 'M'}">checked</c:when></c:choose>> Macho
                            <input type="radio" name="animalSexo" value="F"
                                   <c:choose><c:when test="${animal.sexo == 'F'}">checked</c:when></c:choose>> Fêmea 
                            <input type="radio" name="animalSexo" value="I"
                                   <c:choose><c:when test="${animal.sexo == 'I'}">checked</c:when></c:choose>> Indefinido </td>
                    </tr>   

                    <tr>
                        <td id="tdLabel"><label for="animalIdade">Idade:</label></td> 
                        <td > <input type="radio" name="animalIdade" value="juvenil" 
                                     <c:choose><c:when test="${animal.idade == 'juvenil'}">checked</c:when></c:choose>> Juvenil
                            <input type="radio" name="animalIdade" value="sub-adulto"
                                   <c:choose><c:when test="${animal.idade == 'sub-adulto'}">checked</c:when></c:choose>> Sub-Adulto 
                            <input type="radio" name="animalIdade" value="adulto"
                                   <c:choose><c:when test="${animal.idade == 'adulto'}">checked</c:when></c:choose>> Adulto </td>
                    </tr>

                    <tr>
                        <td id="tdLabel"><label for="animalMarcacao">Marcacao:</label></td> <td><input type="text" name="animalMarcacao" value="<c:out value="${animal.marcacao}" />"
                                                                                          /></td>
                    <tr>        
                        <td id="btnAcaoRodape" colspan="2"><input type="submit" value="Cadastrar" /></td>
                    </tr>

                </table>
            </form>
        </div>
    </body>
</html>