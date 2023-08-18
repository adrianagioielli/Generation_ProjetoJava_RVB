package ECommerce.Repository;

import ECommerce.Model.Produto;

public interface ProdutosRepository {
	
	public void listarProdutos();
	public void resumoProduto(int id);
	public Produto buscaCatalogo(int id);
	

}
