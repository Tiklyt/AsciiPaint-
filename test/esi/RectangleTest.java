package esi;

import g52816.ascii.model.Point;
import g52816.ascii.model.Rectangle;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author bilal
 */
public class RectangleTest {

    @Test
    public void testMove() {
        System.out.println("testMove");
        double dx = 2;
        double dy = 2;
        Rectangle instance = new Rectangle(new Point(1, 1), 10, 5, 'c');
        Rectangle exp = new Rectangle(new Point(3, 3), 10, 5, 'c');
        instance.move(dx, dy);
        assertEquals(exp, instance);
    }
    @Test
    public void testIsInside() {
        System.out.println("isInsideCheck");
        Rectangle r = new Rectangle(new Point(10, 10), 10, 5, 'c');
        assertTrue(r.isInside(new Point(11, 11)));
    }

    @Test
    public void testIsNotInside() {
        System.out.println("isNotInsideCheck");
        Rectangle r = new Rectangle(new Point(10, 10), 10, 5, 'c');
        assertFalse(r.isInside(new Point(20, 11)));
    }

}
