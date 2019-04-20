package model.farmanimal;

import model.EngiException;
import model.product.farmproduct.FarmProduct;

public abstract class FarmAnimal implements Animal{
    public final int DEFAULTLIVINGTIME = 5;
    public final int DEFAULTHUNGRYTIME = 5;
    private boolean hungry;
    protected boolean hasProduct;
    private boolean hasMoved;
    protected boolean egg;
    protected boolean milk;
    protected boolean meat;
    private int livingTime;
    private int hungryTime;
    protected static int jumlah = 0;

    public FarmAnimal(){
        hungry = true;
	    hasProduct = false;
        hungryTime = DEFAULTHUNGRYTIME;
        livingTime = DEFAULTLIVINGTIME;
        jumlah++;
        hasMoved = false;
    }

    public void makan(){
        if (hungry){
            System.out.println("MAKAAAN");
            livingTime = DEFAULTLIVINGTIME;
            hasProduct = true;
            setHungry(false);
            hungryTime = DEFAULTHUNGRYTIME;
        }
    }

    public void setHungry(boolean hungry){
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
            hungryTime--;
            if(hungryTime ==0){
                hungry = true;
                livingTime = DEFAULTLIVINGTIME;
            }
        }
    }
    
    public void updateLivingTime(){
        if(hungry){
            livingTime--;
        }
    }
    
    public int getLivingTime(){
        return livingTime;
    }
    public abstract int getId();
    public abstract String bersuara();

    public boolean isEgg(){
        return egg;
    }
    public boolean isMilk(){
        return milk;
    }
    public boolean isMeat(){
        return meat;
    }
    public abstract FarmProduct getProduct(boolean bool) throws EngiException;
    public static int getJumlah(){ return jumlah; }
    public static void MinJumlah(){ jumlah--; }
}