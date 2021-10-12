
package model.beans;

public class Local {
	private int idLocal;
	private String nome;
	private int capacidade;
	private Show[] shows;
	
	
	public void setIdLocal(int idLocal) {
		this.idLocal = idLocal;
	}
	public int getIdLocal() {
		return idLocal;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getCapacidade() {
		return capacidade;
	}
	public void setCapacidade(int capacidade) {
		this.capacidade = capacidade;
	}
	public Show[] getShows() {
		return shows;
	}
	public void setShows(Show[] shows) {
		this.shows = shows;
	}
	
	
}