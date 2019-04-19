package test.model.product.sideproduct.plachicksoup;

import model.product.sideproduct.plachicksoup.PlachickSoup;
import org.junit.Test;

import static org.junit.Assert.*;

public class PlachickSoupTest {
    PlachickSoup c = new PlachickSoup();

    @Test
    public void chicken_test(){
        System.out.println("PlachickSoup Test");
        System.out.println("Id and harga test");
        assertEquals(8,c.getID());
        assertEquals(55000,c.getHarga());
    }
}