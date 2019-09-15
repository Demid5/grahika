package laba_1.components;

import laba_1.Edge;
import laba_1.Projection;
import laba_1.conversion.Dilatation;
import laba_1.conversion.Rotation;
import laba_1.conversion.Translation;
import laba_1.figures.Cube;
import laba_1.figures.Figure;

import javax.swing.*;
import java.awt.*;


public class DrawPanel extends JPanel {

    private static Figure cube;
    private static Rotation rotation;
    private static Dilatation dilatation;
    private static Translation translation;
    private static Projection projection;

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
        translation = new Translation();
        projection = new Projection();
    }

    private void projectionFigure(Graphics2D graphics2D, Figure figure) {
        projection.setConversionPoints(figure);
        for (Edge edge: figure.getEdges()) {
            graphics2D.drawLine(getX(edge.getA().getX()), getY(edge.getA().getY()), getX(edge.getB().getX()),getY(edge.getB().getY()));
        }
    }


    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D graphics2D = (Graphics2D)g;


        projectionFigure(graphics2D, cube);


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
        buttonDilitation.setBounds(10, 200, 200, 30);
        add(buttonDilitation);
        buttonDilitation.addActionListener(event-> {
            dilatation.setMatrizDilatation((String)selectDilitation.getSelectedItem());
            dilatation.setConversionPoints(cube);
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
            translation.setConversionPoints(cube);
            repaint();
        });

    }
}
