package test.model.cell.facility.well;

import model.cell.facility.well.Well;
import org.junit.Test;

import static org.junit.Assert.*;

public class WellTest {
    Well w = new Well();

    @Test
    public void render() {
        System.out.println("Render test");
        assertEquals(w.render(),19);
    }

}