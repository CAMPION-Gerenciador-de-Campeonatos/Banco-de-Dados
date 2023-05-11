package DTO;

public class ArvorePartidas {
	
	private int id;
	private int pai_id;
	private int filho_esquerda;
	private int filho_direita;
	private String nome_fase;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPai_id() {
		return pai_id;
	}
	public void setPai_id(int pai_id) {
		this.pai_id = pai_id;
	}
	public int getFilho_esquerda() {
		return filho_esquerda;
	}
	public void setFilho_esquerda(int filho_esquerda) {
		this.filho_esquerda = filho_esquerda;
	}
	public int getFilho_direita() {
		return filho_direita;
	}
	public void setFilho_direita(int filho_direita) {
		this.filho_direita = filho_direita;
	}
	public String getNome_fase() {
		return nome_fase;
	}
	public void setNome_fase(String nome_fase) {
		this.nome_fase = nome_fase;
	}
	
}
