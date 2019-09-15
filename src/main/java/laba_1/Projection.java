package laba_1;

import laba_1.conversion.Conversion;
import laba_1.figures.Figure;

public class Projection implements Conversion {

    private static final double T[][] = {
        { 1, 0, 0, 0},
        {0, 1, 0, 0},
        {0.707106781, 0.707106781, 0, 0},
        {0, 0, 0, 1}
    };

    public double[][] getMatriz() {
        return T;
    }

    @Override
    public void setConversionPoints(Figure figure) {
        int n = figure.getPoints().length;
        MyPoint3D coorProjection[] = new MyPoint3D[n];
        for (int i = 0; i < n; ++i) {
            coorProjection[i] = executeConversionPoint(figure.getPoints()[i]);
        }
        figure.setEdges(coorProjection);
    }

}
