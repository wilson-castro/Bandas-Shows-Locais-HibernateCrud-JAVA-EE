package model.beans;

import model.enums.Genero;

public class Banda {
	private int idBanda;
	private String nome;
	private Genero genero;
	private int NumShows;
	
	public void setIdBanda(int idBanda) {
		this.idBanda = idBanda;
	}
	public int getIdBanda() {
		return idBanda;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Genero getGenero() {
		return genero;
	}
	public void setGenero(Genero genero) {
		this.genero = genero;
	}
	public int getNumShows() {
		return NumShows;
	}
	public void setNumShows(int numShows) {
		NumShows = numShows;
	}
	
	
	
}
