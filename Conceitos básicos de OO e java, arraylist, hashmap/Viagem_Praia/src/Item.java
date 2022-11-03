public class Item {
    private String nome;
    private String descrição;
    private double peso;

    public Item (String nome, String descrição, double peso){//construtor
        
        this.nome = nome;
        this.descrição = descrição;
        this.peso = peso;

    }

    public String getNome() {
        return nome;
    }

    public double getPeso() {
        return peso;
    }
   
    public String getDescrição() {
        return descrição;
    }
}
