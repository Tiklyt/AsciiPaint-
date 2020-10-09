package g52816.ascii.model;

import java.util.List;

/**
 *
 * @author bilal
 */
public class GroupCommand implements Command {

    private final Drawing drawing;
    private final List<ColoredShape> l; // très parlant comme nom
    private final Group g; // excellent choix

    /**
     * create a group command
     *
     * @param drawing the draw where the command will be executed
     * @param shape List of shapes to create the group
     */
    public GroupCommand(Drawing drawing, List<ColoredShape> shape) {
        g = new Group(shape);
        this.drawing = drawing;
        this.l = shape;
    }

    /**
     * execute the command into the draw
     */
    @Override
    public void execute() {
        drawing.addShape(g);
        // retirer les shapes du groupe ???
    }

    /**
     * unexecute the command into the draw
     */
    @Override
    public void unexecute() {
        drawing.getShapes().remove(g);
        for (ColoredShape coloredShape : l) {
            drawing.getShapes().add(coloredShape);
        }
    }
}
