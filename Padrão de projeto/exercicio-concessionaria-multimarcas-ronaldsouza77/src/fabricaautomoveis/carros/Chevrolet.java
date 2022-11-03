package fabricaautomoveis.carros;

public class Chevrolet implements CarroFactory{
    public Carro criar_carro(Categoria categoria, String cor){
        Carro carro = null;

        if (categoria == Categoria.POPULAR) {
            carro = new Onix(cor);
        }
        else if (categoria == Categoria.PICKUP) {
            carro = new S10(cor);
        }
        else if (categoria == Categoria.LUXO) {
            carro = new Cruze(cor);
        }

        return carro;

    }
    
}
