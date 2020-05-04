package pt.tooyummytogo.facade.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import pt.tooyummytogo.classes.CatProdutos;
import pt.tooyummytogo.classes.CatalogoComerciantes;
import pt.tooyummytogo.classes.Comerciante;
import pt.tooyummytogo.classes.Produto;

public class ProdutoInfo {
	
	private int quantidade;
	private int valor;
	private LocalDateTime data_inicio;
	private LocalDateTime data_fim;
	private ArrayList<String> ingredientes = new ArrayList<String>();
	private String tipo;
	
	public ProdutoInfo (int quantidade,int valor, LocalDateTime data_inicio, LocalDateTime data_fim, ArrayList<String> ingredientes, String tipo) {
		this.quantidade = quantidade;
		this.valor = valor;
		this.data_inicio = data_inicio;
		this.data_fim = data_fim;
		this.ingredientes = ingredientes;
		this.tipo = tipo;
	}
	
	public static List<ProdutoInfo> todosProdutos () {
		CatProdutos cat = CatProdutos.getInstanceCatProd();
		List<ProdutoInfo> listaProdutos = new ArrayList<ProdutoInfo>();
		for (Produto p : cat.getProdutos()) {
			ProdutoInfo infoProduto = new ProdutoInfo (p.getQt(),p.getValor(), p.getDataInicio(),p.getDataFim(),p.getIngredientes(),p.getTipo());
			listaProdutos.add(infoProduto);
		}
		return listaProdutos;
	}
	
}
