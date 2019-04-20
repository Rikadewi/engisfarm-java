package test.model.cell.land;

import model.cell.land.Land;
import model.farmanimal.bull.Bull;
import org.junit.Test;

import static org.junit.Assert.*;

public class LandTest {
    Bull b = new Bull();
    Land l = new Land(true, b, "grassLand");

    @Test
    public void landTest(){
        System.out.println("Land Test");
        assertTrue(l.isRumput());
        assertEquals(l.getAnimal().getId(),11);
        assertEquals(l.getType(),"grassLand");
    }
}