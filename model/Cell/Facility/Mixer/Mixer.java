//File : mixer.h

// #include "facility.h"
// #include "../../Product/Header/beefomellete.h"
// #include "../../Product/Header/chickenegg.h"
// #include "../../Product/Header/platypusegg.h"
// #include "../../Product/Header/chickenmeat.h"
// #include "../../Product/Header/cowmeat.h"
// #include "../../Product/Header/cowmilk.h"
// #include "../../Product/Header/platypusmilk.h"

//mixer merupakan turunan dari facility
class Mixer extends Facility{
    public Mixer(){}
    //mengembalikan int yang akan menjadi id 
    public int render(){
        return 20;
    }
    public void updateCell(String UpdateType){
        //do nothing
    }
    public void interactCell(){
        //do nothing
    }
}