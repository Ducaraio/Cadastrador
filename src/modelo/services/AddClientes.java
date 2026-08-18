package modelo.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import modelo.entidades.Clientes;
import modelo.mainexceptions.CadastradorExceptions;

public class AddClientes {
	public static void Adicionar(Connection conn, Clientes c) throws CadastradorExceptions {
		try {
			String sql = "insert into infocliente (email, nome, idade) values (?, ?, ?);";
			PreparedStatement add = conn.prepareStatement(sql);
			add.setString(1, c.getEmail());
			add.setString(2, c.getNome());
			add.setInt(3, c.getIdade());
			add.execute();
			add.close();
					
			}catch(SQLException e){
				throw new CadastradorExceptions("Error:" + e.getMessage());
			}
		}
}

