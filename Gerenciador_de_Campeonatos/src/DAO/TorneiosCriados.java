package DAO;

import java.sql.*;

import Conexao.ConectandoJavaBD;

public class TorneiosCriados {
	
	public void torneiosCriadosPorUsuario(int id_usuario, int id_competicao) {
		
		try {
			
			Connection connection = ConectandoJavaBD.getInstance().getConnection();
			
			String sql = "INSERT INTO torneios_criados(usuario_id, id_competicao) VALUES (?,?)";
			
			PreparedStatement statement = connection.prepareStatement(sql);
			
			statement.setInt(1, id_usuario);
			statement.setInt(2, id_competicao);
			
			statement.execute();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
