import Controllers.PessoaController;
import Models.Pessoa;
import Services.PessoaService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Pessoa pessoa = new Pessoa("Lucas", 21, "example@teste.com", "(85)9999-9999");
        PessoaController pc = new PessoaController();
        pc.cadastrarPessoa(pessoa);
        pc.fecharArquivo();

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Digite o nome do usuário a ser buscado: ");
            String nome = scanner.nextLine();

            PessoaService ps = new PessoaService();
            ps.buscarUsuario(nome);
        }
    }
}
