package g52816.ascii.model;

import java.util.Objects;

/**
 *
 * @author bilal
 */
public class Circle extends ColoredShape {

    private double radius;
    private Point center;

    /**
     * Create a circle with his characteristics
     *
     * @param center center of the circle
     * @param radius radius of the circle
     * @param color color of the circle
     */
    public Circle(Point center, double radius, char color) {
        super(color);
        if (radius <= 0) {
            throw new IllegalArgumentException("radius must be positive "
                    + "received : "
                    + radius);
        }
        this.radius = radius;
        this.center = new Point(center);
    }

    /**
     * move the point center of the circle
     *
     * @param dx offset of X
     * @param dy offset of Y
     */
    public void move(double dx, double dy) {
        center.move(dx, dy);
    }

    /**
     * give the center of the circle
     *
     * @return the circle point
     */
    public Point getCenter() {
        return center; // copie
    }

    /**
     * represent the circle in a String
     *
     * @return a string circle
     */
    @Override
    public String toString() {
        return "Circle" + "rad:" + radius + ",center:" + center;
    }

    /**
     * check if a point is inside the circle
     *
     * @param p the p that will be checked
     * @return true or false
     */
    @Override
    public boolean isInside(Point p) {
        return Math.pow(p.getX() - center.getX(), 2) + Math.pow(p.getY() // ajouter une méthode distanceTo dans la classe point. center.distanceTo(p) <= radius;
                - center.getY(), 2) <= radius;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 73 * hash + (int) (Double.doubleToLongBits(this.radius) ^ (Double.doubleToLongBits(this.radius) >>> 32));
        hash = 73 * hash + Objects.hashCode(this.center);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Circle other = (Circle) obj;
        if (Double.doubleToLongBits(this.radius) != Double.doubleToLongBits(other.radius)) {
            return false;
        }
        return Objects.equals(this.center, other.center);
    }

}
