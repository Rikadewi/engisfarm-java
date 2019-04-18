class ChickenKampung extends FarmAnimal{
    public ChickenJago(){
        super.egg = true;
        super.milk = false;
        super.meat = true;
    }
	public String bersuara(){
        return "kukuruyuuuuuk";
    }
	public FarmProduct getProduct(boolean isKill){
        if (isKill){
            ChickenMeat meat;
            jumlah--;
            return meat;
        }
        else{
            if (super.hasProduct){
                ChickenEgg egg;
                hasProduct = false;
                return egg;
            }
            else
                throw "ayam kampung ini tidak memiliki telur saat ini";
        }
    }
	public int getId(){
        if (super.isHungry())
            return 1;
        else
            return 2;
    }
}