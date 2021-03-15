package com.objective.jogo.gourmet.app;

import com.objective.jogo.gourmet.api.ControladorDoJogo;
import com.objective.jogo.gourmet.api.InterfaceDoUsuario;


/**
 * Define o funcionamento do jogo, modificando seu estado
 * e interagindo com o usuário.
 *
 * @author pedro
 *
 */
public class JogoGourmet {

	private final ControladorDoJogo jogo;
	private final InterfaceDoUsuario _interface;
	
	public JogoGourmet(ControladorDoJogo jogo, InterfaceDoUsuario _interface) {
		this.jogo = jogo;
		this._interface = _interface;
	}
	
    public void iniciar() {
        iniciarLoopDoJogo();
    }
    
    private void iniciarLoopDoJogo() {
    	_interface.apresentarFraseInicial();
    	while(true) {
    		boolean resposta = fazerPergunta();
    		lidarComResposta(resposta);
    	}
    }

    private boolean fazerPergunta() {
    	String adjetivo = jogo.pegarAdjetivoAtual().get();
    	return _interface.verificarAdjetivo(adjetivo);
    }

	private void lidarComResposta(boolean resposta) {
		jogo.responderAdjetivoAtual(resposta);
		
		jogo.pegarPratoAtual().ifPresent(pratoEncontrado -> {
			boolean errou = !_interface.verificarPratoEncontrado(pratoEncontrado);
			
			if (errou) lidarComErro(pratoEncontrado);
			else _interface.apresentarFraseDeAcerto();
			
			voltarParaInicio();
		});
	}

	private void lidarComErro(String pratoEncontrado) {
		String novoPrato = _interface.requisitarNovoPrato();
		String adjetivoDoNovoPrato = _interface.requisitarNovoAdjetivo(novoPrato, pratoEncontrado);
		jogo.inserirPrato(novoPrato, adjetivoDoNovoPrato);
	}
	
	private void voltarParaInicio() {
		_interface.apresentarFraseInicial();
		jogo.voltarParaInicio();
	}
    
}
