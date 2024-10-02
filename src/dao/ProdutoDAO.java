package dao;


import beans.cadastro;
import Conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;


/**
 *
 * @author fabio.nmoura
 */
public class ProdutoDAO {
      private Conexao conexao;
    private Connection conn;
    
    public ProdutoDAO(){
        this.conexao = new Conexao();
        this.conn = this.conexao.getConexao();
    }
    public void inserir (cadastro cadastro){
        String sql = "INSERT INTO energia (data,qtde,capacidade, nome) VALUES (?,?,?,?)";
        try{
            
         PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setString(1, cadastro.getData());
           stmt.setInt(2, cadastro.getqtde());
           stmt.setInt(3, cadastro.getcapacidade());
            stmt.setString(4, cadastro.getnome());
            stmt.execute();
        
        }catch(Exception e){
            System.out.println("Erro ao inserir cadastro: "+ e.getMessage());
        }
    }
    public void alterar(cadastro cadastro){
String sql = "UPDATE produto SET descricao=?, qtde=?, preco=? WHERE id =?";
    try{
        PreparedStatement stmt = this.conn.prepareStatement(sql);
        stmt.setString(1, cadastro.getnome());
        stmt.setInt(2, cadastro.getqtde());
       stmt.setInt(3, cadastro.getcapacidade());
        stmt.execute();
    }catch (Exception e){
        System.out.println("Erro ao atualizar produto: "+ e.getMessage());
    }
    }
    public void excluir(int id){
        String sql = "DELETE FROM teladelogin WHERE id = ?";
        try{
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setInt(1,id);
            stmt.execute();
        }catch(Exception e){
            System.out.println("Erro ao excluir produto: "+ e.getMessage());
        }}
    public cadastro getProduto(String nome){
        String sql = "SELECT * FROM energia WHERE nome =?";
        
        try{
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setString(1, nome);
            ResultSet rs = stmt.executeQuery();
            cadastro produto = new cadastro ();
            rs.next();
            
            produto.setData(rs.getString("data"));
               produto.setnome(rs.getString("nome"));
            produto.setqtde(rs.getInt("qtde"));
        
            return produto;
        }catch(Exception e){
            System.out.println("Erro ao atualizar produto: "+ e.getMessage());
            return null;
        }}
    public List<cadastro> getcadastro(){
        String sql = "SELECT * FROM energia";
        try{
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            List<cadastro> listacadastro = new ArrayList<>();
            while(rs.next()){
                cadastro p = new cadastro();
                p.setData(rs.getString("data"));
                p.setqtde(rs.getInt("qtde"));
                p.setcapacidade(rs.getInt("capacidade"));
                p.setnome(rs.getString("nome"));
                listacadastro.add(p);
            }
            return listacadastro;
        }catch (Exception e){
            return null;
        }
    }
}
