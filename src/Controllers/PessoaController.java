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

    public PessoaController() {
        lerArquivo();
    }

    public void cadastrarPessoa(Pessoa pessoa) {
        listaDePessoas.add(pessoa);
    }

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

    private void escreverArquivo() {
        try (FileWriter fw = new FileWriter(enderecoArquivo, false);BufferedWriter bw = new BufferedWriter(fw)) {
            for (Pessoa pessoa : listaDePessoas) {
                bw.write(pessoa.toString());
                bw.newLine();
            }
            bw.flush();
        } catch (IOException e) {
            System.out.println("Erro ao escrever no arquivo de pessoas");
        }
    }

    public void encerrarPrograma() {
        escreverArquivo();
    }
}
