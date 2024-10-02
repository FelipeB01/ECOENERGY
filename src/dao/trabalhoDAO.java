
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
 * @author fabio.nmoura
 */
public class trabalhoDAO {
     private Conexao conexao;
    private Connection conn;
    
    public trabalhoDAO(){
        this.conexao = new Conexao();
        this.conn = this.conexao.getConexao();
    }public void inserir (cadastro cadastro){
        String sql = "INSERT INTO cep (nome, cep) VALUES (?,?)";
        try{
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setString(1, cadastro.getcliente());
            stmt.setInt(2, cadastro.getCEP());
            stmt.execute();
}catch(Exception e){
            System.out.println("Erro ao inserir cadastro: "+ e.getMessage());
        }}
 public List<cadastro> getcadastro(){
        String sql = "SELECT * FROM cep";
        try{
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            List<cadastro> listacadastro = new ArrayList<>();
            while(rs.next()){
                cadastro p = new cadastro();
                p.setcliente(rs.getString("nome"));
                p.setCEP(rs.getInt("cep"));
               
                listacadastro.add(p);
            }
            return listacadastro;
        }catch (Exception e){
            return null;
        }}}
