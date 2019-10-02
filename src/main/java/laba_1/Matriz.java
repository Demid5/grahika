package laba_1;

import laba_1.figures.Figure;

import java.awt.*;

public abstract class Matriz {
    public static double[][] multiplicationMatriz(double matriz1[][], double matriz2[][]) {
        int n = matriz1.length;
        int m = matriz2[0].length;
        int o = matriz2.length;
        double newMatriz[][] = new double[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < o; k++) {
                    newMatriz[i][j] += matriz1[i][k] * matriz2[k][j];
                }
            }
        }
        return newMatriz;
    }


    public static double[][] getV(final Figure figure) {
        MyPoint3D myPoint3D[] = figure.getPoints();
        double v[][] = new double[6][4];
        double V[][] = new double[4][6];


         //z = 25--
        v[0] = abcd(myPoint3D[0], myPoint3D[1], myPoint3D[2]);

        // y = 25
        v[1] = abcd(myPoint3D[0], myPoint3D[1], myPoint3D[4]);

        // x = 25
        v[2] = abcd(myPoint3D[0], myPoint3D[2], myPoint3D[4]);

        // z = 100
        v[3] = abcd(myPoint3D[4], myPoint3D[5], myPoint3D[6]);

        // y = 100
        v[4] = abcd(myPoint3D[2], myPoint3D[3], myPoint3D[6]);

        // x = 100
        v[5] = abcd(myPoint3D[1], myPoint3D[3], myPoint3D[5]);


        for (int i = 0; i < 6; ++i) {
            for (int j = 0; j < 4; ++j) {
                V[j][i] = v[i][j];
            }
        }

        return V;
    }

    private static double[] abcd(MyPoint3D firstPoint, MyPoint3D secondPoint, MyPoint3D threePoint) {
        double a = (secondPoint.getY() - firstPoint.getY()) * (threePoint.getZ() - firstPoint.getZ())
                - (threePoint.getY() - firstPoint.getY()) * (secondPoint.getZ() - firstPoint.getZ());
        double b = (secondPoint.getZ() - firstPoint.getZ()) * (threePoint.getX() - firstPoint.getX())
                -  (threePoint.getZ() - firstPoint.getZ()) * (secondPoint.getX() - firstPoint.getX());
        double c = (secondPoint.getX() - firstPoint.getX()) * (threePoint.getY() - firstPoint.getY())
                - (threePoint.getX() - firstPoint.getX()) * (secondPoint.getY() - firstPoint.getY());
        double d = -firstPoint.getX() * a - firstPoint.getY() * b - firstPoint.getZ() * c;
        return new double[]{a, b, c, d};
    }


    public static void print(double matrix[][]) {
        int n = matrix.length, m = matrix[0].length;
        for (int j = 0; j < m; ++j) {
            for (int i = 0; i < n; ++i) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static double cos(MyPoint3D a, MyPoint3D b) {
        double nomerator = a.getX() * b.getX() + a.getY() * b.getY() + a.getZ() * b.getZ();
        double denumerator = Math.sqrt(a.getX() * a.getX() + a.getY() * a.getY() + a.getZ() * a.getZ())
                * Math.sqrt(b.getX() * b.getX() + b.getY() * b.getY() + b.getZ() * b.getZ());
        return nomerator / denumerator;
    }
}
