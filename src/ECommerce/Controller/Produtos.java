package ECommerce.Controller;
import ECommerce.Model.Produto;
import ECommerce.Repository.ProdutosRepository;
import ECommerce.Util.Apresentacao;

import java.util.ArrayList;

public class Produtos implements ProdutosRepository{

	private ArrayList<Produto> listaProdutos = new ArrayList<Produto>();
	
	
	
	public Produtos() {
		super();
		inicializaProdutos();
	}

	//inicializa produtos do catálogo
	private void inicializaProdutos() {
		listaProdutos.add(new Produto(1, "Kit Vestido de crochê", "Vestido estilo anos 1920 com flores de crochê. "
				+ "Kit acompanha chapéu e bolsa no mesmo padrão.", 25));
		listaProdutos.add(new Produto(2, "Kit terno moderno", "Camisa e calça em tecido e casaco de crochê. "
				+ "Kit acompanha bolsa carteira.", 20));
		listaProdutos.add(new Produto(3, "Vestido Praia", "Vestido em tecido estilo moderno. Acompanha bolsa "
				+ "praia.", 15));
		listaProdutos.add(new Produto(4, "Casaco de inverno", "Casaco em tecido estilo pele, corpo inteiro. "
				+ "Acompanha touca, estola e regalo.", 35));
		listaProdutos.add(new Produto(5, "Vestido longo festa", " Vestido em tecido liso, várias cores", 10));
		listaProdutos.add(new Produto(6, "Acessórios", "Sapatos, brincos, toucas e peças de baixo. Vàrias cores", 5));
	}

	//mostra o catálogo
	public void listarProdutos() {
		for(var produto : listaProdutos) {
			Apresentacao.linha();
			produto.visualizar();
			Apresentacao.separador();
		}
	}
	
	//mostra um item resumido do catálogo
	public void resumoProduto(int id) {
		Produto item = null;
		try {
			item = buscaCatalogo(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(item.getId() == id) {
			item.visualizaResumo();
		}
		
	}

	//métodos auxiliares
	public Produto buscaCatalogo(int id) {
		for(var item : listaProdutos) {
			if(item.getId() == id) {
				return item;
			}
		}
		return null;
	}
	
}
