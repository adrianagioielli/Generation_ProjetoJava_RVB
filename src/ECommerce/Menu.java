package ECommerce;

import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

import ECommerce.Controller.Produtos;
import ECommerce.Controller.Carrinho;
import ECommerce.Controller.Compra;
import ECommerce.Util.Apresentacao;
import ECommerce.Util.Estetica;
import ECommerce.Util.FormataTexto;
import ECommerce.Util.ScannersService;
import ECommerce.Repository.ProdutosRepository;

public class Menu {
	
	private static ProdutosRepository produtos = new Produtos();
	private static Carrinho carrinho = new Carrinho(produtos); 
	private static Scanner leia = ScannersService.getLeitura();
	private static Compra compra = new Compra();
	
	public static void main(String[] args) {
	
		System.out.println(Estetica.TEXT_RESET);
		int opcao = 0;
		
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
				compra.pagamento(carrinho);
				keyPress();
				opcao = 0;
				break;
			//finaliza o programa
			case 4:
				Apresentacao.separador();
				Apresentacao.centralizado("Agradecemos pela preferência!");
				Apresentacao.centralizado("Volte sempre!!!!");
				Apresentacao.separador();
				leia.close();
				System.exit(0);			
			
				//verifica opcao inválida e retorna para menu
			default:
				Apresentacao.geralErro("Opção não existe no menu! Tente novamente");
				keyPress();
				opcao = 0;
				break;
			}
		}while(opcao == 0); 

	}
	
	public static void keyPress() {
		try {
			Apresentacao.geral("Pressione Enter para continuar: ");
			System.in.read();
		}catch(IOException e) {
			Apresentacao.geralErro("Você pressionou uma tecla diferente de Enter!");
		}
	}
	
	public static void mostraMenuPrincipal() {
		Apresentacao.separador();
		Apresentacao.linha();
		Apresentacao.centralizado("Recriar");
		Apresentacao.centralizado("Vestuário para bonecas");
		Apresentacao.linha();
		Apresentacao.separador();
		Apresentacao.linha();
		Apresentacao.centralizado("1 - Conheça nosso catálogo");
		Apresentacao.centralizado("2 - Carrinho de compras");
		Apresentacao.centralizado("3 - Pagamento");
		Apresentacao.centralizado("4 - Sair");
		Apresentacao.linha();
		Apresentacao.separador();
		Apresentacao.centralizado("Entre com a opção desejada:");
		Apresentacao.linha();
	}
	
	
	//case 1: 
	public static void catalogo() {
		Apresentacao.cabecalho("Catálogo");
		produtos.listarProdutos();
		adicionaItem();
	}
	
	public static void adicionaItem() {
		String escolha = "";
		Apresentacao.geral("Desesja incluir produto ao carrinho? (S/N) ");
		escolha = leia.next();
		if(escolha.equalsIgnoreCase("s")) {
			add();
			catalogo();
		}
	}
	
	public static void add() {
		int compra = 0;
		Apresentacao.geral("Digite o ID do produto que deseja adicionar: ");
		compra = ScannersService.leInteiro();
		if(compra == 0) {
			return ;
		}
		carrinho.add(compra);
		produtos.resumoProduto(compra);
		Apresentacao.geral("Item adicionado ao carrinho!");
	}
	
	public static void visualizarCarrinho() {
		Apresentacao.cabecalho("Carrinho");
		carrinho.visualizaItens();
		carrinho.visualizaTotal();
	}

}
