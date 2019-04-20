package model.list;

import model.EngiException;

//import java.lang.reflect.Array;

public class List<Type> {
    
    private Type []data;
    private int size;
    private int nEff;
    private static final int IDXMIN =0;
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
        nEff =0;
        data = (Type[]) new Object[size];
    }

    public List(int _size){
        size = _size;
        nEff =0;
        data = (Type[]) new Object[size];
    }

        //Services
    public boolean isEmpty() {
        return (nEff == 0);
    }
    public boolean isFull() {
        return (nEff == size);
    }

    public void add(Type x) throws EngiException {
        try
        {    
            if(size > nEff){
                data[nEff] = x;
                nEff++;
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
        nEff--;
    }


    //jika tidak ditermukan kembalikan -1
    public int find(Type elmt) throws EngiException{
        boolean found = false;
        int i=0;
        while(!found && i<nEff){
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
    public int getNEff(){
        return nEff;
    }
    public int getFirstIdx(){
        return IDXMIN;
    }
    public int getLastIdx() {
        if(nEff > 0)
            return nEff-1;
        else
            return 0;
    }
}