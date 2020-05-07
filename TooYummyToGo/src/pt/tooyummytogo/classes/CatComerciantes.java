package pt.tooyummytogo.classes;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import pt.tooyummytogo.facade.dto.PosicaoCoordenadas;

public class CatComerciantes {
	
	private static ArrayList <Comerciante> comerciantes = new ArrayList <Comerciante>();
	private static CatComerciantes catCom = new CatComerciantes();
	

	public static CatComerciantes getInstanceCatCom() {
        return catCom;
    }
	
	public ArrayList <Comerciante> getComerciantes() {
		return comerciantes;
	}
	public PosicaoCoordenadas getLocalizacao (Comerciante comerciante) {
		return null;
	}
	
	public LocalTime getPeriodoPossivel (Comerciante comerciante) {
		return null;
	}
	
	public void addComerciante(String nome, String password, String email, int contacto, PosicaoCoordenadas localizacao) {
		
		getComerciantes().add(new Comerciante(nome, password, email, contacto, localizacao));
	}
	
	
	public Comerciante getComerciante(String contacto) {
		for (Comerciante c : comerciantes) {
			if (c.getContacto() == Integer.parseInt(contacto)) {
				return c;
			}
		}
		return null;
	}
	
	public Optional<Comerciante> tryLogin(int contacto, String password){
		
		return Optional.ofNullable(getComerciante(String.valueOf(contacto))).filter(c -> c.getPassword().equals(password));
	}
	
}
