import javax.swing.*;
import java.io.IOException;

public class Metodos {
    public int[] secao =  new int[10];
    public int[] votoscandidatos = new int[300];
    public Votacao[] pQtdEleitores(Votacao[] votacao) throws IOException {
        //tentativa de mostrar a quantidade de eleitores por Seção

        int i;
        String mostra = "";

        for(i = 0; i < 200; i++){
                secao[votacao[i].NumeroSecao ] ++;
        }

        for(i = 0; i < 10; i++){
            mostra += " Seção: " + (i + 1) + " Qtd.Eleitores: " + secao[i];
            mostra += "\n";
        }
        JOptionPane.showMessageDialog(null, mostra);

        return votacao;
    }

    public Votacao[] pSecaoMaiorMenor(Votacao[] votacao) throws IOException {
        int aux, i;
        for(i = 0; i < 10 - 1; i++){
            for(int j = 0; j < 10 - i - 1; j++){
                if(secao[i] > secao[i + 1]){
                    aux =  secao[i];
                    secao[i] =  secao[i + 1];
                    secao[i + 1] =  aux;
                }
            }
        }

        JOptionPane.showMessageDialog(null, "Maior número de eleitores: " + secao[9] + "\nMenor número de eleitores: " + secao[0]);
        return votacao;
    }

    public Votacao[] pQtdVotos(Votacao[] votacao) throws IOException {
        //quantidade de votos por candidato
        for(int i =  0; i < 200; i++){
            votoscandidatos[votacao[i].NumeroCandidato]++;
        }

        String mostra = "";
        for(int j = 0; j < 200; j++){
            mostra += "Candidato: " + votacao[j].NumeroCandidato + " Qtd.Votos: " + votoscandidatos[j];
            mostra += "\n";
        }
        for(int k = 0; k < 200; k++){
            System.out.println("Candidato: " + votacao[k].NumeroCandidato + " Qtd.Votos: " + votoscandidatos[k]);
        }

        JOptionPane.showMessageDialog(null, mostra);
        return votacao;
    }

    public Votacao[] p10Primeiros(Votacao[] votacao) throws IOException {
        int[] DezPrimeiros = new int[200];
        int i;
        for( i = 0; i < 200; i++){
            if(votoscandidatos[i] != 0 & votoscandidatos[i] >= 1){
                DezPrimeiros[i] =  votoscandidatos[i];
            }
        }

        for( i = 0; i < 200; i++){
            for(int j = 0; j < 200 - i - 1; j++){
                if(DezPrimeiros[j] > DezPrimeiros[j + 1]){
                    int aux = DezPrimeiros[j];
                    DezPrimeiros[j] = DezPrimeiros[j + 1];
                    DezPrimeiros[j + 1] =  aux;
                }
            }
            //System.out.println(DezPrimeiros[i]);
        }

        String mostra = "";
        for(i = 0 ; i < 10; i++){
            int posicao =  200 - i  - 1;
            mostra += ("Candidato: " + votacao[posicao].NumeroCandidato + " Qtd.Votos: " + DezPrimeiros[posicao] + "\n");
        }
        JOptionPane.showMessageDialog(null, "TOP 10 PRIMEIROS CANDIDATOS\n" + mostra);

        return votacao;
    }
}
