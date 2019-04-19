package test.model.farmanimal.cow;

import model.EngiException;
import model.farmanimal.cow.Cow;
import model.product.farmproduct.FarmProduct;
import org.junit.Test;

import static org.junit.Assert.*;

public class CowTest {
    Cow b = new Cow();

    @Test
    public void cowTest() {
        System.out.println("Cow Test");
        System.out.println("ismilk, isegg, ishungry, ismeat test");
        assertTrue(b.isMilk());
        assertFalse(b.isEgg());
        assertTrue(b.isHungry());
        assertTrue(b.isMeat());
    }

    @Test
    public void bersuaraTest() {
        System.out.println("Bersuara test");
        assertEquals("Moooo...", b.bersuara());
    }

    @Test
    public void getProductTest() {
        System.out.println("getProduct test");
        FarmProduct f = new FarmProduct(0, 0);
        boolean err = false;
        try {
            b.setHungry(false);
            f = b.getProduct(true);
            assertEquals(f.getID(), 3);
        } catch (EngiException e) {
            if (e.getMessage().equals("sapi ini tidak memiliki susu saat ini")) {
                err = true;
            }
        }

        err = false;
        try {
            b.setHungry(true);
            b.makan();
            f = b.getProduct(false);
            assertEquals(f.getID(), 4);
        } catch (EngiException e) {
            if (e.getMessage().equals("sapi ini tidak memiliki susu saat ini")) {
                err = true;
            }
        }

        err = false;
        try {
            b.setHungry(false);
            f = b.getProduct(false);
            assertEquals(f.getID(), 4);
        } catch (EngiException e) {
            if (e.getMessage().equals("sapi ini tidak memiliki susu saat ini")) {
                err = true;
            }
        }

        assertTrue(err);
    }

    @Test
    public void getIdTest() {
        System.out.println("getID test");
        b.setHungry(true);
        assertEquals(5, b.getId());
        b.setHungry(false);
        assertEquals(6, b.getId());

    }
}