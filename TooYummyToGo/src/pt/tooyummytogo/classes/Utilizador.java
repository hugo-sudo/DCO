package pt.tooyummytogo.classes;

import java.util.ArrayList;
import java.util.List;

import com.monstercard.Card;
import com.monstercard.MonsterCardAPI;

import pt.tooyummytogo.facade.dto.ProdutoInfo;

public class Utilizador {
	private String nome;
	private String email;
	private String password;
	private List<Reserva> reservas = new ArrayList<Reserva>();
	private int currentIdRes;
	
	public Utilizador(String nome,String email, String password) {
		this.nome = nome;
		this.email = email;
		this.password = password;
	}
	
	public String getNome() {
		return nome;
	}
	public String getEmail() {
		return email;
	}
	public String getPassword() {
		return password;
	}
	public List<Reserva> getReservas(){
		return reservas;
	}
	public boolean Pagar (Card cartao, int valor) {
        MonsterCardAPI m = new MonsterCardAPI();
        if (m.isValid(cartao) && m.block(cartao, valor)) {
            return m.charge(cartao, valor);
        }
        return false;
    }

	public int createReserva(int valor, List<ProdutoInfo> carrinho) {
		List<Produto> produtos = new ArrayList<Produto>();
		Produto pr;
		for (ProdutoInfo p: carrinho) {
			pr = new Produto(p.getQt(), p.getIngredientes(), p.getTipo(), p.getValor());
			produtos.add(pr);
		}
		getReservas().add(new Reserva(valor, produtos, currentIdRes));
		return currentIdRes++;
		
		
		
	}
	
}
