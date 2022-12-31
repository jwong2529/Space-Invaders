import java.awt.Color;
import java.awt.Graphics;

public class Winner extends GraphicsObject {
    int x;
    int y;

    public Winner(int x, int y){
        super(x, y);
    }

    public void draw(Graphics g){
        g.setColor(new Color(75, 21, 69));
        g.fillRect(x,y,600, 600);
        g.setColor(new Color(220, 45, 90));
        g.drawString("Winner!!!", 150, 150);
    }
}