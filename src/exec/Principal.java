package exec;

import database.*;

import java.sql.Connection;
import java.sql.SQLException;

public class Principal {
    public static void menu (){
        System.out.println(" ###### AGENDA TELEFONICA ONLINE! ###### \n" +
                "Digite 1 para mostrar todas as pessoas fisicas na agenda telefonica;                  \n" +
                "Digite 2 para mostrar todas as pessoas juridicas na agenda telefonica;                \n" +
                "Digite 3 para mostrar todos os usuarios presentes na agenda telefonica;               \n" +
                "Digite 4 para buscar um estabelecimento, como emegencia,restaurante, universidade, " +
                "entre outros;                                                                         \n" +
                "" +
                "");
    }
    public static void main(String[] args) throws SQLException {
        menu();
        Connection teste = new conexao().getConnection();
        usuario_conex colocar = new usuario_conex(teste);
        colocar.tested();
        teste.close();

    }
}
