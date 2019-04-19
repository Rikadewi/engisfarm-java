import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import view.MainFrame;
import java.util.*;

class Main {
    public static void main(String[] args) {
        System.out.println("Rika's Farm");
        System.out.println("A Game build with C++ using Object Oriented Paradigm" );
        System.out.println("========================================================");
        System.out.println("Lukas Kurnia Jonathan / 13517006");
        System.out.println("Eginata Kasan / 13517030");
        System.out.println("Vivianni / 13517060" );
        System.out.println("Gardahadi / 13517144" );
        System.out.println("Rika Dewi / 13517147" );


        MainFrame F = new MainFrame();
        F.renderAnimalCount(3);
        F.renderName("Rika");

    }
}

class MKeyListener extends KeyAdapter {

    @Override
    public void keyPressed(KeyEvent event) {

        char ch = event.getKeyChar();

        if (ch == 'a' ||ch == 'b'||ch == 'c' ) {

            System.out.println(event.getKeyChar());

        }

        if (event.getKeyCode() == KeyEvent.VK_HOME) {

            System.out.println("Key codes: " + event.getKeyCode());

        }
    }
}