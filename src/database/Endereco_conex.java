package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import agenda1.Endereco;


public class Endereco_conex {
    private final Connection conexao;

    public Endereco_conex(Connection conexao) {
        this.conexao = conexao;
    }

    public void inserir_endereco(Endereco endereco) throws SQLException{
        String sql_code = "INSERT INTO endereco (rua,numero,bairro,cidade,UF) VALUES" + "('"+endereco.getRua()+"',"+
                endereco.getNumero()+",'"+endereco.getBairro()+"','"+endereco.getCidade()+"','"+endereco.getUF()+"');";
        PreparedStatement inserir = conexao.prepareStatement(sql_code);
        inserir.execute();
        conexao.close();
    }

    /*
    public void remover_endereco(endereco endereco) throws SQLException{
        String sql_code = "DELETE FROM USUARIO WHERE ID = "+endereco.getID_end()+"";
        PreparedStatement inserir = conexao.prepareStatement(sql_code);
        inserir.execute();
        conexao.close();
    }
    */
    public void update_rua(Endereco endereco) throws SQLException{
        String sql_code = "UPDATE CLIENTE SET rua = '"+endereco.getRua()+"' WHERE ID = "+endereco.getID_end()+"";
        PreparedStatement inserir = conexao.prepareStatement(sql_code);
        inserir.execute();
        conexao.close();
    }

    public void update_numero(Endereco endereco) throws SQLException{
        String sql_code = "UPDATE CLIENTE SET numero = '"+endereco.getNumero()+"' WHERE ID = "+endereco.getID_end()+"";
        PreparedStatement inserir = conexao.prepareStatement(sql_code);
        inserir.execute();
        conexao.close();
    }

    public void update_bairro(Endereco endereco) throws SQLException{
        String sql_code = "UPDATE CLIENTE SET barrio = '"+endereco.getBairro()+"' WHERE ID = "+endereco.getID_end()+"";
        PreparedStatement inserir = conexao.prepareStatement(sql_code);
        inserir.execute();
        conexao.close();
    }

    public void update_cidade(Endereco endereco) throws SQLException{
        String sql_code = "UPDATE CLIENTE SET cidade = '"+endereco.getCidade()+"' WHERE ID = "+endereco.getID_end()+"";
        PreparedStatement inserir = conexao.prepareStatement(sql_code);
        inserir.execute();
        conexao.close();
    }

    public void update_UF(Endereco endereco) throws SQLException{
        String sql_code = "UPDATE CLIENTE SET UF = '"+endereco.getUF()+"' WHERE ID = "+endereco.getID_end()+"";
        PreparedStatement inserir = conexao.prepareStatement(sql_code);
        inserir.execute();
        conexao.close();
    }

}
