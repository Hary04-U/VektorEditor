package cz.uhk.veditor.gui;

import cz.uhk.veditor.grobjekt.*;
import cz.uhk.veditor.grobjekt.Rectangle;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

public class MainWindow extends JFrame {
    private List<AbstractGeomObject> objekty = new ArrayList();
    private GraphPanel panel;

    public MainWindow() {
        super("Vektorový editor");
        this.setDefaultCloseOperation(3);
        panel = new GraphPanel(objekty);
        add(panel, BorderLayout.CENTER);
        this.initTestData();
        this.setSize(800, 600);
        this.setLocationRelativeTo((Component)null);
    }

    private void initTestData() {
        this.objekty.add(new Circle(new Point(100, 100), 50, Color.BLUE));
        this.objekty.add(new Square(new Point(200, 200), 40, Color.BLACK));
        this.objekty.add(new Circle(new Point(300, 300), 10, Color.YELLOW));
        this.objekty.add(new Square(new Point(150, 200), 20, Color.GREEN));
        this.objekty.add(new Circle(new Point(350, 250), 60, Color.PINK));
        this.objekty.add(new Square(new Point(400, 450), 35, Color.MAGENTA));
        this.objekty.add(new Rectangle(new Point(120, 160), 40, 50, Color.BLUE));
        this.objekty.add(new Rectangle(new Point(220, 340), 60, 80, Color.CYAN));
        this.objekty.add(new Rectangle(new Point(400, 160), 10, 20, Color.ORANGE));
        this.objekty.add(new Triangle(new Point(100, 250), 10, Color.DARK_GRAY));
        this.objekty.add(new Triangle(new Point(300, 160), 20, Color.PINK));
        this.objekty.add(new Triangle(new Point(260, 500), 30, Color.GRAY));
    }
}
