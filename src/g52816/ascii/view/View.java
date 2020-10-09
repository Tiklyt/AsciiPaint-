package g52816.ascii.view;

import g52816.ascii.flipTable.FlipTable;
import g52816.ascii.model.AsciiPaint;
import g52816.ascii.model.ColoredShape;
import g52816.ascii.model.Drawing;
import g52816.ascii.model.Point;
import java.awt.AWTException;
import java.awt.Robot;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author user
 */
public class View {

    private Scanner in = new Scanner(System.in);
    private final AsciiPaint paint;

    /**
     * Create the view
     *
     * @param p The model
     */
    public View(AsciiPaint p) {
        paint = p;
    }

    /**
     * Ask a command to the user
     *
     * @return the command asked from the user
     */
    public String askCommand() {
        return in.nextLine();
    }

    /**
     * Show how many shapes theres is in the draw
     */
    public void showShapes() {
        System.out.println(paint.getShapes());
    }

    /**
     * Show the Paint
     */
    public void showPaint() {
        Drawing d = paint.getDraw();
        clearer();
        String[][] Paint = asAscii();
        for (int i = 0; i < d.getWidth(); i++) {
            for (int j = 0; j < d.getHeight(); j++) {
                System.out.print(Paint[i][j]);
            }
            System.out.println(".");
        }
    }

    /**
     * Draw shapes into the Background paint
     *
     * @return result
     */
    private String[][] asAscii() {
        Drawing d = paint.getDraw();
        String[][] draw = new String[d.getHeight()][d.getHeight()];
        for (int i = 0; i < d.getHeight(); i++) {
            for (int j = 0; j < d.getHeight(); j++) {
                Point p = new Point(i, j);
                ColoredShape shape = d.getShape(p);
                if (shape != null) {
                    if (!shape.isAGroup()) {
                        draw[p.getX()][p.getY()] = shape.getColoration()
                                + Character.toString(shape.getColor())
                                + shape.resetter();
                    } else {
                        draw[p.getX()][p.getY()] = shape.getColoration(p)
                                + Character.toString(shape.getColor(p))
                                + shape.resetter();
                    }

                } else {
                    draw[p.getX()][p.getY()] = ".";
                }
            }
        }
        return draw;
    }

    /**
     * Change the Input to a new InputStream
     *
     * @param in
     */
    public void setInput(InputStream in) {
        this.in = new Scanner(in);
    }

    /**
     * Reset the input
     */
    public void resetInput() {
        setInput(System.in);
    }

    /**
     * Find the file and read line by line this file
     *
     * @param s the File name
     */
    public void executeLoad(String s) {
        try {
            setInput(new FileInputStream(s));
        } catch (FileNotFoundException ex) {
            System.out.println("File not found !");
        }
    }

    /**
     * Show the help command
     */
    public void helpShower() {
        String[] header = {"Add     ", "Utils     "};
        String[][] data = {
            {"add circle X Y rd C", "move NB X Y"},
            {"add rectangle X Y W H C", "list//color NB COLOR//del NB"},
            {"add square X Y SIDE C", "show//exit//undo/redo//load"},
            {"add line X1 Y1 X2 Y2", "compact"},};

        System.out.println(FlipTable.of(header, data));
    }
    
    public void clearer(){
   /*     try {
    Robot pressbot = new Robot();
    pressbot.keyPress(17); // Holds CTRL key.
    pressbot.keyPress(76); // Holds L key.
    pressbot.keyRelease(17); // Releases CTRL key.
    pressbot.keyRelease(76); // Releases L key.
} catch (AWTException ex) {

}*/
    }

    public void menuShower() {
        // default StandardCharsets.UTF_8
        String content;
        try {
            content = Files.readString(Paths.get("paint.txt"));
            System.out.println(content);
            content = Files.readString(Paths.get("name.txt"));
            System.out.println(content);
        } catch (IOException ex) {
            Logger.getLogger(View.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
