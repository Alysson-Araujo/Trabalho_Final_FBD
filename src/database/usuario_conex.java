package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import agenda1.usuario;


/* create (insert)
read (select)
update (update)
delete (delete)
*/


public class usuario_conex {
    private final Connection conexao;

    public usuario_conex(Connection conexao) {
        this.conexao = conexao;
    }

    public void tested() throws SQLException{
        String sql_code = "INSERT INTO usuario (nome,email,telefone) VALUES('abc','abcdef@gmail.com',99824-14151)" ;
        PreparedStatement inserir = conexao.prepareStatement(sql_code);
        inserir.execute();
        conexao.close();
    }



    public void inserir_usuario(usuario user) throws SQLException{
        String sql_code = "INSERT INTO usuario (nome,email,telefone) VALUES" + "('"+user.getNome()+"','"+user.getEmail()+"','"
                +user.getTelefone()+");";
                PreparedStatement inserir = conexao.prepareStatement(sql_code);
                inserir.execute();
                conexao.close();
    }
    public void remover_usuario(usuario user) throws  SQLException{
        String sql_code = "DELETE FROM USUARIO WHERE ID = "+user.getID()+"";
        PreparedStatement inserir = conexao.prepareStatement(sql_code);
        inserir.execute();
        conexao.close();
    }

    public void update_nome(usuario user) throws SQLException{
        String sql_code = "UPDATE CLIENTE SET nome = '"+user.getNome()+"' WHERE ID = "+user.getID()+"";
        PreparedStatement inserir = conexao.prepareStatement(sql_code);
        inserir.execute();
        conexao.close();
    }

    public void update_email(usuario user) throws SQLException{
        String sql_code = "UPDATE CLIENTE SET email = '"+user.getEmail()+"' WHERE ID = "+user.getID()+"";
        PreparedStatement inserir = conexao.prepareStatement(sql_code);
        inserir.execute();
        conexao.close();
    }

    public void update_telefone(usuario user) throws SQLException{
        String sql_code = "UPDATE CLIENTE SET telefone = '"+user.getTelefone()+"' WHERE ID = "+user.getID()+"";
        PreparedStatement inserir = conexao.prepareStatement(sql_code);
        inserir.execute();
        conexao.close();
    }
}
