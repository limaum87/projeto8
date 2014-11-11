/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import externo.InvertePontos;
import externo.Money;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Currency;

/**
 *
 * @author felipe
 */
public class Dinheiro {
    String dinheiro;
    Currency curr = Currency.getInstance("BRL");
    Money dinheirom;
    String dinheirosimbolo;
    String dinheirosemsimbolo;
    BigDecimal bddinheiro;
    
    public String getDinheiro() {
        return dinheiro;
    }

    public void setDinheiro(String dinheiro) {
        this.dinheiro = dinheiro;
    }

    public Currency getCurr() {
        return curr;
    }

    public void setCurr(Currency curr) {
        this.curr = curr;
    }

    public Money getDinheirom() {
        return dinheirom;
    }

    public void setDinheirom(Money dinheirom) {
        this.dinheirom = dinheirom;
    }

    public String getDinheirosimbolo() {
        return dinheirosimbolo;
    }

    public void setDinheirosimbolo(String dinheirosimbolo) {
        this.dinheirosimbolo = dinheirosimbolo;
    }

    public BigDecimal getBddinheiro() {
        return bddinheiro;
    }

    public void setBddinheiro(BigDecimal bddinheiro) {
        this.bddinheiro = bddinheiro;
    }

    
 
    
    public Money TransformaDinheiro(Dinheiro d){
        
        BigDecimal bd = new BigDecimal(d.getDinheiro());
        Money m = new Money(bd,curr);
        return m;
    }
    
