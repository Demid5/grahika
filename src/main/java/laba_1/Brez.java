package laba_1;

/**
 * все элементарные преобразования
 * (перемещения, вращения и масштабирование) реализовать в виде кнопок
 */

import javax.swing.*;
import java.awt.*;

public class Brez extends JPanel {
    public void paintComponent(Graphics g){
        super.paintComponents(g);
        g.setColor(Color.BLACK);
        Dr_Circle(150, 170, 110, g); //координаты центра и радиус
    }

    private void Dr_Circle(int center_x, int center_y, int radius, Graphics g){
        int x = 0, y = radius, sigma = 0, delta = 2 - 2 * radius;
        while (y >= 0){
            //считаем для одной четверти, и симметрично заполняем остальные
            g.drawLine(center_x + x, center_y - y, center_x + x, center_y - y);     // 1 четверть
            g.drawLine(center_x - x, center_y - y, center_x - x, center_y - y);     // 2 четверть
            g.drawLine(center_x - x, center_y + y, center_x - x, center_y + y);     // 3 четверть
            g.drawLine(center_x + x, center_y + y, center_x + x, center_y + y);     // 4 четверть
            sigma = 2 * (delta + y) - 1;
            if (delta < 0 && sigma <= 0) {          //перемещение по горизонтали
                x++;
                delta += x + 1;
            } else if (delta > 0 && sigma > 0) {    //перемещение по вертикали
                y--;
                delta -= y + 1;
            } else {                                //перемещение по диагонали
                x++;
                delta += x - y;
                y--;
            }
        }
    }
}