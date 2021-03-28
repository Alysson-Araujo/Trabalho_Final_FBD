package database;

import java.sql.*;
import java.util.Scanner;

public class Crud {
    public static void mostrar_todos_tabela(String tabela) throws SQLException {

        Connection conexao = new conexao().getConnection();
        Statement st = conexao.createStatement();
        ResultSet rs;

        switch (tabela) {
            case "usuario":
                st.executeQuery("select nome,email,telefone, from " + tabela + " order by nome asc;");

                rs = st.getResultSet();
                //System.out.println("id            | nome            | email            | telefone");
                String asf = rs.getString("nome");
                while (rs.next()) {
                    System.out.println("nome = " + rs.getString("nome") +
                            " | email = " + rs.getString("email") + " | telefone = " + rs.getString("telefone") + "\n");
                }
                break;

            case "endereco":
                st.executeQuery("select rua,numero,bairro,cidade,UF from " + tabela + " order by cidade,bairro asc;"); // falar sobre o assunto com o pessoal

                rs = st.getResultSet();
                while (rs.next()) {
                    System.out.println("rua = " + rs.getString("rua") +
                            " | numero = " + rs.getString("numero") + " | bairro = " + rs.getString("bairro") +
                            " | cidade = " + rs.getString("cidade") + " | UF = " + rs.getString("UF") + "\n");
                }
                break;

            case "pessoa fisica":
                st.executeQuery("select P.nome,P.email,P.telefone,E.rua,E.numero,E.bairro,E.cidade from " + tabela +
                        "P,endereco E WHERE;");

                rs = st.getResultSet();
                while (rs.next()) {
                    System.out.println("id_end = " + rs.getString("id_end") + " | rua = " + rs.getString("rua") +
                            " | numero = " + rs.getString("numero") + " | bairro = " + rs.getString("bairro") +
                            " | cidade = " + rs.getString("cidade") + " | UF = " + rs.getString("UF") + "\n");
                }
                break;
        }

    }

    public static void excluir_pessoa_fisica(String CPF) throws SQLException {

        Connection conexao = new conexao().getConnection();
        String sql_code1 = "DELETE FROM pessoafisica_endereco WHERE id_pesfis = '" + CPF + "'";
        PreparedStatement inserir1 = conexao.prepareStatement(sql_code1);
        inserir1.execute();

        String sql_code2 = "DELETE FROM pessoa_fisica WHERE CPF = '" + CPF + "'";
        PreparedStatement inserir2 = conexao.prepareStatement(sql_code2);
        inserir2.execute();

    }

    public static void excluir_pessoa_juridica(String CNPJ) throws SQLException {
        Connection conexao = new conexao().getConnection();
        String sql_code1 = "DELETE FROM pessoajuridica_endereco WHERE id_pesjur = '" + CNPJ + "'";
        PreparedStatement inserir1 = conexao.prepareStatement(sql_code1);
        inserir1.execute();

        Statement st = conexao.createStatement();
        String sql_code = "DELETE FROM pessoa_juridica WHERE CNPJ = '" + CNPJ + "'";
        PreparedStatement inserir = conexao.prepareStatement(sql_code);
        inserir.execute();
    }

    public static void alterar_dados_pessoa_fisica(String opcao) throws SQLException {
        String CPF;
        Scanner in = new Scanner(System.in);
        Connection conexao = new conexao().getConnection();
        String sql;
        PreparedStatement statement;

        switch (opcao) {
            //nome
            case "1":
                System.out.println("Digite o CPF da pessoa:");
                CPF = in.nextLine();
                System.out.println("Digite o novo nome da pessoa:");
                String nome_novo = in.nextLine();


                sql = "UPDATE pessoa_fisica SET nome = '" + nome_novo + "' WHERE CPF = '" + CPF + "'";
                statement = conexao.prepareStatement(sql);
                statement.execute();

                break;

            //email
            case "2":
                System.out.println("Digite o CPF da pessoa:");
                CPF = in.nextLine();
                System.out.println("Digite o novo email da pessoa:");
                String novo_email = in.nextLine();


                sql = "UPDATE pessoa_fisica SET email = '" + novo_email + "' where CPF = '" + CPF + "'";
                statement = conexao.prepareStatement(sql);
                statement.execute();


                break;

            //telefone
            case "3":

                System.out.println("Digite o CPF da pessoa:");
                CPF = in.nextLine();
                System.out.println("Digite o novo telefone da pessoa:");
                String novo_telefone = in.nextLine();

                sql = "UPDATE pessoa_fisica SET telefone = '" + novo_telefone + "' where CPF = '" + CPF + "'";
                statement = conexao.prepareStatement(sql);
                statement.execute();
                break;
        }
    }

