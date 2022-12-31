import java.awt.Color;
import java.awt.Graphics;

public class Loser extends GraphicsObject {
    int x;
    int y;

    public Loser(int x, int y){
        super(x, y);
    }

    public void draw(Graphics g){
        g.setColor(new Color(0, 7, 7));
        g.fillRect(x,y,400, 400);
        g.setColor(new Color(241, 6, 6));
        g.drawString("Game Over: Try again!", 200, 200);
    }
}