package laba_1.conversion;

public class Dilatation implements Conversion {
    private static double matrizDilatation[][];
    private double alpha, beta, gamma;

    public Dilatation() {
        alpha = beta = gamma = 1;
    }

    public void setMatrizDilatation(String property) {

        if (property.equals("Сжатие")) {
            alpha = beta = gamma = 0.95;
        }
        else {
            alpha = beta = gamma = 1.05;
        }

        matrizDilatation = new double[][] {
                {alpha, 0, 0, 0},
                {0, beta, 0, 0},
                {0, 0, gamma, 0},
                {0, 0, 0, 1}
        };
    }

    @Override
    public double[][] getMatriz() {
        return matrizDilatation;
    }
}
