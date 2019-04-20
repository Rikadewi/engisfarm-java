package test.model.product.farmproduct.platypusegg;

import model.product.farmproduct.platypusegg.PlatypusEgg;
import org.junit.Test;

import static org.junit.Assert.*;

public class PlatypusEggTest {
    PlatypusEgg c = new PlatypusEgg();

    @Test
    public void platypusegg_test(){
        System.out.println("PlatypusEgg Test");
        System.out.println("Id and harga test");
        assertEquals(5,c.getIdProduct());
        assertEquals(10000,c.getHarga());
    }
}