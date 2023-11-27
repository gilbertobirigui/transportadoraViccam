/*
Lembre-se de que o método setBounds() não só define o tamanho do componente, mas também sua posição. 
Os dois primeiros parâmetros são as coordenadas x e y, e os dois últimos são a largura e a altura.
Por outro lado, o método setSize() só define a largura e a altura do componente.
*/



package telas;

import telas.TelaCadastroEmpresa;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class TelaMenuPrincipal extends JFrame{
    
    private JFrame f;
    private JPanel p;
    private JButton btn;
    private JLabel lab;
    
    
    
    
 
  public TelaMenuPrincipal(){
      telaMenu();
  }
    




private void telaMenu(){
    f = new JFrame();
    f.setVisible(true);
    f.setSize(1000,600); // dimensoes da tela
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    f.setLocationRelativeTo(null);  // aqui ele vai deixar tela no centro monitor
    f.setTitle("Menu principal");  // titulo da tela
    f.setResizable(false); // trava o tamanho da tela
    f.setLayout(null);
    f.setLayout(new FlowLayout()); // seta o gerenciador de layout dos componentes
     
    
    // criando  barra do menu 
    JMenuBar mb = new JMenuBar();
    
        //addcionar nome na barra do menu
        JMenu arquivos = new JMenu("Arquivos");   // aqui aparece file = arquivos em portugues
        JMenu processamento = new JMenu("Processamento");   // aqui aparece file = arquivos em portugues
        JMenu relatorios = new JMenu("Relatorio");   // aqui aparece file = arquivos em portugues
        JMenu sobre = new JMenu("Sobre");   // aqui aparece file = arquivos em portugues
        JMenu sair = new JMenu("Sair");   // aqui aparece file = arquivos em portugues
        mb.add(arquivos);  // adicionando o objeto file na barra 
        mb.add(processamento);  // adicionando o objeto file na barra 
        mb.add(relatorios); 
        mb.add(sobre); 
        mb.add(sair); 
        
        JMenuItem btnItemEmp = new JMenuItem("Cadastro de Empresas");
        JMenuItem btnItemCli = new JMenuItem("Cadastro de Clientes");
        arquivos.add(btnItemEmp);
        arquivos.add(btnItemCli);
        
        
    f.setJMenuBar(mb);
    
      // Chamando os Metodos Salvar e Novo Usuario 
     //   btnItemEmp.addActionListener(this::entrarEmpresa);
    
    
    btnItemEmp.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            TelaCadastroEmpresa telaEmpresa = new TelaCadastroEmpresa();
            f.dispose();
        }
    });
       
 
    //private void entrarEmpresa(ActionEvent e) {
        // chamando tela principal do menu
    //    TelaCadastroEmpresa telaEmpresa = new TelaCadastroEmpresa();
    //    this.dispose();
   // }
    
    

}


/*
 JSeparator linha = new JSeparator();
    linha.setBounds(0, 50, 1000, 10); 
    linha.setBackground(Color.PINK);
    p.add(linha);
    
*/



}