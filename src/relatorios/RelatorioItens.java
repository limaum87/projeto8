/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package relatorios;

import factory.ConnectionFactory;
import gui.componentes.Dialogos;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;
import javax.imageio.ImageIO;
import modelo.Chamado;

/**
 *
 * @author felipe
 */
public class RelatorioItens {
    Connection conexao;
    InputStream inputStream;
    Map parametros;

    Dialogos d = new Dialogos();

public RelatorioItens() throws IOException{
    conexao = new ConnectionFactory().getConnection();
    inputStream = getClass().getResourceAsStream( "Itensemestoque.jasper" );
    parametros = new HashMap<String, Object>();

    //File logo = new File("/gui.icones/cabecalho.png");  
    //File rodape = new File("/gui.icones/rodape.png");  
    BufferedImage logo = ImageIO.read(getClass().getResource("/gui/icones/cabecalho.png"));
    BufferedImage rodape = ImageIO.read(getClass().getResource("/gui/icones/rodape.png"));

    try {
        relatorioutil.abrirRelatorio( "Itensemestoque", inputStream, parametros, conexao );

        } catch (Exception exc ) {
            d.MensagemErro(1, exc);
            exc.printStackTrace();
        } 

    }
}
