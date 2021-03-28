package agenda1;

public class Endereco {
    private int ID_end;
    private String rua;
    private int numero;
    private String bairro;
    private String cidade;
    private String UF;

    public Endereco(int ID_end, String rua, int numero, String bairro, String cidade, String UF) {
        this.ID_end = ID_end;
        this.rua = rua;
        this.numero = numero;
        this.bairro = bairro;
        this.cidade = cidade;
        this.UF = UF;
    }

    public Endereco(String rua, int numero, String bairro, String cidade, String UF) {
        this.rua = rua;
        this.numero = numero;
        this.bairro = bairro;
        this.cidade = cidade;
        this.UF = UF;
    }

    public int getID_end() {
        return ID_end;
    }

    public void setID_end(int ID_end) {
        this.ID_end = ID_end;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUF() {
        return UF;
    }

    public void setUF(String UF) {
        this.UF = UF;
    }


}
