package br.com.treinamento.compras.service;

import br.com.treinamento.compras.Principal;
import br.com.treinamento.compras.model.Cliente;

public class ClienteService {

	public static void cadastrarCliente() {

		System.out.println("\n___Cadastrar cliente___");

		Integer codigo = SistemaService.validaCodigo("cliente");
		Boolean codigoDuplicado = codigoDuplicadoCliente(codigo);
		
		if (codigoDuplicado) {
			return;
		}

		System.out.print("Nome: ");
		String nome = Principal.scanner.nextLine();

		System.out.print("Email: ");
		String email = Principal.scanner.nextLine();

		Principal.clienteList.add(new Cliente(codigo, nome, email));
		System.out.println("\nCliente cadastrado com sucesso! \nPressione enter para continuar");
		Principal.scanner.nextLine();
	}

	// Verifica e repete o cógido caso já exista
	public static boolean codigoDuplicadoCliente(Integer codigo) {

		boolean codigoDuplicado = false;
		for (Cliente cliente : Principal.clienteList) {

			if (cliente.getCodigo().equals(codigo)) {
				System.out.println("Erro: Já existe um cliente com o código " + codigo + ". Tente novamente, por favor!");
				codigoDuplicado = true; // código existente
				break;
			}
	
		}
		return codigoDuplicado;
	}

	public static void listarClientes() {
		System.out.println("\n____LISTA DE CLIENTE_____\n");
		System.out.printf("%-10S %-25S %-25S \n", "Código", "Nome", "Email");

		Principal.clienteList.forEach(cliente -> {
			System.out.printf("%-10d %-25s %-25s \n",cliente.getCodigo(), cliente.getNome(), cliente.getEmail());
		});

		System.out.println("\nFim da lista \nPressione enter para continuar");
		Principal.scanner.nextLine();
	}

	public static Cliente buscarCliente() {

		Cliente clientePedido = null;

		while (clientePedido==null) {

			// verifica se o código é um numero
			Integer codigoCliente = SistemaService.validaCodigo("cliente");

			for (Cliente cliente : Principal.clienteList) {

				if (cliente.getCodigo().equals(codigoCliente)) {
					clientePedido = cliente;
					break;
				}
			}
			
			if (clientePedido == null) {
				System.out.println("Cliente não encontrado.");
			}
		}
		
		return clientePedido;
	}
}
