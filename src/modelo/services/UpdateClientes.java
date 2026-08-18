package modelo.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import modelo.mainexceptions.CadastradorExceptions;

public class UpdateClientes {
	public static void update(int conf, int id, Scanner sc, Connection conn) throws CadastradorExceptions{
		try {
			if(conf == 1) {
				String sql = "update infoCliente set email = ? where id = ?;";
				PreparedStatement ps = conn.prepareStatement(sql);
				System.out.print("Novo Email: ");
				String email = sc.next().strip();
				ps.setString(1, email);
				ps.setInt(2, id);
				ps.execute();
				ps.close();
			}
			else if(conf == 2) {
				String sql = "update infocliente set nome = ? where id = ?;";
				PreparedStatement ps = conn.prepareStatement(sql);
				System.out.print("Novo Nome: ");
				String nome = sc.nextLine().strip();
				ps.setString(1, nome);
				ps.setInt(2, id);
				ps.execute();
				ps.close();
			}
			else if(conf == 3) {
				String sql = "update infocliente set idade = ? where id = ?;";
				PreparedStatement ps = conn.prepareStatement(sql);
				System.out.println("Nova Idade: ");
				int idade = sc.nextInt();
				ps.setInt(1, idade);
				ps.setInt(2, id);
				ps.execute();
				ps.close();
			}
			
		}catch(SQLException e) {
			throw new CadastradorExceptions("Error:" + e.getMessage());
		}
	}
}