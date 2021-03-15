package com.objective.jogo.gourmet.app;

import java.awt.Component;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.objective.jogo.gourmet.api.InterfaceDoUsuario;

public class JOptionPaneUI implements InterfaceDoUsuario {

	private static final String TITLE = "Jogo Gourmet";
	
	private static final String FRASE_INICIAL 						= "Pense em um prato que gosta";
	private static final String FRASE_ACERTO 						= "Acertei de novo!";
	private static final String FRASE_VERIFICAR_ADJETIVO 			= "O prato que você pensou é %s?";
	private static final String FRASE_VERIFICAR_PRATO_ENCONTRADO 	= "O prato que você pensou é %s?";
	private static final String FRASE_REQUISITAR_NOVO_ADJETIVO 		= "%s é _______ mas %s não.";
	private static final String FRASE_REQUISITAR_NOVO_PRATO 		= "Qual prato você pensou?";
	
	private final JFrame frame = new JFrame();
	private static final String[] simOuNaoOptions = {"Sim", "Não"};
	
	
	@Override
	public void apresentarFraseInicial() {  
	    JOptionPane.showMessageDialog(frame, FRASE_INICIAL, TITLE, JOptionPane.PLAIN_MESSAGE);  
	}

	@Override
	public void apresentarFraseDeAcerto() {
	    JOptionPane.showMessageDialog(frame, FRASE_ACERTO, TITLE, JOptionPane.DEFAULT_OPTION);  
	}

	@Override
	public boolean verificarAdjetivo(String adjetivo) {
		String pergunta = String.format(FRASE_VERIFICAR_ADJETIVO, adjetivo);
	    return perguntarSimOuNao(pergunta);  
	}

	@Override
	public boolean verificarPratoEncontrado(String pratoEncontrado) {
		String pergunta = String.format(FRASE_VERIFICAR_PRATO_ENCONTRADO, pratoEncontrado);
	    return perguntarSimOuNao(pergunta);  
	}

	@Override
	public String requisitarNovoAdjetivo(String novoPrato, String pratoEncontrado) {
		String pergunta = String.format(FRASE_REQUISITAR_NOVO_ADJETIVO, novoPrato, pratoEncontrado);
		return requisitarValor(pergunta);
	}

	@Override
	public String requisitarNovoPrato() {
		String pergunta = String.format(FRASE_REQUISITAR_NOVO_PRATO);
		return requisitarValor(pergunta);
	}
	
	private boolean perguntarSimOuNao(String pergunta) {
		Component fr = new JFrame();
		return JOptionPane.showOptionDialog(fr, pergunta, TITLE, JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, simOuNaoOptions, simOuNaoOptions[0]) == JOptionPane.YES_OPTION;
	}
	
	private String requisitarValor(String pergunta) {
		return (String)JOptionPane.showInputDialog(frame, pergunta, TITLE, JOptionPane.QUESTION_MESSAGE); 
	}
}