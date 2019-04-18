package model.farmanimal.chickenjago;

import model.EngiException;
import model.farmanimal.FarmAnimal;
import model.product.farmproduct.FarmProduct;
import model.product.farmproduct.chickenmeat.ChickenMeat;

public class ChickenJago extends FarmAnimal {
    public ChickenJago(){
        super.egg = false;
        super.milk = false;
        super.meat = true;
    }
	public String bersuara(){
        return "kukuruyuuuuuk";
    }
	public FarmProduct getProduct(boolean isKill) throws EngiException {
        if (isKill){
            ChickenMeat meat = new ChickenMeat();
            return meat;
        }
        else{
            EngiException e = new EngiException("ChickenJago tidak memiliki telur");
            throw e;
        }
    }
	public int getId(){
        if (super.isHungry())
            return 3;
        else
            return 4;
    }
}