package com.objective.jogo.gourmet;

import com.objective.jogo.gourmet.api.ControladorDoJogo;
import com.objective.jogo.gourmet.api.InterfaceDoUsuario;
import com.objective.jogo.gourmet.api.JogoGourmet;
import com.objective.jogo.gourmet.app.ControladorDoJogoImpl;
import com.objective.jogo.gourmet.app.JogoGourmetImpl;
import com.objective.jogo.gourmet.app.LinhaDeComandoUI;

// TODO JOptionPaneIU
// TODO Resolver "Resource leak: 'scanner' is never closed" em LinhaDeComandoUI
// TODO Escrever javadocs (avaliar necessidade)

public class JogoGourmetApplication {

	public static void main(String[] args) {
		ControladorDoJogo controladorDoJogo = new ControladorDoJogoImpl();
//		InterfaceDoUsuario _interface = new JOptionPanelUI();
		InterfaceDoUsuario _interface = new LinhaDeComandoUI(); // Facilitar debug
		
		JogoGourmet jogo = new JogoGourmetImpl(controladorDoJogo, _interface);
		
		jogo.iniciar();
	}
}
