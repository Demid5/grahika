package laba_1.figures;

import laba_1.Edge;
import laba_1.MyPoint3D;

public interface Figure {

    MyPoint3D[] getPoints();

    Edge[] getEdges();

    void setEdges(MyPoint3D[] pointss);

    double[][] getV();
    public void setVisible();


    double[] getPlane();
}
