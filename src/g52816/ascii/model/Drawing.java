package g52816.ascii.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author bilal
 */
public class Drawing {

    final static int DEFAULT_HEIGHT = 50;
    final static int DEFAULT_WIDTH = 50;
    private List<ColoredShape> shapes;
    private int height;
    private int width;

    /**
     * create a Draw with his characteristics
     *
     * @param height the height
     * @param width the width
     */
    public Drawing(int height, int width) {
        if (height < 0 || width < 0) {
            throw new IllegalArgumentException("Cant have negative value height"
                    + " : " + height + " width : " + width);
        }
        this.shapes = new ArrayList<>();
        this.height = height;
        this.width = width;
    }

    /**
     * create a Draw with default characteristics
     */
    public Drawing() {
        this(DEFAULT_HEIGHT, DEFAULT_WIDTH);
    }

    /**
     * Add to shape list
     *
     * @param shape the shape
     */
    public void addShape(ColoredShape shape) {
        shapes.add(shape);
    }

    public void setShape(ColoredShape shape, int pos) {
        shapes.set(pos, shape);
    }

    /**
     * get a shape in a point p
     *
     * @param p check p
     * @return a shape or null
     */
    public ColoredShape getShape(Point p) {
        for (int i = 0; i < shapes.size(); i++) {
            if (shapes.get(i).isInside(p)) {
                return shapes.get(i);
            }
        }
        return null;
    }

    /**
     * Allow to remove a shape
     *
     * @param i the position of i in List to remove
     */
    public void removeShape(int i) {
        shapes.remove(i);
    }

    public List<ColoredShape> getShapes() { // supprimer ou copie au minimum
        return shapes;
    }

    /**
     * give the Height
     *
     * @return the Height
     */
    public int getHeight() {
        return height;
    }

    /**
     * give the Width
     *
     * @return the width
     */
    public int getWidth() {
        return width;
    }
}
