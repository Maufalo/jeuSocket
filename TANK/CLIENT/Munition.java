package processus;
import java.awt.*;
import javax.swing.JPanel; 

public class Munition extends JPanel{
    int x;
    int y;
    int incX;
    int incY;
    int width = 30;
    int height = 30;
    boolean type;
    boolean pos;
    public Munition() {
        this.type = false;
        this.pos = false;
    }
    public void paint(Graphics g){
        super.paint(g);
        g.setColor(Color.orange);
        g.fillOval(getX(), getY(), this.width,this.height);
        int posX = getX() + getIncX();
        int posY = getY() + getIncY();
        setX(posX);
        setY(posY);
        repaint();
        try
        {
            Thread.sleep(1);
        }
        catch (Exception e)
        {}
        if(getX()+30 < 0 || getX() > 1290){
            setIncX(0);
            setWidth(0);
            setHeight(0);
        }
        if(getY()+30 < 0 || getY() > 690){
            setIncY(0);
            setWidth(0);
            setHeight(0);
        }
    }
   
    public int getX() {
        return x;
    }
    public void setX(int x) {
        this.x = x;
    }
    public int getY() {
        return y;
    }
    public void setY(int y) {
        this.y = y;
    }
    public int getIncX() {
        return incX;
    }
    public int getIncY() {
        return incY;
    }
    public void setIncX(int incX) {
       this.incX = incX;
    }
    public void setIncY(int incY) {
       this.incY = incY;
    }
    
    public void setWidth(int width) {
        this.width = width;
    }
    
    public void setHeight(int height) {
        this.height = height;
    }
    public boolean isType() {
        return type;
    }
    public void setType(boolean type) {
        this.type = type;
    }
    public boolean isPos() {
        return pos;
    }
    public void setPos(boolean pos) {
        this.pos = pos;
    }
}
