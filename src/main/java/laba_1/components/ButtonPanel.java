package laba_1.components;

import javax.swing.*;
import java.awt.*;

public class ButtonPanel extends JPanel {

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        setBackground(Color.CYAN);
        setLocation(0, 0);
        setSize(20, 20);
        JButton buttonRotation = new JButton("Вращать по оси OZ");
        buttonRotation.setBounds(10, 100, 200, 30);
        add(buttonRotation);
    }
}
