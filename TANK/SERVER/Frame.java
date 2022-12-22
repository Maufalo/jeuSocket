package window;
import javax.swing.JFrame;
import listener.Clavier;
import processus.Standoff;
import socket.Server;


public class Frame extends JFrame{
    Standoff so;
    Server socket;
    Clavier listen = new Clavier(this);
    public Frame(Standoff so, Server socket){
        this.setVisible(true);
        this.setTitle("S E R V E R");
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
    public Server getSocket() {
        return socket;
    }
    
}