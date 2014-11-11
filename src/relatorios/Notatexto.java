/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package relatorios;

import dao.NotaFiscalDAO;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelo.Fechamento;
import modelo.NotaFiscal;

/**
 *
 * @author felipe
 */
public class Notatexto {
    ResultSet nota,parcelas,itens;
    
 public void GeraTXT (NotaFiscal nf){    
try {
            
            NotaFiscalDAO nfd = new NotaFiscalDAO();
            NotaFiscalDAO nfd2 = new NotaFiscalDAO();
            NotaFiscalDAO nfd3 = new NotaFiscalDAO();
            nota=nfd.DadosNota(nf);
            parcelas=nfd2.ParcelasNota(nf);
            itens=nfd3.ItensNota(nf);
            nota.next();
            itens.next();
            int[] par = new int[25];
            String[] parcela = new String[13];
            String[] vencimento = new String[13];
            parcelas.last();
            int total = parcelas.getRow();
            parcelas.beforeFirst();
            String[] espaco = new String[100];
             
            itens.last();
            int ttitens = itens.getRow();
            itens.beforeFirst();
            String [] codigo = new String[20];
            String [] descricao = new String[20];
            String [] quantidade = new String[20];
            String [] unitario = new String[20];
            String [] vltotal = new String [20];
            String [] simbolo = new String [20];
            String [] aliquota = new String [20];
            
            for (int a=1;a<20;a++){
                if (ttitens>=a){
                itens.next();
                codigo[a]=itens.getString(1);
                descricao[a]=itens.getString(2);
                quantidade[a]=itens.getString(3);
                unitario[a]=itens.getString(4);
                vltotal[a]=itens.getString(5);
                simbolo[a]="PC     ";
                aliquota[a]="0";

                }
                else{
                    itens.next();
                    codigo[a]=" ";
                    descricao[a]=" ";
                    quantidade[a]=" ";
                    unitario[a]=" ";
                    vltotal[a]=" ";
                    simbolo[a]=" ";
                    aliquota[a]=" ";
                    
                }
            }
                int c = 1;
                int d = 1;
             for (int b=1;b<19;b++){
                 
               
                 espaco[c]= new String(new char[12 -  codigo[d].length()]).replace('\0', ' ');
                 c++;
                
                 espaco[c]= new String(new char[60 -  descricao[d].length()]).replace('\0', ' ');
                 c++;
               
                 espaco[c]= new String(new char[13 -  quantidade[d].length()]).replace('\0', ' ');
                 c++;
               
                 espaco[c]= new String(new char[19 -  unitario[d].length()]).replace('\0', ' ');
                 c++;
    
                 espaco[c]= new String(new char[10 -  vltotal[d].length()]).replace('\0', ' ');
                 
                 c++;
                 d++;
             
                 
                 }
                 
            
            
            int teste = nota.getString(2).length();
            int res = 39 - teste;
            int es2 = 75 -nota.getString(10).length();
            int es3 = 33 - nota.getString(17).length();
            int es4 = 65 - (7 + nota.getString(11).length()+nota.getString(12).length()+nota.getString(13).length());
            int es5 = 24 - nota.getString(14).length();
            int es6 = 19 - nota.getString(18).length();
            int es7 = 38 - nota.getString(15).length();
            int es8 = 26 - nota.getString(16).length();
            int es9 = 11 -  nota.getString(19).length();
            int es10 = 33 -  nota.getString(20).length();
            int k = 1;
            int l = 1;
            int m = 1;
           
            for (int j=1;j<13;j++){
                if (total>=j){
                    parcelas.next();
                    if (k==7 || k== 14){
                        par[k]= 16 -  parcelas.getString(1).length();
                        k++;
                      
                    }else{
                    par[k]= 16 -  parcelas.getString(1).length();
                    k++;
                    par[k]= 14 -  parcelas.getString(2).length();
                    k++;
                    }
                    vencimento[l]  = parcelas.getString(1);
                    parcela[l]  = parcelas.getString(2);
                  
                    l++;
               
                   }
                else {
                 
                    vencimento[l]  = " ";
                    parcela[l]  = " ";
                    par[k]= 16 -  vencimento[l].length();
                    k++;
                    par[k]= 14 - parcela[l].length();
                    k++;
                    l++;
                    
                }
            }
            

            String space = new String(new char[res]).replace('\0', ' ');
            String space2 = new String(new char[es2]).replace('\0', ' ');
            String space3 = new String(new char[es3]).replace('\0', ' ');
            String space4 = new String(new char[es4]).replace('\0', ' ');
            String space5 = new String(new char[es5]).replace('\0', ' ');
            String space6 = new String(new char[es6]).replace('\0', ' ');
            String space7 = new String(new char[es7]).replace('\0', ' ');
            String space8 = new String(new char[es8]).replace('\0', ' ');
            String space9 = new String(new char[es9]).replace('\0', ' ');
            String space10 = new String(new char[es10]).replace('\0', ' ');
            String pres1 = new String(new char[par[1]]).replace('\0', ' ');
            String pres2 = new String(new char[par[2]]).replace('\0', ' ');
            String pres3 = new String(new char[par[3]]).replace('\0', ' ');
            String pres4 = new String(new char[par[4]]).replace('\0', ' ');
            String pres5 = new String(new char[par[5]]).replace('\0', ' ');
            String pres6 = new String(new char[par[6]]).replace('\0', ' ');
            String pres7 = new String(new char[par[7]]).replace('\0', ' ');
            String pres8 = new String(new char[par[8]]).replace('\0', ' ');
            String pres9 = new String(new char[par[9]]).replace('\0', ' ');
            String pres10 = new String(new char[par[10]]).replace('\0', ' ');
            String pres11 = new String(new char[par[11]]).replace('\0', ' ');
            String pres12 = new String(new char[par[12]]).replace('\0', ' ');
            String pres13 = new String(new char[par[13]]).replace('\0', ' ');
            String pres14 = new String(new char[par[14]]).replace('\0', ' ');
            String pres15 = new String(new char[par[15]]).replace('\0', ' ');
            String pres16 = new String(new char[par[16]]).replace('\0', ' ');
            String pres17 = new String(new char[par[17]]).replace('\0', ' ');
            String pres18 = new String(new char[par[18]]).replace('\0', ' ');
            String pres19 = new String(new char[par[19]]).replace('\0', ' ');
            String pres20 = new String(new char[par[20]]).replace('\0', ' ');
            String pres21 = new String(new char[par[21]]).replace('\0', ' ');
            
           
            
            String str = "0\n" +
"\n" +
"\n" +
"                                                                      X                                     "+nota.getString(1)+"\n" +
"\n" +
"\n" +
"\n" +
""+nota.getString(2)+space+nota.getString(3)+" \n" +
"\n" +
"\n" +
""+nota.getString(10)+space2+nota.getString(17)+space3+nota.getString(4)+"\n" +
"\n" +
"Rua "+nota.getString(11)+", "+nota.getString(12)+" "+nota.getString(13)+space4+nota.getString(14)+space5+nota.getString(18)+space6+nota.getString(5)+"\n" +
"\n" +
""+nota.getString(15)+space7+nota.getString(16)+space8+nota.getString(19)+space9+nota.getString(20)+space10+nota.getString(6)+"\n" +
"\n" +
"\n" +
" "+vencimento[1]+pres1+parcela[1]+pres2+vencimento[2]+pres3+parcela[2]+pres4+vencimento[3]+pres5+parcela[3]+pres6+vencimento[4]+pres7+parcela[4]+"\n" +
" "+vencimento[5]+pres8+parcela[5]+pres9+vencimento[6]+pres10+parcela[6]+pres11+vencimento[7]+pres12+parcela[7]+pres13+vencimento[8]+pres14+parcela[8]+"\n" +
" "+vencimento[9]+pres15+parcela[9]+pres16+vencimento[10]+pres17+parcela[10]+pres18+vencimento[11]+pres19+parcela[11]+pres20+vencimento[12]+pres21+parcela[12]+"\n" +
"\n" +
""+codigo[1]+espaco[1]+descricao[1]+espaco[2]+simbolo[1]+quantidade[1]+espaco[3]+unitario[1]+espaco[4]+vltotal[1]+espaco[5]+aliquota[1]+"\n" +
""+codigo[2]+espaco[6]+descricao[2]+espaco[7]+simbolo[2]+quantidade[2]+espaco[8]+unitario[2]+espaco[9]+vltotal[2]+espaco[10]+aliquota[2]+"\n" +
""+codigo[3]+espaco[11]+descricao[3]+espaco[12]+simbolo[3]+quantidade[3]+espaco[13]+unitario[3]+espaco[14]+vltotal[3]+espaco[15]+aliquota[3]+"\n" +
""+codigo[4]+espaco[16]+descricao[4]+espaco[17]+simbolo[4]+quantidade[4]+espaco[18]+unitario[4]+espaco[19]+vltotal[4]+espaco[20]+aliquota[4]+"\n" +
""+codigo[5]+espaco[21]+descricao[5]+espaco[22]+simbolo[5]+quantidade[5]+espaco[23]+unitario[5]+espaco[24]+vltotal[5]+espaco[25]+aliquota[5]+"\n" +
""+codigo[6]+espaco[26]+descricao[6]+espaco[27]+simbolo[6]+quantidade[6]+espaco[28]+unitario[6]+espaco[29]+vltotal[6]+espaco[30]+aliquota[6]+"\n" +
""+codigo[7]+espaco[31]+descricao[7]+espaco[32]+simbolo[7]+quantidade[7]+espaco[33]+unitario[7]+espaco[34]+vltotal[7]+espaco[35]+aliquota[7]+"\n" +
""+codigo[8]+espaco[36]+descricao[8]+espaco[37]+simbolo[8]+quantidade[8]+espaco[38]+unitario[8]+espaco[39]+vltotal[8]+espaco[40]+aliquota[8]+"\n" +
""+codigo[9]+espaco[41]+descricao[9]+espaco[42]+simbolo[9]+quantidade[9]+espaco[43]+unitario[9]+espaco[44]+vltotal[9]+espaco[45]+aliquota[9]+"\n" +
""+codigo[10]+espaco[46]+descricao[10]+espaco[47]+simbolo[10]+quantidade[10]+espaco[48]+unitario[10]+espaco[49]+vltotal[10]+espaco[50]+aliquota[10]+"\n" +
""+codigo[11]+espaco[51]+descricao[11]+espaco[52]+simbolo[11]+quantidade[11]+espaco[53]+unitario[11]+espaco[54]+vltotal[11]+espaco[50]+aliquota[11]+"\n" +
""+codigo[12]+espaco[56]+descricao[12]+espaco[57]+simbolo[12]+quantidade[12]+espaco[58]+unitario[12]+espaco[59]+vltotal[12]+espaco[60]+aliquota[12]+"\n" +
""+codigo[13]+espaco[61]+descricao[13]+espaco[62]+simbolo[13]+quantidade[13]+espaco[63]+unitario[13]+espaco[64]+vltotal[13]+espaco[65]+aliquota[13]+"\n" +
""+codigo[14]+espaco[66]+descricao[14]+espaco[67]+simbolo[14]+quantidade[14]+espaco[68]+unitario[14]+espaco[69]+vltotal[14]+espaco[70]+aliquota[14]+"\n" +
""+codigo[15]+espaco[71]+descricao[15]+espaco[72]+simbolo[15]+quantidade[15]+espaco[73]+unitario[15]+espaco[74]+vltotal[15]+espaco[75]+aliquota[15]+"\n" +
""+codigo[16]+espaco[76]+descricao[16]+espaco[77]+simbolo[16]+quantidade[16]+espaco[78]+unitario[16]+espaco[79]+vltotal[16]+espaco[80]+aliquota[16]+"\n" +
""+codigo[17]+espaco[81]+descricao[17]+espaco[82]+simbolo[17]+quantidade[17]+espaco[83]+unitario[17]+espaco[84]+vltotal[17]+espaco[85]+aliquota[17]+"\n" +
""+codigo[18]+espaco[86]+descricao[18]+espaco[87]+simbolo[18]+quantidade[18]+espaco[88]+unitario[18]+espaco[89]+vltotal[18]+espaco[90]+aliquota[18]+"\n" +
"\n" +
"\n" +
"          SERVICOS PRESTADOS EM INFORMATICA                                                                   \n" +
"\n" +
"                                                                                                                "+nota.getString(8)+"\n" +
"\n" +
"\n" +
"               0,00                   0,00                       0,00                   0,00                         "+nota.getString(9)+"\n" +
"\n" +
"               0,00                   0,00                       0,00                   0,00                       "+nota.getString(7)+"\n" +
"\n" +
"\n" +
"O MESMO                                                               2                     \n" +
"\n" +
"                                                                                            \n" +
"\n" +
"     0                    VOLUMES                                                                                       \n" +
"\n" +
"\n" +
"Empresa enquadrada no simples nacional\n" +
"Contato (54) 3419-0323\n" +
"\n" +
"Dados Bancarios:\n" +
"Banco Itau, Agencia: 0207  Conta: 84194-1\n" +
"\n" +
"\n" +
"\n" + 
"\n" +
"";
            try {
            File newTextFile = new File("/tmp/nota.a##");

            FileWriter fw = new FileWriter(newTextFile);
            fw.write(str);
            fw.close();
           } catch (IOException iox) {
            //do stuff with exception
            iox.printStackTrace();
        }

        } catch (SQLException ex ) {
            //do stuff with exceptionIOException iox
                  System.out.println(" Erro ao gerar nota: "+ex);
        }
    }
}
