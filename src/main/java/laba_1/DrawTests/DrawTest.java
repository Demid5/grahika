package laba_1.DrawTests;

import laba_1.frames.DrawFrame;
import laba_1.frames.SizedFrame;

import javax.swing.*;
import java.awt.*;

public class DrawTest {
    public static void main(String[] args) {
        EventQueue.invokeLater(() ->
        {
            JFrame frame = new DrawFrame();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
            frame.setTitle("my first line");
        });
    }
}
