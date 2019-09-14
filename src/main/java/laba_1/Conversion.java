package laba_1;

public interface Conversion {

    double[][] getMatriz();

    default MyPoint3D executeConversionPoint(MyPoint3D coordinate) {
        double curResuls[][] = Matriz.multiplicationMatriz(new double[][]{{coordinate.getX(), coordinate.getY(), coordinate.getZ(), 1}}, getMatriz());
        return new MyPoint3D(curResuls[0][0], curResuls[0][1], curResuls[0][2]);
    }

    default void setConversionPoints(Cube cube) {
        for (int i = 0; i < cube.getPoints().length; ++i) {
            cube.getPoints()[i] = executeConversionPoint(cube.getPoints()[i]);
        }
        cube.updatePoints();
    }

}
