//File : land.h

// #include "cell.h"
// #include "../../farmanimal/Header/farmanimal.h"

// LandType = barn, coop, grassLand

package model.cell.land;

import model.EngiException;
import model.cell.Cell;
import model.farmanimal.FarmAnimal;
import model.player.Player;

//implementasi kurangin farm animal
public class Land extends Cell {
    //true jika ada rumput
    private boolean rumput; 
    private FarmAnimal animal;
    private String landType;
    public Land () {}
    public Land (boolean rumput, FarmAnimal animal, String landType){
        this.rumput = rumput;
        this.animal = animal;
        this.landType = landType;
    }
    //mengembalikan char yang akan diprint
    public int render(){
        if(getPlayer() == null){
            if(getAnimal() == null){
                if(landType == "barn"){
                    if(isRumput()){
                        return 14;
                    }else{
                        return 13;
                    }
                }
    
                if(landType == "coop"){
                    if(isRumput()){
                        return 16;
                    }else{
                        return 15;
                    }
                }
                if(landType == "grassLand"){
                    if(isRumput()){
                        return 18;
                    }else{
                        return 17;
                    }
                }
            }else{
                return getAnimal().getId();
            }
        }
        else{
            return 22;
        }
        return -1;
    }
    public boolean isRumput(){
        return true;
    }
    public void setRumput(boolean b){
        rumput = b;
    }
    public String getType(){
        return landType;
    }
    public void setType(String landType){
        this.landType = landType;
    }
    public FarmAnimal getAnimal(){
        return animal;
    }
    public void setAnimal(FarmAnimal f){
        animal = f;
    }
    //menerima update untuk grow
    //menerima update untuk makan
    public void updateCell(String updateType) throws EngiException {
        if(updateType == "grow"){
            setRumput(true);
            Player P = getPlayer();
            try {
                P.grow();
            }catch (EngiException e){
                throw e;
            }
            return;
        }
        
        if(updateType == "makan"){
            FarmAnimal F = getAnimal();
            if(F != null){
                if(isRumput()){
                    if (F.isHungry()){
                        F.makan();
                        setRumput(false);
                    }
                }
            }
            return;
        }
    
        if (updateType == "removeAnimal"){
            FarmAnimal F = getAnimal();
            // farmanimal.Minjumlah()
            setAnimal(null);
            return;
        }
        
        if (updateType == "checkAnimal"){
            FarmAnimal F = getAnimal();
            if(F != null){
                F.updateLivingTime();
                F.updateHungryTime();
                if(F.getLivingTime() <= 0){
                    updateCell("removeAnimal");
                }
            }
            return;
        }
    
        if (updateType == "canMove"){
            FarmAnimal F = getAnimal();
            if(F != null){
                F.setMoved(false);
            }
            return;
        }
    }
    public void interactCell() throws EngiException {
        FarmAnimal F = getAnimal();
        Player P = getPlayer();
        if(F != null){
            try {
                P.interact(F);
            }catch (EngiException e){
                throw e;
            }

        }
    }
}
