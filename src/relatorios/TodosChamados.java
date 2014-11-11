/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package relatorios;

import factory.ConnectionFactory;
import java.io.InputStream;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author felipe
 */
public class TodosChamados {
     Connection conexao;
    InputStream inputStream;
    Map parametros;
      

public TodosChamados(){
    conexao = new ConnectionFactory().getConnection();
    inputStream = getClass().getResourceAsStream( "chamados.jasper" );
    parametros = new HashMap();
    try {
        relatorioutil.abrirRelatorio( "chamados", inputStream, parametros, conexao );

        } catch (Exception exc ) {
            exc.printStackTrace();
        } 

    }
}

