package test.model.product.farmproduct.chickenmeat;

import model.product.farmproduct.chickenmeat.ChickenMeat;
import org.junit.Test;

import static org.junit.Assert.*;

public class ChickenMeatTest {
    ChickenMeat c = new ChickenMeat();

    @Test
    public void chickenmeat_test(){
        System.out.println("ChickenMeat Test");
        System.out.println("Id and harga test");
        assertEquals(2,c.getIdProduct());
        assertEquals(17000,c.getHarga());
    }
}