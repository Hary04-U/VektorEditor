package cz.uhk.veditor.gui;

import cz.uhk.veditor.grobjekt.AbstractGeomObject;
import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.List;
import javax.swing.JPanel;

public class GraphPanel extends JPanel {
    List<AbstractGeomObject> objektList;

    public GraphPanel(List<AbstractGeomObject> objektList) {
        this.objektList = objektList;
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
