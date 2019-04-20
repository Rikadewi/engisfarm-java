package test.model.cell.facility.truck;

import model.cell.facility.truck.Truck;
import org.junit.Test;

import static org.junit.Assert.*;

public class TruckTest {
    Truck t = new Truck();

    @Test
    public void truckTest(){
        System.out.println("Truck test");
        assertTrue(t.isAvailable());
    }

    @Test
    public  void renderTest(){
        System.out.println("Render test");
        assertEquals(t.render(),21);
    }

    @Test
    public void updateCellTest(){
        System.out.println("Update Cell Test");
        t.setNotReady();
        for(int i=0;i<5;i++){
            t.updateCell("readyTruck");
        }
        assertTrue(t.isAvailable());
    }
}