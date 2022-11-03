package fabricaautomoveis.carros;

public class VW implements CarroFactory {

    public Carro criar_carro(Categoria categoria, String cor){
        Carro carro = null;

        if (categoria == Categoria.POPULAR) {
            carro = new Gol(cor);
        }
        else if( categoria == Categoria.PICKUP) {
            carro = new Saveiro(cor);
        }
        else if (categoria == Categoria.LUXO) {
            carro = new Passat(cor);
        }
        return carro;

    }

}
