
package dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.*;   // tem q importar cojunto de bibliote para tabalhar com sql 

/*
 * RA 21197785-5 - GILBERTO ANTONIO DA SAILVA
 * MAPA - ADSIS - PROGRAMAÇÃO II - 53/2023
 * Classe ModuloConexao
 */

public class ModuloConexao {
    
    // metodo responsavel para conexao com o banco de dados
    public static Connection conector(){  // qdo nao uso void tem q ter retorno
        // criar uma variavel armazenar conexao 
        Connection conexao = null; 
        String driver = "com.mysql.cj.jdbc.Driver";  // chama o driver connector 
        String url = "jdbc:mysql://localhost:3306/mapa";  // armazena informacao ref ao banco 
        String user = "root";
        String password = "";    // senha minha G148031
        
        // estabelecendo a conexao ao banco 
        
        try {
            Class.forName(driver);
            conexao = DriverManager.getConnection(url, user, password);
            return conexao;
        } catch (Exception e) {
               // System.out.println(e);
            return null;
        }
    }
}
    
    
    
    
    
    
    
    
    
    
    
    