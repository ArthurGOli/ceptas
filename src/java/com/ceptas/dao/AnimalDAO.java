/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ceptas.dao;

import com.ceptas.model.Animal;
import com.ceptas.util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DESENV
 */
public class AnimalDAO {

    static Connection conn;

    public AnimalDAO() {

        conn = Conexao.getConnection();

    }

    public void adicionarAnimal(Animal animal) {
        try {
            String query = "INSERT INTO ANI_ANIMAL (ani_especie, ani_nomePopular, ani_grupoTaxonomico, ani_sexo, ani_idade, ani_marcacao) VALUES (?,?,?,?,?,?)";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, animal.getEspecie());
            preparedStatement.setString(2, animal.getNomePopular());
            preparedStatement.setString(3, animal.getGrupoTaxonomico());
            preparedStatement.setString(4, animal.getSexo());
            preparedStatement.setString(5, animal.getIdade());
            preparedStatement.setString(6, animal.getMarcacao());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removerAnimal(int animalId) {
        try {
            String query = "DELETE FROM ANI_ANIMAL WHERE usu_id=?";
            PreparedStatement preparedStatement = conn.prepareCall(query);
            preparedStatement.setInt(1, animalId);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void atualizarAnimal(Animal animal) {
        try {
            String query = "UPDATE ANI_ANIMAL SET ani_especie=?, ani_nomePopular=?, ani_grupoTaxonomico=?, ani_sexo=?, ani_idade=?, ani_marcacao=? WHERE ani_id=?";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, animal.getEspecie());
            preparedStatement.setString(2, animal.getNomePopular());
            preparedStatement.setString(3, animal.getGrupoTaxonomico());
            preparedStatement.setString(4, animal.getSexo());
            preparedStatement.setString(5, animal.getIdade());
            preparedStatement.setString(6, animal.getMarcacao());
            preparedStatement.setInt(7, animal.getId());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Animal> getAllAnimais() {
        List<Animal> animais = new ArrayList<Animal>();
        try {
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM ANI_ANIMAL");
            while (resultSet.next()) {
                Animal animal = new Animal();
                animal.setId(resultSet.getInt("ani_id"));
                animal.setEspecie(resultSet.getString("ani_especie"));
                animal.setNomePopular(resultSet.getString("ani_nomePopular"));
                animal.setGrupoTaxonomico(resultSet.getString("ani_grupoTaxonomico"));
                animal.setSexo(resultSet.getString("ani_sexo"));
                animal.setIdade(resultSet.getString("ani_idade"));
                animal.setMarcacao(resultSet.getString("ani_marcacao"));
                animais.add(animal);
            }
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return animais;
    }

    public Animal getAnimalById(int animalId) {
        Animal animal = new Animal();
        try {
            String query = "SELECT * FROM ANI_ANIMAL WHERE ani_id=?";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setInt(1, animalId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                animal.setId(resultSet.getInt("ani_id"));
                animal.setEspecie(resultSet.getString("ani_especie"));
                animal.setNomePopular(resultSet.getString("ani_nomePopular"));
                animal.setGrupoTaxonomico(resultSet.getString("ani_grupoTaxonomico"));
                animal.setSexo(resultSet.getString("ani_sexo"));
                animal.setIdade(resultSet.getString("ani_idade"));
                animal.setMarcacao(resultSet.getString("ani_marcacao"));
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return animal;
    }
    
    public List<Animal> getAnimalByMarcacao(String animalMarcacao) {
        
        List<Animal> animais = new ArrayList<Animal>();
        String query = "";
        try {
            Statement statement = conn.createStatement();
            query = "SELECT * FROM ANI_ANIMAL WHERE ani_marcacao LIKE '%"+animalMarcacao+"%'";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                Animal animal = new Animal();
                animal.setId(resultSet.getInt("ani_id"));
                animal.setEspecie(resultSet.getString("ani_especie"));
                animal.setNomePopular(resultSet.getString("ani_nomePopular"));
                animal.setGrupoTaxonomico(resultSet.getString("ani_grupoTaxonomico"));
                animal.setSexo(resultSet.getString("ani_sexo"));
                animal.setIdade(resultSet.getString("ani_idade"));
                animal.setMarcacao(resultSet.getString("ani_marcacao"));
                animais.add(animal);
            }
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Query= " + query);
        return animais;
    }
    
    public Animal getUnicoAnimalByMarcacao(String animalMarcacao) {
        
        String query = "";
        Animal animal = new Animal();
        try {
            Statement statement = conn.createStatement();
            query = "SELECT * FROM ANI_ANIMAL WHERE ani_marcacao = '"+animalMarcacao+"'";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                animal.setId(resultSet.getInt("ani_id"));
                animal.setEspecie(resultSet.getString("ani_especie"));
                animal.setNomePopular(resultSet.getString("ani_nomePopular"));
                animal.setGrupoTaxonomico(resultSet.getString("ani_grupoTaxonomico"));
                animal.setSexo(resultSet.getString("ani_sexo"));
                animal.setIdade(resultSet.getString("ani_idade"));
                animal.setMarcacao(resultSet.getString("ani_marcacao"));
            }
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Query= " + query);
        return animal;
    }

}
