package esi;


import g52816.ascii.model.Circle;
import g52816.ascii.model.Point;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author user
 */
public class CircleTest {
    

    /**
     * Test of move method, of class Circle.
     */
    @Test
    public void testMove() {
        System.out.println("moveCircle");
        Circle c = new Circle(new Point(5,5),5,'o');
        Circle exp = new Circle(new Point(10,10),5,'o');
        c.move(5, 5);
        assertEquals(exp, c);
    }

    @Test
    public void isInside(){
        System.out.println("circlePointIsInside");
        Circle c = new Circle(new Point(5, 5),5,'o');
        Point p = new Point(6, 6);
        assertTrue(c.isInside(p));
    }
    
    @Test
    public void isNotInside(){
        System.out.println("circlePointIsNotInside");
        Circle c = new Circle(new Point(5, 5),5,'o');
        Point p = new Point(25, 25);
        assertFalse(c.isInside(p));
    }
    
}
