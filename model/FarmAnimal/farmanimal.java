abstract class FarmAnimal{
    public final int default_living_time = 5;
    public final int default_hungry_time = 5;
    private boolean hungry;
    protected boolean hasProduct;
    private boolean hasMoved;
    protected boolean egg;
    protected boolean milk;
    protected boolean meat;
    private int living_time;
    private int hungry_time;
    protected static int jumlah = 0;

    public FarmAnimal(){
        hungry = true;
	    hasProduct = false;
        hungry_time = default_hungry_time;
        living_time = default_living_time;
        jumlah++;
        hasMoved = false;
    }

    public void makan(){
        if (hungry){
            living_time = default_living_time;
            hasProduct = true;
            setHungry(false);
            hungry_time = default_hungry_time;
        }
    }

    public void setHungry(bool hungry){
        this.hungry = hungry;
    }
    //fungsi boolean isHungry mengembalikan true jika atribut hungry bernilai true
    public boolean isHungry(){
        return hungry;
    }
    public boolean getMoved(){
        return hasMoved;
    }
    public void setMoved(boolean moved){
        hasMoved = moved;
    }
    public void updateHungryTime(){
        if(!hungry){
            hungry_time--;
            if(hungry_time==0){
                hungry = true;
                living_time = default_living_time;
            }
        }
    }
    
    public void updateLivingTime(){
        if(hungry){
            living_time--;
        }
    }
    
    public int getLivingTime(){
        return living_time;
    }
}