public class Ave extends Animal{
    //atributo exclusivo da classe Ave
    private Boolean voa_bem;
    //construtor
    public Ave(String nome, String espécie, int quantidade_de_patas, String som_específico, Boolean voa_bem){
    super(nome, espécie, quantidade_de_patas, som_específico);
        this.voa_bem = voa_bem;
    }
    //get que retorna um bool se a ave voa bem ou não
    public Boolean get_voa_bem(){
        return voa_bem;
    }
    // descrição da classe principal(Animal) + a descrição se a ave voa bem
    public String get_descrição_longa(){
        String descrição = super.get_descrição_longa();
        if(voa_bem){
            descrição += " e voa bem.";
        }else{
            descrição += " e não voa bem.";
        }
        return descrição;
    }

}
