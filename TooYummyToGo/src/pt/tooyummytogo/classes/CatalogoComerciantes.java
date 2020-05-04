package pt.tooyummytogo.classes;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import pt.tooyummytogo.facade.dto.PosicaoCoordenadas;

public class CatalogoComerciantes {
	
	private static ArrayList <Comerciante> comerciantes = new ArrayList <Comerciante>();
	private static CatalogoComerciantes catCom = new CatalogoComerciantes();
	private int currentId = 0;
	

	public static CatalogoComerciantes getInstanceCatCom() {
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
	
	public void addComerciante(Comerciante comerciante) {
		currentId++;
		getComerciantes().add(comerciante);
	}
	
	public Optional<Comerciante> getComerciante(int id) {
		for (Comerciante c : comerciantes) {
			if (c.getId() == id) {
				return Optional.of(c);
			}
		}
		return Optional.empty();
	}
	
	public int getCurrentId() {
		return currentId;
	}
	
	public void setIdCounter(int id) {
		this.currentId = id; 
	}
}
