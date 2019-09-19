package laba_1.conversion;

import laba_1.Edge;
import static java.lang.Math.cos;
import static java.lang.Math.sin;
import laba_1.conversion.Rotation;
import laba_1.conversion.Translation;
import laba_1.figures.Figure;

import java.lang.reflect.Field;

public class Animation implements Conversion{
    // произвольная прямая
    private Edge line;
    private double l, m, n;
    private double a, b, c;
    private double matrizAnimation[][];

    // задаем произвольную прямую
    public void setLine(Edge line) {
        this.line = line;
        a = line.getA().getX();
        b = line.getA().getY();
        c = line.getA().getZ();
        double f = Math.PI / 6;
        double root = Math.sqrt(a * a + b * b + c * c);
        l = a / root; m = b / root; n = c / root;
        matrizAnimation = new double[][] {
                {l * l + cos(f) * (1 - l * l), l * (1 - cos(f)) * m + n * sin(f), l * (1 - cos(f)) * n - m * sin(f), 0},
                {l * (1 - cos(f)) * m - n * sin(f), m * m + cos(f) * (1 - m * m), m * (1 - cos(f)) * n + l * sin(f), 0 },
                {l * (1 - cos(f)) * n + m * sin(f), m * (1 - cos(f)) * n - l * sin(f), n * n + cos(f) * (1 - n * n), 0},
                {0, 0, 0, 1}
        };
    }



    @Override
    public double[][] getMatriz() {
        return matrizAnimation;
    }
}
