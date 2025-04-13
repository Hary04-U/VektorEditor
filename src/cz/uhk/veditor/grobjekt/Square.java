package cz.uhk.veditor.grobjekt;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;

public class Square extends AbstractGeomObject {
    protected int a;

    public Square(Point position, int a, Color color) {
        super(position, color);
        this.a = a;
    }

    public Square(int a) {
        this.a = a;
    }

    public boolean contains(int x, int y) {
        return x >= this.position.x && x <= this.position.x + this.a && y >= this.position.y && y <= this.position.y + this.a;
    }

    public void draw(Graphics2D g) {
        g.setColor(this.color);
        g.drawRect(this.position.x - a / 2, this.position.y - a / 2, this.a, this.a);
    }
}
