public class Animal {
    //Atributos da classe principal
    private String nome;
    private String espécie;
    private int qtd_patas;
    private String som_específico;
    // construtor
    public Animal(String nome, String espécie, int qtd_patas, String som_específico){
        this.nome = nome;
        this.espécie = espécie;
        this.qtd_patas = qtd_patas;
        this.som_específico = som_específico;
    }
    
    //geters
    public String get_nome(){
        return nome;
    }

    public String get_espécie(){
        return espécie;
    }

    public int get_qtd_patas(){
        return qtd_patas;
    }

    public String get_som_específico(){
        return som_específico;
    }

    public String get_descrição(){
        String descrição;
        descrição = nome+" "+"é um(a)"+" "+espécie;
        return descrição;
    }
    
    public String get_descrição_longa(){
        String desc_longa = get_descrição()+" que faz "+som_específico;
        return desc_longa;
    }
}
