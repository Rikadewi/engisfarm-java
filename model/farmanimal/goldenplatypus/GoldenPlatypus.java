package model.farmanimal.goldenplatypus;

import model.EngiException;
import model.farmanimal.FarmAnimal;
import model.product.farmproduct.FarmProduct;
import model.product.farmproduct.platypusegg.PlatypusEgg;
import model.product.farmproduct.platypusmilk.PlatypusMilk;

import java.util.Random;

public class GoldenPlatypus extends FarmAnimal {
    public GoldenPlatypus(){
        super.egg = true;
        super.milk = true;
        super.meat = false;
    }
	public String bersuara(){
        return "krrrrrrr...";
    }
	public FarmProduct getProduct(boolean isKill) throws EngiException {
        if (isKill){
            EngiException e = new EngiException("kamu tidak boleh membunuh seekor platypus");
            throw e;
        }
        else{
            if (super.hasProduct){
                Random rand = new Random();
                int n = rand.nextInt(2);
                if (n==0){
                    PlatypusEgg egg = new PlatypusEgg();
                    hasProduct = false;
                    return egg;
                }
                else{
                    PlatypusMilk milk = new PlatypusMilk();
                    hasProduct = false;
                    return milk;
                }
            }
            else{
                EngiException e = new EngiException("platypus ini tidak memiliki produk saat ini");
                throw e;
            }
        }
    }
	public int getId(){
        if (super.isHungry())
            return 7;
        else
            return 8;
    }
}