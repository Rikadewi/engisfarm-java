package model.product;

public class Product {
    //id 1..6 farmproduct 7..9 sideproduct
    //1 : chickenegg
    //2 : chickenmeat
    //3 : cowmeat
    //4 : cowmilk
    //5 : platypusegg
    //6 : platypusmilk
    //7 : beefomellete
    //8 : plachicksoup
    //9 : platycowpancake

    protected int id;
    protected int harga;

    public Product(int id, int harga){
        this.id = id;
        this.harga = harga;
    }

    public int getIdProduct(){
        return id;
    }

    public int getHarga(){
        return harga;
    }
}
