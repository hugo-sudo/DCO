package pt.tooyummytogo.facade.handlers;

import java.util.ArrayList;
import java.util.List;

import pt.tooyummytogo.classes.Comerciante;


public class AdicionarTipoDeProdutoHandler {
	
	private Comerciante com;
	
	
	
	public AdicionarTipoDeProdutoHandler(Comerciante com) {
		this.com = com;
		
	}
	

	public String registaTipoDeProduto(String tp, int valor) {	 
		com.addProd(0, null, tp, valor);
		com.addHoje(0, null, tp, valor);
		return tp;
			
	}
	public String registaTipoDeProduto(String tp, String[] ingredientes, int valor) {
		com.addProd(0, ingredientes, tp, valor);
		com.addHoje(0, ingredientes, tp, valor);
		return tp;
		
		
	}
	

}
