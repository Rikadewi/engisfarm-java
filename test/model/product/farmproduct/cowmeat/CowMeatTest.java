package test.model.product.farmproduct.cowmeat;

import model.product.farmproduct.cowmeat.CowMeat;
import org.junit.Test;

import static org.junit.Assert.*;

public class CowMeatTest {
    CowMeat c = new CowMeat();

    @Test
    public void cowmeat_test(){
        System.out.println("CowMeat Test");
        System.out.println("Id and harga test");
        assertEquals(3,c.getIdProduct());
        assertEquals(45000,c.getHarga());
    }
}