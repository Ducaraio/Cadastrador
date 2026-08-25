package modelo.interfaces;

import java.util.Set;

import modelo.mainexceptions.CadastradorExceptions;

public interface jdbcCadastrador<T>{
	public  Set<T> check()throws CadastradorExceptions;
	public void adicionar(T t)throws CadastradorExceptions;
	public void remover(int id, Set<T> t, String senha)throws CadastradorExceptions;
}	
