/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;
import java.time.LocalDate;
import java.util.ArrayList;




/**
 *
 * @author Nunzio
 */
public class Appello {
    private int NumData;
    private Corso corso;
    private Data data;
    public ArrayList<Data> ElencoAppelliDate= new ArrayList<Data>();
    public ArrayList<Appello> ElencoAppelli=new ArrayList<Appello>(); 
    public ArrayList<Studente> ListastudentiPrenotati=new ArrayList<Studente>();
    
    public Appello(){};
    public Appello(int NumData,Corso corso){
        ElencoAppelli=new ArrayList<Appello>();
        ElencoAppelliDate=new ArrayList<Data>();
        this.NumData=NumData;
        this.corso=corso;
    }
    
  public int getNumData(){
      return NumData;
  }
  public void setNumData(int NumData){
      this.NumData=NumData;
  }
  public void addData(Data d){
      if(d.getData().isAfter(LocalDate.of(2019, 12, 1))){
      ElencoAppelliDate.add(d);}
     
  }
  public Data getData(){
      return data;
  }
  public void setData(Data data){
      this.data=data;
  }
  public ArrayList<Appello> getAppelli(){
      return ElencoAppelli;
  }

public Corso getCorso(){
    return corso;
}
public void setCorso(Corso corso){
    this.corso=corso;
}
public ArrayList<Studente> getStudentiPrenotati(){
    return ListastudentiPrenotati;
}
public ArrayList<Data> getElencoDate() {
	return ElencoAppelliDate;	
}



    @Override
    public String toString() {
	
	StringBuffer buf = new StringBuffer();
	
	buf.append(corso+" con numero date "+NumData+ "\n");
	
	for(Data d : ElencoAppelliDate) {
		buf.append("  Date: "+d.getData()+"\n  Tipo Prova: "+d.getTipoProva()+"\n Aula:"+d.getAula()+"\n");
	}
	
	return buf.toString();
}
    
    
    

   

}
