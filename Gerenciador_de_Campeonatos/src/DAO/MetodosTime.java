package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

import DTO.*;
import Conexao.*;

public class MetodosTime {

	public void criarTime(Time time, int usuarioLogado) {

		try {

			Connection connection = ConectandoJavaBD.getInstance().getConnection();

			String sql = "INSERT INTO time(NOME, IMAGEM_ESCUDO, ABREVIACAO, ID_USUARIO) VALUES (?, ?, ?, ?)";

			PreparedStatement statement = connection.prepareStatement(sql);

			statement.setString(1, time.getNome());
			statement.setString(2, time.getImagem_escudo());
			statement.setString(3, time.getAbreviacao());
			statement.setInt(4, usuarioLogado);

			statement.execute();

			System.out.println("Time inserido com sucesso!");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<Time> listarTimes() {
		List<Time> times = new ArrayList<>();

		try {
			Connection connection = ConectandoJavaBD.getInstance().getConnection();
			String sql = "SELECT * FROM time";
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery(sql);

			while (resultSet.next()) {
				int id = resultSet.getInt("ID");
				String nome = resultSet.getString("NOME");
				String abreviacao = resultSet.getString("ABREVIACAO");
				String imagem_escudo = resultSet.getString("IMAGEM_ESCUDO");

				Time time = new Time(id, nome, abreviacao, imagem_escudo);
				times.add(time);
			}

			resultSet.close();
			statement.close();
			connection.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		for (Time time : times) {
			System.out.println(time.toString());
		}

		return times;
	}

	public void editarNomeTime(String nome_atual, String nome_editado) {

		try {

			Connection connection = ConectandoJavaBD.getInstance().getConnection();

			String sql = "UPDATE time SET nome = ? WHERE nome = ?";

			PreparedStatement statement = connection.prepareStatement(sql);

			statement.setString(1, nome_editado);
			statement.setString(2, nome_atual);

			statement.execute();

			System.out.println("Nome de time editado com sucesso!");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void editarImagemTime(String nome_atual, String caminho_imagem_atualizado) {

		try {

			Connection connection = ConectandoJavaBD.getInstance().getConnection();

			String sql = "UPDATE time SET imagem_escudo = ? WHERE nome = ?";

			PreparedStatement statement = connection.prepareStatement(sql);

			statement.setString(1, caminho_imagem_atualizado);
			statement.setString(2, nome_atual);

			statement.execute();

			System.out.println("Imagem do escudo do time editada com sucesso!");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void editarAbreviacaoTime(String nome_atual, String abreviacao_atualizada) {

		try {

			Connection connection = ConectandoJavaBD.getInstance().getConnection();

			String sql = "UPDATE time SET abreviacao = ? WHERE nome = ?";

			PreparedStatement statement = connection.prepareStatement(sql);

			statement.setString(1, abreviacao_atualizada);
			statement.setString(2, nome_atual);

			statement.execute();

			System.out.println("Abreviacao do time editada com sucesso!");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void editarTudoTime(String nome_atual, String nome_atualizado, String caminho_imagem_atualizado,
			String abreviacao_atualizada) {

		editarNomeTime(nome_atual, nome_atualizado);
		editarImagemTime(nome_atual, caminho_imagem_atualizado);
		editarAbreviacaoTime(nome_atual, abreviacao_atualizada);
	}

	public void removerTime(String nome) {
		String sql = "DELETE FROM time WHERE nome = ?";
		try (Connection connec = ConectandoJavaBD.getInstance().getConnection();
				PreparedStatement stat = connec.prepareStatement(sql)) {

			stat.setString(1, nome);
			stat.executeUpdate();

			System.out.println("Time excluído.");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
