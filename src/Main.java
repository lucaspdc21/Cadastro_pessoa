import Controllers.PessoaController;
import Models.Pessoa;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PessoaController pc = new PessoaController();

        // Cadastra uma nova pessoa
        Pessoa pessoa = new Pessoa("Lucas", 21, "example@teste.com", "(85)9999-9999");
        pc.cadastrarPessoa(pessoa);

        // Atualiza a pessoa
        pc.atualizarPessoa(pessoa.getNome());

        // deleção de uma pessoa
        pc.deletarPessoa("Joao");

        // Encerra e salva 
        pc.encerrarPrograma();

        scanner.close();
    }
}
