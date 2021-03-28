package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Pessoa_fisica_conex {
    private final Connection conexao;

    public Pessoa_fisica_conex(Connection conexao) {
        this.conexao = conexao;
    }

    public void inserir_pessoa_fisica2(String Nome,String email,String telefone,String CPF) throws SQLException{
        String sql_code = "INSERT INTO pessoa_fisica (nome,email,telefone,CPF) VALUES" + "('"+Nome+"','"+email+"','"
                +telefone+"','"+CPF+"');";
        PreparedStatement statement = conexao.prepareStatement(sql_code);
        statement.execute();

    }
}
