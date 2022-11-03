
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * Classe criada para implementar a interface gráfica da Rede Social.
 * O objetivo dessa implementação é didático! 
 * - Exercitar e apresentar conceitos de GUIs (Interfaces Gráficas de Usuário) 
 *   e Tratamento de Exceções
 * 
 * @author Julio Cesar Alves
 */
public class TelaRedeSocial {
    // Janela da nossa tela
    private JFrame janela;
    // Caixa de texto para exibir o feed de noticiai    
    private JTextArea areaTextoFeed;    
    // Botão para postar uma mensagem no feed
    private JButton botaoPostarMensagem;
    // Botão para curtir uma mensagem do feed
    private JButton botaoCurtir;
    // Botão para comentar uma mensagem do feed
    private JButton botaoComentar;
    // Botão para atualizar o feed
    private JButton botao_atualizar;
    // um painel que mostra barras de rolagem quando necessário
    private JScrollPane painel_feed;
    // fonte do feed
    private Font fonte;
    // caixa de seleção
    private JComboBox<String> caixa_selecao;

    private Boolean carregou;
    
    // Objeto que representa a Regra de Negócios (a lógica da Rede Social em si)
    private FeedNoticias feed;
    
    /**
     * Construtor da classe: cria o feed, os componentes e monta a tela.
    */
    public TelaRedeSocial() {
        feed = new FeedNoticias();
        
        construirJanela();
    }

    /**
     * Constroi os componentes e monta a janela
    */
    private void construirJanela() throws HeadlessException {
        janela = new JFrame("GUI - Rede Social");
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        criarComponentes();
        
        montarJanela();
    }

    /**
     * Cria os componentes da tela e faz a inscrição nos eventos necessários
     */
    private void criarComponentes() {
        // criando os componentes
        areaTextoFeed = new JTextArea();

        fonte = new Font("Serif", Font.ITALIC, 16);
        areaTextoFeed.setFont(fonte);

        botaoPostarMensagem = new JButton("Postar Mensagem");
        botaoCurtir = new JButton("Curtir");
        botaoComentar = new JButton("Comentar");
        botao_atualizar = new JButton("Atualizar");

        // Componente caixa de seleção de autores
        caixa_selecao = new JComboBox<>();
        //método que recarrega a caixa de seleção com os autores
        recarrega_seleção();
        
        // impede que o usuário edite a área de texto do feed
        areaTextoFeed.setEditable(false);
        
        // adiciona o método que tratará o evento de clique no botão Postar Mensagem
        botaoPostarMensagem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                postarMensagem();
            }            
        });
        
        // adiciona o método que tratará o evento de clique no botão Curtir
        botaoCurtir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                curtirMensagem();
            }
        });
        botaoComentar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                comentarMensagem();
            }
        });
        botao_atualizar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                atualizar_feed();
            }
        });
        caixa_selecao.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if(carregou){
                    atualizar_feed();
                }
            }
        });
    }

    /**
     * Monta a janela
     */
    private void montarJanela() {

        janela.setSize(500, 600);
        
        // Para mais detalhes sobre o BorderLayout acesse:
        // https://docs.oracle.com/javase/tutorial/uiswing/layout/border.html
        janela.setLayout(new BorderLayout());

        janela.add(caixa_selecao, BorderLayout.NORTH);

        JPanel informa_seleção = new JPanel();
        informa_seleção.setLayout(new BoxLayout(informa_seleção, BoxLayout.Y_AXIS));
        informa_seleção.add(new JLabel("Filtrar mensagens pelo autor"));
        informa_seleção.add(caixa_selecao);
        janela.add(informa_seleção, BorderLayout.NORTH);
        
        JPanel painelCentral = new JPanel();
        painelCentral.setLayout(new BoxLayout(painelCentral, BoxLayout.Y_AXIS));
        painelCentral.add(new JLabel("Feed de Notícias"));
        painel_feed = new JScrollPane(areaTextoFeed);
        painelCentral.add(painel_feed);
        janela.add(painelCentral, BorderLayout.CENTER);
        
        JPanel painelBotoes = new JPanel();
        painelBotoes.setLayout(new FlowLayout());
        painelBotoes.add(botaoPostarMensagem);
        painelBotoes.add(botaoCurtir);
        painelBotoes.add(botaoComentar);
        painelBotoes.add(botao_atualizar);
        janela.add(painelBotoes, BorderLayout.SOUTH);
    }

    public void recarrega_seleção(){

        carregou = false;

        caixa_selecao.removeAllItems();
        caixa_selecao.addItem("Todos");

        List<String> autores = new ArrayList<>();
        autores = feed.get_autores();

        for(String a : autores){
            caixa_selecao.addItem(a);
        }

        carregou = true;

    }
    
    /*
     * Exibe a tela da Rede Social
    */
    public void exibir() {
        janela.setVisible(true);
    }
    
    /**
     * Posta uma mensagem no feed. Solicita o autor e a mensagem ao usuário,
     * posta no Feed e atualiza a área de texto de exibição do feed.
     */
    private void postarMensagem() {
        String autor = JOptionPane.showInputDialog("Autor da mensagem");
        String mensagem = JOptionPane.showInputDialog("Texto da mensagem");        
        feed.postarMensagemTexto(autor, mensagem);        
        atualizarAreaTextoFeed();
        recarrega_seleção();
    }
    
    /**
     * Curte uma mensagem. Solicita o identificador da mensagem ao usuário,
     * curte a mensagem e atualiza a área de texto de exibição do feed.
     */
    private void curtirMensagem() {
        if(feed.nroMensagens()>0){
            Boolean num_valido = false;
            while (!num_valido) {
                try {
                    int idMensagem = Integer.parseInt(JOptionPane.showInputDialog("Id da mensagem"));
                    feed.curtir(idMensagem);
                    atualizarAreaTextoFeed();
                    num_valido = true;
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(janela, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        }else{
            JOptionPane.showMessageDialog(janela, "Ainda não há publicações para curtir!!!", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }    
    /*
     * Comenta em uma publicação. Solicita  o comentário e o id da postagem ao usuário.
     */
    private void comentarMensagem(){
        String comentário= JOptionPane.showInputDialog("Comentário");
        int idcomentario = Integer.parseInt(JOptionPane.showInputDialog("Id da mensagem"));        
        feed.comentar(idcomentario, comentário);        
        atualizarAreaTextoFeed();
    }

    /**
     * Atauliza a área de texto de exibição do Feed.
     */
    private void atualizarAreaTextoFeed() {  
        // Limpa a lista de publicações
        areaTextoFeed.setText("");

        List<Publicacao> publicacoes = new ArrayList<>();

        // Obtém as publicações do feed de notícias
        // Se a caixa de seleção for "Todos", mostra todas as publicações
        if(caixa_selecao.getSelectedItem().equals("Todos")){
            publicacoes = feed.getPublicacoes();       
        }else{ // se não, apenas as publicações do autor escolhido.
            String autor = caixa_selecao.getItemAt(caixa_selecao.getSelectedIndex());
            publicacoes = feed.getPublicacoes(autor);
        }

        // Percorre a lista de publicações adicionando na área de texto o texto da publicação
        for (Publicacao publicacao : publicacoes) {
            areaTextoFeed.append(publicacao.getTextoExibicao());
        }
    } 
    
    private void atualizar_feed(){
        atualizarAreaTextoFeed();
    }
}
