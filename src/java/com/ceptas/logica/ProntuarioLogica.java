/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ceptas.logica;

import com.ceptas.dao.AnimalDAO;
import com.ceptas.dao.ProntuarioDAO;
import com.ceptas.model.Prontuario;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author DESENV
 */
public class ProntuarioLogica implements Logica {

    private ProntuarioDAO dao;

    public ProntuarioLogica() {
        dao = new ProntuarioDAO();
    }

    public String executa(HttpServletRequest req, HttpServletResponse res)
            throws Exception {

        String destino = "WEB-INF/jsp/prontuario.jsp";
        String acao = req.getParameter("acao");
        
        if (acao.equalsIgnoreCase("buscar")) {
            System.out.println("ProntuarioLogica=buscar");
            Prontuario prontuario = new ProntuarioDAO().getProntuarioById(Integer.parseInt(req.getParameter("prontuarioId")));
            List<Prontuario> prontuarios = new ArrayList();
            if (prontuario.getId() != 0)
                prontuarios.add(prontuario);
            System.out.println("Prontuario ID = " + prontuario.getId());
            req.setAttribute("prontuarios", prontuarios);

            destino = "/WEB-INF/jsp/listaProntuario.jsp";
        }else if (acao.equalsIgnoreCase("listar")) {
            List<Prontuario> prontuarios = new ProntuarioDAO().getAllProntuarios();

            req.setAttribute("prontuarios", prontuarios);

            destino = "/WEB-INF/jsp/listaProntuario.jsp";
        } else if (acao.equalsIgnoreCase("editar")) {
            int prontuarioId = Integer.parseInt(req.getParameter("prontuarioId"));
            Prontuario prontuario = dao.getProntuarioById(prontuarioId);
            req.setAttribute("prontuario", prontuario);
            destino = "WEB-INF/jsp/prontuario.jsp";
        } if (acao.equalsIgnoreCase("novo")) {
            
            //int animalId = Integer.parseInt(req.getParameter("animalId"));
            
            //Prontuario prontuario = new Prontuario();
            
            //prontuario.setAnimal(new AnimalDAO().getAnimalById(animalId));
            
            //req.setAttribute("prontuario", prontuario);
            destino = "WEB-INF/jsp/prontuario.jsp";
            
        }else if (acao.equalsIgnoreCase("cadastrar")) {

            destino = "/mvc?logica=ProntuarioLogica&acao=listar";
            Prontuario prontuario = new Prontuario();
            //DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");
            //Calendar cal = Calendar.getInstance();

            prontuario.setAnimal(new AnimalDAO().getUnicoAnimalByMarcacao(req.getParameter("prontuarioAnimalMarcacao")));
            prontuario.setDtEntrada(req.getParameter("prontuarioDtEntrada"));
            //prontuario.setDtEntrada(dateFormat.format(cal));
            prontuario.setApreensao(req.getParameter("prontuarioApreensao"));
            prontuario.setLocalizacao(req.getParameter("prontuarioLocalizacao"));
            prontuario.setDiagnostico(req.getParameter("prontuarioDiagnostico"));
            prontuario.setDescProcedimento(req.getParameter("prontuarioDescProcedimento"));
            prontuario.setDtSaida(req.getParameter("prontuarioDtSaida"));

            String prontuarioId = req.getParameter("prontuarioId");
            if (prontuarioId == null || prontuarioId.isEmpty()) {
                dao.adicionarProntuario(prontuario);
            } else {
                prontuario.setId(Integer.parseInt(prontuarioId));
                dao.atualizarProntuario(prontuario);
            }
        } else if (acao.equalsIgnoreCase("apagar")) {
            System.out.println("ProntuarioLogica=apagar");
            destino = "/mvc?logica=ProntuarioLogica&acao=listar";
            
            int prontuarioId = Integer.parseInt(req.getParameter("prontuarioId"));
            dao.removerProntuario(prontuarioId);
        
        }

        return destino;
    }

}
