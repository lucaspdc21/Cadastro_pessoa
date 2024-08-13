package Services;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import Models.Pessoa;

public class PessoaService {

    private String enderecoArquivo = "pessoas.txt";

    public void buscarUsuario(String nome) {
        String linha;
        boolean encontrado = false;
        try (BufferedReader br = new BufferedReader(new FileReader(enderecoArquivo))) {
            while ((linha = br.readLine()) != null) {
                if (linha.contains(nome)) {
                    Pessoa pessoa = Pessoa.capturaNoArquivo(linha);
                    System.out.println(pessoa);
                    encontrado = true;
                    break;
                }
            }
            if (!encontrado) {
                System.out.println("Usuário não encontrado");
            }
        } catch (IOException e) {
            System.out.println("Erro ao buscar o usuário:");
            e.printStackTrace();
        }
    }
}
