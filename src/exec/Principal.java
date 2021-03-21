package exec;

import database.*;
import agenda1.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Principal {
    public static void menu (){
        System.out.println("_________________________________________\n");
        System.out.println("    AGENDA TELEFONICA ONLINE!              ");
        System.out.println("_________________________________________\n");
        System.out.println("[1] - Mostra todas as pessoas físicas");// n feito
        System.out.println("[2] - Mostra todas as pessoas jurídicas"); // n feito
        System.out.println("[3] - Mostra todos os usuarios");// feito
        System.out.println("[4] - Mostrar todos os enderecos"); // feito
        System.out.println("[5] - Busca um estabelecimento comercial");// n feito
        System.out.println("[6] - Busque por uma pessoa juritica");// n feito
        System.out.println("[7] - Busque por uma pessoa fisica");// n feito
        System.out.println("[8] - busque por todas as pessoas que moram em uma determinada cidade");// n feito
        System.out.println("[9] - busque por todas as pessoas que moram em um determinado estado");// n feito
        System.out.println("[10] - busque por todas as pessoas que moram em uma determinada rua");// n feito
    }




    public static void main(String[] args) throws SQLException {
        Scanner in = new Scanner(System.in);
        Connection conexao_BD = new conexao().getConnection();
        //usuario_conex colocar = new usuario_conex(teste);
        //colocar.tested();
        Crud.mostrar_todos_tabela("endereco");
        //teste.close();
        boolean existeNaTabelaEndereco = false;
        /* Objeto para adicionar uma pessoa física*/

        /*responsável em fazer a seleção de menu*/
        int numerador= Integer.parseInt(in.nextLine());

        boolean programa = true;

        while (programa){

            switch (numerador){
                case 1:
                    try {


                        System.out.println("Digite [1] para cadastrar uma Pessoa Física; \n" +
                                "Digite [2] para cadastrar uma Pessoa Jurídica;");
                        int tipoCadastro = Integer.parseInt(in.nextLine());

                        if (tipoCadastro == 1) {
                            System.out.println("Diga as informações que essa pessoa possui abaixo >>> ");
                            System.out.print("Nome Completo: ");
                            String Nome = in.nextLine();
                            for(int i =0;i < Nome.length();i++){
                                Character caractere = Nome.charAt(i);
                                if(Character.isDigit(caractere)){
                                    throw new Exception();
                                }
                            }


                            System.out.print("\n");
                            System.out.print("e-mail: ");
                            String email = in.nextLine();

                            System.out.print("\n");
                            System.out.print("telefone: ");
                            String telefone = in.nextLine();
                            for(int i =0;i < telefone.length();i++){
                                Character caractere = telefone.charAt(i);
                                if(Character.isAlphabetic(caractere)){
                                    throw new Exception(telefone);
                                }
                            }

                            System.out.print("\n");
                            System.out.print("CPF: ");
                            String CPF = in.nextLine();
                            for(int i =0;i < CPF.length();i++){
                                Character caractere = CPF.charAt(i);
                                if(Character.isAlphabetic(caractere)){
                                    throw new Exception();
                                }
                            }

                            System.out.print("\n");
                            System.out.print("Rua: ");
                            String Rua = in.nextLine();

                            System.out.print("\n");
                            System.out.print("Numero da residencia: ");
                            int num_residencia = Integer.parseInt(in.nextLine());

                            System.out.print("\n");
                            System.out.print("Bairro: ");
                            String bairro = in.nextLine();

                            System.out.print("\n");
                            System.out.print("Cidade: ");
                            String cidade = in.nextLine();

                            System.out.print("\n");
                            System.out.print("UF: ");
                            String UF = in.nextLine();

                            System.out.print("\n");
                            /* instancia uma nova pessoa para colocar no BD*/
                            Pessoa_fisica pessoaFisica = new Pessoa_fisica(Nome, email, telefone, CPF);

                            Pessoa_fisica_conex PFC = new Pessoa_fisica_conex(conexao_BD);
                            PFC.inserir_pessoa_fisica(pessoaFisica);

                            /*Parte onde inserimos o endereco da pessoa na tabela endereco do BD*/

                            /*Primeiro vamos verificar se o endereco escrito já está na tabela, no caso se a rua
                             * está em tal cidade*/

                            Statement st = conexao_BD.createStatement();
                            st.executeQuery("SELECT rua,cidade,UF FROM endereco WHERE rua = '" + Rua +
                                    "' AND cidade = '" + cidade + "' AND UF = '" + UF + "';");
                            ResultSet rs = st.getResultSet();


                            /*Evitando que ruas se repetem, eu não vou colocar um while verificando linha por linha
                             * já que a estrutura que fizemos não vai permitir que isso aconteca*/


                            while (rs.next()) {
                                String verifica_cidade = rs.getString("cidade");
                                String verifica_rua = rs.getString("rua");
                                String verifica_UF = rs.getString("UF");
                                if (verifica_UF.equals(UF) && verifica_cidade.equals(cidade) && verifica_rua.equals(Rua)) {
                                    existeNaTabelaEndereco = true;
                                    break;
                                } else {
                                    existeNaTabelaEndereco = false;
                                }
                            }


                            if (!existeNaTabelaEndereco) {
                                Endereco_conex EndConex = new Endereco_conex(conexao_BD);
                                Endereco novo_endereco = new Endereco(Rua, num_residencia, bairro, cidade, UF);
                                EndConex.inserir_endereco(novo_endereco);
                            } else {
                                /* pegaria o id_endereco e relacionar com o id_usuario do usuario que está sendo
                                 * colocado agora.
                                 *  */
                                Endereco_conex EndConex = new Endereco_conex(conexao_BD);

                                // pegamos o id_usuario que estamos cadastrando
                                st.executeQuery("SELECT id_usuario FROM pessoa_fisica WHERE CPF = '" + CPF + "';");
                                rs = st.getResultSet();
                                int id_usuario = rs.getInt("id_usuario");

                                // pegamos o id_endereco do endereco já presente na tabela endereco
                                st.executeQuery("SELECT id_endereco FROM endereco WHERE rua = '" + Rua + "' AND cidade = '" +
                                        cidade + "' AND UF= '" + UF + "';");
                                rs = st.getResultSet();
                                int id_endereco = rs.getInt("id_endereco");

                                st.executeQuery("INSERT TABLE usuario_endereco (id_usuario,id_endereco)" +
                                        "VALUES('" + id_usuario + "','" + id_endereco + "')");
                            }
                        }
                    }
                    catch (NumberFormatException e){
                        System.out.println("Valores Errados. Por favor, escreva aquilo que está sendo pedido no formato correto!" + " " +
                                "\n Voltando para o menu...");
                    }
                    catch(Exception e1){System.out.println("Não coloque informações que não condizem com o que é " +
                            "pedido");}
                    break;

                case 0:
                    programa = false;
                    break;
            }


        }
    }
}
