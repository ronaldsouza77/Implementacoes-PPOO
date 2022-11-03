

import corredores.Competidor;

public class Corredor implements Competidor{

    private String nome_corredor;
    private int velocidade;
    private int distancia;
    private int distancia_percorrida;
    private boolean esta_correndo;

    public Corredor(String nome, int velocidade){
        nome_corredor = nome;
        this.velocidade = velocidade;
        distancia = 0;
        distancia_percorrida = 0;
        esta_correndo = false;
    }

    public String getNome(){
        return nome_corredor;
    }

    public int getVelocidade(){
        return velocidade;
    }

    public int get_distancia(){
        return distancia;
    }

    public int getDistanciaPercorrida(){
        return distancia_percorrida;
    }

    public boolean estaCorrendo(){
        return esta_correndo;
    }

    public void prepararParaNovaCorrida(int distanciaDaCorrida){
        distancia = distanciaDaCorrida;
        distancia_percorrida = 0;
        esta_correndo = false;
    }

    public void run(){
        esta_correndo = true; 

       while(distancia_percorrida < distancia){
            try {
                distancia_percorrida++;
                Thread.sleep((1/velocidade)*1000);
            } catch (Exception e) {
                System.out.println("Execução interrompida!");
            }
        }
        esta_correndo = false;
    }   
}
