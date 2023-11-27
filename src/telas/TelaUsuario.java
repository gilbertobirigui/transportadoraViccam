
package telas;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import java.sql.*;
import dal.ModuloConexao;
import javax.swing.JSeparator;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


/**
 * RA 21197785-5 - GILBERTO ANTONIO DA SAILVA
 * MAPA - ADSIS - PROGRAMAÇÃO II - 53/2023
 * Tela de Usuário
 */

public class TelaUsuario extends JFrame{
   
    java.sql.Connection conexao = null; // inicializado como null
    PreparedStatement pst = null;       
    ResultSet rs = null;
  
    // atributos 
    private JLabel lblNome, lblLogin, lblSenha, lblEmail, lblObs1;  // atributo lblLogin, lblSenha tipo JLabel
    private JButton btnSalvar;
    private JTextField txtId, txtNome, txtLogin, txtSenha, txtEmail;  // TextField campos entrada dados
      
    
    // Construtor 
    public TelaUsuario(){
        // chamoando metodo configura tela 
        this.TelaNovoUsuario();
        conexao = ModuloConexao.conector();
    }

    // metodo para inserir usuarios
    private void inserir(){
         // instrucao sql 
         String sql = "insert into mapa.usuario(nome, login, senha, email) values(?,?,?,?)";
         try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, txtNome.getText());
            pst.setString(2, txtLogin.getText());
            pst.setString(3, txtSenha.getText());
            pst.setString(4, txtEmail.getText());

            // validando campos obrigatorios
             if (((txtLogin.getText().isEmpty()) || (txtSenha.getText().isEmpty()))) {
                 JOptionPane.showMessageDialog(null, "Preencha todos os campos obrigatórios");
             } else {
                int inserido = pst.executeUpdate(); // add variavel inserido 1
                  
                if (inserido > 0){
                   JOptionPane.showMessageDialog(null, "Cadastrado efetuado com sucesso");
                   limparCampo();
                }
            }
    
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    // metodo configura tela
    private void TelaNovoUsuario(){
        this.setLayout(new FlowLayout()); // seta o gerenciador de layout dos componentes
        this.setSize(550, 350);  // tamanho da tela  500 largura por 300 altura
        this.setTitle("Tela de Cadastro de Usuários ");  // titulo da tela
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // passa como parametro JFrame.exit on close para fechar o programa
        this.setResizable(false); // trava o tamanho da tela
        this.setLocationRelativeTo(null);  // aqui ele vai deixar tela no centro monitor
        this.setLayout(null);
        JSeparator linha = new JSeparator();
        linha.setBounds(0, 278, 550, 10); // ajuste a posição e o tamanho conforme necessário
        this.add(linha);
        
        // Criando os jLabel da tela cadastro de usuario 20
        lblObs1  = criarLabel("* Campos obrigatórios", 360, 10);
        lblNome  = criarLabel("  Nome: ", 40, 50);
        lblLogin = criarLabel("* Login: ", 40, 95);
        lblSenha = criarLabel("* Senha: ", 40, 140);
        lblEmail = criarLabel("   Email: ", 40, 190);
    
        // criando os TextField da tela de cadastro de usuario
        txtNome = criarCampoTexto("digite o nome do usuário", 90, 50, 400, 20);
        txtLogin = criarCampoTexto("digite o login do usuário", 90, 95, 200, 20);
        txtSenha = criarCampoSenha("digite o senha para o usuário", 90, 140, 150, 20);
        txtEmail = criarCampoTexto("digite o email do usuário", 90, 190, 400, 20);

        // criando botao salvar
        btnSalvar = criarBotao("Salvar", 230, 240);
  
        // Chamando os Metodos Salvar e Novo Usuario 
        btnSalvar.addActionListener(this::salvarBtnUsuario);
        
        
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                try {
                    if (conexao != null) {
                        JOptionPane.showMessageDialog(null, "Fechando a tela cadastro de usuário "
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
    
    private void salvarBtnUsuario(ActionEvent e) {
         // chamar o metodo inserir
         inserir();

    }

    // Metodo de Criiar JLabel - ou seja nome dos campos      
    public JLabel criarLabel(String texto, int x, int y) {
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
    
    // Metodo criar botao Salvar 
    public JButton criarBotao(String texto, int x, int y) {
        JButton botao = new JButton(texto);
        botao.setBounds(x, y, 70, 20);
        botao.setFont(new Font("Arial", Font.ITALIC, 11));
        botao.setForeground(new Color(255, 255, 255));  // cor da letra
        botao.setBackground(new Color(115, 115, 115));  // cor do botao total
        add(botao);
        return botao;
    }
         
    public void limparCampo(){
        txtNome.setText("");
        txtLogin.setText("");
        txtSenha.setText("");
        txtEmail.setText("");
    }

    public JPasswordField criarCampoSenha(String toolTipText, int x, int y, int width, int height) {
        JPasswordField campoSenha = new JPasswordField();
        campoSenha.setBounds(x, y, width, height);
        campoSenha.setFont(new Font("Serif", Font.PLAIN, 14));
        campoSenha.setToolTipText(toolTipText);
        add(campoSenha);
        return campoSenha;
    }
}
 