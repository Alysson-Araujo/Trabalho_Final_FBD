package exec;

import database.*;
import agenda1.*;

import java.beans.beancontext.BeanContextServiceRevokedEvent;
import java.sql.*;
import java.util.Scanner;

public class Principal {
    public static void menu (){
        System.out.println("_________________________________________\n");
        System.out.println("    AGENDA TELEFONICA ONLINE!              ");
        System.out.println("_________________________________________\n");
        System.out.println("[1] - Insira um novo usuário");//
        System.out.println("[2] - Remover uma pessoa física");//
        System.out.println("[3] - Remover uma pessoa jurídica"); //
        System.out.println("[4] - Alterar algum dado de uma pessoa física");// n feito
        System.out.println("[5] - Alterar algum dado de uma pessoa jurídica");// n feito
        System.out.println("[6] - Mostrar por todos os enderecos de uma cidade:");// n feito
        System.out.println("[7] - Busque por uma pessoa fisica:");// n feito
        System.out.println("[8] - busque por todas as pessoas que moram em um determinado estado");// n feito
        System.out.println("[9] - busque por todas as pessoas que moram em uma determinada rua");// n feito
    }




    public static void main(String[] args) throws SQLException {
        Scanner in = new Scanner(System.in);
        Connection conexao_BD = new conexao().getConnection();
        //usuario_conex colocar = new usuario_conex(teste);
        //colocar.tested();
        //Crud.mostrar_todos_tabela("endereco");
        //teste.close();
        boolean existeNaTabelaEndereco = false;
        /* Objeto para adicionar uma pessoa física*/

        /*responsável em fazer a seleção de menu*/
        int numerador;

        boolean programa = true;

        while (programa){
        menu();
        numerador = Integer.parseInt(in.nextLine());
            switch (numerador){
                case 1:

                        System.out.println("Digite [1] para cadastrar uma Pessoa Física; \n" +
                                "Digite [2] para cadastrar uma Pessoa Jurídica;");
                        int tipoCadastro = Integer.parseInt(in.nextLine());

                        if (tipoCadastro == 1) {
                            System.out.println("Diga as informações que essa pessoa possui abaixo >>> ");
                            System.out.print("Nome Completo: ");
                            String Nome = in.nextLine();



                            System.out.print("\n");
                            System.out.print("e-mail: ");
                            String email = in.nextLine();

                            System.out.print("\n");
                            System.out.print("telefone: ");
                            String telefone = in.nextLine();


                            System.out.print("\n");
                            System.out.print("CPF: ");
                            String CPF = in.nextLine();

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
                            PFC.inserir_pessoa_fisica2(Nome,email,telefone,CPF);


                            // Parte onde inserimos o endereco da pessoa na tabela endereco do BD



                            /*Primeiro vamos verificar se o endereco escrito já está na tabela, no caso se a rua
                             * está em tal cidade*/
                            System.out.println("teste1");
                            Endereco_conex endereco = new Endereco_conex(conexao_BD);

                            System.out.println("teste2");
                            endereco.inserir_endereco(Rua,num_residencia,bairro,cidade,UF); // dando erro aqui

                            System.out.println("teste3");
                            /*Evitando que ruas se repetem, eu não vou colocar um while verificando linha por linha
                             * já que a estrutura que fizemos não vai permitir que isso aconteca*/

/*
                            while (rs.next()) {
                                String verifica_cidade = rs.getString("cidade");
                                String verifica_rua = rs.getString("rua");
                                String verifica_UF = rs.getString("UF");
                                int verifica_num_residencia = rs.getInt("numero");
                                if (verifica_UF.equals(UF) && verifica_cidade.equals(cidade) && verifica_rua.equals(Rua)
                                    && verifica_num_residencia==num_residencia) {
                                    existeNaTabelaEndereco = true;
                                    break;
                                } else {
                                    existeNaTabelaEndereco = false;
                                }
                            }

*/


                        }


                        //tipo cadastro ==2
                        else if(tipoCadastro==2){
                            System.out.println("Diga as informações que essa pessoa possui abaixo >>> ");
                            System.out.print("Nome Completo: ");
                            String Nome = in.nextLine();




                            System.out.print("\n");
                            System.out.print("e-mail: ");
                            String email = in.nextLine();

                            System.out.print("\n");
                            System.out.print("telefone: ");
                            String telefone = in.nextLine();



                            System.out.print("\n");
                            System.out.print("CNPJ: ");
                            String CNPJ = in.nextLine();



                            System.out.print("\n");
                            System.out.print("Rua: ");
                            String Rua = in.nextLine();

                            System.out.print("\n");
                            System.out.print("Numero da residencia/local: ");
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
                            System.out.print("Tipo da empresa: ");
                            String Tipo_empresa = in.nextLine();

                            /* instancia uma nova pessoa para colocar no BD*/
                            Pessoa_juridica pessoaJuridica = new Pessoa_juridica(Nome, email, telefone, CNPJ,Tipo_empresa);

                            Pessoa_juridica_conex PJC = new Pessoa_juridica_conex(conexao_BD);


                            //IMPORTANTE MUDANÇA!
                            PJC.inserir_pessoa_juridica2(Nome,email,telefone,CNPJ,Tipo_empresa);




                            /*Parte onde inserimos o endereco da pessoa na tabela endereco do BD*/

                            Statement st = conexao_BD.createStatement();
                            Endereco_conex EndConex = new Endereco_conex(conexao_BD);
                            Endereco novo_endereco = new Endereco(Rua, num_residencia, bairro, cidade, UF);
                            EndConex.inserir_endereco(Rua,num_residencia,bairro,cidade,UF);

                            EndConex.insert_pessoajuridica_endereco(CNPJ,Rua,cidade,UF);

                            /*pegar o id do endereço adicionado agora! */


                            /*Pegando o ID do usuário adicionado agora!, que no caso é o CNPJ! Então não vai precisar*/



                            /* inserindo na tabela de relacionamento entre pessoa fisica e endereço*/







                            /*Primeiro vamos verificar se o endereco escrito já está na tabela, no caso se a rua
                             * está em tal cidade*/

/*

                            Statement st = conexao_BD.createStatement();
                            st.executeQuery("SELECT rua,cidade,UF,numero FROM endereco WHERE rua = '" + Rua +
                                    "' AND cidade = '" + cidade + "' AND UF = '" + UF + "' AND numero = "+
                                    num_residencia+" ;");
                            ResultSet rs = st.getResultSet();

*/


                            /*Evitando que ruas se repetem, eu não vou colocar um while verificando linha por linha
                             * já que a estrutura que fizemos não vai permitir que isso aconteca*/

/*
                            while (rs.next()) {
                                String verifica_cidade = rs.getString("cidade");
                                String verifica_rua = rs.getString("rua");
                                String verifica_UF = rs.getString("UF");
                                int verifica_num_residencia = rs.getInt("numero");
                                if (verifica_UF.equals(UF) && verifica_cidade.equals(cidade) && verifica_rua.equals(Rua)
                                        && verifica_num_residencia==num_residencia) {
                                    existeNaTabelaEndereco = true;
                                    break;
                                } else {
                                    existeNaTabelaEndereco = false;
                                }
                            }
*/




                        }

                    break;

                case 2:
                    System.out.print("Digite o CPF da pessoa física: ");
                    String CPF = in.nextLine();
                    Crud.excluir_pessoa_fisica(CPF);
                    break;

                case 3:
                    System.out.print("Digite o CNPJ da pessoa juridica/empresa: ");
                    String CNPJ= in.nextLine();
                    Crud.excluir_pessoa_juridica(CNPJ);
                    break;

                case 4:
                    System.out.println("[1] para mudar o nome \n" +
                            "[2] para mudar o email \n" +
                            "[3] para mudar o telefone \n");
                    String opcao_PF = in.nextLine();
                    Crud.alterar_dados_pessoa_fisica(opcao_PF);
                    break;

                case 5:
                    System.out.println("[1] para mudar o nome \n" +
                            "[2] para mudar o email \n" +
                            "[3] para mudar o telefone \n" +
                            "[4] para mudar o CNPJ");
                    String opcao_PJ = in.nextLine();
                    Crud.alterar_dados_pessoa_juridica(opcao_PJ);
                    break;

                case 6:
                    System.out.println("Digite o nome da cidade: ");
                    System.out.print("Cidade:");
                    String cidade = in.nextLine();
                    System.out.println("");

                    System.out.println("Digite a UF dessa cidade: ");
                    System.out.print("UF:");
                    String UF = in.nextLine();
                    System.out.println("");
                    Crud.buscar_ruas_pela_cidade(cidade,UF);
                    break;

                case 0:
                    programa = false;
                    break;
            }

        }
    }
}
