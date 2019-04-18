//File : cell.java
// #include "../../farmanimal/Header/farmanimal.h"
// #include "../../Player/Header/player.h"

// CellType  = land, facility
// UpdateType = makan, grow, readyTruck, removeAnimal, checkAnimal, canMove
package model.cell;
import model.player.Player;
import model.farmanimal.FarmAnimal;

import model.EngiException;

public abstract class Cell{
    protected String cellType;
    protected Player engi;
    //0 untuk out of bound
    //1-12 untuk farm animal (ganjil laper, genap kenyang)
    //egg and milk producing? ada brpa?
    //1-2 Chicken Kampung -- egg, meat
    //3-4 ChickenJago -- Meat
    //5-6 Cow -- milk, meat
    //7-8 Golden Platypus -- egg,milk
    //9-10 Platypus -- egg,milk
    //11-12 Bull -- Meat
    //13-18 untuk land (ganjil tdk berumput, genap berumput)
    //13-14 Barn
    //15-16 Coop
    //17-18 GrassLand
    //19-21 untuk facility
    //19 untuk well
    //20 untuk mixer
    //21 untuk truck
    //22 untuk player
    public abstract int render();
    public String getType(){
        return cellType;
    }
    public abstract void updateCell(String updateType) throws EngiException;
    public void setType(String cellType){
        this.cellType = cellType;
    }
    public abstract FarmAnimal getAnimal();
    public Player getPlayer(){
        return engi;
    }
    public void setPlayer(Player p){
        engi = p;
    }
    public abstract void interactCell() throws EngiException;

    //throw "Can't set facility" jika type cell facility
    public abstract void setAnimal(FarmAnimal f) throws EngiException;
}