import java.awt.Color;
import java.awt.Graphics;

public class InvaderLaser extends GraphicsObject {
    double speed_y;

    public InvaderLaser(double x, double y, double speed_y){
        super(x,y);
        this.speed_y = speed_y;
    }

    public void draw(Graphics g){
        g.setColor(new Color(238, 6, 68));
        g.fillRect((int)x, (int)y, 1, 4);

    }

    public void update(int pic_width, int pic_height, int frame) {
        this.y += this.speed_y;
    }
}