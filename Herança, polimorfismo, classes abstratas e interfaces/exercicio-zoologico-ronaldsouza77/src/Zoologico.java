import java.util.ArrayList;

public class Zoologico {
    //listas de animais
    private ArrayList<Aguia> aguias;       
    private ArrayList<Galinha> galinhas;       
    private ArrayList<Gato> gatos;
    private ArrayList<Lobo> lobos;

    public Zoologico(){//construtor
        aguias = new ArrayList<Aguia>();
        galinhas = new ArrayList<Galinha>();
        gatos = new ArrayList<Gato>();
        lobos = new ArrayList<Lobo>();
    }

    /*
     * Métodos para adicionar animais em cada lista
     */
    public void adiciona_aguia(String nome, String espécie, int quantidade_de_patas, String som_específico, Boolean voa_bem){
        Aguia aguia = new Aguia(nome, espécie, quantidade_de_patas, som_específico, voa_bem);
        aguias.add(aguia);
    }

    public void adiciona_galinha(String nome, String espécie, int quantidade_de_patas, String som_específico, Boolean voa_bem){
        Galinha galinha = new Galinha(nome, espécie, quantidade_de_patas, som_específico, voa_bem);
        galinhas.add(galinha);
    }

    public void adiciona_gato(String nome, String espécie, int quantidade_de_patas, String som_específico, String cor_dos_pelos){
        Gato gato = new Gato(nome, espécie, quantidade_de_patas, som_específico, cor_dos_pelos);
        gatos.add(gato);
    }

    public void adiciona_lobo(String nome, String espécie, int quantidade_de_patas, String som_específico, String cor_dos_pelos){
        Lobo lobo = new Lobo(nome, espécie, quantidade_de_patas, som_específico, cor_dos_pelos);
        lobos.add(lobo);
    }

    /*
     *  Busca um animal pelo nome e quando achar(se achar)
     *  retorna a descrição longa do animal
    */ 
    public String descrição_animal(String nome){
        for (Aguia a : aguias) {
            if (a.get_nome().equals(nome)) {
                return a.get_descrição_longa();
            }
        }
        for (Galinha g : galinhas) {
            if (g.get_nome().equals(nome)) {
                return g.get_descrição_longa();
            }
        }
        for (Gato g : gatos) {
            if (g.get_nome().equals(nome)) {
                return g.get_descrição_longa();
            }
        }
        for (Lobo l : lobos) {
            if (l.get_nome().equals(nome)) {
                return l.get_descrição_longa();
            }
        }
        return "Animal não encontrado!";
    }

    // retorna uma string com a descrição de todos os animais do zoológico
    public String descrição_zoologico(){
        String descrição = "Lista de animais do zoológico:"+"\n";

        for (Aguia a : aguias) {            
            descrição += a.get_descrição() +"\n";            
        }
        for (Galinha g : galinhas) {           
            descrição += g.get_descrição() +"\n";          
        }
        for (Gato g : gatos) {           
            descrição += g.get_descrição() +"\n";            
        }
        for (Lobo l : lobos) {            
            descrição += l.get_descrição() +"\n";            
        }
        return descrição;
    }

     // retorna uma string com a descrição longa de todos os animais do zoológico
    public String descrição_longa_zoologico(){
        String descrição = "Lista de animais do zoológico:"+"\n";

        for (Aguia a : aguias) {            
            descrição += a.get_descrição_longa() +"\n";            
        }
        for (Galinha g : galinhas) {           
            descrição += g.get_descrição_longa() +"\n";          
        }
        for (Gato g : gatos) {           
            descrição += g.get_descrição_longa() +"\n";            
        }
        for (Lobo l : lobos) {            
            descrição += l.get_descrição_longa() +"\n";            
        }
        return descrição;
    }
}
