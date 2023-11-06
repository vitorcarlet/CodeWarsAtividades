package provaMetodos;

public class LUDecompositionExample {
    public static void main(String[] args) {
        double[][] A = {
                {1, 3, 5,7},
                {3, 5, 7,1},
                {5,7,1,3},
                {7, 1,3,5}

        };

        double[] b = {12,0,4,16};

        int n = A.length;
        double[][] L = new double[n][n];
        double[][] U = new double[n][n];

        // Decomposição LU
        for (int i = 0; i < n; i++) {
            L[i][i] = 1;
            for (int j = i; j < n; j++) {
                double sum = 0;
                for (int k = 0; k < i; k++) {
                    sum += L[i][k] * U[k][j];
                }
                U[i][j] = A[i][j] - sum;
            }
            for (int j = i + 1; j < n; j++) {
                double sum = 0;
                for (int k = 0; k < i; k++) {
                    sum += L[j][k] * U[k][i];
                }
                L[j][i] = (A[j][i] - sum) / U[i][i];
            }

            // Imprime L e U a cada passo
            System.out.println("Passo " + (i + 1) + ":");
            System.out.println("L:");
            printMatrix(L);
            System.out.println("U:");
            printMatrix(U);
            System.out.println();
        }

        // Resolvendo o sistema LY = b
        double[] Y = new double[n];
        for (int i = 0; i < n; i++) {
            double sum = 0;
            for (int j = 0; j < i; j++) {
                sum += L[i][j] * Y[j];
            }
            Y[i] = (b[i] - sum) / L[i][i];
            System.out.println("Resolvendo o sistema LY = B");
            System.out.println("Y["+i+"] = (b["+i+"] - sum) / L["+i+"]["+i+"]");
            System.out.println("Y["+i+"] = "+(b[i] - sum)+"/"+  L[i][i]);
            System.out.println(Y[i]);
        }

        System.out.println("\n\n");

        // Resolvendo o sistema Ux = Y
        double[] x = new double[n];
        for (int i = n - 1; i >= 0; i--) {
            double sum = 0;
            for (int j = i + 1; j < n; j++) {
                sum += U[i][j] * x[j];
            }
            x[i] = (Y[i] - sum) / U[i][i];
            System.out.println("Resolvendo o sistema Ux = Y");
            System.out.println("x["+i+"] = (Y["+i+"] - sum) / U["+i+"]["+i+"]");
            System.out.println("x["+i+"] = "+(Y[i] +"-"+ sum)+"/"+  U[i][i]);
            System.out.println(x[i]);
        }

        // Imprime a solução
        System.out.println("Solução: ");
        for (int i = 0; i < n; i++) {
            System.out.println("x[" + i + "] = " + x[i]);
        }
    }

    // Função para imprimir uma matriz
    public static void printMatrix(double[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
