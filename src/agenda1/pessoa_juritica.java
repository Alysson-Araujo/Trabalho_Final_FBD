package agenda1;

public class pessoa_juritica extends usuario {
    private String CNPJ;
    private String tipo_empresa;



    public pessoa_juritica(String nome, String email, String telefone, String endereco, int endereco_numero, String endereco_bairro, String cidade, String UF) {
        super(nome, email, telefone, endereco, endereco_numero, endereco_bairro, cidade, UF);
    }


    public String getCNPJ() {
        return CNPJ;
    }

    public void setCNPJ(String CNPJ) {
        this.CNPJ = CNPJ;
    }

    public String getTipo_empresa() {
        return tipo_empresa;
    }

    public void setTipo_empresa(String tipo_empresa) {
        this.tipo_empresa = tipo_empresa;
    }

}
