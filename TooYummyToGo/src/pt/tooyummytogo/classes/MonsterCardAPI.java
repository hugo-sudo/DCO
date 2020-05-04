package pt.tooyummytogo.classes;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MonsterCardAPI {

	
	public MonsterCardAPI () {
	}
	
	public boolean isValid(Card cc) throws ParseException {
		if (String.valueOf(cc.getNumero()).length() != 12) {
			return false;
		}
		SimpleDateFormat formatter = new SimpleDateFormat("MM-yy");
		Date data = formatter.parse(cc.getData());
		Date currentDate = new Date();
		if (currentDate.after(data)) {
			return false;
		}
		return true;
		
	}
	
	public boolean charge (Card cc, int valor) throws ParseException {
		if (isValid (cc)) {
			if (cc.getSaldo() >= valor) {
				cc.setSaldo(cc.getSaldo() - valor);
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
	
}
