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

}
