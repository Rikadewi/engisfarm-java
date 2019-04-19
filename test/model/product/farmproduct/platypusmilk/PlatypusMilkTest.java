package test.model.product.farmproduct.platypusmilk;

import model.product.farmproduct.platypusmilk.PlatypusMilk;
import org.junit.Test;

import static org.junit.Assert.*;

public class PlatypusMilkTest {
    PlatypusMilk c = new PlatypusMilk();

    @Test
    public void platypusmilk_test(){
        System.out.println("PlatypusMilk Test");
        System.out.println("Id and harga test");
        assertEquals(6,c.getID());
        assertEquals(25000,c.getHarga());
    }
}