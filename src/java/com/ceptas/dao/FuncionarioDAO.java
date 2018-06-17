/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ceptas.dao;

import java.util.List;
import com.ceptas.model.Funcionario;
import com.ceptas.util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Statement;

/**
 *
 * @author DESENV
 */
public class FuncionarioDAO {

    private Connection conn;

    public FuncionarioDAO() {
        conn = Conexao.getConnection();
    }

    public void adicionarLocal(Funcionario funcionario) {
        try {
            String query = "insert into LOC_LOCAL (LOC_DESCRICAO, LOC_PUBLICO) values (?,?)";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, funcionario.getDescricao());
            preparedStatement.setString(2, funcionario.getPublico());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removerLocal(int localId) {
        try {
            String query = "delete from LOC_LOCAL where LOC_ID=?";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setInt(1, localId);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void atualizarLocal(Funcionario local) {
        try {
            String query = "update LOC_LOCAL set LOC_DESCRICAO=?, LOC_PUBLICO=? where LOC_ID=?";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, local.getDescricao());
            preparedStatement.setString(2, local.getPublico());
            preparedStatement.setInt(3, local.getId());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Funcionario> getAllLocais() {
        List<Funcionario> locais = new ArrayList<Funcionario>();
        try {
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from LOC_LOCAL");
            while (resultSet.next()) {
                Funcionario local = new Funcionario();
                local.setId(resultSet.getInt("LOC_ID"));
                local.setDescricao(resultSet.getString("LOC_DESCRICAO"));
                local.setPublico(resultSet.getString("LOC_PUBLICO"));
                locais.add(local);
            }
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return locais;
    }

    public Funcionario getLocalById(int localId) {
        Funcionario local = new Funcionario();
        try {
            String query = "select * from LOC_LOCAL where LOC_ID=?";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setInt(1, localId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                local.setId(resultSet.getInt("LOC_ID"));
                local.setDescricao(resultSet.getString("LOC_DESCRICAO"));
                local.setPublico(resultSet.getString("LOC_PUBLICO"));
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return local;
    }

}
