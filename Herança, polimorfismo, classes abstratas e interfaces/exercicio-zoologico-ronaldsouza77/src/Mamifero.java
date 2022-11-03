public class Mamifero extends Animal{
    //Atributo exclusivo da classe mamífero
    private String cor_dos_pelos;
    //Construtor
    public Mamifero(String nome, String espécie, int quantidade_de_patas, String som_específico, String cor_dos_pelos){
        super(nome, espécie, quantidade_de_patas, som_específico);
        this.cor_dos_pelos = cor_dos_pelos;
    }
    //retorna a cor dos pelos do mamífero
    public String get_cor_dos_pelos(){
        return cor_dos_pelos;
    }
    // descrição da classe principal(Animal) + cor dos pelos do mamífero
    public String get_descrição_longa(){
        String descrição = super.get_descrição_longa();
        descrição += " e tem pelo " + cor_dos_pelos +".";
        return descrição;
    }
    
}
