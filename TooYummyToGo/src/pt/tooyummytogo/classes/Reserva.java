package pt.tooyummytogo.classes;


public class Reserva {
	private int id;
	private float valor_total;
	private Carrinho carrinho;
	
	
	public Reserva (int id, Carrinho carrinho) {
		this.id = id;
		this.valor_total = carrinho.getTotal();
		this.carrinho = carrinho;
	}
	
	public int getId() {
		return this.id;
	}
	
}
