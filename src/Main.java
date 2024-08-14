import Controllers.PessoaController;
import Models.Pessoa;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        PessoaController pc = new PessoaController();
        Scanner sc = new Scanner(System.in);

        System.out.println("Sistema de cadastro de pessoas\n");
        boolean programaEncerrado = false;

        while (!programaEncerrado) {
            System.out.println("Escolha uma opção\n"+                
                "1 - Cadastrar pessoa\n" +
                "2 - Deletar pessoa\n" +
                "3 - Listar pessoas\n" +
                "4 - Buscar pessoa\n" +
                "5 - Atualizar daods de uma pessoa" +
                "6 - Encerrar programa\n");
            int escolha = sc.nextInt();
            sc.nextLine();
            switch (escolha) {
                case 1:
                    pc.cadastrarPessoa(intanciarPessoa(sc, pc));
                    break;
                case 2:
                    System.out.println("Digite o nome da pessoa que deseja deletar:");
                    String nome = sc.nextLine();
                    System.out.println("Deseja mesmo deletar a pessoa " + nome + "? (s/n)");
                    String confirmacao = sc.nextLine();
                    if (confirmacao.equalsIgnoreCase("s")) {
                        pc.deletarPessoa(nome);
                    }else{
                        System.out.println("Operação cancelada.");
                    }
                        pc.deletarPessoa(null);
                    break; 
                case 3:
                    System.out.println("Lista de pessoas cadastradas:");
                    pc.listarPessoas();
                    break;
                case 4:
                    System.out.println("Digite o nome da pessoa que deseja buscar:");
                    String nomePessoa = sc.nextLine();
                    pc.buscarPessoa(nomePessoa);
                    break;
                case 5:
                    System.out.println("Digite o nome da pessoa que deseja atualizar:");
                    String nomePessoaAtualizar = sc.nextLine();
                    pc.atualizarPessoa(nomePessoaAtualizar);
                    break;

                case 6:
                    System.out.println("Deseja mesmo encerrar o programa? (s/n)");
                    String confirmacaoEncerrar = sc.nextLine();
                    if (confirmacaoEncerrar.equalsIgnoreCase("s")) {
                        programaEncerrado = true;
                        System.out.println("Salvando dados...");
                        pc.escreverArquivo();
                    } else {
                        System.out.println("Operação cancelada.");
                    }
                    break;
                default:
                    break;
            }
        };

        
    }

    private static Pessoa intanciarPessoa(Scanner sc, PessoaController pc) {
        System.out.println("Digite o nome da pessoa:");
        String nome = sc.next();
        sc.nextLine();
        System.out.println("Digite a idade da pessoa:");
        int idade = sc.nextInt();
        sc.nextLine();
        System.out.println("Digite o email da pessoa:");
        String email = sc.next();
        sc.nextLine();
        System.out.println("Digite o telefone da pessoa:");
        String telefone = sc.next();
        sc.nextLine();
        Pessoa pessoa = new Pessoa(nome, idade, email, telefone);
        return pessoa;
    }
}