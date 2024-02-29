package Conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class DB {
	public static Connection ConexaoDB() {
 	   	String driver = "com.mysql.cj.jdbc.Driver";
        String URL = "jdbc:mysql://localhost:3306/agendecontatos";
        String USER = "root";
        String PASS = "4200";
        Connection conexao = null;
        try {
            Class.forName(driver);
            conexao = DriverManager.getConnection(URL, USER, PASS);
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Driver não localizado: " + e.getMessage());
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Deu erro na conexão com a fonte de dados: " + e.getMessage());
        }
        return conexao;
	}
	
}
