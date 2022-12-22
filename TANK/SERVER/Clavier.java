package listener;
import java.awt.event.*;
import java.io.IOException;
import processus.*;
import window.Frame;
import exception.*;
import socket.Server;

public class Clavier implements KeyListener{
    Frame frame;
    boolean touch = false;
    public Clavier(Frame frame){
        this.frame = frame;

    }

    public void keyTyped(KeyEvent e){
        Tank tank = this.frame.getSo().getTank();
        Munition [] munition = tank.getBala();
        Server server = frame.getSocket();
        if(touch){
            if(e.getKeyChar() == 'q'){
                System.out.println("espaces");
                tank.setIsaBala();
                try {
                    try {
                        server.getOut().writeUTF("Espace_q");
                    } catch (IOException i) {
                        System.out.println(i);
                    }
                    
                    if(tank.getIsaBala() < 0){
                        throw new NotMunition("LANY BALA");
                    }
                    else{
                        munition[tank.getIsaBala()].setIncX(-1);
                        munition[tank.getIsaBala()].setPos(true);
                        System.out.println(tank.getIsaBala());
                    }
                } catch (NotMunition ex) {
                    //ex.printStackTrace();
                    System.out.println(ex);
                }
            }
            if(e.getKeyChar() == 'd'){
                System.out.println("espaces");
                tank.setIsaBala();
                try {
                    try {
                        server.getOut().writeUTF("Espace_d");
                    } catch (IOException i) {
                        System.out.println(i);
                    }
                    if(tank.getIsaBala() < 0){
                        throw new NotMunition("LANY BALA");
                    }
                    else{
                        munition[tank.getIsaBala()].setIncX(1);
                        munition[tank.getIsaBala()].setPos(true);
                        System.out.println(tank.getIsaBala());
                    }
                } catch (NotMunition ex) {
                    //ex.printStackTrace();
                    System.out.println(ex);
                }
            }
            if(e.getKeyChar() =='z'){
                System.out.println("espaces");
                tank.setIsaBala();
                try {
                    try {
                        server.getOut().writeUTF("Espace_z");
                    } catch (IOException i) {
                        System.out.println(i);
                    }
                    
                    if(tank.getIsaBala() < 0){
                        throw new NotMunition("LANY BALA");
                    }
                    else{
                        munition[tank.getIsaBala()].setIncY(-1);
                        munition[tank.getIsaBala()].setPos(true);
                        System.out.println(tank.getIsaBala());
                    }
                } catch (NotMunition ex) {
                    //ex.printStackTrace();
                    System.out.println(ex);
                }
            }
            if(e.getKeyChar() == 's'){
                System.out.println("espaces");
                tank.setIsaBala();
                try {
                    try {
                        server.getOut().writeUTF("Espace_s");
                    } catch (IOException i) {
                        System.out.println(i);
                    }
                    if(tank.getIsaBala() < 0){
                        throw new NotMunition("LANY BALA");
                    }
                    else{
                        munition[tank.getIsaBala()].setIncY(1);
                        munition[tank.getIsaBala()].setPos(true);
                        System.out.println(tank.getIsaBala());
                    }
                } catch (NotMunition ex) {
                    //ex.printStackTrace();
                    System.out.println(ex);
                }
            }
        }
        else{
            if(e.getKeyChar() == 'q'){
                // System.out.println("left");
                try {
                    server.getOut().writeUTF("q");
                } catch (IOException i) {
                    System.out.println(i);
                }
                tank.setIncX(-2);
            }
            if(e.getKeyChar() == 'd'){
                // System.out.println("right");
                try {
                    server.getOut().writeUTF("d");
                } catch (IOException i) {
                    System.out.println(i);
                }
                tank.setIncX(2);
            }
            if(e.getKeyChar() == 'z'){
                // System.out.println("up");
                try {
                    server.getOut().writeUTF("z");
                } catch (IOException i) {
                    System.out.println(i);
                }
                tank.setIncY(-2);
            }
            if(e.getKeyChar() == 's'){
                // System.out.println("down");
                try {
                    server.getOut().writeUTF("s");
                } catch (IOException i) {
                    System.out.println(i);
                }
                tank.setIncY(2);
            }
        }
    }

    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == e.VK_SPACE){
            touch = true;
            System.out.println("true");
        }

    }

    public void keyReleased(KeyEvent e) {
        if(e.getKeyCode() == e.VK_SPACE){
            touch = false;
            System.out.println("false");
        }
    }
    
}
