package test.model.product.sideproduct.platycowpancake;

import model.product.sideproduct.platycowpancake.PlatycowPancake;
import org.junit.Test;

import static org.junit.Assert.*;

public class PlatycowPancakeTest {
    PlatycowPancake c = new PlatycowPancake();

    @Test
    public void platycowpancake_test(){
        System.out.println("PlatycowPancake Test");
        System.out.println("Id and harga test");
        assertEquals(9,c.getID());
        assertEquals(30000,c.getHarga());
    }

}