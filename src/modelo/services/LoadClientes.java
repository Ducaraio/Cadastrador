package modelo.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Set;

import modelo.entidades.Clientes;
import modelo.mainexceptions.CadastradorExceptions;

public class LoadClientes {
	public static void load(Set<Clientes> cliente, Connection conn) throws CadastradorExceptions{
		try {
			String sql = "select id, email, nome, idade from infoCliente;";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				cliente.add(new Clientes(rs.getInt("id"), rs.getString("email"), rs.getString("nome"), rs.getInt("idade")));
			}
			ps.close();
			rs.close();
		}
		catch(SQLException e){
			throw new CadastradorExceptions("Error:" + e.getMessage());
		}
	}
}
