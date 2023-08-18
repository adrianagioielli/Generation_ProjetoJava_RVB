package ECommerce;

import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

import ECommerce.Controller.Produtos;
import ECommerce.Controller.Carrinho;
import ECommerce.Util.Estetica;
import ECommerce.Util.FormataTexto;
import ECommerce.Util.ScannersService;

public class Menu {
	
	private static Carrinho carrinho = new Carrinho(); 
	private static Scanner leia = ScannersService.getLeitura();
	
	public static void main(String[] args) {
	
		int opcao = 0;
		
		Produtos.inicializaProdutos();
		
		do {
			mostraMenuPrincipal();
			opcao = ScannersService.leInteiro();
		
			switch(opcao) {
			
			//listar o catálogo de vestuário e adiciona produtos
			case 1:
				catalogo();
				keyPress();
				opcao = 0;
				break;
			
			//visualiza o carrinho de compras
			case 2:
				visualizarCarrinho();
				keyPress();
				opcao = 0;
				break;
			//pagina de pagto: lista itens no carrinho, soma valores para pagamento e encerra compra
			case 3:
			
				keyPress();
				opcao = 0;
				break;
			//finaliza o programa
			case 4:
				System.out.println(Estetica.TEXT_WHITE + Estetica.ANSI_PURPLE_BACKGROUND
						+ FormataTexto.preenche("*", 50));
				System.out.println(FormataTexto.centraliza("Agradecemos pela preferência!", 50));
				System.out.println(FormataTexto.centraliza("Volte sempre!!!!", 50));
				System.out.println(FormataTexto.preenche("*", 50));
				leia.close();
				System.exit(0);			
			
				//verifica opcao inválida e retorna para menu
			default:
				System.out.println(Estetica.TEXT_RED_BOLD + Estetica.ANSI_WHITE_BACKGROUND +
						"\nOpção não existe no menu! Tente novamente\n");
				keyPress();
				opcao = 0;
				break;
		}
			
			
		}while(opcao == 0); 

	}
	
	public static void keyPress() {
		try {
			System.out.println(Estetica.TEXT_RESET + Estetica.ANSI_WHITE_BACKGROUND + "\n\nPressione Enter para continuar: ");

			System.in.read();
		}catch(IOException e) {
			System.out.println("Você pressionou uma tecla diferente de Enter!");
		}
	}
	
	public static void mostraMenuPrincipal() {
		System.out.println(Estetica.TEXT_WHITE + Estetica.ANSI_PURPLE_BACKGROUND
		         + FormataTexto.preenche("*", 50));
		System.out.println(FormataTexto.preenche(" ", 50));
		System.out.println(FormataTexto.centraliza("Recriar", 50));
		System.out.println(FormataTexto.centraliza("Vestuário para bonecas", 50));
		System.out.println(FormataTexto.preenche(" ", 50));
		System.out.println(FormataTexto.preenche("*", 50));
		System.out.println(FormataTexto.preenche(" ", 50));
		System.out.println(FormataTexto.centraliza("1 - Conheça nosso catálogo", 50));
		System.out.println(FormataTexto.centraliza("2 - Carrinho de compras", 50));
		System.out.println(FormataTexto.centraliza("3 - Pagamento", 50));
		System.out.println(FormataTexto.centraliza("4 - Sair", 50));
		System.out.println(FormataTexto.preenche(" ", 50));
		System.out.println(FormataTexto.preenche("*", 50));
		System.out.println(FormataTexto.centraliza("Entre com a opção desejada:", 50));
		System.out.println(FormataTexto.preenche(" ", 50)+ Estetica.TEXT_RESET);
	}
	
	
	//case 1: 
	public static void catalogo() {
		cabecalho();
		Produtos.listarProdutos();
		adicionaItem();
	}
	
	public static void cabecalho() {
		//cabeçalho
		System.out.println(Estetica.TEXT_WHITE + Estetica.ANSI_PURPLE_BACKGROUND
						+  FormataTexto.preenche("*", 75));
		System.out.println(FormataTexto.centraliza("Catálogo", 75));
		System.out.println(FormataTexto.preenche("*", 75)+ Estetica.TEXT_RESET);
	}
	
	public static void adicionaItem() {
		String escolha = "";
		
		System.out.println("\nDesesja incluir produto ao carrinho? (S/N) ");
		escolha = leia.next();
		if(escolha.equalsIgnoreCase("s")) {
			add();
			catalogo();
		}
	}
	
	public static void add() {
		int compra = 0;
		
		System.out.println("\nDigite o ID do produto que deseja adicionar: ");
		compra = ScannersService.leInteiro();
		if(compra == 0) {
			return ;
		}
		carrinho.add(compra);
		Produtos.resumoProduto(compra);
		System.out.println("\nItem adicionado ao carrinho!");
	}
	
	public static void visualizarCarrinho() {
		//fazer cabeçalho do carrinho
		carrinho.visualizaItens();
		
	}

}
