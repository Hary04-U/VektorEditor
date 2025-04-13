package cz.uhk.veditor.grobjekt;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;

public class Rectangle extends AbstractGeomObject {
    protected int a;
    protected int b;

    public Rectangle(Point position, int a, int b, Color color) {
        super(position, color);
        this.a = a;
        this.b = b;
    }

    public Rectangle(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public boolean contains(int x, int y) {
        return x >= this.position.x - this.a / 2 && x <= this.position.x - this.a / 2 + this.a &&
                y >= this.position.y - this.b / 2 && y <= this.position.y - this.b / 2 + this.b;
    }

    public void draw(Graphics2D g) {
        g.setColor(this.color);
        g.drawRect(this.position.x - a / 2, this.position.y - b / 2, this.a, this.b);

    }
}

