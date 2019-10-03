package laba_1.figures;

import laba_1.Edge;
import laba_1.MyPoint3D;

public class BykvaP implements Figure {

    private MyPoint3D points[];
    private Edge edges[];

    public BykvaP() {
        points = new MyPoint3D[20];
        points[0] = new MyPoint3D(0, 0, 0);
        points[1] = new MyPoint3D(0, 0, 20);
        points[2] = new MyPoint3D(20, 0, 20); //
        points[3] = new MyPoint3D(20, 0, 0);

        points[4] = new MyPoint3D(70, 0, 0);
        points[5] = new MyPoint3D(70, 0, 20);
        points[6] = new MyPoint3D(90, 0, 20); //
        points[7] = new MyPoint3D(90, 0, 0);

        points[8] = new MyPoint3D(0, 100, 0);
        points[9] = new MyPoint3D(0, 100, 20);
        points[10] = new MyPoint3D(20, 100, 20); //
        points[11] = new MyPoint3D(20, 100, 0);

        points[12] = new MyPoint3D(70, 100, 0);
        points[13] = new MyPoint3D(70, 100, 20);
        points[14] = new MyPoint3D(90, 100, 20); //
        points[15] = new MyPoint3D(90, 100, 0);



        points[16] = new MyPoint3D(0, 80, 0);
        points[17] = new MyPoint3D(0, 80, 20);

        points[18] = new MyPoint3D(90, 80, 20); //
        points[19] = new MyPoint3D(90, 80, 0);

        edges = new Edge[24];
    }


    @Override
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
        edges[1] = new Edge(pointss[1], pointss[2]);
        edges[2] = new Edge(pointss[2], pointss[3]);
        edges[3] = new Edge(pointss[3], pointss[0]);

        edges[4] = new Edge(pointss[4], pointss[5]);
        edges[5] = new Edge(pointss[5], pointss[6]);
        edges[6] = new Edge(pointss[6], pointss[7]);
        edges[7] = new Edge(pointss[7], pointss[4]);

        edges[8] = new Edge(pointss[0], pointss[8]);
        edges[9] = new Edge(pointss[1], pointss[9]);
        edges[10] = new Edge(pointss[2], pointss[10]);
        edges[11] = new Edge(pointss[3], pointss[11]);

        edges[12] = new Edge(pointss[4], pointss[12]);
        edges[13] = new Edge(pointss[5], pointss[13]);
        edges[14] = new Edge(pointss[6], pointss[14]);
        edges[15] = new Edge(pointss[7], pointss[15]);


        edges[16] = new Edge(pointss[9], pointss[14]);
        edges[17] = new Edge(pointss[8], pointss[15]);
        edges[18] = new Edge(pointss[17], pointss[18]);
        edges[19] = new Edge(pointss[16], pointss[19]);

        edges[20] = new Edge(pointss[8], pointss[9]);
        edges[21] = new Edge(pointss[14], pointss[15]);


        edges[22] = new Edge(pointss[16], pointss[17]);
        edges[23] = new Edge(pointss[19], pointss[18]);    }

    @Override
    public double[][] getV() {
        return new double[0][];
    }

    @Override
    public void setVisible() {

    }

    @Override
    public double[] getPlane() {
        return new double[0];
    }

}
