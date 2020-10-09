package g52816.ascii.model;

/**
 *
 * @author bilal
 */
public class MoveCommand implements Command{
    private ColoredShape c;
    private int dx;
    private int dy;

    /**
     * Allow to create a move Command
     * @param c the shape where the move will be done
     * @param dx delta X
     * @param dy delta Y
     */
    public MoveCommand(ColoredShape c, int dx, int dy) {
        this.c = c;
        this.dx = dx;
        this.dy = dy;
    }

    /**
     * execute the modification
     */
    @Override
    public void execute() {
        c.move(dx, dy);
    }

    /**
     * unexecute the modification
     */
    @Override
    public void unexecute() {
       c.move(-dx, -dy);
    }
   
}
