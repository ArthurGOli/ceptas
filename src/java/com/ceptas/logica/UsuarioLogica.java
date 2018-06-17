/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ceptas.logica;

import com.ceptas.dao.UsuarioDAO;
import com.ceptas.model.Usuario;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author DESENV
 */
public class UsuarioLogica implements Logica {

    private UsuarioDAO dao;

    public UsuarioLogica() {
        dao = new UsuarioDAO();

    }

    public String executa(HttpServletRequest req, HttpServletResponse res)
            throws Exception {

        String destino = "WEB-INF/jsp/usuario.jsp";
        String acao = req.getParameter("acao");

        System.out.println("UsuarioLogica");
        if (acao.equalsIgnoreCase("logar")) {
            System.out.println("UsuarioLogica=logar");
            Usuario usuario = new UsuarioDAO().validarLogin(req.getParameter("usuarioLogin"), req.getParameter("usuarioSenha"));
            System.out.println(usuario.getLogin() + " " + usuario.getSenha());
            if (usuario.isAtivo()) {
                req.setAttribute("usuario", usuario);
                //session.setAttribute("usuarioLogado", usuario);
                //destino = "/WEB-INF/jsp/home.jsp";
                destino = "/mvc?logica=HomeLogica";
            }
            else{
                destino = "WEB-INF/jsp/login.jsp";
            }            
        } else if (acao.equalsIgnoreCase("buscar")) {
            System.out.println("UsuarioLogica=buscar");

            List<Usuario> usuarios = new UsuarioDAO().getUsuarioByLogin(req.getParameter("usuarioLogin"));

            req.setAttribute("usuarios", usuarios);

            destino = "/WEB-INF/jsp/listaUsuario.jsp";
        } else if (acao.equalsIgnoreCase("listar")) {
            System.out.println("UsuarioLogica=listar");
            List<Usuario> usuarios = new UsuarioDAO().getAllUsuarios();

            req.setAttribute("usuarios", usuarios);

            destino = "/WEB-INF/jsp/listaUsuario.jsp";
        } else if (acao.equalsIgnoreCase("editar")) {
            System.out.println("UsuarioLogica=editar");

            int usuarioId = Integer.parseInt(req.getParameter("usuarioId"));
            Usuario usuario = dao.getUsuarioById(usuarioId);
            req.setAttribute("usuario", usuario);
            destino = "WEB-INF/jsp/usuario.jsp";
        } else if (acao.equalsIgnoreCase("novo")) {
            System.out.println("UsuarioLogica=novo");
            destino = "WEB-INF/jsp/usuario.jsp";

        } else if (acao.equalsIgnoreCase("cadastrar")) {
            System.out.println("UsuarioLogica=cadastrar");
            destino = "/mvc?logica=UsuarioLogica&acao=listar";
            Usuario usuario = new Usuario();

            usuario.setLogin(req.getParameter("usuarioLogin"));
            usuario.setSenha(req.getParameter("usuarioSenha"));
            usuario.setAtivo(req.getParameter("usuarioAtivo") != null);

            String usuarioId = req.getParameter("usuarioId");

            if (usuarioId == null || usuarioId.isEmpty()) {
                dao.adicionarUsuario(usuario);
                System.out.println("Novo usuario");
            } else {
                usuario.setId(Integer.parseInt(usuarioId));
                dao.atualizarUsuario(usuario);
                System.out.println("usuario alterado");
            }
        } else if (acao.equalsIgnoreCase("apagar")) {
            System.out.println("UsuarioLogica=apagar");
            destino = "/mvc?logica=UsuarioLogica&acao=listar";
            
            int usuarioId = Integer.parseInt(req.getParameter("usuarioId"));
            dao.removerUsuario(usuarioId);
                    
        }
        System.out.println(destino);
        return destino;
    }
}
