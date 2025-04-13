package cz.uhk.veditor.gui;

import cz.uhk.veditor.grobjekt.AbstractGeomObject;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.List;
import javax.swing.JPanel;

public class GraphPanel extends JPanel {
    private List<AbstractGeomObject> objektList;
    private MainWindow mainWindow;

    private AbstractGeomObject selectedObject = null;
    private Point lastMousePosition = null;

    public GraphPanel(List<AbstractGeomObject> objektList, MainWindow mainWindow) {
        this.objektList = objektList;
        this.mainWindow = mainWindow;

        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (mainWindow.isSelectMode()) {
                    for (int i = objektList.size() - 1; i >= 0; i--) {
                        AbstractGeomObject obj = objektList.get(i);
                        if (obj.contains(e.getX(), e.getY())) {
                            selectedObject = obj;
                            lastMousePosition = e.getPoint();
                            break;
                        }
                    }
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                selectedObject = null;
                lastMousePosition = null;
            }
        });

        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                if (mainWindow.isSelectMode() && selectedObject != null && lastMousePosition != null) {
                    int dx = e.getX() - lastMousePosition.x;
                    int dy = e.getY() - lastMousePosition.y;

                    Point pos = selectedObject.getPosition();
                    selectedObject.setPosition(new Point(pos.x + dx, pos.y + dy));

                    lastMousePosition = e.getPoint();
                    repaint();
                }
            }
        });
    }

    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2 = (Graphics2D)g;
        g2.setStroke(new BasicStroke(2.0F));
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        for(AbstractGeomObject obj : this.objektList) {
            obj.draw((Graphics2D)g);
        }

    }
}
