package g52816.ascii.controller;

import g52816.ascii.model.AsciiPaint;
import g52816.ascii.model.ColoredShape;
import g52816.ascii.model.Point;
import g52816.ascii.view.View;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author bilal
 */
public class Application {

    private AsciiPaint ascii;
    private final View v;

    /**
     * Allow to create a Application
     */
    public Application() {
        initializer();
        v = new View(ascii);
    }

    /**
     * Start the application
     */
    public void start() {
        v.menuShower();
        v.helpShower();
        System.out.println("Enter a command !");
        String command = v.askCommand();
        while (!command.contains("exit")) {
            try {
                if (commandMatcher(command)) {
                    System.out.println("Command not found !");
                }
            } catch (IndexOutOfBoundsException e) {
                System.out.println("The index you choosed is not in bound");
            }
            System.out.println("Enter a command !");
            command = v.askCommand();
        }
        System.out.println("Good bye !");
    }

    /**
     * check if command match to create rectangle
     *
     * @param s command checked
     */
    private boolean rectangleMatcher(String s) {
        if (s.matches("add rectangle \\d+ \\d+ \\d+ \\d+ \\w")) {
            String[] tab = s.split("\\s");
            int x = Integer.parseInt(tab[2]);
            int y = Integer.parseInt(tab[3]);
            int width1 = Integer.parseInt(tab[4]);
            int height1 = Integer.parseInt(tab[5]);
            char c = tab[6].charAt(0);
            ascii.newRectangle(x, y, width1, height1, c);
            return true;
        }
        return false;
    }

    /**
     * check if command match to create circle
     *
     * @param s command checked
     */
    private boolean circleMatcher(String s) {
        if (s.matches("add circle \\d+ \\d+ \\d+ \\w")) {
            String[] tab = s.split("\\s");
            int x = Integer.parseInt(tab[2]);
            int y = Integer.parseInt(tab[3]);
            int radius = Integer.parseInt(tab[4]);
            char c = tab[5].charAt(0);
            ascii.newCircle(y, x, radius, c);
            return true;
        }
        return false;
    }

    /**
     * Check if command match to create line
     *
     * @param s command checked
     * @return true or false
     */
    private boolean lineMatcher(String s) {
        if (s.matches("add line \\d+ \\d+ \\d+ \\d+ \\w")) {
            String[] tab = s.split("\\s");
            Point p1 = new Point(Integer.parseInt(tab[2]), Integer.parseInt(tab[3]));
            Point p2 = new Point(Integer.parseInt(tab[4]), Integer.parseInt(tab[5]));
            ascii.newLine(p1, p2, tab[6].charAt(0));
            return true;
        }
        return false;
    }

    /**
     * checked if command match to create square
     *
     * @param s command checked
     */
    private boolean squareMatcher(String s) {
        if (s.matches("add square \\d+ \\d+ \\d+ \\w")) {
            String[] tab = s.split("\\s");
            int x = Integer.parseInt(tab[2]);
            int y = Integer.parseInt(tab[3]);
            int side = Integer.parseInt(tab[4]);
            char c = tab[5].charAt(0);
            ascii.newSquare(x, y, side, c);
            return true;
        }
        return false;
    }

    /**
     * checked if command match to show Paint
     *
     * @param s command checked
     */
    private boolean showMatcher(String s) {
        if (s.matches("show")) {
            v.showPaint();
            return true;
        }
        return false;
    }

    /**
     * Check if command match with list
     *
     * @param s the String
     * @return true or false
     */
    private boolean listMatcher(String s) {
        if (s.matches("list")) {
            v.showShapes();
            return true;
        }
        return false;
    }

    /**
     * Check if command match with move
     *
     * @param s the String
     * @return true or false
     */
    private boolean moveMatcher(String s) {
        if (s.matches("move \\d+ \\d+ \\d+")) {
            String[] tab = s.split("\\s");
            int pos = Integer.parseInt(tab[1]);
            int dx = Integer.parseInt(tab[2]);
            int dy = Integer.parseInt(tab[3]);
            ColoredShape c = ascii.getDraw().getShapes().get(pos);
            ascii.move(c, dx, dy);
            return true;
        }
        return false;
    }

