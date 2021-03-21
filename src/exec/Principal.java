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
        System.out.println("    AGENDA TELEFÔNICA ONLINE!              ");
        System.out.println("_________________________________________\n");
        System.out.println("[1] - Mostra todas as pessoas físicas");// n feito
        System.out.println("[2] - Mostra todas as pessoas jurídicas"); // n feito
        System.out.println("[3] - Mostra todos os usuarios");// feito
        System.out.println("[4] - Mostra todos os endereços"); // feito
        System.out.println("[5] - Busca um estabelecimento comercial");// n feito
        System.out.println("[6] - Busca por uma pessoa jurídica");// n feito
        System.out.println("[7] - Busca por uma pessoa física");// n feito
        System.out.println("[8] - Busca por todas as pessoas que moram em uma determinada cidade");// n feito
        System.out.println("[9] - Busca por todas as pessoas que moram em um determinado estado");// n feito
        System.out.println("[10] - Busca por todas as pessoas que moram em uma determinada rua");// n feito
    }




    public static void main(String[] args) throws SQLException {
        Scanner in = new Scanner(System.in);
        Connection conexao_BD = new conexao().getConnection();
        //usuario_conex colocar = new usuario_conex(teste);
        //colocar.tested();
        Crud.mostrar_todos_tabela("endereco");
        //teste.close();
        boolean existeNaTabelaEndereco;
        /* Objeto para adicionar uma pessoa física*/

        /*responsável em fazer a seleção de menu*/
        int numerador= Integer.parseInt(in.nextLine());

        boolean programa = true;

        while (programa){

            switch (numerador){
                case 1:
                    try
                    {
                        System.out.println("[1] Cadastrar uma Pessoa Física; \n" +
                                           "[2] Cadastrar uma Pessoa Jurídica;");
                        int tipoCadastro = Integer.parseInt(in.nextLine());

                        if (tipoCadastro ==1){
                            System.out.println("[Digite os seguintes dados]");
                            System.out.print("Nome Completo: "); String Nome = in.nextLine(); System.out.print("\n");
                            System.out.print("E-mail: "); String email = in.nextLine(); System.out.print("\n");
                            System.out.print("Telefone: "); String telefone = in.nextLine(); System.out.print("\n");
                            System.out.print("CPF: "); String CPF = in.nextLine();System.out.print("\n");
                            System.out.print("Rua: "); String Rua = in.nextLine();System.out.print("\n");
                            System.out.print("Numero da residência: "); int num_residencia = Integer.parseInt(in.nextLine());System.out.print("\n");
                            System.out.print("Bairro: "); String bairro = in.nextLine();System.out.print("\n");
                            System.out.print("Cidade e UF - (Quixadá-CE):  "); String cidade = in.nextLine();System.out.print("\n");
                            System.out.print("UF: ");String UF = in.nextLine();System.out.print("\n");
                            /* instancia uma nova pessoa para colocar no BD*/
                            Pessoa_fisica pessoaFisica = new Pessoa_fisica(Nome,email,telefone,CPF);

                            Pessoa_fisica_conex PFC = new Pessoa_fisica_conex(conexao_BD);
                            PFC.inserir_pessoa_fisica(pessoaFisica);

                            /*Parte onde inserimos o endereco da pessoa na tabela endereco do BD*/

                            /*Primeiro vamos verificar se o endereco escrito já está na tabela, no caso se a rua
                            * está em tal cidade*/

                            Statement st = conexao_BD.createStatement();
                            st.executeQuery("SELECT rua,cidade,UF FROM endereco WHERE rua = " +Rua +
                                    "AND cidade = " +cidade+" AND UF = "+ UF +";");
                            ResultSet rs = st.getResultSet();


                            /*Evitando que ruas se repetem, eu não vou colocar um while verificando linha por linha
                            * já que a estrutura que fizemos não vai permitir que isso aconteca*/


                            while(rs.next()){
                                String verifica_cidade = rs.getString("cidade");
                                String verifica_rua = rs.getString("rua");
                                String verifica_UF = rs.getString("UF");
                                if(verifica_UF.equals(UF) && verifica_cidade.equals(cidade) && verifica_rua.equals(Rua)){
                                    existeNaTabelaEndereco = true;
                                    break;
                                }
                                else {
                                    existeNaTabelaEndereco = false;
                                }
                            }


                            if (!existeNaTabelaEndereco){
                                /* ideias
                                * faria um if verificando se a cidade e a rua são as mesmas, mas UF diferente
                                * faria um if verificando se
                                *
                                *  */
                                Endereco_conex EndConex = new Endereco_conex(conexao_BD);
                                Endereco novo_endereco = new Endereco(Rua, num_residencia, bairro, cidade, UF);
                                EndConex.inserir_endereco(novo_endereco);
                            }
                            else{
                                /* pegaria o id_endereco e relacionar com o id_usuario do usuario que está sendo
                                * colocado agora.
                                *  */
                                st.executeQuery("");
                            }
                            String verifica_cidade = rs.getString("cidade");
                            String verifica_rua = rs.getString("rua");


                            if (Rua!=verifica_rua) {
                                /*entrando aqui, significa que não tem nenhuma cidade com essa rua, logo,
                                 * vamos adicionar todas as informações dela*/

                            }
                            /* Entrando aqui significa que tem esse nome dessa rua já cadastrada, mas a cidade
                            * é diferente.  */
                            else{

                            }

                        }
                    }

            }


        }
    }





}
