/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progettojava;

import entity.*;
import control.*;
import java.time.LocalDate;

/**
 *
 * @author Nunzio
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Corso c1=new Corso("Fisica 1",6,"Marco Rossi");
        
       
        Studente s1=new Studente("Nunzio", "Riccetti", "N46003808");
        Studente s2=new Studente ("Ciro","Garofalo","N378902");
        
        Data d=new Data("sg-2",LocalDate.of(2019,12,03),TipoProva.Prova_Calcolatore,TipoAula.Aula);
        Data d1=new Data("SG-I",LocalDate.of(2019,10,03),TipoProva.Prova_Calcolatore,TipoAula.Laboratorio);
        
        
        Appello a1=new Appello(2,c1);
        
        Gestione gestione=new Gestione();
        Appello a=new Appello();
       
        
       gestione.InserisciCorso(c1);
       gestione.StampaCorsi();
       gestione.CreaCorso();
       gestione.StampaCorsi();
       
       gestione.aggiungiAppello(a1);
       a1.ElencoAppelliDate.add(d);
       a1.ElencoAppelliDate.add(d1);
       System.out.println(a1.toString());
       gestione.PrenotazioneStudente(a1, s2);
       gestione.PrenotazioneStudente(a1, s1);
       gestione.visualizzaStudentiPrenotati(a1);
       
      
       
    }
    
}
