package socket;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import processus.*;
import window.Frame;
import exception.*;

    
public class Client extends Thread{
        Socket socket;
        DataOutputStream out;
        DataInputStream input;
        BufferedReader br;
        boolean connection = false;
        Thread thread;
        String message;
        Frame frame;
    
        public Client(String adresse, int port) {
            try {
                Standoff so = new Standoff();
                frame = new Frame(so, this);
                socket = new Socket(adresse, port);
                out = new DataOutputStream(socket.getOutputStream());
                br = new BufferedReader(new InputStreamReader(System.in));
                thread = new Thread(this);
                thread.start();
                while(!message.equals("Over")){
                    try{
                        message = br.readLine();
                        out.writeUTF("Client : "+message);
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
                        
                        socket.close();
                        out.close();
                    } catch (IOException i) {
                        System.out.println(i);
                    }
                }
            }
        }
    
        public void run() {
            boolean connection = false;
            String message_server = "";
            try {
                input = new DataInputStream(this.socket.getInputStream());
                while(!message_server.equals("Over")){
                    message_server = input.readUTF();
                    server_message(message_server);
                    System.out.println("Message server : "+message_server);
                }
                connection = true;
            } catch (IOException i) {
                System.out.println(i);
            }
            finally{
                if(connection){
                    try {
                        this.socket.close();
                        input.close();
                    } catch (IOException i) {
                        System.out.println(i);
                    }
                }
            }
        }
        public void server_message(String msg){
            Tank tank = this.frame.getSo().getTank();
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
    
    

