//File: truck.h

// #include "facility.h"

package model.cell.facility.truck;

import model.cell.facility.Facility;
import model.EngiException;

//truck merupakan turunan dari class facility
public class Truck extends Facility{
    //melambangkan seberapa lama lagi hingga truck bisa dipakai
    private int ready;

    public static final int MAXREADY = 5;
    public Truck(){
        ready = 0;
    }
    public void setNotReady(){
        ready = MAXREADY;
    }
    //mengembalikan char yang akan diprint pada map
    public int render(){
        return 21;
    }
    //mengembalikan true jika truck bisa dipakai
    public boolean isAvailable(){
        return (ready<=0);
    }
    //Untuk update keadaan truck
    public void updateCell(String updateType){
        if (updateType == "readyTruck"){
            if(ready>0){
                ready--;
            }
        }
    }
    public void interactCell() throws EngiException {
        if(isAvailable()){
            setNotReady();
        }else{
            EngiException e = new EngiException("Truck tidak ada");
            throw e;
        }
    }
}
