package br.com.hotel;

import br.com.hotel.Pessoa;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

public class Hospede {

    
    ResultSet rs = null;
    String sql = "SELECT *FROM hospede";



    public void create(Pessoa p){

        Connection conexao = ModuloConexao.conector();
        PreparedStatement stmt = null;

        try {
            stmt = conexao.prepareStatement(
                "INSERT INTO hospede (nome,telefone,cpf)VALUES(?,?,?)");
            stmt.setString(1, p.getNome());
            stmt.setString(2, p.getTelefone());
            stmt.setString(3, p.getCpf());
            
            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null,"Salvo com sucesso");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao cadastrar");
        }finally{
           ModuloConexao.closeConector(conexao, stmt);
    }
}
    
    public List<Pessoa> read(){
        Connection conexao = ModuloConexao.conector();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        
        List<Pessoa> pessoas = new ArrayList<>();
        
        try {
            stmt = conexao.prepareStatement("SELECT * FROM hospede;",Statement.RETURN_GENERATED_KEYS);
            
            rs = stmt.executeQuery();
            
            while(rs.next()){
                Pessoa pessoa = new Pessoa();
               // pessoa.gerar_Id();
                pessoa.setNome(rs.getString("nome"));
                pessoa.setTelefone(rs.getString("telefone"));
                pessoa.setCpf(rs.getString("cpf"));
                
                
                pessoas.add(pessoa);
            }
                    
                    } catch (SQLException ex) {
            Logger.getLogger(Hospede.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ModuloConexao.closeConector(conexao, stmt, rs);
        }
        return pessoas;
        
    }
    public void Delete(Pessoa p){
        Connection conexao = ModuloConexao.conector();
        PreparedStatement stmt = null;
        try {
            stmt = conexao.prepareStatement(
                "DELETE FROM hospede WHERE nomw=?");
            stmt.setString(1, p.getNome());
            
            
            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null,"Deletado com sucesso");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao Deletar");
        }finally{
           ModuloConexao.closeConector(conexao, stmt);
    }
        
    }
    
    

    
        
        

}
