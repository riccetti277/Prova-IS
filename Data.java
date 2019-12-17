/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;
import java.time.LocalDate;
/**
 *
 * @author Nunzio
 */
public class Data {
    private String aulaProva;
    private LocalDate data;
    private TipoProva tipoProva;
    private TipoAula tipoAula;
    
    public Data(String aula,LocalDate data,TipoProva prova,TipoAula tipoaula){
        this.aulaProva=aula;
        this.data=data;
        this.tipoAula=tipoaula;
        this.tipoProva=prova;
    }
    
    public LocalDate getData(){
        return data;
    }
    public void setData(LocalDate data){
        this.data=data;
    }
    public String getAula(){
        return aulaProva;
    }
    public void setAula(String aula){
        this.aulaProva=aula;
}
    public TipoProva getTipoProva(){
        return tipoProva;
    }
    public TipoAula getTipoAula(){
        return tipoAula;
    }
   
    public void seTipoAula(TipoAula tipoaula){
        this.tipoAula=tipoaula;
}
    public void setTipoProva(TipoProva tipoprova){
        this.tipoProva=tipoprova;
}
    @Override
    public String toString(){
        String s="";
        s+=("Aula: "+aulaProva+"\tTipoAula: "+tipoAula+"\tData: "+data+" TipoProva: "+tipoProva+"\n");
        return s;
    }
}
