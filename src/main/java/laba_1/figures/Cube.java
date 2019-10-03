package laba_1.figures;


import laba_1.Edge;
import laba_1.Matriz;
import laba_1.MyPoint3D;

import static laba_1.Matriz.abcd;

public class Cube implements Figure{
    private MyPoint3D points[];
    private Edge edges[];

    public Cube() {
        points = new MyPoint3D[8];
        points[0] = new MyPoint3D(25, 25, 25);
        points[1] = new MyPoint3D(100, 25, 25);
        points[2] = new MyPoint3D(25, 100, 25); //
        points[3] = new MyPoint3D(100, 100, 25);
        points[4] = new MyPoint3D(25, 25, 100);
        points[5] = new MyPoint3D(100, 25, 100);
        points[6] = new MyPoint3D(25, 100, 100); //
        points[7] = new MyPoint3D(100, 100, 100);
        edges = new Edge[12];
    }



    public MyPoint3D[] getPoints() {
        return points;
    }

    @Override
    public Edge[] getEdges() {
        return edges;
    }


    @Override
    public void setEdges(MyPoint3D[] pointss) {
        edges[0] = new Edge(pointss[0], pointss[1]);
        edges[1] = new Edge(pointss[0], pointss[2]);
        edges[2] = new Edge(pointss[3], pointss[2]);
        edges[3] = new Edge(pointss[3], pointss[1]);

        edges[4] = new Edge(pointss[4], pointss[5]);
        edges[5] = new Edge(pointss[4], pointss[6]);
        edges[6] = new Edge(pointss[7], pointss[6]);
        edges[7] = new Edge(pointss[7], pointss[5]);

        edges[8] = new Edge(pointss[0], pointss[4]);
        edges[9] = new Edge(pointss[1], pointss[5]);
        edges[10] = new Edge(pointss[2], pointss[6]);
        edges[11] = new Edge(pointss[3], pointss[7]);
    }

    @Override
    public void setVisible() {
        double e[][] = new double[][]{{400, 700, -1000}};
        double v[][] = getV();
        int n = v.length, m = v[0].length;
        double visGran[] = new double[m];
        for (int j = 0; j < m; ++j) {
            visGran[j] = Matriz.scalarProduct(new MyPoint3D(v[0][j], v[1][j], v[2][j]), new MyPoint3D(e[0][0], e[0][1], e[0][2]));
        }
        if (visGran[0] > 0 && visGran[1] > 0) {
            edges[0].setVisible(false);
        }
        else {
            edges[0].setVisible(true);
        }

        if (visGran[0] > 0 && visGran[2] > 0) {
            edges[1].setVisible(false);
        }
        else {
            edges[1].setVisible(true);
        }

        if (visGran[0] > 0 && visGran[4] > 0) {
            edges[2].setVisible(false);
        }
        else {
            edges[2].setVisible(true);
        }

        if (visGran[0] > 0 && visGran[5] > 0) {
            edges[3].setVisible(false);
        }
        else {
            edges[3].setVisible(true);
        }

        if (visGran[1] > 0 && visGran[3] > 0) {
            edges[4].setVisible(false);
        }
        else {
            edges[4].setVisible(true);
        }

        if (visGran[3] > 0 && visGran[2] > 0) {
            edges[5].setVisible(false);
        }
        else {
            edges[5].setVisible(true);
        }

        if (visGran[3] > 0 && visGran[4] > 0) {
            edges[6].setVisible(false);
        }
        else {
            edges[6].setVisible(true);
        }

        if (visGran[3] > 0 && visGran[5] > 0) {
            edges[7].setVisible(false);
        }
        else {
            edges[7].setVisible(true);
        }

        if (visGran[1] > 0 && visGran[2] > 0) {
            edges[8].setVisible(false);
        }
        else {
            edges[8].setVisible(true);
        }

        if (visGran[1] > 0 && visGran[5] > 0) {
            edges[9].setVisible(false);
        }
        else {
            edges[9].setVisible(true);
        }

        if (visGran[2] > 0 && visGran[4] > 0) {
            edges[10].setVisible(false);
        }
        else {
            edges[10].setVisible(true);
        }

        if (visGran[4] > 0 && visGran[5] > 0) {
            edges[11].setVisible(false);
        }
        else {
            edges[11].setVisible(true);
        }
    }

    public void setPoints(MyPoint3D[] points) {
        this.points = points;
    }

    @Override
    public double[][] getV() {
        MyPoint3D myPoint3D[] = this.getPoints();
        double v[][] = new double[6][3];
        double V[][] = new double[3][6];


        //z = 25-- //передняя
        v[0] = abcd(myPoint3D[0], myPoint3D[1], myPoint3D[2]);

        // y = 25 // нижняя
        v[1] = abcd(myPoint3D[0], myPoint3D[4], myPoint3D[1]);

        // x = 25 // левая
        v[2] = abcd(myPoint3D[0], myPoint3D[2], myPoint3D[4]);

        // z = 100 // задняя
        v[3] = abcd(myPoint3D[4], myPoint3D[6], myPoint3D[5]);

        // y = 100 // верхняя
        v[4] = abcd(myPoint3D[2], myPoint3D[3], myPoint3D[6]);

        // x = 100 // правая
        v[5] = abcd(myPoint3D[1], myPoint3D[5], myPoint3D[3]);


        for (int i = 0; i < 6; ++i) {
            for (int j = 0; j < 3; ++j) {
                V[j][i] = v[i][j];
            }
        }
        return V;
    }


}
