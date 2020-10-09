package g52816.ascii.model;

/**
 *
 * @author bilal
 */
public class Line extends ColoredShape {

    private Point p1;
    private Point p2;

    /**
     * Allow to create a Line
     *
     * @param p1 Point1
     * @param p2 Point2
     * @param color the color of this Line
     */
    public Line(Point p1, Point p2, char color) {
        super(color);
        this.p1 = p1;
        this.p2 = p2;
    }

    /**
     * move a line
     *
     * @param dx delta X
     * @param dy delta Y
     */
    @Override
    public void move(double dx, double dy) {
        p1.move(dx, dy);
        p2.move(dx, dy);
    }

    /**
     * check if a Point isInside the line
     *
     * @param p the point
     * @return true or false
     */
    @Override
    public boolean isInside(Point p) {
        return distance(p1, p) + distance(p, p2) == distance(p1, p2);
    }

    /**
     * Return the distance between 2 point
     *
     * @param p1 P1
     * @param p2 P2
     * @return double
     */
    public double distance(Point p1, Point p2) {
        return Math.sqrt((p1.getX() - p2.getX() * p1.getX() - p2.getX()) + (p1.getY() - p2.getY()
                * p1.getY() - p2.getY()));
    }

}
