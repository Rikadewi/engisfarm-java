package model.farmanimal.cow;

import model.EngiException;
import model.farmanimal.FarmAnimal;
import model.product.farmproduct.FarmProduct;
import model.product.farmproduct.cowmeat.CowMeat;
import model.product.farmproduct.cowmilk.CowMilk;

public class Cow extends FarmAnimal {
    public Cow(){
        super.egg = false;
        super.milk = true;
        super.meat = true;
    }
	public String bersuara(){
        return "Moooo...";
    }
	public FarmProduct getProduct(boolean isKill) throws EngiException {
        if (isKill){
            CowMeat meat = new CowMeat();
            jumlah--;
            return meat;
        }
        else{
            if (super.hasProduct){
                CowMilk milk = new CowMilk();
                hasProduct = false;
                return milk;
            }
            else {
                EngiException e = new EngiException("sapi ini tidak memiliki susu saat ini");
                throw e;
            }
        }
    }
	public int getId(){
        if (super.isHungry())
            return 5;
        else
            return 6;
    }
}