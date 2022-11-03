import java.util.*;

/**
 * Classe que representa uma mensagem em uma rede social.
 * 
 * Uma mensagem possui um autor, hora da postagem, número de curtidas e 
 * comentários. O conteudo da mensagem em si deve ser tratado em subclasses.
 * 
 * Esse eh um exemplo do livro: Programacao Orientada a Objetos com Java - uma 
 * introducao pratica utilizando BlueJ.
 * 
 * @author  Michael Kölling and David J. Barnes
 *          Traduzido e adaptado por Julio Cesar Alves
 */
public class Mensagem {
    
    // Nome do autor da mensagem
    private String autor;
    // Quantidade de curtidas que a mensagem recebeu
    private int nroCurtidas;
    // Hora na qual a mensagem foi postada (em milissegundos)
    private long horaPostagem;
    // Lista de comentários que a mensagem recebeu
    private ArrayList<String> comentarios;

    /**
     * Constroi uma mensagem a partir do nome do autor. 
     * Define automaticamente a hora da postagem; inicializa as curtidas com
     * zero e cria a lista de comentarios vazia.
     * 
     * @param autor Nome do autor da mensagem
     */
    public Mensagem(String autor) {
        this.autor = autor;
        nroCurtidas = 0;
        horaPostagem = System.currentTimeMillis();
        comentarios = new ArrayList<String>();		
    }

    /**
     * Realiza a ação de curtir uma mensagem. Na pratica apenas conta mais
     * uma curtida.
     */
    public void curtir() {
        nroCurtidas++;
    }

    /**
     * Adiciona um comentario a mensagem, recebendo apenas o texto do 
     * comentario
     * 
     * @param comentario Texto do comentario
     */
    public void comentar(String comentario) {
        comentarios.add(comentario);
    }

    /**
     * Exibe na saida padrao a mensagem formatada para aparecer no Feed de
     * Noticias. Exibe ha quanto tempo a mensagem foi publicada.
     */
    public void exibir() {
        System.out.println(autor);
        System.out.println("\t" + exibirTempo() + " - "
                + nroCurtidas + " pessoas curtiram isso!");
        exibirComentarios();
    }

    /**
     * Metodo auxiliar usado no metodo exibir para que seja exibido ha
     * quanto tempo a mensagem foi postada.
     * 
     * @return Texto com a informacao formatada
     */
    private String exibirTempo() {
        long tempoAtual = System.currentTimeMillis();
        long diferenca = (tempoAtual - horaPostagem);

        long diferencaSeg = diferenca/1000;
        long diferencaMin = diferencaSeg/60;

        if (diferencaMin < 1) {
                return "\tHa " + diferencaSeg + " segundos atras";
        }
        else {
                return "\tHa " + diferencaMin + " minutos atras";
        }
    }

    /**
     * Metodo auxiliar usado pelo metodo exibir para exibir os comentarios
     * da mensagem.
     */
    private void exibirComentarios() {
        if (comentarios.size() == 0) {
            System.out.println("\tNao ha comentarios...");
        }
        else {
            for (int i = 0; i < comentarios.size(); i++) {	
                System.out.println("\t" + comentarios.get(i));
            }
        }
    }
}