package Controllers;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import Models.Pessoa;

public class PessoaController {

    private String enderecoArquivo = "pessoas.txt";
    private FileWriter fw;
    private BufferedWriter bw;

    public PessoaController() {
        try {
            fw = new FileWriter(enderecoArquivo, true);
            bw = new BufferedWriter(fw);
        } catch (IOException e) {
            System.out.println("Erro ao acessar o arquivos de pessoas");
        }
    }

    public void cadastrarPessoa(Pessoa pessoa){
        try{
            bw.write(pessoa.toString());
            // Pula a linha para o próximo cadastro
            bw.newLine();
            // Força a escrita dos dados em Buffer
            bw.flush();
        } catch (IOException e) {
            System.out.println("Erro ao cadastrar a pessoa:");
        }
    }
    
    // Método necessario para fechar o arquivo após as alterações, OBRIGATORIO
    public void fecharArquivo(){
        try {
            bw.close();
            fw.close();
        } catch (IOException e) {
            System.out.println("Erro ao fechar o arquivo de pessoas");
        }
    }


}
