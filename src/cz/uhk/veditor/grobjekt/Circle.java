package cz.uhk.veditor.grobjekt;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;

public class Circle extends AbstractGeomObject {
    protected int radius;

    public Circle(Point position, int radius, Color color) {
        super(position, color);
        this.radius = radius;
    }

    public Circle(int radius) {
        this.radius = radius;
    }

    public boolean contains(int x, int y) {
        int m = this.position.x;
        int n = this.position.y;
        int l = (x - m) * (x - m) + (y - n) * (y - n);
        int r = this.radius * this.radius;
        return l <= r;
    }

    public void draw(Graphics2D g) {
        g.setColor(this.color);
        g.drawOval(this.position.x - radius, this.position.y - radius, 2 * this.radius, 2 * this.radius);
    }
}

