package laba_1.components;

import laba_1.*;

import javax.swing.*;
import java.awt.*;


public class DrawPanel extends JPanel {

    private static Cube cube;
    private static Rotation rotation;
    private static Dilatation dilatation;

    private static int S_HEIGHT, S_WIDTH;

    private int getX(double x) {
        return (int)(x + S_WIDTH / 4);
    }

    private int getY(double y) {
        return  (int)((-y + S_HEIGHT / 4));
    }

    public DrawPanel() {
        cube = new Cube();
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        S_HEIGHT = screenSize.height;
        S_WIDTH = screenSize.width;
        rotation = new Rotation(Math.PI / 6);
        dilatation = new Dilatation();
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


        projectionCube(graphics2D, cube.getA(), cube.getB(), cube.getC(), cube.getD(), cube.getE(),
                cube.getF(), cube.getG(), cube.getK());


        // кнопка выбора оси координат , вокруг которой будем крутить

        JComboBox<String> selectExis = new JComboBox<>();
        selectExis.addItem("OX");
        selectExis.addItem("OY");
        selectExis.addItem("OZ");
        selectExis.setBounds(10, 50, 100, 30);
        add(selectExis);



        JButton buttonRotation = new JButton("Вращать по оси OZ");
        buttonRotation.setBounds(10, 100, 200, 30);
        add(buttonRotation);
        buttonRotation.addActionListener(event-> {
            rotation.setExis((String) selectExis.getSelectedItem());
            rotation.setConversionPoints(cube);
            repaint();
        });


        // кнопка выбора растяжения или сжатия изображения

        JComboBox<String> selectDilitation = new JComboBox<>();
        selectDilitation.addItem("Растяжение");
        selectDilitation.addItem("Сжатие");
        selectDilitation.setBounds(10, 150, 100, 30);
        add(selectDilitation);


        JButton buttonDilitation = new JButton("Масштабировать");
        buttonDilitation.setBounds(10, 250, 200, 30);
        add(buttonDilitation);
        buttonDilitation.addActionListener(event-> {
            dilatation.setMatrizDilatation((String)selectDilitation.getSelectedItem());
            dilatation.setConversionPoints(cube);
            repaint();
        });




    }
}
