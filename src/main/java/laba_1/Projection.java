package laba_1;

public class Projection  {


    private static final double T[][] = {
        { 1, 0, 0, 0},
        {0, 1, 0, 0},
        {0.707106781, 0.707106781, 0, 0},
        {0, 0, 0, 1}
    };


    public static MyPoint2D obliqueProjection(MyPoint3D coordinate) {
        double newCoordinate[][] = Matriz.multiplicationMatriz(new double[][]{{coordinate.getX(), coordinate.getY(), coordinate.getZ(), 1}}, T);
        return new MyPoint2D(newCoordinate[0][0], newCoordinate[0][1]);
    }

}
