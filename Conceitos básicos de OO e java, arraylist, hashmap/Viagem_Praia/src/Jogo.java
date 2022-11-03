/**
 * Essa é a classe principal da aplicacao "World of Zull".
 * "World of Zuul" é um jogo de aventura muito simples, baseado em texto.
 * 
 * Usuários podem caminhar em um cenário. E é tudo! Ele realmente precisa ser 
 * estendido para fazer algo interessante!
 * 
 * Para jogar esse jogo, crie uma instancia dessa classe e chame o método "jogar".
 * 
 * Essa classe principal cria e inicializa todas as outras: ela cria os ambientes, 
 * cria o analisador e começa o jogo. Ela também avalia e  executa os comandos que 
 * o analisador retorna.
 * 
 * @author  Michael Kölling and David J. Barnes (traduzido e adaptado por Julio César Alves)
 */


public class Jogo {
    // analisador de comandos do jogo
    private Analisador analisador;
    // ambiente onde se encontra o jogador
    private Ambiente ambienteAtual;
    
    private Viajante jogador;
        
    /**
     * Cria o jogo e incializa seu mapa interno.
     */
    public Jogo()  {
        criarAmbientes(ambienteAtual);
        analisador = new Analisador();
    }
    /**
     * Cria todos os ambientes e liga as saidas deles
     * param ambiente todo
     */
    private void criarAmbientes(Ambiente ambiente) {
        //Ambiente reitoria, pavilhao, cantina, departamento, laboratorio;
        Ambiente lavras, belo_horizonte,são_paulo,uberlandia,rio_de_janeiro, copacabana, mar;
        Item cadeira, boia;

        cadeira = new Item("cadeira",  "para ficar de boa na areia apreciando a natureza", 2);
        boia = new Item("boia", "toda colorida, para não se afogar", 0.300);
      
        // cria os ambientes
        lavras = new Ambiente("no centro de lavras");
        belo_horizonte = new Ambiente("em belo horizonte,capital de Minas gerais");
        são_paulo = new Ambiente("em São paulo capital");
        uberlandia = new Ambiente("em uberlandia,no triângulo mineiro");
        rio_de_janeiro = new Ambiente("No Rio de Janeiro,A cidade maravilhosa");
        copacabana = new Ambiente("na praia de copacabana! o seu  destino foi alcançado!",cadeira);
        mar = new Ambiente("no mar, cuidado para não ir muito ao fundo!!",boia);

        
        // inicializa as saidas dos ambientes
        lavras.ajustarSaida("norte",belo_horizonte);
        lavras.ajustarSaida("sul",são_paulo);
        lavras.ajustarSaida("leste",rio_de_janeiro);
        lavras.ajustarSaida("oeste",uberlandia);

        belo_horizonte.ajustarSaida("sul",lavras);
        belo_horizonte.ajustarSaida("leste",rio_de_janeiro);
        belo_horizonte.ajustarSaida("oeste",uberlandia);
        
        uberlandia.ajustarSaida("leste",lavras);
        uberlandia.ajustarSaida("norte",belo_horizonte);
        uberlandia.ajustarSaida("sul",são_paulo);

        são_paulo.ajustarSaida("leste",rio_de_janeiro);
        são_paulo.ajustarSaida("oeste",uberlandia);
        são_paulo.ajustarSaida("norte", lavras);
    
        rio_de_janeiro.ajustarSaida("norte",belo_horizonte);
        rio_de_janeiro.ajustarSaida("sul",são_paulo);
        rio_de_janeiro.ajustarSaida("leste",copacabana);
        rio_de_janeiro.ajustarSaida("oeste",lavras);

        copacabana.ajustarSaida("baixo", mar);
        copacabana.ajustarSaida("oeste", rio_de_janeiro);
      
        mar.ajustarSaida("cima", copacabana);

        ambienteAtual = lavras;  // o jogo comeca em lavras

        jogador = new Viajante("jog_1");
    }

    /**
     *  Rotina principal do jogo. Fica em loop ate terminar o jogo.
     */
    public void jogar()  {
        imprimirBoasVindas();

        // Entra no loop de comando principal. Aqui nós repetidamente lemos comandos e 
        // os executamos até o jogo terminar.
                
        boolean terminado = false;
        while (! terminado) {
            Comando comando = analisador.pegarComando();
            terminado = processarComando(comando);
        }
        System.out.println("Obrigado por jogar. Até mais!");
    }

