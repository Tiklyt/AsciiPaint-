package g52816.ascii.model;

/**
 *
 * @author bilal
 */
public class ColorCommand implements Command{

    
    private ColoredShape c;
    private String previousColor;
    private String nameColor;

    /**
     * Create a color command
     * @param c the coloredShape
     * @param nameColor the name of the color
     */
    public ColorCommand(ColoredShape c, String nameColor) {
        this.c = c;
        this.previousColor = c.getColoration();
        this.nameColor = nameColor;
    }
    
    /**
     * execute the command
     */
    @Override
    public void execute() {
        c.colorationSetter(nameColor);
    }

    /**
     * unexecute the command
     */
    @Override
    public void unexecute() {
        c.changeColoration(previousColor);
    }
    
}
