class Bull extends FarmAnimal{
    public Bull(){
        super.egg = false;
        super.milk = false;
        super.meat = true;
    }
	public String bersuara(){
        return "(Manly) Moooo...";
    }
	public FarmProduct getProduct(boolean isKill){
        if (isKill){
            CowMeat meat;
            jumlah--;
            return meat;
        }
        else
            throw "Bull tidak memiliki susu";
    }
	public int getId(){
        if (super.isHungry())
            return 11;
        else
            return 12;
    }
}