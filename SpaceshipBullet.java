import java.awt.Color;
import java.awt.Graphics;

public class SpaceshipBullet extends GraphicsObject {
	
	
	public SpaceshipBullet(double x, double y) {
		super(x, y);
		
	}
	
	@Override
    public void draw(Graphics g) {  
        g.setColor(Color.MAGENTA);        
        g.drawRoundRect((int) this.x, (int) this.y, 7, 20, 180, 40);
        g.fillRoundRect((int) this.x, (int) this.y, 7, 20, 180, 40);
    }
	

}
