package Matricula;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConexaoBD {
    private static Connection conn = null;
    
    private ConexaoBD(){
        try{
            Class.forName("org.gjt.mm.mysql.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/banco_1","root","");
        }catch(ClassNotFoundException e){
            System.out.println("Erro no driver de conexão "+e);
        }catch(SQLException ex){
            System.out.println("Não foi possivel conectar "+ ex);
        }
    }
    
    public static Connection conexao(){
        if(conn==null)
            new ConexaoBD();
        return conn;
    }
    

    
}
