package test.model.list;

import model.EngiException;
import model.list.List;
import org.junit.Test;

import static org.junit.Assert.*;

public class ListTest {
    @Test
    public void listTest(){
        System.out.println("List test");
        List<Integer> l = new List<Integer>();
        assertEquals(l.getSize(),256);
        assertEquals(l.getNEff(),0);
    }

    @Test
    public void listSizeTest(){
        System.out.println("List Size test");
        List<Integer> l = new List<Integer>(5);
        assertEquals(l.getSize(),5);
        assertEquals(l.getNEff(),0);
    }

    @Test
    public void isEmptyTest(){
        System.out.println("isEmpty Test");
        List<Integer> l = new List<Integer>();
        assertTrue(l.isEmpty());
        try{
            l.add(2);
        }catch (EngiException e){

        }
        assertFalse(l.isEmpty());
    }

    @Test
    public void isFullTest(){
        System.out.println("isFull Test");
        List<Integer> l = new List<Integer>(10);
        assertFalse(l.isFull());
        for(int i=0;i<10;i++){
            try{
                l.add(i);
            }catch (EngiException e){

            }
        }
        assertTrue(l.isFull());
    }

    @Test
    public void addTest(){
        System.out.println("Add Test");
        List<Integer> l = new List<Integer>();
        try{
            l.add(2);
        }catch (EngiException e){
        }
        int x = l.getElmt(0);
        assertEquals(x,2);
    }

    @Test
    public void removeTest(){
        System.out.println("Remove Test");
        List<Integer> l = new List<Integer>();
        try{
            l.add(2);
            l.add(3);
        }catch (EngiException e){
        }
        try{
            l.remove(2);
        }catch (EngiException e){
        }
        int x = l.getElmt(0);
        assertEquals(x,3);
        assertEquals(l.getNEff(),1);
    }

    @Test
    public void removeAtTest(){
        System.out.println("RemoveAt Test");
        List<Integer> l = new List<Integer>();
        try{
            l.add(2);
            l.add(3);
            l.add(4);
        }catch (EngiException e){
        }
        l.removeAt(2);
        int x = l.getElmt(0);
        assertEquals(x,2);
        assertEquals(l.getNEff(),2);
    }

    @Test
    public void findTest(){
        System.out.println("Find Test");
        List<Integer> l = new List<Integer>();
        try{
            l.add(2);
            l.add(3);
        }catch (EngiException e){
        }

        int x=-5;
        try {
            x=l.find(2);
        }catch (EngiException e){
        }
        assertEquals(x,0);

        boolean err = false;
        try {
            l.find(4);
        }catch (EngiException e){
            if(e.getMessage().equals("Tidak Ditemukan Objek")){
                err=true;
            }
        }
        assertTrue(err);
    }

    @Test
    public void getElmtTest(){
        System.out.println("GetElmt Test");
        List<Integer> l = new List<Integer>();
        try{
            l.add(2);
            l.add(3);
        }catch (EngiException e){
        }
        int x = l.getElmt(0);
        int y = l.getElmt(1);
        assertEquals(x,2);
        assertEquals(y,3);
    }

    @Test
    public void getSizeTest(){
        System.out.println("GetSize Test");
        List<Integer> l1 = new List<Integer>(10);
        List<Integer> l2 = new List<Integer>(20);
        assertEquals(l1.getSize(),10);
        assertEquals(l2.getSize(),20);
    }

    @Test
    public void getNEffTest(){
        System.out.println("GetNeff Test");
        List<Integer> l = new List<Integer>();
        assertEquals(l.getNEff(),0);
        try{
            l.add(2);
            l.add(3);
        }catch (EngiException e){
        }
        assertEquals(l.getNEff(),2);
    }

    @Test
    public void getFirstIdxTest(){
        System.out.println("GetFirstIdx Test");
        List<Integer> l = new List<Integer>();
        try{
            l.add(2);
            l.add(3);
        }catch (EngiException e){
        }
        assertEquals(l.getFirstIdx(),0);
    }

    @Test
    public void getLastIdxTest(){
        System.out.println("GetLastIdx Test");
        List<Integer> l = new List<Integer>();
        try{
            l.add(2);
            l.add(3);
        }catch (EngiException e){
        }
        assertEquals(l.getLastIdx(),1);
    }
}