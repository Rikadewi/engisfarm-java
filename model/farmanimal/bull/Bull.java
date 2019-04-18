package model.farmanimal.bull;

import model.EngiException;
import model.farmanimal.FarmAnimal;
import model.product.farmproduct.FarmProduct;
import model.product.farmproduct.cowmeat.CowMeat;

public class Bull extends FarmAnimal{
    public Bull(){
        super.egg = false;
        super.milk = false;
        super.meat = true;
    }
	public String bersuara(){
        return "(Manly) Moooo...";
    }
	public FarmProduct getProduct(boolean isKill) throws EngiException {
        if (isKill){
            CowMeat meat = new CowMeat();
            return meat;
        }
        else{
            EngiException e = new EngiException("Bull tidak memiliki susu");
            throw e;
        }
    }
	public int getId(){
        if (super.isHungry())
            return 11;
        else
            return 12;
    }
}