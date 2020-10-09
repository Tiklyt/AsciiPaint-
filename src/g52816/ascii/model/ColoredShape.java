package g52816.ascii.model;

import g52816.ascii.view.Color;

/**
 *
 * @author bilal
 */
public abstract class ColoredShape implements Shape {

    private char color;
    private String coloration;

    /**
     * Allow to create a Color to the shape
     *
     * @param color color of the shape
     */
    public ColoredShape(char color) {
        this.color = color;
        coloration = Color.BLACK;
    }

    /**
     * Get the Color of the instance
     *
     * @return char
     */
    public char getColor() {
        return color;
    }

    /**
     * set the Color of the instance
     *
     * @param color char
     */
    public void setColor(char color) {
        this.color = color;
    }

    /**
     * Allow to change the coloration of a ColoredShape
     *
     * @param coloration the color
     */
    public void changeColoration(String coloration) {
        this.coloration = coloration;
    }

    /**
     * Allow to get the coloration
     *
     * @return the coloration
     */
    public String getColoration() {
        return coloration;
    }
    
    public boolean isAGroup(){
        return false;
    }

    public void colorationSetter(String color) { // jamais de classe de la vue dans le modèle.
        switch (color) {
            case "RED":
                coloration = Color.RED;
                System.out.println("LOL");
                break;
            case "YELLOW":
                coloration = Color.YELLOW;
                
                break;
            case "BLUE":
                coloration = Color.BLUE;
                break;
            case "GREEN":
                coloration = Color.GREEN;
                break;
            case "CYAN":
                coloration = Color.CYAN;
                break;
            case "PURPLE":
                coloration = Color.PURPLE;
                break;
            default:
                System.out.println("Non founded color.");
        }
    }
    
    public char getColor(Point p){ // garder uniquement cette méthode et la mettre dans Shape
        return ' ';
    }
    
    public String getColoration(Point p){
        return " ";
    }

    public String resetter() {
        return Color.RESET;
    }

}
