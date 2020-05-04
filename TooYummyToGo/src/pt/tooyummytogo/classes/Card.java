package pt.tooyummytogo.classes;

public class Card {
	
	private int numero;
	private String data;
	private int ccv;
	private int saldo;
	
	public Card (int numero, String data, int ccv, int saldo) {
		this.numero = numero;
		this.data = data;
		this.ccv = ccv;
		this.saldo = saldo;
	}
	
	public int getNumero () {
		return numero;
	}
	public int getCCV () {
		return ccv;
	}
	
	public String getData () {
		return data;
	}
	
	public int getSaldo() {
		return saldo;
	}
	
	public void setSaldo (int saldo) {
		this.saldo = saldo;
	}
}
