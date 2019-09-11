package laba_1.frames;

import javax.swing.*;
import java.awt.*;

public class SizedFrame extends JFrame {
    public SizedFrame() {
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
