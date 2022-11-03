package concessionaria;

import fabricaautomoveis.carros.Carro;
import fabricaautomoveis.carros.Categoria;
import fabricaautomoveis.carros.Chevrolet;
import fabricaautomoveis.carros.FIAT;
import fabricaautomoveis.carros.Marca;
import fabricaautomoveis.carros.VW;

import java.util.ArrayList;
import java.util.List;

/**
 * Representa uma concessionária que vende carros de uma determinada Marca.
 */
public class Concessionaria {
    // Nome da concessionária
    private String nome;
    // Carros da concessionária
    private List<Carro> carros;
    // Marca da qual a concessionária vende os carros
    private Marca marcaFranquia;

    private FIAT fiat_factory;
    private VW vw_factory;
    private Chevrolet chevrolet_factory;
    
    /**
     * Uma concessionária é construída com um nome e uma Marca da qual vende carros
     * @param nome O nome da concessionária.
     * @param marca A marca da qual a concessionária vende os carros
     */
    public Concessionaria(String nome, Marca marca) {
        this.nome = nome;        
        this.marcaFranquia = marca;
        carros = new ArrayList<>();
        fiat_factory = new FIAT();
        vw_factory = new VW(); 
        chevrolet_factory = new Chevrolet();    
    }
    
    /**
     * Retorna o nome da concessionária
     * 
     * @return O nome da concessionária
     */
    public String getNome() {
        return nome;
    }
    
    /**
     * Retorna a Marca da qual a concessionária vende os carros.
     * 
     * @return A marca dos carros
     */
    public Marca getMarcaFranquia() {
        return marcaFranquia;
    }

    public void set_marca_franquia(Marca marca){
        marcaFranquia = marca;
    }
    
    /**
     * Realiza a compra de um carro de uma determinada categoria e com uma cor
     * @param categoria Categoria do carro a ser comprado.
     * @param cor Cor do carro a ser comprado
     * 
     * @return Verdadeiro se o carro pode ser comprado (modelo disponível)
     */
    public boolean comprarCarro(Categoria categoria, String cor) {

        Carro carro;

        if(marcaFranquia == Marca.FIAT){
            carro = fiat_factory.criar_carro(categoria, cor);
        }else if(marcaFranquia == Marca.VW){
            carro = vw_factory.criar_carro(categoria, cor);
        }else{
            carro = chevrolet_factory.criar_carro(categoria, cor);
        }
        
        if (carro != null) {
            carro.produzir();
            carro.pintar();
            carro.liberarDocumentacao();
            carros.add(carro);
            return true;
        }
        else {
            System.out.println("Não há modelos disponíveis para essa categoria");
            return false;
        }
    }
}
