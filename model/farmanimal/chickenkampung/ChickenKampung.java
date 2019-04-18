package model.farmanimal.chickenkampung;

import model.EngiException;
import model.farmanimal.FarmAnimal;
import model.product.farmproduct.FarmProduct;
import model.product.farmproduct.chickenegg.ChickenEgg;
import model.product.farmproduct.chickenmeat.ChickenMeat;

public class ChickenKampung extends FarmAnimal {
    public ChickenKampung(){
        super.egg = true;
        super.milk = false;
        super.meat = true;
    }
	public String bersuara(){
        return "kukuruyuuuuuk";
    }
	public FarmProduct getProduct(boolean isKill) throws EngiException {
        if (isKill){
            ChickenMeat meat = new ChickenMeat();
            jumlah--;
            return meat;
        }
        else{
            if (super.hasProduct){
                ChickenEgg egg = new ChickenEgg();
                hasProduct = false;
                return egg;
            }
            else{
                EngiException e = new EngiException("ayam kampung ini tidak memiliki telur saat ini");
                throw e;
            }
        }
    }
	public int getId(){
        if (super.isHungry())
            return 1;
        else
            return 2;
    }
}