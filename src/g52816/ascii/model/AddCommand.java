package g52816.ascii.model;

/**
 *
 * @author bilal
 */
public class AddCommand implements Command{
    private final ColoredShape c;
    private final Drawing d;
    /**
     * Create a Add Command
     * @param d the draw where the change will be affected
     * @param c 
     */
    public AddCommand(Drawing d,ColoredShape c) {
        this.c = c;
        this.d = d;
    }

    /**
     * execute the command
     */
    @Override
    public void execute() {
        d.addShape(c);
    }

    /**
     * unexecute the command
     */
    @Override
    public void unexecute() {
       d.getShapes().remove(c);
    }
    
    
    
}
