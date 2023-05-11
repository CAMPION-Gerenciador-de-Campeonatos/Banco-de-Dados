package DTO;

public class Time {

	private int id;
	private String nome;
	private byte[] imagem_escudo;
	private String abreviacao;

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

	public byte[] getImagem_escudo() {
		return imagem_escudo;
	}

	public void setImagem_escudo(byte[] imagem_escudo) {
		// Validação do avatar
		if (imagem_escudo.length == 0) {
			throw new IllegalArgumentException("A imagem deve ser selecionado");
		}
		this.imagem_escudo = imagem_escudo;
	}

	public String getAbreviacao() {
		return abreviacao;
	}

	public void setAbreviacao(String abreviacao) {
		this.abreviacao = abreviacao;
	}

}
