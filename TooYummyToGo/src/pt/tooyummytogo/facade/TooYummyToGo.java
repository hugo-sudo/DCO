package pt.tooyummytogo.facade;

import java.util.Optional;

import pt.tooyummytogo.Sessao;
import pt.tooyummytogo.classes.CatComerciantes;
import pt.tooyummytogo.classes.CatProdutos;
import pt.tooyummytogo.classes.CatUtilizadores;
import pt.tooyummytogo.classes.Comerciante;
import pt.tooyummytogo.classes.Utilizador;
import pt.tooyummytogo.facade.handlers.RegistarComercianteHandler;
import pt.tooyummytogo.facade.handlers.RegistarUtilizadorHandler;

/**
 * Esta é a classe do sistema.
 */
public class TooYummyToGo {
	private CatComerciantes catCom = new CatComerciantes();
	private CatUtilizadores catUti = new CatUtilizadores();
	
	// UC1
	public RegistarUtilizadorHandler getRegistarUtilizadorHandler() {
		return new RegistarUtilizadorHandler(catUti);
	}
	
	/**
	 * Returns an optional Session representing the authenticated user.
	 * @param username
	 * @param password
	 * @return
	 * 
	 * UC2
	 */
	public Optional<Sessao> autenticar(String email, String password) {
		Optional<Utilizador> currentUti = catUti.tryLogin(email, password);
		return currentUti.map(u -> new Sessao(u, catCom)); 
	}
	
	public Optional<Sessao> autenticar(int contacto, String password) {
		Optional<Comerciante> currentCom = catCom.tryLogin(contacto, password);
		
		
		return currentCom.map(c -> new Sessao(c));  
	}
	

	// UC3
	public RegistarComercianteHandler getRegistarComercianteHandler() {
		return new RegistarComercianteHandler(catCom);
	}
	

}
