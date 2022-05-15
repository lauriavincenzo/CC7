/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cargame;

/**
 *
 * @author vlaur
 */
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import static java.lang.Thread.sleep;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Calendar;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.Timer;

public class CarGame extends JFrame implements KeyListener, ActionListener {

    
    private ImageIcon car;
    private long timer;
    private int num1 = 400, num2 = 0, num3 = 0;
    private ImageIcon car1, car2, car3;
    private ImageIcon tree1, tree2, tree3;
    private boolean rightrotate = false, paint = false;
    Alberi a1,a2,a3;
    condivisa c;
    Thread_Ostacolifissi o,o2;
    public CarGame(String title) {
        super(title);
        setBounds(300, 10, 700, 700);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        addKeyListener(this);
        setFocusable(true);
        setResizable(false);
        c = new condivisa();
        a1=new Alberi(this,c);
        a2=new Alberi(this,c);
        a3=new Alberi(this,c);
        a1.start();
        a2.start();
        a3.start();
        

    }

    public void paint(Graphics g) {
        //disegno di asfalto, righe e marciapiede
        g.setColor(Color.gray);
        g.fillRect(0, 0, 700, 700);
        g.setColor(Color.white);
        g.fillRect(90, 0, 10, 700);
        g.fillRect(600, 0, 10, 700);
        g.setColor(Color.black);
        g.fillRect(100, 0, 500, 700);
        
        //striscie della strada
        if (c.getMovimentostrada()==0) {
            for (int i = 0; i <= 700; i += 100) {
                g.setColor(Color.white);
                g.fillRect(350, i, 10, 70); //350 è la posizione della linea tratt nello schermo //70 è la grandezza di ogni trattino, aumentando il dato diventa una riga continua  //10 larghezza delle strisce, aumentando il dato aumenta la larghezza delle striscie
            }
            c.setMovimentostrada(1);
            
        } else if (c.getMovimentostrada()==1) {
            for (int i = 50; i <= 700; i += 100) {
                g.setColor(Color.white);
                g.fillRect(350, i, 10, 70);
            }
            c.setMovimentostrada(0);
        }
        
        //GRAFICA ALBERI
        
        tree1 = new ImageIcon("./assets/tree1.png");
        tree1.paintIcon(this, g, 0, c.getTree1ypos());
        num1 = util.RandomRange(0, 499);
        tree2 = new ImageIcon("./assets/tree2.png");
        tree2.paintIcon(this, g, 0, c.getTree2ypos());
        tree3 = new ImageIcon("./assets/tree3.png");
        tree3.paintIcon(this, g, 0, c.getTree3ypos());
        tree1.paintIcon(this, g, 600, c.getTree4ypos());
        tree3.paintIcon(this, g, 600, c.getTree5ypos());
        tree2.paintIcon(this, g, 600, c.getTree6ypos());
        c.incrementopos();

        //CREAZIONE AUTO PROTAGONISTA
        car = new ImageIcon("./assets/gamecar1.png");
        car.paintIcon(this, g, c.getXpos(), c.getYpos());
        c.decrementoy();
        c.controlloy();

        // GESTIONE OSTACOLI FISSI DA 158 A 276
        car1 = new ImageIcon("./assets/gamecar2.png");
        car2 = new ImageIcon("./assets/gamecar3.png");
        car1.paintIcon(this, g, c.getCarxpos()[c.getCxpos1()], c.getY1pos());
        car2.paintIcon(this, g, c.getCarxpos()[c.getCxpos2()], c.getY2pos());
        c.gestioneostacolifissi();
        
        //GAMEOVER
        c.gameover();
        //PUNTEGGIO KM/H E TIMER
        g.setColor(Color.blue);
        g.fillRect(120, 35, 220, 50);
        g.setColor(Color.DARK_GRAY);
        g.fillRect(125, 40, 210, 40);

        g.setColor(Color.blue);
        g.fillRect(415, 35, 180, 50);
        g.setColor(Color.DARK_GRAY);
        g.fillRect(420, 40, 170, 40);

        g.setColor(Color.white);
        g.setFont(new Font("Arial", Font.BOLD, 30));
        g.drawString("Score : " + c.getScore(), 160, 70);
        g.drawString(c.getSpeed() + " Km/h", 453, 70);
        c.incrementoscore();
        c.incrementospeed();
        c.gestionescore();
        c.gestionevelocita();
       
        
        //delay 
        c.gestionedelay();
        //SCHERMATA DI GAME OVER
        if (c.isGameover()) {
            g.setColor(Color.gray);
            g.fillRect(120, 210, 460, 200);
            g.setColor(Color.DARK_GRAY);
            g.fillRect(130, 220, 440, 180);
            g.setFont(new Font("Serif", Font.BOLD, 50));
            g.setColor(Color.yellow);
            g.drawString("Game Over !", 210, 270);
            g.setColor(Color.white);
            g.setFont(new Font("Arial", Font.BOLD, 30));
            c.setTimer(c.getTimer()/1000);
            g.drawString("Tempo di gioco: "+c.getTimer(), 210, 330);
            g.setFont(new Font("Arial",Font.BOLD,20));
            g.drawString("secondi", 450, 350);
            g.drawString("Press Enter to Restart", 250, 380);

            if (!paint) {
                repaint();
                paint = true;
            }
        } else {
            repaint();
        }
    }

    public static void main(String args[]) {
        CarGame c = new CarGame("Car Game");
    }

    @Override
    public void keyPressed(KeyEvent e) {
        // TODO Auto-generated method stub
        if (e.getKeyCode() == KeyEvent.VK_LEFT && !c.isGameover()) {
            c.setXpos(c.getXpos()-100);
            if (c.getXpos() < 100) {
                c.setXpos(100);
            }

        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT && !c.isGameover()) {
            c.setXpos(c.getXpos()+100);
            if (c.getXpos() > 500) {
                c.setXpos(500);
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_ENTER && c.isGameover()) {
            c.setGameover(false);
            paint = false;
            c.setCxpos1(0);
            c.setCxpos2(2);
            c.setCypos1(util.RandomRange(0, 4));
            c.setCypos2(util.RandomRange(0, 4));
            c.setY1pos(c.getCarypos()[c.getCypos1()]);
            c.setY2pos(c.getCarypos()[c.getCypos2()]);
            c.setTinizio(new Date().getTime());
            c.setTfine(new Date().getTime());
            c.setScore(0);
            c.setSpeed(50);
            
            c.setDelay(120);
            c.setXpos(300);
            c.setYpos(700);

        }

    }

    @Override
    public void keyReleased(KeyEvent arg0) {
        // TODO Auto-generated method stub

    }

    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub
        if (e.getKeyChar() == 'a' && !c.isGameover()) {
            
            c.setXpos(c.getXpos()-100);

        }
        if (e.getKeyChar() == 'd' && !c.isGameover()) {
            
            c.setXpos(c.getXpos()+100);
        }
        if (e.getKeyChar() == 'w' && !c.isGameover()) {
             if(c.getSpeed()<100)
             {
                 c.setSpeed(c.getSpeed()+5);
             }
            
        }
        if (e.getKeyChar() == 's' && !c.isGameover()) {
            if(c.getSpeed()<50)
             {
                 c.setSpeed(c.getSpeed()-5);
                 
             }
        }

        repaint();

    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        // TODO Auto-generated method stub

    }
}
