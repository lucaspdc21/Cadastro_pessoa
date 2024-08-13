package Controllers;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import Models.Pessoa;

public class PessoaController {

    private String enderecoArquivo = "pessoas.txt"; 
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
            System.out.println("Pessoa " + nome + " removida com sucesso.");
        } else {
            System.out.println("Pessoa " + nome + " não encontrada.");
            return;
        }
    }

    // Função que lê linha por linha do arquivo pessoas.txt
    private void lerArquivo() {
        try (FileReader fr = new FileReader(enderecoArquivo);BufferedReader br = new BufferedReader(fr)) {
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
        try (FileWriter fw = new FileWriter(enderecoArquivo, false);BufferedWriter bw = new BufferedWriter(fw)) {
            for (Pessoa pessoa : listaDePessoas) {
                bw.write(pessoa.toString());
                bw.newLine();
            }
            bw.flush(); // Libera o buffer
        } catch (IOException e) {
            System.out.println("Erro ao escrever no arquivo de pessoas");
        }
    }

    // Encerra o programa após escrever os dados no arquivo
    public void encerrarPrograma() {
        escreverArquivo();
    }
}
