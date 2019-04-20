//#include<iostream>
//#include "gameengine.h"
//#include <ostream>
//#include <cstdlib>
//using namespace std;
package controller;

import model.EngiException;
import model.cell.Cell;
import model.cell.facility.mixer.Mixer;
import model.cell.facility.truck.Truck;
import model.cell.facility.well.Well;
import model.cell.land.Land;
import model.farmanimal.*;
import model.farmanimal.bull.Bull;
import model.farmanimal.chickenjago.ChickenJago;
import model.farmanimal.chickenkampung.ChickenKampung;
import model.farmanimal.cow.Cow;
import model.farmanimal.goldenplatypus.GoldenPlatypus;
import model.farmanimal.platypus.Platypus;
import model.player.Player;
import model.product.Product;
import model.list.List;
import java.util.ArrayList;
import java.util.Vector;
import java.util.Stack;
import java.util.Random;

// import com.sun.org.apache.xpath.internal.operations.String;

public class GameEngine {

    public static final int WORLDSIZE = 10;
    private Cell[][] world;
    private int tick;
    private int xPlayer;
    private int yPlayer;
    private int animals;

    public Cell[][] getWorld() {
        return world;
    }

    public int getXPlayer() {
        return xPlayer;
    }

    public int getYPlayer() {
        return yPlayer;
    }

    public Player getEngi() {
        return world[xPlayer][yPlayer].getPlayer();
    }

