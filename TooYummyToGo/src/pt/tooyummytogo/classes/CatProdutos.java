package pt.tooyummytogo.classes;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CatProdutos {
	private List<Produto> produtos = new ArrayList<Produto>();
	private static CatProdutos catProd = new CatProdutos();
	
	public static CatProdutos getInstanceCatProd() {
		return catProd;
	}
	public List<Produto> getProdutos() {
		return produtos;
	}
	public void addProduto(Produto prod) {
		Optional<Produto> opt = getProduto(prod.getTipo());
		if (opt.isPresent()) {
			Produto produto = opt.get();
			produto.setQuantidade(produto.getQt() + prod.getQt());
		} else {
			produtos.add(prod);
		}
		
	}
	public Optional<Produto> getProduto(String tipo) {
		for (Produto prod: getProdutos()) {
			if (prod.getTipo().equals(tipo)) {
				return Optional.of(prod);
			}
		}
		return Optional.empty();
	}
	
	public boolean estaDisp(String tipo, int qt) {
		Optional<Produto> opt = getProduto(tipo);
		if (opt.isPresent()) {
			Produto prod = opt.get();
			if (prod.estaDisp(qt)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean existe (String tipo) {
		return estaDisp (tipo,0);
	}
	
	public void setHorario(LocalDateTime now, LocalDateTime plusHours) {
		for (Produto p: getProdutos()) {
			p.setData_inicio(now);
			p.setData_fim(plusHours);
		}
		
		
	}
	

}
