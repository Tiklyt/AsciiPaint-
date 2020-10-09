package g52816.ascii.model;

/**
 *
 * @author bilal
 */
public class Rectangle extends ColoredShape {

    private Point upperLeft;
    private double width;
    private double height;

    /**
     * Create a rectangle with his characteristics
     *
     * @param upperLeft leftBottom point of the rectangle
     * @param width the width
     * @param height the height
     * @param color color of the rectangle
     */
    public Rectangle(Point upperLeft, double width, double height, char color) {
        super(color);
        if (height < 0 || width < 0) {
            throw new IllegalArgumentException("Cant have negative value height"
                    + " : " + height + " width : " + width);
        }
        this.upperLeft = new Point(upperLeft);
        this.width = width;
        this.height = height;
    }

    /**
     * allow to move the rectangle
     *
     * @param dx added to x
     * @param dy added to y
     */
    public void move(double dx, double dy) {
        upperLeft.move(dx, dy);
    }

    /**
     * Represent a rectangle in a string
     *
     * @return a string
     */
    @Override
    public String toString() {
        return "Rec:" + upperLeft + " " + "width:" + width + " height:" + height;
    }

    /**
     * check if a point is inside
     *
     * @param p the point
     * @return true or false
     */
    @Override
    public boolean isInside(Point p) {
        return  p.getX() >= upperLeft.getX() && 
                p.getX() < (upperLeft.getX() + width) && 
                p.getY() >= upperLeft.getY() && 
                p.getY() < (upperLeft.getY() + height);

    }

}
