/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cargame;

/**
 *
 * @author sireci
 * @class main
 * @brief vengono effettuati tutti paint, implementati tutti i thread e
 * richiamati i vari metodi
 *
 */
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
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

public class giocoseparato extends JFrame implements KeyListener, ActionListener {

    /**
     * @var variabili private create per fare le paint dei vari oggetti
     */
    private ImageIcon car1, car2, car4, car5, car6;
    private ImageIcon tree1, tree2, tree3;
    private ImageIcon car;
    private ImageIcon logo;
    /**
     * @var variabili private che servono da valore random da dare agli alberi
     * per coordinate
     */
    private int num1 = 400, num2 = 0, num3 = 0;
    private boolean paint = false;
    /**
     * dichiarazioni di tutti i thread
     */
    Thread_alberi a1;
    Thread_alberi a2, a3;
    condivisa c;
    Thread_Ostacolifissi o, o2;
    Thread_ostacolimobili om1, om2;
    Thread_score gs, gs2;
    Thread_inseguitore i;
    /**
     * @var variabile intera per la gestione di schermate
     */
    int menu = 0;

    public giocoseparato(String title) {
        /**
         * inizializzazione metodi fissi delle classi e dei vari thread
         */
        super(title);
        setBounds(300, 10, 700, 700);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        addKeyListener(this);
        setFocusable(true);
        setResizable(false);
        c = new condivisa();
        a1 = new Thread_alberi(this, c);
        a2 = new Thread_alberi(this, c);
        a3 = new Thread_alberi(this, c);
        o = new Thread_Ostacolifissi(c, this);
        o2 = new Thread_Ostacolifissi(c, this);
        om1 = new Thread_ostacolimobili(c, this);
        om2 = new Thread_ostacolimobili(c, this);
        gs = new Thread_score(c, this);
        gs2 = new Thread_score(c, this);
        i = new Thread_inseguitore(c, this);
        menu = 0;

    }

