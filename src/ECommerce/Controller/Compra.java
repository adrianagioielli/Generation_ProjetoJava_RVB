package ECommerce.Controller;

import ECommerce.Util.Apresentacao;
import ECommerce.Util.ScannersService;

public class Compra {
	
	public void pagamento(Carrinho carrinho) {
		carrinhoFinal(carrinho);
		if(formaPgto()) {
			carrinho.esvaziaCarrinho();
		}
		
	}
	
	//exibir carrinho final
	private void carrinhoFinal(Carrinho carrinho) {
		Apresentacao.cabecalho("Finalizar compra");	
		carrinho.visualizaItens();
		carrinho.visualizaTotal();
	}
	
	//forma de pagamento
	private boolean formaPgto() {
		Apresentacao.separador();
		Apresentacao.centralizado("Escolha a forma de pagamento: ");
		Apresentacao.centralizado("1 - Boleto ");
		Apresentacao.centralizado("2 - Cartão de crédito ");
		Apresentacao.centralizado("3 - Débito/Pix");
		Apresentacao.centralizado("4 - Sair");
		Apresentacao.separador();
		Apresentacao.centralizado("Digite a opção de pagamento: ");
		int opcao = ScannersService.leInteiro();
		
		switch(opcao) {
		case 1:
			Apresentacao.geral("Boleto gerado com sucesso!");
			return true;
		case 2:
			Apresentacao.geral("Cartão autorizado!");
			Apresentacao.geral("Pagamento efetuado com sucesso!");
			return true;
		case 3:
			Apresentacao.geral("Débito/Pix recebido!");
			Apresentacao.geral("Pagamento efetuado com sucesso!");
			return true;
		case 4:
			Apresentacao.geral("Deseja salvar itens do carrinho? (S/N) ");
			String resposta = ScannersService.getLeitura().next();
			if(resposta.equalsIgnoreCase("s")) {
				return false;
			}
			return true;
		default:
			Apresentacao.geralErro("Opção não existe no menu! Tente novamente!");
			return formaPgto();
		}
	}
}
