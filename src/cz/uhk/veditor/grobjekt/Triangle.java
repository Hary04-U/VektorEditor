package cz.uhk.veditor.grobjekt;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;

public class Triangle extends AbstractGeomObject {
    protected int a;

    public Triangle(Point position, int a, Color color) {
        super(position, color);
        this.a = a;
    }

    public Triangle(int a) {
        this.a = a;
    }

    @Override
    public boolean contains(int x, int y) {
        Point p1 = new Point(this.position.x, this.position.y - (int)(Math.sqrt(3) / 3 * this.a));
        Point p2 = new Point(this.position.x - this.a / 2, this.position.y + (int)(Math.sqrt(3) / 6 * this.a));
        Point p3 = new Point(this.position.x + this.a / 2, this.position.y + (int)(Math.sqrt(3) / 6 * this.a));

        double area = Math.abs((p1.x * (p2.y - p3.y) + p2.x * (p3.y - p1.y) + p3.x * (p1.y - p2.y)) / 2.0);

        double area1 = Math.abs((x * (p2.y - p3.y) + p2.x * (p3.y - y) + p3.x * (y - p2.y)) / 2.0);
        double area2 = Math.abs((p1.x * (y - p3.y) + x * (p3.y - p1.y) + p3.x * (p1.y - y)) / 2.0);
        double area3 = Math.abs((p1.x * (p2.y - y) + p2.x * (y - p1.y) + x * (p1.y - p2.y)) / 2.0);

        return (area == area1 + area2 + area3);
    }

    @Override
    public void draw(Graphics2D g) {
        g.setColor(this.color);

        Point p1 = new Point(this.position.x, this.position.y - (int)(Math.sqrt(3) / 3 * this.a));
        Point p2 = new Point(this.position.x - this.a / 2, this.position.y + (int)(Math.sqrt(3) / 6 * this.a));
        Point p3 = new Point(this.position.x + this.a / 2, this.position.y + (int)(Math.sqrt(3) / 6 * this.a));

        int[] xPoints = {p1.x, p2.x, p3.x};
        int[] yPoints = {p1.y, p2.y, p3.y};
        g.drawPolygon(xPoints, yPoints, 3);
    }
}
