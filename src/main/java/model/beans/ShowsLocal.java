package model.beans;

public class ShowsLocal {
	private int id;
	private int show_Id;
	private int local_Id;
	private String data_show;
	private String lugar_nome;
	private int capacidade;
	private int numBandas;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getShow_Id() {
		return show_Id;
	}
	public void setShow_Id(int show_Id) {
		this.show_Id = show_Id;
	}
	public int getLocal_Id() {
		return local_Id;
	}
	public void setLocal_Id(int local_Id) {
		this.local_Id = local_Id;
	}
	public String getData_show() {
		return data_show;
	}
	public void setData_show(String data_show) {
		this.data_show = data_show;
	}
	public String getLugar_nome() {
		return lugar_nome;
	}
	public void setLugar_nome(String lugar_nomw) {
		this.lugar_nome = lugar_nomw;
	}
	public int getCapacidade() {
		return capacidade;
	}
	public void setCapacidade(int capacidade) {
		this.capacidade = capacidade;
	}
	public int getNumBandas() {
		return numBandas;
	}
	public void setNumBandas(int numBandas) {
		this.numBandas = numBandas;
	}
	
	
}