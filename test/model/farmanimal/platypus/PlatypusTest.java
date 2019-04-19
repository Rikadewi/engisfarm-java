package test.model.farmanimal.platypus;

import model.EngiException;
import model.farmanimal.platypus.Platypus;
import model.product.farmproduct.FarmProduct;
import org.junit.Test;

import static org.junit.Assert.*;

public class PlatypusTest {
    Platypus b = new Platypus();

    @Test
    public void platypusTest(){
        System.out.println("Platypus Test");
        System.out.println("ismilk, isegg, ishungry, ismeat test");
        assertTrue(b.isMilk());
        assertTrue(b.isEgg());
        assertTrue(b.isHungry());
        assertFalse(b.isMeat());
    }

    @Test
    public void bersuaraTest(){
        System.out.println("Bersuara test");
        assertEquals("krrrrrrr...",b.bersuara());
    }

    @Test
    public void getProductTest(){
        System.out.println("getProduct test");
        FarmProduct f = new FarmProduct(0,0);
        boolean err = false;
        boolean k = false;
        b.setHungry(true);
        b.makan();

        try{
            f = b.getProduct(false);
            boolean id = false;
            if (f.getID() == 5 || f.getID() == 6)
                id = true;
            assertTrue(id);
        }catch (EngiException e){
            if (e.getMessage().equals("platypus ini tidak memiliki produk saat ini")){
                err = true;
            }else if (e.getMessage().equals("kamu tidak boleh membunuh seekor platypus")){
                k=true;
            }
        }
        assertFalse(err);
        assertFalse(k);

        err=false;
        k=false;
        try{
            f = b.getProduct(true);
            boolean id = false;
            if (f.getID() == 5 || f.getID() == 6)
                id = true;
            assertFalse(id);
        }catch (EngiException e){
            if (e.getMessage().equals("platypus ini tidak memiliki produk saat ini")){
                err = true;
            }else if (e.getMessage().equals("kamu tidak boleh membunuh seekor platypus")){
                k=true;
            }
        }
        assertFalse(err);
        assertTrue(k);

        err=false;
        k=false;
        try{
            f = b.getProduct(false);
            boolean id = false;
            if (f.getID() == 5 || f.getID() == 6)
                id = true;
            assertFalse(id);
        }catch (EngiException e){
            if (e.getMessage().equals("platypus ini tidak memiliki produk saat ini")){
                err = true;
            }else if (e.getMessage().equals("kamu tidak boleh membunuh seekor platypus")){
                k=true;
            }
        }
        assertTrue(err);
        assertFalse(k);
    }

    @Test
    public void getIdTest(){
        System.out.println("getID test");
        b.setHungry(true);
        assertEquals(9,b.getId());
        b.setHungry(false);
        assertEquals(10,b.getId());
    }
}