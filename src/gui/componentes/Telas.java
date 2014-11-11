/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.componentes;

import gui.Cfops;
import gui.ConsultaNota;
import gui.ControlePagamentos;
import gui.MostraChamados;
import static gui.home.cards;
import java.awt.CardLayout;

/**
 *
 * @author felipe
 */
public class Telas {
    
    public void TelaInicio(){
        MostraChamados vwchm = new MostraChamados();
        cards.add(vwchm, "Mostra Chamado");
        CardLayout layout2 = (CardLayout) (cards.getLayout());
        layout2.show(cards, "Mostra Chamado");
    }
    public void TelaControlePagamentos(){
        ControlePagamentos ctlpag = new ControlePagamentos();
        cards.add(ctlpag, "Controle Paganentos");
        CardLayout layout2 = (CardLayout) (cards.getLayout());
        layout2.show(cards, "Controle Paganentos");
    }

    public void ConsultaNota() {
        ConsultaNota connot = new ConsultaNota();
        cards.add(connot, "Consulta Nota");
        CardLayout layout2 = (CardLayout) (cards.getLayout());
        layout2.show(cards, "Consulta Nota");
    }

    public void NovaNota() {
        Cfops novnot = new Cfops();
        cards.add(novnot, "Nova Nota");
        CardLayout layout2 = (CardLayout) (cards.getLayout());
        layout2.show(cards, "Nova Nota");
    }
}
