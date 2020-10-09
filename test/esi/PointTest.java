
package esi;


import g52816.ascii.model.Point;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author bilal
 */
public class PointTest {
        
    @Test
    public void testGetX() {
        System.out.println("getX");
        Point instance = new Point(1,0);
        int expResult = 1;
        int result = instance.getX();
        assertEquals(expResult, result);     
    }
    @Test
    public void testGetY() {
        System.out.println("getY");
        Point instance = new Point(0,1);
        int expResult = 1;
        int result = instance.getY();
        assertEquals(expResult, result);     
    }
    @Test
    public void testDefaultPoint() {
        System.out.println("defaultPoint");
        Point instance = new Point();
        Point expResult = new Point(0,0) ;
        assertEquals(instance, expResult);     
    }
    @Test
    public void testMove(){
        System.out.println("MovePoint");
        Point p = new Point(10, 10);
        Point expR = new Point(20,20);
        p.move(10, 10);
        assertEquals(expR, p);
    }
}
