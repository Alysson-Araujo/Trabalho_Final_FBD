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


    public void insert_pessoajuridica_endereco(String CNPJ, String Rua, String Cidade, String UF, int num_residencia) throws SQLException{

        Statement st = conexao.createStatement();
        st.executeQuery("SELECT id_endereco FROM endereco WHERE rua = '"+Rua+"' AND cidade = '"+Cidade+"' AND uf = '"+UF+"' AND numero = " +
                num_residencia+"");
        ResultSet rs = st.getResultSet();
        rs.next();
        System.out.println("num id endereço = "+rs.getInt("id_endereco"));
        int id_endereco = rs.getInt("id_endereco");
        String sql_code = "INSERT INTO pessoajuridica_endereco (id_pesjur,id_endereco) VALUES ('"+CNPJ+"',"+id_endereco+")";
        PreparedStatement inserir = conexao.prepareStatement(sql_code);
        inserir.execute();

    }

    public void insert_pessoafisica_endereco(String CPF, String Rua, String Cidade, String UF, int num_residencia) throws SQLException{

        Statement st = conexao.createStatement();
        st.executeQuery("SELECT id_endereco FROM endereco WHERE rua = '"+Rua+"' AND cidade = '"+Cidade+"' AND uf = '"+UF+"' AND numero = " +
                num_residencia+"");
        ResultSet rs = st.getResultSet();
        rs.next();
        System.out.println("num id endereço = "+rs.getInt("id_endereco"));
        int id_endereco = rs.getInt("id_endereco");
        String sql_code = "INSERT INTO pessoafisica_endereco (id_pesfis,id_endereco) VALUES ('"+CPF+"',"+id_endereco+")";
        PreparedStatement inserir = conexao.prepareStatement(sql_code);
        inserir.execute();
    }

}

