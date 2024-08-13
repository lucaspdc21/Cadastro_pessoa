package Controllers;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import Models.Pessoa;

public class PessoaController {

    private String enderecoArquivo = "../pessoas.txt"; 
    private List<Pessoa> listaDePessoas = new ArrayList<>();

    // Construtor que chama a função lerArquivo e armazena os dados em uma lista
    public PessoaController() {
        lerArquivo();
    }

    // Adiciona o usuário na lista: objeto "Pessoa" na lista "Pessoas"
    public void cadastrarPessoa(Pessoa pessoa) {
        listaDePessoas.add(pessoa);
    }

    // Remove a pessoa pelo nome e atualiza o arquivo
    public void deletarPessoa(String nome) {
        Pessoa pessoaParaRemover = null;
        for (Pessoa pessoa : listaDePessoas) {
            if (pessoa.getNome().equalsIgnoreCase(nome)) {
                pessoaParaRemover = pessoa;
                break;
            }
        }

        if (pessoaParaRemover != null) {
            listaDePessoas.remove(pessoaParaRemover);
            escreverArquivo(); // Atualiza o arquivo após a remoção
            System.out.println("Pessoa " + nome + " removida com sucesso.");
        } else {
            System.out.println("Pessoa " + nome + " não encontrada.");
        }
    }

    // Função que lê linha por linha do arquivo pessoas.txt
    private void lerArquivo() {
        try (FileReader fr = new FileReader(enderecoArquivo);
             BufferedReader br = new BufferedReader(fr)) {
            String linhaLida;
            while ((linhaLida = br.readLine()) != null) {
                Pessoa pessoa = Pessoa.capturaNoArquivo(linhaLida);
                listaDePessoas.add(pessoa);
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo de pessoas");
        }
    }

    // Armazena os dados do usuário após a leitura correta das informações
    private void escreverArquivo() {
        try (FileWriter fw = new FileWriter(enderecoArquivo, false);
             BufferedWriter bw = new BufferedWriter(fw)) {
            for (Pessoa pessoa : listaDePessoas) {
                bw.write(pessoa.toString());
                bw.newLine();
            }
            bw.flush(); // Libera o buffer
        } catch (IOException e) {
            System.out.println("Erro ao escrever no arquivo de pessoas");
        }
    }

    // atualização das informações de uma pessoa
    public void atualizarPessoa(String nome) {
        Pessoa pessoaParaAtualizar = null;
        for (Pessoa pessoa : listaDePessoas) {
            if (pessoa.getNome().equalsIgnoreCase(nome)) {
                pessoaParaAtualizar = pessoa;
                break;
            }
        }

        if (pessoaParaAtualizar != null) {
            Scanner scanner = new Scanner(System.in);
            
            // Atualizar nome
            System.out.print("Digite o novo nome (ou pressione Enter para manter o nome atual): ");
            String novoNome = scanner.nextLine().trim();
            if (!novoNome.isEmpty()) {
                pessoaParaAtualizar.setNome(novoNome);
            }

            // Atualizar idade
            boolean idadeValida = false;
            while (!idadeValida) {
                System.out.print("Digite a nova idade (ou pressione Enter para manter a idade atual): ");
                String idadeInput = scanner.nextLine().trim();
                if (idadeInput.isEmpty()) {
                    idadeValida = true; // Manter a idade atual
                } else {
                    try {
                        int novaIdade = Integer.parseInt(idadeInput);
                        pessoaParaAtualizar.setIdade(novaIdade);
                        idadeValida = true;
                    } catch (NumberFormatException e) {
                        System.out.println("Idade inválida. Por favor, insira um número.");
                    }
                }
            }

            // Atualizar e-mail
            System.out.print("Digite o novo e-mail (ou pressione Enter para manter o e-mail atual): ");
            String novoEmail = scanner.nextLine().trim();
            if (!novoEmail.isEmpty()) {
                pessoaParaAtualizar.setEmail(novoEmail);
            }

            // Atualizar telefone
            System.out.print("Digite o novo telefone (ou pressione Enter para manter o telefone atual): ");
            String novoTelefone = scanner.nextLine().trim();
            if (!novoTelefone.isEmpty()) {
                pessoaParaAtualizar.setTelefone(novoTelefone);
            }

            
            escreverArquivo();
            System.out.println("Informações atualizadas com sucesso.");
        } else {
            System.out.println("Pessoa não encontrada.");
        }
    }

    // Encerra o programa após escrever os dados no arquivo
    public void encerrarPrograma() {
        escreverArquivo();
    }
}
