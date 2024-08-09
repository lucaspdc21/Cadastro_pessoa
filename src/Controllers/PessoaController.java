package Controllers;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import Models.Pessoa;

public class PessoaController {
    private static final String FILE_NAME = "pessoas.txt";

    public void cadastrarPessoa(Pessoa pessoa) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
            writer.write(pessoa.toString());
            writer.newLine();
        }
    }

}
