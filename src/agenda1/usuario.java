package agenda1;

public class usuario {
    private int ID;
    private String nome;



    private String email;
    private String telefone;
    private String endereco;
    private int    endereco_numero;
    private String endereco_bairro;
    private String Cidade;
    private String UF;

    public usuario(String nome, String email, String telefone, String endereco, int endereco_numero,
                   String endereco_bairro, String cidade, String UF) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.endereco = endereco;
        this.endereco_numero = endereco_numero;
        this.endereco_bairro = endereco_bairro;
        Cidade = cidade;
        this.UF = UF;
    }


        public int getID() {
            return ID;
        }

        public void setID(int ID) {
            this.ID = ID;
        }
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public int getEndereco_numero() {
        return endereco_numero;
    }

    public void setEndereco_numero(int endereco_numero) {
        this.endereco_numero = endereco_numero;
    }

    public String getEndereco_bairro() {
        return endereco_bairro;
    }

    public void setEndereco_bairro(String endereco_bairro) {
        this.endereco_bairro = endereco_bairro;
    }

    public String getCidade() {
        return Cidade;
    }

    public void setCidade(String cidade) {
        Cidade = cidade;
    }

    public String getUF() {
        return UF;
    }

    public void setUF(String UF) {
        this.UF = UF;
    }
}
