package clima;

import java.util.ArrayList;
import java.util.List;

import series.ControladorSeries;
import series.SerieDados;

public class ControladorSeriesClima implements ControladorSeries{
    private Temperatura temperatura;
    private Umidade umidade;
    private List<SerieDados> lista;

    public ControladorSeriesClima(){
        lista = new ArrayList<SerieDados>();
        
        temperatura = new Temperatura("Lavras", 20, 25);
        umidade = new Umidade("Lavras", 20, 25);

        temperatura.inserir_dado(20, 30);
        umidade.inserir_dado(20,55);

        temperatura.inserir_dado(21, 31);
        umidade.inserir_dado(21,53);

        temperatura.inserir_dado(22, 35);
        umidade.inserir_dado(22,49);

        temperatura.inserir_dado(23, 28);
        umidade.inserir_dado(23,57);

        temperatura.inserir_dado(24, 26);
        umidade.inserir_dado(24,70);

        temperatura.inserir_dado(25, 25);
        umidade.inserir_dado(25,74);

        lista.add(temperatura);
        lista.add(umidade);

    }

    public List<SerieDados> obterSeriesDados(){
        return lista;
    }
}
