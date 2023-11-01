package provaMetodos;

public class GaussSeidelExample {
    public static void main(String[] args) {
        double[][] A = {
                {20, -1,2,3,4,6},
                {-6,30,-1,-4,3,5},
                {-2,1,15,1,4,6},
                {2,-2,1,24,4,-1},
                {3,3,-4,7,35,7},
                {1,-3,2,6,3,27}
        };

        double[] b = {1,59,-11,-68,9,-74};

        int n = A.length;
        double[] x = new double[n];
        double epsilon = 1e-6;
        int maxIterations = 1000;

        for (int k = 0; k < maxIterations; k++) {
            for (int i = 0; i < n; i++) {
                double sum = 0.0;
                for (int j = 0; j < n; j++) {
                    if (j != i) {
                        sum += A[i][j] * x[j];
                    }
                }
                x[i] = (b[i] - sum) / A[i][i];
            }

            // Verificar a convergência
            double error = 0.0;
            for (int i = 0; i < n; i++) {
                error += Math.abs(A[i][i] * x[i] - b[i]);
            }

            if (error < epsilon) {
                System.out.println("Convergência alcançada após " + (k + 1) + " iterações.");
                break;
            }
        }

        // Imprimir a solução
        System.out.println("Solução: ");
        for (int i = 0; i < n; i++) {
            System.out.println("x[" + i + "] = " + x[i]);
        }
    }
}
