package pt.tooyummytogo.facade.handlers;

import pt.tooyummytogo.classes.CatUtilizadores;
import pt.tooyummytogo.classes.Utilizador;
import pt.tooyummytogo.facade.dto.PosicaoCoordenadas;

public class RegistarUtilizadorHandler {
	
	private CatUtilizadores catUti;
	
	public RegistarUtilizadorHandler(CatUtilizadores catUti) {
		this.catUti = catUti;
		
		
	}
	/**
	 * Regista um utilizador normal.
	 * @param Username
	 * @param Password
	 * @ensures existe um utilizador com esse username
	 */
	
	public boolean registarUtilizador(String nome,String email, String password) {
		for (Utilizador uti: catUti.getUtilizadores()) {
			if(uti.getEmail().equals(email)) {
				return false;
			}
		}
		
		catUti.addUtilizador(nome, email, password);
		return true;
		
		
	}

}
