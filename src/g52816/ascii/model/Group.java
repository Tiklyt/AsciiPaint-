package g52816.ascii.model;

import java.util.List;

/**
 *
 * @author bilal
 */ 
public class Group extends ColoredShape { // implements Shape

    private List<ColoredShape> group; // List de Shape

    /**
     * create a group
     *
     * @param grouped the List of group that will be copied
     */
    public Group(List<ColoredShape> grouped) {
        super('G');
        group = grouped;
    }

    /**
     * Move all the group depending of delta X and delta Y
     *
     * @param dx delta X
     * @param dy delta Y
     */
    @Override
    public void move(double dx, double dy) {
        for (ColoredShape coloredShape : group) {
            coloredShape.move(dx, dy);
        }
    }

    /**
     * Return the first Insided Point from the group
     *
     * @param p the Point that will be tested
     * @return true or false
     */
    @Override
    public boolean isInside(Point p) {
        for (ColoredShape coloredShape : group) {
            if (coloredShape.isInside(p)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Convert a Group to a String
     *
     * @return String of Group
     */
    @Override
    public String toString() {
        String v = "Group : ";
        for (ColoredShape coloredShape : group) {
            v += coloredShape.toString() + " ";
        }
        return v;
    }
    
    public boolean isAGroup(){ // supprimer
        return true;
    }
    
    public char getColor(Point p){
        for (ColoredShape coloredShape : group) {
            if(coloredShape.isInside(p)){
                return coloredShape.getColor();
            }
        }
        return ' ';
    }
    
    public String getColoration(Point p){
        for (ColoredShape coloredShape : group) {
            if(coloredShape.isInside(p)){
                return coloredShape.getColoration();
            }
        }
        return " ";
    }
}
