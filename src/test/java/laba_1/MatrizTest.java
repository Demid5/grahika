package laba_1;

import laba_1.figures.Cube;
import laba_1.figures.Figure;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.w3c.dom.ls.LSOutput;


public class MatrizTest {
    double [][]v;
    double [][]e;
    Figure figure;

    @Before
    public void initData() {
        figure = new Cube();
        v = Matriz.getV(figure);
        e = new double[][]{{10, 10, -10, 0}};
    }

    @Test
   public void correct() {
        double s[][] = new double[][]{{50, 75, 60, 1}};
        double result[][] = Matriz.multiplicationMatriz(s, v);
        for (int i = 0; i < result[0].length; ++i) {
            if (result[0][i] < 0) {
                multiPlication(i);
            }
        }
        result = Matriz.multiplicationMatriz(e, v);
        int n = v.length, m = v[0].length;
        for (int j = 0; j < m; ++j) {
            System.out.println(Matriz.cos(new MyPoint3D(v[0][j], v[1][j], v[2][j]), new MyPoint3D(e[0][0], e[0][1], e[0][2])));
        }


        Matriz.print(v);
        Assert.assertEquals(s, result);
    }


    private void multiPlication(int column) {
        for (int i = 0; i < v.length; ++i) {
            v[i][column] *= (-1);
        }
    }
}
