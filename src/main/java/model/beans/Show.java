package model.beans;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Show {
	private int idShow;
	private Calendar data;
	private Banda[] bandas;
	private int idLocal;
	
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
            Date date = new SimpleDateFormat("dd/MM/yyyy")
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
	
	public Banda[] getBandas() {
		return bandas;
	}
	public void setBandas(Banda[] bandas) {
		this.bandas = bandas;
	}
	public int getIdLocal() {
		return idLocal;
	}
	public void setIdLocal(int idLocal) {
		this.idLocal = idLocal;
	}
	
	
	
}
