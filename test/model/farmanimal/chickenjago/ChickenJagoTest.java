package test.model.farmanimal.chickenjago;

import model.EngiException;
import model.farmanimal.chickenjago.ChickenJago;
import model.product.farmproduct.FarmProduct;
import org.junit.Test;

import static org.junit.Assert.*;

public class ChickenJagoTest {
    ChickenJago b = new ChickenJago();

    @Test
    public void chickenJagoTest(){
        System.out.println("ChickenJago Test");
        System.out.println("ismilk, isegg, ishungry, ismeat test");
        assertFalse(b.isMilk());
        assertFalse(b.isEgg());
        assertTrue(b.isHungry());
        assertTrue(b.isMeat());
    }

    @Test
    public void bersuaraTest(){
        System.out.println("Bersuara test");
        assertEquals("kukuruyuuuuuk",b.bersuara());
    }

    @Test
    public void getProductTest(){
        System.out.println("getProduct test");
        FarmProduct f = new FarmProduct(0,0);
        boolean err = false;
        try{
            f = b.getProduct(true);
            assertEquals(f.getID(),2);
        }catch (EngiException e){
            if (e.getMessage().equals("ChickenJago tidak memiliki telur")){
                err = true;
            }
        }

        err=false;
        try{
            f = b.getProduct(false);
        }catch (EngiException e){
            if (e.getMessage().equals("ChickenJago tidak memiliki telur")){
                err = true;
            }
        }
        assertTrue(err);
    }

    @Test
    public void getIdTest(){
        System.out.println("getID test");
        b.setHungry(true);
        assertEquals(3,b.getId());
        b.setHungry(false);
        assertEquals(4,b.getId());
    }
}