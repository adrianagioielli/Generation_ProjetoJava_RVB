package ECommerce.Model;

import ECommerce.Util.Apresentacao;
import java.text.NumberFormat;

import ECommerce.Util.FormataTexto;


public class Produto {
	
	//atributos de um produto
	private String nome;
	private String descricao;
	private double valor;
	private int id;
	
	//construtor
	public Produto(int id, String nome, String descricao, double valor) {
		super();
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.valor = valor;
	}
	
	//getters e setters
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	//formata a visualização do catálogo
	public void visualizar() {
		Apresentacao.geral(" ID:" + this.id);
		Apresentacao.geral(" Produto: " + this.nome);
		Apresentacao.geral(" Sobre: " + this.descricao);
		Apresentacao.geral(" " + formatarValor(this.valor));
	}
	//formata valor do item
	public static String formatarValor(double valor) {
		NumberFormat nf = NumberFormat.getCurrencyInstance();
		nf.setMinimumFractionDigits(2);
		//String valorFormatado = new String();
		String valorFormatado = nf.format(valor);
		return valorFormatado;
	}
	
	public void visualizaResumo() {
		Apresentacao.geral(" Produto: " + nome);
		Apresentacao.geral(" " + Produto.formatarValor(valor));
	}

}