    public GameEngine() throws EngiException {
        tick = 0;
        xPlayer = 5;
        yPlayer = 5;
        animals = 10;
        world = new Cell[WORLDSIZE][WORLDSIZE];

        //Inisialisasi dunia dan set semua petak menjadi graassland berumput
        for (int i = 0; i < WORLDSIZE; i++) {
            for (int j = 0; j < WORLDSIZE; j++) {
                {
                    world[i][j] = new Land(true, null, "grassLand");
                }
            }
        }

        //Menetapkan Player
        world[xPlayer][yPlayer].setPlayer(new Player());

        //Menetapkan Coop
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                world[i][j] = new Land(true, null, "coop");
            }
        }

        for (int i = 0; i < 5; i++) {
            for (int j = 5; j < 10; j++) {
                world[i][j] = new Land(true, null, "barn");
            }
        }

        //Menetapkan Facility
        world[7][9] = new Mixer();
        world[8][9] = new Well();
        world[9][9] = new Truck();

        //Menetapkan Animal di coop
        try {
            world[0][0].setAnimal(new ChickenKampung());
            world[1][1].setAnimal(new ChickenKampung());
            world[2][2].setAnimal(new Platypus());
            world[3][3].setAnimal(new Platypus());

            //Menetapkan Animal di barn
            world[0][6].setAnimal(new ChickenJago());
            world[0][7].setAnimal(new ChickenJago());
            world[2][8].setAnimal(new Bull());
            world[2][9].setAnimal(new Bull());

            //Menetapkan ANimal di Grassland
            world[8][3].setAnimal(new Cow());

            world[9][2].setAnimal(new GoldenPlatypus());

        } catch (EngiException e) {
            throw e;
        }
    }

    public int look(int i, int j) {
        if (i >= 0 && i < 10 && j >= 0 && j < 10) {
            return world[i][j].render();
        } else {
            return 0;
        }
    }

    // TUNGGU IMPLEMENTASI JAVA LIST
    public Vector<Integer> lookAround(int x, int y) throws EngiException {
        Vector<Integer> around = new Vector<Integer>();
        //lihat objek utara (x-1)(y)
        around.add(look(x - 1, y));
        //lihat objek timur (x)(y+1)
        around.add(look(x, y + 1));
        //lihat objek selatan (x+1)(y)
        around.add(look(x + 1, y));
        //lihat objek barat (x)(y-1)
        around.add(look(x, y - 1));
        return around;
    }

    // TUNGGU IMPLEMENTASI JAVA LIST
    public void handleInteract() throws EngiException {
        //Mendapatkan list yang berisi objek disekitarnya
        // cout << "pass1\n";
        Vector<Integer> around = lookAround(xPlayer, yPlayer);
        boolean foundAnimal = false;
        boolean foundFacility = false;
        int i = 0;
        int pos = -1;
        int x = xPlayer;
        int y = yPlayer;
        // cout << "pass2\n";
        while (!foundAnimal && !foundFacility && (i < 4)) {
            //jika animal
            if (around.get(i) >= 1 && around.get(i) <= 10) {
                foundAnimal = true;
            } else if (around.get(i) >= 19 && around.get(i) <= 21) { //facility
                foundFacility = true;
                pos = i;
            } else {
                i++;
            }
        }

        if (foundAnimal) {

            if (i == 0) {//interact animal utara
                FarmAnimal temp = world[xPlayer - 1][yPlayer].getAnimal();
                getEngi().interact(temp);

            } else if (i == 1) { //interact animal timur
                FarmAnimal temp = world[xPlayer][yPlayer + 1].getAnimal();
                getEngi().interact(temp);
            } else if (i == 2) { //interact animal selatan
                FarmAnimal temp = world[xPlayer + 1][yPlayer].getAnimal();
                getEngi().interact(temp);

            } else if (i == 3) { //interact animal barat
                FarmAnimal temp = world[xPlayer][yPlayer - 1].getAnimal();
                getEngi().interact(temp);
            }

        }

        if (foundFacility) {
            if (around.get(i) == 19) {//well
                getEngi().interactWell();
            } else if (around.get(i) == 20) {//mixer
                getEngi().interactMixer();
            } else if (around.get(i) == 21) {//truck

                if (pos == 0) x = xPlayer - 1;
                if (pos == 1) y = yPlayer + 1;
                if (pos == 2) x = xPlayer + 1;
                if (pos == 3) y = yPlayer - 1;
                try {
                    world[x][y].interactCell();
                    getEngi().interactTruck();
                } catch (EngiException e) {
                    throw e;
                }

            }
        }
    }

    boolean moveAnimal(FarmAnimal f, Vector<Integer> around, int i) {
        boolean found = false;
        //penghasil telur move bisa ke coop 15 16
        if (f.isEgg()) {
            if (around.get(i) == 15 || around.get(i) == 16) {
                found = true;
            }
        }
        //penghasil daging move bisa ke barn 13 14
        if (f.isMeat()) {
            if (around.get(i) == 13 || around.get(i) == 14) {
                found = true;
            }
        }
        //move bisa ke grassland 17 18
        if (f.isMilk()) {
            if (around.get(i) == 17 || around.get(i) == 18) {
                found = true;
            }
        }
        return found;
    }

    public void handleMoveAnimal(int x, int y) throws EngiException {
        Vector<Integer> around = lookAround(x, y);
        FarmAnimal f = world[x][y].getAnimal();
        if (f != null) {
            if (!f.getMoved()) {
                boolean found = false;
                int i = 0;
                while (!found && i < 4) {
                    Random rand = new Random();
                    int n = rand.nextInt(100);
                    n = n % 4;
                    if (n == 0 && moveAnimal(f, around, 0)) {//utara (x-1)(y)
                        world[x][y].setAnimal(null);
                        world[x - 1][y].setAnimal(f);
                        found = true;
                    } else if (n == 1 && moveAnimal(f, around, 1)) { //timur (x)(y+1)
                        world[x][y].setAnimal(null);
                        world[x][y + 1].setAnimal(f);
                        found = true;
                    } else if (n == 2 && moveAnimal(f, around, 2)) {//selatan (x+1)(y)
                        world[x][y].setAnimal(null);
                        world[x + 1][y].setAnimal(f);
                        found = true;
                    } else if (n == 3 && moveAnimal(f, around, 3)) {//barat (x)(y-1)
                        world[x][y].setAnimal(null);
                        world[x][y - 1].setAnimal(f);
                        found = true;
                    } else {
                        i++;
                    }
                }
                if (!found) {
                    EngiException e = new EngiException("Ada animal yang stuck!");
                    throw e;
                } else {
                    f.setMoved(true);
                }
            }
        }
    }

    public void handleMove(int n) throws EngiException {
        Vector<Integer> around = lookAround(xPlayer, yPlayer);
        boolean found = false;
        int i = 0;
        Player P = getEngi();
        if (n == 1) {//atas
            if ((around.get(0)) >= 13 && (around.get(0)) <= 18) {
                world[xPlayer][yPlayer].setPlayer(null);
                xPlayer--;
                world[xPlayer][yPlayer].setPlayer(P);
            } else {
                EngiException e = new EngiException("Tidak dapat melakukan move");
                throw e;
            }
        } else if (n == 2) {//kanan
            if ((around.get(1)) >= 13 && (around.get(1)) <= 18) {
                world[xPlayer][yPlayer].setPlayer(null);
                yPlayer++;
                world[xPlayer][yPlayer].setPlayer(P);
            } else {
                EngiException e = new EngiException("Tidak dapat melakukan move");
                throw e;
            }
        } else if (n == 3) {//bawah
            if ((around.get(2)) >= 13 && (around.get(2)) <= 18) {
                world[xPlayer][yPlayer].setPlayer(null);
                xPlayer++;
                world[xPlayer][yPlayer].setPlayer(P);
            } else {
                EngiException e = new EngiException("Tidak dapat melakukan move");
                throw e;
            }
        } else if (n == 4) {//kiri
            if ((around.get(3)) >= 13 && (around.get(3)) <= 18) {
                world[xPlayer][yPlayer].setPlayer(null);
                yPlayer--;
                world[xPlayer][yPlayer].setPlayer(P);
            } else {
                EngiException e = new EngiException("Tidak dapat melakukan move");
                throw e;
            }
        }
    }

    public void handleGrow() throws EngiException {
        world[getXPlayer()][getYPlayer()].updateCell("grow");
    }

    public String handleTalk() throws EngiException {
        Vector<Integer> around = lookAround(xPlayer, yPlayer);
        String s;
        if (around.get(0) >= 1 && around.get(0) <= 12) {
            FarmAnimal temp = world[xPlayer - 1][yPlayer].getAnimal();
            s = getEngi().talk(temp);
            return s;
        } else if (around.get(1) >= 1 && around.get(1) <= 12) {
            FarmAnimal temp = world[xPlayer][yPlayer + 1].getAnimal();
            s = getEngi().talk(temp);
            return s;
        } else if (around.get(2) >= 1 && around.get(2) <= 12) {
            FarmAnimal temp = world[xPlayer + 1][yPlayer].getAnimal();
            s = getEngi().talk(temp);
            return s;
        } else if (around.get(3) >= 1 && around.get(3) <= 12) {
            FarmAnimal temp = world[xPlayer][yPlayer - 1].getAnimal();
            s = getEngi().talk(temp);
            return s;
        } else {
            EngiException e = new EngiException("sedang ngomong sendiri");
            throw e;
        }
    }

    public void handleKill() throws EngiException {
        Vector<Integer> around = lookAround(xPlayer, yPlayer);
        boolean hasKill = false;
        int i = 0;
        while (!hasKill && i < 4) {
            //penghasil daging id = 1 2 3 4 5 6 11 12
            if ((around.get(i) >= 1 && around.get(i) <= 6) || around.get(i) == 11 || around.get(i) == 12) {
                hasKill = true;
            } else {
                i++;
            }
        }
        if (i == 0) {//kill animal utara
            FarmAnimal temp = world[xPlayer - 1][yPlayer].getAnimal();
            getEngi().kill(temp);
            world[xPlayer - 1][yPlayer].updateCell("removeAnimal");

        } else if (i == 1) { //kill animal timur
            FarmAnimal temp = world[xPlayer][yPlayer + 1].getAnimal();
            getEngi().kill(temp);
            world[xPlayer][yPlayer + 1].updateCell("removeAnimal");
        } else if (i == 2) { //kill animal selatan
            FarmAnimal temp = world[xPlayer + 1][yPlayer].getAnimal();
            getEngi().kill(temp);
            world[xPlayer + 1][yPlayer].updateCell("removeAnimal");

        } else if (i == 3) { //kill animal barat
            FarmAnimal temp = world[xPlayer][yPlayer - 1].getAnimal();
            getEngi().kill(temp);
            world[xPlayer][yPlayer - 1].updateCell("removeAnimal");
        }

    }

    public int getID(int i, int j) {
        return world[i][j].render();
    }

    /* FUNGSI UPDATE */
    public void updateGame() throws EngiException {
        tick++;
        //Menggerakan animal
        animals = 0;
        for (int i = 0; i < WORLDSIZE; i++) {
            for (int j = 0; j < WORLDSIZE; j++) {
                if (getID(i, j) < 13) { //Jika merupakan animal

                    world[i][j].updateCell("checkAnimal");
                    //Bikin Animal tsb makan
                    world[i][j].updateCell("makan");
                    //kurangin living time, sekaligus bunuh yang mati
                    if (world[i][j].getAnimal() != null) {
                        //Gerakan Animal Tsb
                        handleMoveAnimal(i, j);
                    }
                    animals = world[i][j].getAnimal().getJumlah();
                } else if (getID(i, j) == 21) { //Jika merupakan truck
                    //Ubah keadaan trucknya
                    world[i][j].updateCell("readyTruck");
                }
                //Kasus lain???
            }
        }

        //mengeset hewan untuk bisa move
        for (int i = 0; i < WORLDSIZE; i++) {
            for (int j = 0; j < WORLDSIZE; j++) {
                if (getID(i, j) < 13) { //Jika merupakan animal
                    //Bikin Animal bisa move
                    world[i][j].updateCell("canMove");
                }
            }
        }
    }
    
        public void renderer(int n){
        switch (n)
        {
            case 0 : //Out of Bounds

                break;
            case 1 : //Chicken Kampung
                System.out.print( "\033[31;46m" + "CK" + "\033[0m"); //Print Kotak background Magenta
                break;
            case 2 :
                System.out.print( "\033[30;46m" + "CK" + "\033[0m"); //Print Kotak background Magenta
                break;
            case 3 : //Chicken Jago
                System.out.print( "\033[31;46m" + "CJ" + "\033[0m"); //Print Kotak background Magenta
                break;
            case 4 :
                System.out.print( "\033[30;46m" + "CJ" + "\033[0m"); //Print Kotak background Magenta
                break;
            case 5 : //Cow
                System.out.print( "\033[31;46m" + "CO" + "\033[0m"); //Print Kotak background Magenta
                break;
            case 6 :
                System.out.print( "\033[30;46m" + "CO" + "\033[0m"); //Print Kotak background Magenta
                break;
            case 7 : // Golden Platypus
                System.out.print( "\033[31;46m" + "GP" + "\033[0m"); //Print Kotak background Magenta
                break;
            case 8 :
                System.out.print( "\033[30;46m" + "GP" + "\033[0m"); //Print Kotak background Magenta
                break;
            case 9 : // Platypus
                System.out.print( "\033[31;46m" + "PL" + "\033[0m"); //Print Kotak background Magenta
                break;
            case 10 :
                System.out.print( "\033[30;46m" + "PL" + "\033[0m"); //Print Kotak background Magenta
                break;
            case 11 : //Bull
                System.out.print( "\033[31;46m" + "BL" + "\033[0m"); //Print Kotak background Magenta teks merah
                break;
            case 12 :
                System.out.print( "\033[30;46m" + "BL" + "\033[0m"); //Print Kotak background Magenta teks item
                break;
            case 13 : //Barn
                System.out.print( "\033[30;43;1m" + 'B' + " \033[0m"); //Print Kotak Background kuning
                break;
            case 14 :
                System.out.print( "\033[30;42;1m" + 'B' + " \033[0m"); //Print Kotak background Hijau
                break;
            case 15 : //Coop
                System.out.print( "\033[30;43;1m" + 'C' + " \033[0m"); //Print Kotak background Kuning
                break;
            case 16 :
                System.out.print( "\033[30;42;1m" + 'C' + " \033[0m"); //Print Kotak background Hijau
                break;
            case 17: //GrassLand Ga Berumput
                System.out.print( "\033[30;43;1m" + 'G' + " \033[0m"); //Print Kotak background Kuning
                break;
            case 18: //GrassLand Berumput
                System.out.print( "\033[42;1m" + 'G' + " \033[0m"); //Print Kotak background Hijau
                break;
            case 19 : //Well
                System.out.print( "\033[37;44m" + 'W' + " \033[0m"); //Print Kotak background Hijau
                break;
            case 20 : //Mixer
                System.out.print( "\033[37;44m" + 'M' + " \033[0m"); //Print Kotak background Hijau
                break;
            case 21 : //Truck
                System.out.print( "\033[37;44m" + 'T' + " \033[0m" );//Print Kotak background Hijau
                break;
            case 22 : //player
                System.out.print( "\033[31;1;42m" + 'P' + " \033[0m"); //Print Kotak background Hijau
                break;
            default:
                break;
        }
    }
