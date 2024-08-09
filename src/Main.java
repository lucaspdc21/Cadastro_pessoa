import Controllers.PessoaController;
import Models.Pessoa;

public class Main {
    public static void main(String[] args) {
        Pessoa pessoa = new Pessoa("João", 25, "email", "1");
        PessoaController pc = new PessoaController();
        try {
            pc.cadastrarPessoa(pessoa);
        } catch (Exception e) {
            e.printStackTrace();
    }
    }
}