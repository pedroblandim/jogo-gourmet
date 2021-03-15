package com.objective.jogo.gourmet.app;

import java.util.Scanner;

import com.objective.jogo.gourmet.api.InterfaceDoUsuario;

public class LinhaDeComandoUI implements InterfaceDoUsuario {

	private static final String FRASE_INICIAL 						= "Pense em um prato que gosta (pressione enter)";
	private static final String FRASE_ACERTO 						= "Acertei de novo! (pressione enter)";
	private static final String FRASE_VERIFICAR_ADJETIVO 			= "O prato que você pensou é %s? (s ou n)";
	private static final String FRASE_VERIFICAR_PRATO_ENCONTRADO 	= "O prato que você pensou é %s? (s ou n)";
	private static final String FRASE_REQUISITAR_NOVO_ADJETIVO 		= "%s é _______ mas %s não.";
	private static final String FRASE_REQUISITAR_NOVO_PRATO 		= "Qual prato você pensou?";
	
	private final Scanner scanner = new Scanner(System.in);
	
	@Override
	public void apresentarFraseInicial() {
		mostrar(FRASE_INICIAL);
	}

	@Override
	public void apresentarFraseDeAcerto() {
		mostrar(FRASE_ACERTO);
	}

	@Override
	public boolean verificarAdjetivo(String adjetivo) {
		String pergunta = String.format(FRASE_VERIFICAR_ADJETIVO, adjetivo);
		return mostrar(pergunta).equalsIgnoreCase("S") ? true : false;
	}

	@Override
	public boolean verificarPratoEncontrado(String pratoEncontrado) {
		String pergunta = String.format(FRASE_VERIFICAR_PRATO_ENCONTRADO, pratoEncontrado);
		return mostrar(pergunta).equalsIgnoreCase("S") ? true : false;
	}

	@Override
	public String requisitarNovoAdjetivo(String novoPrato, String pratoEncontrado) {
		String pergunta = String.format(FRASE_REQUISITAR_NOVO_ADJETIVO, novoPrato, pratoEncontrado);
		return mostrar(pergunta);
	}

	@Override
	public String requisitarNovoPrato() {
		String pergunta = FRASE_REQUISITAR_NOVO_PRATO; 
		return mostrar(pergunta);
	}

	private String mostrar(String pergunta) {
		System.out.println(pergunta);
		String resp = scanner.nextLine();
		return resp;
	}
}
