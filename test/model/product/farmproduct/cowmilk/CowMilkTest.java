package test.model.product.farmproduct.cowmilk;

import model.product.farmproduct.cowmilk.CowMilk;
import org.junit.Test;

import static org.junit.Assert.*;

public class CowMilkTest {
    CowMilk c = new CowMilk();

    @Test
    public void cowmilk_test(){
        System.out.println("CowMilk Test");
        System.out.println("Id and harga test");
        assertEquals(4,c.getIdProduct());
        assertEquals(15000,c.getHarga());
    }
}