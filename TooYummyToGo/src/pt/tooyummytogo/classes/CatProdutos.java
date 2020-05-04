package pt.tooyummytogo.classes;

import java.util.ArrayList;
import java.util.Optional;

public class CatProdutos {
	private int currentId = 0;
	private ArrayList<Produto> produtos = new ArrayList<Produto>();
	private static CatProdutos catProd = new CatProdutos();
	
	public static CatProdutos getInstanceCatProd() {
		return catProd;
	}
	public int getCurrentId() {
		return currentId;
	}
	public ArrayList<Produto> getProdutos() {
		return produtos;
	}
	public void addProduto(Produto prod) {
		Optional<Produto> opt = getProduto(prod.getID());
		if (opt.isPresent()) {
			Produto product = opt.get();
			product.setQuantidade(product.getQt() + prod.getQt());
		} else {
			currentId++;
			produtos.add(prod);
		}
		
	}
	public Optional<Produto> getProduto(int id) {
		for (Produto prod: getProdutos()) {
			if (prod.getID() == id) {
				return Optional.of(prod);
			}
		}
		return Optional.empty();
	}
	
	public boolean estaDisp(int id, int qt) {
		Optional<Produto> opt = getProduto(id);
		if (opt.isPresent()) {
			Produto prod = opt.get();
			if (prod.estaDisp(qt)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean existe (int id) {
		return estaDisp (id,0);
	}
	

}
