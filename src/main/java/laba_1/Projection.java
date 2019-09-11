package laba_1;

public class Projection {

    private static final double T[][] = {
        { 1, 0, 0, 0},
        {0, 1, 0, 0},
        {0.707106781, 0.707106781, 0, 0},
        {0, 0, 0, 1}
    };


    private static double[] multiplicationVectorMatriz(double vector[], double matriz[][]) {
        double newVector[] = new double[vector.length];
        int n = matriz.length, m = matriz[0].length;
        double curSum = 0;
        for (int i = 0; i < m; ++i) {
            curSum = 0;
            for (int j = 0; j < n; ++j) {
                curSum += (vector[j] * matriz[j][i]);
            }
            newVector[i] = curSum;
        }
        return newVector;
    }

    public static Point obliqueProjection(Point coordinate) {
        double newCoordinate[] = multiplicationVectorMatriz(new double[]{coordinate.getX(), coordinate.getY(), coordinate.getZ(), 1}, T);
        return new Point((int)newCoordinate[0], (int)newCoordinate[1], (int)newCoordinate[2]);
    }
}
