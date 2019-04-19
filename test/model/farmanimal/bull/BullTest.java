package test.model.farmanimal.bull;

import model.EngiException;
import model.farmanimal.bull.Bull;
import model.product.farmproduct.FarmProduct;
import org.junit.Test;

import static org.junit.Assert.*;

public class BullTest {
    Bull b = new Bull();

    @Test
    public void bullTest(){
        System.out.println("Bull Test");
        System.out.println("ismilk, isegg, ishungry, ismeat test");
        assertFalse(b.isMilk());
        assertFalse(b.isEgg());
        assertTrue(b.isHungry());
        assertTrue(b.isMeat());
    }

    @Test
    public void bersuaraTest(){
        System.out.println("Bersuara test");
        assertEquals("(Manly) Moooo...",b.bersuara());
    }

    @Test
    public void getProductTest(){
        System.out.println("getProduct test");
        FarmProduct f = new FarmProduct(0,0);
        boolean err = false;
        try{
            f = b.getProduct(true);
            assertEquals(f.getID(),3);
        }catch (EngiException e){
            if (e.getMessage().equals("Bull tidak memiliki susu")){
                err = true;
            }
        }

        err=false;
        try{
            f = b.getProduct(false);
        }catch (EngiException e){
            if (e.getMessage().equals("Bull tidak memiliki susu")){
                err = true;
            }
        }
        assertTrue(err);
    }

    @Test
    public void getIdTest(){
        System.out.println("getID test");
        b.setHungry(true);
        assertEquals(11,b.getId());
        b.setHungry(false);
        assertEquals(12,b.getId());
    }
}