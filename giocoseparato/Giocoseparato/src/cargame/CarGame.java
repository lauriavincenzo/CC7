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

    private int xpos=300,ypos=700;
    private ImageIcon car;
    private long timer;
    long tinizio;
    long tfine;
    private int num1 = 400, num2 = 0, num3 = 0;
    private ImageIcon car1, car2, car3;
    private int score = 0, delay = 100, speed = 50;
    private ImageIcon tree1, tree2, tree3;
    private boolean rightrotate = false, gameover = false, paint = false;
    Alberi a, a1, a2;
    condivisa c;

    public CarGame(String title) {
        super(title);
        setBounds(300, 10, 700, 700);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        addKeyListener(this);
        setFocusable(true);
        setResizable(false);

        tinizio = new Date().getTime();
        c = new condivisa();

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
        c.riposizionamentoAlberi();
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
        //car3=new ImageIcon("./assets/gamecar4.png");

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
        g.drawString("Score : " + score, 160, 70);
        g.drawString(speed + " Km/h", 453, 70);
        score++;
        speed++;

        if (speed > 130) {
            speed = 130;

        }
        //PUNTO CRITICO, IL DELAY ERA A 60, 500 è PER MOSTRARE BENE IL SUO EFFETTO
        if (score % 50 == 0) {
            delay -= 10;
            if (delay < 100) {
                delay = 100;
            }
        }
        //delay 
        c.gestionedelay();
        //SCHERMATA DI GAME OVER
        if (gameover) {
            g.setColor(Color.gray);
            g.fillRect(120, 210, 460, 200);
            g.setColor(Color.DARK_GRAY);
            g.fillRect(130, 220, 440, 180);
            g.setFont(new Font("Serif", Font.BOLD, 50));
            g.setColor(Color.yellow);
            g.drawString("Game Over !", 210, 270);
            g.setColor(Color.white);
            g.setFont(new Font("Arial", Font.BOLD, 30));

            timer=timer/1000;
            g.drawString("Tempo di gioco: "+timer, 210, 330);
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
        if (e.getKeyCode() == KeyEvent.VK_LEFT && !gameover) {
            xpos -= 100;
            if (xpos < 100) {
                xpos = 100;
            }

        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT && !gameover) {
            xpos += 100;
            if (xpos > 500) {
                xpos = 500;
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_ENTER && gameover) {
            gameover = false;
            paint = false;
            cxpos1 = 0;
            cxpos2 = 2;
            cxpos3 = 4;
            cypos1 = util.RandomRange(0, 4);
            cypos2 = util.RandomRange(0, 4);
            cypos3 = util.RandomRange(0, 4);
            y1pos = carypos[cypos1];
            y2pos = carypos[cypos2];
            y3pos = carypos[cypos3];
            speed = 50;
            score = 0;
            tfine = new Date().getTime();
            tinizio=new Date().getTime();
            delay = 120;
            xpos = 300;
            ypos = 700;

        }

    }

    @Override
    public void keyReleased(KeyEvent arg0) {
        // TODO Auto-generated method stub

    }

    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub
        if (e.getKeyChar() == 'a' && !gameover) {
            xpos -= 100;

        }
        if (e.getKeyChar() == 'd' && !gameover) {
            xpos += 100;
        }
        if (e.getKeyChar() == 'w' && !gameover) {
             if(speed<100)
             {
                 speed+=5;
             }
            
        }
        if (e.getKeyChar() == 's' && !gameover) {
            if(speed<50)
             {
                 speed+=5;
             }
        }

        repaint();

    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        // TODO Auto-generated method stub

    }
}
