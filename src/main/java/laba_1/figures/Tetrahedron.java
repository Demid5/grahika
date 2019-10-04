package laba_1.figures;

import laba_1.Edge;
import laba_1.Matriz;
import laba_1.MyPoint3D;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static laba_1.Matriz.abcd;

public class Tetrahedron implements Figure {
    private class myPair {
        Set<Edge> first;
        double second;

        public myPair() { }

        public myPair(double second) {
            this.second = second;
        }

        public myPair(Set<Edge> first) {
            this.first = first;
        }
    }

    private MyPoint3D points[];
    private Edge edges[];
    private myPair plane[];

    public Tetrahedron() {
        points = new MyPoint3D[5];
        points[0] = new MyPoint3D(100, 0, 0);
        points[1] = new MyPoint3D(25, 0, 50);
        points[2] = new MyPoint3D(0, 0, 0);
        points[3] = new MyPoint3D(50, 100, 25);
        points[4] = new MyPoint3D(50, 10, 10);

        edges = new Edge[6];
        for (int i = 0; i < 6; ++i) {
            edges[i] = new Edge();
        }

        plane = new myPair[4];
        for (int i = 0; i < plane.length; ++i) {
            plane[i] = new myPair(new HashSet<>());
        }
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


    @Override
    public double[][] getV() {
        MyPoint3D myPoint3D[] = this.getPoints();
        double v[][] = new double[4][3];
        double V[][] = new double[3][4];

        v[0] = abcd(myPoint3D[0], myPoint3D[2], myPoint3D[1]);

        v[1] = abcd(myPoint3D[0], myPoint3D[1], myPoint3D[3]);

        v[2] = abcd(myPoint3D[1], myPoint3D[2], myPoint3D[3]);

        v[3] = abcd(myPoint3D[0], myPoint3D[3], myPoint3D[2]);

        for (int i = 0; i < 4; ++i) {
            for (int j = 0; j < 3; ++j) {
                V[j][i] = v[i][j];
            }
        }

        return V;
    }

    public void setVisible() {
        for (int i = 0; i < plane.length; ++i) {
            plane[i].first.clear();
        }
        plane[0].first.addAll(Arrays.asList(edges[0], edges[1], edges[3]));
        plane[1].first.addAll(Arrays.asList(edges[0], edges[2], edges[4]));
        plane[2].first.addAll(Arrays.asList(edges[3], edges[4], edges[5]));
        plane[3].first.addAll(Arrays.asList(edges[1], edges[2], edges[5]));

        double e[][] = new double[][]{{1, 1, -1}};
        double v[][] = getV();
        double s[][] = new double[][]{{points[4].getX(), points[4].getY(), points[4].getZ()}};

        for (int j = 0; j < plane.length; ++j) {
            plane[j].second = Matriz.scalarProduct(new MyPoint3D(v[0][j], v[1][j], v[2][j]), new MyPoint3D(e[0][0], e[0][1], e[0][2]));
        }

        for (Edge edge: edges) {
            int count = 0;
            for (myPair elem: plane) {
                if (elem.first.contains(edge) && elem.second < 0) {
                    count++;
                }
            }
            if (count > 0) {
                edge.setVisible(true);
            }
            else {
                edge.setVisible(false);
            }
        }


    }

    public double[] getPlane() {
        double mas[] = new double[plane.length];
        for (int i = 0; i < plane.length; ++i) {
            mas[i] = plane[i].second;
        }
        return mas;
    }
}
