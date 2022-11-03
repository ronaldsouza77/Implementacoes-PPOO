package clima;

import java.util.HashMap;

import series.SerieDados;

public abstract class ClimaSerieDados implements SerieDados{

    private String cidade;
    private int dia_inicial;
    private int dia_final;
    private HashMap< Integer, Integer> serie_dados;


    public ClimaSerieDados(String local,int dia_inicial, int dia_final){
        cidade = local;
        this.dia_inicial = dia_inicial;
        this.dia_final = dia_final;
        serie_dados = new HashMap<>();

    }

    @Override
    public int obterDiaInicial(){
        return dia_inicial;
    }

    @Override
    public int obterDiaFinal(){
        return dia_final;
    }

    @Override
    public int obterDado(int dia){
        return serie_dados.get(dia);
    }

    @Override
    public String get_cidade(){
        return cidade;
    }

    public Boolean inserir_dado(int dia, int dado){
        if((dia >= dia_inicial) && (dia <= dia_final)){
            serie_dados.put(dia,dado);
            return true;
        }else{
            return false;
        }

    }






}
