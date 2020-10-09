package g52816.ascii.model;

import java.util.List;
import java.util.Stack;

/**
 *
 * @author bilal
 */
public class AsciiPaint {

    private Drawing drawing;
     private UndoManager undoManager = new UndoManager();
    /**
     * create a Draw with default parameter
     */
    public AsciiPaint() {
        drawing = new Drawing();
    }

    /**
     * create a Draw with width and height
     *
     * @param width width
     * @param height height
     */
    public AsciiPaint(int width, int height) {
        drawing = new Drawing(width, height);
    }

    /**
     * Add a circle to the Draw
     *
     * @param x X
     * @param y y
     * @param radius radius
     * @param color color
     */
    public void newCircle(int x, int y, double radius, char color) {
        Command c = new AddCommand(drawing, new Circle(new Point(x, y), radius, color));
        undoManager.doIt(c);
    }

    /**
     * Add a rectangle to the draw
     *
     * @param x x
     * @param y y
     * @param width width
     * @param height height
     * @param color color
     */
    public void newRectangle(int x, int y, double width, double height, char color) {
        Command c = new AddCommand(drawing, new Rectangle(new Point(x, y), width, height, color));
        undoManager.doIt(c);
    }

    /**
     * Add a square to the draw
     *
     * @param x x
     * @param y y
     * @param side side
     * @param color color
     */
    public void newSquare(int x, int y, double side, char color) {
        Command c = new AddCommand(drawing, new Square(new Point(x, y), side, color));
        undoManager.doIt(c);// vider la redo stack
    }

    /**
     * Add a group to the shapes
     *
     * @param shapes List of shapes
     */
    public void newGroup(List<ColoredShape> shapes) {
        Command c = new GroupCommand(drawing, shapes);
        undoManager.doIt(c);// vider la redo stack
    }

    /**
     * Add a line in shapes
     *
     * @param p1 P1
     * @param p2 P2
     * @param color the color of the line
     */
    public void newLine(Point p1, Point p2, char color) {
        Command c = new AddCommand(drawing, new Line(p1, p2, color));
        undoManager.doIt(c);// vider la redo stack
    }

    public void move(ColoredShape c, int dx, int dy) {
        Command co = new MoveCommand(c, dx, dy);
        undoManager.doIt(co);// vider la redo stack
    }

    /**
     * return the drawing
     *
     * @return a Draw
     */
    public Drawing getDraw() { // supprimer: remplacer getHeight, getWidth et getcolorAt(x, y), getShapesList()
        return drawing;
    }
    
    /**
     * Change color of a shape
     * @param c a shape
     * @param Color the color choosed
     */
    public void changeColor(ColoredShape c,String Color){
        Command co = new ColorCommand(c, Color);
        undoManager.doIt(co);// vider la redo stack
        
    }
    /**
     * Delete a shape
     * @param c the shape that will be destroyed
     */
    public void delete(ColoredShape c){
        Command co = new deleteCommand(c, drawing);
        undoManager.doIt(co);// vider la redo stack
    }

    /**
     * return a List of ColoredShapes
     *
     * @return a List
     */
    public List<ColoredShape> getShapes() { // SUPPRIMER ou retourner une copie.
        return drawing.getShapes();
    }

    public void undo() {
        undoManager.undo();
    }

    public void redo() {
        undoManager.redo();
    }
}
