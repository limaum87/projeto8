package dao;

import factory.ConnectionFactory;
import gui.componentes.Dialogos;
import java.sql.*;
import modelo.Empresa;


public class EmpresaDAO {
    private Connection connection;
    Long id_empresa;
    String nome_empresa;
    Long razaosocial;
    Long cnpj;
    Long inscricao_estadual;
    String rua;
    Long numero;
    Long complemento;
    String bairro;
    String cidade;
    String estado;
    String email;
    String telefone;
    String telefone2;
    ResultSet resultado;
    ResultSet agoravai;
    Dialogos d = new Dialogos();
    public EmpresaDAO(){
        this.connection = new ConnectionFactory().getConnection();
    }
    public void adiciona(Empresa empresa){
        String sql = "INSERT INTO empresa(nome_empresa,razaosocial,cnpj,inscricao_estadual,rua,numero,complemento,bairro,cidade,email,telefone,deslocamento,cep,estado) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, empresa.getNome_empresa());
            stmt.setString(2, empresa.getRazaosocial());
            stmt.setString(3, empresa.getCnpj());
            stmt.setString(4, empresa.getInscricao_estadual());
            stmt.setString(5, empresa.getRua());
            stmt.setString(6, empresa.getNumero());
            stmt.setString(7, empresa.getComplemento());
            stmt.setString(8, empresa.getBairro());
            stmt.setString(9, empresa.getCidade());
            stmt.setString(10, empresa.getEmail());
            stmt.setString(11, empresa.getTelefone());
            stmt.setString(12, empresa.getDeslocamento());
            stmt.setString(13, empresa.getCep());
            stmt.setString(14, empresa.getEstado());
            stmt.execute();
            stmt.close();
        } catch (Exception u) {
            d.MensagemErro(1,u);
            throw new RuntimeException();
        }
    }
    public ResultSet ConsultarEmpresa(){
        try { 
               Statement stmt = connection.createStatement();
               String sql = "select nome_empresa from empresa order by nome_empresa ASC ";
               resultado = stmt.executeQuery(sql);  
               connection.close();
               
           } catch (Exception u) {    
               d.MensagemErro(1,u);
               System.out.println(" Erro ao consultar empresa: "+u);  
           }        return resultado;          
       }  
       
       public ResultSet RetornaDados(Empresa empresa){
               String sql = "SELECT empresa.id_empresa, empresa.nome_empresa, empresa.razaosocial, empresa.cnpj, empresa.inscricao_estadual, empresa.rua, empresa.numero, empresa.complemento, empresa.bairro, empresa.cidade, empresa.telefone, empresa.email, empresa.deslocamento, empresa.cep FROM public.empresa where nome_empresa = ? ";
           try { 
                PreparedStatement stmt = connection.prepareStatement(sql);
                stmt.setString(1, empresa.getNome_empresa());
                stmt.execute();
               resultado = stmt.executeQuery();   
               connection.close();
               
           } catch (Exception u) {    
               d.MensagemErro(1,u);
               System.out.println(" Erro ao consultar dados da empresa: "+u);      
           }        return resultado;          
       }  
public void altera(Empresa empresa){
        String sql = "UPDATE empresa set (nome_empresa,razaosocial,cnpj,inscricao_estadual,rua,numero,complemento,bairro,cidade,email,telefone,deslocamento,cep,estado) = (?,?,?,?,?,?,?,?,?,?,?,?,?,?) where id_empresa = ? ";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, empresa.getNome_empresa());
            stmt.setString(2, empresa.getRazaosocial());
            stmt.setString(3, empresa.getCnpj());
            stmt.setString(4, empresa.getInscricao_estadual());
            stmt.setString(5, empresa.getRua());
            stmt.setString(6, empresa.getNumero());
            stmt.setString(7, empresa.getComplemento());
            stmt.setString(8, empresa.getBairro());
            stmt.setString(9, empresa.getCidade());
            stmt.setString(10, empresa.getEmail());
            stmt.setString(11, empresa.getTelefone());
            stmt.setString(12, empresa.getDeslocamento());
            stmt.setString(13, empresa.getCep());
            stmt.setString(14, empresa.getEstado());
            stmt.setLong(15, empresa.getId_empresa());
            stmt.execute();
            stmt.close();
        } catch (SQLException u) {
            d.MensagemErro(1,u);
            throw new RuntimeException(u);
        }
    }

    public void RemoveListaEtiqueta(Empresa empresaexcluida) {
         String sql = "UPDATE empresa set etiqueta = False where nome_empresa = ? ";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, empresaexcluida.getNome_empresa());
            stmt.execute();
            stmt.close();
        } catch (SQLException u) {
            d.MensagemErro(1,u);
            throw new RuntimeException(u);
        }
    }
  
}
    


