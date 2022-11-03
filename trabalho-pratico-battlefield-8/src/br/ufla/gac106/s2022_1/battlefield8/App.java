package br.ufla.gac106.s2022_1.battlefield8;

import br.ufla.gac106.s2022_1.baseJogo.Tela;

public class App {
    public static void main(String[] args) throws Exception {
        Jogo jogo = new Jogo(new Tela("Battlefield 8"));		
		jogo.jogar();
    }
}
