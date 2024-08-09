package Models;

public class Pessoa {
    private String nome;
    private int idade;
    private String email;
    private String telefone;

    public Pessoa() {
    }

    public Pessoa(String nome, int idade, String email, String telefone) {
        this.nome = nome;
        this.idade = idade;
        this.email = email;
        this.telefone = telefone;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
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

    // Importante para salvar os dados do indivíduo de uma forma que o sistema consiga ler corretamente
    public String toString() {
        return String.format("%s,%d,%s,%s", nome, idade, email, telefone);
    }

    // Método usado para capturar os dados do indivio no arquivo de texto
    public static Pessoa capturaNoArquivo(String linha) {
        String[] s = linha.split(",");
        Pessoa pessoaCapturada = new Pessoa(s[0], Integer.parseInt(s[1]), s[2], s[3]);
        return (pessoaCapturada);
    }
    
}