//File : well.h

// #include "facility.h"

package model.cell.facility.well;

//Well merupakan turunan dari facility
class Well extends Facility{
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