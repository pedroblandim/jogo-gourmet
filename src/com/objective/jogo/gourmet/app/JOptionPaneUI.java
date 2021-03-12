package com.objective.jogo.gourmet.app;

import javax.swing.JOptionPane;

import com.objective.jogo.gourmet.api.InterfaceDoUsuario;

public class JOptionPaneUI implements InterfaceDoUsuario {

	@Override
	public void apresentarFraseInicial() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void apresentarFraseDeAcerto() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean verificarAdjetivo(String adjetivo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean verificarPratoEncontrado(String pergunta) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String requisitarNovoAdjetivo(String novoPrato, String pratoEncontrado) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String requisitarNovoPrato() {
		// TODO Auto-generated method stub
		return null;
	}

}
