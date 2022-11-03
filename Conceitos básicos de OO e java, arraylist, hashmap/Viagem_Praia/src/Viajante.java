import java.util.ArrayList;

public class Viajante {
    private String nome;
    private ArrayList<Item> mala;

   // construtor
    public Viajante(String nome){
        this.nome = nome;
        mala = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void add_item(Item item){
        mala.add(item);
    }

    //remove um item do array
    public Item remove_item(String nome_rmv){
        for(int i = 0; i< mala.size(); i++) {
            if(mala.get(i).getNome().equals(nome_rmv)){
                Item item_aux = mala.get(i);
                mala.remove(i);
                return item_aux;
            }
        }
        return null;          
    }

    // retorna uma string com a lista de itens
    public String retorna_itens(){
        if(mala.size() == 0){
            return "Não há nada na mala!";
        }else{
            String itens_mala = "Em sua mala há:";
            for (Item item : mala) {
              itens_mala += " \n um(a)"+item.getNome() + ". ";
            }
            return itens_mala;
        }   
    }
}
