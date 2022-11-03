public class Cliente {
    // Atributos do cliente
    private String nome_titular;
    private String cpf;

    public Cliente(String nome, String Cpf){//Construtor
        nome_titular = nome;
        cpf = Cpf;
    }

    public String getNome(){//Retorna o nome do cliente
        return nome_titular;
    }

    public String getCpf(){//Retorna o cpf do cliente
        return cpf;
    }

}
