
package telas;

import dal.ModuloConexao;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.text.DateFormat;
import java.util.Date;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * RA 21197785-5 - GILBERTO ANTONIO DA SAILVA
 * MAPA - ADSIS - PROGRAMAÇÃO II - 53/2023
 * Tela de login 
 */

public class TelaLogin extends JFrame {
   
    java.sql.Connection conexao = null; // inicializado da variaveis como null
    PreparedStatement pst = null;       
    ResultSet rs = null;
        
    // atributos 
    private JFrame menu;
    
    
    private JLabel lbldate,lblLogin, lblSenha, lblStatus, lblobs1, lblData;   // atributo lblLogin, lblSenha tipo JLabel
    private JButton btnEntrar, btnNovoUsuario;
    private JTextField txtLogin, txtSenha;  // 
    
    
    // Construtor 
    public TelaLogin(){
        // chamando metodo configura tela
        this.configuraTela();
        conexao = ModuloConexao.conector();
        if (conexao != null) {
            lblStatus.setText("Status: Banco de dados conectado");
            lblStatus.setFont(new Font("Arial", Font.ITALIC, 11));
        } else {
            lblStatus.setText("Status: Banco de dados nao Conectado");
            lblStatus.setFont(new Font("Arial", Font.ITALIC, 11));
        }
        lblStatus.setBounds(15, 153, 300, 20);

    }
    
    // metodo configura tela
    private void configuraTela(){
        this.setLayout(new FlowLayout()); // seta o gerenciador de layout dos componentes
        this.setSize(400, 220);  // tamanho da tela  400 largura por 220 altura
        this.setTitle("Tela de login ");  // titulo da tela
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // fechar o programa
        this.setResizable(false); // trava o tamanho da tela
        this.setLocationRelativeTo(null);  // aqui ele vai deixar tela no centro monitor
        this.setLayout(null);
        JSeparator linha = new JSeparator();
        linha.setBounds(0, 150, 400, 10); 
        this.add(linha);
   
        // Criando os jLabel da tela cadastro de usuario 20
        lblobs1  = criarLabelLogin("* Campos obrigatórios", 250, 7);
        lblLogin = criarLabelLogin("* Login: ", 35, 32);
        lblSenha = criarLabelLogin("* Senha: ", 35, 64);
        lblStatus = criarLabelLogin("* Senha: ", 105, 57);
        lblData = criarLabelLogin("Data ", 320, 154);
            
        // criando os TextField da tela de cadastro de usuario
        txtLogin = criarCampoTexto("Digite o login do usuário", 85, 34, 200, 20);
        txtSenha = criarCampoSenha("Digite o senha para o usuário", 85, 65, 100, 20);

        // criando botoes Entrar e Novo usuario
        btnEntrar = criarBotao("Entrar", 60, 110);
        
     
        // Chamando os Metodos Salvar e Novo Usuario 
        btnEntrar.addActionListener(this::entrarUsuario);
   
   
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                try {
                    if (conexao != null) {
                        JOptionPane.showMessageDialog(null, "Fechando a Tela de login "
                                + "\nFechando a conexão do banco de dados");
                        conexao.close();
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
    
        setVisible(true);
        
    }

    public static void main(String[] args){
        TelaLogin tela = new TelaLogin();
        Date data = new Date();
        DateFormat formatador = DateFormat.getDateInstance(DateFormat.SHORT);
        tela.lblData.setText(formatador.format(data));
        tela.lblData.setFont(new Font("Arial", Font.ITALIC, 11));
        tela.setVisible(true);    
    }

    private void entrarUsuario(ActionEvent e) {
        // chamando tela principal do menu
        TelaMenuPrincipal menu = new TelaMenuPrincipal();
        this.dispose();
    
    }
        
    private void cadastrarNovoUsuario(ActionEvent e) {
       TelaUsuario usuario = new TelaUsuario();
       usuario.setVisible(true);
       this.dispose();
    }
       
    // Metodo de Criar JLabel - ou seja nome dos campos      
        public JLabel criarLabelLogin(String texto, int x, int y) {
            JLabel label = new JLabel();
            label.setText(texto);
            label.setBounds(x, y, 150, 20);
            label.setFont(new Font("Serif", Font.PLAIN, 14));
            add(label);
            return label;
        }
   
        // Metodo JTextField campos do formulario
        public JTextField criarCampoTexto(String toolTipText, int x, int y, int width, int height) {
            JTextField campoTexto = new JTextField();
            campoTexto.setBounds(x, y, width, height);
            campoTexto.setFont(new Font("Serif", Font.PLAIN, 14));
            campoTexto.setToolTipText(toolTipText);
            add(campoTexto);
            return campoTexto;
        }
   
        public JPasswordField criarCampoSenha(String toolTipText, int x, int y, int width, int height) {
            JPasswordField campoSenha = new JPasswordField();
            campoSenha.setBounds(x, y, width, height);
            campoSenha.setFont(new Font("Serif", Font.PLAIN, 14));
            campoSenha.setToolTipText(toolTipText);
            add(campoSenha);
            return campoSenha;
        }
  
        public JButton criarBotao(String texto, int x, int y) {
            JButton botao = new JButton(texto);
            botao.setBounds(x, y, 80, 20);
            botao.setFont(new Font("Arial", Font.ITALIC, 11));
            botao.setForeground(new Color(255, 255, 255));  // cor da letra
            botao.setBackground(new Color(115, 115, 115));  // cor do botao total
            add(botao);
            return botao;
        }
        
        public JButton criarBotaoNovoUsuario(String texto, int x, int y) {
            JButton botaoNovoUser = new JButton(texto);
            botaoNovoUser.setBounds(x, y, 155, 20);
            botaoNovoUser.setFont(new Font("Arial", Font.ITALIC, 11));
            botaoNovoUser.setForeground(new Color(255, 255, 255));  // cor da letra
            botaoNovoUser.setBackground(new Color(115, 115, 115));  // cor do botao total
            add(botaoNovoUser);
            return botaoNovoUser;
        }

   

   
        
}
