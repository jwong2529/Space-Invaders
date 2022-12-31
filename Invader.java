import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Invader extends GraphicsObject {

    private int width;
    private int height;
    private Color color;

    public Invader(double x, double y, int width, int height, Color color) {
        super(x, y);
        this.width = width;
        this.height = height;
        this.color = color;
    }

    @Override
    public void draw(Graphics g) {
        // change the color of the pen
        g.setColor(this.color);
        // draw the rectangle

        g.fillRect((int) this.x, (int) this.y, this.width, this.height);
    }
    public void update(int pic_width, int pic_height, int frame){
        if (this.x < 0 || this.x + this.width > pic_width) {
            this.speed_x = -this.speed_x;
        }
        if (this.y < 0 || this.y + this.height > pic_height) {
            this.speed_y = -this.speed_y;
        }

        Random randy = new Random();
        this.color = Color.blue;
        super.update(pic_width, pic_height, frame);
    }
}