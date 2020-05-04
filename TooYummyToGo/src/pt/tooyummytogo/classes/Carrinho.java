package pt.tooyummytogo.classes;

import java.util.ArrayList;
import java.util.List;

public class Carrinho {
	
	private ArrayList<Produto> lista_produtos = new ArrayList <Produto>();
	private float valor_total = 0;
	
	
	public Carrinho() {
		
	}
	
	public Carrinho(ArrayList <Produto> lista_produtos) {
		this.lista_produtos = lista_produtos;
		for (Produto prod: lista_produtos ) {
			this.valor_total += prod.getValor(); 
		}
	}
	
	public void addProd (Produto produto) {
		if (getListaProd().contains(produto)) {
			Produto prod = getListaProd().get(getListaProd().indexOf(produto));
			prod.setQuantidade(prod.getQt() + produto.getQt());
			setValor_total(getTotal() + produto.getValor());
		} else {
			lista_produtos.add(produto);
			setValor_total(getTotal() + produto.getValor());
		}
		
	}
	
	public float getTotal() {
		return valor_total;
	}
	public ArrayList<Produto> getListaProd(){
		return lista_produtos;
	}
	
	public void setValor_total (float valor_total) {
		this.valor_total = valor_total;
	}
}
