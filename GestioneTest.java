/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import entity.Appello;
import entity.Corso;
import entity.Data;
import entity.Studente;
import entity.TipoAula;
import entity.TipoProva;
import java.time.LocalDate;
import static java.time.LocalDate.of;
import org.junit.After;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;


/**
 *
 * @author Nunzio
 */
public class GestioneTest {
    
    public GestioneTest() {
      
    
    
    }
    
    @Before
    public void setUp() {
        
    }
    
    @After
    public void tearDown() {
    }

   

    

    
    @Test
    public void TestPrenotazioneStudente1() {
        
       Gestione g=new Gestione();
       Studente s1=new Studente("Luigi","Garofalo","N567890");
       Corso c=new Corso("Elettronica", 3, "Luigi Olino");
       g.InserisciCorso(c);
       Appello a=new Appello(1,c);
       g.aggiungiAppello(a);
       Data d1=new Data("SG II", LocalDate.of(2019,12,30), TipoProva.Prova_Orale, TipoAula.Aula);
       a.addData(d1);
       g.PrenotazioneStudente(a, s1);
       assertEquals(1,a.ListastudentiPrenotati.size());
        
    }//in condizioni normali in cui sono presenti tutti i dati necessari la prenotazione avviene correttamente
    @Test
    public void TestPrenotazioneStudente2(){
       Gestione g=new Gestione();
       Studente s1=new Studente("Luigi","Garofalo","N567890");
       Corso c=new Corso("Elettronica",6,"Luigi Olino");
       g.InserisciCorso(c);
       Appello a=new Appello(1,c);
       Data d1=new Data("SG II", LocalDate.of(2019,12,30), TipoProva.Prova_Orale, TipoAula.Aula);
       a.addData(d1);
       g.PrenotazioneStudente(a, s1);
       assertEquals(0,a.ListastudentiPrenotati.size());
    }//Poichè l'appello è stato creato ma non aggiunto alla lista appelli mi aspetto che ritorni un messaggio "Non ci sono appelli disponibili"
    
    
    @Test
    public void TestPrenotazioneStudente3(){
        Gestione g=new Gestione();
       Studente s1=new Studente("Luigi","Garofalo","N567890");
       Corso c=new Corso("Elettronica",6,"Luigi Olino");
       g.InserisciCorso(c);
       Appello a=new Appello(1,c);
       g.aggiungiAppello(a);
       Data d1=new Data("SG II", LocalDate.of(2019,12,30), TipoProva.Prova_Orale, TipoAula.Aula);
       g.PrenotazioneStudente(a, s1);
       assertEquals(0,a.ListastudentiPrenotati.size());
    }//Poichè non è stata aggiunta la data  mi aspetto che ritorni un messaggio "Non ci sono date per questo appello"


