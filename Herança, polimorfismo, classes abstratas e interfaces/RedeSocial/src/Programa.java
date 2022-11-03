import java.util.Scanner;

/**
 * Parte do material das disciplinas de Orientação a Objetos
 * do Departamento de Ciência da Computação
 * da Universidade Federal de Lavras (DCC/UFLA)
 *
 * Codigo inicial incompleto usado nas aulas de Polimorfismo.
 *
 * Implementação baseada no exemplo de Barnes e Kolling
 * Prof. Julio Cesar Alves
 */
public class Programa {

    // Objeto do feed de notícias da rede social
    private FeedNoticias feed;

    // usado para obter dados do usuário via terminal
    Scanner entrada;

    /*
     * O construtor cria os atributos da classe
     */
    public Programa() {
        feed = new FeedNoticias();
        entrada = new Scanner(System.in);
    }
    
    /*
     * Executa o loop do menu do programa 
     */
    public void executar() {
        int opcao;
        do {
            exibirMenu();
            opcao = Integer.parseInt(entrada.nextLine());
            tratarOpcaoMenu(opcao);            
        } while (opcao != 4);        
    }
    
    /*
     * Exibe as opções de menu
     */
    private void exibirMenu() {
        System.out.println("\nREDE SOCIAL ");
        System.out.println("1 - Exibir o Feed de Noticias");
        System.out.println("2 - Postar mensagem de texto");
        System.out.println("3 - Postar mensagem com foto");
        System.out.println("4 - Sair\n");
        System.out.print("Digite sua opcao: ");
    }
    
    /*
     * Trata as opções do menu
     */
    private void tratarOpcaoMenu(int opcao) {
        switch (opcao) {
            case 1:
                feed.exibir();
                break;
            case 2:
                postarTexto();                
                break;
            case 3:
                postarFoto();
                break;
            case 4:
                System.out.println("\nObrigado!\n");
                break;
            default:
                System.out.println("\nOpcao Invalida!\n");
                break;
        }
    }
    
    /*
     * Trata a opção de postar uma mensagem de texto no feed de notícias
     */
    private void postarTexto() {
        String autor, mensagem;
        
        System.out.println("Digite o autor:");
        autor = entrada.nextLine();
        
        System.out.println("Digite a mensagem de texto:");
        mensagem = entrada.nextLine();
        
        feed.postarMensagemTexto(autor, mensagem);
    }
    
    /*
     * Trata a opção de postar uma mensagem com foto no feed de notícias
     */
    private void postarFoto() {
        String autor, foto, legenda;
        
        System.out.println("Digite o autor:");
        autor = entrada.nextLine();
        
        System.out.println("Digite o arquivo da foto:");
        foto = entrada.nextLine();
        
        System.out.println("Digite a legenda da foto:");
        legenda = entrada.nextLine();
        
        feed.postarMensagemFoto(autor, foto, legenda);
    }
}
