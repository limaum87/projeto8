/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
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
import modelo.OrdemCompra;

/**
 *
 * @author felipe
 */
public class OrdemdeCompra {
    Connection conexao;
    InputStream inputStream;
    InputStream subInputStream;
    Map parametros;
    String fch,emp;
    Dialogos d = new Dialogos();
    
public OrdemdeCompra(OrdemCompra oc) throws IOException{

    conexao = new ConnectionFactory().getConnection();
    inputStream = getClass().getResourceAsStream( "OrdemdeCompra.jasper" );
    subInputStream = this.getClass().getResourceAsStream("OrdemdeCompra_subreport1.jasper");
    parametros = new HashMap<String, Object>();
    BufferedImage logo = ImageIO.read(getClass().getResource("/gui/icones/cabecalho.png"));
    BufferedImage rodape = ImageIO.read(getClass().getResource("/gui/icones/rodape.png"));
    
    parametros.put("os",oc.getId_ordemcompra());
    parametros.put("cab",logo);
    parametros.put("rod",rodape);
    parametros.put("SUBREPORT_INPUT_STREAM", subInputStream);
    try {
        relatorioutil.abrirRelatorio( "OrdemdeCompra", inputStream, parametros, conexao );

        } catch (Exception exc ) {
            d.MensagemErro(1, exc);
            exc.printStackTrace();
        } 

    }
}

