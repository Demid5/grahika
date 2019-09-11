package laba_1.frames;

import laba_1.components.NotHelloWorldComponent;

import javax.swing.*;
import java.awt.*;

public class NotHelloWorldFrame extends JFrame {
    public NotHelloWorldFrame() {
        add(new NotHelloWorldComponent());
        // получить размеры экрана

        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int screenHeight = screenSize.height;
        int screenWidth = screenSize.width;

        // задать ширину и высоту фрейма предоставив платформе
        // возможность самой выбирать местополжение фрейма

        setSize(screenWidth / 2, screenHeight / 2);
        setLocationByPlatform(true);
    }
}
