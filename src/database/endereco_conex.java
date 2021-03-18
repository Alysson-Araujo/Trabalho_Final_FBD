package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import agenda1.endereco;

public class endereco_conex {
    private Connection conexao;

    public endereco_conex(Connection conexao) {
        this.conexao = conexao;
    }

    public void inserir_endereco(endereco endereco) throws SQLException{
        String sql_code = "INSERT INTO endereco (rua,numero,bairro,cidade,UF) VALUES" + "('"+endereco.getRua()+"','"+
                endereco.getNumero()+"','"+endereco.getBairro()+"','"+endereco.getCidade()+"','"+endereco.getUF()+");";
        PreparedStatement inserir = conexao.prepareStatement(sql_code);
        inserir.execute();
        conexao.close();
    }

}
