package DTO;

public class Competicao {
	
	private int id;
	private String nome;
	private String descricao;
	private int quant_times;
	private String premiacao;
	private String esporte;
	
	public Competicao() {
		
	}
	
	public Competicao(int id, String nome, String descricao, int quantidade_times, String premiacao, String esporte) {
		
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.quant_times = quantidade_times;
		this.premiacao = premiacao;
		this.esporte = esporte;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public int getQuant_times() {
		return quant_times;
	}
	public void setQuant_times(int quant_times) {
		this.quant_times = quant_times;
	}
	public String getPremiacao() {
		return premiacao;
	}
	public void setPremiacao(String premiacao) {
		this.premiacao = premiacao;
	}
	public String getEsporte() {
		return esporte;
	}
	public void setEsporte(String esporte) {
		this.esporte = esporte;
	}
	
	@Override
	public String toString() {
		return id +" / "+ nome +" / "+ quant_times +" / "+ esporte +" / "+ premiacao + " / " + descricao;
	}
}
