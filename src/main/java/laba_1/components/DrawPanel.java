package laba_1.components;

import laba_1.conversion.*;
import laba_1.Edge;
import laba_1.MyPoint3D;
import laba_1.Projection;
import laba_1.figures.*;

import javax.swing.*;
import java.awt.*;


public class DrawPanel extends JPanel {
    private int countRotation;
    boolean znak;
    private String localExis;
    private int countExis;
    private static Figure cube, tetrader, oz, bykvaP;
    private static Rotation rotation;
    private static Dilatation dilatation;
    private static Translation translation;
    private static Projection projection;
    private static Animation animation;
    private static AnimationSecond animationSecond;

    private static int S_HEIGHT, S_WIDTH;

    private int getX(double x) {
        return (int)(x + S_WIDTH / 4);
    }

    private int getY(double y) {
        return  (int)((-y + S_HEIGHT / 4));
    }

    public DrawPanel() {
        countRotation = 0;
        znak = false;
        localExis = "OP";
        countExis = 0;
        bykvaP = new BykvaP();
        oz = new OZ();
        cube = new Cube();
        tetrader = new Tetrahedron();
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        S_HEIGHT = screenSize.height;
        S_WIDTH = screenSize.width;
        rotation = new Rotation(Math.PI / 6);
        dilatation = new Dilatation();
        translation = new Translation();
        projection = new Projection();
        animation = new Animation();
        animationSecond = new AnimationSecond();
    }

    private void projectionFigure(Graphics2D graphics2D, Figure figure) {
        Edge lineOz = oz.getEdges()[0];
        projection.setConversionPoints(oz);
        graphics2D.setColor(Color.red);
        graphics2D.drawLine(getX(lineOz.getA().getX()), getY(lineOz.getA().getY()), getX(lineOz.getB().getX()),getY(lineOz.getB().getY()));


        graphics2D.setColor(Color.black);
        projection.setConversionPoints(figure);
        figure.setVisible();
        double scalarProduct[] = figure.getPlane();
if(znak) {

    if (countExis % 12 == 3 && localExis.equals("OX")) {
        figure.getEdges()[0].setVisible(false);
        scalarProduct[1] *= (-1);
    }
    if ((countExis % 12 == 9 || countExis % 12 == 7 || countExis % 12 == 8) && localExis.equals("OX")) {
        figure.getEdges()[1].setVisible(true);
        figure.getEdges()[5].setVisible(true);
        scalarProduct[3] *= (-1);
    }

    if (countExis % 12 == 1 && localExis.equals("OY")) {
        figure.getEdges()[1].setVisible(true);
        figure.getEdges()[5].setVisible(true);
        scalarProduct[3] *= (-1);
    }
}
else {
    if (countRotation % 12 == 11) {
        figure.getEdges()[0].setVisible(false);
        figure.getEdges()[3].setVisible(false);
        figure.getEdges()[4].setVisible(false);
        scalarProduct[1] *= (-1);
        scalarProduct[3] -= (-1);
    }
}
        int add = 200;
        int index = 1;

        for (double elem: scalarProduct) {
            graphics2D.drawString((index++) + " грань  = " + elem, 500, (add +=20));
        }
        for (Edge edge: figure.getEdges()) {
            if (edge.isVisible()) {
                graphics2D.setColor(Color.black);
            }
            else {
                graphics2D.setColor(Color.orange);
            }
            graphics2D.drawLine(getX(edge.getA().getX()), getY(edge.getA().getY()), getX(edge.getB().getX()),getY(edge.getB().getY()));
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Figure figure = tetrader;
        Graphics2D graphics2D = (Graphics2D)g;
        projectionFigure(graphics2D, figure);
        // добавим оси коордиант

        graphics2D.setColor(Color.red);
        graphics2D.drawLine(getX(0), getY(0), getX(0), getY(500));
        graphics2D.drawLine(getX(0), getY(0), getX(500), getY(0));
        // чеклист выбора оси координат , вокруг которой будем крутить

        JComboBox<String> selectExis = new JComboBox<>();
        selectExis.addItem("OX");
        selectExis.addItem("OY");
        selectExis.addItem("OZ");
        selectExis.setBounds(10, 50, 100, 30);
        add(selectExis);



        JButton buttonRotation = new JButton("Вращать");
        buttonRotation.setBounds(10, 100, 200, 30);
        add(buttonRotation);
        buttonRotation.addActionListener(event-> {
            znak = true;
            rotation.setExis((String) selectExis.getSelectedItem());
            if (localExis.equals(rotation.getExis())) {
                countExis++;
            }
            else {
                countExis = 0;
                localExis = rotation.getExis();
            }

            rotation.setMatrizRotation();
            rotation.setConversionPoints(figure);
            repaint();
        });


        // кнопка выбора растяжения или сжатия изображения

        JComboBox<String> selectDilitation = new JComboBox<>();
        selectDilitation.addItem("Растяжение");
        selectDilitation.addItem("Сжатие");
        selectDilitation.setBounds(10, 150, 100, 30);
        add(selectDilitation);


        JButton buttonDilitation = new JButton("Масштабировать");
        buttonDilitation.setBounds(10, 200, 200, 30);
        add(buttonDilitation);
        buttonDilitation.addActionListener(event-> {
            dilatation.setMatrizDilatation((String)selectDilitation.getSelectedItem());
            dilatation.setConversionPoints(figure);
            repaint();
        });


        JComboBox<String> selectTranslation = new JComboBox<>();
        selectTranslation.addItem("по оси OX");
        selectTranslation.addItem("по оси OY");
        selectTranslation.addItem("по оси OZ");
        selectTranslation.setBounds(10, 250, 100, 30);
        add(selectTranslation);

        JButton buttonTranslationOX = new JButton("Перенос");
        buttonTranslationOX.setBounds(10, 300, 200, 30);
        add(buttonTranslationOX);
        buttonTranslationOX.addActionListener(event-> {
            translation.setMatrizTraslation((String)selectTranslation.getSelectedItem());
            translation.setConversionPoints(figure);
            repaint();
        });

        Edge line = new Edge(new MyPoint3D(getX(240), getY(50), 200), new MyPoint3D(getX(300), getY(150), 250));
        graphics2D.setColor(Color.blue);
        graphics2D.drawLine(getX(240), getY(50), getX(300), getY(150));

        JButton buttonLab = new JButton("вращаем");
        buttonLab.setBounds(10, 20, 200, 30);
        add(buttonLab);
        buttonLab.addActionListener(event-> {
            znak = false;
            countRotation++;
             animation.setLine(line);
             animation.setConversionPoints(figure);
            repaint();
        });

    }
}
