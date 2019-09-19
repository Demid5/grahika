package laba_1.conversion;

import laba_1.Edge;
import laba_1.figures.Figure;

public class AnimationSecond {

    // произвольная прямая
    private Edge line;
    private double l, m, n;
    private double a, b, c;
    private double matriz[][];

    // задаем произвольную прямую
    public void setLine(Edge line) {
        this.line = line;
        a = line.getA().getX();
        b = line.getA().getY();
        c = line.getA().getZ();
        double root = Math.sqrt(a * a + b * b + c * c);
        l = a / root; m = b / root; n = c / root;
    }

    public Edge getLine() {
        return line;
    }


    public void execute(Figure cube) {
        /**
         * 1 -й шаг перенос на вектор матрицы A(-a, -b, -c)
         */

        Translation translation = new Translation();
        translation.setMatrizTraslation(-a, -b, -c);
        translation.setConversionPoints(cube);

        /**
         * 2-й шаг. Совмещение оси аппликатс прямой L двумя поворотами вокруг оси абсцисс и
         * оси ординат.
         */
        double d = Math.sqrt(m * m + n * n);
        Rotation rotationOX = new Rotation();
        rotationOX.setMatrizRotation(new double[][]{
                {1, 0, 0, 0},
                {0, n / d, m / d, 0},
                {0, -m / d, n / d, 0},
                {0, 0, 0, 1}
        });
        rotationOX.setConversionPoints(cube);
        rotationOX.setMatrizRotation(new double[][]{
                {1, 0, d, 0},
                {0, 1, 0, 0},
                {-d, 0, 1, 0},
                {0, 0, 0, 1}
        });
        rotationOX.setConversionPoints(cube);

        /**
         * 3-й шаг. Вращение вокруг прямой L на заданный уголφ.
         */
        Rotation rotation = new Rotation(Math.PI / 6);
        rotation.setExis("OZ");
        rotation.setMatrizRotation();
        rotation.setConversionPoints(cube);


        /**
         * 4-й шаг. Поворот вокруг оси ординат на угол -θ.
         */
        rotationOX.setMatrizRotation(new double[][]{
                {1, 0, -d, 0},
                {0, 1, 0, 0},
                {d, 0, 1, 0},
                {0, 0, 0, 1}
        });
        rotationOX.setConversionPoints(cube);

        /**
         * 5-й шаг. Поворот вокруг оси абсцисс на угол -ψ.
         */
        rotationOX.setMatrizRotation(new double[][]{
                {1, 0, 0, 0},
                {0, n / d, -m / d, 0},
                {0, m / d, n / d, 0},
                {0, 0, 0, 1}
        });

        /**
         * 6-й шаг. Перенос на вектор А (a, b, c)
         */
        translation.setMatrizTraslation(a, b, c);
        translation.setConversionPoints(cube);
    }




}
