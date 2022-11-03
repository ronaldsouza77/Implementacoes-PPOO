public class Conta {
    // Atributos da conta
    private double saldo;
    private double limite;
    private double num_conta;
    private Cliente cliente;
    private static double conta = 1000;

    public Conta(Cliente cliente, double lim){
        //Construtor que cria a conta com saldo =0
        num_conta = conta;
        this.cliente = cliente;
        saldo = 0;
        limite = lim;
        conta++;
    }
   

    public Conta(double lim,double sald,Cliente cliente){
        //Construtor que cria a conta com o saldo determinado pelo usuário
        num_conta = conta;
        this.cliente = cliente;
        saldo = sald;
        limite = lim;
        conta++;
    }

    public double getSaldo() {//Retorna o saldo da conta
        return saldo;
    }

    public double getLimite(){// retorna o limite da conta
        return limite;
    }

    public double getNumConta(){// retorna o num da conta
        return num_conta;
    }

    public String getNomeCliente(){// retorna o nome do cliente da classe Cliente
        return cliente.getNome();
    }

    public void saque(double qtd){//Efetua o saque na conta
        saldo -= qtd;      
    }

    public void deposito(double qtd){  //Efetua o depósito na conta  
        saldo += qtd;
    }

    public void transferencia(double valor, Conta destino){
        saque(valor);
        destino.deposito(valor);
    }
}
