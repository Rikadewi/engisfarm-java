//File : land.h

// #include "cell.h"
// #include "../../farmanimal/Header/farmanimal.h"

// LandType = barn, coop, grassLand

package model.cell.land;

import model.EngiException;
import model.cell.Cell;
import model.farmanimal.FarmAnimal;
import model.player.Player;
import java.util.LinkedList;

//implementasi kurangin farm animal
public class Land extends Cell {
    //true jika ada rumput
    private boolean rumput; 
    private FarmAnimal animal;
    private String landType;
    private static LinkedList<String> list_of_landType = new LinkedList<String>(){{add("barn"); add("coop"); add("grassland");}};
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
                if(landType.equals("barn")){
                    if(isRumput()){
                        return 14;
                    }else{
                        return 13;
                    }
                }
    
                if(landType.equals("coop")){
                    if(isRumput()){
                        return 16;
                    }else{
                        return 15;
                    }
                }
                if(landType.equals("grassLand")){
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
        return rumput;
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
        // setRumput(false);
        // System.out.println(updateType);
        if(updateType.equals("grow")){
            setRumput(true);
            Player P = getPlayer();
            try {
                P.grow();
            }catch (EngiException e){
                throw e;
            }
            return;
        }
        
        if(updateType.equals("makan")){
            // System.out.println("msk update cell makan");
            FarmAnimal F = getAnimal();
            if(F != null){
                if(isRumput()){
                    if (F.isHungry()){
                        F.makan();
                        setRumput(false);
                        // System.out.println("selesai makan");
                    }
                }
            }
            return;
        }
    
        if (updateType.equals("removeAnimal")){
            FarmAnimal F = getAnimal();
            FarmAnimal.MinJumlah();
            setAnimal(null);
            return;
        }
        
        if (updateType.equals("checkAnimal")){
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
    
        if (updateType.equals("canMove")){
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
