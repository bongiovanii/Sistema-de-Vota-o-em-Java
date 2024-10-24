import javax.swing.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class ClasseMetodos {
    //Cadastrando o numero de candidatos e de seções com base no eleitor (200 eleitores)
    public Votacao[] fCadastrarVotos(Votacao[] votacao) {
        Random rand = new Random();
        int i;
        for (i = 0; i < 200; i++) {
            votacao[i] = new Votacao();
        }
        for (i = 0; i < 200; i++) {
            votacao[i].NumeroCandidato = rand.nextInt(300);
            votacao[i].NumeroSecao = rand.nextInt(10); //Integer.parseInt(JOptionPane.showInputDialog("Insira o número da seção (de 0 a 10)"));
        }
        return votacao;

    }

    public Votacao[] fClassifica(Votacao[] votacao) {
        int aux, i, j;
        for (i = 0; i < 200; i++) {
            for (j = 0; j < 200 - i - 1; j++) {
                if (votacao[j].NumeroSecao > votacao[j + 1].NumeroSecao ) {
                    aux = votacao[j].NumeroSecao;
                    votacao[j].NumeroSecao = votacao[j + 1].NumeroSecao;
                    votacao[j + 1].NumeroSecao = aux;
                }
            }
        }
        return votacao;
    }


    public Votacao[] pGravarArquivo(Votacao[] votacao) throws IOException {
        int i;
        //classe BufferedWriter para escrever no arquivo
        String fileName = "Votacao2024.txt";
        try (BufferedWriter escritor = new BufferedWriter(new FileWriter(fileName))){
            for(i = 0; i < 200; i++) {
                escritor.write(votacao[i].NumeroSecao + "\n");
                escritor.write(votacao[i].NumeroCandidato + "\n");
            }
        } catch(IOException e) {
            JOptionPane.showMessageDialog(null, "Erro ao gravar arquivo: ");
            throw e;
        }
        JOptionPane.showMessageDialog(null, "Arquivo Gerado");
        return votacao;

    }
}

