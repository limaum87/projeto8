
package relatorios;

import java.io.InputStream;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import factory.ConnectionFactory;
import gui.componentes.Dialogos;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import modelo.Chamado;
import relatorios.relatorioutil;
import java.sql.*;
import javax.imageio.ImageIO;
/**
 *
 * @author felipe
 */
public class VerChamado {
    Connection conexao;
    InputStream inputStream;
    Map parametros;
    Long idos;  
    Dialogos d = new Dialogos();

public VerChamado(Chamado chamado) throws IOException{
    conexao = new ConnectionFactory().getConnection();
    inputStream = getClass().getResourceAsStream( "VerChamado.jasper" );
    parametros = new HashMap<String, Object>();
    idos = chamado.getId_ocorrencia();
    //File logo = new File("/gui.icones/cabecalho.png");  
    //File rodape = new File("/gui.icones/rodape.png");  
    BufferedImage logo = ImageIO.read(getClass().getResource("/gui/icones/cabecalho.png"));
    BufferedImage rodape = ImageIO.read(getClass().getResource("/gui/icones/rodape.png"));

    parametros.put("id_os",idos);
    parametros.put("cab",logo);
    parametros.put("rod",rodape);
    try {
        relatorioutil.abrirRelatorio( "VerChamado", inputStream, parametros, conexao );

        } catch (Exception exc ) {
            d.MensagemErro(1, exc);
            exc.printStackTrace();
        } 

    }
}