    /**
     * @brief metodo per andare a disegnare i vari elementi grazie al supporto
     * dei vari metodi nella condivisa
     * @param1 Graphics g, parametro utile per implementare la grafica
     */
    public void paint(Graphics g) {

        if (menu == 0) {
            //grafica menu iniziale
            g.setColor(Color.DARK_GRAY);
            g.fillRect(700, 700, 700, 700);
            g.setFont(new Font("Serif", Font.BOLD, 50));
            logo = new ImageIcon("./assets/logo.png");
            logo.paintIcon(this, g, 161, 200);
            g.setColor(Color.gray);
            g.setFont(new Font("Arial", Font.BOLD, 30));
            g.drawString("Premi:", 300, 350);
            g.setFont(new Font("Arial", Font.BOLD, 25));
            g.drawString("- Enter ??? per giocare.", 220, 390);
            g.drawString("- Esc ??? per uscire.", 220, 420);
            g.setFont(new Font("Arial", Font.BOLD, 20));

            if (!paint) {
                repaint();
                paint = true;
            } else {
                repaint();
            }

        } else {
            //grafica strada

            g.setColor(Color.gray);
            g.fillRect(0, 0, 700, 700);
            g.setColor(Color.white);
            g.fillRect(90, 0, 10, 700);
            g.fillRect(600, 0, 10, 700);
            g.setColor(Color.black);
            g.fillRect(100, 0, 500, 700);

            //gestione movimento strada
            if (c.getMovimentostrada() == 0) {
                for (int i = 0; i <= 700; i += 100) {
                    g.setColor(Color.white);
                    g.fillRect(350, i, 10, 70);
                }
                c.setMovimentostrada(1);

            } else if (c.getMovimentostrada() == 1) {
                for (int i = 50; i <= 700; i += 100) {
                    g.setColor(Color.white);
                    g.fillRect(350, i, 10, 70);
                }
                c.setMovimentostrada(0);
            }

            //grafica alberi
            num1 = util.RandomRange(0, 499);
            tree1 = new ImageIcon("./assets/tree1.png");
            tree2 = new ImageIcon("./assets/tree2.png");
            tree3 = new ImageIcon("./assets/tree3.png");
            tree1.paintIcon(this, g, 0, c.getTree1ypos());
            tree2.paintIcon(this, g, 0, c.getTree2ypos());
            tree3.paintIcon(this, g, 0, c.getTree3ypos());
            tree1.paintIcon(this, g, 600, c.getTree4ypos());
            tree3.paintIcon(this, g, 600, c.getTree5ypos());
            tree2.paintIcon(this, g, 600, c.getTree6ypos());
            c.incrementopos();

            //grafica auto protagonista
            car = new ImageIcon("./assets/gamecar1.png");
            car.paintIcon(this, g, c.getXpos(), c.getYpos());
            c.decrementoy();
            c.controlloy();

            //grafica ostacoli
            car1 = new ImageIcon("./assets/gamecar2.png");
            car2 = new ImageIcon("./assets/gamecar3.png");
            car4 = new ImageIcon("./assets/gamecar5.png");
            car5 = new ImageIcon("./assets/gamecar6.png");
            car6 = new ImageIcon("./assets/gamecar4.png");
            car1.paintIcon(this, g, c.getCarxpos()[c.getCxpos1()], c.getY1pos());
            car2.paintIcon(this, g, c.getCarxpos()[c.getCxpos2()], c.getY2pos());
            car4.paintIcon(this, g, c.getCarxpos()[c.getCxpos4()], c.getY4pos());
            car5.paintIcon(this, g, c.getCarxpos()[c.getCxpos5()], c.getY5pos());
            car6.paintIcon(this, g, c.getXposinseg(), c.getYposinseg());
            c.avanzamento();
            //metodo per gestire le collisioni tra i vari ostacoli, funziona per meta, decommenti la prossima riga e il metodo
            //nella condivisa per vedere il funzionamento
//          c.gestionecollisioniostacoli();       
            c.gameover();
            //grafica score e speed
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
            g.drawString("Score : " + c.getScore(), 140, 70);
            g.drawString(c.getSpeed() + " Km/h", 453, 70);
            c.gestionevelocita();

            //delay 
            c.gestionedelay();
            //grafica game over
            if (c.isGameover()) {
                ImageIcon talebano = new ImageIcon("./assets/esplosione.png");
                Image tmp = talebano.getImage();
                tmp = tmp.getScaledInstance(230, 270, java.awt.Image.SCALE_SMOOTH);
                talebano = new ImageIcon(tmp);
                talebano.paintIcon(this, g, c.getXpos() - talebano.getIconWidth() / 4, c.getYpos() - talebano.getIconHeight() / 4);
                g.setColor(Color.gray);
                g.fillRect(120, 210, 460, 200);
                g.setColor(Color.DARK_GRAY);
                g.fillRect(130, 220, 440, 180);
                g.setFont(new Font("Serif", Font.BOLD, 50));
                g.setColor(Color.yellow);
                g.drawString("Game Over !", 210, 270);
                g.setColor(Color.white);
                g.setFont(new Font("Arial", Font.BOLD, 30));
                c.setTimer(c.getTimer() / 1000);
                g.drawString("Tempo di gioco: " + c.getTimer(), 210, 330);
                g.setFont(new Font("Arial", Font.BOLD, 20));
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
    }

    /**
     * @name main
     * @brief classe main
     * @param args[] variabile di tipo stringa
     */
    public static void main(String args[]) {
        giocoseparato c = new giocoseparato("Car Game");
    }

    /**
     * @name Keypressed
     * @brief metodo gestione evento tasto premuto
     * @param Keyevent e, parametro per il richiamo e la gestione dei vari
     * eventi
     */
    @Override
    public void keyPressed(KeyEvent e) {
        // TODO Auto-generated method stub
        if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
            System.exit(0);
        }

        if (e.getKeyCode() == KeyEvent.VK_ENTER && menu == 0) {
            c.setGameover(false);
            paint = true;
            menu = 1;
            a1.start();
            a2.start();
            a3.start();
            o.start();
            o2.start();
            om1.start();
            om2.start();
            gs.start();
            gs2.start();
            i.start();
            c.setTinizio(new Date().getTime());
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT && !c.isGameover()) {
            if (menu == 1) {
                c.setXpos(c.getXpos() - 100);
                if (c.getXpos() < 100) {
                    c.setXpos(100);
                }
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT && !c.isGameover()) {
            if (menu == 1) {
                c.setXpos(c.getXpos() + 100);
                if (c.getXpos() > 400) {
                    c.setXpos(400);
                }
            }
        }

        if (e.getKeyCode() == KeyEvent.VK_ENTER && c.isGameover()) {
            c.setGameover(false);
            paint = false;
            c.setCxpos1(0);
            c.setCxpos2(2);

            c.setCxpos4(1);
            c.setCxpos5(3);
            c.setCypos1(util.RandomRange(0, 4));
            c.setCypos2(util.RandomRange(0, 4));

            c.setCypos4(util.RandomRange(0, 4));
            c.setCypos5(util.RandomRange(0, 4));
            c.setY1pos(c.getCarypos()[c.getCypos1()]);
            c.setY2pos(c.getCarypos()[c.getCypos2()]);

            c.setY4pos(c.getCarypos()[c.getCypos4()]);
            c.setY5pos(c.getCarypos()[c.getCypos5()]);
            c.setTinizio(new Date().getTime());
            c.setTfine(new Date().getTime());
            c.setScore(0);
            c.setSpeed(50);
            c.setDelay(150);
            c.setXpos(300);
            c.setYpos(400);
            c.setXposinseg(c.getXpos());
            c.setYposinseg(c.getYposinseg());

        }

    }

    /**
     * @name Keyreleased
     * @brief metodo gestione evento tasto rilasciato
     * @param Keyevent arg0, parametro per il richiamo e la gestione dei vari
     * eventi
     */
    @Override
    public void keyReleased(KeyEvent arg0) {
        // TODO Auto-generated method stub

    }

    /**
     * @name Keytyped
     * @brief metodo gestione evento tasto typpato
     * @param Keyevent e, parametro per il richiamo e la gestione dei vari
     * eventi
     */
    @Override
    public void keyTyped(KeyEvent e) {
        System.out.println(c.isGameover());
        if (!c.isGameover() && menu == 1) {
            if ((e.getKeyChar() == 'a' || e.getKeyChar() == 'A') && !c.isGameover()) {
                if (c.getXpos() != 100) {
                    c.setXpos(c.getXpos() - 100);

                }

            }
            if ((e.getKeyChar() == 'd' || e.getKeyChar() == 'D') && !c.isGameover()) {
                if (c.getXpos() != 500) {
                    c.setXpos(c.getXpos() + 100);
                }
            }
            if ((e.getKeyChar() == 'w' || e.getKeyChar() == 'W') && !c.isGameover()) {
                if (c.getSpeed() < 130) {
                    c.setSpeed(c.getSpeed() + 5);
                    c.setDelay(c.getDelay() - 5);
                }

            }
            if ((e.getKeyChar() == 's' || e.getKeyChar() == 'S') && !c.isGameover()) {
                if (c.getSpeed() > 50) {
                    c.setSpeed(c.getSpeed() - 5);
                    c.setDelay(c.getDelay() + 5);
                }
            }
            repaint();
        }
        // TODO Auto-generated method stub

    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        // TODO Auto-generated method stub

    }
    /**
     * @name getmenu()
     * @brief get valore menu
     */
    public int getmenu() {
        return menu;
    }
}
