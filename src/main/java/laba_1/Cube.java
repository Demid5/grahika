package laba_1;


public class Cube {

    private MyPoint3D A, B, C, D;
    private MyPoint3D E, F, G, K;
    private MyPoint3D points[];

    public Cube() {
         A = new MyPoint3D(25, 25, 25);
         B = new MyPoint3D(100, 25, 25);
         C = new MyPoint3D(25, 100, 25);
         D = new MyPoint3D(100, 100, 25);
         E = new MyPoint3D(25, 25, 100);
         F = new MyPoint3D(100, 25, 100);
         G = new MyPoint3D(25, 100, 100);
         K = new MyPoint3D(100, 100, 100);
         points = new MyPoint3D[]{A, B, C, D, E, F, G, K};
    }

    public MyPoint3D[] getPoints() {
        return points;
    }

    public void updatePoints() {
        A = points[0];
        B = points[1];
        C = points[2];
        D = points[3];
        E = points[4];
        F = points[5];
        G = points[6];
        K = points[7];
    }

    public void setPoints(MyPoint3D[] points) {
        this.points = points;
    }

    public void setA(MyPoint3D a) {
        A = a;
    }

    public void setB(MyPoint3D b) {
        B = b;
    }

    public void setC(MyPoint3D c) {
        C = c;
    }

    public void setD(MyPoint3D d) {
        D = d;
    }

    public void setE(MyPoint3D e) {
        E = e;
    }

    public void setF(MyPoint3D f) {
        F = f;
    }

    public void setG(MyPoint3D g) {
        G = g;
    }

    public void setK(MyPoint3D k) {
        K = k;
    }

    public MyPoint3D getA() {
        return A;
    }

    public MyPoint3D getB() {
        return B;
    }

    public MyPoint3D getC() {
        return C;
    }

    public MyPoint3D getD() {
        return D;
    }

    public MyPoint3D getE() {
        return E;
    }

    public MyPoint3D getF() {
        return F;
    }

    public MyPoint3D getG() {
        return G;
    }

    public MyPoint3D getK() {
        return K;
    }

}
