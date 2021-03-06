package model.player;

import model.EngiException;
import model.product.Product;
import model.product.sideproduct.SideProduct;
import model.product.sideproduct.beefomellete.BeefOmellete;
import model.product.sideproduct.plachicksoup.PlachickSoup;
import model.product.sideproduct.platycowpancake.PlatycowPancake;
import model.farmanimal.FarmAnimal;
import model.list.List;

public class Player {
    private static final int DEFWATER = 10;
    private static final int MAXWATER = 20;
    private static final int DEFMONEY = 0;
    private static final int MAXMONEY = 2000000;
    private static final int MAXBAG = 10;

    private int water; //menyimpan jumlah air yg dimiliki players
    private List<Product> inventory; //tas
    private long money; //menyimpang uang dari player

    public Player(){
        water = DEFWATER;
        money = DEFMONEY;
        inventory = new List(MAXBAG);
    }

    //menerima input Farm Animal
    //mencetak di layar suara animal tersebut
    public String talk(FarmAnimal f){
        return f.bersuara();
    }

    public void interactWell() throws EngiException{
        if (water<MAXWATER){
            water++;
        }else{
            EngiException e = new EngiException("Ember penuh");
            throw e;
        }
    }

    //melakukan mix bahan pada barang yang ditemukan di inverntory
    //mixer jenis 1 (chcken egg, cow meat) = beef omellete
    //mixer jenis 2 (platypus egg, cow milk) = platypus pancake
    //mixer jenis 3 (platypus milk, chicken meat) = plachick soup
    public void interactMixer() throws EngiException {
        boolean hasMix = false;

        //jika inventory kosong
        if (inventory.isEmpty()){
            throw new EngiException("Inventory kosong");
        }

        //mixer jenis 1 (chcken egg, cow meat) = beef omellete
        boolean found1 = false;
        boolean found2 = false;
        int idx1 = 0;
        int idx2 = 0;
        //cari chicken egg = 1
        while (idx1<=inventory.getLastIdx() && !found1){
            Product temp = inventory.getElmt(idx1);
            if (temp.getIdProduct()==1){
                found1 = true;
            }else{
                idx1++;
            }
        }
        //cari cowmeat = 3
        while (idx2<=inventory.getLastIdx() && !found2){
            Product temp = inventory.getElmt(idx2);
            if (temp.getIdProduct()==3){
                found2 = true;
            }else{
                idx2++;
            }
        }

        if(found1 && found2){
            hasMix = true;
            inventory.removeAt(idx1);
            inventory.removeAt(idx2);
            SideProduct omellete = new BeefOmellete();
            inventory.add(omellete);
        }

        //jika belom mix
        if(!hasMix){
            //mixer jenis 2 (platypus egg, cow milk) = platypus pancake
            found1 = false;
            found2 = false;
            idx1 = 0;
            idx2 = 0;
            //cari platypus egg = 5
            while (idx1<=inventory.getLastIdx() && !found1){
                Product temp = inventory.getElmt(idx1);
                if (temp.getIdProduct()==5){
                    found1 = true;
                }else{
                    idx1++;
                }
            }
            //cari cowmilk = 4
            while (idx2<=inventory.getLastIdx() && !found2){
                Product temp = inventory.getElmt(idx2);
                if (temp.getIdProduct()==4){
                    found2 = true;
                }else{
                    idx2++;
                }
            }

            if(found1 && found2){
                hasMix = true;
                inventory.removeAt(idx1);
                inventory.removeAt(idx2);
                SideProduct pancake = new PlatycowPancake();
                inventory.add(pancake);
            }
        }

        //jika belom mix
        if(!hasMix){
            //mixer jenis 3 (platypus milk, chicken meat) = plachick soup
            found1 = false;
            found2 = false;
            idx1 = 0;
            idx2 = 0;
            //cari platypus milk = 6
            while (idx1<=inventory.getLastIdx() && !found1){
                Product temp = inventory.getElmt(idx1);
                if (temp.getIdProduct()==6){
                    found1 = true;
                }else{
                    idx1++;
                }
            }
            //cari chickenmeat = 2
            while (idx2<=inventory.getLastIdx() && !found2){
                Product temp = inventory.getElmt(idx2);
                if (temp.getIdProduct()==2){
                    found2 = true;
                }else{
                    idx2++;
                }
            }

            if(found1 && found2){
                hasMix = true;
                inventory.removeAt(idx1);
                inventory.removeAt(idx2);
                SideProduct soup = new PlachickSoup();
                inventory.add(soup);
            }
        }
    }

    //hasil penjualan akan ditambahkan ke money
    //jika kapasitas money sudah penuh, maka akan ditambahkan hingga MAXMONEY
    public void interactTruck(){
        while(!inventory.isEmpty()){
            if(inventory.getElmt(inventory.getLastIdx()).getHarga() + money > MAXMONEY){
                money=MAXMONEY;
            }else{
                money+=inventory.getElmt(inventory.getLastIdx()).getHarga();
            }
            inventory.removeAt(inventory.getLastIdx());
        }
    }

    //menerima input Farm Animal
    //berinteraksi dengan milk dan egg producing animal
    //throw "Tidak bisa berinteraksi dengan meat producing animal" jika berinteraksi dengan meat producing animal
    //jika animal tidak lapar, akan mendapatkan prodcut
    //throw exception jika animal lapar
    //mendapatkan product jika inventory masih cukup
    //throw "Inventory penuh" jika inventory penuh
    public void interact(FarmAnimal f) throws EngiException{
        if(f.isMeat() && !f.isEgg() && !f.isMilk()){
            throw new EngiException("Tidak bisa berinteraksi dengan animal yang meat producing only");
        }else{
            if(inventory.getNEff() < MAXBAG){
                try{
                    inventory.add(f.getProduct(false));
                }catch (EngiException s){
                    throw s;
                }
            }else{
                throw new EngiException("Inventory penuh");
            }
        }
    }

    //menerima input Farm Animal
    //jika animal tidak lapar, akan mendapatkan prodcut
    //throw exception jika animal lapar
    //throw "Bukan meat producing animal" jika input bukan meat producing animal
    //throw "Inventory penuh" jika inventory penuh
    public void kill(FarmAnimal f) throws EngiException{
        if(inventory.getNEff() < MAXBAG){
            inventory.add(f.getProduct(true));
        }else{
            throw new EngiException("Inventory penuh");
        }
    }

    //mengurangi jumlah water jika water > 0
    //throw "Air tidak cukup" jika water
    public void grow() throws EngiException{
        if(water > 0){
            water--;
        }else{
            throw new EngiException("Air tidak cukup");
        }
    }

    //mengembalikan 22
    public int render(){
        return 22;
    }

    //mengembalikan nilai water
    public int getWater(){
        return water;
    }

    //mengembalikan jumlah uang player
    public long getMoney(){
        return money;
    }

    //mengembalikan isi tas player
    public List <Product> getInventory(){
        return inventory;
    }
}
