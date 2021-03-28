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

    public void inserir_pessoa_juridica2(String Nome,String email,String telefone,String CNPJ, String tipo_empresa) throws SQLException{
        String sql_code = "INSERT INTO pessoa_juridica (nome,email,telefone,CNPJ,tipo_empresa) VALUES" + "('"+Nome+"','"+email+"','"
                +telefone+"','"+CNPJ+"','"+tipo_empresa+"');";
        PreparedStatement inserir = conexao.prepareStatement(sql_code);
        inserir.execute();
    }
}
