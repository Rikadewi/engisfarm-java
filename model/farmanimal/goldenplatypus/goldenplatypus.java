import java.util.Random;

class GoldenPlatypus extends FarmAnimal{
    public GoldenPlatypus(){
        super.egg = true;
        super.milk = true;
        super.meat = false;
    }
	public String bersuara(){
        return "krrrrrrr...";
    }
	public FarmProduct getProduct(boolean isKill){
        if (isKill){
            throw "kamu tidak boleh membunuh seekor platypus";
        }
        else{
            if (super.hasProduct){
                Random rand = new Random();
                int n = rand.nextInt(2);
                if (n==0){
                    PlatypusEgg egg;
                    hasProduct = false;
                    return egg;
                }
                else{
                    PlatypusMilk milk;
                    hasProduct = false;
                    return milk;
                }
            }
            else
                throw "platypus ini tidak memiliki produk saat ini";
        }
    }
	public int getId(){
        if (super.isHungry())
            return 7;
        else
            return 8;
    }
}