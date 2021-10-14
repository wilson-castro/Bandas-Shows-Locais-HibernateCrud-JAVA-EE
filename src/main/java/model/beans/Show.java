package model.beans;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Show {
	private int idShow;
	private Calendar data;
	private int idLocal;
	private int numBandas;
	
	public void setIdShow(int idShow) {
		this.idShow = idShow;
	}
	public int getIdShow() {
		return idShow;
	}
	public Calendar getData() {
		return data;
	}
	
	public void setData(String data) {
		Calendar dataConvertida = null;	
		
		try {
            Date date = new SimpleDateFormat("yyyy-MM-dd")
                  .parse(data);
            dataConvertida = Calendar.getInstance();
            dataConvertida.setTime(date);
        } catch (ParseException e) {
            System.out.println("Erro de conversão da data");
            return; //para a execução do método
        }

		
		this.data = dataConvertida;
	}
	
	public void setData(Calendar data) {

		this.data = data;
	}
	
	public int getIdLocal() {
		return idLocal;
	}
	public void setIdLocal(int idLocal) {
		this.idLocal = idLocal;
	}
	public int getNumBandas() {
		return numBandas;
	}
	public void setNumBandas(int numBandas) {
		this.numBandas = numBandas;
	}
	
	
	
}
