package br.ufla.gac106.s2022_1.battlefield8;

import br.ufla.gac106.s2022_1.baseJogo.Terminal;

public class AppTerminal {
    public static void main(String[] args) throws Exception {
        Jogo jogo = new Jogo(new Terminal());		
		jogo.jogar();
    }
}
