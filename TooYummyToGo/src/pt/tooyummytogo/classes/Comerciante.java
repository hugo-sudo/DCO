package pt.tooyummytogo.classes;

import java.util.ArrayList;
import java.util.List;

import pt.tooyummytogo.facade.dto.PosicaoCoordenadas;

public class Comerciante {

	private int contacto;
	private String nome;
	private String email;
	private String password;
	private PosicaoCoordenadas localizacao;
	private CatProdutos produtosCom = new CatProdutos();
	private int id;
	
	
	public Comerciante (String nome, String password, String email, int contacto, PosicaoCoordenadas localizacao,CatProdutos produtosCom, int id) {
		this.nome = nome;
		this.email = email;
		this.contacto = contacto;
		this.password = password;
		this.localizacao = localizacao;
		this.produtosCom = produtosCom;
		this.id = id; //ver como gerar um id aleatório
	}
	
	public List<String> getTiposProd() {
		ArrayList<String> tiposProd = new ArrayList<String>();
		for (Produto a : getCatProdutos().getProdutos()) {
			tiposProd.add(a.getTipo());
		}
		return tiposProd;
	}
	
	public boolean existeProd (int id) {
		return produtosCom.existe(id);
	}
	
	public void addProd (Produto produto) {
		produtosCom.addProduto(produto);
	}


	public int getId() {
		return id;
	}

	public CatProdutos getCatProdutos() {
		return produtosCom;
	}

	public PosicaoCoordenadas getLocalizacao() {
		return localizacao;
	}


	public int getContacto() {
		return contacto;
	}
	
	public String getNome() {
		return nome;
	}

}
