package Conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConectandoJavaBD {

	private static ConectandoJavaBD conexaoUtil;

	public static ConectandoJavaBD getInstance() {
		if (conexaoUtil == null) {
			conexaoUtil = new ConectandoJavaBD();
		}

		return conexaoUtil;
	}

	public Connection getConnection() throws ClassNotFoundException, SQLException {

		Class.forName("com.mysql.cj.jdbc.Driver");

		return DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/gerenciador_de_campeonatos", "root", "");
	}
	
	public static void main(String[] args) {
		
		try {
		System.out.println(getInstance().getConnection());
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
