package pt.tooyummytogo.classes;

import java.util.ArrayList;
import java.util.Optional;

import pt.tooyummytogo.facade.dto.PosicaoCoordenadas;

public class CatUtilizadores {
	private ArrayList<Utilizador> utilizadores = new ArrayList<Utilizador>();
	private static CatUtilizadores catUti = new CatUtilizadores();
	
	public static CatUtilizadores getInstanceCatUti() {
		return catUti;
	}
	
	public ArrayList<Utilizador> getUtilizadores() {
		return utilizadores;
	}
	public void addUtilizador(String nome,String email, String password) {
		utilizadores.add(new Utilizador(nome, email, password));
	}

	public Utilizador getUtilizador(String email) {
		for (Utilizador uti: getUtilizadores()) {
			if (uti.getEmail().equals(email)) {
				return uti;
			}
		}
		return null;
	}
	
	
	public Optional<Utilizador> tryLogin(String email, String password){

		return Optional.ofNullable(getUtilizador(email)).filter(u -> u.getPassword().equals(password));
	}
	
	

}
