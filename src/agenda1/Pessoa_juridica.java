package agenda1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class Pessoa_juridica extends Usuario {
    private String CNPJ;
    private String tipo_empresa;
    private Connection conexao;


    public Pessoa_juridica(String nome, String email, String telefone, String CNPJ, String tipo_empresa){
        super(nome, email, telefone);
        this.CNPJ = CNPJ;
        this.tipo_empresa = tipo_empresa;
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

/*
    public void update_tipo_empresa(Pessoa_juridica PJ) throws SQLException{
        String sql_code = "UPDATE CLIENTE SET nome = '"+PJ.getTipo_empresa()+"' WHERE ID = "+PJ.getCNPJ()+"";
        PreparedStatement inserir = conexao.prepareStatement(sql_code);
        inserir.execute();
        conexao.close();
    }
*/

}



