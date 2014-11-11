package factory;

// faz as importações de classes necessárias para o funcionamento do programa
import gui.componentes.Dialogos;
import gui.login;
import java.sql.*; // classe para tratamento de exceções


public class ConnectionFactory {
    Dialogos d = new Dialogos();
    
    public Connection getConnection() {
        if (login.getBanco()==1){
            try {
                return DriverManager.getConnection("jdbc:postgresql://yoshi/seahawk","postgres","postgres");
            }
            catch(SQLException excecao) {
            d.MensagemErro(12);
            throw new RuntimeException(excecao);
        }
    }
        else{
            try {
                return DriverManager.getConnection("jdbc:postgresql://seahawk/projeto8","postgres","postgres");
            }
            catch(SQLException excecao) {
                throw new RuntimeException(excecao);
            }
        }
        
    }
        
}