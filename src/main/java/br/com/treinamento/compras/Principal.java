package br.com.treinamento.compras;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.com.treinamento.compras.model.Cliente;
import br.com.treinamento.compras.model.Pedido;
import br.com.treinamento.compras.model.Produto;
import br.com.treinamento.compras.service.ClienteService;
import br.com.treinamento.compras.service.PedidoService;
import br.com.treinamento.compras.service.ProdutoService;
import br.com.treinamento.compras.service.SistemaService;

public class Principal {

	public static Scanner scanner = new Scanner(System.in);
	public static List<Cliente> clienteList = new ArrayList<Cliente>();
	public static List<Produto> produtoList = new ArrayList<Produto>();
	public static List<Pedido> pedidoList = new ArrayList<Pedido>();

	public static void main(String[] args) {

		while (true) {

			SistemaService.exibirMenu();

			System.out.print("Informe uma opção: ");
			Integer opcao = scanner.nextInt();
			scanner.nextLine();

			switch (opcao) {

			case 1: {
				ClienteService.cadastrarCliente();
				break;
			}
			case 2: {
				ClienteService.listarClientes();
				break;
			}
			case 3: {
				ProdutoService.cadastrarProduto();
				break;
			}
			case 4: {
				ProdutoService.listarProduto();
				break;
			}
			case 5: {
				PedidoService.criarPedido();
				break;
			}
			case 6: {
				PedidoService.listarPedido();
				break;
			}
			case 7: {
				PedidoService.detalharPedido();
				break;
			}
			case 8: {
				scanner.close();
				System.out.println("Saindo do programa...");
				System.exit(0);
			}
			default:
				System.out.println("Opção inválida.Tente novamente");
			}

		}

	}

}
