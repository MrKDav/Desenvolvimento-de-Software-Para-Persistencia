package java;

public class Pessoa implements java.io.Serializable{
    private String cpf;
    private String nome;
    private String email;
    private String fone;

    public Pessoa(){
        super();
    }

    public Pessoa(String cpf, String nome, String email, String fone){
        this.cpf = cpf;
        this.nome = nome;
        this.email = email;
        this.fone = fone;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "cpf='" + cpf + '\'' +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", fone='" + fone + '\'' +
                '}';
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
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

    public String getFone() {
        return fone;
    }

    public void setFone(String fone) {
        this.fone = fone;
    }


}
