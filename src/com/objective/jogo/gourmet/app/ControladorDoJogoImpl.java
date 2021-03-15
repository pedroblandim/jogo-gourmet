package com.objective.jogo.gourmet.app;

import java.util.Optional;

import com.objective.jogo.gourmet.api.ControladorDoJogo;

public class ControladorDoJogoImpl implements ControladorDoJogo {

	// Um nó guarda um adjetivo ou um prato e seus dois nós filhos
	private final No raiz = criarNoInicial();
	private No noAtual = raiz;
	private No noPai;
	
	@Override
	public Optional<String> pegarAdjetivoAtual() {
		String adjetivo = noAtual.valor == null ? "null" : noAtual.valor;
		
		if(noAtualPossuiPrato()) return Optional.empty();
		return Optional.of(adjetivo);
	}

	@Override
	public Optional<String> pegarPratoAtual() {
		String prato = noAtual.valor == null ? "null" : noAtual.valor;
		
		if(!noAtualPossuiPrato()) return Optional.empty();
		return Optional.of(prato);
	}

	@Override
	public void responderAdjetivoAtual(boolean simOuNao) {
		noPai = noAtual;
		noAtual = simOuNao ? noAtual.filhoEsquerda : noAtual.filhoDireita;
	}

	@Override
	public void inserirPrato(String novoPrato, String adjetivo) {
		String pratoAtual = noAtual.valor;
		
		No novoNo;
		// Substitui o noAtual pelo o novo no
		if(noPai.filhoDireita == noAtual) {
			novoNo = noPai.filhoDireita(adjetivo).filhoDireita;			
		} else {
			novoNo = noPai.filhoEsquerda(adjetivo).filhoEsquerda;
		}
		
		novoNo.filhoEsquerda(novoPrato).filhoDireita(pratoAtual);
	}

	@Override
	public void voltarParaInicio() {
		noAtual = raiz;
	}

	private No criarNoInicial() {
		return new No()
			.valor("massa")
			.filhoEsquerda("lasanha")
			.filhoDireita("Bolo de Chocolate");
	}
	
	private boolean noAtualPossuiPrato() {
		// Os pratos se encontram nos nós que não possuem filhos
		return noAtual.isFolha();
	}
	
	private static class No {
		private String valor;
		private No filhoEsquerda;
		private No filhoDireita;
		
		No filhoEsquerda(String valorDoNo) {
			No novoNo = new No().valor(valorDoNo);
			
			this.filhoEsquerda = novoNo;
			return this;
		}
		
		No filhoDireita(String valorDoNo) {
			No novoNo = new No().valor(valorDoNo);
			
			this.filhoDireita = novoNo;
			return this;
		}
		
		No valor(String valor) {
			this.valor = valor;
			return this;
		}
		
		boolean isFolha() {
			return (filhoEsquerda == null && filhoDireita == null);
		}
	}
}
