package modelo.entidades;

import java.util.Objects;

public class Clientes {
	private Integer id;
	private String email;
	private String nome;
	private int idade;
	
	public Clientes(Integer id, String email, String nome, int idade) {
		this.id = id;
		this.email = email;
		this.nome = nome;
		this.idade = idade;
	}

	public Clientes(String email, String nome, int idade) {
		this.email = email;
		this.nome = nome;
		this.idade = idade;
	}
	
	public Clientes(Integer id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	@Override
	public int hashCode() {
		return Objects.hash(email, id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Clientes other = (Clientes) obj;
		return Objects.equals(email, other.email) && Objects.equals(id, other.id);
	}

	
	
}
