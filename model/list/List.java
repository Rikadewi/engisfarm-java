package model.list;

import model.EngiException;

//import java.lang.reflect.Array;

public class List<Type> {
    
    private Type []data;
    private int size;
    private int Neff;
    private static final int IdxMin =0;
    private static final int MAXSIZE =256;

//    public List(){
//        size = MAXSIZE;
//        Neff = 0;
////        @SuppressWarnings("unchecked"
//        data =  (Type[]) new Object[MAXSIZE];
////        final Type[] data = (Type[]) Array.newInstance(c,size);
////        this.data = data;
//    }

//    public List(Class<Type> c, int _size){
//        size = _size;
//        Neff = 0;
//        @SuppressWarnings("unchecked")
//        final Type[] data = (Type[]) Array.newInstance(c,size);
//        this.data = data;
//    }
    public List(){
        size = MAXSIZE;
        Neff =0;
        data = (Type[]) new Object[size];
    }

    public List(int _size){
        size = _size;
        Neff =0;
        data = (Type[]) new Object[size];
    }

        //Services
    public boolean isEmpty() {
        return (Neff == 0);
    }
    public boolean isFull() {
        return (Neff == size);
    }

    public void add(Type X) throws EngiException {
        try
        {    
            if(size > Neff){
                data[Neff] = X;
                Neff++;
            }
            else {
                throw new EngiException("List penuh, tidak dapat menambahkan objek baru") ;
            }
        }
        catch(EngiException e)
        {
            throw e;
        }
    }

    public void remove(Type elmt) throws EngiException {
        removeAt(find(elmt));
    }        

    public void removeAt(int idx){
        //MENGGESER SETIAP ELEMENT
        for(int i=idx; i<getLastIdx(); i++){
            data[i] = data[i+1];
        }
        Neff--;
    }


    //jika tidak ditermukan kembalikan -1
    public int find(Type elmt) throws EngiException{
        boolean found = false;
        int i=0;
        while(!found && i<Neff){
            if(data[i] == elmt){
                found = true;
            }
            else {
                i++;
            }
        }
        if (found){
            return i;
        }
        else{
            throw new EngiException("Tidak Ditemukan Objek");
        }
    }
    
    public Type getElmt(int i){
        return data[i];
    }
    public int getSize(){
        return size;
    }
    public int getNeff(){
        return Neff;
    }
    public int getFirstIdx(){
        return IdxMin;
    }
    public int getLastIdx() {
        if(Neff > 0)
            return Neff-1;
        else
            return 0;
    }
}