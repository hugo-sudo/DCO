package pt.tooyummytogo.facade.dto;

import java.util.ArrayList;
import java.util.List;

import pt.tooyummytogo.classes.CatProdutos;
import pt.tooyummytogo.classes.CatalogoComerciantes;
import pt.tooyummytogo.classes.Comerciante;

public class ComercianteInfo {
	
	private int contacto;
	private String nome;
	private PosicaoCoordenadas localizacao;
	private List<ProdutoInfo> listaProdutos = new ArrayList<ProdutoInfo>();
	
	public ComercianteInfo (String nome, int contacto, PosicaoCoordenadas localizacao,List<ProdutoInfo> listaProdutos ) {
		this.nome = nome;
		this.contacto = contacto;
		this.localizacao = localizacao;
		this.listaProdutos = listaProdutos;
	}
	
	public static List<ComercianteInfo> todosComerciantes () {
		CatalogoComerciantes cat = CatalogoComerciantes.getInstanceCatCom();
		List<ComercianteInfo> listaComerciante = new ArrayList<ComercianteInfo>();
		for (Comerciante c : cat.getComerciantes()) {
			ComercianteInfo infoComerciante = new ComercianteInfo (c.getNome(),c.getContacto(),c.getLocalizacao(),c.getCatProdutos());
			listaComerciante.add(infoComerciante);
		}
		return listaComerciante;
	}
	
	public PosicaoCoordenadas getLocalizacao() {
		return localizacao;
	}
	
	public CatProdutos
}
