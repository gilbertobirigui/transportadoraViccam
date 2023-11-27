
package telas;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.text.DateFormat;
import java.util.Date;
import javax.swing.*;
import javax.swing.border.TitledBorder;

/**
 *
 * @author gfilm
 */



public class TelaCadastroEmpresa{
    // atributos 
    
    
    
    
    
    
    
    private JLabel lblCnpj, lblInscricao, lblEmpresa, lblNomeFantasia, lblDataCadastro, lblContato, lblDataRegistro, lblCep,
                   lblEndereco, lblNumero, lblComplemento, lblBairro, lblEstado, lblCidade, lblEmail, lblSite,lblEndCobranca,
                   lblCepCobranca, lblEstCobrancalblTelefone, lblBaiCobranca, lblCidCobranca, lblReferencai, lblTelefone, 
                   lblCelular, lblObs, lblPessoa, lblOptanteSimples, lblCategoria;
    
    
    
    private JButton btnSalvar;
    
    
    private JTextField txtCnpj, txtPessoa, txtEmpresa, txtNomeFantasia, txtContato, txtTelefone, txtCelular, txtInscricao, txtDataCadastro;    // TextField campos entrada dados
     
    
    
        
    
    
    
    
    public TelaCadastroEmpresa(){
          
           telaempresa();
           Date txtDataCadastro = new Date();  
          // DateFormat formatador = DateFormat.getDateInstance(DateFormat.SHORT);
          
          JPanel pan = new JPanel();
           pan.setBorder(BorderFactory.createTitledBorder(null, "Documentos", TitledBorder.CENTER, TitledBorder.TOP));
        
    }
    
    
    
    
    public void telaempresa(){
        JFrame f = new JFrame();
        f.setTitle("Cadastro de Empresas");  // titulo da tela
        f.setSize(900,600);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setResizable(false); // trava o tamanho da tela
        f.setLocationRelativeTo(null);  // aqui ele vai deixar tela no centro monitor
              
        JPanel p = new JPanel();
        p.setLayout(null);
        f.add(p);
        
        // y = linha
        // x = coluna
        
        // Criando os jLabel da tela cadastro de usuario 20
        //lblObs1  = criarLabel("* Campos obrigatórios", 360, 10);
               lblCnpj  = criarLabelEmpresa("Cnpj / Cpf ", 7, 50, p);
               lblPessoa = criarLabelEmpresa("Pessoa * ", 120, 50, p);
             lblEmpresa = criarLabelEmpresa("Razão Social * ", 222, 50, p);
        lblNomeFantasia = criarLabelEmpresa("Nome Fantasia ", 575, 50, p);
             lblContato = criarLabelEmpresa("Contato", 7,100, p);
             lblTelefone = criarLabelEmpresa("Telefone", 222,100, p);
             lblCelular = criarLabelEmpresa("Celular", 350,100, p);
             lblInscricao = criarLabelEmpresa("Inscrição Estadual", 500,100, p);
             lblDataCadastro = criarLabelEmpresa("Data de Registro", 670,100, p);
    
        // criando os TextField da tela de cadastro de usuario
        txtCnpj = criarCampoTexto("digite o cnpj da empresa", 7, 70, 108, 20, p);
        txtPessoa = criarCampoTexto("marque opcao fisica ou juridica ", 120, 70, 10, 20, p);
        txtEmpresa = criarCampoTexto("digite a razão social da empresa", 222, 68, 350, 20, p);
        txtNomeFantasia = criarCampoTexto("digite o nome fantasia da empresa", 575, 68, 300, 20, p);
        txtContato = criarCampoTexto("digite o contato da empresa", 7, 117, 200, 20, p);
        txtTelefone = criarCampoTexto("digite o telefone fixo da empresa", 222, 117, 100, 20, p);
        txtCelular = criarCampoTexto("digite o celular da empresa", 350, 117, 100, 20, p);
        txtInscricao = criarCampoTexto("digite a inscricao estadual", 500, 117, 150, 20, p);
        txtDataCadastro = criarCampoTexto("digite a inscricao estadual", 670, 117, 150, 20, p);
        
        
        
        // criando botao salvar
        btnSalvar = criarBotao("Salvar", 230, 240);
         JPanel pan = new JPanel();
         pan.setPreferredSize(new Dimension(40, 40)); // Define o tamanho do painel
         pan.setBorder(BorderFactory.createTitledBorder("Pessoa *"));
        
         JCheckBox fisica = new JCheckBox("Fisica");
         pan.add(fisica);
         
         
         
         f.add(pan);
         ///f.pack(); // ajusta o tamanho da janela ao tamanho do painel
        
        
        f.setVisible(true);
        
    }    
        
        
        
    // Metodo de Criar JLabel - ou seja nome dos campos      
    public JLabel criarLabelEmpresa(String texto, int x, int y, JPanel p ) {
        JLabel lbl = new JLabel();
        lbl.setText(texto);
        lbl.setBounds(x, y, 150, 20);
        lbl.setFont(new Font("Serif", Font.PLAIN, 12));
        p.add(lbl);
        return lbl;
    }

    // Metodo JTextField campos do formulario
    public JTextField criarCampoTexto(String toolTipText, int x, int y, int width, int height, JPanel p) {
        JTextField campoTexto = new JTextField();
        campoTexto.setBounds(x, y, width, height);
        campoTexto.setFont(new Font("Serif", Font.PLAIN, 12));
        campoTexto.setToolTipText(toolTipText);
        p.add(campoTexto);
        return campoTexto;
    }
    
    // Metodo criar botao Salvar 
    public JButton criarBotao(String texto, int x, int y) {
        JButton botao = new JButton(texto);
        botao.setBounds(x, y, 70, 20);
        botao.setFont(new Font("Arial", Font.ITALIC, 11));
        botao.setForeground(new Color(255, 255, 255));  // cor da letra
        botao.setBackground(new Color(115, 115, 115));  // cor do botao total
       // add(botao);
        return botao;
    }
         
    public void limparCampo(){
        txtCnpj.setText("");
     
    }

    

        
        
}
    
    
    
    
    

