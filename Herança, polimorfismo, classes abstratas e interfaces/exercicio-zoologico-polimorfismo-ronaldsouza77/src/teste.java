public class teste {
    public static void main(String[] args) throws Exception {
        //InterfaceUsuario iu = new InterfaceUsuario();
        //iu.executar();

        Animal animal = new Lobo("Balto", "lobo", 4, "auu", "cinza");

        System.out.println(animal.get_nome());

        animal = new Galinha("coco","Galinha", 2, "cocorico", false);

        System.out.println(animal.get_nome());

        animal =  new Lobo("Groth", "lobo", 4, "auu", "cinza");

        System.out.println(animal.get_nome());

        System.out.println(animal.get_descrição_longa());

        animal = new Galinha("Jertrudes","Galinha", 2, "cocorico", false);

        System.out.println(animal.get_nome());

        System.out.println(animal.get_descrição_longa());
    }
}
