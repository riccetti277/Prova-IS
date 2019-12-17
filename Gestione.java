/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;
import entity.*;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.Scanner;


/**
 *
 * @author Nunzio
 */
public class Gestione {
    public ArrayList<Corso> ElencoCorsi= new ArrayList<>();
    Scanner input=new Scanner(System.in);
    
     
    Appello app=new Appello();
    
    
    Corso cor=new Corso();
    
    public Gestione(){};
    
    public void CreaCorso(){
        System.out.println("Inserisci Nome Corso:");
        String nom=input.nextLine();
        cor.setNomeCor(nom);
        System.out.println("Inserire Nome Docente:"); 
        String doc=input.nextLine();
        cor.setDocente(doc);
        System.out.println("Inserire CFU:");
        int cfu=input.nextInt();
        cor.setNumCrediti(cfu);
       if(ElencoCorsi.contains(nom)){
           if(ElencoCorsi.contains(doc)){
               return;
           }
       }
	ElencoCorsi.add(cor);
       
	
    }
    public void InserisciCorso(Corso c){
        ElencoCorsi.add(c);
    }
    
    public void StampaCorsi(){
        if(ElencoCorsi.size()==0){
            System.out.println("Non ci sono corsi.");
        }
        for(Iterator<Corso> i=ElencoCorsi.iterator();i.hasNext();){
            Corso c=i.next();
            System.out.println(c);
        }
    }
    public void RimuoviCorso(Corso cor){
        
        ElencoCorsi.remove(cor);
        
    }
    
    public void PrenotazioneStudente(Appello a ,Studente s){
       
       if(s.getMatricola().isEmpty()){
           System.out.println("Lo studente " +s+ "non ha la matricola");
           return;
       }
       if(!ElencoCorsi.contains(a.getCorso())){
           System.out.println("Il corso "+a.getCorso()+"non non è presente in lista");
           return;
           
       }
       
       
       if(ElencoCorsi.size()==0){
           
       
           System.out.print("Il corso non è presente nella lista");
            System.out.println(" ERRORE : IMPOSSIBILE EFFETTUARE PRENOTAZIONE");
            return;
       }
       
       if(a.getCorso().getNomeCor().isEmpty()){
           System.out.println("Nome corso non presente.");
           return;
       }
       if(a.getCorso().getDocente().isEmpty()){
           System.out.println("Docente del corso non presente ");
           return;
       }
	if(app.ElencoAppelli.size()==0){
            System.out.print("Non ci sono appelli disponibili");
            System.out.println(" ERRORE : IMPOSSIBILE EFFETTUARE PRENOTAZIONE");
            return;
        }
        
        
	
            if(a.ElencoAppelliDate.size()==0){
            System.out.print("Non ci sono date per questo appello.");
            System.out.println(" ERRORE : IMPOSSIBILE EFFETTUARE PRENOTAZIONE");
            return;}
            
        if(a.ListastudentiPrenotati.contains(s)){     
	System.out.println("Lo studente "+s+" è già prenotato per l'appello ");
        return;
        }   
        else{
             s.AppelliPrenotati.add(a);
	a.ListastudentiPrenotati.add(s);
        }
                    
        }       
         
public void aggiungiAppello(Appello appello)
	{

	if (app.ElencoAppelli.contains(appello)){   
        return;
	}
        app.ElencoAppelli.add(appello);
        }
   public void visualizzaAppelliPrenotati(Studente s) {
         System.out.print("Lo studente "+s+" si è prenotato ai seguenti esami: ");
		for(Appello a : s.AppelliPrenotati) {
			System.out.println(a);
		}
	}
	
	public void visualizzaStudentiPrenotati(Appello a) {
            if(a.ListastudentiPrenotati.size()==0){
                System.out.print("Non ci sono studenti prenotati: ");
                return;
            }
     System.out.println("Gli studenti prenotati per l'appello: "+a+" sono: ");
        for (Studente s : a.getStudentiPrenotati()) {
            System.out.println(s);
        }
	}
}
