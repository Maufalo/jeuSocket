package processus;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import processus.Munition;

public class Tank extends JPanel{
    int idTank;
    Munition [] bala;
    int isaBala = 5;
    int vie = 3;
    int x;
    int y;
    int incX;
    int incY;
    int width = 70;
    int height = 70;
    public Tank(int idTank, int x ,int y) {
        this.idTank = idTank;
        this.x = x;
        this.y = y;
        this.bala = new Munition[5];
        for (int i = 0; i < bala.length; i++) {
            this.bala[i] = new Munition();
        }
        this.vie = 3;
    }

    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.green);
        g.fillRect(getX(), getY(), width, height);
        for (int i = 0; i < bala.length; i++) {
            this.bala[i].paint(g);
        }
        repaint();
    }
    public int getIdTank() {
        return idTank;
    }

    public int getVie() {
            return vie;
        }
    public int getX() {
            return x;
        }
    public int getY() {
            return y;
        }
    public int getIncX() {
            return incX;
        }
    public int getIncY() {
            return incY;
        }
    public void setIdTank(int idTank) {
        this.idTank = idTank;
    }
    public void setVie(Munition m) {
        m.setX(-30);
        m.setY(700);
        m.setWidth(0);
        m.setHeight(0);
        if(!m.isType()){
            if(getVie() > 1){
                this.vie = vie - 1;
                m.setType(true);
            }
            else{
                this.vie = 0;
                System.out.println("Vous êtes détruit");
                setWidth(0);
                setHeight(0);
                setY(0);
                setX(-60);
                for (int i = 0; i < bala.length; i++) {
                    this.bala[i].setY(700);
                    this.bala[i].setX(-60);

                }
            }
        }
        if(m.isType()){
            this.vie = vie - 0;
        }

    }
   
    public void setX(int x) {
        this.x = x;
    }
    public void setY(int y) {
        this.y = y;
    }
    public void setIncX(int incX) {
        this.incX = incX;
        int posX = getX() + incX;
        setX(posX);
        for (int i = 0; i < bala.length; i++) {
            if(!this.bala[i].isPos()){
                this.bala[i].setX(getX());
            }
            else{
                this.bala[i].setX(this.bala[i].getX());

            }
        }
    }
    public void setIncY(int incY) {
        this.incY = incY;
        int posY = getY() + incY;
        setY(posY);
        for (int i = 0; i < bala.length; i++) {
            if(!this.bala[i].isPos()){
                this.bala[i].setY(getY());
            }
            else{
                this.bala[i].setY(this.bala[i].getY());

            }
        }
        
    }

    public Munition [] getBala() {
        return bala;
    }

    public void setBala(Munition [] bala) {
        this.bala = bala;
    }


    public int getIsaBala() {
        return isaBala;
    }

    public void setIsaBala() {
        this.isaBala = isaBala -1;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }
    
}
