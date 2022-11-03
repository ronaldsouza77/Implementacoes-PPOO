import java.util.List;

import clima.ControladorSeriesClima;
import series.SerieDados;
import series.VisualizadorSeries;

public class Principal {

    public void executar() {

        VisualizadorSeries visualizar;
        ControladorSeriesClima controlador;
        List<SerieDados> lista;

        controlador = new ControladorSeriesClima();
        lista = controlador.obterSeriesDados();
        visualizar = new VisualizadorSeries(lista);

        visualizar.exibir();
        /*for(SerieDados e : lista){
            System.out.println("Dados da Serie " + e.obterIdentificacaoSerie() +" em " + e.get_cidade());
            System.out.println();

            int dia_final = e.obterDiaFinal();
            int dia_inicial = e.obterDiaInicial();

            for(int i = dia_inicial; i<= dia_final; i++){
                System.out.println("Dia " + i + ": " + e.obterDado(i));
            }
            System.out.println();

        }*/
            
    }
}
