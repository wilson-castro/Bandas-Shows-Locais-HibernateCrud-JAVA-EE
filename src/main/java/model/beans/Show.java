package model.beans;

import java.util.Calendar;

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
