import java.util.List;
import java.util.Scanner;
import Controllers.PessoaController;
import Models.Pessoa;

public class Main {
    public static void main(String[] args) {
        Pessoa pessoa = new Pessoa("Lucas", 21, "example@teste.com", "(85)9999-9999");
        PessoaController pc = new PessoaController();    
        pc.cadastrarPessoa(pessoa);
        pc.listarPessoas();
        System.out.println("Digite o nome completo da pessoa que deseja buscar:");
        Scanner scanner = new Scanner(System.in);
        String nome = scanner.nextLine();
        pc.buscarPessoas(nome);
        scanner.close();
        pc.encerrarPrograma();


    }
}
