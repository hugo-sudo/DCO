package pt.tooyummytogo.facade.handlers;

import pt.tooyummytogo.facade.dto.PosicaoCoordenadas;

import java.util.List;

import pt.tooyummytogo.classes.CatProdutos;
import pt.tooyummytogo.classes.CatalogoComerciantes;
import pt.tooyummytogo.classes.Comerciante;


public class RegistarComercianteHandler {
	/**
	 * Regista um Comerciante.
	 * @param Username
	 * @param Password
	 * @ensures existe um comerciante com esse username
	 */
	public boolean registarComerciante(String nome, String password, PosicaoCoordenadas p, String email, int contacto, CatProdutos cat) {
		CatalogoComerciantes catCom = CatalogoComerciantes.getInstanceCatCom();
		int idCounter = catCom.getIdCounter() + 1;
		
		for (Comerciante a: catCom.getComerciantes()) {
			if (PosicaoCoordenadas.saoIguais(a.getLocalizacao(), p) || (a.getContacto() == contacto)) {
				return false;
			}
		}
		
		Comerciante novoCom = new Comerciante (nome, password, email, contacto, p, cat, idCounter);
		catCom.getComerciantes().add(novoCom);
		catCom.setIdCounter(idCounter);
		
		return true;
	
	}
}
