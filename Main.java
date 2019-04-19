import view.MainFrame;
import controller.GameEngine;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Scanner;


public class Main {
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

        //Initialize Game Engine
//        GameEngine G = new GameEngine();
        int count = 0;

        //Initialize MainFrame
        MainFrame F = new MainFrame();
        F.renderAnimalCount(3);
        F.renderName(playerName);

        //Add Listener
        MKeyListener listener = new MKeyListener();
        F.addKeyListener(listener);
        F.setVisible(true);

        TimerThred T1 = new TimerThred(F);
        T1.start();
        while(true) {
            if(listener.getKey()=='w'){
                count++;
                F.renderAnimalCount(count);
            }
            listener.setKey('x');
            try { Thread.sleep(1000); }
            catch (Exception e) {}
        }

    }
}

class TimerThred extends Thread {

    private MainFrame F;
    private int count;

    public TimerThred (MainFrame frame){
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

class MKeyListener extends KeyAdapter {

    private char key;

    MKeyListener() {
        key='x';
    }

    public char getKey() {
        return key;
    }

    public void setKey(char key) {
        this.key = key;
    }

    @Override
    public void keyPressed(KeyEvent event) {

        key = event.getKeyChar();
        System.out.println(key);
//        try{
//            wait();
//        }catch (Exception e){
//
//        }
    }
}
