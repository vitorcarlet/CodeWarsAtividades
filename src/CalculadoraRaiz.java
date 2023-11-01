import java.util.ArrayList;
import java.util.Scanner;

public class CalculadoraRaiz {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double a = 1.0; // Coeficiente 'a' da função f(x) = ax + b
        double b = -1.0; // Coeficiente 'b' da função f(x) = ax + b
        double precisao = 1e-3; // Precisão desejada
        double xA = 0.0; // Intervalo inicial (a)
        double xB = 1.0; // Intervalo inicial (b)
        double xInicial = 0.5; // Valor inicial de x para os métodos ponto fixo e Newton-Raphson
        int maxIteracoes = 15; // Número máximo de iterações

        ArrayList<TabelaPassoAPasso> tabelaBisseccao = new ArrayList<>();
        ArrayList<TabelaPassoAPasso> tabelaPosicaoFalsa = new ArrayList<>();
        ArrayList<TabelaPassoAPasso> tabelaPontoFixo = new ArrayList<>();
        ArrayList<TabelaPassoAPasso> tabelaNewtonRaphson = new ArrayList<>();

        double raizBisseccao = bisseccao(a, b, xA, xB, precisao, maxIteracoes, tabelaBisseccao);
        double raizPosicaoFalsa = posicaoFalsa(a, b, xA, xB, precisao, maxIteracoes, tabelaPosicaoFalsa);
        double raizPontoFixo = pontoFixo(a, b, xInicial, precisao, maxIteracoes, tabelaPontoFixo);
        double raizNewtonRaphson = newtonRaphson(a, b, xInicial, precisao, maxIteracoes, tabelaNewtonRaphson);

        // Imprimir a tabela passo a passo para bissecção
        System.out.println("Método da Bissecção:");
        System.out.println("k\t  a\t\t  b\t\t  x\t\t  f(a)\t\t  f(b)\t\t  f(x)\t\t  |xk+1 - xk|");
        for (TabelaPassoAPasso linha : tabelaBisseccao) {
            System.out.printf("%d\t  %.3f\t  %.3f\t  %.3f\t  %.3f\t  %.3f\t  %.3f\t  %.3f%n",
                    linha.iteracao, linha.a, linha.b, linha.x, linha.fA, linha.fB, linha.fX, linha.deltaX);
        }
        System.out.println("Raiz aproximada (Bissecção): " + raizBisseccao);
        System.out.println();

        // Imprimir a tabela passo a passo para posição falsa
        System.out.println("Método da Posição Falsa:");
        System.out.println("k\t  a\t\t  b\t\t  x\t\t  f(a)\t\t  f(b)\t\t  f(x)\t\t  |xk+1 - xk|");
        for (TabelaPassoAPasso linha : tabelaPosicaoFalsa) {
            System.out.printf("%d\t  %.3f\t  %.3f\t  %.3f\t  %.3f\t  %.3f\t  %.3f\t  %.3f%n",
                    linha.iteracao, linha.a, linha.b, linha.x, linha.fA, linha.fB, linha.fX, linha.deltaX);
        }
        System.out.println("Raiz aproximada (Posição Falsa): " + raizPosicaoFalsa);
        System.out.println();

        // Imprimir a tabela passo a passo para ponto fixo
        System.out.println("Método do Ponto Fixo:");
        System.out.println("k\t  x\t\t  f(x)\t\t  |xk+1 - xk|");
        for (TabelaPassoAPasso linha : tabelaPontoFixo) {
            System.out.printf("%d\t  %.3f\t  %.3f\t  %.3f%n",
                    linha.iteracao, linha.x, linha.fX, linha.deltaX);
        }
        System.out.println("Raiz aproximada (Ponto Fixo): " + raizPontoFixo);
        System.out.println();

