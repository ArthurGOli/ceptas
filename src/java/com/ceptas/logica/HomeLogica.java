/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ceptas.logica;

import com.ceptas.dao.ProntuarioDAO;
import com.ceptas.model.Prontuario;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author DESENV
 */
public class HomeLogica implements Logica{
    
    public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
        
        List<Prontuario> prontuarios = new ProntuarioDAO().getProntuariosPendente();
        req.setAttribute("prontuarios", prontuarios);

        return "/WEB-INF/jsp/home.jsp";

    }
}
    

