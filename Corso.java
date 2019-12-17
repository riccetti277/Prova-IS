/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author Nunzio
 */
public class Corso {
    private String nomeCorso;
    private String Docente;
    private int NumCrediti;
    
    public Corso(){
        nomeCorso="";
        Docente="";
        NumCrediti=6;
    }
    public Corso(String nomeCorso,int NumCrediti,String Docente){
        this.nomeCorso=nomeCorso;
        this.NumCrediti=NumCrediti;
        this.Docente=Docente;
    }
    
    public String getNomeCor(){
        return nomeCorso;
    }
    public String getDocente(){
        return Docente;
    }
    public int getNumCrediti(){
        return NumCrediti;
    }
    public void setNomeCor(String nome){
        this.nomeCorso=nome;
    }
    public void setDocente(String doc){
        this.Docente=doc;
    }
    public void setNumCrediti(int crediti){
        this.NumCrediti=crediti;
    }
    @Override
    public String toString(){
        String s="";
        s+=nomeCorso+"   "+"CFU: "+NumCrediti+"   "+"Docente: "+Docente;
        return s;
    }
}
