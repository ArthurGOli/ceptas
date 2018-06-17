<%-- 
    Document   : login
    Created on : 09/05/2017, 19:48:16
    Author     : DESENV
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="${pageContext.request.contextPath}/estilo/estilo.css" rel="stylesheet" type="text/css"/>
        <title>CEPTAS - Sistema de cadastro - Bem-vindo</title>

        <script>
            function validarLogin() {
                var mystring = document.getElementById('usuarioLogin').value;
                if (!mystring.match(/\S/)) {
                    alert('Digite um login');
                    return false;
                } else {
                    mystring = document.getElementById('usuarioSenha').value;
                    if (!mystring.match(/\S/)) {
                        alert('Digite uma senha');
                        return false;
                    } else {
                        return true;
                    }
                }
            }
        </script>
    </head>
    <body>
        <div id="centraliza">
            <div id="faixalogin1"></div>
            <div id="corpo">        
                <img id="imglogin1" src="${pageContext.request.contextPath}/img/logoCeptas.png" alt=""/>
                <img id="imglogin2" src="${pageContext.request.contextPath}/img/logoUnimonte.png" alt=""/>
                <div id="camposlogin">
                    <form action="mvc?logica=UsuarioLogica&acao=logar" onsubmit="return validarLogin(this)" method="post">
                        <table id="formulario">
                            <tr><td id="textoLogin">Seja bem-vindo</td></tr>
                            <tr><td id="tdLabel">Login:<input type="text" name="usuarioLogin" id="usuarioLogin"/></td></tr>
                            <tr> <td id="tdLabel">Senha:<input type="password" name="usuarioSenha" id="usuarioSenha"/></td></tr>
                            <tr><td id="btnAcaoRodape" colspan="2"> <input type="submit" value="ENTRAR"/></td></tr>
                        </table>
                </div>
                </form>
                <jsp:include page="rodape.jsp" />
                </body>
            </div> 
        </div> 
</html>
