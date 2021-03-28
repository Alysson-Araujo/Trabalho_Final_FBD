package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Pessoa_fisica_conex {
    private final Connection conexao;

    public Pessoa_fisica_conex(Connection conexao) {
        this.conexao = conexao;
    }

    /* No Banco de dados,se inserirmos nas tabelas filhos, a tabela mãe também vai receber a inserção (herança em BD)
     * LOGO, foi necessário criar a pessoa jurídica e fisica no pacote database para que o conceito funcione normalmente.
     */


    public void inserir_pessoa_fisica2(String Nome,String email,String telefone,String CPF) throws SQLException{
        String sql_code = "INSERT INTO pessoa_fisica (nome,email,telefone,CPF) VALUES" + "('"+Nome+"','"+email+"','"
                +telefone+"','"+CPF+"');";
        PreparedStatement statement = conexao.prepareStatement(sql_code);
        statement.execute();

    }



}
