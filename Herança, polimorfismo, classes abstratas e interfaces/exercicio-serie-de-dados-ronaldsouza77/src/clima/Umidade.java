package clima;

public class Umidade extends ClimaSerieDados{
    

    public Umidade(String local,int dia_inicial, int dia_final){
        super(local, dia_inicial, dia_final);

    }
    
    @Override
    public String obterIdentificacaoSerie(){
        return "Umidade" + get_cidade();
    }
}
