/**
 * Classe Ambiente - um ambiente em um jogo adventure.
 *
 * Esta classe é parte da aplicação "World of Zuul".
 * "World of Zuul" é um jogo de aventura muito simples, baseado em texto.  
 *
 * Um "Ambiente" representa uma localização no cenário do jogo. Ele é conectado aos 
 * outros ambientes através de saídas. As saídas são nomeadas como norte, sul, leste 
 * e oeste. Para cada direção, o ambiente guarda uma referência para o ambiente vizinho, 
 * ou null se não há saída naquela direção.
 * 
 * @author  Michael Kölling and David J. Barnes (traduzido e adaptado por Julio César Alves)
 */
import java.util.HashMap;
public class Ambiente {
    private String descricao;

    private Item item;

    private HashMap<String, Ambiente> saidas;

    public Ambiente(String descricao) {

        this.descricao = descricao;
        saidas = new HashMap<String,Ambiente>();
    }

    //construtor para ambiente com item
    public Ambiente(String descricao, Item item) {

        this.descricao = descricao;
        this.item = item;
        saidas = new HashMap<String,Ambiente>();
    }

    public void ajustarSaida(String direcao, Ambiente ambiente) {
        saidas.put(direcao, ambiente);
    }
    public String getDescricao() {
        return descricao;
    }
    public Ambiente getAmbiente(String direcao) {
        return saidas.get(direcao);
    }
    public String getSaidas() {
        String textoSaidas = "";
        for (String direcao : saidas.keySet()) {
            textoSaidas = textoSaidas + direcao + " ";
        }
        return textoSaidas;
    }

    public String getdescricaolonga(){//retorna a descrição do ambiente e os itens que há nele
        String descriçao_longa = getDescricao();
        if(tem_item() == false){
            descriçao_longa += " e não há nada de mais aqui!";
        }else{
            descriçao_longa += "E nesse local há um(a):" + item.getNome() +" "+ item.getDescrição();
        }
        return descriçao_longa;
    }

    public Boolean tem_item(){
        if(item != null){
            return true;
        }else{
            return false;
        }
    }

    public Item consulta_item(){
        if(item != null){
            return item;
        }else {
            return null;
        }
    }

    public Item coleta_item(){
        Item item_aux = item;    
        item = null;
        return item_aux;
    }

    public String getNome(){
        return item.getNome();
    }
 }