    public static void alterar_dados_pessoa_juridica(String opcao) throws SQLException {
        String CNPJ;
        String tipo_empresa;
        Scanner in = new Scanner(System.in);
        Connection conexao = new conexao().getConnection();
        String sql;
        PreparedStatement statement;

        switch (opcao) {
            //nome
            case "1":
                System.out.println("Digite o CNPJ da pessoa:");
                CNPJ = in.nextLine();
                System.out.println("Digite o novo nome da pessoa:");
                String nome_novo = in.nextLine();


                sql = "UPDATE pessoa_juridica SET nome = '" + nome_novo + "' where CNPJ = '" + CNPJ + "'";
                statement = conexao.prepareStatement(sql);
                statement.execute();
                break;

            //email
            case "2":
                System.out.println("Digite o CNPJ da pessoa:");
                CNPJ = in.nextLine();
                System.out.println("Digite o novo email da pessoa:");
                String novo_email = in.nextLine();


                sql = "UPDATE pessoa_juridica SET email = '" + novo_email + "' where CNPJ = '" + CNPJ + "'";
                statement = conexao.prepareStatement(sql);
                statement.execute();
                break;

            //telefone
            case "3":

                System.out.println("Digite o CNPJ da pessoa:");
                CNPJ = in.nextLine();
                System.out.println("Digite o novo telefone da pessoa:");
                String novo_telefone = in.nextLine();


                sql = "UPDATE pessoa_juridica SET telefone = '" + novo_telefone + "' where CNPJ = '" + CNPJ + "'";
                statement = conexao.prepareStatement(sql);
                statement.execute();
                break;
        }
    }

    public static void buscar_ruas_pela_cidade(String cidade, String UF) throws SQLException {
        Connection conexao = new conexao().getConnection();
        Statement st = conexao.createStatement();
        st.executeQuery("SELECT * FROM endereco");
        ResultSet teste = st.getResultSet();

        st.executeQuery("SELECT cidade,rua,bairro,UF AS ESTADO FROM endereco WHERE cidade = '" + cidade + "' AND " +
                "UF = '" + UF + "'");
        ResultSet rs = st.getResultSet();

        while (rs.next()) {
            System.out.println("Cidade = " + rs.getString("cidade") + " | rua = " + rs.getString("rua") +
                    " | bairro = " + rs.getString("bairro") +
                    " | ESTADO = " + rs.getString("ESTADO") + "\n");

        }
    }

    public static void mostrar_pessoaFisica_endereco() throws SQLException {
        Connection conexao = new conexao().getConnection();
        Statement st = conexao.createStatement();
        ResultSet rs;

        /*

        select PF.nome, PF.telefone, EN.rua, EN.numero, EN.bairro, EN.cidade, EN.uf from pessoa_fisica PF, pessoafisica_endereco PFE,
        endereco EN WHERE PF.cpf = PFE.id_pesfis AND PFE.id_endereco = EN.id_endereco

        */

        st.executeQuery("SELECT PF.nome, PF.email, PF.telefone, EN.rua, EN.numero, EN.bairro, EN.cidade, EN.uf FROM pessoa_fisica PF, " +
                "pessoafisica_endereco PFE, endereco EN WHERE PF.cpf = PFE.id_pesfis AND PFE.id_endereco = EN.id_endereco ORDER BY nome asc");

        rs = st.getResultSet();
        while (rs.next()) {
            System.out.println("Nome: " + rs.getString("nome") +
                    " | Email:  " + rs.getString("email") + " | Telefone: " + rs.getString("telefone") +
                    " | Rua: " + rs.getString("rua") + "| Numero: "+rs.getString("numero")+
                    " | Bairro: "+rs.getString("bairro")+ " | Cidade: "+rs.getString("cidade")+
                    " | UF: "+ rs.getString("uf")+"\n");

        }
    }

    public static void mostrar_pessoaJuridica_endereco() throws SQLException {
        Connection conexao = new conexao().getConnection();
        Statement st = conexao.createStatement();
        ResultSet rs;

        /*

        select PJ.nome, PJ.telefone, EN.rua, EN.numero, EN.bairro, EN.cidade, EN.uf, PJ.tipo_empresa from pessoa_juridica PJ, pessoajuridica_endereco PJE,
        endereco EN WHERE PJ.cnpj = PJE.id_pesjur AND PJE.id_endereco = EN.id_endereco ORDER BY nome, tipo_empresa asc


        */

        st.executeQuery("SELECT PJ.nome, PJ.telefone, PJ.email, EN.rua, EN.numero, EN.bairro, EN.cidade, EN.uf, PJ.tipo_empresa FROM pessoa_juridica PJ, " +
                "pessoajuridica_endereco PJE, endereco EN WHERE PJ.cnpj = PJE.id_pesjur AND PJE.id_endereco = EN.id_endereco " +
                "ORDER BY nome,tipo_empresa asc");

        rs = st.getResultSet();
        while (rs.next()) {
            System.out.println("Nome: " + rs.getString("nome") +
                    " | Email:  " + rs.getString("email") + " | Telefone: " + rs.getString("telefone") +
                    " | Rua: " + rs.getString("rua") + "| Numero: "+rs.getString("numero")+
                    " | Bairro: "+rs.getString("bairro")+ " | Cidade: "+rs.getString("cidade")+
                    " | UF: "+ rs.getString("uf")+"\n");

        }
    }

    /*public static void mostrar_pessoasFisicas_cidade_bairro(String bairro, String cidade) throws SQLException{
        Connection conexao = new conexao().getConnection();
        Statement st = conexao.createStatement();
        st.executeQuery("SELECT id_endereco FROM endereco WHERE bairro = '"+bairro+"' AND cidade = '"+cidade+"'");
        ResultSet rs = st.getResultSet();
        rs.next();
        int id_endereco = rs.getInt("id_endereco");

        st.executeQuery("SELECT id_endereco FROM endereco WHERE bairro = '"+bairro+"' AND cidade = '"+cidade+"'");


    }*/
}