    @Test
public void TestPrenotazioneStudente4(){
    Gestione g=new Gestione();
       Studente s1=new Studente("Luigi","Garofalo","N567890");
       Corso c=new Corso("Elettronica",6,"Luigi Olino");
       g.InserisciCorso(c);
       Appello a=new Appello(1,c);
       Data d1=new Data("SG II", LocalDate.of(2019,12,30), TipoProva.Prova_Orale, TipoAula.Aula);
       g.PrenotazioneStudente(a, s1);
       assertEquals(0,a.ListastudentiPrenotati.size());
       
}//Poiche non é stata aggiunta ne la data ne l'appello mi aspetto che riporti solo l'errore di mancato appello

@Test
public void TestPrenotazioneStudente5(){
    Gestione g=new Gestione();
    Studente s1=new Studente("Luigi","Garofalo","N567890");
    Corso c=new Corso("Elettronica",6,"Luigi Olino");
    Appello a=new Appello(1,c);
     Data d1=new Data("SG II", LocalDate.of(2019,12,30), TipoProva.Prova_Orale, TipoAula.Aula);
     g.PrenotazioneStudente(a, s1);
    assertEquals(0,a.ListastudentiPrenotati.size());
}//Poiche il corso non è stato aggiunto alla lista corsi mi aspetto che a prescindere non si effettui la prenotazione


@Test
public void TestPrenotazioneStudente6(){
        Gestione g=new Gestione();
        Studente s1=new Studente("Luigi","Garofalo","N567890");
       Corso c=new Corso("Elettronica", 3, "Luigi Olino");
       g.InserisciCorso(c);
       Appello a=new Appello(1,c);
       g.aggiungiAppello(a);
       Data d1=new Data("SG II", LocalDate.of(2019,12,30), TipoProva.Prova_Orale, TipoAula.Aula);
       a.addData(d1);
       g.PrenotazioneStudente(a, s1);
       g.PrenotazioneStudente(a, s1);
       assertEquals(1,a.ListastudentiPrenotati.size());
}//Poichè ho fatto prenotare lo studente s1 allo stesso appello mi aspetto che compaia 1 sola volta nella lista


@Test
public void TestPrenotazioneStudente7(){
    Gestione g=new Gestione();
    Studente s1=new Studente("Luigi","Garofalo","N567890");
    Studente s2=new Studente("Nunzio","Riccetti","N46003808");
    Corso c=new Corso("Ingegneria del Software",9,"Roberto Natella");
    Corso c1=new Corso("Elettronica",9,"Luigi Olino");
    g.InserisciCorso(c);
    g.InserisciCorso(c1);
    Appello a=new Appello(1,c);
    Appello a1=new Appello(1,c1);
    g.aggiungiAppello(a1);
    g.aggiungiAppello(a);
    Data d1=new Data("SG II", LocalDate.of(2019,12,30), TipoProva.Prova_Orale, TipoAula.Aula);
    Data d2=new Data("SG I", LocalDate.of(2020,1,03), TipoProva.Prova_Calcolatore, TipoAula.Laboratorio);
    a.addData(d2);
    a1.addData(d1);
    g.PrenotazioneStudente(a, s2);
    g.PrenotazioneStudente(a1, s1);
    assertEquals(1,a.ListastudentiPrenotati.size());
    assertEquals(1,a1.ListastudentiPrenotati.size());
}// Prenotando uno studente per ciascun appello mi aspetto che la lista del singolo appello contenga 1 studente


@Test
public void TestPrenotazioneStudente8(){
    Gestione g=new Gestione();
    Studente s1=new Studente("Luigi","Garofalo","N567890");
    Studente s2=new Studente("Nunzio","Riccetti","N46003808");
    Corso c=new Corso("Ingegneria del Software",9,"Roberto Natella");
    Corso c1=new Corso("Elettronica",9,"Luigi Olino");
    g.InserisciCorso(c);
    g.InserisciCorso(c1);
    Appello a=new Appello(1,c);
    Appello a1=new Appello(1,c1);
    g.aggiungiAppello(a1);
    g.aggiungiAppello(a);
    Data d1=new Data("SG II", LocalDate.of(2019,12,30), TipoProva.Prova_Orale, TipoAula.Aula);
    Data d2=new Data("SG I", LocalDate.of(2020,1,03), TipoProva.Prova_Calcolatore, TipoAula.Laboratorio);
    a.addData(d2);
    a1.addData(d1);
    g.PrenotazioneStudente(a, s2);
    g.PrenotazioneStudente(a, s1);
    assertEquals(2,a.ListastudentiPrenotati.size());
    assertEquals(0,a1.ListastudentiPrenotati.size());
}//Prenotando entrambi gli studenti per un appello mi aspetto che la lista di studenti prenotati sia vuota per l'altro appello
@Test
public void TestPrenotazioneStudente9(){
    Gestione g=new Gestione();
    Studente s1=new Studente("Luigi","Garofalo","N567890");
    Studente s2=new Studente("Nunzio","Riccetti","N46003808");
    Corso c=new Corso("Ingegneria del Software",9,"Roberto Natella");
    Corso c1=new Corso("Elettronica",9,"Luigi Olino");
    g.InserisciCorso(c);
    g.InserisciCorso(c1);
    Appello a=new Appello(1,c);
    Appello a1=new Appello(1,c1);
    g.aggiungiAppello(a1);
    g.aggiungiAppello(a);
    Data d1=new Data("SG II", LocalDate.of(2019,12,30), TipoProva.Prova_Orale, TipoAula.Aula);
    Data d2=new Data("SG I", LocalDate.of(2020,1,03), TipoProva.Prova_Calcolatore, TipoAula.Laboratorio);
    a.addData(d2);
    a1.addData(d1);
    g.PrenotazioneStudente(a, s2);
    g.PrenotazioneStudente(a, s1);
    g.PrenotazioneStudente(a1, s2);
    g.PrenotazioneStudente(a1, s1);
    assertEquals(2,a.ListastudentiPrenotati.size());
    assertEquals(2,a1.ListastudentiPrenotati.size());
    }//Prenotando gli stessi studenti per due appelli differenti mi aspetto che la lista di entrambi gli appelli li contenga
@Test
public void TestPrenotazioneStudente10(){
    Gestione g=new Gestione();
    Studente s1=new Studente("Luigi","Garofalo","N567890");
    Studente s2=new Studente("Nunzio","Riccetti","N46003808");
    Corso c=new Corso("Ingegneria del Software",9,"Roberto Natella");
    Corso c1=new Corso("Elettronica",9,"Luigi Olino");
    g.InserisciCorso(c);
    g.InserisciCorso(c1);
    Appello a=new Appello(1,c);
    Appello a1=new Appello(1,c1);
    g.aggiungiAppello(a1);
    g.aggiungiAppello(a);
    Data d1=new Data("SG II", LocalDate.of(2019,12,30), TipoProva.Prova_Orale, TipoAula.Aula);
    Data d2=new Data("SG I", LocalDate.of(2020,1,03), TipoProva.Prova_Calcolatore, TipoAula.Laboratorio);
    a.addData(d2);
    a1.addData(d1);
    g.PrenotazioneStudente(a, s2);
    g.PrenotazioneStudente(a, s1);
    g.PrenotazioneStudente(a1, s2);
    assertEquals(2,a.ListastudentiPrenotati.size());
    assertEquals(1,a1.ListastudentiPrenotati.size());
}//Lo studente s2 si è prenotato a entrambi gli appelli mi aspetto che compaia in entrambi gli appelli
@Test
public void TestPrenotazioneStudente11(){
    Gestione g=new Gestione();
    Studente s1=new Studente("Luigi","Garofalo","N567890");
    Studente s2=new Studente("Nunzio","Riccetti","N46003808");
    Corso c=new Corso("Ingegneria del Software",9,"Roberto Natella");
    Corso c1=new Corso("Elettronica",9,"Luigi Olino");
    g.InserisciCorso(c);
    g.InserisciCorso(c1);
    Appello a=new Appello(1,c);
    Appello a1=new Appello(1,c1);
    g.aggiungiAppello(a1);
    g.aggiungiAppello(a);
    Data d1=new Data("SG II", LocalDate.of(2019,12,30), TipoProva.Prova_Orale, TipoAula.Aula);
    Data d2=new Data("SG I", LocalDate.of(2020,1,03), TipoProva.Prova_Calcolatore, TipoAula.Laboratorio);
    a.addData(d2);
    a1.addData(d1);
    g.PrenotazioneStudente(a, s2);
    g.PrenotazioneStudente(a, s1);
    g.PrenotazioneStudente(a1, s2);
    g.PrenotazioneStudente(a1, s2);
    assertEquals(2,a.ListastudentiPrenotati.size());
    assertEquals(1,a1.ListastudentiPrenotati.size());
}//Nel secondo appello lo studente s2 si è prenotato due volte mi aspetto che compaia solo 1 volta
@Test
public void TestPrenotazioneStudente12(){
    Gestione g=new Gestione();
    Studente s1=new Studente("Luigi","Garofalo","N567890");
    Studente s2=new Studente("Nunzio","Riccetti","N46003808");
    Corso c=new Corso("Ingegneria del Software",9,"Roberto Natella");
    Corso c1=new Corso("Elettronica",9,"Luigi Olino");
    g.InserisciCorso(c);
    Appello a=new Appello(1,c);
    Appello a1=new Appello(1,c1);
    g.aggiungiAppello(a1);
    g.aggiungiAppello(a);
    Data d1=new Data("SG II", LocalDate.of(2019,12,30), TipoProva.Prova_Orale, TipoAula.Aula);
    Data d2=new Data("SG I", LocalDate.of(2020,1,03), TipoProva.Prova_Calcolatore, TipoAula.Laboratorio);
    a.addData(d2);
    a1.addData(d1);
    g.PrenotazioneStudente(a, s2);
    g.PrenotazioneStudente(a, s1);
    g.PrenotazioneStudente(a1, s2);
    g.PrenotazioneStudente(a1, s2);
    g.PrenotazioneStudente(a1, s1);
    assertEquals(2,a.ListastudentiPrenotati.size());
    assertEquals(0,a1.ListastudentiPrenotati.size());
}//Ho creato due corsi ma ho aggiunto solo 1 nell'elenco dei corsi mi aspetto che anche insernedo l'appello per quel corso gli studenti non riescano a prenotarsi

@Test
public void TestPrenotazioneStudente13(){
    Gestione g=new Gestione();
    Studente s1=new Studente("Luigi","Garofalo","N567890");
    Studente s2=new Studente("Nunzio","Riccetti","N46003808");
    Corso c=new Corso("Ingegneria del Software",9,"Roberto Natella");
    Corso c1=new Corso("Elettronica",9,"Luigi Olino");
    g.InserisciCorso(c);
    g.InserisciCorso(c1);
    Appello a=new Appello(1,c);
    Appello a1=new Appello(1,c1);
    g.aggiungiAppello(a1);
    g.aggiungiAppello(a);
    Data d1=new Data("SG II", LocalDate.of(2019,12,30), TipoProva.Prova_Orale, TipoAula.Aula);
    Data d2=new Data("SG I", LocalDate.of(2020,1,03), TipoProva.Prova_Calcolatore, TipoAula.Laboratorio);
    a.addData(d2);
    a1.addData(d1);
    assertEquals(0,a.ListastudentiPrenotati.size());
    assertEquals(0,a1.ListastudentiPrenotati.size());
}//Senza nessuna prenotazione le due liste di studenti prenotati ai rispettivi appelli saranno vuote

@Test
public void TestPrenotazioneStudente14(){
    Gestione g=new Gestione();
    Studente s1=new Studente("Luigi","Garofalo","");
    Studente s2=new Studente("Nunzio","Riccetti","N46003808");
    Corso c=new Corso("Ingegneria del Software",9,"Roberto Natella");
    Corso c1=new Corso("Elettronica",9,"Luigi Olino");
    g.InserisciCorso(c);
    g.InserisciCorso(c1);
    Appello a=new Appello(1,c);
    Appello a1=new Appello(1,c1);
    g.aggiungiAppello(a1);
    g.aggiungiAppello(a);
    Data d1=new Data("SG II", LocalDate.of(2019,12,30), TipoProva.Prova_Orale, TipoAula.Aula);
    Data d2=new Data("SG I", LocalDate.of(2020,1,03), TipoProva.Prova_Calcolatore, TipoAula.Laboratorio);
    a.addData(d2);
    a1.addData(d1);
    g.PrenotazioneStudente(a, s2);
    g.PrenotazioneStudente(a, s1);
    g.PrenotazioneStudente(a1, s2);
    g.PrenotazioneStudente(a1, s2);
    assertEquals(1,a.ListastudentiPrenotati.size());
    assertEquals(1,a1.ListastudentiPrenotati.size());
}//Poiche la matricola di s1 è nulla la prenotazione non dovrebbe avvenire

@Test
public void TestPrenotazioneStudente15(){
    Gestione g=new Gestione();
    Studente s1=new Studente("Luigi","Garofalo","");
    Studente s2=new Studente("Nunzio","Riccetti","N46003808");
    Studente s3=new Studente("Martina","Soriano","N4600912");
    
    Corso c1=new Corso("Ingegneria del Software",9,"");
    Corso c2=new Corso("",9,"Luigi Olino");
    Corso c3=new Corso("Teoria dei segnali",9,"Luisa Polito");
    
    g.InserisciCorso(c1);
    g.InserisciCorso(c2);
    g.InserisciCorso(c3);
    Appello a1=new Appello(1,c1);
    Appello a2=new Appello(1,c2);
    Appello a3=new Appello(1,c3);
    g.aggiungiAppello(a1);
    g.aggiungiAppello(a2);
    g.aggiungiAppello(a3);
    Data d1=new Data("SG II", LocalDate.of(2019,12,30), TipoProva.Prova_Orale, TipoAula.Aula);
    Data d2=new Data("SG II", LocalDate.of(2020, 1, 4), TipoProva.Prova_Orale, TipoAula.Aula);
    Data d3=new Data("SG III",LocalDate.of(2020, 2, 20), TipoProva.Prova_Orale, TipoAula.Aula);
    a1.addData(d2);
    a2.addData(d1);
    a3.addData(d3);
    g.PrenotazioneStudente(a1, s2);
    g.PrenotazioneStudente(a1, s1);
    g.PrenotazioneStudente(a1, s3);
    g.PrenotazioneStudente(a2, s2);
    g.PrenotazioneStudente(a3, s3);
    assertEquals(0,a1.ListastudentiPrenotati.size());
    assertEquals(0,a2.ListastudentiPrenotati.size());
    assertEquals(1,a3.ListastudentiPrenotati.size());
}//Poiche alcuni tra i dati dello studente "s1" e quelli dei corsi "c" e "c1" sono nulli la prenotazione non avverrà

@Test
public void TestPrenotazioneStudente16(){
    Gestione g=new Gestione();
    Studente s1=new Studente("Luigi","Garofalo","N567890");
    Studente s2=new Studente("Nunzio","Riccetti","N46003808");
    Studente s3=new Studente("Martina","Soriano","N4600912");
    
    Corso c1=new Corso("Ingegneria del Software",9,"RobertoNatella");
    Corso c2=new Corso("Elettronica",9,"Luigi Vosio");
    Corso c3=new Corso("Teoria dei segnali",9,"Luisa Polito");
    
    g.InserisciCorso(c1);
    g.InserisciCorso(c2);
    g.InserisciCorso(c3);
    
    Appello a1=new Appello(1,c1);
    Appello a2=new Appello(1,c2);
    Appello a3=new Appello(1,c3);
    g.aggiungiAppello(a1);
    g.aggiungiAppello(a2);
    g.aggiungiAppello(a3);
    g.aggiungiAppello(a3);
    Data d1=new Data("SG II", LocalDate.of(2019,12,30), TipoProva.Prova_Orale, TipoAula.Aula);
    Data d2=new Data("SG II", LocalDate.of(2020, 1, 4), TipoProva.Prova_Orale, TipoAula.Aula);
    Data d3=new Data("SG III",LocalDate.of(2020, 2, 20), TipoProva.Prova_Orale, TipoAula.Aula);
    a1.addData(d2);
    a2.addData(d1);
    a3.addData(d3);
    g.PrenotazioneStudente(a1, s2);
    g.PrenotazioneStudente(a3, s3);
    g.PrenotazioneStudente(a1, s1);
    g.PrenotazioneStudente(a1, s3);
    g.PrenotazioneStudente(a2, s2);
    g.PrenotazioneStudente(a3, s3);
    
    assertEquals(3,a1.ListastudentiPrenotati.size());
    assertEquals(1,a2.ListastudentiPrenotati.size());
    assertEquals(1,a3.ListastudentiPrenotati.size());
    
    
}//Testando più studenti che si prenotano a più esami.
@Test
public void TestPrenotazioneStudente17(){
    Gestione g=new Gestione();
    Studente s1=new Studente("Luigi","Garofalo","N567890");
    
    Corso c1=new Corso("Ingegneria del Software",9,"Roberto Natella");
    Corso c2=new Corso("Fisica 1",6," Giovanni Loschi");
    g.InserisciCorso(c1);
    g.InserisciCorso(c2);
    Appello a1=new Appello(1,c1);
    Appello a2=new Appello(2,c2);
    g.aggiungiAppello(a1);
    g.aggiungiAppello(a2);
    Data d1=new Data("SG II", LocalDate.of(2019,12,30), TipoProva.Prova_Orale, TipoAula.Aula);
    Data d2=new Data("SG II", LocalDate.of(2019, 1, 4), TipoProva.Prova_Orale, TipoAula.Aula);
    Data d3=new Data("SG III",LocalDate.of(2020, 2, 20), TipoProva.Prova_Orale, TipoAula.Aula);
    a2.addData(d2);
    a1.addData(d1);
    a2.addData(d3);
    g.PrenotazioneStudente(a1, s1);
    g.PrenotazioneStudente(a2, s1);
    assertEquals(1,a1.ListastudentiPrenotati.size());
    assertEquals(1,a2.ListastudentiPrenotati.size());
    assertEquals(1,a1.ElencoAppelliDate.size());
    assertEquals(1,a2.ElencoAppelliDate.size());
    
}//Poichè la data d2 è fissata per prima di Dicembre mi aspetto che non compaia nella lista di date di a2


}

