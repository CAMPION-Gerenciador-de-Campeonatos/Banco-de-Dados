package DTO;

public class Time {

	private int id;
	private String nome;
	private String imagem_escudo;
	private String abreviacao;
	
	public Time() {
		
	}

	public Time(int id, String nome, String abreviacao, String imagem_escudo){
		
		this.id = id;
		this.abreviacao = abreviacao;
		this.nome = nome;
		this.imagem_escudo = imagem_escudo;
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

	public String getImagem_escudo() {
        return imagem_escudo;
    }

    public void setImagem_escudo(String imagem_escudo) {
        this.imagem_escudo = imagem_escudo;
    }

	public String getAbreviacao() {
		return abreviacao;
	}

	public void setAbreviacao(String abreviacao) {
		this.abreviacao = abreviacao;
	}

	@Override
	public String toString() {
		return id +" / "+ nome +" / "+ abreviacao +" / "+ imagem_escudo;
	}
	
	

	
}