//Fungsi untuk print Map
   public void printMap(){
           for (int i = 0; i<WORLDSIZE; i++){
                   for(int j=0; j<WORLDSIZE; j++){
                           renderer(getID(i,j));
                       }
                       System.out.print(" "); //Kasih Spasi
                       printKeterangan(i);
                       System.out.println();
                   }
    }

    public void printMessage(String msg) {
       System.out.println( msg);
   }
//
   public void printKeterangan(int n){
           switch (n)
           {
                   case 0:
                       System.out.print( "Legend :");
                       break;
                   case 1:
                       System.out.print( "");
                       break;
                   case 2:
                       System.out.print( "Hewan Text Hitam: Kenyang | Hewan Text Merah: Lapar");
                       break;
                   case 3:
                       System.out.print( "Land Background Hijau: Ada Rumput | Land Background Kuning: Tidak ada rumput");
                       break;
                   case 4:
                       System.out.print( "P: Player");
                       break;
                   case 5:
               System.out.print( "W: Well | M: Mixer | T: Truck");
               break;
           case 6:
               System.out.print( "G: GrassLand | C: Coop | B: Barn");
               break;
           case 7:
               System.out.print( "CK: Chicken Kampung");
               break;
           case 8:
               System.out.print( "CJ: Chicken Jago");
               break;
           case 9:
               System.out.print( "CO: Cow");
               break;
           case 10:
               System.out.print( "GP: Golden Platypus");
               break;
           case 11:
               System.out.print( "PL: Platypus");
               break;
           case 12:
               System.out.print( "BL: Bull");
               break;
           default:
               break;
       }
   }

    public ArrayList getInventoryList(){
        ArrayList<String> retList = new ArrayList<String>();
        List <Product>  productList = getEngi().getInventory();
        for(int i = 0; i< productList.getNeff(); i++){
            switch (productList.getElmt(i).getID()){
                    case 1 : retList.add("ChickenEgg"); break;
                    case 2 : retList.add( "ChickenMeat"); break;
                    case 3 : retList.add( "CowMeat"); break;
                    case 4 : retList.add( "CowMilk"); break;
                    case 5 : retList.add( "PlatypusEgg"); break;
                    case 6 : retList.add( "PlatypusMilk"); break;
                    case 7 : retList.add( "BeefOmellete"); break;
                    case 8 : retList.add( "PlaChickSoup"); break;
            }
        }
        return retList;
        
    }

   public void printKeadaan(String Name){
       System.out.println( "Ticks : " + tick );
       System.out.println( "Nama Player :" + Name );
       System.out.println( "Water : " + getEngi().getWater() );
       System.out.println( "Money : " + getEngi().getMoney() );
       System.out.println( "Jumlah Animal : " + animals);
       System.out.print("Inventory : ");
       List <Product>  productList = getEngi().getInventory();
       for(int i = 0; i< productList.getNeff(); i++){
               switch (productList.getElmt(i).getID())
               {
                       case 1 : System.out.print( "ChickenEgg"); break;
               case 2 : System.out.print( "ChickenMeat"); break;
               case 3 : System.out.print( "CowMeat"); break;
               case 4 : System.out.print( "CowMilk"); break;
               case 5 : System.out.print( "PlatypusEgg"); break;
               case 6 : System.out.print( "PlatypusMilk"); break;
               case 7 : System.out.print( "BeefOmellete"); break;
               case 8 : System.out.print( "PlaChickSoup"); break;
               default:
                   break;
           }
           if (i != productList.getLastIdx()){
                   System.out.print( ", ");
               }
           else {
               System.out.println();
           }
       }
       System.out.println();

   }


   public int getanimals(){
           return animals;
    }
    
}