package DTO;

public class Usuario {

	private int id;
	private String nomeCompleto;
	private String email;
	private String senha;
	private String caminho_avatar;
	private boolean logado;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		if (!email.contains("@")) {
			throw new IllegalArgumentException("O email deve ser válido");
		}
		this.email = email;
	}
	
	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		if (senha.length() < 8) {
			throw new IllegalArgumentException("A senha deve ter no mínimo 8 caracteres");
		}
		this.senha = senha;
	}

	public String getAvatar() {
        return caminho_avatar;
    }

    public void setAvatar(String caminhoAvatar) {
        this.caminho_avatar = caminhoAvatar;
    }
	
	public boolean isLogado() {
		return logado;
	}

	public void setLogado(boolean logado) {
		this.logado = logado;
	}

	@Override
	public String toString() {
		return getId() + " " + getNomeCompleto() + " " + getEmail() + " " + getAvatar();
	}
}
