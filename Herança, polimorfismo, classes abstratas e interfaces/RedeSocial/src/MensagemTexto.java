/**
 * Subclasse da classe Mensagem que define uma Mensagem de Texto.
 * Acrescenta apenas o texto da mensagem em si
 * 
 * Esse eh um exemplo do livro: Programacao Orientada a Objetos com Java - uma 
 * introducao pratica utilizando BlueJ.
 * 
 * @author  Michael Kölling and David J. Barnes
 *          Traduzido e adaptado por Julio Cesar Alves
 */
public class MensagemTexto extends Mensagem {

    // texto da mensagem 
    private String texto;
	
    /**
     * Cria uma mensagem de texto a partir do seu autor e do proprio texto
     * 
     * @param autor Autor da mensagem
     * @param texto Texto da mensagem
     */    
    public MensagemTexto(String autor, String texto) {
        super(autor);
        this.texto = texto;
    }

    /*
     * Retorna o texto da mensagem
     */
    public String getTexto() {
        return texto;
    }
}