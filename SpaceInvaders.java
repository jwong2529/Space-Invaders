import java.util.ArrayList;
import java.util.Random;

// graphics
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;

// events
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

// swing
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class SpaceInvaders extends JPanel implements ActionListener, KeyListener, Runnable {

    private final int canvasWidth;
    private final int canvasHeight;
    private Color backgroundColor;

    private final int framesPerSecond = 25;
    private final int msPerFrame = 1000 / framesPerSecond;
    private Timer timer;
    private int frame = 0;

    private Player player;
    private Invader aliens;
    private ArrayList<Invader> alienList;
    private ArrayList<InvaderLaser> alienLaser;
    private ArrayList<PlayerLaser> playerLaser;
    private ArrayList<Destroy> destroyed;
    private ArrayList<Destroy> dead;
    private ArrayList<Moving> dying;
    private Loser L= new Loser(0,0);
    private Winner W= new Winner(0,0);

    double XLeft= 0.0;
    double XRight= 560.0;
    double YUp=0.0;
    double YDown=100.0;
    double alien_X1=XLeft;
    double alien_Y1=YUp;
    double alien1_end=515.0;
    double alien_X2=XLeft+15;
    double alien_Y2=YUp;
    double alien2_end=530.0;
    double alien_X3=XLeft+30;
    double alien_Y3=YUp;
    double alien3_end=545.0;
    double alien_X4=XLeft+45;
    double alien_Y4=YUp;
    double alien4_end=560.0;
    double alien_X5=XLeft+60;
    double alien_Y5=YUp;
    double alien5_end=575.0;
    double alien_X6=XLeft+75;
    double alien_Y6=YUp;
    double alien_X7=XLeft;
    double alien_Y7=YUp+15;
    double alien_X8=XLeft+15;
    double alien_Y8=YUp+15;
    double alien_X9=XLeft+30;
    double alien_Y9=YUp+15;
    double alien_X10=XLeft+45;
    double alien_Y10=YUp+15;
    double alien_X11=XLeft+60;
    double alien_Y11=YUp+15;
    double alien_X12=XLeft+75;
    double alien_Y12=YUp+15;
    double alien_X13=XLeft;
    double alien_Y13=YUp+30;
    double alien_X14=XLeft+15;
    double alien_Y14=YUp+30;
    double alien_X15=XLeft+30;
    double alien_Y15=YUp+30;
    double alien_X16=XLeft+45;
    double alien_Y16=YUp+30;
    double alien_X17=XLeft+60;
    double alien_Y17=YUp+30;
    double alien_X18=XLeft+75;
    double alien_Y18=YUp+30;
    double alien_X19=XLeft;
    double alien_Y19=YUp+45;
    double alien_X20=XLeft+15;
    double alien_Y20=YUp+45;
    double alien_X21=XLeft+30;
    double alien_Y21=YUp+45;
    double alien_X22=XLeft+45;
    double alien_Y22=YUp+45;
    double alien_X23=XLeft+60;
    double alien_Y23=YUp+45;
    double alien_X24=XLeft+75;
    double alien_Y24=YUp+45;
    double alien_X25=XLeft;
    double alien_Y25=YUp+60;
    double alien_X26=XLeft+15;
    double alien_Y26=YUp+60;
    double alien_X27=XLeft+30;
    double alien_Y27=YUp+60;
    double alien_X28=XLeft+45;
    double alien_Y28=YUp+60;
    double alien_X29=XLeft+60;
    double alien_Y29=YUp+60;
    double alien_X30=XLeft+75;
    double alien_Y30=YUp+60;

    ArrayList<Moving> movement;

    Random rando= new Random();

    public SpaceInvaders() {
        this.canvasWidth = 800;
        this.canvasHeight = 400;
        this.backgroundColor = Color.black;
        setPreferredSize(new Dimension(this.canvasWidth, this.canvasHeight));

        this.timer = new Timer(msPerFrame, this);
        this.movement=new ArrayList<>();
        this.alienLaser=new ArrayList<>();
        this.playerLaser=new ArrayList<>();
        this.destroyed=new ArrayList<>();
        this.dead=new ArrayList<>();
        this.dying=new ArrayList<>();

        player = new Player(300, 300, 30,30, Color.white);
        movement.add(new Moving(alien_X1,alien_Y1,5.0,0.1,515.0,0.0));
        movement.add(new Moving(alien_X2,alien_Y2,5.0,0.1,530.0,15.0));
        movement.add(new Moving(alien_X3,alien_Y3,5.0,0.1,545.0,30.0));
        movement.add(new Moving(alien_X4,alien_Y4,5.0,0.1,560.0,45.0));
        movement.add(new Moving(alien_X5,alien_Y5,5.0,0.1,575.0,60.0));
        movement.add(new Moving(alien_X6,alien_Y6,5.0,0.1,590.0,75.0));
        movement.add(new Moving(alien_X7,alien_Y7,5.0,0.1,515.0,0.0));
        movement.add(new Moving(alien_X8,alien_Y8,5.0,0.1,530.0,15.0));
        movement.add(new Moving(alien_X9,alien_Y9,5.0,0.1,545.0,30.0));
        movement.add(new Moving(alien_X10,alien_Y10,5.0,0.1,560.0,45.0));
        movement.add(new Moving(alien_X11,alien_Y11,5.0,0.1,575.0,60.0));
        movement.add(new Moving(alien_X12,alien_Y12,5.0,0.1,590.0,75.0));
        movement.add(new Moving(alien_X13,alien_Y13,5.0,0.1,515.0,0.0));
        movement.add(new Moving(alien_X14,alien_Y14,5.0,0.1,530.0,15.0));
        movement.add(new Moving(alien_X15,alien_Y15,5.0,0.1,545.0,30.0));
        movement.add(new Moving(alien_X16,alien_Y16,5.0,0.1,560.0,45.0));
        movement.add(new Moving(alien_X17,alien_Y17,5.0,0.1,575.0,60.0));
        movement.add(new Moving(alien_X18,alien_Y18,5.0,0.1,590.0,75.0));
        movement.add(new Moving(alien_X19,alien_Y19,5.0,0.1,515.0,0.0));
        movement.add(new Moving(alien_X20,alien_Y20,5.0,0.1,530.0,15.0));
        movement.add(new Moving(alien_X21,alien_Y21,5.0,0.1,545.0,30.0));
        movement.add(new Moving(alien_X22,alien_Y22,5.0,0.1,560.0,45.0));
        movement.add(new Moving(alien_X23,alien_Y23,5.0,0.1,575.0,60.0));
        movement.add(new Moving(alien_X24,alien_Y24,5.0,0.1,590.0,75.0));
        movement.add(new Moving(alien_X25,alien_Y25,5.0,0.1,515.0,0.0));
        movement.add(new Moving(alien_X26,alien_Y26,5.0,0.1,530.0,15.0));
        movement.add(new Moving(alien_X27,alien_Y27,5.0,0.1,545.0,30.0));
        movement.add(new Moving(alien_X28,alien_Y28,5.0,0.1,560.0,45.0));
        movement.add(new Moving(alien_X29,alien_Y29,5.0,0.1,575.0,60.0));
        movement.add(new Moving(alien_X30,alien_Y30,5.0,0.1,590.0,75.0));

            }

    @Override
    public void run() {
        display();

        this.timer.start();
    }

    private void display() {
        JFrame jframe = new JFrame();
        jframe.addKeyListener(this);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setContentPane(this);
        jframe.pack();
        jframe.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        update();
        repaint(0, 0, this.canvasWidth, this.canvasHeight);
        this.frame++;
    }

    @Override
    protected void paintComponent(Graphics g) {
        clearCanvas(g);
        if (hasWonGame()) {
            paintWinScreen(g);
        } else if (hasLostGame()) {
            paintLoseScreen(g);
        } else {
            paintGameScreen(g);
        }
    }

    private void clearCanvas(Graphics g) {
        Color oldColor = g.getColor();
        g.setColor(this.backgroundColor);
        g.fillRect(0, 0, this.canvasWidth, this.canvasHeight);
        g.setColor(oldColor);
    }

    public void keyReleased(KeyEvent e) {
    }

    public void keyTyped(KeyEvent e) {
    }

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            this.player.x -=10;
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            this.player.x += 10;
        } else if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            playerLaser.add(new PlayerLaser(player.x+12.5, player.y, -10.0));
        }
    }

    private void update() {
        this.player.update(this.canvasWidth, this.canvasHeight,frame);
        for(Moving movement: this.movement){
            movement.update(this.canvasWidth, this.canvasHeight, frame);
         }
        for(PlayerLaser laser: this.playerLaser){
            laser.update(this.canvasWidth, this.canvasHeight, frame);
        }
        for (InvaderLaser laser : this.alienLaser) {
            laser.update(this.canvasWidth, this.canvasHeight, frame);
        }
    }

    private boolean hasLostGame() {

        for (InvaderLaser laser : this.alienLaser) {
            if (laser.x >= player.x - 25 && laser.x <= player.x + 25 && laser.y >= player.y && laser.y <= player.y + 25) {
                destroyed.add(new Destroy(player.x, player.y));
            }
        }
        for(Moving sprite: this.movement){
            if (sprite.x >= player.x - 25 && sprite.x <= player.x + 25 && sprite.y + 25 >= player.y && sprite.y + 25 <=player.y + 25){
                destroyed.add(new Destroy(player.x, player.y));
            }
            else if (sprite.y +50 >= 560){
                destroyed.add(new Destroy(player.x, player.y));
            }
        }
        if (destroyed.size() >= 1){
            return true;
        }
        else {
            return false;
        }
    }

    private boolean hasWonGame() {
        for(PlayerLaser laser: this.playerLaser){
            for(Moving sprit: this.movement) {
                Destroy exp = new Destroy(sprit.x, sprit.y);
                if(laser.x >= sprit.x && laser.x <= sprit.x + 15 && laser.y >= sprit.y && laser.y <= sprit.y + 15){
                    dead.add(exp);
                    movement.remove(sprit);
                    playerLaser.remove(laser);
                    dying.add(sprit);
                }
                if(laser.y <= 0){
                    playerLaser.remove(laser);
                }
            }
        }
        if(dying.size()>= 30) {
            return true;
        }
        return false;
    }

    private void paintGameScreen(Graphics g) {
        this.player.draw(g);
        for (Moving movement: this.movement){
            movement.draw(g);

            if(movement.x==rando.nextInt(550)) {
                alienLaser.add(new InvaderLaser(movement.x + 5, movement.y + 10, 5.0));
            }
        }
        for (InvaderLaser laser : this.alienLaser) {
            laser.draw(g);
        }
        for (PlayerLaser lase : this.playerLaser) {
            lase.draw(g);
        }


    }

    private void paintWinScreen(Graphics g) {
        W.draw(g);
    }

    private void paintLoseScreen(Graphics g) {
        L.draw(g);
    }


    public static void main(String[] args) {
        SpaceInvaders invaders = new SpaceInvaders();
        EventQueue.invokeLater(invaders);

    }
}

