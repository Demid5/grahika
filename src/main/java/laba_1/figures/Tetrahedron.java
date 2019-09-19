package laba_1.figures;

import laba_1.Edge;
import laba_1.MyPoint3D;

public class Tetrahedron implements Figure {

    private MyPoint3D points[];
    private Edge edges[];

    public Tetrahedron() {
        points = new MyPoint3D[4];
        points[0] = new MyPoint3D(100, 0, 0);
        points[1] = new MyPoint3D(25, 0, 50);
        points[2] = new MyPoint3D(0, 0, 0);
        points[3] = new MyPoint3D(50, 75, 25);
        edges = new Edge[6];
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
        edges[1] = new Edge(pointss[0], pointss[2]);
        edges[2] = new Edge(pointss[0], pointss[3]);
        edges[3] = new Edge(pointss[1], pointss[2]);
        edges[4] = new Edge(pointss[1], pointss[3]);
        edges[5] = new Edge(pointss[2], pointss[3]);
    }
}
