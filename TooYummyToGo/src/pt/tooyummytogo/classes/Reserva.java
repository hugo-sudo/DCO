package pt.tooyummytogo.classes;

import java.util.ArrayList;
import java.util.List;

public class Reserva {
	private int id;
	private float valor_total;
	private List<Produto> produtos = new ArrayList<Produto>();
	
	
	public Reserva (int valor_total, List<Produto> produtos, int id) {
		this.valor_total = valor_total;
		this.produtos = produtos;
		this.id = id;
	}
	
}
