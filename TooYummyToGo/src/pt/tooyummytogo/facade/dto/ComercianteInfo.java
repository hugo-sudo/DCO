package pt.tooyummytogo.facade.dto;

import java.util.ArrayList;
import java.util.List;

import pt.tooyummytogo.classes.Comerciante;
import pt.tooyummytogo.classes.CatComerciantes;
import pt.tooyummytogo.classes.CatProdutos; 

public class ComercianteInfo {
	
	private int contacto;
	private String nome;
	private PosicaoCoordenadas localizacao;
	private List<ProdutoInfo> listaProdutos = new ArrayList<ProdutoInfo>();
	
	public ComercianteInfo (String nome, int contacto, PosicaoCoordenadas localizacao, List<ProdutoInfo> listaProdutos) {
		this.nome = nome;
		this.contacto = contacto;
		this.localizacao = localizacao;
		this.listaProdutos = listaProdutos;
	}
	
	public PosicaoCoordenadas getLocalizacao() {
		return localizacao;
	}
	
	public List<ProdutoInfo> getProdutosInfo() {
		return listaProdutos;
	}
	public int getContacto() {
		return contacto;
	}
	public String getNome() {
        return nome;
    }
	public String toString() {
        return "Comerciante: " + getNome();
    }
	
}
	
