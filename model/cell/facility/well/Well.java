//File : well.h

// #include "facility.h"

package model.cell.facility.well;

import model.cell.facility.Facility;
//TODO:
//import model.cell.player.Player;

//Well merupakan turunan dari facility
public class Well extends Facility{
    public Well(){}
    //mengembalikan char yang akan diprint
    public int render(){
        return 19;
    }
    public void updateCell(String updateType){
        //do nothing
    }
    public void interactCell(){
        engi.interactWell();
    }
}