package modelo.interfaces;

import java.util.Scanner;

import modelo.entidades.Clientes;
import modelo.mainexceptions.CadastradorExceptions;

public interface jdbcClientes extends  jdbcCadastrador<Clientes>{
	public void updateClientes(int conf, int id, Scanner sc) throws CadastradorExceptions;
}
