//File: truck.h

// #include "facility.h"

//Truck merupakan turunan dari class Facility
class Truck extends Facility{
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
    public bool isAvailable(){
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
    public void interactCell(){
        if(isAvailable()){
            setNotReady();
        }else{
            throw "Truck tidak ada";
        }
    }
}
