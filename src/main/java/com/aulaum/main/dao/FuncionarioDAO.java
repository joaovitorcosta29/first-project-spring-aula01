/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aulaum.main.dao;
import com.aulaum.main.model.FuncionarioBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Aluno
 */
public class FuncionarioDAO {
    public List<FuncionarioBean> listarFuncionarios(){
        List<FuncionarioBean> lista = new ArrayList();
        try{
            Connection conn = Conexao.conectar();
            PreparedStatement stmt = null; //caminho pro banco de dados
            ResultSet rs = null; //retorno do banco de dados
            
            stmt = conn.prepareStatement("SELECT * FROM funcionario");
            rs = stmt.executeQuery();
            
            while(rs.next()){
                FuncionarioBean funcionario = new FuncionarioBean();
                funcionario.setId(rs.getInt("id"));
                funcionario.setNome(rs.getString("nome"));
                funcionario.setCargo(rs.getString("cargo"));
                funcionario.setDepartamento(rs.getString("departamento"));
                funcionario.setEmail(rs.getString("email"));
                funcionario.setDataContratacao(rs.getDate("data_contratacao"));
                
                lista.add(funcionario);
            }
            
        }catch(SQLException e){
            e.printStackTrace();
        }
        return lista;
    }
    public int totalFuncionarios(){
        int total = 0;
        try{
            Connection conn = Conexao.conectar();
            PreparedStatement stmt = null;
            ResultSet rs = null;
            
            stmt = conn.prepareStatement("SELECT COUNT(*) as total FROM funcionario");
            rs = stmt.executeQuery();
            
            if(rs.next()){
            total = rs.getInt("total");
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return total;
    }
    public List<FuncionarioBean> tecnologia(){
        List<FuncionarioBean> listaFiltrada = new ArrayList();
        try{
            Connection conn = Conexao.conectar();
            PreparedStatement stmt = null; //caminho pro banco de dados
            ResultSet rs = null; //retorno do banco de dados
            
            stmt = conn.prepareStatement("SELECT * FROM funcionario WHERE departamento = 'Tecnologia'");
            rs = stmt.executeQuery();
            
            while(rs.next()){
                FuncionarioBean funcionarioFiltrado = new FuncionarioBean();
                funcionarioFiltrado.setId(rs.getInt("id"));
                funcionarioFiltrado.setNome(rs.getString("nome"));
                funcionarioFiltrado.setDepartamento(rs.getString("departamento"));
                listaFiltrada.add(funcionarioFiltrado);
            }
            
        }catch(SQLException e){
            e.printStackTrace();
        }
        return listaFiltrada;
     
    }
}