    public String DinheiroSimbolo (Dinheiro d){
        String valor;
        Money m ;
        m=d.getDinheirom();
        valor=m.toStringcomSimbolo();
        valor=InvertePontos.converteVirgula(valor);
        return valor;
    }
    public String DinheirosemSimbolo (Dinheiro d){
        String valor;
        Money m ;
        m=d.getDinheirom();
        valor=m.toStringsemSimbolo();
        valor=InvertePontos.converteVirgula(valor);
        return valor;
    }
    public String DinheirosemSimbolo (){
        String valor;
        Money m ;
        m=this.getDinheirom();
        valor=m.toStringsemSimbolo();
        valor=InvertePontos.converteVirgula(valor);
        return valor;
    }
    public Dinheiro soma (Dinheiro d){
        String newe = InvertePontos.convertePonto(dinheiro);
        String newd = InvertePontos.convertePonto(d.getDinheiro());
        BigDecimal bd = new BigDecimal(newe);
        Money m = new Money(bd,curr);
        BigDecimal bd2 = new BigDecimal(newd);
        Money m2 = new Money(bd2,curr);
        m=m.plus(m2);
        String ms = m.toString();
        ms = m.toStringcomSimbolo();
        String m1 = m.toStringsemSimbolo();
        Dinheiro resultado = new Dinheiro();
        resultado.setDinheiro(m1);
        resultado.setDinheirom(m);
        resultado.setDinheirosimbolo(InvertePontos.converteVirgula(ms));
        return resultado;
    }
        public Dinheiro divide (BigDecimal qtdeParcelas){
        String newe = InvertePontos.convertePonto(this.getDinheiro());
        BigDecimal valorTotal = new BigDecimal(newe);
        
        BigDecimal valorParcela = valorTotal.divide(qtdeParcelas, 1, RoundingMode.CEILING);  
        BigDecimal valorParcial = valorParcela.multiply(qtdeParcelas.subtract(new BigDecimal(1)));  
        BigDecimal ultimaParcela = valorTotal.subtract(valorParcial);
        Money vpm = new Money(valorParcela,curr);
        DecimalFormat decFormat = new DecimalFormat("'R$' 0,00"); 
        DecimalFormat dinFormat = new DecimalFormat("00.00");
        String valorParcelasim= decFormat.format(valorParcela);  
        
        String vps = vpm.toString();
        vps = vpm.toStringcomSimbolo();
        String vp = dinFormat.format(valorParcela);
        Dinheiro resultado = new Dinheiro();
        vp=InvertePontos.converteVirgula(vp);
        valorParcelasim=InvertePontos.converteVirgula(valorParcelasim);
        resultado.setDinheiro(vp);
        resultado.setDinheirom(vpm);
        resultado.setDinheirosimbolo(valorParcelasim);
        return resultado;
    }
        public Dinheiro dividesobra (BigDecimal qtdeParcelas){
        String newe = InvertePontos.convertePonto(this.getDinheiro());
        BigDecimal valorTotal = new BigDecimal(newe);
        
        BigDecimal valorParcela = valorTotal.divide(qtdeParcelas, 1, RoundingMode.CEILING);  
        BigDecimal valorParcial = valorParcela.multiply(qtdeParcelas.subtract(new BigDecimal(1)));  
        BigDecimal ultimaParcela = valorTotal.subtract(valorParcial);
        
        Money vpm = new Money(ultimaParcela,curr);
        String vps = vpm.toString();
        vps = vpm.toStringcomSimbolo();
        String vp = vpm.toStringsemSimbolo();
        vp=InvertePontos.converteVirgula(vp);
        Dinheiro resultado = new Dinheiro();
        resultado.setDinheiro(vp);
        resultado.setDinheirom(vpm);
        resultado.setDinheirosimbolo(InvertePontos.converteVirgula(vps));
        return resultado;
    }
    public BigDecimal convertebd (){
        String newd = InvertePontos.convertePonto(this.getDinheiro());
        BigDecimal bd = new BigDecimal(newd);
        this.setBddinheiro(bd);
        return bd;
    }
    public Boolean maiorqzero (){
        int v;
        String newe = InvertePontos.convertePonto(this.getDinheiro());
        BigDecimal bd = new BigDecimal(newe);
        BigDecimal zero = new BigDecimal(0);
        v=bd.compareTo(zero);
        
        if (v>0){
            return true;
        }else
            return false;
    }
    public Dinheiro subtrai (Dinheiro d, Dinheiro e){
        String newe = InvertePontos.convertePonto(d.getDinheiro());
        String newd = InvertePontos.convertePonto(e.getDinheiro());
        BigDecimal bd = new BigDecimal(newe);
        Money m = new Money(bd,curr);
        BigDecimal bd2 = new BigDecimal(newd);
        Money m2 = new Money(bd2,curr);
        m=m.minus(m2);
        String ms = m.toString();
        ms = m.toStringcomSimbolo();
        String m1 = m.toStringsemSimbolo();
        Dinheiro resultado = new Dinheiro();
        resultado.setDinheiro(m1);
        resultado.setDinheirom(m);
        resultado.setDinheirosimbolo(InvertePontos.converteVirgula(ms));
        return resultado;
    }
    public Dinheiro multiplica (Integer q){
        String newe = InvertePontos.convertePonto(this.getDinheiro());
        BigDecimal bd = new BigDecimal(newe);
        Money m = new Money(bd,curr);
        m=m.times(q);
        String ms = m.toString();
        ms = m.toStringcomSimbolo();
        String m1 = m.toStringsemSimbolo();
        Dinheiro resultado = new Dinheiro();
        resultado.setDinheiro(InvertePontos.converteVirgula(m1));
        resultado.setDinheirom(m);
        resultado.setDinheirosimbolo(InvertePontos.converteVirgula(ms));
        return resultado;
    }

    public Dinheiro porcento() {
        String newe = InvertePontos.convertePonto(this.getDinheiro());
        BigDecimal bd = new BigDecimal(newe);
        Money m = new Money(bd,curr);
        m=m.times2(1.41d);
        String ms = m.toString();
        ms = m.toStringcomSimbolo();
        String m1 = m.toStringsemSimbolo();
        Dinheiro resultado = new Dinheiro();
        resultado.setDinheiro(InvertePontos.converteVirgula(m1));
        resultado.setDinheirom(m);
        resultado.setDinheirosimbolo(InvertePontos.converteVirgula(ms));
        return resultado;
    }
}
