package ECommerce.Util;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ScannersService {
	
	private static Scanner leitura;
	
	public static Scanner getLeitura() {
		if(leitura == null) {
			leitura = new Scanner(System.in);
		}
		return leitura;
	}
	
	public static int leInteiro() {
		return leInteiro("\nDigite valores inteiros!", 0);
	}
	
	public static int leInteiro(String erro, int padrao) {
		int opcao = 0;
		Scanner leia = ScannersService.getLeitura();
		try {
			opcao = leia.nextInt();
		}catch(InputMismatchException e) {
			Apresentacao.geralErro(erro);;
			opcao =  padrao;
		}
		leia.nextLine();
		return opcao;
	}

}
