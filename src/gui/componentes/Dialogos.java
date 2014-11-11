/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.componentes;

import gui.MostraErro;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

/**
 *
 * @author felipe
 */
public class Dialogos {
    
    
    public void MensagemErro(Integer i) {
        JOptionPane optionPane = new JOptionPane();
            JDialog dialog = optionPane.createDialog("Width 100");
            dialog = optionPane.createDialog(null,"Erro!");
            dialog.setSize(500,150);
            if (i==1){
                optionPane.setMessage("É preciso completar todos campos!");
            }
            if (i==2){
                optionPane.setMessage("É necessário ao menos 1 item!");
            }
            if (i==3){
                optionPane.setMessage("É necessário selecionar um tipo de atendimento e especificar o tempo");
            }
            if (i==4){
                optionPane.setMessage("Chamado finalizado com sucesso! ");
            }
            if (i==5){
                optionPane.setMessage("É necessário selecionar chamados ");
            }
            if (i==6){
                optionPane.setMessage("Você deve atribuir um nome ao fechamento ");
            }
            if (i==7){
                optionPane.setMessage("E necessário preencher todos campos!");
            }
            if (i==8){
                optionPane.setMessage("Não existe nenhuma OS para imprimir!");
            }
            if (i==9){
                optionPane.setMessage("É necessário selecionar a quantidade de parcelas");
            }
            if (i==10){
                optionPane.setMessage("É preciso especificar corretamente o meio de pagamento");
            }
            if (i==11){
                optionPane.setMessage("Sua versão do sistema está \n desatualizada. \n\n Entre em contato com o suporte. ");
            }
            if (i==12){
                optionPane.setMessage("Não foi possivel conectar ao banco de dados! ");
            }
            if (i==13){
                optionPane.setMessage("É necessario selecionar um item! ");
            }
            if (i==14){
                optionPane.setMessage("Acesso negado. ");
            }
           
            optionPane.setMessageType(JOptionPane.ERROR_MESSAGE);
            dialog.setAlwaysOnTop(true);
            dialog.setVisible(true);
    }
    public void MensagemSucesso(Integer i) {
        JOptionPane optionPane = new JOptionPane();
            JDialog dialog = optionPane.createDialog("Width 100");
            dialog = optionPane.createDialog(null,"Sucesso!");
            dialog.setSize(350,150);
            if (i==1){
                optionPane.setMessage("Chamado finalizado com sucesso!");
            }
            if (i==2){
                optionPane.setMessage("Chamado alterado com sucesso!");
            }
            if (i==3){
                optionPane.setMessage("Fechamento criado com sucesso! ");
            }      
            if (i==4){
                optionPane.setMessage("Empresa adicionada com sucesso! ");
            } 
            if (i==5){
                optionPane.setMessage("Empresa alterada com sucesso! ");
            } 
            if (i==6){
                optionPane.setMessage("Área adicionada com sucesso! ");
            } 
            if (i==7){
                optionPane.setMessage("Serviço adicionado com sucesso! ");
            } 
            if (i==8){
                optionPane.setMessage("Serviço removido com sucesso! ");
            }
            if (i==9){
                optionPane.setMessage("Mensalidade adicionado com sucesso! ");
            } 
            if (i==10){
                optionPane.setMessage("Mensalidade removida com sucesso! ");
            } 
            if (i==11){
                optionPane.setMessage("OS alterada com sucesso! ");
            } 
            if (i==12){
                optionPane.setMessage("Nota Fiscal gerada com sucesso! ");
            } 
            if (i==13){
                optionPane.setMessage("Usuario alterado com sucesso! ");
            } 
            if (i==14){
                optionPane.setMessage("Chamado encaminhado com sucesso! ");
            } 
            if (i==15){
                optionPane.setMessage("Fornecedor adicionado com sucesso! ");
            } 
            if (i==16){
                optionPane.setMessage("Ordem de Compra adicionada com sucesso! ");
            } 
            if (i==17){
                optionPane.setMessage("Fechamento finalizado! ");
            } 
            if (i==18){
                optionPane.setMessage("Fechamento removido! ");
            } 
            if (i==19){
                optionPane.setMessage("Fornecedor alterado! ");
            } 
            if (i==20){
                optionPane.setMessage("Item removido com sucesso! ");
            }
            if (i==21){
                optionPane.setMessage("Contrato adicionado com sucesso! ");
            }
            if (i==22){
                optionPane.setMessage("Pagamento baixado do sistema! ");
            }
            if (i==23){
                optionPane.setMessage("Pagamento adicionado no sistema! ");
            }
            if (i==24){
                optionPane.setMessage("Gerado arquivo nota! ");
            }
            if (i==25){
                optionPane.setMessage("Novo CFOP Adicionado! ");
            }
            optionPane.setMessageType(JOptionPane.INFORMATION_MESSAGE);
            dialog.setAlwaysOnTop(true);
            dialog.setVisible(true);
    }
    public void MensagemErro(Integer i, Exception u) {
        JOptionPane optionPane = new JOptionPane();
            JDialog dialog = optionPane.createDialog(null,"Erro!");
            dialog.setSize(550,550);
            
            new MostraErro(u).setVisible(true);
            
            if (i==1){
                optionPane.setMessage("Erro! : ");
                
            }
            optionPane.setMessageType(JOptionPane.ERROR_MESSAGE);
            dialog.setAlwaysOnTop(true);
            dialog.setVisible(false);
            
    }
    public void MensagemTeste(Integer i) {
        JOptionPane optionPane = new JOptionPane();
        JDialog dialog = optionPane.createDialog("Width 100");
        dialog = optionPane.createDialog(null,"Erro!");
        dialog.setSize(500,150);
        if (i==1){
            optionPane.setMessage("É preciso completar todos campos!");
        }
    }
    public void MensagemCuidado(Integer i) {
        JOptionPane optionPane = new JOptionPane();
            JDialog dialog = optionPane.createDialog("Width 100");
            
            dialog = optionPane.createDialog(null,"Cuidado!");
            dialog.setSize(500,150);
            if (i==1){
                optionPane.setMessage("Já existe uma Nota Fiscal dessa empresa!");
            }
            if (i==2){
                optionPane.setMessage("Os atendimentos já foram pagos!");
            }
            if (i==3){
                optionPane.setMessage("Existem Mensalidades nesse cliente!");
            }
            optionPane.setMessageType(JOptionPane.WARNING_MESSAGE);
            dialog.setAlwaysOnTop(true);
            dialog.setVisible(true);
    }
    public boolean MensagemCerteza() {
        JOptionPane optionPane = new JOptionPane();
   
        String[] choices= {"Sim","Não"};
        int response=optionPane.showOptionDialog(null, "Você tem certeza?", "Tem Certeza?", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, choices, choices[0]);
       
        
       if (response == 0){
           return true;
       }
       else if (response == 1){
           return false;
       }
        return false;
    }
    public boolean MensagemImprimir() {
        JOptionPane optionPane = new JOptionPane();
   
        String[] choices= {"Sim","Não"};
        int response=optionPane.showOptionDialog(null, "Você deseja imprimir a nota?", "Imprimir?", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, choices, choices[0]);
       
        
       if (response == 0){
           return true;
       }
       else if (response == 1){
           return false;
       }
        return false;
    }
}
