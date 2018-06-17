/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ceptas.logica;

import com.ceptas.dao.AnimalDAO;
import com.ceptas.model.Animal;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author DESENV
 */
public class AnimalLogica implements Logica{
    
    private AnimalDAO dao;
    
    public AnimalLogica(){
        dao = new AnimalDAO();
    }
    
    public String executa(HttpServletRequest req, HttpServletResponse res)
            throws Exception {
         
        String destino = "WEB-INF/jsp/animal.jsp";
        String acao = req.getParameter("acao");
        
        System.out.println("AnimalLogica");
        
        if (acao.equalsIgnoreCase("buscar")) {
            
            System.out.println("AnimalLogica=buscar");
            List<Animal> animais = new AnimalDAO().getAnimalByMarcacao(req.getParameter("animalMarcacao"));

            req.setAttribute("animais", animais);

            destino = "/WEB-INF/jsp/listaAnimal.jsp";
        } else if (acao.equalsIgnoreCase("listar")) {
            List<Animal> animais = new AnimalDAO().getAllAnimais();

            req.setAttribute("animais", animais);

            destino = "/WEB-INF/jsp/listaAnimal.jsp";
        } else if (acao.equalsIgnoreCase("editar")) {
            int animalId = Integer.parseInt(req.getParameter("animalId"));
            Animal animal = dao.getAnimalById(animalId);
            req.setAttribute("animal", animal);
            destino = "WEB-INF/jsp/animal.jsp";
        } else if (acao.equalsIgnoreCase("novo")) {
            
            destino = "WEB-INF/jsp/animal.jsp";
            
        } else if (acao.equalsIgnoreCase("cadastrar")) {
            
            destino ="/mvc?logica=AnimalLogica&acao=listar";
            Animal animal = new Animal();
            
            animal.setEspecie(req.getParameter("animalEspecie"));
            animal.setNomePopular(req.getParameter("animalNomePopular"));
            animal.setGrupoTaxonomico(req.getParameter("animalGrupoTaxonomico"));
            animal.setSexo(req.getParameter("animalSexo"));
            animal.setIdade(req.getParameter("animalIdade"));
            animal.setMarcacao(req.getParameter("animalMarcacao"));

            String animalId = req.getParameter("animalId");
            
            if (animalId == null || animalId.isEmpty()) {
                dao.adicionarAnimal(animal);
            } else {
                animal.setId(Integer.parseInt(animalId));
                dao.atualizarAnimal(animal);
            }
        }

        return destino;
         
     }

    
}
