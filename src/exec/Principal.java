package exec;

import database.*;
import agenda1.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Principal {
    public static void menu (){
        System.out.println("_________________________________________\n");
        System.out.println("    AGENDA TELEFONICA ONLINE!              ");
        System.out.println("_________________________________________\n");
        System.out.println("[1] - Mostra todas as pessoas fisicas");
        System.out.println("[2] - Mostra todas as pessoas juridicas");
        System.out.println("[3] - Mostra todos os usuarios");
        System.out.println("[4] - Busca um estabelecimento comercial");
        System.out.println("[5] - Busque por uma pessoa juritica");
        System.out.println("[6] - Busque por uma pessoa fisica");
        System.out.println("[7] - busque por todas as pessoas que moram em uma determinada cidade");
        System.out.println("[7] - busque por todas as pessoas que moram em um determinado estado");
        System.out.println("[7] - busque por todas as pessoas que moram em uma determinada rua");
    }

    public static void mostrar_todos_tabela(String tabela) throws SQLException {

        Connection conexao = new conexao().getConnection();
        Statement st = conexao.createStatement();
        ResultSet rs;

        switch (tabela){
            case "usuario":
                st.executeQuery("select nome,email,telefone from " + tabela +" order by nome asc;");

                rs = st.getResultSet();
                //System.out.println("id            | nome            | email            | telefone");
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
                st.executeQuery("select nome,email,telefone from " + tabela +" order by nome asc;");

                rs = st.getResultSet();
                while (rs.next()) {
                    System.out.println("id_end = "+rs.getString("id_end") + " | rua = " + rs.getString("rua") +
                            " | numero = " + rs.getString("numero") + " | bairro = " + rs.getString("bairro") +
                            " | cidade = " + rs.getString("cidade") + " | UF = " + rs.getString("UF") +"\n");
                }
        }
    }

    public static void main(String[] args) throws SQLException {
        //menu();
        Connection teste = new conexao().getConnection();
        //usuario_conex colocar = new usuario_conex(teste);
        //colocar.tested();
        mostrar_todos_tabela("endereco");
        teste.close();

    }
}
