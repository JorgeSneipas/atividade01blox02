import javafx.application.Application;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MainAplication extends Application {

    public static void main(String[] args) throws SQLException {
        Connection galadriel = new ConexaoSingleton().getConn();
        Connection gandalf = new ConexaoSingleton().getConn();

        if(galadriel==gandalf)
            System.out.println("As conexoes sao iguais");
        else
            System.out.println("As conexões sao diferentes");

        String sql = "Create table alunos (matricula int primary key, nome varchar(50))";

        Statement statement = galadriel.createStatement();

        statement.execute(sql);

        System.out.println("Created table alunos.");

        sql = "Insert into alunos (matricula, nome) values (1, 'Windson Gomes de Alburqueque III')";

        int rows = statement.executeUpdate(sql);



        if (rows > 0) {
            System.out.println("Inserted a new row.");
        }


        sql = "SELECT * FROM alunos";

        ResultSet resultSet = statement.executeQuery(sql);

        int count = 0;

        while (resultSet.next()) {
            count++;

            int ID = resultSet.getInt("matricula");
            String name = resultSet.getString("nome");
            System.out.println("Aluno #" + count + ": " + ID + ", " + name);
        }

        galadriel.close();

    }

    @Override
    public void start(Stage primaryStage) {

    }
}
