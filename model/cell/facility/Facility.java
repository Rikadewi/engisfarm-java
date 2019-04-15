//File : facility.h

// #include "cell.h"

// FacilityType  = well, mixer, truck 

package model.cell.facility;

import model.cell.Cell;
//TODO:
//import model.farmanimal.FarmAnimal;

//facility merupakan turunan dari cell
public abstract class Facility extends Cell{
    // mengembalikan NULL
    public FarmAnimal getAnimal(){
        return null;
    }
    //throw
    public void setAnimal(FarmAnimal f){
        throw "Can't set facility";
    }
}
