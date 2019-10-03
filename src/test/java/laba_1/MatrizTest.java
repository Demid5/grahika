package laba_1;

import laba_1.figures.Cube;
import laba_1.figures.Figure;
import laba_1.figures.Tetrahedron;
import org.junit.Before;
import org.junit.Test;


public class MatrizTest {
    double [][]v;
    double [][]e;
    Figure figure;

    @Before
    public void initData() {
        figure = new Tetrahedron();
        v = figure.getV();
        e = new double[][]{{1, 1, -1}};
    }

    @Test
   public void correct() {
        double s[][] = new double[][]{{50, 10, 10}};
       /* double result[][] = Matriz.multiplicationMatriz(s, v);
        for (int i = 0; i < result[0].length; ++i) {
            if (result[0][i] < 0) {
                Matriz.multiPlication(i, v);
            }
        }
        result = Matriz.multiplicationMatriz(s, v);*/
        int n = v.length, m = v[0].length;
        for (int j = 0; j < m; ++j) {
            System.out.println(Matriz.scalarProduct(new MyPoint3D(v[0][j], v[1][j], v[2][j]), new MyPoint3D(e[0][0], e[0][1], e[0][2])));
        }


        Matriz.print(v);

    }

}