    /**
     * Imprime a mensagem de abertura para o jogador.
     */
    private void imprimirBoasVindas() {
        System.out.println();
        System.out.println("Bem-vindo á nossa viagem!");
        System.out.println("Viagem a praia é um jogo para vc alcançar o destino de férias tão aguardadas: uma praia calma e serena!");
        System.out.println();
        System.out.println("Digite 'ajuda' se você precisar de ajuda.");
        
       exibir_ambiente_atual();
    }

    /**
     * Dado um comando, processa-o (ou seja, executa-o)
     * @param comando O Comando a ser processado.
     * @return true se o comando finaliza o jogo.
     */
    private boolean processarComando(Comando comando)  {
        boolean querSair = false;

        if(comando.ehDesconhecido()) {
            System.out.println("Eu nao entendi o que voce disse...");
            return false;
        }

        String palavraDeComando = comando.getPalavraDeComando();
        if (palavraDeComando.equals("ajuda")) {
            imprimirAjuda();
        }
        else if (palavraDeComando.equals("ir")) {
            irParaAmbiente(comando);
        }
        else if (palavraDeComando.equals("sair")) {
            querSair = sair(comando);
        }else if(palavraDeComando.equals("observar")){
            observar(comando);
        }else if(palavraDeComando.equals("pegar")){
            pegar_item(comando);
        }

        return querSair;
    }

    //Método para listar onde o viajante está, e o que há na mala
    private void observar(Comando comando){
        System.out.println("Você esta " + ambienteAtual.getdescricaolonga());
        System.out.println(jogador.retorna_itens());
    }

    /**
     * Exibe informações de ajuda.
     * Aqui nós imprimimos algo bobo e enigmático e a lista de  palavras de comando
     */
    private void imprimirAjuda()  {
        System.out.println("Você esta perdido. Voce esta com sua família, mas eles não também não sabem o caminho.");
        System.out.println("O gps estragou.");
        System.out.println();
        System.out.println("Suas palavras de comando sao:");
        System.out.println("    "+ analisador.getComandos());
    }

    /** 
     * Tenta ir em uma direcao. Se existe uma saída para lá entra no novo ambiente, 
     * caso contrário imprime mensagem de erro.
     */
    private void irParaAmbiente(Comando comando)  {
        // se não há segunda palavra, não sabemos pra onde ir...
        if(!comando.temSegundaPalavra()) {            
            System.out.println("Ir pra onde?");
            return;
        }

        String direcao = comando.getSegundaPalavra();

        // Tenta sair do ambiente atual
        Ambiente proximoAmbiente = ambienteAtual.getAmbiente(direcao);
       
        

        if (proximoAmbiente == null) {
            System.out.println("Nao ha passagem!");
        }
        else {
            ambienteAtual = proximoAmbiente;
            exibir_ambiente_atual();
        }
    }

    //exibe o local que o jogador esta no momento e as saídas do ambiente
    private void exibir_ambiente_atual(){      
            
        System.out.println("Você esta " + ambienteAtual.getDescricao());       
        System.out.print("Saidas: ");
        System.out.println(ambienteAtual.getSaidas());
        System.out.println();
    }
    

    /** 
     * "Sair" foi digitado. Verifica o resto do comando pra ver se nós queremos 
     * realmente sair do jogo.
     * @return true, se este comando sai do jogo, false, caso contrário.
     */
    private boolean sair(Comando comando)  {
        if(comando.temSegundaPalavra()) {
            System.out.println("Sair o que?");
            return false;
        }
        else {
            return true;  // sinaliza que nós realmente queremos sair
        }
    }

    //método para pegar um item do ambiente
    private void pegar_item(Comando comando){
        if(!comando.temSegundaPalavra()) {            
            System.out.println("Pegar o que?");
            return;
        }

        String objeto = comando.getSegundaPalavra();
        String nome = ambienteAtual.getNome();

        if(ambienteAtual.tem_item()){
            if(nome.equals(objeto)){
                jogador.add_item(ambienteAtual.coleta_item());
                System.out.println("Item coletado com sucesso!");
            }else{
                System.out.println("Não há esse item no ambiente!");
            }
            exibir_ambiente_atual();
        }else{
            System.out.println("Não há esse item no ambiente!");
            exibir_ambiente_atual();
        }
    }
}
