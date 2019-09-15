package laba_1.figures;


import laba_1.Edge;
import laba_1.MyPoint3D;

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

    public void setPoints(MyPoint3D[] points) {
        this.points = points;
    }


}
