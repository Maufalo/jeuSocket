package window;

import javax.swing.JFrame;
import listener.Clavier;
import processus.Standoff;
import socket.Client;


public class Frame extends JFrame{
    Standoff so;
    Client socket;
    Clavier listen = new Clavier(this);
    public Frame(Standoff so, Client socket){
        this.setVisible(true);
        this.setTitle("C L I E N T");
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setSize(1300, 700);
        this.so  = so;
        this.socket = socket;
        this.add(so);
        this.addKeyListener(listen);
    }
    public Standoff getSo() {
        return so;
    }
    public void setSo(Standoff so) {
        this.so = so;
    }
    public Client getSocket() {
        return socket;
    }
    
}