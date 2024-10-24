import javax.swing.*;
import java.io.IOException;

public class Principal {
        public static void main(String[] args) throws IOException {
            Votacao[] votacao = new Votacao[200];
            ClasseMetodos m = new ClasseMetodos();
            Metodos metodos =  new Metodos();

            int i, opc = 0;
            while(opc!=9){
                    opc = Integer.parseInt(JOptionPane.showInputDialog("SISTEMA DE VOTAÇÃO\n1 – Carregar Seção/Número Eleitor\n" +
                            "2 – Classificar por Seção \n3 – Gravar Registros \n4 – Mostrar Indicadores\n9 – Finalizar "));

                    switch(opc){
                            case 1:
                                    votacao = m.fCadastrarVotos(votacao);
                                    JOptionPane.showMessageDialog(null, "Dados Cadastrados");
                                    break;
                            case 2:
                                    votacao = m.fClassifica(votacao);
                                    JOptionPane.showMessageDialog(null, "Dados Classificados");
                                    break;
                            case 3:
                                    m.pGravarArquivo(votacao);
                                    break;
                            case 4:
                                while(opc != 9){
                                    opc =  Integer.parseInt(JOptionPane.showInputDialog("MOSTRAR INDICADORES\nEstatísticas de Votação em 2024" +
                                            "\n1-Quantidade de Eleitores por Seção" +
                                            "\n2-Seção com Maior e Menor número de Eleitores" +
                                            "\n3-Quantidade de votos por candidato" +
                                            "\n4-10 Primeiros colocados (nmr.cand e qtd.votos)" +
                                            "\n9-Finalizar Consulta"));

                                    switch (opc){
                                        case 1:
                                            metodos.pQtdEleitores(votacao);
                                            break;
                                        case 2:
                                            metodos.pSecaoMaiorMenor(votacao);
                                            break;
                                        case 3:
                                            metodos.pQtdVotos(votacao);
                                            break;
                                        case 4:
                                            metodos.p10Primeiros(votacao);
                                            break;
                                        case 9:
                                            JOptionPane.showMessageDialog(null, "Finalizando Consulta");
                                            break;
                                        default:
                                            JOptionPane.showMessageDialog(null, "Insira uma opção que seja valida");
                                    }
                                }

                                    break;
                            case 9:
                                    JOptionPane.showMessageDialog(null, "Processo Finalizado");
                                    break;
                            default:
                                    JOptionPane.showMessageDialog(null, "Insira uma opção que seja valida");
                    }
            }
        }
}
