package pt.tooyummytogo.facade.handlers;

import java.time.LocalDateTime;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.monstercard.Card;

import pt.tooyummytogo.classes.CatComerciantes;
import pt.tooyummytogo.classes.Comerciante;
import pt.tooyummytogo.classes.Produto;
import pt.tooyummytogo.classes.Utilizador;
import pt.tooyummytogo.facade.dto.ComercianteInfo;
import pt.tooyummytogo.facade.dto.PosicaoCoordenadas;
import pt.tooyummytogo.facade.dto.ProdutoInfo;


public class EncomendarHandler {
	
	private Utilizador uti;
    private CatComerciantes catCom;
    private List<ProdutoInfo> carrinho = new ArrayList<ProdutoInfo>();
    private LocalDateTime data_inicial;
    private LocalDateTime data_final;
    private PosicaoCoordenadas coordinate;
    private List<ComercianteInfo> comerciantes = new ArrayList<ComercianteInfo>();
    private List<ProdutoInfo> produtosCom = new ArrayList<ProdutoInfo>();
    private Comerciante comCorrente;

    public EncomendarHandler(Utilizador uti, CatComerciantes catCom) {
        this.uti = uti;
        this.catCom = catCom;
    }

	public List<ComercianteInfo> indicaLocalizacaoActual(PosicaoCoordenadas coordinate) {
		this.coordinate = coordinate;
		return redefineRaio(5000);
	}

	public List<ComercianteInfo> redefineRaio(int i) {
		LocalDateTime atual = LocalDateTime.now();
		setDataInicial(atual);
		setDataFinal(atual.plusHours(1));
		ArrayList<ComercianteInfo> comerciantesInfo = new ArrayList<ComercianteInfo>();
		ArrayList<ProdutoInfo> produtosHojeInfo = new ArrayList<ProdutoInfo>();
		for (Comerciante c : catCom.getComerciantes()) {
			produtosHojeInfo = new ArrayList<ProdutoInfo>();
			if (coordinate.distanciaEmMetros(c.getLocalizacao()) <= i) {
				boolean verificador = false;
				for (Produto p : c.getProdutosHoje().getProdutos()) {
					if (p.getDataFim().minusHours(1).isAfter(atual) || p.getDataFim().minusHours(1).isEqual(atual) ) {
						verificador = true;
						ProdutoInfo produto = new ProdutoInfo(p.getQt(),p.getValor(),p.getDataInicio(), p.getDataFim(), p.getIngredientes(), p.getTipo());
						produtosHojeInfo.add(produto);
					}
				}
				if (verificador) {
					ComercianteInfo comerciante = new ComercianteInfo(c.getNome(), c.getContacto(), c.getLocalizacao(),produtosHojeInfo);
					comerciantesInfo.add(comerciante);
				}
			}
		}	
		if (comerciantesInfo.isEmpty()) {
			System.out.println("Não existem comerciantes no raio definido.");
			return comerciantesInfo;
		} else {
			comerciantes = comerciantesInfo;
			return comerciantes;
		}
		
	}

	public List<ComercianteInfo> redefinePeriodo(LocalDateTime now, LocalDateTime plusHours) {
		ArrayList<ComercianteInfo> comerciantesInfo = new ArrayList<ComercianteInfo>();
		ArrayList<ProdutoInfo> produtosHojeInfo = new ArrayList<ProdutoInfo>();
		setDataInicial(now);
		setDataFinal(plusHours);
		for (Comerciante c : catCom.getComerciantes()) {
			produtosHojeInfo = new ArrayList<ProdutoInfo>();
			boolean verificador = false;
			for (Produto p : c.getProdutosHoje().getProdutos()) {
				if (p.getDataInicio().isBefore(now) && p.getDataFim().isAfter(now) || p.getDataInicio().isBefore(plusHours) && p.getDataFim().isAfter(plusHours)) {
					verificador = true;
					ProdutoInfo produto = new ProdutoInfo(p.getQt(),p.getValor(),p.getDataInicio(), p.getDataFim(), p.getIngredientes(), p.getTipo());
					produtosHojeInfo.add(produto);
				}
			}
			if (verificador) {
				ComercianteInfo comerciante = new ComercianteInfo(c.getNome(), c.getContacto(), c.getLocalizacao(),produtosHojeInfo);
				comerciantesInfo.add(comerciante);
			}
		}
		
		comerciantes = comerciantesInfo;
		return comerciantes;
	}

	public List<ProdutoInfo> escolheComerciante(ComercianteInfo comercianteInfo) {
		if (comerciantes.contains(comercianteInfo)) {
			comCorrente = catCom.getComerciante(String.valueOf(comercianteInfo.getContacto()));
			produtosCom = comercianteInfo.getProdutosInfo(); 
			return produtosCom;
		} 
		return produtosCom;
		
		
		
	}

	public void indicaProduto(ProdutoInfo p, int i) {
		if (produtosCom.contains(p) && p.estaDisp(i) ) {
			Optional<Produto> opt = comCorrente.getProdutosHoje().getProduto(p.getTipo());
			opt.ifPresent((Produto produto) -> {
				produto.setQuantidade(produto.getQt()- i);
				carrinho.add(p);
				p.setQuantidade(p.getQt() - i);
			});	
		} else {
			if (!p.estaDisp(i)) {
				System.out.println("Apenas existem " + p.getQt() + " unidades de " + p.getTipo() );
			}
		}
	}

	public String indicaPagamento(String string, String string2, String string3) {
		String [] data = string2.split("/");
		String mes = data[0];
		String ano = data [1];
		Card cc = new Card (string,string3,mes,ano);
		int valor = 0;
		for (ProdutoInfo p : carrinho) {
			valor += (p.getQt() * p.getValor());
		}
		if (uti.Pagar(cc,valor)) {
			int codigoReserva = uti.createReserva(valor, carrinho);
			carrinho = new ArrayList<ProdutoInfo>();
			return "Reserva " + codigoReserva + " feita com sucesso";
			
		} else {
			carrinho = new ArrayList<ProdutoInfo>();
			return "Reserva não foi feita com sucesso";
		}
	}
	
	public void setDataInicial(LocalDateTime data_inicial) {
		this.data_inicial = data_inicial;
	}
	
	public void setDataFinal(LocalDateTime data_final) {
		this.data_final = data_final;
	}
	
	public LocalDateTime getDataInicial() {
		return data_inicial;
	}
	
	public LocalDateTime getDataFinal() {
		return data_final;
	}


}
