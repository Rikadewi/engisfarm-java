package test.model.player;

import model.EngiException;
import model.farmanimal.bull.Bull;
import model.farmanimal.chickenkampung.ChickenKampung;
import model.farmanimal.platypus.Platypus;
import model.player.Player;
import org.junit.Test;

import static org.junit.Assert.*;

public class PlayerTest {
    Player p = new Player();

    @Test
    public void playerTest(){
        System.out.println("Player Test");
        assertEquals(p.getWater(),10);
        assertEquals(p.getMoney(),0);
    }

    @Test
    public void talkTest(){
        System.out.println("Talk test");
        Bull b = new Bull();
        assertEquals(p.talk(b),b.bersuara());
        Platypus pl =new Platypus();
        assertEquals(p.talk(pl),pl.bersuara());
    }

    @Test
    public void interactTest(){
        System.out.println("Interact test");
        Bull b = new Bull();
        ChickenKampung c = new ChickenKampung();
        boolean err = false;
        try{
            p.interact(b);
        }catch (EngiException e){
            if(e.getMessage().equals("Tidak bisa berinteraksi dengan animal yang meat producing only")){
                err=true;
            }
        }
        assertTrue(p.getInventory().isEmpty());
        assertTrue(err);

        err=false;
        try{
            c.makan();
            p.interact(c);
        }catch (EngiException e){
            if(e.equals("Tidak bisa berinteraksi dengan animal yang meat producing only")){
                err=true;
            }
        }
        assertFalse(err);
    }


    @Test
    public void killTest(){
        System.out.println("Kill test");
        Bull b = new Bull();
        try{
            p.kill(b);
        }catch (EngiException e){

        }
        assertEquals(p.getInventory().getElmt(0).getID(),3);

        for(int i=1;i<10;i++){
            Bull b1 = new Bull();
            try{
                p.kill(b);
            }catch (EngiException e){

            }
        }

        boolean err = false;
        try{
            p.kill(b);
        }catch (EngiException e){
            if(e.getMessage().equals("Inventory penuh")){
                err = true;
            }
        }
        assertTrue(err);
    }
}

/*javac -cp /usr/share/java/junit4.jar model/EngiException.java model/farmanimal/FarmAnimal.java model/product/farmproduct/platypusmilk/PlatypusMilk.java model/product/farmproduct/platypusegg/PlatypusEgg.java model/product/Product.java model/product/farmproduct/FarmProduct.java model/farmanimal/platypus/Platypus.java test/model/player/PlayerTest.java model/farmanimal/bull/Bull.java model/farmanimal/chickenkampung/ChickenKampung.java model/player/Player.java model/product/sideproduct/SideProduct.java model/product/sideproduct/beefomellete/BeefOmellete.java model/product/sideproduct/plachicksoup/PlachickSoup.java model/product/sideproduct/platycowpancake/PlatycowPancake.java model/product/farmproduct/chickenegg/ChickenEgg.java model/product/farmproduct/chickenmeat/ChickenMeat.java model/product/farmproduct/cowmilk/CowMilk.java model/product/farmproduct/cowmeat/CowMeat.java model/list/List.java*/