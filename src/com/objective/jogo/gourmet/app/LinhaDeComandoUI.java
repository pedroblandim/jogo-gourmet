package com.objective.jogo.gourmet.app;

import java.util.Scanner;

import com.objective.jogo.gourmet.api.InterfaceDoUsuario;

public class LinhaDeComandoUI implements InterfaceDoUsuario {

	static private final String FRASE_INICIAL 						= "Pense em um prato que gosta.";
	static private final String FRASE_ACERTO 						= "Acertei de novo.";
	private static final String FRASE_VERIFICAR_ADJETIVO 			= "O prato que você pensou é %s?";
	private static final String FRASE_VERIFICAR_PRATO_ENCONTRADO 	= "O prato que você pensou é %s.";
	private static final String FRASE_REQUISITAR_NOVO_ADJETIVO 		= "%s é _______ mas %s não.";
	private static final String FRASE_REQUISITAR_NOVO_PRATO 		= "Qual prato você pensou?";
	
	
	@Override
	public void apresentarFraseInicial() {
		esperarPorEnter(FRASE_INICIAL);
	}

	@Override
	public void apresentarFraseDeAcerto() {
		esperarPorEnter(FRASE_ACERTO);
	}

	@Override
	public boolean verificarAdjetivo(String adjetivo) {
		String pergunta = String.format(FRASE_VERIFICAR_ADJETIVO, adjetivo);
		return input(pergunta).equalsIgnoreCase("S") ? true : false;
	}

	@Override
	public boolean verificarPratoEncontrado(String pratoEncontrado) {
		String pergunta = String.format(FRASE_VERIFICAR_PRATO_ENCONTRADO, pratoEncontrado);
		return input(pergunta).equalsIgnoreCase("S") ? true : false;
	}

	@Override
	public String requisitarNovoAdjetivo(String novoPrato, String pratoEncontrado) {
		String pergunta = String.format(FRASE_REQUISITAR_NOVO_ADJETIVO, novoPrato, pratoEncontrado);
		return input(pergunta);
	}

	@Override
	public String requisitarNovoPrato() {
		String pergunta = FRASE_REQUISITAR_NOVO_PRATO; 
		return input(pergunta);
	}

	public void esperarPorEnter(String frase) {
	    Scanner scanner = new Scanner(System.in);
	    System.out.println(frase);
	    
		while(true) {
		     String input = scanner.nextLine();
		     if( !input.equals("") ) {}
		     else {
		          break;
		     }
		}
	}

	private String input(String pergunta) {
		Scanner scanner = new Scanner(System.in);
		System.out.println(pergunta);
		String resp = scanner.nextLine();
		return resp;
	}
	
}
