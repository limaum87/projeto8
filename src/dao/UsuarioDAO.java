package dao;

import factory.ConnectionFactory;
import gui.componentes.Dialogos;
import gui.home;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.Usuario;

public class UsuarioDAO {
    private Connection connection;
    Long id;
    String nome;
    String sobrenome;
    String cpf;
    String rua;
    Long numero;
    Long complemento;
    Long telefone;
    Long telefone2;
    String email;
    ResultSet resultado;
    ResultSet resultado2;
    ResultSet resultado3;
    ResultSet rs;
    ResultSet idusuario;
    Dialogos d = new Dialogos();
    
    public UsuarioDAO(){
        this.connection = new ConnectionFactory().getConnection();
    }
    public void adiciona(Usuario usuario){
        String sql = "INSERT INTO usuario(nome,cpf,rua, numero, complemento, telefone,email,telefone2,bairro,senha,id_grupo) VALUES(?,?,?,?,?,?,?,?,?,?,1)";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getCpf());
            stmt.setString(3, usuario.getRua());
            stmt.setString(4, usuario.getNumero());
            stmt.setString(5, usuario.getComplemento());
            stmt.setString(6, usuario.getTelefone());
            stmt.setString(7, usuario.getEmail());
            stmt.setString(8, usuario.getTelefone2());
            stmt.setString(9, usuario.getBairro());
            stmt.setString(10, usuario.getSenha());
            stmt.execute();
            stmt.close();
        } catch (SQLException u) {
            d.MensagemErro(1,u);
            throw new RuntimeException(u);
        }
    }
    public ResultSet ConsultarUsuario(){
        try { 
               Statement stmt = connection.createStatement();
               String sql = "select nome from usuario ";
               resultado = stmt.executeQuery(sql);
               connection.close();
           } catch (Exception u) {    
               d.MensagemErro(1,u);
               System.out.println(" Erro ao consultar usuario: "+u);      
           }        return resultado;  
    }  
    public ResultSet ConsultaEmail(Usuario usuario){
        String sql = "SELECT usuario.nome FROM public.usuario where usuario.email= ? ";
        try {  
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, usuario.getEmail());
            stmt.execute();
            resultado = stmt.executeQuery();
            connection.close();
        } catch (Exception u) {    
            d.MensagemErro(1,u);
            System.out.println(" Erro ao consultar usuario: "+u);      
        }        return resultado;          
    }
    public ResultSet RetornaDados(Usuario usuario){
        String sql = "SELECT usuario.id_nome, usuario.nome, usuario.cpf, usuario.telefone, usuario.rua, usuario.numero, usuario.telefone2, usuario.bairro, usuario.complemento, usuario.email FROM public.usuario WHERE usuario.nome = ?;";
        try { 
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, usuario.getNome());
            stmt.execute();
            resultado = stmt.executeQuery(); 
            connection.close();
        } catch (Exception u) {    
            d.MensagemErro(1,u);
               System.out.println(" Erro ao consultar usuario: "+u);      
           }        return resultado;       
    }
    public void altera(Usuario usuario){
           String sql = "UPDATE usuario set (nome,sobrenome,cpf,rua, numero, complemento, telefone,email,telefone2,bairro) = (?,?,?,?,?,?,?,?,?,?) where id_nome = ? ";
           try {
               PreparedStatement stmt = connection.prepareStatement(sql);
               stmt.setString(1, usuario.getNome());
               stmt.setString(2, usuario.getSobrenome());
               stmt.setString(3, usuario.getCpf());
               stmt.setString(4, usuario.getRua());
               stmt.setString(5, usuario.getNumero());
               stmt.setString(6, usuario.getComplemento());
               stmt.setString(7, usuario.getTelefone());
               stmt.setString(8, usuario.getEmail());
               stmt.setString(9, usuario.getTelefone2());
               stmt.setString(10, usuario.getBairro());
               stmt.setLong(11, usuario.getId());
               stmt.execute();
               stmt.close();
           } catch (SQLException u) {
               d.MensagemErro(1,u);
               throw new RuntimeException(u);
           }
           }
    public Boolean login(Usuario usuario){  
               boolean existe = false;  
               String sql = "SELECT * FROM usuario WHERE email = ? AND senha = ?";
               try{
                   PreparedStatement stmt = connection.prepareStatement(sql);
                   stmt.setString(1, usuario.getEmail());  
                   stmt.setString(2, usuario.getSenha()); 
                   stmt.execute();
                   rs = stmt.executeQuery();  
                   connection.close();
               } catch (Exception u) {   
                   d.MensagemErro(1,u);
                   System.out.println(" Erro ao consultar usuario: "+u);      
               }        
               try {
                   if(rs.next()){
                       existe = true;
                       return(existe);
                   }
                   else {
                       JOptionPane.showMessageDialog(null, "Usuario ou senha incorreto"); 
                   }
               } catch (SQLException u) {
                   d.MensagemErro(1,u);
                   System.out.println(" Erro ao validar usuario: ");
                   
               }
               return(existe);
           } 
    public Long ConsultaId(Usuario usuario){
        Long idf= null;
        String sql = "SELECT usuario.id_nome FROM public.usuario where usuario.email= ? ";
        try {  
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, usuario.getEmail());
            stmt.execute();
            resultado3 = stmt.executeQuery();
            connection.close();
        } catch (Exception u) {    
            d.MensagemErro(1,u);
            System.out.println(" Erro ao consultar usuario: "+u);      
        }
        try {
            resultado3.next();
            idf= Long.parseLong(resultado3.getString(1));
        } catch (SQLException u) {
            d.MensagemErro(1,u);
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, u);
        }
        return idf;          
    }
    public Long ConsultaPermissao(Usuario usuario){
        Long idf= null;
        String sql = "SELECT usuario.id_grupo FROM public.usuario where usuario.email= ? ";
        try {  
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, usuario.getEmail());
            stmt.execute();
            resultado3 = stmt.executeQuery();
            connection.close();
        } catch (Exception u) {    
            d.MensagemErro(1,u);
            System.out.println(" Erro ao consultar usuario: "+u);      
        }
        try {
            resultado3.next();
            idf= Long.parseLong(resultado3.getString(1));
        } catch (SQLException u) {
            d.MensagemErro(1,u);
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, u);
        }
        return idf;          
    }
    
}