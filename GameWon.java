
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class GameWon extends GraphicsObject {

	public GameWon(double x, double y) {
		super(x, y);
	}
	
	@Override
	public void draw(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, 600, 400);
		
		g.setColor(new Color(250, 250, 250));
		g.setFont(new Font("Impact", Font.BOLD, 70));
		g.drawString("You win!", 180, 220);
	}
}
