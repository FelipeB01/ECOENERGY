
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
public class funcionarioDAO {
   private Conexao conexao;
    private Connection conn;
    
    public funcionarioDAO(){
        this.conexao = new Conexao();
        this.conn = this.conexao.getConexao();  
}
    public void inserir (cadastro cadastro){
        String sql = "INSERT INTO funcionario (funcionarios, senhafun) VALUES (?,?)";
        try{
            
     
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setString(1, cadastro.getFuncionarios());
            stmt.setString(2, cadastro.getSenhafun());
            stmt.execute();
        
        }catch(Exception e){
            System.out.println("Erro ao inserir cadastro: "+ e.getMessage());
        }
}public List<cadastro> getcadastro(){
        String sql = "SELECT * FROM funcionario";
        try{
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            List<cadastro> listacadastro = new ArrayList<>();
            while(rs.next()){
                cadastro p = new cadastro();
                p.setFuncionarios(rs.getString("funcionarios"));
                p.setSenhafun(rs.getString("senhafun"));
                listacadastro.add(p);
            }
            return listacadastro;
        }catch (Exception e){
            return null;
}}}