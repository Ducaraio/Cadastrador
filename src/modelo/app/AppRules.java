package modelo.app;

import java.util.Scanner;

public class AppRules {
	
	public static int optionRule(int option, Scanner sc) {
		if(option < 0 || option > 4) {
			while(option < 0 || option > 4){
				System.out.print("opção inválida. Tente novamente(1), (2) , (3), (4) ou (0): ");
				option = sc.nextInt();
			}
			return option;
		}else 
			return option;
	}
	
	
	
	public static int optionRuleCase1(int option, Scanner sc) {
		if(option != 0 && option != 1 && option != 5) {
			while(option != 0 && option != 1 && option != 5){
				System.out.print("opção inválida. Tente novamente(1), (5) ou (0): ");
				option = sc.nextInt();
			}
			return option;
		}else 
			return option;
	}
	
	
	
	public static int confCase2(int conf, Scanner sc) {
		if(conf < 1 || conf >3) {
			while(conf < 1 && conf >3) {
				System.out.println();
				System.out.print("Opção inválida. Tente (1), (2), (3): ");
				conf = sc.nextInt();
			}
			return conf;
		}
		return conf;
	}
	
	
	public static int optionRuleCase3and4(int opt, Scanner sc){
		if(opt != 0  && opt != 5) {
			while(opt != 0 && opt == 5) {
				System.out.println();
				System.out.print("Opção inválida. Tente (0), (5): ");
				opt = sc.nextInt();
			}
			return opt;
		}
		return opt;
	}
	
	public static int optionRuleCase2(int option, Scanner sc) {
		if(option != 0 && option != 2 && option != 5) {
			while(option != 0 && option != 2 && option != 5){
				System.out.print("opção inválida. Tente (2), (5) ou (0): ");
				option = sc.nextInt();
			}
			return option;
		}else 
			return option;
	}
	
	public static void nextPage() {
		for(int i = 0; i < 100; i++) {
			System.out.println();
		}
	}
}
