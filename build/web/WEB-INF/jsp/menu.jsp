<div id="centraliza">

    <div id="cabecalho">
        <img id="imgLogoUnimonte" src="${pageContext.request.contextPath}/img/logoUnimonte.png" alt=""/>
        <img id="imgLogoCeptas" src="${pageContext.request.contextPath}/img/logoCeptas.png" alt=""/>
    </div>
    <div id="divMenu">

        <ul id="menu">
            <li><a href="#">Cadastrar</a>

                <ul id="subMenu">
                    <li><a href=mvc?logica=AnimalLogica&acao=novo">Animal</a></li>
                    <li><a href="mvc?logica=ProntuarioLogica&acao=novo">Prontuário</a></li>
                    <li><a href="mvc?logica=UsuarioLogica&acao=novo">Usuário</a></li>
                </ul>

            </li>
            <li><a href="#">Listar</a>

                <ul id="subMenu">
                    <li><a href="mvc?logica=AnimalLogica&acao=listar">Animal</a></li>
                    <li><a href="mvc?logica=ProntuarioLogica&acao=listar">Prontuário</a></li>
                    <li><a href="mvc?logica=HomeLogica">Prontuários Pendentes</a></li>
                    <li><a href="mvc?logica=UsuarioLogica&acao=listar">Usuário</a></li>
                </ul>

            </li>
            <li><a href="#">Relatórios</a>

                <ul id="subMenu">
                    <li><a href="mvc?logica=RelatorioLogica&acao=listar"">Apreensão</a></li>
                </ul>

            </li>
            <li><a href="#">&nbsp;</a></li>
        </ul>

    </div>