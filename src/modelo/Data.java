/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import gui.componentes.Dialogos;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 *
 * @author felipe
 */
public class Data {
    java.sql.Date  data; 
    Dialogos d = new Dialogos();
    java.sql.Date sqlDate ;

    public java.sql.Date getData() {
        return data;
    }

    public void setData(java.sql.Date data) {
        this.data = data;
    }
    
    
    public void RetornaData(String e){
        SimpleDateFormat inputFormat = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy", Locale.US);
        SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            sqlDate= new java.sql.Date (inputFormat.parse(e).getTime()); 
        } catch (ParseException ex) {
            d.MensagemErro(1, ex);
        }
        this.setData(sqlDate);
    }
}
