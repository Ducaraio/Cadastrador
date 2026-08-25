package modelo.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import modelo.mainexceptions.CadastradorExceptions;

public class Conexao {
	private static Connection conn;

	public static Connection novaConnection() throws CadastradorExceptions {
		try {
			if (conn == null) {
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Cliente", "developer", "1234567");
			}
		} catch (SQLException e) {
			throw new CadastradorExceptions("Error:" + e.getMessage());
		}
		return conn;
	}

	public static void finishConnection() throws CadastradorExceptions {
		try {
			if (conn != null) {
				conn.close();
				System.out.println("--".repeat(10));
				System.out.println("Conexão encerrada com sucesso.");
			}
		} catch (SQLException e) {
			throw new CadastradorExceptions("Error: " + e.getMessage());
		}
	}
}
