package modelo.app;


import java.sql.Connection;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import modelo.conexao.Conexao;
import modelo.entidades.Clientes;
import modelo.mainexceptions.CadastradorExceptions;
import modelo.services.crudClientes;

public class Programa {
	public static void main(String[]args) {
		Scanner sc = new Scanner(System.in);
		Set<Clientes> cliente = new HashSet<>();
		
		System.out.println("-----KADASTRER-----");
		System.out.println("(1) cadastrar novo cliente");
		System.out.println("(2) Atualizar dados do cliente");
		System.out.println("(3) Visualizar clientes cadastrados");
		System.out.println("(4) Deletar cliente cadastrado");
		System.out.println("(0) Sair");
		System.out.println("--".repeat(10));
		System.out.print("Opção: ");
		int opt = sc.nextInt();
		opt = AppRules.optionRule(opt, sc);
		System.out.println("\n".repeat(2));
		
		try {
			Connection conn = Conexao.novaConnection();
			crudClientes cc = new crudClientes(conn);
			while(opt != 0) {
				sc.nextLine();
				switch(opt) {
				case 1:
					AppRules.nextPage();
					System.out.println("==".repeat(10));
					System.out.println("Cadastro de Cliente");
					System.out.println("==".repeat(10));
					System.out.println();
					System.out.print("Email: ");
					String email = sc.nextLine().strip();
					System.out.print("Nome: ");
					String nome = sc.nextLine();
					System.out.print("Idade: ");
					int idade = sc.nextInt();
					Clientes addC = new Clientes(email, nome, idade);
					cc.adicionar(addC);
					System.out.println("--".repeat(10));
					System.out.println("Cliente adicionado.");
					System.out.println("--".repeat(10));
					System.out.println();
					System.out.println("(5) Menu Principal \n" + "(1) Adicionar outro cliente \n" + "(0) Sair");
					System.out.print("Opção: ");
					opt = sc.nextInt();
					opt = AppRules.optionRuleCase1(opt, sc);
					break;
					
				case 2:
					AppRules.nextPage();
					System.out.println("==".repeat(10));
					System.out.println("Update Clientes");
					System.out.println("==".repeat(10));
					System.out.println();
					System.out.print("Id do cliente: ");
					int id = sc.nextInt();
					sc.nextLine();
					System.out.println("Qual atributo deseja alterar?");
					System.out.println("(1) Email\n(2) Nome\n(3) Idade");
					System.out.println("Opção: ");
					int conf = sc.nextInt();
					conf = AppRules.confCase2(conf, sc);
					sc.nextLine();
					cc.updateClientes(conf, id, sc);
					System.out.println();
					System.out.println("--".repeat(10));
					System.out.println("Informações atualizadas.");
					System.out.println("--".repeat(10));
					System.out.println();
					System.out.println("(5) Menu Principal \n" + "(2) Nova Alteração \n" + "(0) Sair");
					System.out.print("Opção: ");
					opt = sc.nextInt();
					opt = AppRules.optionRuleCase2(opt, sc);
					break;
					
				case 3:
					AppRules.nextPage();
					System.out.println("==".repeat(10));
					System.out.println("Clientes Cadastrados");
					System.out.println("==".repeat(10));
					System.out.println();
					cliente = cc.check();
					System.out.println();
					System.out.println("(5) Menu Principal \n" + "(0) Sair");
					System.out.print("Opção: ");
					opt = sc.nextInt();
					opt = AppRules.optionRuleCase3and4(opt, sc);
					break;
					
				case 4:
					AppRules.nextPage();
					System.out.println("==".repeat(10));
					System.out.println("Deletar Cliente");
					System.out.println("==".repeat(10));
					System.out.println();
					System.out.print("Id do cliente: ");
					id = sc.nextInt();
					sc.nextLine();
					System.out.print("Senha de confirmação: ");
					String senha = sc.next();
					cc.remover(id, cliente, senha);
					System.out.println();
					System.out.println("(5) Menu Principal \n" + "(0) Sair");
					System.out.print("Opção: ");
					opt = sc.nextInt();
					opt = AppRules.optionRuleCase3and4(opt, sc);
					break;
					
					
				case 5:
					AppRules.nextPage();
					System.out.println("-----KADASTRER---1--");
					System.out.println("(1) cadastrar novo cliente");
					System.out.println("(2) Atualizar dados do cliente");
					System.out.println("(3) Visualizar clientes cadastrados");
					System.out.println("(4) Deletar cliente cadastrado");
					System.out.println("(0) Sair");
					System.out.println("--".repeat(10));
					System.out.print("Opção: ");
					opt = sc.nextInt();
					opt = AppRules.optionRule(opt, sc);
					break;
				}
			}
			
		}catch(CadastradorExceptions e) {
			System.out.println(e.getMessage());
		}finally{
			try {
				Conexao.finishConnection();
			}
			catch(CadastradorExceptions e){
				System.out.println( e.getCause());
			}
			System.out.println("=_".repeat(10) + "=");
			System.out.println("Programa encerrado.");
			System.out.println("=_".repeat(10) + "=");
			sc.close();
		}
	}
}