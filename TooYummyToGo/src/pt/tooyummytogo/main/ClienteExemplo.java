package pt.tooyummytogo.main;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import pt.tooyummytogo.Sessao;
import pt.tooyummytogo.facade.TooYummyToGo;
import pt.tooyummytogo.facade.dto.ComercianteInfo;
import pt.tooyummytogo.facade.dto.PosicaoCoordenadas;
import pt.tooyummytogo.facade.dto.ProdutoInfo;
import pt.tooyummytogo.facade.handlers.AdicionarTipoDeProdutoHandler;
import pt.tooyummytogo.facade.handlers.ColocarProdutoHandler;
import pt.tooyummytogo.facade.handlers.EncomendarHandler;
import pt.tooyummytogo.facade.handlers.RegistarComercianteHandler;
import pt.tooyummytogo.facade.handlers.RegistarUtilizadorHandler;

public class ClienteExemplo {
	public static void main(String[] args) {
		TooYummyToGo ty2g = new TooYummyToGo();
		
		// UC1
		RegistarUtilizadorHandler regHandler = ty2g.getRegistarUtilizadorHandler();
		regHandler.registarUtilizador("Felismina", "felismina@gmail.com","hortadafcul" );
		regHandler.registarUtilizador("Alberto", "alberto@gmail.com","alberto123" );
		
		// UC3
		RegistarComercianteHandler regComHandler = ty2g.getRegistarComercianteHandler();
		
		regComHandler.registarComerciante("Silvino","silvino@hotmail.com", 919183201, "bardoc2", new PosicaoCoordenadas(34.51, 45.2));
		regComHandler.registarComerciante("Maribel", "maribel@sapo.pt", 919282101, "torredotombo", new PosicaoCoordenadas(34.52, 45.2));
		
		// UC4
		Optional<Sessao> talvezSessao = ty2g.autenticar(919183201, "bardoc2");
		talvezSessao.ifPresent( (Sessao s) -> {
			AdicionarTipoDeProdutoHandler atp = s.adicionarTipoDeProdutoHandler();
			for (String tp : new String[] {"Pão", "Pão de Ló", "Mil-folhas"}) {
				atp.registaTipoDeProduto(tp, 2);
			}
		});

		// UC5
		Optional<Sessao> talvezSessao2 = ty2g.autenticar(919183201, "bardoc2");
		talvezSessao2.ifPresent( (Sessao s) -> {
			
			ColocarProdutoHandler cpv = s.getColocarProdutoHandler();
			
			List<String> listaTiposDeProdutos = cpv.inicioDeProdutosHoje();
			
			cpv.indicaProduto(listaTiposDeProdutos.get(0), 10); // Pão
			cpv.indicaProduto(listaTiposDeProdutos.get(2), 5); // Mil-folhas
			
			//extensao 3a.
			AdicionarTipoDeProdutoHandler atp = s.adicionarTipoDeProdutoHandler();
			
			cpv.indicaProduto(atp.registaTipoDeProduto("bolo de laranja", new String[] {"farinha", "laranjas"}, 10), 2);
			
			
			cpv.confirma(LocalDateTime.now(), LocalDateTime.now().plusHours(2));
			
			System.out.println("Produtos disponíveis");
		});
		
		Optional<Sessao> talvezSessao7 = ty2g.autenticar(919282101, "torredotombo");
		talvezSessao7.ifPresent( (Sessao s) -> {
			AdicionarTipoDeProdutoHandler atp = s.adicionarTipoDeProdutoHandler();
			for (String tp : new String[] {"pastel de nata", "bolo de arroz", "palmier", "ucal"}) {
				atp.registaTipoDeProduto(tp, 2);
			}
			ColocarProdutoHandler cpv = s.getColocarProdutoHandler();
			
			List<String> listaTiposDeProdutos = cpv.inicioDeProdutosHoje();
			
			cpv.indicaProduto(listaTiposDeProdutos.get(3), 20);
			cpv.indicaProduto(listaTiposDeProdutos.get(0), 5);
			cpv.indicaProduto(listaTiposDeProdutos.get(1), 2);
			
			
			
			cpv.confirma(LocalDateTime.now(), LocalDateTime.now().plusHours(2));
			
			System.out.println("Produtos disponíveis");
			
			
		});
		
		// UC6 + UC7
		Optional<Sessao> talvezSessao3 = ty2g.autenticar("felismina@gmail.com", "hortadafcul");
		talvezSessao3.ifPresent( (Sessao s) -> {
			EncomendarHandler lch = s.getEncomendarComerciantesHandler();
			List<ComercianteInfo> cs = lch.indicaLocalizacaoActual(new PosicaoCoordenadas(34.5, 45.2));
			
			for (ComercianteInfo i : cs) {
				System.out.println(i);
			}
			
			boolean redefineRaio = true;
			if (redefineRaio) {
				cs = lch.redefineRaio(100);
				for (ComercianteInfo i : cs) {
					System.out.println(i);
				}
			}
			
			boolean redefinePeriodo = true;
			if (redefinePeriodo) {
				cs = lch.redefinePeriodo(LocalDateTime.now(), LocalDateTime.now().plusHours(1));
				for (ComercianteInfo i : cs) {
					System.out.println(i);
				}
			}
			
			
			// A partir de agora é UC7
			List<ProdutoInfo> ps = lch.escolheComerciante(cs.get(0));
			for (ProdutoInfo p : ps) {
				lch.indicaProduto(p, 1); // Um de cada
			}
			String codigoReserva = lch.indicaPagamento("365782312312", "02/2021", "422");
			System.out.println(codigoReserva); 
			
			ps = lch.escolheComerciante(cs.get(1));
			lch.indicaProduto(ps.get(0), 21);
			lch.indicaProduto(ps.get(1), 2);
			lch.indicaProduto(ps.get(2), 6);
			
			codigoReserva = lch.indicaPagamento("365782312312", "02/2021", "422");
			System.out.println(codigoReserva);
			
		});
		
	}
}
