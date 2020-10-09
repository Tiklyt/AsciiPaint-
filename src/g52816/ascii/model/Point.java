package g52816.ascii.model;

public class Point {

    private int x;
    private int y;

    /**
     * Create a point (x,y)
     *
     * @param x the x
     * @param y the y
     */
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * defensive copy
     *
     * @param p Point that will be copied
     */
    public Point(Point p) {
        this(p.x, p.y);
    }

    /**
     * Create a point(0,0)
     */
    public Point() {
        this(0, 0);
    }

    /**
     * Allow to return x from the point
     *
     * @return x
     */
    public int getX() {
        return x;
    }

    /**
     * Allow to return y from the point
     *
     * @return y
     */
    public int getY() {
        return y;
    }
    
    // ajouter distanceTo

    /**
     * Allow to move a point
     *
     * @param dx addition of dx
     * @param dy addition of dy
     */
    public void move(double dx, double dy) {
        x += dx;
        y += dy;
    }

    /**
     * Allow to represent a point in a String
     *
     * @return a String
     */
    @Override
    public String toString() {
        return "Point" + "x:" + x + ",y:" + y;
    }
}
