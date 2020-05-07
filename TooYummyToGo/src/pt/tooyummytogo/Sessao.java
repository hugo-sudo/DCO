package pt.tooyummytogo;

import pt.tooyummytogo.classes.CatComerciantes;

import pt.tooyummytogo.classes.Comerciante;
import pt.tooyummytogo.classes.Utilizador;
import pt.tooyummytogo.facade.handlers.AdicionarTipoDeProdutoHandler;
import pt.tooyummytogo.facade.handlers.ColocarProdutoHandler;
import pt.tooyummytogo.facade.handlers.EncomendarHandler;

public class Sessao {
	
	private Comerciante com;
	private Utilizador uti;
	private CatComerciantes catCom;
	
	
	public Sessao(Utilizador u, CatComerciantes catCom ) {
		this.uti = u;
		this.catCom = catCom;
	}
	

	public Sessao(Comerciante c) {
		this.com = c;
	}


	// UC4
	public AdicionarTipoDeProdutoHandler adicionarTipoDeProdutoHandler() {
		if (com != null) {
			return new AdicionarTipoDeProdutoHandler(com);
		} else {
			System.out.println("Funcionalidade apenas disponível para comerciantes.");
			return null;
		}
		
	}

	// UC5
	public ColocarProdutoHandler getColocarProdutoHandler() {
		if (com != null) {
			return new ColocarProdutoHandler(com);
		} else {
			System.out.println("Funcionalidade apenas disponível para comerciantes.");
			return null;
		} 
	}

	public EncomendarHandler getEncomendarComerciantesHandler() {
		if (uti != null) {
			return new EncomendarHandler(uti, catCom);
		} else {
			System.out.println("Funcionalidade não disponível para comerciantes.");
			return null;
		}
		
	}
}
