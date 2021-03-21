package database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Crud {
    public static void mostrar_todos_tabela(String tabela) throws SQLException {

        Connection conexao = new conexao().getConnection();
        Statement st = conexao.createStatement();
            ResultSet rs;

        switch (tabela){
            case "usuario":
                st.executeQuery("select nome,email,telefone, from " + tabela +" order by nome asc;");

                rs = st.getResultSet();
                //System.out.println("id            | nome            | email            | telefone");
                String asf = rs.getString("nome");
                while (rs.next()) {
                    System.out.println("nome = " + rs.getString("nome") +
                            " | email = " + rs.getString("email") + " | telefone = " + rs.getString("telefone") +"\n");
                }


            case "endereco":
                st.executeQuery("select rua,numero,bairro,cidade,UF from " + tabela +" order by cidade,bairro asc;"); // falar sobre o assunto com o pessoal

                rs = st.getResultSet();
                while (rs.next()) {
                    System.out.println("rua = " + rs.getString("rua") +
                            " | numero = " + rs.getString("numero") + " | bairro = " + rs.getString("bairro") +
                            " | cidade = " + rs.getString("cidade") + " | UF = " + rs.getString("UF") +"\n");
                }


            case "pessoa fisica":
                st.executeQuery("select P.nome,P.email,P.telefone,E.rua,E.numero,E.bairro,E.cidade from " + tabela +
                        "P,endereco E WHERE;");

                rs = st.getResultSet();
                while (rs.next()) {
                    System.out.println("id_end = "+rs.getString("id_end") + " | rua = " + rs.getString("rua") +
                            " | numero = " + rs.getString("numero") + " | bairro = " + rs.getString("bairro") +
                            " | cidade = " + rs.getString("cidade") + " | UF = " + rs.getString("UF") +"\n");
                }
        }

    }

    public static  void buscar_especificos_dados(){

    }

}
