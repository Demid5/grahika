package laba_1.DrawTests;

import laba_1.frames.NotHelloWorldFrame;

import javax.swing.*;
import java.awt.*;

public class NotHelloWorld {
    public static void main(String[] args) {
        EventQueue.invokeLater(() ->
        {
            JFrame frame = new NotHelloWorldFrame();
            frame.setTitle("my application");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}
