/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ceptas.model;

/**
 *
 * @author DESENV
 */
public class Prontuario {
    
    private int id;
    //private int animalId;    
    private Animal animal;
    private String dtEntrada;
    private String apreensao;    
    private String localizacao;
    private String diagnostico;
    private String descProcedimento;
    private String dtSaida;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }
    
    /*public int getAnimalId() {
        return animalId;
    }

    public void setAnimalId(int animalId) {
        this.animalId = animalId;
    }*/

    public String getDtEntrada() {
        return dtEntrada;
    }

    public void setDtEntrada(String dtEntrada) {
        this.dtEntrada = dtEntrada;
    }

    public String getApreensao() {
        return apreensao;
    }

    public void setApreensao(String apreensao) {
        this.apreensao = apreensao;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public String getDescProcedimento() {
        return descProcedimento;
    }

    public void setDescProcedimento(String descProcedimento) {
        this.descProcedimento = descProcedimento;
    }

    public String getDtSaida() {
        return dtSaida;
    }

    public void setDtSaida(String dtSaida) {
        this.dtSaida = dtSaida;
    }
    
}
