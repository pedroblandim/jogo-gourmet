package com.objective.jogo.gourmet.api;

public interface InterfaceDoUsuario {
    
	public void apresentarFraseInicial();
	public void apresentarFraseDeAcerto();
	public boolean verificarAdjetivo(String adjetivo);
	public boolean verificarPratoEncontrado(String pergunta);
	public String requisitarNovoAdjetivo(String novoPrato, String pratoEncontrado);
	public String requisitarNovoPrato();
    
}
