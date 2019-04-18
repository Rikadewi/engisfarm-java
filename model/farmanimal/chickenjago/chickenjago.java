class ChickenJago extends FarmAnimal{
    public ChickenJago(){
        super.egg = false;
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
        else
            throw "ChickenJago tidak memiliki telur";
    }
	public int getId(){
        if (super.isHungry())
            return 3;
        else
            return 4;
    }
}