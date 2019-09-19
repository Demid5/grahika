package laba_1.conversion;

public class Translation implements Conversion{

    private double[][] matrizTraslation;
    private double y, n, v;

    public Translation() {
        y = n = v = 0;
    }

    @Override
    public double[][] getMatriz() {
        return matrizTraslation;
    }

    public void setMatrizTraslation(String selectedItem) {
        y = n = v = 0;
        switch (selectedItem) {
            case "по оси OX": { y = 5; } break;
            case "по оси OY": { n = 5; } break;
            case "по оси OZ": { v = 5; } break;
        }

        matrizTraslation = new double[][] {
                {1, 0, 0, 0},
                {0, 1, 0, 0},
                {0, 0, 1, 0},
                {y, n, v, 1}
        };
    }

    public void setMatrizTraslation(double y, double n, double v) {
        this.y = y; this.n = n; this.v = v;
        matrizTraslation = new double[][] {
                {1, 0, 0, 0},
                {0, 1, 0, 0},
                {0, 0, 1, 0},
                {y, n, v, 1}
        };
    }
}
