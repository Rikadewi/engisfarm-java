package test.model.farmanimal.chickenkampung;

import model.EngiException;
import model.farmanimal.chickenkampung.ChickenKampung;
import model.product.farmproduct.FarmProduct;
import org.junit.Test;

import static org.junit.Assert.*;

public class ChickenKampungTest {
    ChickenKampung b = new ChickenKampung();

    @Test
    public void chickenKampungTest(){
        System.out.println("ChickenKampung Test");
        System.out.println("ismilk, isegg, ishungry, ismeat test");
        assertFalse(b.isMilk());
        assertTrue(b.isEgg());
        assertTrue(b.isHungry());
        assertTrue(b.isMeat());
    }

    @Test
    public void bersuaraTest(){
        System.out.println("Bersuara test");
        assertEquals("pok pok petoook",b.bersuara());
    }

    @Test
    public void getProductTest(){
        System.out.println("getProduct test");
        FarmProduct f = new FarmProduct(0,0);
        boolean err = false;
        try{
            b.setHungry(false);
            f = b.getProduct(true);
            assertEquals(f.getIdProduct(),2);
        }catch (EngiException e){
            if (e.getMessage().equals("ayam kampung ini tidak memiliki telur saat ini")){
                err = true;
            }
        }

        err=false;
        try{
            b.setHungry(true);
            b.makan();
            f = b.getProduct(false);
            assertEquals(f.getIdProduct(),1);
        }catch (EngiException e){
            if (e.getMessage().equals("ayam kampung ini tidak memiliki telur saat ini")){
                err = true;
            }
        }

        err=false;
        try{
            b.setHungry(false);
            f = b.getProduct(false);
            assertEquals(f.getIdProduct(),1);
        }catch (EngiException e){
            if (e.getMessage().equals("ayam kampung ini tidak memiliki telur saat ini")){
                err = true;
            }
        }

        assertTrue(err);
    }

    @Test
    public void getIdTest(){
        System.out.println("getIdProduct test");
        b.setHungry(true);
        assertEquals(1,b.getId());
        b.setHungry(false);
        assertEquals(2,b.getId());
    }

}