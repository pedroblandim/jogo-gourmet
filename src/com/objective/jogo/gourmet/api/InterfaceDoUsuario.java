package com.objective.jogo.gourmet.api;

/**
 * Classe que define como o jogo interage com
 * o usuário.
 * 
 * @author pedro
 *
 */
public interface InterfaceDoUsuario {
    
	public void apresentarFraseInicial();
	public void apresentarFraseDeAcerto();
	public boolean verificarAdjetivo(String adjetivo);
	public boolean verificarPratoEncontrado(String pratoEncontrado);
	public String requisitarNovoAdjetivo(String novoPrato, String pratoEncontrado);
	public String requisitarNovoPrato();
    
}
