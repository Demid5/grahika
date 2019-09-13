package laba_1.components;

import laba_1.MyPoint2D;
import laba_1.MyPoint3D;
import laba_1.Projection;
import laba_1.Rotation;

import javax.swing.*;
import java.awt.*;


/**
 * 1 sm = 25 px
 */


public class DrawPanel extends JPanel {

    private static int countt = 0;


    private static int S_HEIGHT, S_WIDTH;

    private int getX(int x) {
        return x * 25 + S_WIDTH / 4;
    }

    private int getY(int y) {
        return  (-y * 25) + S_HEIGHT / 4;
    }

    public DrawPanel() {
        // получить размеры экрана

        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        S_HEIGHT = screenSize.height;
        S_WIDTH = screenSize.width;

    }

    private void projectionCube(Graphics2D graphics2D,
                          MyPoint3D A, MyPoint3D B, MyPoint3D C, MyPoint3D D,
                          MyPoint3D E, MyPoint3D F, MyPoint3D G, MyPoint3D K) {
        MyPoint2D a = Projection.obliqueProjection(A);
        MyPoint2D b = Projection.obliqueProjection(B);
        MyPoint2D c = Projection.obliqueProjection(C);
        MyPoint2D d = Projection.obliqueProjection(D);
        MyPoint2D e = Projection.obliqueProjection(E);
        MyPoint2D f = Projection.obliqueProjection(F);
        MyPoint2D gg = Projection.obliqueProjection(G);
        MyPoint2D k = Projection.obliqueProjection(K);

        graphics2D.drawLine(getX(a.getX()), getY(a.getY()), getX(b.getX()), getY(b.getY()));
        graphics2D.drawLine(getX(a.getX()), getY(a.getY()), getX(c.getX()), getY(c.getY()));
        graphics2D.drawLine(getX(d.getX()), getY(d.getY()), getX(c.getX()), getY(c.getY()));
        graphics2D.drawLine(getX(d.getX()), getY(d.getY()), getX(b.getX()), getY(b.getY()));


        graphics2D.drawLine(getX(e.getX()), getY(e.getY()), getX(f.getX()), getY(f.getY()));
        graphics2D.drawLine(getX(e.getX()), getY(e.getY()), getX(gg.getX()), getY(gg.getY()));
        graphics2D.drawLine(getX(k.getX()), getY(k.getY()), getX(gg.getX()), getY(gg.getY()));
        graphics2D.drawLine(getX(k.getX()), getY(k.getY()), getX(f.getX()), getY(f.getY()));


        graphics2D.drawLine(getX(a.getX()), getY(a.getY()), getX(e.getX()), getY(e.getY()));
        graphics2D.drawLine(getX(b.getX()), getY(b.getY()), getX(f.getX()), getY(f.getY()));
        graphics2D.drawLine(getX(c.getX()), getY(c.getY()), getX(gg.getX()), getY(gg.getY()));
        graphics2D.drawLine(getX(d.getX()), getY(d.getY()), getX(k.getX()), getY(k.getY()));
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D graphics2D = (Graphics2D)g;

       /* MyPoint3D A = new MyPoint3D(3, 0, 0);
        MyPoint3D B = new MyPoint3D(5, 2, 0);
        MyPoint3D C = new MyPoint3D(-1, 3, 0);
        MyPoint3D D = new MyPoint3D(1, -1, 6);

        A = Projection.obliqueProjection(A);
        B = Projection.obliqueProjection(B);
        C = Projection.obliqueProjection(C);
        D = Projection.obliqueProjection(D);*/

        // рисуем тетраэдр

   /*     graphics2D.drawLine(getX(A.getX()), getY(A.getY()), getX(B.getX()), getY(B.getY()));
        graphics2D.drawLine(getX(A.getX()), getY(A.getY()), getX(C.getX()), getY(C.getY()));
        graphics2D.drawLine(getX(B.getX()), getY(B.getY()), getX(C.getX()), getY(C.getY()));

        graphics2D.drawLine(getX(D.getX()), getY(D.getY()), getX(A.getX()), getY(A.getY()));
        graphics2D.drawLine(getX(D.getX()), getY(D.getY()), getX(B.getX()), getY(B.getY()));
        graphics2D.drawLine(getX(D.getX()), getY(D.getY()), getX(C.getX()), getY(C.getY()));*/
        
        // нарисуем координатные оси
/*
        MyPoint2D O = new MyPoint2D(0, 0);
        MyPoint2D OX = new MyPoint2D(20, 0);
        MyPoint2D OY = new MyPoint2D(0, 20);
        graphics2D.drawLine(getX(O.getX()), getY(O.getY()), getX(OX.getX()), getY(OX.getY()));
        graphics2D.drawLine(getX(O.getX()), getY(O.getY()), getX(OY.getX()), getY(OY.getY()));

        //*/


        MyPoint3D A = new MyPoint3D(0, 0, 0);
        MyPoint3D B = new MyPoint3D(3, 0, 0);
        MyPoint3D C = new MyPoint3D(0, 3, 0);
        MyPoint3D D = new MyPoint3D(3, 3, 0);
        MyPoint3D E = new MyPoint3D(0, 0, 3);
        MyPoint3D F = new MyPoint3D(3, 0, 3);
        MyPoint3D G = new MyPoint3D(0, 3, 3);
        MyPoint3D K = new MyPoint3D(3, 3, 3);


        if (countt == 1) {
            projectionCube(graphics2D, A, B, C, D, E, F, G, K);
        }

        if (countt == 2) {
            graphics2D.drawLine(200, 200, 300, 300);
        }



        JButton buttonRotation = new JButton("Вращать по оси OZ");
        buttonRotation.setBounds(10, 100, 200, 30);
        add(buttonRotation);
        buttonRotation.addActionListener(event-> {
            Rotation.initMatriz(Math.PI / 6);
            countt++;
            repaint();
        });

    }
}
