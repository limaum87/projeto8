
package relatorios;

import java.io.InputStream;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import net.sf.jasperreports.engine.JRException;
import factory.ConnectionFactory;

import java.sql.*;
/**
 *
 * @author felipe
 */
public class relatorios {
    Connection conexao;
    InputStream inputStream;
    Map parametros;
      

public relatorios(){
    conexao = new ConnectionFactory().getConnection();
    inputStream = getClass().getResourceAsStream( "empresas.jasper" );
    parametros = new HashMap();
    try {
        relatorioutil.abrirRelatorio( "empresas", inputStream, parametros, conexao );

        } catch (Exception exc ) {
            exc.printStackTrace();
        } 

    }
}
