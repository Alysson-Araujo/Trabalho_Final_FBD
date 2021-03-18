package agenda1;

public class usuario {
    private int ID;
    private String nome;
    private String email;
    private String telefone;


    public usuario(String nome, String email, String telefone, String endereco, int endereco_numero,
                   String endereco_bairro, String cidade, String UF) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
    }


        public int getID() {
            return ID;
        }

        public void setID(int ID) {
            this.ID = ID;
        }
        public String getNome() { return nome; }

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


}
