
package Matricula;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Persistencia {
    public static void adiciona(Aluno aluno) {
        String sql = "INSERT INTO aluno(nome,cpf) VALUES(?,?)";
        try {
            PreparedStatement stmt = ConexaoBD.conexao().prepareStatement(sql);
            stmt.setString(1, aluno.getNome());
            stmt.setString(2, aluno.getCPF());
            System.out.println(stmt.toString());
            stmt.execute();
            stmt.close();

        } catch (SQLException u) {
            System.out.println("Não foi possivel executar o sql");
        }
    }
    
    public static ArrayList<Aluno> consulta() {
        ArrayList<Aluno> list = new ArrayList<>();

        String sql = "Select * from aluno";
        try {
            PreparedStatement stmt = ConexaoBD.conexao().prepareStatement(sql);
            ResultSet resultset = stmt.executeQuery();
            while (resultset.next()) {
                //Aluno a = new Aluno(resultset.getString(2), resultset.getString(3));
                //list.add(a);
             }                           
            stmt.close();
        } catch (SQLException u) {
            System.out.println("Não foi possivel executar o sql");
        }

        return list;

    }
}
