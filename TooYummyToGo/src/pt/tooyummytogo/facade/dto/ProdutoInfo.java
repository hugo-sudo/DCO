package pt.tooyummytogo.facade.dto;

import java.time.LocalDateTime;


import java.util.ArrayList;
import java.util.List;

import pt.tooyummytogo.classes.CatProdutos;
import pt.tooyummytogo.classes.CatComerciantes;
import pt.tooyummytogo.classes.Comerciante;
import pt.tooyummytogo.classes.Produto;

public class ProdutoInfo {
	
	private int quantidade;
	private int valor;
	private LocalDateTime data_inicio;
	private LocalDateTime data_fim;
	private String[] ingredientes;
	private String tipo;
	
	public ProdutoInfo (int quantidade,int valor, LocalDateTime data_inicio, LocalDateTime data_fim, String[] ingredientes, String tipo) {
		this.quantidade = quantidade;
		this.valor = valor;
		this.data_inicio = data_inicio;
		this.data_fim = data_fim;
		this.ingredientes = ingredientes;
		this.tipo = tipo;
	}
	
	public LocalDateTime getDataFim() {
		return data_fim;
	}

	public LocalDateTime getDataInicio() {
		return data_inicio;
	}

	public String[] getIngredientes() {
		return ingredientes;
	}
	
	public void setQuantidade (int quantidade) {
		this.quantidade = quantidade;
	}
	
	public int getQt() {
		return quantidade;
	}
	public int getValor() {
		return valor;
	}
	public String getTipo() {
		return tipo;
	}
	public boolean estaDisp(int qt) {
		if (quantidade >= qt) {
			return true;
		} else {
			return false;
		}
	}
	
}
