package clima;

public class Temperatura extends ClimaSerieDados {
    

    public Temperatura(String local,int dia_inicial, int dia_final){
        super(local, dia_inicial, dia_final);

    }
    
    @Override
    public String obterIdentificacaoSerie(){
        return "Temperatura" + get_cidade();
    }
}
