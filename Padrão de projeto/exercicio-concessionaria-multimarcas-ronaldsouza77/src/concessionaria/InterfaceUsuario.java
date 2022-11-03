/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package concessionaria;

import fabricaautomoveis.carros.Categoria;
import fabricaautomoveis.carros.Marca;
import java.util.Scanner;

/**
 *
 * @author julio
 */
public class InterfaceUsuario {

    private Concessionaria ppooVeiculos;
    private Scanner entrada;
    private int opcao; 
        
    public void exibir() {
        
        ppooVeiculos = new Concessionaria("PPOO Veículos", Marca.FIAT);
        entrada = new Scanner(System.in);
               
        do {
            opcao = menu();
            
            switch (opcao) {
                case 1:
                    comprarCarro();
                    break;
                case 2:
                    mudar_franquia();
                    break;
                case 3:
                    System.out.println("Até mais!");
                    break;
                default:
                    System.out.println("Opção inválida!");                   
            }
            
        } while (opcao != 3);        
    }            
    
    private int menu() {
        System.out.println("1 - Comprar Carro");
        System.out.println("2 - Mudar a franquia da concessionária");
        System.out.println("3 - Sair");
        
        return Integer.parseInt(entrada.nextLine());
    }

    private int menu_marcas(){
        System.out.println("1 - Fiat");
        System.out.println("2 - Volkswagen");
        System.out.println("3 - Chevrolet");
        
        return Integer.parseInt(entrada.nextLine());
    }

    private void comprarCarro() {        
        System.out.println("Concessionaria vende carros da: " + ppooVeiculos.getMarcaFranquia());        
        
        System.out.print("Escolha a categoria (1: Popular, 2: Pickup ou 3: Luxo): ");
        Categoria categoria = Categoria.peloID(Integer.parseInt(entrada.nextLine()));
        
        System.out.print("Escolha a cor: ");
        String cor = entrada.nextLine();
        
        if (ppooVeiculos.comprarCarro(categoria, cor)) {
            System.out.println("Parabéns!!! O carro é seu!!!");            
        }
        else {
            System.out.println("Sinto muito, não quer escolher outro?");
        }
        
        esperarTecla();
    }

    private void mudar_franquia(){

        System.out.println("Você quer comprar carros de qual Marca?");
        opcao = menu_marcas();

        switch (opcao) {
            case 1:
                ppooVeiculos.set_marca_franquia(Marca.FIAT);
                System.out.println("Franquia alterada com sucesso!");
                break;
            case 2:
                ppooVeiculos.set_marca_franquia(Marca.VW);
                System.out.println("Franquia alterada com sucesso!");
                break;
            case 3:
                ppooVeiculos.set_marca_franquia(Marca.CHEVROLET);
                System.out.println("Franquia alterada com sucesso!");
                break;
            default:
                System.out.println("Opção inválida!");                   
        }

    }
    
    private void esperarTecla() {
        entrada.nextLine();
    }
}

