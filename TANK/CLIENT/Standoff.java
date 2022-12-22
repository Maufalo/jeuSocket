package processus;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import processus.Tank;

public class Standoff extends JPanel{
    Tank tank = new Tank(1, 200, 20);
    Tank tank1 = new Tank(2, 500, 20);

    public Standoff() {
        
    }
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, 1290, 690);
        tank.paint(g);
        tank1.paint(g);
        voatifitra();
        repaint();
    }
    public void voatifitra(){
        Munition [] bala1 = tank.getBala();
        Munition [] bala2 = tank1.getBala(); 
        int x1 = tank.getX();
        int y1 = tank.getY();
        int x2 = tank1.getX();
        int y2 = tank1.getY();
        if(tank1.getIdTank() == 2){
            for (int i = 0; i < bala1.length; i++) {
                if(y1 == bala2[i].getY() || y1+30 == bala2[i].getY()){
                    if(x1 <= bala2[i].getX() && x1+30 >= bala2[i].getX()){
                        tank.setVie(bala2[i]);
                        System.out.println("vie tank = "+tank.getVie());
                    }
                }
                if(x1 == bala2[i].getX() || x1+30 == bala2[i].getX()){
                    if(y1 <= bala2[i].getY() && y1+30 >= bala2[i].getY()){
                        tank.setVie(bala2[i]);
                        System.out.println("vie tank = "+tank.getVie());
                    }
                }
                if(y2 == bala1[i].getY() || y2+30 == bala1[i].getY()){
                    if(x2 <= bala1[i].getX() && x2+30 >= bala1[i].getX()){
                        tank1.setVie(bala1[i]); 
                        System.out.println("vie tank1 = "+tank1.getVie());
                    }
                }
                if(x2 == bala1[i].getX() || x2+30 == bala1[i].getX()){
                    if(y2 <= bala1[i].getY() && y2+30 >= bala1[i].getY()){
                        tank1.setVie(bala1[i]);
                        System.out.println("vie tank1 = "+tank1.getVie());
                    }
                }
            }
        }
    }
    public Tank getTank() {
        return tank;
    }
    public void setTank(Tank tank) {
        this.tank = tank;
    }
    public Tank getTank1() {
        return tank1;
    }
    public void setTank1(Tank tank1) {
        this.tank1 = tank1;
    }
    
}
