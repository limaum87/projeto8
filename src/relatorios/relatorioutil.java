
package relatorios;

import com.jaspersoft.jrx.export.JRTxtExporter;
import factory.ConnectionFactory;
import java.awt.BorderLayout;
import java.io.File;
import java.io.InputStream;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import jxl.format.PaperSize;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.export.JRTextExporter;
import net.sf.jasperreports.engine.export.JRTextExporterParameter;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.swing.JRViewer;
/**
 *
 * @author felipe
 */
public class relatorioutil {
   

    public static void abrirRelatorio( String titulo, InputStream inputStream,Map parametros, Connection conexao ) 
            throws JRException {
        JasperPrint print = JasperFillManager.fillReport(inputStream, parametros, conexao );
       
        viewReportFrame( titulo, print );
    }


    public static void abrirRelatorio(
            String titulo,
            InputStream inputStream,
            Map parametros,
            JRDataSource dataSource ) throws JRException {
        
        JasperPrint print = JasperFillManager.fillReport(
                inputStream, parametros, dataSource );
        viewReportFrame( titulo, print );

    }

    public static void multiplosRelatorios(String titulo,InputStream inputStream,Map parametros, Connection conexao ) throws JRException{
        
        JasperPrint print = JasperFillManager.fillReport(inputStream, parametros, conexao );
        viewReportFrame( titulo, print );
        
    }
    
    public static JasperPrint Relatorioun(InputStream inputStream,Map parametros, Connection conexao ) throws JRException{

        JasperPrint jasperPrint = JasperFillManager.fillReport(inputStream, parametros, conexao); 
        return jasperPrint;
        
    }
    
    public static void viewReportFrame( String titulo, JasperPrint print ) {

        JRViewer viewer = new JRViewer( print );
        JFrame frameRelatorio = new JFrame( titulo );
        frameRelatorio.add( viewer, BorderLayout.CENTER );
        frameRelatorio.setSize( 500, 500 );
        frameRelatorio.setExtendedState( JFrame.MAXIMIZED_BOTH );
        frameRelatorio.setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
        frameRelatorio.setVisible( true );

    }
public static void txtRelatorio( String titulo, InputStream inputStream,Map parametros, Connection conexao ) {
       
        JRExporter exporter = new JRTextExporter();  
            JasperPrint print;
        try {
            print = JasperFillManager.fillReport(inputStream, parametros, conexao );
       
            // Configure the exporter (set output file name and print object)  

            exporter.setParameter(JRExporterParameter.JASPER_PRINT, print);  

            exporter.setParameter(JRExporterParameter.OUTPUT_FILE, new File("/home/felipe/report.txt"));    
            exporter.setParameter(JRTextExporterParameter.CHARACTER_WIDTH, new Float(3));  
            exporter.setParameter(JRTextExporterParameter.CHARACTER_HEIGHT, new Float(30));  
            exporter.setParameter(JRTextExporterParameter.CHARACTER_ENCODING, "iso-8859-1");  
                     
            // Export the PDF file  
            exporter.exportReport();  
        } catch (JRException ex) {
            Logger.getLogger(relatorioutil.class.getName()).log(Level.SEVERE, null, ex);
        }
}
}
