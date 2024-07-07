package aplicacao;

import data.Robo;
import data.BaseDeDados;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ACMERobots extends JFrame{
    //atributos da tela inicial
    private JButton novoCadastro;
    private JButton locacoes;
    private JButton dados;
    private JPanel janelaPrincipal;

    //atributos da Tela de Gerar Relatório
    private JTable tabela;
    private JScrollPane scrollTabela;
    private JPanel telaRelatorio;


    public ACMERobots () {
        super();
        novoCadastro = new JButton("Novo Cadastro");
        locacoes = new JButton("Locações");
        dados = new JButton("Dados");
        setTitle("Página Inicial");
        setSize(350, 450);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setLocationRelativeTo(null); // centraliza a janela na tela

        janelaPrincipal = new JPanel();
        janelaPrincipal.setLayout(new BoxLayout(janelaPrincipal, BoxLayout.Y_AXIS));

        // estrutura os botoes com espaçamento
        janelaPrincipal.add(Box.createVerticalStrut(125));
        janelaPrincipal.add(novoCadastro);
        janelaPrincipal.add(Box.createVerticalStrut(25));
        janelaPrincipal.add(locacoes);
        janelaPrincipal.add(Box.createVerticalStrut(25));
        janelaPrincipal.add(dados);
        add(janelaPrincipal);

        // centraliza os botoes
        novoCadastro.setAlignmentX(Component.CENTER_ALIGNMENT);
        locacoes.setAlignmentX(Component.CENTER_ALIGNMENT);
        dados.setAlignmentX(Component.CENTER_ALIGNMENT);


        // faz os botoes abrirem novos JPanels
        JPanel painelCadastro = criaPainelCadastros();
        JPanel painelLocacoes = criaPainelLocacoes();
        JPanel painelDados = criaPainelDados();

        novoCadastro.addActionListener(e -> trocarPainel(criaPainelCadastros()));
        locacoes.addActionListener(e -> trocarPainel(criaPainelLocacoes()));
        dados.addActionListener(e -> trocarPainel(criaPainelDados()));

        setVisible(true);
    }

    private JPanel criaPainelCadastros() {
        JPanel painel = new JPanel();

        JButton voltar = new JButton("Voltar");
        voltar.addActionListener(e -> trocarPainel(janelaPrincipal));

        JButton botaoNovoCliente = new JButton("Cadastrar novo cliente");
        JButton botaoNovoRobo = new JButton("Cadastrar novo robô");
        JButton botaoNovaLocacao = new JButton("Cadastrar nova locação");

        botaoNovoCliente.addActionListener(e -> trocarPainel(criaTelaCadastroCliente()));
        botaoNovoRobo.addActionListener(e -> trocarPainel(criaTelaCadastroRobo()));

        painel.setLayout(new BoxLayout(painel, BoxLayout.Y_AXIS));
        JLabel label = new JLabel("Cadastros");
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        voltar.setAlignmentX(Component.CENTER_ALIGNMENT);
        botaoNovoCliente.setAlignmentX(Component.CENTER_ALIGNMENT);
        botaoNovoRobo.setAlignmentX(Component.CENTER_ALIGNMENT);
        botaoNovaLocacao.setAlignmentX(Component.CENTER_ALIGNMENT);

        painel.add(Box.createVerticalGlue());
        painel.add(label);
        painel.add(Box.createVerticalStrut(25));
        painel.add(botaoNovoCliente);
        painel.add(Box.createVerticalStrut(25));
        painel.add(botaoNovoRobo);
        painel.add(Box.createVerticalStrut(25));
        painel.add(botaoNovaLocacao);
        painel.add(Box.createVerticalStrut(25));
        painel.add(voltar);
        painel.add(Box.createVerticalGlue());

        return painel;
    }

    private JPanel criaPainelLocacoes() {
        JPanel painel = new JPanel();

        JButton voltar = new JButton("Voltar");
        voltar.addActionListener(e -> trocarPainel(janelaPrincipal));

        JButton botaoConsultaLocacoes = new JButton("Consultar todas as Locações");
        JButton botaoProcessaLocacoes = new JButton("Processar Locações Pendentes");
        JButton botaoEditaLocacao = new JButton("Alterar Locação");

        painel.setLayout(new BoxLayout(painel, BoxLayout.Y_AXIS));
        JLabel label = new JLabel("Locações");
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        voltar.setAlignmentX(Component.CENTER_ALIGNMENT);
        botaoProcessaLocacoes.setAlignmentX(Component.CENTER_ALIGNMENT);
        botaoConsultaLocacoes.setAlignmentX(Component.CENTER_ALIGNMENT);
        botaoEditaLocacao.setAlignmentX(Component.CENTER_ALIGNMENT);

        painel.add(Box.createVerticalGlue());
        painel.add(label);
        painel.add(Box.createVerticalStrut(25));
        painel.add(botaoConsultaLocacoes);
        painel.add(Box.createVerticalStrut(25));
        painel.add(botaoProcessaLocacoes);
        painel.add(Box.createVerticalStrut(25));
        painel.add(botaoEditaLocacao);
        painel.add(Box.createVerticalStrut(25));
        painel.add(voltar);
        painel.add(Box.createVerticalGlue());

        return painel;
    }

    private JPanel criaPainelDados() {
        JPanel painel = new JPanel();

        JButton voltar = new JButton("Voltar");
        voltar.addActionListener(e -> trocarPainel(janelaPrincipal));

        JButton botaoRelatorioGeral = new JButton("Mostrar Relatório Geral");
        JButton botaoCarregaDados = new JButton("Carregar dados");
        JButton botaoSalvaDados = new JButton("Salvar dados");

        //faz o botão ler os dados de arquivo csv
        botaoCarregaDados.addActionListener(e -> new BaseDeDados());
        botaoRelatorioGeral.addActionListener(e -> trocarPainel(criaTelaRelatorio()));

        painel.setLayout(new BoxLayout(painel, BoxLayout.Y_AXIS));
        JLabel label = new JLabel("Dados");
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        voltar.setAlignmentX(Component.CENTER_ALIGNMENT);
        botaoRelatorioGeral.setAlignmentX(Component.CENTER_ALIGNMENT);
        botaoCarregaDados.setAlignmentX(Component.CENTER_ALIGNMENT);
        botaoSalvaDados.setAlignmentX(Component.CENTER_ALIGNMENT);

        painel.add(Box.createVerticalGlue());
        painel.add(label);
        painel.add(Box.createVerticalStrut(25));
        painel.add(botaoRelatorioGeral);
        painel.add(Box.createVerticalStrut(25));
        painel.add(botaoCarregaDados);
        painel.add(Box.createVerticalStrut(25));
        painel.add(botaoSalvaDados);
        painel.add(Box.createVerticalStrut(25));
        painel.add(voltar);
        painel.add(Box.createVerticalGlue());

        return painel;
    }
    private void trocarPainel(JPanel painel) {
        getContentPane().removeAll(); // remove todo conteudo da janela atual
        add(painel);
        // garante que não haja nada no panel antes de trocar de página
        revalidate();
        repaint();
    }

    private JPanel criaTelaRelatorio(){
        JTable tabela = new JTable();
        JScrollPane scrollTabela = new JScrollPane();
        JPanel telaRelatorio = new JPanel();

        tabela.add(scrollTabela);
        telaRelatorio.add(tabela);
        add(telaRelatorio);
        setTitle("Relatório Geral");
        setSize(350, 450);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //mostrar dados na tabela


        tabela.setAlignmentX(Component.CENTER_ALIGNMENT);
        return telaRelatorio;
    }

    private JPanel criaTelaCadastroCliente(){
        JPanel telaCadastroCliente = new JPanel(new GridBagLayout());
        JTextField campoCodigo = new JTextField(15);
        JTextField campoNome = new JTextField(30);
        JLabel label = new JLabel("Novo Cadastro de Cliente");
        JLabel codigo = new JLabel("Código");
        JLabel nome = new JLabel("Nome");

        JButton cadastrar = new JButton("Cadastrar");
        JButton voltar = new JButton("Voltar");
        voltar.addActionListener(e -> trocarPainel(criaPainelCadastros()));

        telaCadastroCliente.setLayout(new BoxLayout(telaCadastroCliente, BoxLayout.Y_AXIS));
        //cadastrar.addActionListener(e -> ); // fazer método que salva os campos nos indices do array clientes

        telaCadastroCliente.setLayout(new BoxLayout(telaCadastroCliente, BoxLayout.Y_AXIS));


        telaCadastroCliente.add(Box.createVerticalGlue());
        telaCadastroCliente.add(Box.createVerticalStrut(70));
        telaCadastroCliente.add(label);
        telaCadastroCliente.add(Box.createVerticalStrut(30));
        telaCadastroCliente.add(codigo);
        telaCadastroCliente.add(Box.createVerticalStrut(10));
        telaCadastroCliente.add(campoCodigo);
        telaCadastroCliente.add(Box.createVerticalStrut(50));
        telaCadastroCliente.add(nome);
        telaCadastroCliente.add(Box.createVerticalStrut(10));
        telaCadastroCliente.add(campoNome);
        telaCadastroCliente.add(Box.createVerticalStrut(30));
        telaCadastroCliente.add(voltar, cadastrar);
        telaCadastroCliente.add(Box.createVerticalStrut(25));
        telaCadastroCliente.add(Box.createVerticalGlue());

        add(telaCadastroCliente);

        codigo.setAlignmentX(Component.CENTER_ALIGNMENT);
        campoCodigo.setAlignmentX(Component.CENTER_ALIGNMENT);
        nome.setAlignmentX(Component.CENTER_ALIGNMENT);
        campoNome.setAlignmentX(Component.CENTER_ALIGNMENT);

        return telaCadastroCliente;
    }

    private JPanel criaTelaCadastroRobo(){
        JPanel telaCadastroRobo = new JPanel(new GridBagLayout());
        JTextField campoId = new JTextField(15);
        JTextField campoModelo = new JTextField(30);
        JLabel label = new JLabel("Novo Cadastro de Robô");
        JLabel id = new JLabel("ID");
        JLabel tipo = new JLabel("Tipo de Robô");


        JComboBox<Robo> tipoRobo = new JComboBox<>();
        JLabel modelo = new JLabel("Modelo");

        JButton cadastrar = new JButton("Cadastrar");
        JButton voltar = new JButton("Voltar");
        voltar.addActionListener(e -> trocarPainel(criaPainelCadastros()));


        telaCadastroRobo.setLayout(new BoxLayout(telaCadastroRobo, BoxLayout.Y_AXIS));
        //cadastrar.addActionListener(e -> ); // fazer método que salva os campos nos indices do array robos

        telaCadastroRobo.add(Box.createVerticalGlue());
        telaCadastroRobo.add(Box.createVerticalStrut(30));
        telaCadastroRobo.add(label);
        telaCadastroRobo.add(Box.createVerticalStrut(30));
        telaCadastroRobo.add(id);
        telaCadastroRobo.add(Box.createVerticalStrut(5));
        telaCadastroRobo.add(campoId);
        telaCadastroRobo.add(Box.createVerticalStrut(30));
        telaCadastroRobo.add(tipo);
        telaCadastroRobo.add(Box.createVerticalStrut(5));
        telaCadastroRobo.add(tipoRobo);
        telaCadastroRobo.add(Box.createVerticalStrut(50));
        telaCadastroRobo.add(modelo);
        telaCadastroRobo.add(Box.createVerticalStrut(5));
        telaCadastroRobo.add(campoModelo);
        telaCadastroRobo.add(Box.createVerticalStrut(30));
        telaCadastroRobo.add(voltar, cadastrar);
        telaCadastroRobo.add(Box.createVerticalStrut(25));
        telaCadastroRobo.add(Box.createVerticalGlue());

        add(telaCadastroRobo);

        id.setAlignmentX(Component.CENTER_ALIGNMENT);
        campoId.setAlignmentX(Component.CENTER_ALIGNMENT);
        modelo.setAlignmentX(Component.CENTER_ALIGNMENT);
        campoModelo.setAlignmentX(Component.CENTER_ALIGNMENT);

        return telaCadastroRobo;
    }
}
