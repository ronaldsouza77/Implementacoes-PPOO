import java.util.Scanner;

/*
 * Classe que trata a interface com o usuário (menu de opções)
 */
public class InterfaceUsuario {

    // Scanner para obter dados do usuário via terminal
    private Scanner entrada;
    private Zoologico zoo;

    /* 
     * Construtor da classe
     */
    public InterfaceUsuario() {
        entrada = new Scanner(System.in);
        zoo = new Zoologico();
    }

    /*
     * Método que trata o loop de exibição e tratamento do menu
     */
    public void executar() {
        int opcao;
        do {
            exibirMenu();
            
            System.out.println("\nDigite sua opção: ");
            opcao = Integer.parseInt(entrada.nextLine());

            tratarMenu(opcao);

        } while (opcao != 5);

        // fecha o objeto Scanner para liberar os seus recursos
        entrada.close();
    }

    /*
     * Método que exibe as opções de menu
     */
    public void exibirMenu() {
        System.out.println("1 - Cadastrar animal");
        System.out.println("2 - Descrever animal");
        System.out.println("3 - Listar animais");        
        System.out.println("4 - Listar animais completo");
        System.out.println("5 - Sair");
    }

    /*
     * menu que exibe as opções para cadastrar os animais
     */
    public void  exibir_menu_animal(){
        System.out.println();
        System.out.println("|===================|");
        System.out.println("|   1 - Aguia       |");
        System.out.println("|   2 - Galinha     |");
        System.out.println("|   3 - Gato        |");        
        System.out.println("|   4 - Lobo        |");
        System.out.println("|===================|");
    }

    //menu que exibe as opções para saber se ave voa bem ou não
    public void menu_voa_bem(){
       // System.out.println();
        System.out.println("|======================|");
        System.out.println("|   Essa Ave voa bem?  |");
        System.out.println("|   1 - Sim            |");
        System.out.println("|   2 - Não            |");
        System.out.println("|======================|");
    }

    /*
     * Método que trata uma opção de menu escolhida pelo usuário
     */
    private void tratarMenu(int opcao) {
        switch (opcao) {
            case 1:
                cadastrarAnimal();
                break;
            case 2:
                descreverAnimal();
                break;
            case 3:
                listarAnimais();
                break;
            case 4:
                listarAnimaisCompleto();
                break;
            case 5:
                System.out.println("Saindo do programa...");
                break;
            default:
                System.out.println("Opção inválida!");
                break;
        }

        // se o usuário não estiver saindo do programa, pede para ele digitar ENTER antes de exibir o menu novamente
        if (opcao != 5) {
            System.out.println("\nDigite ENTER para continuar!");
            entrada.nextLine();
        }
    }

    /*
     * Método auxiliar que obtém uma String do usuário
     */
    private String pedirString(String instrucao) {
        System.out.print(instrucao);
        System.out.println();
        String informacao = entrada.nextLine();
        return informacao;
    }

    /*
     * Trata a opção de menu: Cadastrar Animal
     */
    private void cadastrarAnimal() {

        System.out.print("Qual a espécie do animal?");
        exibir_menu_animal();
        int opcao = Integer.parseInt(entrada.nextLine());
        trataropçao(opcao);    
    }

    // trata a opção de qual espécie cadastrar no zoológico
    public void trataropçao(int opcao){

        String nome = pedirString("Digite o nome do animal");
        System.out.print("Quantas patas esse animal possui?");
        System.out.println();
        int qtd_patas = Integer.parseInt(entrada.nextLine());
        String som = pedirString("Qual som esse animal faz?");

        if(opcao == 1){

            if(voa_bem()) zoo.adiciona_aguia(nome, "Aguia", qtd_patas, som, true);
            else zoo.adiciona_aguia(nome, "Aguia", qtd_patas, som, false);

        }else if (opcao == 2){

            if(voa_bem()) zoo.adiciona_galinha(nome, "Galinha", qtd_patas, som, true);
            else zoo.adiciona_galinha(nome, "Galinha", qtd_patas, som, false);

        }else if (opcao == 3){

            String pelo = pedirString("Qual a cor do pelo desse animal?");
            zoo.adiciona_gato(nome, "Gato", qtd_patas, som, pelo);

        }else if (opcao == 4){
            String pelo = pedirString("Qual a cor do pelo desse animal?");
            zoo.adiciona_lobo(nome, "Lobo", qtd_patas, som, pelo);
        }
    }

    // Método que verifica com o usuário se uma ave voa bem
    public Boolean voa_bem(){

        menu_voa_bem();
        int como_voa = Integer.parseInt(entrada.nextLine());    
        if(como_voa == 1) return true;
        else return false;

    }

    /*
     * Trata a opção de menu: Descrever Animal
     */
    private void descreverAnimal() {

        String nome =  pedirString("Qual o nome do animal?");
        System.out.print(zoo.descrição_animal(nome));
    }

    /*
     * Trata a opção de menu: Listar Animais
     */
    private void listarAnimais() {

        System.out.print(zoo.descrição_zoologico());
    }

    /*
     * Trata a opção de menu: Listar Animais
     */
    private void listarAnimaisCompleto() {

        System.out.print(zoo.descrição_longa_zoologico());
    }
}