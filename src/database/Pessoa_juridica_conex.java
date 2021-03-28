package database;

import agenda1.Pessoa_juridica;
//mport agenda1.usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Pessoa_juridica_conex {
    private final Connection conexao;

    public Pessoa_juridica_conex(Connection conexao) {
        this.conexao = conexao;
    }

/*
    public void tested() throws SQLException {
        String sql_code = "INSERT INTO pessoa_juridica (nome,email,telefone) VALUES('abc','abcdef@gmail.com',99824-14151)" ;
        PreparedStatement inserir = conexao.prepareStatement(sql_code);
        inserir.execute();
        //conexao.close();
    }
*/

    /* No Banco de dados,se inserirmos nas tabelas filhos, a tabela mãe também vai receber a inserção (herança em BD)
    * LOGO, foi necessário criar a pessoa jurídica e fisica no pacote database para que o conceito funcione normalmente.
    */

    public void inserir_pessoa_juridica(Pessoa_juridica PJ) throws SQLException{
        String sql_code = "INSERT INTO pessoa_juridica (nome,email,telefone,CNPJ,tipo_empresa) VALUES" + "('"+PJ.getNome()+"','"+PJ.getEmail()+"','"
                +PJ.getTelefone()+"','"+PJ.getCNPJ()+"','"+PJ.getTipo_empresa()+"');";
        PreparedStatement inserir = conexao.prepareStatement(sql_code);
        inserir.execute();
        //conexao.close();
    }

    public void inserir_pessoa_juridica2(String Nome,String email,String telefone,String CNPJ, String tipo_empresa) throws SQLException{
        String sql_code = "INSERT INTO pessoa_juridica (nome,email,telefone,CNPJ,tipo_empresa) VALUES" + "('"+Nome+"','"+email+"','"
                +telefone+"','"+CNPJ+"','"+tipo_empresa+"');";
        PreparedStatement inserir = conexao.prepareStatement(sql_code);
        inserir.execute();

    }

    public void remover_pessoa_juridica(String CNPJ) throws  SQLException{
        String sql_code = "DELETE FROM pessoa_juridica WHERE CNPJ = "+CNPJ+"";
        PreparedStatement inserir = conexao.prepareStatement(sql_code);
        inserir.execute();
        //conexao.close();
    }

    public void update_nome(String NOVO_NOME,String CNPJ) throws SQLException{
        String sql_code = "UPDATE PESSOA_JURIDICA SET nome = '"+NOVO_NOME+"' WHERE CNPJ = "+CNPJ+";";
        PreparedStatement inserir = conexao.prepareStatement(sql_code);
        inserir.execute();
        //conexao.close();
    }

    public void update_email(Pessoa_juridica PJ) throws SQLException{
        String sql_code = "UPDATE PESSOA_JURIDICA SET email = '"+PJ.getEmail()+"' WHERE CNPJ = "+PJ.getCNPJ()+"";
        PreparedStatement inserir = conexao.prepareStatement(sql_code);
        inserir.execute();
        //conexao.close();
    }

    public void update_telefone(String TELEFONE_NOVO, String CNPJ) throws SQLException{
        String sql_code = "UPDATE PESSOA_JURIDICA SET telefone = '"+TELEFONE_NOVO+"' WHERE CNPJ = "+CNPJ+"";
        PreparedStatement inserir = conexao.prepareStatement(sql_code);
        inserir.execute();
        //conexao.close();
    }
    public void update_CNPJ(String CNPJ_ANTIGO, String CNPJ_NOVO) throws SQLException{
        String sql_code = "UPDATE PESSOA_JURIDICA SET CNPJ = '"+CNPJ_NOVO+"' WHERE CNPJ = "+CNPJ_ANTIGO+";";
        PreparedStatement inserir = conexao.prepareStatement(sql_code);
        inserir.execute();
        //conexao.close();
    }


}
