import java.util.Scanner;
import java.util.ArrayList;

public class Banco {
    // Atributos do banco
    private ArrayList<Conta> contas;
    private Conta conta;
   // private Conta conta2;
    private Scanner entrada;

    public Banco(){// construtor
        entrada = new Scanner(System.in);
        contas = new ArrayList<>();
    }

    public void executar_menu(){// método que inicia o programa
        int acao;
        do{
            exibir_menu();
            System.out.println("\nDigite sua opção: ");
            acao = Integer.parseInt(entrada.nextLine());
            if(acao < 8){
                executar_acao(acao);
            }
        }while(acao != 8);

        entrada.close();
    }

    public void exibir_menu(){
        //Menu principal
        System.out.println("|===================================|");
        System.out.println("|     1 - Criar conta               |");
        System.out.println("|     2 - Consultar saldo           |");
        System.out.println("|     3 - Depositar                 |");
        System.out.println("|     4 - Sacar                     |");
        System.out.println("|     5 - Transferência             |");
        System.out.println("|     6 - Listar contas criadas     |");
        System.out.println("|     7 - Remover uma conta         |");
        System.out.println("|     8 - Sair                      |");
        System.out.println("|===================================|");
    }

    public void menu_conta(){
         //Opção para criar a conta
         System.out.println("|======================================|");
         System.out.println("|   Como você deseja criar a conta?    |");
         System.out.println("|   1-Com saldo inicial                |");
         System.out.println("|   2-Sem saldo inicial                |");
         System.out.println("|======================================|");
    }

    private void executar_acao(int acao){
        //Conforme a ação desejada pelo usuário, chamao método correspondente
        if(acao == 1){
            criar_conta();
        }else if(acao == 2){
            exibir_saldo();
        }else if(acao == 3){
            depositar();
        }else if(acao == 4){
            sacar();
        }else if(acao == 5){
            transferir();
        }else if(acao == 6){
            listar_contas();
        }else if(acao == 7){
            remover_conta();
        }
    }

    private void criar_conta(){
        menu_conta();
        int opção = Integer.parseInt(entrada.nextLine());

        if(opção == 1){//Criar conta com saldo
            System.out.println("Digite o nome do cliente:");
            String nome = entrada.nextLine();

            System.out.println("Digite o cpf do cliente:"); 
            String cpf =  entrada.nextLine();
            
            System.out.println("Digite o limite da conta:"); 
            double lim = Double.parseDouble(entrada.nextLine());

            System.out.println("Digite o saldo inicial da conta da conta:"); 
            double saldo = Double.parseDouble(entrada.nextLine());

            Cliente cliente;
            cliente = new Cliente(nome, cpf);
            
            conta = new Conta(lim,saldo,cliente);// cria uma conta
            contas.add(conta);// adiciona a conta no arraylist
            System.out.println("Número gerado para a conta:"+conta.getNumConta());
        
        }else if(opção == 2){// criar conta sem saldo
            System.out.println("Digite o nome do cliente:");
            String nome = entrada.nextLine();

            System.out.println("Digite o cpf do cliente:"); 
            String cpf =  entrada.nextLine();
            
            System.out.println("Digite o limite da conta:"); 
            double lim = Double.parseDouble(entrada.nextLine());

            Cliente cliente;
            cliente = new Cliente(nome, cpf);
        
            conta = new Conta(cliente,lim);//cria a conta
            contas.add(conta);// adiciona a conta no arraylist
            System.out.println("Número gerado para a conta:"+conta.getNumConta());
            
        }else{//entrada inválida
            System.out.println("Opção inválida!");
        }      
    }

    private void exibir_saldo(){
        // Se existir uma conta, busca o saldo segundo o num da conta digitado pelo usuário
        if(conta != null){
            System.out.println("\nQual o número da conta para consultar o saldo?");
            double num = Double.parseDouble(entrada.nextLine());

            Conta buscada = busca_conta(num);
             if(buscada != null){// se achar a conta com o respectivo num exibe o saldo
                exibe_saldo(buscada);
            }
            else{// se não imprime que não foi encontrado uma conta com o número de entrada
                System.out.println("Conta não encontrada!");
            }
        }else{//Se não existir, exibe uma mensagem que a conta não foi criada
            System.out.println("Conta não criada!");
        }      
    }

    public void exibe_saldo(Conta buscada){//Exibição do saldo
        System.out.println("Nome do titular da conta:"+buscada.getNomeCliente());
        System.out.println("Saldo:"+buscada.getSaldo());
    }

    private Conta busca_conta(double num){ //Busca uma conta no arraylist
        for(Conta conta : contas){
            if(conta.getNumConta() == num){
                return conta;// se achar retorna a conta
            }
        }
        return null;// se não retorna null
    }

    private void depositar(){
        //Verifica se a conta foi criada
        if(conta != null){
            System.out.println("\nQual o número da conta para realizar o depósito?");
            double num = Double.parseDouble(entrada.nextLine());

            Conta buscada = busca_conta(num);// busca a conta pelo num
            if(buscada != null){ //se for diferente de null executa o depósito
                depósito(buscada);
            }
            else{// se for null não encontrou
                System.out.println("Conta não encontrada!");
            }
        }else{
            System.out.println("Conta não criada!");
        }
    }

