package com.objective.jogo.gourmet.api;

import java.util.Optional;

public interface ControladorDoJogo {
    
    public Optional<String> pegarAdjetivoAtual();
    public Optional<String> pegarPratoAtual();
	public void responderAdjetivoAtual(boolean resposta);
	public void inserirPrato(String prato, String adjetivo);
	public void voltarParaInicio();

}
