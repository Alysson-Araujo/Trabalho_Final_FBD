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
    private Connection conexao;

    public usuario_conex(Connection conexao) {
        this.conexao = conexao;
    }


    public void inserir_usuario(usuario user) throws SQLException{
        String sql_code = "INSERT INTO usuario (nome,email,telefone,endereco,endereco_numero," +
                "endereco_bairro,cidade,UF) VALUES" + "('"+user.getNome()+"','"+user.getEmail()+"','"
                +user.getTelefone()+"','"+user.getTelefone()+"','"+user.getEndereco()+"','"+user.getEndereco_numero()+
                "','"+user.getEndereco_bairro()+"','"+user.getCidade()+"','"+user.getUF()+");";
                PreparedStatement inserir = conexao.prepareStatement(sql_code);
        inserir.execute();
        conexao.close();
    }
    public void remover_usuario(usuario user){

    }

}
