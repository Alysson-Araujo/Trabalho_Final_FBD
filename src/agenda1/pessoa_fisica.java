package agenda1;

public class pessoa_fisica extends usuario{
    private String CPF ;



    public pessoa_fisica(String nome, String email, String telefone, String endereco, int endereco_numero, String endereco_bairro, String cidade, String UF) {
        super(nome, email, telefone, endereco, endereco_numero, endereco_bairro, cidade, UF);
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

}
