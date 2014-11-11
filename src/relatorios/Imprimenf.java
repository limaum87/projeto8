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
import modelo.NotaFiscal;

/**
 *
 * @author felipe
 */
public class Imprimenf {
    
    Connection conexao;
    InputStream inputStream;
    InputStream subInputStream;
    InputStream subInputStream2;
    Map parametros;
    String fch,emp;
    Long id_nota;

public Imprimenf(NotaFiscal nf){

    conexao = new ConnectionFactory().getConnection();
    inputStream = getClass().getResourceAsStream( "Imprimenf.jasper" );
    subInputStream = this.getClass().getResourceAsStream("Imprimenf_subreport1.jasper");
    subInputStream2 = this.getClass().getResourceAsStream("Imprimenf_subreport2.jasper");


    parametros = new HashMap<String, Object>();
    id_nota= nf.getId_nota();
    parametros.put("id_nota",id_nota);
    parametros.put("SUBREPORT_INPUT_STREAM", subInputStream);
    parametros.put("SUBREPORT_INPUT_STREAM2", subInputStream2);
    try {
        relatorioutil.abrirRelatorio( "Imprimenf.jasper", inputStream, parametros, conexao );
        

        } catch (Exception exc ) {
            exc.printStackTrace();
        } 

    }

}

