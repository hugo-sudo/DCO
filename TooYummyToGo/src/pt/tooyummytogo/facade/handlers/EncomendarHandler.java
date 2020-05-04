package pt.tooyummytogo.facade.handlers;

import java.time.LocalDateTime;
import java.time.chrono.ChronoLocalDateTime;
import java.time.temporal.TemporalAmount;
import java.util.ArrayList;
import java.util.List;

import pt.tooyummytogo.facade.dto.ComercianteInfo;
import pt.tooyummytogo.facade.dto.PosicaoCoordenadas;
import pt.tooyummytogo.facade.dto.ProdutoInfo;


public class EncomendarHandler {

	public List<ComercianteInfo> indicaLocalizacaoActual(PosicaoCoordenadas coordinate) {
		return redefineRaio(coordinate, 5000);
	}

	public List<ComercianteInfo> redefineRaio(PosicaoCoordenadas coordinate, int i) {
		ArrayList<ComercianteInfo> comerciantesInfo = new ArrayList<ComercianteInfo>();
		ArrayList<ComercianteInfo> comerciantesProximos = new ArrayList<Comerciante>();
		LocalDateTime atual = LocalDateTime.now();
		for (ComercianteInfo c : ComercianteInfo.todosComerciantes()) {
			if (coordinate.distanciaEmMetros(c.getLocalizacao()) <= i) {
				comerciantesProximos.add(c);
			}
		}
		
		for (Comerciante c : comerciantesProximos) {
			for (Produto p : c.getCatProdutos().getProdutos()) {
				if (p.getDataFim().minusHours(1).isAfter(atual)) {
					ComercianteInfo comerciante = new ComercianteInfo(c.getNome(), c.getContacto(), c.getLocalizacao(),c.getCatProdutos());
					if (!comerciantesInfo.contains(comerciante)) {
						comerciantesInfo.add(comerciante);
					}
				}
			}
		}
		return comerciantesInfo;
	}

	public List<ComercianteInfo> redefinePeriodo(LocalDateTime now, LocalDateTime plusHours) {
		ArrayList<ComercianteInfo> comerciantesInfo = new ArrayList<ComercianteInfo>();
		CatalogoComerciantes catComerciantes = CatalogoComerciantes.getInstanceCatCom();
		
		for (Comerciante c : catComerciantes.getComerciantes()) {
			for (Produto p : c.getCatProdutos().getProdutos()) {
				if (p.getDataInicio().isBefore(now) && p.getDataFim().isAfter(now)) {
					ComercianteInfo comerciante = new ComercianteInfo(c.getNome(), c.getContacto(), c.getLocalizacao(),c.getCatProdutos());
					if (!comerciantesInfo.contains(comerciante)) {
						comerciantesInfo.add(comerciante);
					}
				} else if (p.getDataInicio().isBefore(plusHours) && p.getDataFim().isAfter(plusHours)) {
					ComercianteInfo comerciante = new ComercianteInfo(c.getNome(), c.getContacto(), c.getLocalizacao(),c.getCatProdutos());
					if (!comerciantesInfo.contains(comerciante)) {
						comerciantesInfo.add(comerciante);
					}
				}
			}
		}
		
		return comerciantesInfo;
	}

	public List<ProdutoInfo> escolheComerciante(ComercianteInfo comercianteInfo) {
		// TODO Auto-generated method stub
		return null;
	}

	public void indicaProduto(ProdutoInfo p, int i) {
		// TODO Auto-generated method stub
		
	}

	public String indicaPagamento(String string, String string2, String string3) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
