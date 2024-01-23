package br.com.treinamento.compras.model;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;

public class ItemPedido {
	
	
	public ItemPedido(Produto produto, Integer quantidade) {
		this.produto = produto;
		this.quantidade = quantidade;
		this.valorUnitario = produto.getPreco();
		calcularValorTotal();
	
	}

	@Getter @Setter
	private Produto produto;

	@Getter @Setter
	private Integer quantidade;
	
	@Getter @Setter
	private BigDecimal valorUnitario;
	
	@Getter @Setter
	private BigDecimal valorTotal;
	
	
	private void calcularValorTotal() {
		this.valorTotal = valorUnitario.multiply(new BigDecimal(quantidade));
	}
		
	
	
}
