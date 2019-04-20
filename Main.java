import model.EngiException;
import view.MainFrame;
import controller.GameEngine;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import model.list.*;

import java.util.ArrayList;
import java.util.Scanner;


public class Main {

    private static GameEngine G;
    private static MainFrame F;
    private static JLabel GameMessage;
    private static JLabel ExceptionMessage;
    
    // private static JLabel Message2;
    // private static JLabel Message3;


    public static void main(String[] args) {
        System.out.println("Rika's Farm");
        System.out.println("A Game built with Java using Object Oriented Paradigm" );
        System.out.println("========================================================");
        System.out.println("Lukas Kurnia Jonathan / 13517006");
        System.out.println("Eginata Kasan / 13517030");
        System.out.println("Vivianni / 13517060" );
        System.out.println("Gardahadi / 13517144" );
        System.out.println("Rika Dewi / 13517147" );
        String playerName = "Rika";
//        Scanner sc = new Scanner(System.in);
//        System.out.println("Silahkan Input Nama : ");
//        String playerName = sc.next();
//

        try {

            //Initialize Game Engine
            G = new GameEngine();

            //Initialize MainFrame
            F = new MainFrame();
            F.renderAnimalCount(3);
            F.renderName(playerName);


            //Add Listener
            MKeyListener listener = new MKeyListener();
            F.addKeyListener(listener);
            F.setVisible(true);

            //Start Tick Thread
            TickThread T1 = new TickThread(F);
            T1.start();

            //Initialize Map
            for (int i = 0; i<G.WORLDSIZE; i++){
                for(int j=0; j<G.WORLDSIZE;j++){
                    F.renderCell(G.getID(i,j),i,j);
                }
            }
            
            
            GameMessage = new JLabel("Message : Hello Welcome to Engis Farm");
            ExceptionMessage = new JLabel("Error : Error Messages will be displayed here");
            F.renderMsg(GameMessage);
            F.renderMsg(ExceptionMessage);
            while(true) {

                if(listener.getKey()!= 'x'){
                    try {
                        if (listener.getKey() == 'w') {
                            G.handleMove(1);
                        } else if (listener.getKey() == 'a') {
                            G.handleMove(4);
                        } else if (listener.getKey() == 's') {
                            G.handleMove(3);
                        } else if (listener.getKey() == 'd') {
                            G.handleMove(2);
                        } else if (listener.getKey() == 't') {
                            GameMessage = new JLabel(G.handleTalk());
                        } else if (listener.getKey() == 'i') {
                            G.handleInteract();
                        } else if (listener.getKey() == 'k') {
                            G.handleKill();
                        } else if (listener.getKey() == 'q') {
                            F.dispose();
                            System.exit(0);
                        }
                        G.updateGame();
                        G.printKeadaan("Rika");
                        G.printMap();
                        updateMap();
                    } catch (EngiException E) {
                        System.out.println("Masuk Exception 1");
                        ExceptionMessage = new JLabel("Error : " + E.getMessage());

                        updateMap();
                        G.printKeadaan("Rika");
                        G.printMap();
                    }
                    
                }

                listener.setKey('x');
                try { Thread.sleep(500); }
                catch (Exception e) {}
            }
        } catch (EngiException E){
            System.out.println("Masuk Exception 2");
            ExceptionMessage = new JLabel("Error : " + E.getMessage());
            updateMap();
        }
    }

    public static void updateMap(){
        F.clearMsg();
        F.clearMap();
        F.clearCondition();
        F.clearInventory();
        for (int i = 0; i<G.WORLDSIZE; i++){
            for(int j=0; j<G.WORLDSIZE;j++){
                F.renderCell(G.getID(i,j),i,j);
                // System.out.print(G.getID(i, j) + " ");
                
            }
            // System.out.println();
        }
        ArrayList<String> inventory = new ArrayList<String>(G.getInventoryList());

        for(int i=0; i<inventory.size(); i++){
            F.renderInventory(inventory.get(i));
        }

        F.renderMsg(GameMessage);
        F.renderMsg(ExceptionMessage);
        F.renderCondition(G.getEngi().getWater(), G.getEngi().getMoney());
        
    }
}
      
class MKeyListener extends KeyAdapter {

    private char key;

    MKeyListener() {
        key='x';
    }

    public char getKey() {
        return key;
    }

    public synchronized void setKey(char key) {
        this.key = key;
    }

    @Override
    public void keyPressed(KeyEvent event) {

        setKey(event.getKeyChar());
        System.out.println(key);

    }
}




class TickThread extends Thread {

    private MainFrame F;
    private int count;

    public TickThread(MainFrame frame){
        F = frame;
        count = 0;
    }
    public void run(){
        while(true){
            count++;
            F.renderTick(count);
            try { Thread.sleep(1000); }
            catch (Exception e) {}
        }

    }

}

