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
    private JToggleButton btCircle;
    private JToggleButton btSquare;
    private JToggleButton btRectangle;
    private JToggleButton btTriangle;
    private JToggleButton btSelect;

    public MainWindow() {
        super("Vektorový editor");
        this.setDefaultCloseOperation(3);
        panel = new GraphPanel(objekty, this);
        add(panel, BorderLayout.CENTER);
        createToolBar();
        this.initTestData();
        this.setSize(800, 600);
        this.setLocationRelativeTo((Component)null);
        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON1) {
                    if (btCircle.isSelected()) {
                        objekty.add(new Circle(new Point(e.getX(), e.getY()), 50, Color.RED));
                    } else if (btSquare.isSelected()) {
                        objekty.add(new Square(new Point(e.getX(), e.getY()), 40, Color.RED));
                    } else if (btRectangle.isSelected()) {
                        objekty.add(new Rectangle(new Point(e.getX(), e.getY()), 40, 60, Color.RED));
                    } else if (btTriangle.isSelected()) {
                        objekty.add(new Triangle(new Point(e.getX(), e.getY()), 40, Color.RED));
                    }

                    panel.repaint();
                }
            }
        });
    }

    private void createToolBar() {
        JToolBar toolBar = new JToolBar(JToolBar.HORIZONTAL);
        add(toolBar, BorderLayout.NORTH);

        ButtonGroup buttonGroup = new ButtonGroup();

        btCircle = new JToggleButton("Kruh");
        buttonGroup.add(btCircle);
        toolBar.add(btCircle);

        btSquare = new JToggleButton("Čtverec");
        buttonGroup.add(btSquare);
        toolBar.add(btSquare);

        btRectangle = new JToggleButton("Obdelník");
        buttonGroup.add(btRectangle);
        toolBar.add(btRectangle);

        btTriangle = new JToggleButton("Trojúhelník");
        buttonGroup.add(btTriangle);
        toolBar.add(btTriangle);

        btSelect = new JToggleButton("->");
        buttonGroup.add(btSelect);
        toolBar.add(btSelect);
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

    public boolean isSelectMode() {
        return btSelect.isSelected();
    }
}
