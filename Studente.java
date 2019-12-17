/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.ArrayList;

/**
 *
 * @author Nunzio
 */
public class Studente {
    private String nome;
    private String cognome;
    private String matricola;
    public ArrayList<Appello> AppelliPrenotati=new ArrayList<Appello>();
    
    public Studente(){
        nome="";
        cognome="";
        matricola="";
        AppelliPrenotati=new ArrayList<Appello>();
    }
    
    public Studente(String nome,String cognome,String matricola){
        this.nome=nome;
        this.cognome=cognome;
        this.matricola=matricola;
        
    }
    
    public String getNome(){
        return nome;
        
    }
    public String getCognome(){
        return cognome;
    }
    public String getMatricola(){
        return matricola;
    }
    public void setNome(String nome){
        this.nome=nome;
    }        
     public void setCognome(String cognome){
         this.cognome=cognome;
     }
     public void setMat(String matricola){
         this.matricola=matricola;
     }
      public String toString(){
          String s="";
          s+="Nome: "+nome+"  "+"Cognome: "+cognome+"  "+"Matricola: "+matricola;
          return s;
      }     
}
