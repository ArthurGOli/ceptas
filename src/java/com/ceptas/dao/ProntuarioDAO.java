/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ceptas.dao;

import com.ceptas.model.Grafico;
import com.ceptas.model.Prontuario;
import com.ceptas.util.Conexao;
import java.sql.Connection;
import java.sql.Date;
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
public class ProntuarioDAO {

    static Connection conn;

    public ProntuarioDAO() {
        conn = Conexao.getConnection();
    }

    public void adicionarProntuario(Prontuario prontuario) {
        try {
            String query = "INSERT INTO PRO_PRONTUARIO (ani_id, pro_dtEntrada, pro_apreensao, pro_localizacao, pro_diagnostico, pro_descProcedimento, pro_dtSaida) VALUES (?,?,?,?,?,?,?)";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setInt(1, prontuario.getAnimal().getId());
            if(prontuario.getDtEntrada().isEmpty())
                preparedStatement.setNull(2, java.sql.Types.INTEGER);
            else               
                preparedStatement.setString(2, prontuario.getDtEntrada());
            preparedStatement.setString(3, prontuario.getApreensao());
            preparedStatement.setString(4, prontuario.getLocalizacao());
            preparedStatement.setString(5, prontuario.getDiagnostico());
            preparedStatement.setString(6, prontuario.getDescProcedimento());
            if(prontuario.getDtSaida().isEmpty())
                preparedStatement.setNull(7, java.sql.Types.INTEGER);
            else
                preparedStatement.setString(7, (prontuario.getDtSaida()));
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removerProntuario(int prontuarioId) {
        try {
            String query = "DELETE FROM PRO_PRONTUARIO WHERE pro_id=?";
            PreparedStatement preparedStatement = conn.prepareCall(query);
            preparedStatement.setInt(1, prontuarioId);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void atualizarProntuario(Prontuario prontuario) {
        try {
            //String query = "UPDATE PRO_PRONTUARIO SET ani_id=?, pro_dtEntrada=?, pro_apreensao=?, pro_localizacao=?, pro_diagnostico=?, pro_descProcedimento=?, pro_dtSaida=? WHERE pro_id=?";
            String query = "UPDATE PRO_PRONTUARIO SET ani_id=?, pro_dtEntrada=?, pro_apreensao=?, pro_localizacao=?, pro_diagnostico=?, pro_descProcedimento=?, pro_dtSaida=? WHERE pro_id=?";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setInt(1, prontuario.getAnimal().getId());
            if(prontuario.getDtEntrada().isEmpty())
                preparedStatement.setNull(2, java.sql.Types.INTEGER);
            else               
                preparedStatement.setString(2, prontuario.getDtEntrada());
            preparedStatement.setString(3, prontuario.getApreensao());
            preparedStatement.setString(4, prontuario.getLocalizacao());
            preparedStatement.setString(5, prontuario.getDiagnostico());
            preparedStatement.setString(6, prontuario.getDescProcedimento());
            if(prontuario.getDtSaida().isEmpty())
                preparedStatement.setNull(7, java.sql.Types.INTEGER);
            else
                preparedStatement.setString(7, (prontuario.getDtSaida()));
            preparedStatement.setInt(8, prontuario.getId());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Prontuario> getAllProntuarios() {
        List<Prontuario> prontuarios = new ArrayList<Prontuario>();
        try {
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM PRO_PRONTUARIO");
            while (resultSet.next()) {
                Prontuario prontuario = new Prontuario();
                prontuario.setId(resultSet.getInt("pro_id"));
                prontuario.setAnimal(new AnimalDAO().getAnimalById(resultSet.getInt("ani_id")));
                prontuario.setDtEntrada(resultSet.getString("pro_dtEntrada"));
                prontuario.setApreensao(resultSet.getString("pro_apreensao"));
                prontuario.setLocalizacao(resultSet.getString("pro_localizacao"));
                prontuario.setDiagnostico(resultSet.getString("pro_diagnostico"));
                prontuario.setDescProcedimento(resultSet.getString("pro_descProcedimento"));
                prontuario.setDtSaida(resultSet.getString("pro_dtSaida"));
                prontuarios.add(prontuario);
            }
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return prontuarios;
    }

    public Prontuario getProntuarioById(int prontuarioId) {
        Prontuario prontuario = new Prontuario();
        try {
            String query = "SELECT * FROM pro_prontuario WHERE pro_id=?";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setInt(1, prontuarioId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                prontuario.setId(resultSet.getInt("pro_id"));
                prontuario.setAnimal(new AnimalDAO().getAnimalById(resultSet.getInt("ani_id")));
                prontuario.setDtEntrada(resultSet.getString("pro_dtEntrada"));
                prontuario.setApreensao(resultSet.getString("pro_apreensao"));
                prontuario.setLocalizacao(resultSet.getString("pro_localizacao"));
                prontuario.setDiagnostico(resultSet.getString("pro_diagnostico"));
                prontuario.setDescProcedimento(resultSet.getString("pro_descProcedimento"));
                prontuario.setDtSaida(resultSet.getString("pro_dtSaida"));
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return prontuario;
    }

    public List<Prontuario> getProntuariosPendente() {
        List<Prontuario> prontuarios = new ArrayList<Prontuario>();
        try {
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM PRO_PRONTUARIO WHERE pro_dtSaida IS NULL");
            while (resultSet.next()) {
                Prontuario prontuario = new Prontuario();
                prontuario.setId(resultSet.getInt("pro_id"));
                prontuario.setAnimal(new AnimalDAO().getAnimalById(resultSet.getInt("ani_id")));
                prontuario.setDtEntrada(resultSet.getString("pro_dtEntrada"));
                prontuario.setApreensao(resultSet.getString("pro_apreensao"));
                prontuario.setLocalizacao(resultSet.getString("pro_localizacao"));
                prontuario.setDiagnostico(resultSet.getString("pro_diagnostico"));
                prontuario.setDescProcedimento(resultSet.getString("pro_descProcedimento"));
                prontuario.setDtSaida(resultSet.getString("pro_dtSaida"));
                prontuarios.add(prontuario);
            }
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return prontuarios;
    }
    
    public List<Grafico> getProntuarioPeriodo(String dataInicio, String dataFim) {
        List<Grafico> graficos = new ArrayList<Grafico>();
        try {
            String query = "SELECT COUNT(pro_id) as qtd_prontuario, pro_apreensao\n" +
                           "FROM `pro_prontuario` \n" +
                           "WHERE pro_dtEntrada >= ? AND pro_dtEntrada <= ?\n" +
                           "GROUP BY pro_apreensao\n" +
                           "ORDER BY pro_apreensao ASC";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, dataInicio);
            preparedStatement.setString(2, dataFim);
            System.out.println(preparedStatement.toString());
            ResultSet resultSet = preparedStatement.executeQuery();
            
            while (resultSet.next()) {
                Grafico grafico = new Grafico();
                grafico.setQuantidade(resultSet.getString("qtd_prontuario"));
                grafico.setTipo(resultSet.getString("pro_apreensao"));
                graficos.add(grafico);
                        
                
                /*
                Prontuario prontuario = new Prontuario();
                prontuario.setId(resultSet.getInt("pro_id"));
                prontuario.setAnimal(new AnimalDAO().getAnimalById(resultSet.getInt("ani_id")));
                prontuario.setDtEntrada(resultSet.getString("pro_dtEntrada"));
                prontuario.setApreensao(resultSet.getString("pro_apreensao"));
                prontuario.setLocalizacao(resultSet.getString("pro_localizacao"));
                prontuario.setDiagnostico(resultSet.getString("pro_diagnostico"));
                prontuario.setDescProcedimento(resultSet.getString("pro_descProcedimento"));
                prontuario.setDtSaida(resultSet.getString("pro_dtSaida"));
                prontuarios.add(prontuario);
                */
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return graficos;
    }
}

