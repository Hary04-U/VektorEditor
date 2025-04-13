package cz.uhk.veditor.grobjekt;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;

public abstract class AbstractGeomObject {
    protected Point position;
    protected Color color;

    public AbstractGeomObject(Point position, Color color) {
        this.position = position;
        this.color = color;
    }

    public AbstractGeomObject() {
        this.position = new Point(0, 0);
        this.color = Color.BLACK;
    }

    public Point getPosition() {
        return this.position;
    }

    public void setPosition(Point position) {
        this.position = position;
    }

    public void setPosition(int x, int y) {
        this.position = new Point(x, y);
    }

    public Color getColor() {
        return this.color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public abstract boolean contains(int var1, int var2);

    public abstract void draw(Graphics2D var1);
}