        // Imprimir a tabela passo a passo para Newton-Raphson
        System.out.println("Método de Newton-Raphson:");
        System.out.println("k\t  x\t\t  f(x)\t\t  |xk+1 - xk|");
        for (TabelaPassoAPasso linha : tabelaNewtonRaphson) {
            System.out.printf("%d\t  %.3f\t  %.3f\t  %.3f%n",
                    linha.iteracao, linha.x, linha.fX, linha.deltaX);
        }
        System.out.println("Raiz aproximada (Newton-Raphson): " + raizNewtonRaphson);
    }

    static double f(double a, double b, double x) {
        return a * x + b;
    }

    static double bisseccao(double a, double b, double xA, double xB, double precisao, int maxIteracoes, ArrayList<TabelaPassoAPasso> tabela) {
        double raiz = 0.0;

        for (int iteracao = 1; iteracao <= maxIteracoes; iteracao++) {
            double x = (xA + xB) / 2;
            double fA = f(a, b, xA);
            double fB = f(a, b, xB);
            double fX = f(a, b, x);
            double deltaX = Math.abs(x - xA);

            tabela.add(new TabelaPassoAPasso(iteracao, xA, xB, x, fA, fB, fX, deltaX));

            if (Math.abs(fX) < precisao || deltaX < precisao) {
                raiz = x;
                break;
            }

            if (fA * fX < 0) {
                xB = x;
            } else {
                xA = x;
            }
        }

        return raiz;
    }

    static double posicaoFalsa(double a, double b, double xA, double xB, double precisao, int maxIteracoes, ArrayList<TabelaPassoAPasso> tabela) {
        double raiz = 0.0;

        for (int iteracao = 1; iteracao <= maxIteracoes; iteracao++) {
            double fA = f(a, b, xA);
            double fB = f(a, b, xB);
            double x = (xA * fB - xB * fA) / (fB - fA);
            double fX = f(a, b, x);
            double deltaX = Math.abs(x - xA);

            tabela.add(new TabelaPassoAPasso(iteracao, xA, xB, x, fA, fB, fX, deltaX));

            if (Math.abs(fX) < precisao || deltaX < precisao) {
                raiz = x;
                break;
            }

            if (fA * fX < 0) {
                xB = x;
            } else {
                xA = x;
            }
        }

        return raiz;
    }

    static double pontoFixo(double a, double b, double xInicial, double precisao, int maxIteracoes, ArrayList<TabelaPassoAPasso> tabela) {
        double xAtual = xInicial;
        double raiz = 0.0;

        for (int iteracao = 1; iteracao <= maxIteracoes; iteracao++) {
            double fXAtual = f(a, b, xAtual);
            double deltaX = Math.abs(xAtual - fXAtual);

            tabela.add(new TabelaPassoAPasso(iteracao, xAtual, fXAtual, deltaX));

            if (Math.abs(fXAtual) < precisao || deltaX < precisao) {
                raiz = xAtual;
                break;
            }

            xAtual = fXAtual;
        }

        return raiz;
    }

    static double newtonRaphson(double a, double b, double xInicial, double precisao, int maxIteracoes, ArrayList<TabelaPassoAPasso> tabela) {
        double xAtual = xInicial;
        double raiz = 0.0;

        for (int iteracao = 1; iteracao <= maxIteracoes; iteracao++) {
            double fXAtual = f(a, b, xAtual);
            double derivada = a; // Derivada da função f(x) = ax + b é igual a 'a'.
            double deltaX = Math.abs(fXAtual / derivada);

            tabela.add(new TabelaPassoAPasso(iteracao, xAtual, fXAtual, deltaX));

            if (Math.abs(fXAtual) < precisao || deltaX < precisao) {
                raiz = xAtual;
                break;
            }

            xAtual = xAtual - fXAtual / derivada;
        }

        return raiz;
    }
}

class TabelaPassoAPasso {
    int iteracao;
    double a;
    double b;
    double x;
    double fA;
    double fB;
    double fX;
    double deltaX;

    public TabelaPassoAPasso(int iteracao, double a, double b, double x, double fA, double fB, double fX, double deltaX) {
        this.iteracao = iteracao;
        this.a = a;
        this.b = b;
        this.x = x;
        this.fA = fA;
        this.fB = fB;
        this.fX = fX;
        this.deltaX = deltaX;
    }

    public TabelaPassoAPasso(int iteracao, double x, double fX, double deltaX) {
        this.iteracao = iteracao;
        this.x = x;
        this.fX = fX;
        this.deltaX = deltaX;
    }
}
