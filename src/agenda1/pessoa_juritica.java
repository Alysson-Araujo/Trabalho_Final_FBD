package agenda1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import database.conexao;


public class pessoa_juritica extends usuario {
    private String CNPJ;
    private String tipo_empresa;
    private Connection conexao;


    public pessoa_juritica(String nome, String email, String telefone, String endereco, int endereco_numero, String endereco_bairro, String cidade, String UF) {
        super(nome, email, telefone);
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


    public void update_tipo_empresa(pessoa_juritica PJ) throws SQLException{
        String sql_code = "UPDATE CLIENTE SET nome = '"+PJ.getTipo_empresa()+"' WHERE ID = "+PJ.getCNPJ()+"";
        PreparedStatement inserir = conexao.prepareStatement(sql_code);
        inserir.execute();
        conexao.close();
    }
}



