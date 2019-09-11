package laba_1.components;

import javax.swing.*;
import java.awt.*;

public class NotHelloWorldComponent extends JComponent {
    public static final int MESSAGE_X = 75;
    public static final int MESSAGE_Y = 100;

    private static final int DEFALUT_WIDTH = 300;
    private static final int DEFAULT_HEIGHT = 200;

    public void paintComponent(Graphics g) {
        g.drawString("Hello demid5", MESSAGE_X, MESSAGE_Y);
    }

    public Dimension getPreferresSize() {
        return new Dimension(DEFALUT_WIDTH, DEFAULT_HEIGHT);
    }
}
