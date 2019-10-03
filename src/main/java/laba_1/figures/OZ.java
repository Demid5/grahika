package laba_1.figures;

import laba_1.Edge;
import laba_1.MyPoint3D;

public class OZ implements Figure {
    private MyPoint3D points[];
    private Edge edges[];


    public OZ() {
        points = new MyPoint3D[2];
        points[0] = new MyPoint3D(0, 0, 0);
        points[1] = new MyPoint3D(500, 500, 0);
        edges = new Edge[1];
        edges[0] = new Edge(points[0], points[1]);
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
        edges[0] = new Edge(points[0], points[1]);
    }

    @Override
    public double[][] getV() {
        return new double[0][];
    }

    @Override
    public void setVisible() {

    }

}
