package database;

import agenda1.Pessoa_fisica;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Pessoa_fisica_conex {
    private final Connection conexao;

    public Pessoa_fisica_conex(Connection conexao) {
        this.conexao = conexao;
    }

/*
    public void tested() throws SQLException {
        String sql_code = "INSERT INTO pessoa_fisica (nome,email,telefone) VALUES('abc','abcdef@gmail.com',99824-14151)" ;
        PreparedStatement inserir = conexao.prepareStatement(sql_code);
        inserir.execute();
        //conexao.close();
    }
*/

    /* No Banco de dados,se inserirmos nas tabelas filhos, a tabela mãe também vai receber a inserção (herança em BD)
     * LOGO, foi necessário criar a pessoa jurídica e fisica no pacote database para que o conceito funcione normalmente.
     */

    public void inserir_pessoa_fisica (Pessoa_fisica PF) throws SQLException {
        String sql_code = "INSERT INTO pessoa_fisica (nome,email,telefone,CPF) VALUES" + "('"+PF.getNome()+"','"+PF.getEmail()+"','"
                +PF.getTelefone()+"','"+PF.getCPF()+"');";
        PreparedStatement statement = conexao.prepareStatement(sql_code);
        statement.execute();
        conexao.close();
    }

    public void inserir_pessoa_fisica2(String Nome,String email,String telefone,String CPF) throws SQLException{
        String sql_code = "INSERT INTO pessoa_fisica (nome,email,telefone,CPF) VALUES" + "('"+Nome+"','"+email+"','"
                +telefone+"','"+CPF+"');";
        PreparedStatement statement = conexao.prepareStatement(sql_code);
        statement.execute();

    }

    public void remover_pessoa_fisica (Pessoa_fisica PF) throws  SQLException{
        String sql_code = "DELETE FROM pessoa_fisica WHERE CPF = "+PF.getCPF()+"";
        PreparedStatement inserir = conexao.prepareStatement(sql_code);
        inserir.execute();
        //conexao.close();
    }

    public void update_nome(Pessoa_fisica PF) throws SQLException{
        String sql_code = "UPDATE CLIENTE SET nome = '"+PF.getNome()+"' WHERE CPF = "+PF.getCPF()+"";
        PreparedStatement inserir = conexao.prepareStatement(sql_code);
        inserir.execute();
        //conexao.close();
    }

    public void update_email(Pessoa_fisica PF) throws SQLException{
        String sql_code = "UPDATE CLIENTE SET email = '"+PF.getEmail()+"' WHERE CPF = "+PF.getCPF()+"";
        PreparedStatement inserir = conexao.prepareStatement(sql_code);
        inserir.execute();
        //conexao.close();
    }

    public void update_telefone(Pessoa_fisica PF) throws SQLException{
        String sql_code = "UPDATE CLIENTE SET telefone = '"+PF.getTelefone()+"' WHERE CPF = "+PF.getCPF()+"";
        PreparedStatement inserir = conexao.prepareStatement(sql_code);
        inserir.execute();
        //conexao.close();
    }


}
