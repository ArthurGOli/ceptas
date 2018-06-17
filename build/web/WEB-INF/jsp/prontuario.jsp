<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

        <title>CEPTAS - Sistema de cadastro - Registro de prontuario</title>
        <link href="${pageContext.request.contextPath}/estilo/estilo.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
     
        <jsp:include page="menu.jsp" />
        <div id="corpo">
            <div id="tituloCorpo"> CADASTRO DE PRONTUÁRIO </div> 

            <form action="mvc?logica=ProntuarioLogica&acao=cadastrar" method="post">

                <div hidden>
                    <label for="prontuarioId">Prontuario ID</label> <input type="text"
                                                                           name="prontuarioId" value="<c:out value="${prontuario.id}" />"
                                                                           readonly="readonly" placeholder="Prontuario ID"/>
                </div>
                <table id="formulario">                                                          
                    <tr><td id="tdLabel">
                            <label for="prontuarioAnimalId">Animal Marcação:</label></td> <td><input type="text"
                                                                                                name="prontuarioAnimalMarcacao" value="<c:out value="${prontuario.animal.marcacao}" />"
                                                                                                /></td></tr>

                    <tr><td id="tdLabel"> <label for="prontuarioDtEntrada">Data Entrada:</label></td> <td><input type="date"
                                                                                                             name="prontuarioDtEntrada" value="<c:out value="${prontuario.dtEntrada}" />"
                                                                                                             /></td></tr>


                    <tr><td id="tdLabel"> <label for="prontuarioApreensao">Modo de Apreensão:</label></td> 
                        <td > <input type="radio" name="prontuarioApreensao" value="Apreensão"
                                    <c:choose><c:when test="${prontuario.apreensao == 'Apreensão'}">checked</c:when></c:choose>> Apreensão
                            <input type="radio" name="prontuarioApreensao" value="Resgate"
                                    <c:choose><c:when test="${prontuario.apreensao == 'Resgate'}">checked</c:when></c:choose>> Resgate 
                            <input type="radio" name="prontuarioApreensao" value="Voluntária"
                                    <c:choose><c:when test="${prontuario.apreensao == 'Voluntária'}">checked</c:when></c:choose>> Voluntária </td>
                    </tr>


                    <tr><td id="tdLabel"> <label for="prontuarioLocalizacao">Localização:</label></td> <td> <input type="text"
                                                                                                                   name="prontuarioLocalizacao" value="<c:out value="${prontuario.localizacao}" />"
                                                                                                                   /></td></tr>


                    <tr><td id="tdLabel"><label for="prontuarioDiagnostico">Diagnóstico</label></td> <td> <input type="text"
                                                                                  name="prontuarioDiagnostico" value="<c:out value="${prontuario.diagnostico}" />"
                                                                                  /></td></tr>
                    
                    
                    <tr><td id="tdLabel"> <label for="prontuarioDescProcedimento">Descrição do Procedimento:</label></td> <td> <input type="text"
                                                                                                name="prontuarioDescProcedimento" value="<c:out value="${prontuario.descProcedimento}" />"
                                                                                                /></td></tr>
                    
                    
                    <tr><td id="tdLabel"> <label for="prontuarioDtSaida">Data Saída:</label></td> <td><input type="date"
                                                                              name="prontuarioDtSaida" value="<c:out value="${prontuario.dtSaida}" />"
                                                                              /></td></tr>
                    
                    
                    <tr><td id="btnAcaoRodape" colspan="2"> <input type="submit" value="Cadastrar" /></td></tr>
                    
                </table>
            </form>
        </div>
        
    </body>
</html>