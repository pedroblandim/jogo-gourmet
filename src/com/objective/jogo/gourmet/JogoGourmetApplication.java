package com.objective.jogo.gourmet;

import com.objective.jogo.gourmet.api.ControladorDoJogo;
import com.objective.jogo.gourmet.api.InterfaceDoUsuario;
import com.objective.jogo.gourmet.app.ControladorDoJogoImpl;
import com.objective.jogo.gourmet.app.JOptionPaneUI;
import com.objective.jogo.gourmet.app.JogoGourmet;


public class JogoGourmetApplication {

	public static void main(String[] args) {
		ControladorDoJogo controladorDoJogo = new ControladorDoJogoImpl();
		InterfaceDoUsuario _interface = new JOptionPaneUI();
//		InterfaceDoUsuario _interface = new LinhaDeComandoUI(); // Facilitar debug
		
		JogoGourmet jogo = new JogoGourmet(controladorDoJogo, _interface);
		
		jogo.iniciar();
	}
}
