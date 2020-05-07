package pt.tooyummytogo.classes;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Produto {
	private int quantidade;
	private int valor;
	private LocalDateTime data_inicio;
	private LocalDateTime data_fim;
	private String[] ingredientes;
	private String tipo;
	
	public Produto(int quantidade, String[] ingredientes, String tipo, int valor) {
		this.quantidade = quantidade;
		this.ingredientes = ingredientes;
		this.tipo = tipo;
		this.valor = valor;
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
	
	public LocalDateTime getDataInicio() {
        return data_inicio;
    }

    public String[] getIngredientes() {
        return ingredientes;
    }
	
	public void setQuantidade (int quantidade) {
		this.quantidade = quantidade;
	}
	public void setData_inicio(LocalDateTime data_inicio) {
		this.data_inicio = data_inicio;
	}
	public void setData_fim(LocalDateTime data_fim) {
		this.data_fim = data_fim;
	}

	public LocalDateTime getDataFim() {
		return data_fim;
	}

	
	
	
	
	
	
}
