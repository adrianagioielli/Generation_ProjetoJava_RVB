package ECommerce.Util;

public class FormataTexto {
	
	//ajusta tamanhos dos menus de informações para que as linhas não fiquem diferentes
	public static String formata(String texto, int tamanho) {
		int conta = texto.length();
		int qt = conta/tamanho;
		if(qt * tamanho < conta) {
			qt++;
		}
		String copia = "";
		int restante = (qt*tamanho) - conta;
		for(int i = 0; i < (qt-1); i++) {
			copia += texto.substring(i*tamanho, (i*tamanho) + tamanho) + "\n";
		}
		copia += texto.substring((qt-1)*tamanho, conta);
		copia += preenche(" ", restante);
		return copia;
	}
	
	//preenche linhas com espaços ou asteriscos
	public static String preenche(String asterisco, int quantidade) {
		String result = "";
		for(int j = 0; j < quantidade; j++) {
			result += asterisco;
		}
		return result;
	}
	
	//centraliza texto
	public static String centraliza(String texto, int tamanho) {
		int sobra = tamanho - texto.length();
		String result = preenche(" ", sobra/2);
		result += texto + preenche(" ", sobra/2);
		if((sobra%2 != 0)) {
			result += " ";
		}
		return result;
	}

}
