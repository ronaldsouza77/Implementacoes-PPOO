public class Carro {
    //atributos
    private String nome;
    private int velocidade;
    
    //construtor
    public Carro(String nome_carro){
        nome = nome_carro;
    }
    
    public int getVelocidade(){
        return velocidade;
    }
    
    public String getNome(){
        return nome;
    }
    
    public void acelerar(){
        velocidade +=10;
    }
    
    public void reduzir(){
        velocidade -=10;
    }
}