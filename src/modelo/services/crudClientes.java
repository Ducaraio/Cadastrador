package modelo.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import modelo.entidades.Clientes;
import modelo.interfaces.jdbcClientes;
import modelo.mainexceptions.CadastradorExceptions;

public class crudClientes implements jdbcClientes {
	private Connection conn;
	private String senha = "Bsb/!@#";

	public crudClientes(Connection conn) {
		this.conn = conn;
	}

	@Override
	public Set<Clientes> check() throws CadastradorExceptions {
		String sql = "select id, email, nome, idade from infocliente";
		Set<Clientes> clientes = new HashSet<>();
		try (PreparedStatement ps = conn.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
			while (rs.next()) {
				clientes.add(
						new Clientes(rs.getInt("id"), rs.getString("email"), rs.getString("nome"), rs.getInt("idade")));
			}
			for (Clientes c : clientes) {
				System.out.println("ID: " + c.getId() + " | EMAIL: " + c.getEmail() + " | NOME: " + c.getNome()
						+ " | IDADE: " + c.getIdade());
			}
			return clientes;
		} catch (SQLException e) {
			throw new CadastradorExceptions("Error: ", e);
		}
	}

	@Override
	public void adicionar(Clientes t) throws CadastradorExceptions {
		String sql = "insert into infoCliente (email, nome, idade) values(? , ? , ?)";
		try (PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setString(1, t.getEmail());
			ps.setString(2, t.getNome());
			ps.setInt(3, t.getIdade());
			ps.execute();
		} catch (SQLException e) {
			throw new CadastradorExceptions("Error: ", e);
		}
	}

	@Override
	public void remover(int id, Set<Clientes> c, String senha) throws CadastradorExceptions {
		String sql = "delete from infoCliente where id = ?";
		if (senha.equals(this.senha)){
			try (PreparedStatement ps = conn.prepareStatement(sql)) {
				ps.setInt(1, id);
				ps.execute();
				c.removeIf(x -> x.getId() == id);
				System.out.println("--".repeat(10));
				System.out.println("Cliente deletado com sucesso.");
				System.out.println("--".repeat(10));
			}
			catch (SQLException e) {
				throw new CadastradorExceptions("error: ", e);
			}
		}
		else {
			System.out.println("--".repeat(10));
			System.out.println("Senha inválida.");
			System.out.println("--".repeat(10));
		}
	}

	@Override
	public void updateClientes(int conf, int id, Scanner sc) throws CadastradorExceptions {
		PreparedStatement ps = null;
		try {
			if (conf == 1) {
				String sql = "update infoCliente set email = ? where id = ?;";
				ps = conn.prepareStatement(sql);
				System.out.print("Novo Email: ");
				String email = sc.next().strip();
				if (email.isBlank() || email.length() < 10) {
					throw new CadastradorExceptions("Error: Email inválido.");
				}
				ps.setString(1, email);
				ps.setInt(2, id);
				ps.execute();
				ps.close();
			} else if (conf == 2) {
				String sql = "update infocliente set nome = ? where id = ?;";
				ps = conn.prepareStatement(sql);
				System.out.print("Novo Nome: ");
				String nome = sc.nextLine().strip();
				if (nome.isBlank() || nome.length() < 3) {
					throw new CadastradorExceptions("Error: Nome Inválido.");
				}
				ps.setString(1, nome);
				ps.setInt(2, id);
				ps.execute();
				ps.close();
			} else if (conf == 3) {
				String sql = "update infocliente set idade = ? where id = ?;";
				ps = conn.prepareStatement(sql);
				System.out.println("Nova Idade: ");
				int idade = sc.nextInt();
				if (idade < 0) {
					throw new CadastradorExceptions("Error: Idade Inválida.");
				}
				ps.setInt(1, idade);
				ps.setInt(2, id);
				ps.execute();
			}

		} catch (SQLException e) {
			throw new CadastradorExceptions("Error:", e);
		}finally {
			try {
				ps.close();
			}
			catch(SQLException e) {
				throw new CadastradorExceptions("Error: ", e);
			}
		}
	}
}