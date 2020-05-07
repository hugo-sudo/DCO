package pt.tooyummytogo.facade.handlers;

import pt.tooyummytogo.classes.CatComerciantes;
import pt.tooyummytogo.classes.Comerciante;
import pt.tooyummytogo.facade.dto.PosicaoCoordenadas;


public class RegistarComercianteHandler {
	
	private CatComerciantes catCom;
	
	
	public RegistarComercianteHandler(CatComerciantes catCom) {
		this.catCom = catCom;
	}
	
	
	/**
	 * Regista um Comerciante.
	 * @param Username
	 * @param Password
	 * @ensures existe um comerciante com esse username
	 */
	public boolean registarComerciante(String nome, String email, int contacto, String password, PosicaoCoordenadas p) {

		
		for (Comerciante c: catCom.getComerciantes()) {
			if (PosicaoCoordenadas.saoIguais(c.getLocalizacao(), p) || c.getContacto() == contacto || c.getEmail().equals(email)  ) {
				return false;
			}
		}
		
		catCom.addComerciante(nome, password, email, contacto, p);
		return true;
	
	}
}
