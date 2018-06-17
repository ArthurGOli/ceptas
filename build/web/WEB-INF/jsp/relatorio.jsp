<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <script type="text/javascript" src="${pageContext.request.contextPath}/js/loader.js"></script>

        ${grafico}


        <title>CEPTAS - Sistema de cadastro - Relatório</title>
        <link href="${pageContext.request.contextPath}/estilo/estilo.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>

        <jsp:include page="menu.jsp" />
        <div id="corpo">
            <div id="tituloCorpo"> RELATÓRIO DE APREENSÃO </div> </br>
            <form action="mvc?logica=RelatorioLogica&acao=gerar" method="post">
                <div
>                    <label for="prontuarioId">Mês: </label> <input type="month"
                                                                   name="relatorioInicio" value="<c:out value="" />"
                                                                   />
                    <label for="prontuarioId">até </label> <input type="month"
                                                                  name="relatorioFim" value="<c:out value="" />"
                                                                  />
                    <input type="submit" value="Gerar" />
                </div>
                <div id="chart_div"></div>
            </form>
        </div>
    </body>
</html>