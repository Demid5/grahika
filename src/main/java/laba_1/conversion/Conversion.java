package laba_1.conversion;

import laba_1.figures.Cube;
import laba_1.Matriz;
import laba_1.MyPoint3D;
import laba_1.figures.Figure;

public interface Conversion {

    double[][] getMatriz();

    default MyPoint3D executeConversionPoint(MyPoint3D coordinate) {
        double curResuls[][] = Matriz.multiplicationMatriz(new double[][]{{coordinate.getX(), coordinate.getY(), coordinate.getZ(), 1}}, getMatriz());
        return new MyPoint3D(curResuls[0][0], curResuls[0][1], curResuls[0][2]);
    }

    default void setConversionPoints(Figure figure) {
        for (int i = 0; i < figure.getPoints().length; ++i) {
            figure.getPoints()[i] = executeConversionPoint(figure.getPoints()[i]);
        }
    }

}
