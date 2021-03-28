package database;

import java.sql.*;

import agenda1.Endereco;

import javax.print.DocFlavor;
import javax.swing.*;


public class Endereco_conex {
    private final Connection conexao;

    public Endereco_conex(Connection conexao) {
        this.conexao = conexao;
    }

    public void inserir_endereco(String rua, int num_residencia, String bairro, String cidade, String UF) throws SQLException{
        /*Statement st = conexao.createStatement();
        st.executeUpdate("INSERT INTO endereco (rua, numero, bairro, cidade, uf) VALUES " + "('"+rua+"',"+
                num_residencia+",'"+bairro+"','"+cidade+"','"+UF+"');");
*/

        String sql_code = "INSERT INTO endereco (rua, numero, bairro, cidade, uf) VALUES " + "('"+rua+"',"+
                num_residencia+",'"+bairro+"','"+cidade+"','"+UF+"');";
        PreparedStatement inserir = conexao.prepareStatement(sql_code);
        inserir.execute();

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

    public void insert_pessoajuridica_endereco(String CNPJ, String Rua, String Cidade, String UF) throws SQLException{
        Statement st = conexao.createStatement();
        st.executeQuery("SELECT id_endereco FROM endereco WHERE rua = '"+Rua+"'AND cidade = '"+Cidade+"' AND uf = '"+UF+"'");

        ResultSet rs = st.getResultSet();
        rs.next();
        int id_endereco = rs.getInt("id_endereco");
        String sql_code = "INSERT INTO pessoajuridica_endereco (CNPJ,id_endereco) VALUES ('"+CNPJ+"',"+rs+")";
        PreparedStatement inserir = conexao.prepareStatement(sql_code);
        inserir.execute();
    }

}

