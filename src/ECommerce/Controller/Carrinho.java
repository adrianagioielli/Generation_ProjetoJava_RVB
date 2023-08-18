package ECommerce.Controller;
import ECommerce.Repository.ProdutosRepository;

import java.util.ArrayList;
import java.util.List;

import ECommerce.Util.Apresentacao;
import ECommerce.Util.Estetica;
import ECommerce.Util.FormataTexto;
import ECommerce.Controller.Produtos;
import ECommerce.Model.Produto;


public class Carrinho {
	
	private List<Integer> carrinho = new ArrayList<Integer>();
	private ProdutosRepository produtos;
	
	
	//construtor
	public Carrinho(ProdutosRepository produtos) {
		super();
		this.produtos = produtos;
	}

	public boolean add(int id) {
		if(id < 1) {
			return false;
		}
		return carrinho.add(id);
	}
	
	public void visualizaItens() {
		for(Integer item: carrinho) {
			produtos.resumoProduto(item);
		}
	}
	
	public void visualizaTotal() {
		double somaTotal = 0;
		
		for(Integer item: carrinho) {
			Produto p = produtos.buscaCatalogo(item);
			somaTotal += p.getValor(); 
		}
		Apresentacao.geral("Total: " + Produto.formatarValor(somaTotal));
	}

	public void esvaziaCarrinho() {
		carrinho.clear();
		
	}

}
