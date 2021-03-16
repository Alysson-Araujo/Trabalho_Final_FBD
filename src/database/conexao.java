package database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class conexao {
    public Connection getConnection() throws SQLException {
        Connection conexao = DriverManager.getConnection("jdbc:postgresql://localhost:5432/agenda",
                "postgres", "2010056");
        return conexao;
    }
}
