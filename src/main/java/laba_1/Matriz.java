package laba_1;

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


    // NK, NM
    public static double[] abcd(MyPoint3D firstPoint, MyPoint3D secondPoint, MyPoint3D threePoint) {
   /*     double a = N.getX() * M.getY() - M.getX() * N.getY();
        double b = -(K.getX() * M.getY() - M.getX() * K.getY());
        double c = K.getX() * N.getY() - N.getX() * K.getY();*/

        double a = (secondPoint.getY() - firstPoint.getY()) * (threePoint.getZ() - firstPoint.getZ())
                - (threePoint.getY() - firstPoint.getY()) * (secondPoint.getZ() - firstPoint.getZ());
        double b = (secondPoint.getZ() - firstPoint.getZ()) * (threePoint.getX() - firstPoint.getX())
                -  (threePoint.getZ() - firstPoint.getZ()) * (secondPoint.getX() - firstPoint.getX());
        double c = (secondPoint.getX() - firstPoint.getX()) * (threePoint.getY() - firstPoint.getY())
                - (threePoint.getX() - firstPoint.getX()) * (secondPoint.getY() - firstPoint.getY());

        return new double[]{a, b, c};
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

    public static double scalarProduct(MyPoint3D a, MyPoint3D b) {
        return a.getX() * b.getX() + a.getY() * b.getY() + a.getZ() * b.getZ();
    }

    public static void multiPlication(int column, double [][]v) {
        for (int i = 0; i < v.length; ++i) {
            v[i][column] *= (-1);
        }
    }
}
