package laba_1;

public class Edge {
    private MyPoint3D a, b;

    public Edge() { }

    public Edge(MyPoint3D a, MyPoint3D b) {
        this.a = a;
        this.b = b;
    }

    public void setA(MyPoint3D a) {
        this.a = a;
    }

    public MyPoint3D getA() {
        return a;
    }

    public void setB(MyPoint3D b) {
        this.b = b;
    }

    public MyPoint3D getB() {
        return b;
    }
}
