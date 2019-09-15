package laba_1.conversion;

import laba_1.Cube;
import laba_1.conversion.Conversion;

import static java.lang.Math.cos;
import static java.lang.Math.sin;

public class Rotation implements Conversion {
    private double alpha;
    private double matrizRotation[][];
    private String exis;

    public Rotation() { }

    public Rotation(double alpha) {
        this.alpha = alpha;
    }

    public void setExis(String exis) {
        this.exis = exis;
    }

    private void setMatrizRotation() {
        matrizRotation = new double[][]{
                {1, 0, 0, 0},
                {0, 1, 0, 0},
                {0, 0, 1, 0},
                {0, 0, 0, 1}
        };
        switch (exis) {
            case "OX":
                matrizRotation[1][1] = cos(alpha);
                matrizRotation[1][2] = sin(alpha);
                matrizRotation[2][1] = -sin(alpha);
                matrizRotation[2][2] = cos(alpha);
                break;
            case "OY":
                matrizRotation[0][0] = cos(alpha);
                matrizRotation[0][2] = -sin(alpha);
                matrizRotation[2][0] = sin(alpha);
                matrizRotation[2][2] = cos(alpha);
                break;
            case "OZ":
                matrizRotation[0][0] = cos(alpha);
                matrizRotation[0][1] = sin(alpha);
                matrizRotation[1][0] = -sin(alpha);
                matrizRotation[1][1] = cos(alpha);
                break;
        }
    }

    public double[][] getMatriz() {
        return matrizRotation;
    }


    @Override
    public void setConversionPoints(Cube cube) {
        setMatrizRotation();
        Conversion.super.setConversionPoints(cube);
    }
}
