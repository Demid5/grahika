package laba_1.components;

import javax.swing.*;
import java.awt.*;

/**
 * 1 sm = 25 px
 */


public class DrawComponent extends JComponent {

    private static int S_HEIGHT, S_WIDTH;

    private int getX(int x) {
        return x * 25 + S_WIDTH / 4;
    }

    private int getY(int y) {
        return  (-y * 25) + S_HEIGHT / 4;
    }

    public DrawComponent() {
        // получить размеры экрана

        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        S_HEIGHT = screenSize.height;
        S_WIDTH = screenSize.width;

    }

    public void paintComponent(Graphics g) {
        Graphics2D graphics2D = (Graphics2D)g;

        // нарисовать линию

        int A[] = {3, 0};
        int B[] = {5, 2};
        int C[] = {-1, 3};
        graphics2D.drawLine(getX(A[0]), getY(A[1]), getX(B[0]), getY(B[1]));
        graphics2D.drawLine(getX(A[0]), getY(A[1]), getX(C[0]), getY(C[1]));
        graphics2D.drawLine(getX(C[0]), getY(C[1]), getX(B[0]), getY(B[1]));
    }
}
