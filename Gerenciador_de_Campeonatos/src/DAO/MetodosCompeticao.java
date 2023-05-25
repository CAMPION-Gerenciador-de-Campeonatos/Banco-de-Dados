package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

import DTO.*;
import Conexao.*;

public class MetodosCompeticao {

	public void criarCompeticao(Competicao competicao) {
		
		try{
			Connection connection = ConectandoJavaBD.getInstance().getConnection();
			
			String sql = "INSERT INTO competicao (nome, descricao, qtd_times, premiacao, esporte) VALUES (?,?,?,?,?)";
			PreparedStatement statement = connection.prepareStatement(sql);
			
			statement.setString(1, competicao.getNome());
			statement.setString(2, competicao.getDescricao());
			statement.setInt(3, competicao.getQuant_times());
			statement.setString(4, competicao.getPremiacao());
			statement.setString(5, competicao.getEsporte());
			
			statement.execute();
			
			System.out.println("Competicao inserida com sucesso!");
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<Competicao> listarCompeticao() {
		List<Competicao> competicao = new ArrayList<>();

		try {
			Connection connection = ConectandoJavaBD.getInstance().getConnection();
			String sql = "SELECT * FROM competicao";
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery(sql);

			while (resultSet.next()) {
				int id = resultSet.getInt("ID");
				String nome = resultSet.getString("NOME");
				String descricao = resultSet.getString("DESCRICAO");
				int quantidade_times = resultSet.getInt("QTD_TIMES");
				String premiacao = resultSet.getString("PREMIACAO");
				String esporte = resultSet.getString("ESPORTE");

				Competicao Competicao = new Competicao(id, nome, descricao, quantidade_times, premiacao, esporte);
				competicao.add(Competicao);
			}

			resultSet.close();
			statement.close();
			connection.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		for (Competicao Competicao : competicao) {
			System.out.println(Competicao.toString());
		}

		return competicao;
	}
	
	public void editarNomeCompeticao(String nome_atual, String nome_editado) {

		try {

			Connection connection = ConectandoJavaBD.getInstance().getConnection();

			String sql = "UPDATE competicao SET nome = ? WHERE nome = ?";

			PreparedStatement statement = connection.prepareStatement(sql);

			statement.setString(1, nome_editado);
			statement.setString(2, nome_atual);

			statement.execute();

			System.out.println("Nome da competicao editada com sucesso!");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public void editarDescricaoCompeticao(String nome_atual, String descricao_atualizada) {

		try {

			Connection connection = ConectandoJavaBD.getInstance().getConnection();

			String sql = "UPDATE competicao SET descricao = ? WHERE nome = ?";

			PreparedStatement statement = connection.prepareStatement(sql);

			statement.setString(1, descricao_atualizada);
			statement.setString(2, nome_atual);

			statement.execute();

			System.out.println("Descricao da competicao editada com sucesso!");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public void editarQuantidadeTimesCompeticao(String nome_atual, int quantidade_times) {

		try {

			Connection connection = ConectandoJavaBD.getInstance().getConnection();

			String sql = "UPDATE competicao SET qtd_times = ? WHERE nome = ?";

			PreparedStatement statement = connection.prepareStatement(sql);

			statement.setInt(1, quantidade_times);
			statement.setString(2, nome_atual);

			statement.execute();

			System.out.println("Quantidade de times atualizada com sucesso!");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public void editarPremiaçãoCompeticao(String nome_atual, String premiação_editada) {

		try {

			Connection connection = ConectandoJavaBD.getInstance().getConnection();

			String sql = "UPDATE competicao SET premiacao = ? WHERE nome = ?";

			PreparedStatement statement = connection.prepareStatement(sql);

			statement.setString(1, premiação_editada);
			statement.setString(2, nome_atual);

			statement.execute();

			System.out.println("Premiação atualizada com sucesso!");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public void editarEsporteCompeticao(String nome_atual, String esporte_editado) {

		try {

			Connection connection = ConectandoJavaBD.getInstance().getConnection();

			String sql = "UPDATE competicao SET esporte = ? WHERE nome = ?";

			PreparedStatement statement = connection.prepareStatement(sql);

			statement.setString(1, esporte_editado);
			statement.setString(2, nome_atual);

			statement.execute();

			System.out.println("Esporte atualizado com sucesso!");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public void atualizarTudoCompeticao(String nome_atual, String nome_editado, String descricao_atualizada, int quantidade_times, String premiação_editada, String esporte_editado) {
	
		try {

			Connection connection = ConectandoJavaBD.getInstance().getConnection();

			String sql = "UPDATE competicao SET nome = ?, descricao = ?, quantidade_times = ?, premiacao = ?, esporte = ? WHERE nome = ?";

			PreparedStatement statement = connection.prepareStatement(sql);

			statement.setString(1, nome_editado);
			statement.setString(2, descricao_atualizada);
			statement.setInt(3, quantidade_times);
			statement.setString(4, premiação_editada);
			statement.setString(5, esporte_editado);
			statement.setString(6, nome_atual);
			
			statement.execute();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void removerCompeticao(int id) {
		String sql = "DELETE FROM competicao WHERE id = ?";
		try (Connection connec = ConectandoJavaBD.getInstance().getConnection();
				PreparedStatement stat = connec.prepareStatement(sql)) {

			stat.setInt(1, id);
			stat.executeUpdate();

			System.out.println("Competição excluída.");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
}
