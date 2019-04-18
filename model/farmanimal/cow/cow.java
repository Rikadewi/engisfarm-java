class Cow extends FarmAnimal{
    public Cow(){
        super.egg = false;
        super.milk = true;
        super.meat = true;
    }
	public String bersuara(){
        return "Moooo...";
    }
	public FarmProduct getProduct(boolean isKill){
        if (isKill){
            CowMeat meat;
            jumlah--;
            return meat;
        }
        else{
            if (super.hasProduct){
                CowMilk milk;
                hasProduct = false;
                return milk;
            }
            else
                throw "sapi ini tidak memiliki susu saat ini";
        }
    }
	public int getId(){
        if (super.isHungry())
            return 5;
        else
            return 6;
    }
}