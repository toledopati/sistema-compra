package br.com.treinamento.compras.service;

import java.math.BigDecimal;

import br.com.treinamento.compras.Principal;
import br.com.treinamento.compras.model.Produto;

public class ProdutoService {

	public static void cadastrarProduto() {

		System.out.println("\n___Cadastrar Produto___");

		Integer codigo = SistemaService.validaCodigo("produto");
		Boolean codigoDuplicado = codigoDuplicadoProduto(codigo);

		if (codigoDuplicado) {
			return;
		}

		System.out.print("Nome: ");
		String nome = Principal.scanner.nextLine();

		System.out.print("Preço: ");
		//String precoString = Principal.scanner.nextLine().replace("," , ".");
		//BigDecimal preco = new BigDecimal(precoString);
		BigDecimal preco = Principal.scanner.nextBigDecimal();
		Principal.scanner.nextLine();

		Principal.produtoList.add(new Produto(codigo, nome, preco));
		System.out.print("\nProduto cadastrado com sucesso! \nPressione enter para continuar");
		Principal.scanner.nextLine();
	
	}
				
	public static boolean codigoDuplicadoProduto(Integer codigo) {
		boolean codigoDuplicado = false;

		for (Produto produto : Principal.produtoList) {

			if (produto.getCodigo().equals(codigo)) {
				System.out.println("Erro: Já existe um produto com esse cógido. Tente novamente, por favor!");
				codigoDuplicado = true; // código existente
				break;
			}

		}
		return codigoDuplicado;
	}
		
	public static void listarProduto() {
		System.out.println("\n____LISTA DE PRODUTO____\n");
		System.out.printf("%-10S %-25S %-25S \n", "Código", "Nome", "Preço");

		Principal.produtoList.forEach(produto -> {
		System.out.printf("%-10d %-25s %-25s \n",produto.getCodigo(), produto.getNome(),produto.getPreco());
		});

		System.out.println("\nFim da lista \nPressione enter para continuar");
		Principal.scanner.nextLine();
	}

	public static Produto buscarProduto() {
		
		Produto produtoPedido = null;

		while (produtoPedido==null) {

			// verifica se o código é um numero
			Integer codigoProduto = SistemaService.validaCodigo("produto");

			for (Produto produto : Principal.produtoList) {

				if (produto.getCodigo().equals(codigoProduto)) {
					produtoPedido = produto;
					break;
				}
			}
			
			if (produtoPedido == null) {
				System.out.println("Cliente não encontrado.");
			}
		}
		
		return produtoPedido;

	}
	
}
	
