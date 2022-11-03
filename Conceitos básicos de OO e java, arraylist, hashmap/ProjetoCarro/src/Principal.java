import java.util.Scanner;
public class Principal {
   // Carro carro1;
    private  int acao;
    private int tam = 0;
    private String nome_carro, busca;
    private Carro[] vetorDeCarros;

    public Principal(){
        vetorDeCarros = new Carro[5];
    }
    
     public void exibirMenu() {
        System.out.println("|=====================================|");
        System.out.println("|     1 - Criar o carro               |");
        System.out.println("|     2 - Acelerar o carro            |");
        System.out.println("|     3 - Reduzir a velocidade        |");
        System.out.println("|     4 - Exibir os dados do carro    |");
        System.out.println("|     5 - Sair                        |");
        System.out.println("|=====================================|");
            
    }

     public void executarAcao() {
        if(acao == 1){
            if(tam < 5){
                System.out.println("Digite o nome do carro");
                Scanner entrada = new Scanner(System.in);
                nome_carro = entrada.nextLine();
                
                vetorDeCarros[tam] = new Carro(nome_carro);          
                tam++;
               
            }else {
                System.out.println("Vetor cheio! Não é possível criar mais carros.");
            }
        }
        else if (acao == 2) {
            System.out.println("Qual carro deseja tratar?");
            Scanner entrada = new Scanner(System.in);
            busca = entrada.nextLine();
            for(int i = 0; i<tam; i++){
                if(vetorDeCarros[i].getNome().equals(busca)){
                    System.out.println("Digite quantas vezes acelerar o carro:");
                    Scanner entradaAcelerar = new Scanner(System.in);
                    int qtdAcelerar = entradaAcelerar.nextInt();
        
                    for(int x=0; x<qtdAcelerar; x++){
                        vetorDeCarros[i].acelerar();
                    }
                }
                
            }
        }
        else if(acao == 3){
            System.out.println("Qual carro deseja tratar?");
            Scanner entrada = new Scanner(System.in);
            busca = entrada.nextLine();
            for(int i = 0; i<tam; i++){
                if(vetorDeCarros[i].getNome().equals(busca)){
                    System.out.println("Digite quantas vezes reduzir a velocidade do carro:");
                    Scanner entradaReduzir = new Scanner(System.in);
                    int qtdReduzir = entradaReduzir.nextInt();

                    for(int x=0; x<qtdReduzir; x++){
                        vetorDeCarros[i].reduzir();
                    }
                }
            }
        }
        else if(acao == 4){
            for(int i = 0; i<tam; i++){
                int velocidadeCarro = this.vetorDeCarros[i].getVelocidade();
                nome_carro = vetorDeCarros[i].getNome();
                System.out.println("Carro:"+nome_carro);
                System.out.println("Velocidade:"+velocidadeCarro);
            }
       }
    }

    public void executar (){

        while(acao != 5){
            exibirMenu();
            Scanner entrada = new Scanner(System.in);
            acao = entrada.nextInt();
            if(acao != 5){
                executarAcao();
            }
            
        }
    }
}