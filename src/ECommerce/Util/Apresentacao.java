package ECommerce.Util;

public class Apresentacao {
	
	private static int tamanho = 50;
	
	public static void geral(String texto) {
		//ajustar cores fundo e texto
		System.out.println(Estetica.TEXT_WHITE_BOLD + Estetica.ANSI_PURPLE_BACKGROUND + 
				FormataTexto.formata(texto, tamanho));
	}
	
	public static void geralErro(String texto) {
		//ajustar cores fundo e texto
		
		System.out.println(Estetica.TEXT_RED_BOLD + Estetica.ANSI_WHITE_BACKGROUND + 
				FormataTexto.formata(texto, tamanho));
	}
	
	public static void centralizado(String texto) {
		System.out.println(Estetica.TEXT_WHITE_BOLD + Estetica.ANSI_PURPLE_BACKGROUND + 
				FormataTexto.centraliza(texto, tamanho));
	}
	
	public static void separador() {
		//Estetica.TEXT_WHITE + Estetica.ANSI_PURPLE_BACKGROUND
		System.out.println(Estetica.TEXT_WHITE_BOLD + Estetica.ANSI_PURPLE_BACKGROUND + 
				FormataTexto.preenche("*", tamanho));
	}
	public static void linha() {
		System.out.println(Estetica.TEXT_WHITE_BOLD + Estetica.ANSI_PURPLE_BACKGROUND + 
				FormataTexto.preenche(" ", tamanho));
	}
	
	public static void cabecalho(String texto) {
		separador();
		centralizado(texto);
		separador();
	}

}
