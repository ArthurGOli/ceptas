/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ceptas.dao;

import com.ceptas.model.Usuario;
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
public class UsuarioDAO {

    static Connection conn;

    public UsuarioDAO() {

        conn = Conexao.getConnection();

    }

    public void adicionarUsuario(Usuario usuario) {
        try {
            String query = "INSERT INTO USU_USUARIO (usu_login, usu_senha, usu_ativo) VALUES (?,?,?)";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, usuario.getLogin());
            preparedStatement.setString(2, usuario.getSenha());
            preparedStatement.setBoolean(3, usuario.isAtivo());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removerUsuario(int usuarioId) {
        try {
            String query = "DELETE FROM USU_USUARIO WHERE usu_id=?";
            PreparedStatement preparedStatement = conn.prepareCall(query);
            preparedStatement.setInt(1, usuarioId);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void atualizarUsuario(Usuario usuario) {
        try {
            String query = "UPDATE USU_USUARIO SET usu_login=?, usu_senha=?, usu_ativo=? WHERE usu_id=?";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, usuario.getLogin());
            preparedStatement.setString(2, usuario.getSenha());
            preparedStatement.setBoolean(3, usuario.isAtivo());
            preparedStatement.setInt(4, usuario.getId());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Usuario> getAllUsuarios() {
        List<Usuario> usuarios = new ArrayList<Usuario>();
        try {
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM USU_USUARIO");
            while (resultSet.next()) {
                Usuario usuario = new Usuario();
                usuario.setId(resultSet.getInt("usu_id"));
                usuario.setLogin(resultSet.getString("usu_login"));
                usuario.setSenha(resultSet.getString("usu_senha"));
                usuario.setAtivo(resultSet.getBoolean("usu_ativo"));
                usuarios.add(usuario);
            }
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usuarios;
    }

    public Usuario getUsuarioById(int usuarioId) {
        Usuario usuario = new Usuario();
        try {
            String query = "SELECT * FROM USU_USUARIO WHERE usu_id=?";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setInt(1, usuarioId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                usuario.setId(resultSet.getInt("usu_id"));
                usuario.setLogin(resultSet.getString("usu_login"));
                usuario.setSenha(resultSet.getString("usu_senha"));
                usuario.setAtivo(resultSet.getBoolean("usu_ativo"));
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usuario;
    }

    /* Foi inserido retorno com Lista 27/05/2017
	public Usuario getUsuarioByLogin(String usuarioLogin) {
        Usuario usuario = new Usuario();
        try {
            String query = "SELECT * FROM USU_USUARIO WHERE usu_login=?";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, usuarioLogin);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                usuario.setId(resultSet.getInt("usu_id"));
                usuario.setLogin(resultSet.getString("usu_login"));
                usuario.setSenha(resultSet.getString("usu_senha"));
                usuario.setFunId(resultSet.getInt("fun_id"));
                usuario.setAtivo(resultSet.getBoolean("usu_ativo"));
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usuario;
    }*/
    public List<Usuario> getUsuarioByLogin(String usuarioLogin) {
        
        List<Usuario> usuarios = new ArrayList<Usuario>();
        String query = "";
        try {
            Statement statement = conn.createStatement();
            query = "SELECT * FROM USU_USUARIO WHERE usu_login LIKE '%"+usuarioLogin+"%'";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                Usuario usuario = new Usuario();
                usuario.setId(resultSet.getInt("usu_id"));
                usuario.setLogin(resultSet.getString("usu_login"));
                usuario.setSenha(resultSet.getString("usu_senha"));
                
                usuarios.add(usuario);
            }
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return usuarios;
    }
    
    
    
    public Usuario validarLogin(String usuarioLogin, String usuarioSenha) {
        Usuario usuario = new Usuario();
        try {
            String query = "SELECT * FROM USU_USUARIO WHERE usu_login=? AND usu_senha=? AND usu_ativo=1";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, usuarioLogin);
            preparedStatement.setString(2, usuarioSenha);
            ResultSet resultSet = preparedStatement.executeQuery();
            boolean more = resultSet.next();

            if (!more) {
            } else if (more) {
                usuario.setId(resultSet.getInt("usu_id"));
                usuario.setLogin(resultSet.getString("usu_login"));
                usuario.setSenha(resultSet.getString("usu_senha"));
                usuario.setAtivo(resultSet.getBoolean("usu_ativo"));
            }
            resultSet.close();

            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usuario;
    }
}
