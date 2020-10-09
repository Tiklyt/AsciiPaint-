package g52816.ascii.model;

/**
 *
 * @author bilal
 */
public class deleteCommand implements Command{
    private ColoredShape c; // utiliser Shape partout et pas ColoredShape
    private final Drawing d;

    
    /**
     * Create a deleteCommand
     * @param c the colored shape that will be destroyed
     * @param d where the shape will be destroyed
     */
    public deleteCommand(ColoredShape c, Drawing d) {
        this.c = c;
        this.d = d;
    }

    
    /**
     * execute the command
     */
    @Override
    public void execute() {
        d.getShapes().remove(c);
    }

    
    /**
     * unexecute the command
     */
    @Override
    public void unexecute() {
        d.getShapes().add(c);
    }

    
    
    
}
