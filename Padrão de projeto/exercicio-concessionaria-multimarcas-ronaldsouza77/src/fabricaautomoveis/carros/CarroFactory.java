package fabricaautomoveis.carros;

public interface CarroFactory {

    public abstract Carro criar_carro(Categoria categoria, String cor);
}