    /**
     * Check if command match with delete
     *
     * @param s the String
     * @return true or false
     */
    private boolean deleteMatcher(String s) {
        if (s.contains("del")) {
            String[] tab = s.split("\\s");
            int val = Integer.parseInt(tab[1]);
            ascii.delete(ascii.getShapes().get(val));
            return true;
        }
        return false;
    }

    /**
     * Check if command match with coloration
     *
     * @param s the String
     * @return true or false
     */
    private boolean colorationMatcher(String s) {
        String[] v = s.split("\\s");
        if (v[0].matches("color")) {
            int value = Integer.parseInt(v[1]);
            ColoredShape c = ascii.getShapes().get(value);
            ascii.changeColor(c, v[2]);
            return true;
        }
        return false;
    }

    /**
     * Check if command match with group
     *
     * @param s The String
     * @return true or false
     */
    private boolean groupMatcher(String s) {
        String[] v = s.split("\\s");
        List<ColoredShape> g = new ArrayList<>();
        if (v[0].matches("group")) {
            for (int i = 1; i < v.length; i++) {
                System.out.println(v[i]);
                if (Integer.parseInt(v[i]) < ascii.getShapes().size()) {
                    ColoredShape c = ascii.getShapes().get(Integer.parseInt(v[i]));
                    g.add(c);
                }
            }
            for (int i = 0; i < g.size(); i++) {
                for (int j = 0; j < ascii.getShapes().size(); j++) { // pas ici mais dans le modèle (dans GroupCommand)
                    if (g.get(i) == ascii.getShapes().get(j)) {
                        ascii.getShapes().remove(j);
                    }
                }
            }
            ascii.newGroup(g);
        } else {
            return false;
        }
        return true;
    }

    /**
     * Check if command match with undo
     *
     * @param s the command
     * @return true or false
     */
    private boolean undoMatcher(String s) {
        if (s.matches("undo")) {
            ascii.undo();
            return true;
        }
        return false;
    }

    /**
     * Check if command match with redo
     *
     * @param s the command
     * @return true or false
     */
    private boolean redoMatcher(String s) {
        if (s.matches("redo")) {
            ascii.redo();
            return true;
        }
        return false;
    }

    /**
     * Check if the command matches with load
     *
     * @param s the command String
     * @return true or false
     * @throws FileNotFoundException Exception if file not found
     */
    private boolean loadMatcher(String s) {
        String[] tokenized = s.split(" ");
        if (tokenized[0].matches("load")) {
            v.executeLoad(tokenized[1]);
            return true;
        }
        return false;
    }

    /**
     * Check if the command matches with EOF (end of file)
     *
     * @param s the string command
     * @return true or false
     */
    private boolean EOFMatcher(String s) {
        if (s.contains("eof")) {
            v.resetInput();
            return true;
        }
        return true;
    }

    /**
     * General command Matcher Function
     * @param command command
     * @return true or false
     */
    private boolean commandMatcher(String command) {
        return !circleMatcher(command)
                && !rectangleMatcher(command)
                && !squareMatcher(command)
                && !showMatcher(command)
                && !listMatcher(command)
                && !deleteMatcher(command)
                && !moveMatcher(command)
                && !colorationMatcher(command)
                && !groupMatcher(command)
                && !lineMatcher(command)
                && !redoMatcher(command)
                && !undoMatcher(command)
                && !loadMatcher(command)
                && !EOFMatcher(command);
    }

    /**
     * Initialize the windows Applications
     */
    private void initializer() {
        Scanner clavier = new Scanner(System.in);
        System.out.println("Which size for your paint windows ?");
        int width = clavier.nextInt();
        int height = clavier.nextInt();
        while (width < 0 || height < 0) {
            System.out.println("Enter positive value !");
            width = clavier.nextInt();
            height = clavier.nextInt();
        }
        ascii = new AsciiPaint(width, height);
    }

    public static void main(String[] args) {
        Application A = new Application();
        A.start();
    }
}
