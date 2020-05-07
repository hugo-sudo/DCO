package pt.tooyummytogo.classes;

import java.time.LocalDateTime;
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
	private CatProdutos produtosHoje = new CatProdutos();
	
	public Comerciante (String nome, String password, String email, int contacto, PosicaoCoordenadas localizacao) {
		this.nome = nome;
		this.email = email;
		this.contacto = contacto;
		this.password = password;
		this.localizacao = localizacao;
	}
	
	
	public List<String> getTiposProd() {
		ArrayList<String> tiposProd = new ArrayList<String>();
		for (Produto a : getCatProdutos().getProdutos()) {
			tiposProd.add(a.getTipo());
		}
		return tiposProd;
	}
	
	public boolean existeProd (String tp) {
		return produtosCom.existe(tp);
	}
	
	public void addProd (int quantidade, String[] ingredientes, String tipo, int valor) {
		
		getCatProdutos().addProduto(new Produto(quantidade, ingredientes, tipo, valor));
	}

	public void addHoje(int quantidade, String[] ingredientes, String tipo,int valor) {
		getProdutosHoje().addProduto(new Produto(quantidade, ingredientes, tipo, valor));
	}
	
	public void horarioHj(LocalDateTime now, LocalDateTime plusHours) {
		getProdutosHoje().setHorario(now, plusHours);
	}
	
	public void resetHoje() {
		produtosHoje = new CatProdutos();
	}

	public CatProdutos getCatProdutos() {
		return produtosCom;
	}
	
	public CatProdutos getProdutosHoje() {
		return produtosHoje;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getNome() {
        return nome;
    }
	
	public String getPassword() {
		return password;
	}

	public PosicaoCoordenadas getLocalizacao() {
		return localizacao;
	}


	public int getContacto() {
		return contacto;
	}
	

}
