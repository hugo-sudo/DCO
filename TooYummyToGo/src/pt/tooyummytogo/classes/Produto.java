package pt.tooyummytogo.classes;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Produto {
	private int id;
	private int quantidade;
	private int valor;
	private LocalDateTime data_inicio;
	private LocalDateTime data_fim;
	private ArrayList<String> ingredientes = new ArrayList<String>();
	private String tipo;
	
	public Produto(int quantidade, LocalDateTime data_inicio, LocalDateTime data_fim, ArrayList<String> ingredientes, String tipo, int id) {
		this.quantidade = quantidade;
		this.data_inicio = data_inicio;
		this.data_fim = data_fim;
		this.ingredientes = ingredientes;
		this.tipo = tipo;
		this.id = id;
	}
	public int getID() {
		return id;
	}
	public int getQt() {
		return quantidade;
	}
	public int getValor() {
		return valor;
	}
	public boolean estaDisp(int qt) {
		if (quantidade >= qt) {
			return true;
		} else {
			return false;
		}
	}
	
	public String getTipo() {
		return tipo;
	}
	
	public void setQuantidade (int quantidade) {
		this.quantidade = quantidade;
	}
	
	public LocalDateTime getDataFim() {
		return data_fim;
	}
	public LocalDateTime getDataInicio() {
		return data_inicio;
	}
	
	public ArrayList<String> getIngredientes() {
		return ingredientes;
	}
	@Override
	public boolean equals(Object produto) {
		if (((Produto) produto).getID() == getID() ) {
			return true;
		}
		return false;
	
	}
	
	
	
	
	
}
