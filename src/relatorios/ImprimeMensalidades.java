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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.imageio.ImageIO;
import modelo.Chamado;
import modelo.Fechamento;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRPrintPage;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

/**
 *
 * @author felipe
 */
public class ImprimeMensalidades {
    Connection conexao;
    InputStream inputStream;
    Map parametros;
    String fch,emp;
    Dialogos d = new Dialogos();
    
public ImprimeMensalidades(Fechamento fs) throws IOException{

    conexao = new ConnectionFactory().getConnection();
    inputStream = getClass().getResourceAsStream( "ImprimeMensalidades.jasper" );
    parametros = new HashMap<String, Object>();
    BufferedImage logo = ImageIO.read(getClass().getResource("/gui/icones/cabecalho.png"));
    BufferedImage rodape = ImageIO.read(getClass().getResource("/gui/icones/rodape.png"));
    parametros.put("fechamento",fs.getNome_fechamento());
    parametros.put("empresa", fs.getNome_empresa());
    parametros.put("cab",logo);
    parametros.put("rod",rodape);
    try {
        relatorioutil.abrirRelatorio( "ImprimeMensalidades", inputStream, parametros, conexao );

        } catch (Exception exc ) {
            d.MensagemErro(1, exc);
            exc.printStackTrace();
        } 

    }
}
