/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import Conexao.Conexao;
import beans.cadastro;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author cmoura
 */
public class loginDAO {
    private Conexao conexao;
    private Connection conn;
    
    public loginDAO(){
        this.conexao = new Conexao();
        this.conn = this.conexao.getConexao();
    }public void inserir (cadastro cadastro){
        String sql = "INSERT INTO teladelogin (login, senha) VALUES (?,?)";
        try{
            
     
            PreparedStatement stmt = this.conn.prepareStatement(sql);
             stmt.setString(1, cadastro.getlogin());
            stmt.setString(2, cadastro.getsenha());
            stmt.execute();
        
        }catch(Exception e){
            System.out.println("Erro ao inserir cadastro: "+ e.getMessage());
        }
    }public void excluir (int id){
        String sql = "DELECT FROM teladelogin (WHERE id=?";
        try{
            
     
            PreparedStatement stmt = this.conn.prepareStatement(sql);
           stmt.setInt(1,id);
            
            stmt.execute();
        
        }catch(Exception e){
            System.out.println("Erro ao excluir cadastro: "+ e.getMessage());
        }}
     public List<cadastro> getcadastro(){
        String sql = "SELECT * FROM teladelogin";
        try{
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            List<cadastro> listacadastro = new ArrayList<>();
            while(rs.next()){
                cadastro p = new cadastro();
                p.setlogin(rs.getString("login"));
                p.setsenha(rs.getString("senha"));
                p.setId(rs.getInt("id"));
                listacadastro.add(p);
            }
            return listacadastro;
        }catch (Exception e){
            return null;
}
     }}
