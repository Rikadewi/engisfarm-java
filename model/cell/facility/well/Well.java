//File : well.h

// #include "facility.h"

package model.cell.facility.well;
import model.EngiException;
import model.cell.facility.Facility;

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
    public void interactCell() throws EngiException {
        try {
            engi.interactWell();
        }
        catch (EngiException e){
            throw e;
        }
    }
}