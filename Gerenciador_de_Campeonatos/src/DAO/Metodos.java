package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import DTO.*;
import Conexao.*;

public class Metodos {

	private Usuario usuarioLogado;

	public Usuario getUsuarioLogado() {
		return usuarioLogado;
	}

	public void setUsuarioLogado(Usuario usuarioLogado) {
		this.usuarioLogado = usuarioLogado;
	}

	public void criarConta(Usuario usuario) {

		if (emailJaCadastrado(usuario.getEmail())) {
			System.out.println("Email já cadastrado.");
		} else {
			try {

				Connection connection = ConectandoJavaBD.getInstance().getConnection();

				String sql = "INSERT INTO USUARIOS(NOME_COMPLETO, EMAIL, SENHA, AVATAR) VALUES (?, ?, ?, ?)";

				PreparedStatement statement = connection.prepareStatement(sql);

				statement.setString(1, usuario.getNomeCompleto());
				statement.setString(2, usuario.getEmail());
				statement.setString(3, usuario.getSenha());
				statement.setBytes(4, usuario.getAvatar());

				statement.execute();

				System.out.println("Usuário inserido com sucesso!");

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public Usuario fazerLogin(String email, String senha) {

		if (usuarioCadastrado(email, senha)) {
			String sql = "SELECT * FROM usuarios WHERE email = ? AND senha = ?";
			try (Connection connection = ConectandoJavaBD.getInstance().getConnection();
					PreparedStatement statement = connection.prepareStatement(sql)) {
				statement.setString(1, email);
				statement.setString(2, senha);

				try (ResultSet rs = statement.executeQuery()) {
					if (rs.next()) {
						Usuario usuario = new Usuario();
						usuario.setId(rs.getInt("id"));
						usuario.setNomeCompleto(rs.getString("nome_completo"));
						usuario.setEmail(rs.getString("email"));
						usuario.setSenha(rs.getString("senha"));
						usuarioLogado = usuario;

						System.out.println("Login efetuado com sucesso!");
						return usuario;

					} else {
						throw new Exception("Usuário não encontrado.");
					}
				} catch (Exception e) {
					throw new RuntimeException("Erro ao fazer login", e);
				}

			} catch (Exception i) {
				throw new RuntimeException("Erro ao fazer login", i);
			}

		} else {
			System.out.println("Usuario não está cadastrado.");
			return null;
		}
	}

	public void fazerLogout() {
		if (usuarioLogado != null) {
			System.out.println("Logout efetuado com sucesso!");
			usuarioLogado.setLogado(false);
			usuarioLogado = null;
		} else {
			System.out.println("Nenhum usuário está logado.");
		}
	}

	public void editarNomeUsuario(String nome_atualizado) {

		String sql = "UPDATE usuarios SET nome_completo = ? WHERE id = ?";
		try (Connection connec = ConectandoJavaBD.getInstance().getConnection();
				PreparedStatement stat = connec.prepareStatement(sql)) {

			stat.setString(1, nome_atualizado);
			stat.setInt(2, usuarioLogado.getId());

			int result = stat.executeUpdate();
			System.out.println("Nome de usuário atualizado");

		} catch (Exception i) {
			throw new RuntimeException("Erro ao conectar ao banco de dados.", i);
		}

	}

	public void editarEmail(String email_atualizado) {

		if (emailJaCadastrado(email_atualizado)) {
			System.out.println("Email já está cadastrado!");
		} else {
			String sql = "UPDATE usuarios SET email = ? WHERE id = ?";
			try (Connection connec = ConectandoJavaBD.getInstance().getConnection();
					PreparedStatement stat = connec.prepareStatement(sql)) {

				stat.setString(1, email_atualizado);
				stat.setInt(2, usuarioLogado.getId());

				int result = stat.executeUpdate();
				System.out.println("Email atualizado!");

			} catch (Exception i) {
				throw new RuntimeException("Erro ao conectar ao banco de dados.", i);
			}
		}

	}

	public void editarSenha(String senha_atualizada) {

		if (senha_atualizada.length() < 8) {
			System.out.println("Senha inválida! Digite uma senha maior.");
		} else {
			String sql = "UPDATE usuarios SET senha = ? WHERE id = ?";
			try (Connection connec = ConectandoJavaBD.getInstance().getConnection();
					PreparedStatement stat = connec.prepareStatement(sql)) {

				stat.setString(1, senha_atualizada);
				stat.setInt(2, usuarioLogado.getId());

				int result = stat.executeUpdate();
				System.out.println("Senha atualizada!");

			} catch (Exception i) {
				throw new RuntimeException("Erro ao conectar ao banco de dados.", i);
			}
		}
	}

	public boolean emailJaCadastrado(String email) {

		String sql = "SELECT COUNT(*) FROM usuarios WHERE email = ?";
		try (Connection con = ConectandoJavaBD.getInstance().getConnection();
				PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setString(1, email);

			try (ResultSet rs = ps.executeQuery()) {
				rs.next();
				int count = rs.getInt(1);
				return count > 0;

			} catch (Exception e) {
				throw new RuntimeException("Falha ao verificar se o email já está cadastrado", e);
			}

		} catch (Exception i) {
			throw new RuntimeException("Erro ao verificar se email já está cadastrado", i);
		}

	}

	public boolean usuarioCadastrado(String email, String senha) {

		String sql = "SELECT * FROM usuarios WHERE email=? AND senha=?";

		try (Connection connection = ConectandoJavaBD.getInstance().getConnection();
				PreparedStatement statement = connection.prepareStatement(sql)) {

			statement.setString(1, email);
			statement.setString(2, senha);

			try (ResultSet rs = statement.executeQuery()) {
				return rs.next();
			}

		} catch (Exception e) {
			throw new RuntimeException("Erro ao buscar usuário no banco de dados", e);
		}
	}

}
