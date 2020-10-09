package g52816.ascii.model;

/**
 *
 * @author bilal
 */
//NO DOCUMENTATION FOR INTERFACE
public interface Shape {

    public void move(double dx, double dy);

    public boolean isInside(Point p);

    public char getColor();
    
    // setColor
}
