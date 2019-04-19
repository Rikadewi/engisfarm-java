package test.model.product.sideproduct.beefomellete;

import model.product.sideproduct.beefomellete.BeefOmellete;
import org.junit.Test;

import static org.junit.Assert.*;

public class BeefOmelleteTest {
    BeefOmellete c = new BeefOmellete();

    @Test
    public void beefomellete_test(){
        System.out.println("BeefOmellete Test");
        System.out.println("Id and harga test");
        assertEquals(7,c.getID());
        assertEquals(60000,c.getHarga());
    }

}