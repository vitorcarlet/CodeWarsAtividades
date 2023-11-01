package provaMetodos;

public class EliminacaoGauss {
    public static void main(String[] args) {
        // Define a matriz de coeficientes e o vetor de constantes
        double[][] matriz = {
                {2, 1, 1, 1},
                {1,2,1,1},
                {1,1,2,1},
                {1,1,1,2}
        };
        double[] vetorConstantes = {1, 2, 3,4};

        int n = vetorConstantes.length;

        // Aplica o método da Eliminação de Gauss
        for (int k = 0; k < n - 1; k++) {
            // Encontra o pivô
            for (int i = k + 1; i < n; i++) {
                double fator = matriz[i][k] / matriz[k][k];
                for (int j = k; j < n; j++) {
                    matriz[i][j] -= fator * matriz[k][j];
                }
                vetorConstantes[i] -= fator * vetorConstantes[k];
            }

            // Mostra a matriz após a etapa k
            System.out.println("Após a etapa " + (k + 1) + ":");
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(matriz[i][j] + " ");
                }
                System.out.println(" | " + vetorConstantes[i]);
            }
        }

        System.out.println("\n\nResolver o sitema trinagular superior resultante\n\n");

        // Resolve o sistema triangular superior resultante
        double[] solucao = new double[n];
        for (int i = n - 1; i >= 0; i--) {
            double soma = 0;
            for (int j = i + 1; j < n; j++) {
                System.out.println("Soma para resolver o sistema triangular superior resultante:\n" +
                        "soma = "+matriz[i][j] +" *"+solucao[j]
                );
                soma += matriz[i][j] * solucao[j];
            }
            System.out.println("Solução resultante:\n" +
                    "solucao[i] = ("+vetorConstantes[i]+ "-" +soma+ ") /"+matriz[i][i]
            );

            solucao[i] = (vetorConstantes[i] - soma) / matriz[i][i];
            System.out.println("solução ["+i+"] = "+solucao[i]);
            System.out.println("\n");
        }

        // Mostra a solução
        System.out.println("Solução:");
        for (int i = 0; i < n; i++) {
            System.out.println("x" + (i + 1) + " = " + solucao[i]);
        }
    }
}
