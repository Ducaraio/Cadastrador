package modelo.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Set;

import modelo.entidades.Clientes;

public class DeleteCliente {
	
	private static String senha = "Bsb/!@#";
	
	public static void delete(int id, Connection conn, String senhaConf, Set<Clientes> cliente) {
		try {
			if(senhaConf.equals(senha)) {
				String sql = "delete from infocliente where id = ?;";
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setInt(1, id);
				ps.execute();
				cliente.removeIf(x -> x.getId() == id);
				System.out.println("--".repeat(10));
				System.out.println("Cliente deletado com sucesso.");
				System.out.println("--".repeat(10));
				ps.close();
			} 
			else {
				System.out.println("--".repeat(10));
				System.out.println("Senha inválida.");
				System.out.println("--".repeat(10));
			}
		}
		catch(SQLException e) {
			System.out.println("Error: " + e.getMessage());
		}
	}
}
