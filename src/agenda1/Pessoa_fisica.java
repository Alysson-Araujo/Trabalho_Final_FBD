package agenda1;

public class Pessoa_fisica extends Usuario {
    private String CPF ;



    public Pessoa_fisica(String nome, String email, String telefone,String CPF) {
        super(nome, email, telefone);
        this.CPF = CPF;
    }
    public Pessoa_fisica(){}

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

}
