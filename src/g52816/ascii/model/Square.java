package g52816.ascii.model;

/**
 *
 * @author bilal
 */
public class Square extends Rectangle {

    /**
     * Create a square with his characteristics
     *
     * @param upperLeft the upperLeft point
     * @param side side of square
     * @param color color of the square
     */
    public Square(Point upperLeft, double side, char color) {
        super(upperLeft, side, side, color);
    }

}
