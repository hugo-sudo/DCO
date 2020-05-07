package pt.tooyummytogo.facade.handlers;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import pt.tooyummytogo.classes.Comerciante;

public class ColocarProdutoHandler {
	private Comerciante com;
	private List<String> prodAssociados;

	public ColocarProdutoHandler(Comerciante com) {
		this.com = com;
	}

	public List<String> inicioDeProdutosHoje() {
		com.resetHoje();
		return com.getTiposProd();
	}

	public void indicaProduto(String string, int i) {
		prodAssociados = com.getTiposProd();
		if (prodAssociados.contains(string)) {
			com.addHoje(i, null, string, com.getCatProdutos().getProduto(string).get().getValor());
		}
		
		
	}

	public void confirma(LocalDateTime now, LocalDateTime plusHours) {
		com.horarioHj(now, plusHours);
		
	}

}
