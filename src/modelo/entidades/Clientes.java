package modelo.entidades;

import java.util.Objects;

import modelo.mainexceptions.CadastradorExceptions;

public class Clientes {
	private Integer id;
	private String email;
	private String nome;
	private int idade;
	
	public Clientes(Integer id, String email, String nome, int idade) throws CadastradorExceptions {
		this.id = id;
		this.setEmail(email);
		this.setNome(nome);
		this.setIdade(idade);
	}

	public Clientes(String email, String nome, int idade) throws CadastradorExceptions{
		this.setEmail(email);
		this.setNome(nome);
		this.setIdade(idade);
	}
	
	public Clientes(Integer id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) throws CadastradorExceptions {
		if(email.isBlank()) {
			throw new CadastradorExceptions("Error: Email inválido.");
		}
		this.email = email;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) throws CadastradorExceptions {
		if(nome.isBlank()) {
			throw new CadastradorExceptions("Error: Nome Inválido.");
		}
		this.nome = nome;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) throws CadastradorExceptions{
		if(idade < 0) {
			throw new CadastradorExceptions("Error: Idade Inválida.");
		}
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
