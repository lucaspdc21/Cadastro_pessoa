import Controllers.PessoaController;
import Models.Pessoa;

public class Main {
    public static void main(String[] args) {
        Pessoa pessoa = new Pessoa("Lucas", 21, "example@teste.com", "(85)9999-9999");
        PessoaController pc = new PessoaController();
        pc.cadastrarPessoa(pessoa);
        pc.deletarPessoa("Joao");
        pc.encerrarPrograma();
    }
}