import java.util.*;

/**
 * Classe que define o Feed de Noticias da Rede Social.
 * Possui uma lista de mensagens que pode ser de texto ou com foto e metodos
 * para postar as mensagens e exibir todo o Feed.
 * 
 * Esse eh um exemplo do livro: Programacao Orientada a Objetos com Java - uma 
 * introducao pratica utilizando BlueJ.
 * 
 * @author  Michael Kölling and David J. Barnes
 *          Traduzido e adaptado por Julio Cesar Alves
 */
public class FeedNoticias {

    // lista de mensagens publicadas no Feed
    private ArrayList<Mensagem> mensagens;

    /**
     * Cria o Feed de Noticias (apenas inicializa a lista de mensagens)
     */
    public FeedNoticias() {
        mensagens = new ArrayList<Mensagem>();
    }

    /**
     * Metodo para postar uma mensagem de texto no feed. Cria a mensagem e a
     * adiciona na lista de mensagens.
     * 
     * @param autor Nome do autor da mensagem.
     * @param texto Texto da mensagem em si.
     */
    public void postarMensagemTexto(String autor, String texto) {
        mensagens.add(new MensagemTexto(autor, texto));
    }

    /**
     * Metodo para postar uma mensagem com foto no feed. Cria a mensagem e a
     * adiciona na lista de mensagens.
     * 
     * @param autor Nome do autor da mensagem.
     * @param arquivoFoto Nome do arquivo da foto.
     * @param legenda Legenda da foto.
     */
    public void postarMensagemFoto(String autor, String arquivoFoto,  String legenda) {
        mensagens.add(new MensagemFoto(autor, arquivoFoto, legenda));
    }

    /**
     * Metodo de exibicao do Feed de Noticiais. Percorre a lista de mensagens
     * e chama o metodo de exibicao da propria mensagem.
     */
    public void exibir() {
        for (Mensagem m : mensagens) {
            m.exibir();
        }
    }
    
    public void curtir() {
        // ... não implementado ...
    }
}