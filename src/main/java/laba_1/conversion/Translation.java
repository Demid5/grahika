package laba_1.conversion;

public class Translation implements Conversion{

    private double[][] matrizTraslation;
    private double y, n, v;

    public void setMatrizTraslation(double y, double n, double v) {
        matrizTraslation = new double[][] {
                {1, 0, 0, 0},
                {0, 1, 0, 0},
                {0, 0, 1, 0},
                {y, n, v, 1}
        };
    }

    @Override
    public double[][] getMatriz() {
        return matrizTraslation;
    }
}
