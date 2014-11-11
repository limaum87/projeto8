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
import modelo.Fechamento;

/**
 *
 * @author felipe
 */
public class Etiquetas {
    Connection conexao;
    InputStream inputStream;
    Map parametros;
    String fch,emp;
    Dialogos d = new Dialogos();    

    
public Etiquetas(Fechamento fs) throws IOException{

    conexao = new ConnectionFactory().getConnection();
    inputStream = getClass().getResourceAsStream( "Etiquetas.jasper" );
    parametros = new HashMap<String, Object>();
    parametros.put("fechamento",fs.getNome_fechamento());
    try {
        relatorioutil.abrirRelatorio( "Etiquetas", inputStream, parametros, conexao );

        } catch (Exception exc ) {
            d.MensagemErro(1, exc);
            exc.printStackTrace();
        } 

    }
}
