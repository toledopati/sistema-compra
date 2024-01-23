package br.com.treinamento.compras.service;

import br.com.treinamento.compras.Principal;
import br.com.treinamento.compras.model.Cliente;
import br.com.treinamento.compras.model.ItemPedido;
import br.com.treinamento.compras.model.Pedido;
import br.com.treinamento.compras.model.Produto;

public class PedidoService {

	public static void criarPedido() {
		
		System.out.println("\n___Criar Pedido___");
		
		Cliente clientePedido = ClienteService.buscarCliente();
		System.out.println("Cliente: "+clientePedido.getNome());
		
		Pedido pedido = new Pedido(clientePedido);
		
		String resposta = "S";
		while(resposta.equalsIgnoreCase("S")) {
			
			Produto produto = ProdutoService.buscarProduto();
			System.out.println("Produto: "+produto.getNome() + " - Valor Total: R$" + produto.getPreco());
	
			System.out.print("\nInforme a quantidade: ");
			Integer quantidade = Principal.scanner.nextInt();
			Principal.scanner.nextLine();
			
			ItemPedido novoItem = new ItemPedido(produto, quantidade);
			pedido.adicionarItem(novoItem);
			
			System.out.print("\nDeseja inserir mais itens na compra? (S/N): ");
			resposta = Principal.scanner.nextLine();
			
		}	
		
		Principal.pedidoList.add(pedido);
		System.out.println("\nPedido criado com sucesso! \nValor total: R$" + pedido.getTotalPedido());
		
		System.out.println("\nPressione enter para continuar...");
		Principal.scanner.nextLine();
	}
	
	public static void listarPedido() {
		System.out.println("\n____LISTA DE PEDIDO____\n");
		
		System.out.printf("%-10S %-25S %-25S \n", "Código", "Cliente", "Valor Total");
		
		Principal.pedidoList.forEach(pedido -> {
			System.out.printf("%-10s %-25s %-25s \n",pedido.getCodigo(),pedido.getCliente().getNome(), pedido.getTotalPedido());
		});

		System.out.println("\nFim da lista \nPressione enter para continuar");
		Principal.scanner.nextLine();
	}

	public static Pedido buscarPedido() {
		
		Pedido pedidoEncontrado = null;

		while (pedidoEncontrado==null) {

			// verifica se o código é um numero
			Integer codigoPedido = SistemaService.validaCodigo("pedido");
			//para cada pedido da lista
			for (Pedido pedido : Principal.pedidoList) {

				if (pedido.getCodigo().equals(codigoPedido)) {
					pedidoEncontrado = pedido;
					break;
					
				}
			}
			
			if (pedidoEncontrado == null) {
				System.out.println("Pedido não encontrado.");
			}
		}
		
		return pedidoEncontrado;

	}

	public static void detalharPedido() {
		
		Pedido pedidoEncontrado = buscarPedido();
	
		System.out.println("\nNúmero do pedido: " + pedidoEncontrado.getCodigo());
		
		System.out.println("Cliente: " + pedidoEncontrado.getCliente().getNome());
		System.out.println("Valor total: R$" + pedidoEncontrado.getTotalPedido());
		System.out.println("\n___Itens do Pedido___\n");
		System.out.printf("%-10S %-20S %-20S %-20S %-20S\n", "Código", "Produto", "Valor Unitário", "Qtd.", "Valor Total");
		
		//size sabe a quantidade de itens que tem na lista 
		for (int contador = 0; contador < pedidoEncontrado.getItensPedido().size(); contador++) {
			
			ItemPedido item = pedidoEncontrado.getItensPedido().get(contador); //pegar um item por vez da lista
			
			System.out.printf("%-10d %-20s %-20s %-20s %-20s \n", contador + 1, item.getProduto().getNome(), item.getValorUnitario(), item.getQuantidade(), item.getValorTotal());
		}
		
		System.out.println("\n\nFim da lista \nPressione enter para continuar");
		Principal.scanner.nextLine();
	}
}
