package br.com.treinamento.compras.service;

import br.com.treinamento.compras.Principal;

public class SistemaService {

	
	public static void exibirMenu() {
		System.out.println("\n");
		System.out.println("_____SISTEMA DE COMPRAS______");
		System.out.println("\n");
		System.out.println("(1) CADASTRAR CLIENTE");
		System.out.println("(2) LISTAR CLIENTES");
		System.out.println("(3) CADASTRAR PRODUTO");
		System.out.println("(4) LISTAR PRODUTO");
		System.out.println("(5) CRIAR PEDIDO");
		System.out.println("(6) LISTAR PEDIDO");
		System.out.println("(7) DETALHAR COMPRA");
		System.out.println("(8) SAIR");
		System.out.println("\n");
		
		
	}

	public static Integer validaCodigo(String tipoCogido) {
		
		Integer codigo = null;
		
		while (codigo == null) { // !codigoValido | ! = não
			
			//o código digitado é válido? É um número?
			try {
				System.out.print("\nCódigo " +tipoCogido+": ");
				codigo = Principal.scanner.nextInt();
				Principal.scanner.nextLine();
			}
			catch (Exception e) {
				System.out.println("Código inválido, informe um número inteiro");
				Principal.scanner.nextLine();
			}	
		}
		return codigo;
	}
	
	
}
