package ECommerce.Model;

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
		System.out.println(FormataTexto.formata(" ID:" + this.id, 75));
		System.out.println(FormataTexto.formata(" Produto: " + this.nome, 75));
		System.out.println(FormataTexto.formata(" Sobre: " + this.descricao, 75));
		System.out.println(FormataTexto.formata(" " + formatarValor(this.valor), 75));
	}
	//formata valor do item
	public static String formatarValor(double valor) {
		NumberFormat nf = NumberFormat.getCurrencyInstance();
		nf.setMinimumFractionDigits(2);
		//String valorFormatado = new String();
		String valorFormatado = nf.format(valor);
		return valorFormatado;
	}

}
