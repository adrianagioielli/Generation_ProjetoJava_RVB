package ECommerce.Controller;

import java.util.ArrayList;
import java.util.List;

import ECommerce.Util.FormataTexto;
import ECommerce.Controller.Produtos;
import ECommerce.Model.Produto;


public class Carrinho {
	
	private List<Integer> carrinho = new ArrayList<Integer>();
	
	public boolean add(int id) {
		if(id < 1) {
			return false;
		}
		return carrinho.add(id);
	}
	
	public void visualizaItens() {
		for(Integer item: carrinho) {
			Produtos.resumoProduto(item);
		}
	}
	
	public void visualizaTotal() {
		double somaTotal = 0;
		
		for(Integer item: carrinho) {
			Produto p = Produtos.buscaCatalogo(item);
			somaTotal += p.getValor(); 
		}
		System.out.println(FormataTexto.formata(" " + Produto.formatarValor(somaTotal), 50));
	}

}
