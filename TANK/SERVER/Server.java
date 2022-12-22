package socket;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import processus.*;
import exception.*;
import window.Frame;

public class Server extends Thread{
    ServerSocket server;
    Socket socket;
    DataOutputStream out;
    DataInputStream input;
    BufferedReader br;
    boolean connection = false;
    Thread thread;
    String message;
    Frame frame;

    public Server(int port) {
        try {
            Standoff so = new Standoff();
            frame = new Frame(so, this);
            server = new ServerSocket(port);
            System.out.println("Started");
            System.out.println("Waiting client");
            socket = server.accept();
            System.out.println("Client accepted");
            out = new DataOutputStream(socket.getOutputStream());
            br = new BufferedReader(new InputStreamReader(System.in));
            thread = new Thread(this);
            thread.start();
            while(!message.equals("Over")){
                try{
                    message = br.readLine();
                    out.writeUTF("Server : "+message);
                } catch (IOException i) {
                    System.out.println(i);
                }
            }
            connection = true;

        } catch (IOException i) {
            System.out.println(i);
        }
        finally{
            if(connection){
                try {
                    server.close();
                    socket.close();
                } catch (IOException i) {
                    System.out.println(i);
                }
            }
        }
    }

    public void run() {
        boolean connection = false;
        String message_client = "";
        try {
            input = new DataInputStream(this.socket.getInputStream());
            while(!message_client.equals("Over")){
                message_client = input.readUTF();
                client_message(message_client);
                System.out.println("Message client : "+message_client);
            }
            connection = true;
        } catch (IOException i) {
            System.out.println(i);
        }
        finally{
            if(connection){
                try {
                    input.close();
                    this.socket.close();
                } catch (IOException i) {
                    System.out.println(i);
                }
            }
        }
    }
    public void client_message(String msg){
        Tank tank = this.frame.getSo().getTank1();
        Munition [] munition = tank.getBala();
        if(msg.equals("Espace_q")){
            tank.setIsaBala();
                try {
                    
                    if(tank.getIsaBala() < 0){
                        throw new NotMunition("LANY BALA");
                    }
                    else{
                        munition[tank.getIsaBala()].setIncX(-1);
                        System.out.println(tank.getIsaBala());
                    }
                } catch (NotMunition ex) {
                    //ex.printStackTrace();
                    System.out.println(ex);
                }
        }
        if(msg.equals("Espace_d")){
            tank.setIsaBala();
                try {
                    
                    if(tank.getIsaBala() < 0){
                        throw new NotMunition("LANY BALA");
                    }
                    else{
                        munition[tank.getIsaBala()].setIncX(1);
                        System.out.println(tank.getIsaBala());
                    }
                } catch (NotMunition ex) {
                    //ex.printStackTrace();
                    System.out.println(ex);
                }
        }
        if(msg.equals("Espace_z")){
            tank.setIsaBala();
                try {
                    
                    if(tank.getIsaBala() < 0){
                        throw new NotMunition("LANY BALA");
                    }
                    else{
                        munition[tank.getIsaBala()].setIncY(-1);
                        System.out.println(tank.getIsaBala());
                    }
                } catch (NotMunition ex) {
                    //ex.printStackTrace();
                    System.out.println(ex);
                }
        }
        if(msg.equals("Espace_s")){
            tank.setIsaBala();
                try {
                    
                    if(tank.getIsaBala() < 0){
                        throw new NotMunition("LANY BALA");
                    }
                    else{
                        munition[tank.getIsaBala()].setIncY(1);
                        System.out.println(tank.getIsaBala());
                    }
                } catch (NotMunition ex) {
                    //ex.printStackTrace();
                    System.out.println(ex);
                }
        }
        if(msg.equals("q")){
            tank.setIncX(-2);
        }
        if(msg.equals("d")){
            tank.setIncX(2);
        }
        if(msg.equals("z")){
            tank.setIncY(-2);
        }
        if(msg.equals("s")){
            tank.setIncY(2);
        }
    }

    public DataOutputStream getOut() {
        return out;
    }

    public void setOut(DataOutputStream out) {
        this.out = out;
    }
    
}
