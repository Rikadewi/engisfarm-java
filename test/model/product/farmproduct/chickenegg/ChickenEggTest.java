package test.model.product.farmproduct.chickenegg;

import model.product.farmproduct.chickenegg.ChickenEgg;
import org.junit.Test;
import static org.junit.Assert.assertEquals;


public class ChickenEggTest {
    ChickenEgg c = new ChickenEgg();

    @Test
    public void chickenegg_test(){
        System.out.println("ChickenEgg Test");
        System.out.println("Id and harga test");
        assertEquals(1,c.getIdProduct());
        assertEquals(3000,c.getHarga());
    }
}