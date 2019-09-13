package laba_1;

import java.lang.Math;

import static java.lang.Math.cos;
import static java.lang.Math.sin;

public class Rotation {
    private static double alpha;
    private static double matriz[][];

    public static void initMatriz(double al) {
        alpha = al;
        matriz = new double[][]{
                {cos(alpha), -sin(alpha), 0, 0},
                {sin(alpha), cos(alpha), 0, 0},
                {0, 0, 1, 0},
                {0, 0, 0, 1}
        };
    }


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

    public static MyPoint2D rotation(MyPoint3D coordinate) {
        double newCoordinate[] = multiplicationVectorMatriz(new double[]{coordinate.getX(), coordinate.getY(), coordinate.getZ(), 1}, matriz);
        return new MyPoint2D((int)newCoordinate[0], (int)newCoordinate[1]);
    }
}
