package br.com.treinamento.compras.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import lombok.Getter;

public class Pedido {
	
	public Pedido(Cliente cliente) {
		this.codigo = ++contador;
		this.cliente = cliente;
	}

	private static Integer contador = 0;
	
	@Getter 
	private Integer codigo;
	
	@Getter 
	private Cliente cliente;
	
	@Getter
	private List<ItemPedido> itensPedido = new ArrayList<ItemPedido>();
	
	@Getter
	private BigDecimal totalPedido = BigDecimal.ZERO;

	public void adicionarItem(ItemPedido itemPedido) {
		this.itensPedido.add(itemPedido);	
		calcularValor(itemPedido);
	}	
	
	void calcularValor(ItemPedido itemPedido) {
		totalPedido = totalPedido.add(itemPedido.getValorTotal());
		//Valor total do pedido será: O valor que já tinha no carrinho + o valor do novo item		
	}
}
