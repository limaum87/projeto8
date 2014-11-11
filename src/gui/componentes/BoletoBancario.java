/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.componentes;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Date;
import java.text.SimpleDateFormat;
import org.jrimum.bopepo.BancosSuportados;
import org.jrimum.bopepo.view.BoletoViewer;
import org.jrimum.domkee.comum.pessoa.endereco.CEP;
import org.jrimum.domkee.comum.pessoa.endereco.Endereco;
import org.jrimum.domkee.comum.pessoa.endereco.UnidadeFederativa;
import org.jrimum.domkee.financeiro.banco.febraban.Agencia;
import org.jrimum.domkee.financeiro.banco.febraban.Carteira;
import org.jrimum.domkee.financeiro.banco.febraban.Cedente;
import org.jrimum.domkee.financeiro.banco.febraban.ContaBancaria;
import org.jrimum.domkee.financeiro.banco.febraban.NumeroDaConta;
import org.jrimum.domkee.financeiro.banco.febraban.Sacado;
import org.jrimum.domkee.financeiro.banco.febraban.SacadorAvalista;
import org.jrimum.domkee.financeiro.banco.febraban.TipoDeTitulo;
import org.jrimum.domkee.financeiro.banco.febraban.Titulo;
/**
 *
 * @author felipe
 */
public class BoletoBancario {
    public static void NovoBoleto() {/*
                 * INFORMANDO DADOS SOBRE O CEDENTE.
                 */
                Cedente cedente = new Cedente("Accept Solucoes em TI", "00.000.208/0001-00");
                
                /*
                 * INFORMANDO DADOS SOBRE O SACADO.
                 */
                Sacado sacado = new Sacado("JavaDeveloper Pronto Para Férias", "222.222.222-22");

                // Informando o endereço do sacado.
                Endereco enderecoSac = new Endereco();
                enderecoSac.setUF(UnidadeFederativa.RS);
                enderecoSac.setLocalidade("Caxias do sul");
                enderecoSac.setCep(new CEP("59064-120"));
                enderecoSac.setBairro("São Pelegrino");
                enderecoSac.setLogradouro("Rua Julio de Castilhos ");
                enderecoSac.setNumero("2951");
                sacado.addEndereco(enderecoSac);

                /*
                 * INFORMANDO DADOS SOBRE O SACADOR AVALISTA.
                 */
                SacadorAvalista sacadorAvalista = new SacadorAvalista("JRimum Enterprise", "00.000.000/0001-91");

                // Informando o endereço do sacador avalista.
                Endereco enderecoSacAval = new Endereco();
                enderecoSacAval.setUF(UnidadeFederativa.RS);
                enderecoSacAval.setLocalidade("Caxias do sul");
                enderecoSacAval.setCep(new CEP("59000-000"));
                enderecoSacAval.setBairro("Grande Centro");
                enderecoSacAval.setLogradouro("Rua Eternamente Principal");
                enderecoSacAval.setNumero("001");
                sacadorAvalista.addEndereco(enderecoSacAval);

                /*
                 * INFORMANDO OS DADOS SOBRE O TÍTULO.
                 */
                
                // Informando dados sobre a conta bancária do título.
                ContaBancaria contaBancaria = new ContaBancaria(BancosSuportados.BANCO_ITAU.create());
                contaBancaria.setNumeroDaConta(new NumeroDaConta(12345, "0"));
                contaBancaria.setCarteira(new Carteira(30));
                contaBancaria.setAgencia(new Agencia(1234, "1"));
                
                 SimpleDateFormat sdf1= new SimpleDateFormat("yyyy-MM-dd"); //você pode usar outras máscaras
                 java.util.Date y=new java.util.Date();
                 Date date2 = new Date(0000-00-00);
                String data = sdf1.format(y);
 
                
                Titulo titulo = new Titulo(contaBancaria, sacado, cedente, sacadorAvalista);
                titulo.setNumeroDoDocumento("123456");
                titulo.setNossoNumero("99345678");
                titulo.setDigitoDoNossoNumero("5");
                titulo.setValor(BigDecimal.valueOf(110.00));
                titulo.setDataDoDocumento(date2.valueOf(data));
                titulo.setDataDoVencimento(date2.valueOf(data));
                titulo.setTipoDeDocumento(TipoDeTitulo.DM_DUPLICATA_MERCANTIL);
                
                titulo.setDesconto(BigDecimal.ZERO);
                titulo.setDeducao(BigDecimal.ZERO);
                titulo.setMora(BigDecimal.ZERO);
                titulo.setAcrecimo(BigDecimal.ZERO);
                titulo.setValorCobrado(BigDecimal.ZERO);

                /*
                 * INFORMANDO OS DADOS SOBRE O BOLETO.
                 */
                org.jrimum.bopepo.Boleto boleto = new org.jrimum.bopepo.Boleto(titulo);
                
                boleto.setLocalPagamento("Pagável preferencialmente na Rede X ou em " +
                                "qualquer Banco até o Vencimento.");
                boleto.setInstrucaoAoSacado("Senhor sacado, sabemos sim que o valor " +
                                "cobrado não é o esperado, aproveite o DESCONTÃO!");
                boleto.setInstrucao1("PARA PAGAMENTO 1 até Hoje não cobrar nada!");
                boleto.setInstrucao2("PARA PAGAMENTO 2 até Amanhã Não cobre!");
                boleto.setInstrucao3("PARA PAGAMENTO 3 até Depois de amanhã, OK, não cobre.");
                boleto.setInstrucao4("PARA PAGAMENTO 4 até 04/xx/xxxx de 4 dias atrás COBRAR O VALOR DE: R$ 01,00");
                boleto.setInstrucao5("PARA PAGAMENTO 5 até 05/xx/xxxx COBRAR O VALOR DE: R$ 02,00");
                boleto.setInstrucao6("PARA PAGAMENTO 6 até 06/xx/xxxx COBRAR O VALOR DE: R$ 03,00");
                boleto.setInstrucao7("PARA PAGAMENTO 7 até xx/xx/xxxx COBRAR O VALOR QUE VOCÊ QUISER!");
                boleto.setInstrucao8("APÓS o Vencimento, Pagável Somente na Rede X.");

                /*
                 * GERANDO O BOLETO BANCÁRIO.
                 */
                // Instanciando um objeto "BoletoViewer", classe responsável pela
                // geração do boleto bancário.
                BoletoViewer boletoViewer = new BoletoViewer(boleto);

                // Gerando o arquivo. No caso o arquivo mencionado será salvo na mesma
                // pasta do projeto. Outros exemplos:
                // WINDOWS: boletoViewer.getAsPDF("C:/Temp/MeuBoleto.pdf");
                // LINUX: boletoViewer.getAsPDF("/home/temp/MeuBoleto.pdf");
                File arquivoPdf = boletoViewer.getPdfAsFile("MeuPrimeiroBoleto.pdf");

                // Mostrando o boleto gerado na tela.
                mostreBoletoNaTela(arquivoPdf);
    }
    private static void mostreBoletoNaTela(File arquivoBoleto) {

                java.awt.Desktop desktop = java.awt.Desktop.getDesktop();
                
                try {
                        desktop.open(arquivoBoleto);
                } catch (IOException e) {
                        e.printStackTrace();
                }
     }
}
