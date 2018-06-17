/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ceptas.logica;

import com.ceptas.dao.ProntuarioDAO;
import com.ceptas.model.Grafico;
import com.ceptas.model.Prontuario;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RelatorioLogica implements Logica {

    public RelatorioLogica() {

    }

    public String executa(HttpServletRequest req, HttpServletResponse res)
            throws Exception {

        String destino = "WEB-INF/jsp/relatorio.jsp";

        System.out.println("RelatorioLogica");

        System.out.println("mesInicio = " + req.getParameter("mesInicio") + " \nmesFim = " + req.getParameter("mesFim"));
        String acao = req.getParameter("acao");

        if (acao.equalsIgnoreCase("gerar")) {
            System.out.println("RelatorioLogica=gerar");
            String relatorioInicio = req.getParameter("relatorioInicio");
            String relatorioFim = req.getParameter("relatorioFim");
            System.out.println(relatorioInicio);
            System.out.println(relatorioFim);
            List<Grafico> graficos = new ProntuarioDAO().getProntuarioPeriodo(relatorioInicio, relatorioFim);

            String grafico = "<script type=\"text/javascript\">\n"
                    + "      google.charts.load('current', {'packages':['corechart']});\n"
                    + "      google.charts.setOnLoadCallback(drawChart);\n"
                    + "\n"
                    + "      function drawChart() {\n"
                    + "\n"
                    + "        var data = google.visualization.arrayToDataTable([\n"
                    + "          ['Modo de apreensão', 'Quantidade'],\n";
            for (Grafico g : graficos) {
                grafico += "        ['" + g.getTipo() + "', " + g.getQuantidade() + "], \n";
            }
            grafico += "        ]);\n"
                    + "\n"
                    + "        var options = {\n"
                    + "        title: 'Gráfico de " + relatorioInicio + " até " + relatorioFim + "',\n"
                    + "        colors: ['#3BA9D7', '#343C47', '#6DBB4B', '#f3b49f', '#f6c7b6'], \n"
                    + "        titleTextStyle: {\n"
                    + "        color: '#371963',  \n"
                    + "        fontName: 'Verdana', \n"
                    + "        fontSize: 16, \n"
                    + "        bold: false, \n"
                    + "        italic: false, \n"
                    + "        width: 800, \n"
                    + "        height: 500 } \n"
                    + "        };\n"
                    + "\n"
                    + "        var chart = new google.visualization.PieChart(document.getElementById('chart_div'));\n"
                    + "\n"
                    + "        chart.draw(data, options);\n"
                    + "      }\n"
                    + "    </script>";

            req.setAttribute("grafico", grafico);

        }

        return destino;

    }

}