    public boolean verifica_lim_dep(double valor, Conta conta_rec){
        // verifica o limite de depósito
        if(((conta_rec.getSaldo())+valor) <= conta_rec.getLimite()){
            return true;
        }else{
            return false;
        }
    }

    public boolean verifica_lim_saq(double valor, Conta conta_rec){
        // verifica o limite de saque
        if(((conta_rec.getSaldo())-valor) >= ((conta_rec.getLimite())*(-1))){
            return true;
        }else{
            return false;
        }
    }

    private void depósito(Conta conta_rec){
        //método para realizar o depósito
        System.out.println("\nDigite o Valor para depositar: ");
        double valor_deposito =  Double.parseDouble(entrada.nextLine());

        if(verifica_lim_dep(valor_deposito, conta_rec)){//verifica se não atingiu o limite
            conta_rec.deposito(valor_deposito);
            System.out.println("Depósito efetuado com sucesso!");
        }
        else{
            System.out.println("Valor inválido! ultrapassou o limite da conta.");
        }
    }

    private void sacar(){
        //Verifica se a conta foi criada
        if(conta != null){
            System.out.println("\nQual o número da conta para realizar o saque?");
            double num = Double.parseDouble(entrada.nextLine());

            Conta buscada = busca_conta(num);// busca a conta pelo num
             if(buscada != null){//se for diferente de null executa o depósito
                saque(buscada);
            }
            else{// se for null não encontrou
                System.out.println("Conta não encontrada!");
            }
           
        }else{
            System.out.println("Conta não criada!");
        }
    }

    private void saque(Conta conta_rec){
        //Método para realizar o saque
        System.out.println("\nDigite o Valor para sacar: ");
        double valor_saque =  Double.parseDouble(entrada.nextLine());

        if(verifica_lim_saq(valor_saque, conta_rec)){//verifica o limite
            conta_rec.saque(valor_saque);
            System.out.println("Saque efetuado com sucesso!");
        }else{
            System.out.println("Valor inválido! não há saldo suficiente para o saque na conta.");
        }
    }

    private void transferir(){// Método para realizar a transferência
        //Verifica se as contas foram criadas
        if(conta != null){
            System.out.println("\nDigite o número da conta de origem: ");
            double origem =  Double.parseDouble(entrada.nextLine());

            System.out.println("\nDigite o número da conta de destino: ");
            double destino =  Double.parseDouble(entrada.nextLine());

            //verifica se o num da conta escolhido pelo usuário está no sistema
            Conta busca_origem = busca_conta(origem);
            Conta busca_destino = busca_conta(destino);

            if((busca_origem == null) || (busca_destino == null)){ // se uma das contas não for encontrada
                System.out.println("\nUma ou ambas as contas não foram encontradas no sistema!");
            }else{// se as duas foram encontradas
                System.out.println("\nDigite o Valor para transferir: ");
                double valor_transferencia =  Double.parseDouble(entrada.nextLine());

                //verifica se a transferência não vai ultrapassar o limite das contas
                if((verifica_lim_saq(valor_transferencia, busca_origem)) && (verifica_lim_dep(valor_transferencia, busca_destino))){
                    busca_origem.transferencia(valor_transferencia,busca_destino);//executa a transferência
                    System.out.println("\nTransferência executada com sucesso!");
                }else{// se uma das contas for ultrapassar o limite na transferência, é impresso um aviso apenas
                    System.out.println("\nNão foi possível realizar a transferência,uma das contas atingiu o limite!");
                }
            }
        }else{
            System.out.println("Contas não criadas!");
        }   
    }
    
    public void listar_contas(){// lista as contas do arraylist
        if(conta == null){
            System.out.println("Não foi criada nenhuma conta ainda.");
        }else{
            for(Conta conta : contas){
                if(conta != null){
                    System.out.println("Nome:"+conta.getNomeCliente()+"     "+"Número:"+conta.getNumConta());
                }
            }
        }
    }

    private void remover_conta(){

        if(conta != null){// verifica se tem conta criada
            System.out.println("\nQual o número da conta para remover?");
            double num = Double.parseDouble(entrada.nextLine());

            Conta buscada = busca_conta(num);// busca uma conta pelo num

            if(buscada != null){// se for != null, é pq achou a conta
                if(buscada.getSaldo() > 0){// se o saldo for maior que 0, emite um aviso
                    System.out.println("Não é possível cancelar contas com saldo disponível!");
                }else if(buscada.getSaldo() == 0){// se o saldo for igual a 0, remove a conta do array
                    for(int i = 0; i<contas.size(); i++){
                        if(contas.get(i).getNumConta() == num){
                            contas.remove(i);
                            System.out.println("Conta removida com sucesso!");
                        }
                    }            
                }else{// se o saldo for negativo, emite um aviso
                    System.out.println("não é possível cancelar contas em débito!");
                }

            }else{// se for == null, é pq não achou a conta
                System.out.println("Conta inexistente!");
            }
        }else{
            System.out.println("Não foi criada nenhuma conta ainda.");
        }
    }
}

