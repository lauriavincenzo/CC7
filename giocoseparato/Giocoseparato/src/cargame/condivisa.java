/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cargame;

import java.awt.image.BufferedImage;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author sireci_edoardo
 * @class condivisa
 * @brief classe principale, vengono dichiarate tutte le variabili, scritti
 * tutti i metodi da implementare poi nel main e nei thread
 *
 */
public class condivisa {

    /**
     * @var vett è il vettore che contiene le posizioni degli alberi
     */
    public int vett[];
    /**
     * @var movimentostrada è la variabile di controllo di movimento della
     * strada
     */
    int movimentostrada;
    /**
     * @var num1 è il valore che potra andare random da 0 a 500 per stabilire la
     * coordinata precisa di ogni albero
     */
    private int num1 = 400;
    /**
     * @var xpos,ypos,xposinseg,yposinseg sono le coordinate di x e y di
     * protagonistta e inseguitore
     */
    private int xpos, xposinseg;
    private int ypos, yposinseg;
    /**
     * @var carxpos e carypos sono i vettori che conterranno tutte le posizioni
     * che possono assumere gli ostacoli
     */
    private int carxpos[];
    private int carypos[];
    /**
     * @var cxpos1,cxpos2,cxpos4,cxpos5,cypos1,cypos2,cypos4,cypos5 sono le x di
     * ogni ostacolo,mentre y1pos,y2pos,y4pos,y5pos sono le y di ogni ostacolo
     */
    private int cxpos1, cxpos2, cxpos4, cxpos5;
    private int cypos1, cypos2, cypos4, cypos5;
    private int y1pos, y2pos, y4pos, y5pos;
    /**
     * @var timer è la vvariabile che terra il conto della durata della partita
     * ed è data dalla differenza tra tfine-tinizio
     */
    private long timer;
    private long tinizio, tfine;
    /**
     * @var gameover è la variabile di controllo di gameover
     */
    private boolean gameover = false;
    /**
     * @var delay è la variabile che gestisce la velocità di movimento del
     * gioco, più essa è bassa più il gioco va veloce
     */
    private int delay;
    /**
     * @var speed,score sono le variabili che terranno conto di velocità e
     * puntegio della partita
     */
    int speed;
    float score;
    giocoseparato g;

    /**
     * @brief costruttore, serve a inizializzare tutte le variabili che verranno
     * utilizzate
     */
    public condivisa() {
        vett = new int[]{400, -200, -500, 100, -300, 500};
        num1 = util.RandomRange(0, 499);
        ypos = 600;
        xpos = 300;
        xposinseg = xpos;
        yposinseg = 900;
        carxpos = new int[]{100, 200, 300, 400, 500};
        carypos = new int[]{-240, -480, -720, -960, -1200};
        cxpos1 = 0;
        cxpos2 = 2;
        cxpos4 = 1;
        cxpos5 = 3;
        cypos1 = util.RandomRange(0, 4);
        cypos2 = util.RandomRange(0, 4);
        y1pos = carypos[cypos1];
        y2pos = carypos[cypos2];
        y4pos = carypos[cypos4];
        y5pos = carypos[cypos5];
        speed = 50;
        score = 0;
        delay = 150;
        movimentostrada = 0;

    }

    /**
     * @name inseguitore
     * @brief metodo per andare a gestire il movimento dell'inseguitore. Questo
     * metodo poi verrà utilizzato nel thread_inseguitore
     */
    public void inseguitore() {
        xposinseg = xpos;
        if ((speed > 49 && speed < 70) || (score > 200 && score < 400)) {
            yposinseg = 700;
        } else if ((speed > 69 && speed < 90) || (score > 500 && score < 700)) {
            yposinseg = 650;
        } else if ((speed > 89 && speed < 110) || (score > 800 && score < 1000)) {
            yposinseg = 600;
        } else if ((speed > 109 && speed < 131) || (score > 1100 && score < 1300)) {
            yposinseg = 550;
        }

    }

    public int getMovimentostrada() {
        return movimentostrada;
    }

    public void setMovimentostrada(int movimentostrada) {
        this.movimentostrada = movimentostrada;
    }

    /**
     * @name avanzamento
     * @brief metodo per a gestire l'avanzamento della auto del protagonista ad
     * aumentare della velocità
     */
    public void avanzamento() {
        if ((speed > 49 && speed < 70) || (score > 200 && score < 400)) {
            ypos = 500;
        } else if ((speed > 69 && speed < 90) || (score > 500 && score < 700)) {
            ypos = 450;
        } else if ((speed > 89 && speed < 110) || (score > 800 && score < 1000)) {
            ypos = 400;
        } else if ((speed > 109 && speed < 131) || (score > 1100 && score < 1300)) {
            ypos = 350;
        }
    }

    public void setXposinseg(int xposinseg) {
        this.xposinseg = xposinseg;
    }

    public void setYposinseg(int yposinseg) {
        this.yposinseg = yposinseg;
    }

    public int getXposinseg() {
        return xposinseg;
    }

    public int getYposinseg() {
        return yposinseg;
    }

    public int getTree1ypos() {
        return vett[0];
    }

    public int getTree2ypos() {
        return vett[1];
    }

    public int getTree3ypos() {
        return vett[2];
    }

    public int getTree4ypos() {
        return vett[3];
    }

    public int getTree5ypos() {
        return vett[4];
    }

    public int getTree6ypos() {
        return vett[5];
    }

    public void setTree1ypos(int tree1ypos) {
        this.vett[0] = tree1ypos;
    }

    public void setTree2ypos(int tree2ypos) {
        this.vett[1] = tree2ypos;
    }

    public void setTree3ypos(int tree3ypos) {
        this.vett[2] = tree3ypos;
    }

    public void setTree4ypos(int tree4ypos) {
        this.vett[3] = tree4ypos;
    }

    public void setTree5ypos(int tree5ypos) {
        this.vett[4] = tree5ypos;
    }

    public void setTree6ypos(int tree6ypos) {
        this.vett[5] = tree6ypos;
    }

    /**
     * @name riposizionamentoalberi
     * @brief metodo per andare a gestire la collocazione degli alberi lungo il
     * lato della strada. Metodo applicato nel suo thread
     */
    public int riposizionamentoAlberi() {

        if (vett[0] > 700) {
            num1 = util.RandomRange(0, 499);
            vett[0] = -num1;

        }
        if (vett[1] > 700) {
            num1 = util.RandomRange(0, 499);
            vett[1] = -num1;

        }
        if (vett[2] > 700) {
            num1 = util.RandomRange(0, 499);
            vett[2] = -num1;
        }
        if (vett[3] > 700) {
            num1 = util.RandomRange(0, 499);
            vett[3] = -num1;

        }
        if (vett[4] > 700) {
            num1 = util.RandomRange(0, 499);
            vett[4] = -num1;

        }
        if (vett[5] > 700) {
            num1 = util.RandomRange(0, 499);
            vett[5] = -num1;

        }
        return -1;
    }

    /**
     * @name incrementopos
     * @brief metodo che va a incrementare ogni tot le posizioni dei vari alberi
     * in modo da farli scendere nello schermo
     */
    public void incrementopos() {
        vett[0] += 50;
        vett[1] += 50;
        vett[2] += 50;
        vett[3] += 50;
        vett[4] += 50;
        vett[5] += 50;

    }

    public int getY1pos() {
        return y1pos;
    }

    public int getY2pos() {
        return y2pos;
    }

    public int getY4pos() {
        return y4pos;
    }

    public int getY5pos() {
        return y5pos;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setTimer(long timer) {
        this.timer = timer;
    }

    public long getTimer() {
        return timer;
    }

    public int getDelay() {
        return delay;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getSpeed() {
        return speed;
    }

    public boolean isGameover() {
        return gameover;
    }

    public float getScore() {
        return score;
    }

    public void incrementoscore() {
        score++;
    }

    public void incrementospeed() {
        speed++;
    }

    public int getXpos() {
        return xpos;
    }

    public int getYpos() {
        return ypos;
    }

    public int[] getCarxpos() {
        return carxpos;
    }

    public int[] getCarypos() {
        return carypos;
    }

    public int getCxpos1() {
        return cxpos1;
    }

    public int getCxpos2() {
        return cxpos2;
    }

    public int getCxpos4() {
        return cxpos4;
    }

    public int getCxpos5() {
        return cxpos5;
    }

    public int getCypos1() {
        return cypos1;
    }

    public int getCypos2() {
        return cypos2;
    }

    public int getCypos4() {
        return cypos4;
    }

    public int getCypos5() {
        return cypos5;
    }

    public void decrementoy() {
        ypos -= 40;
    }

    /**
     * @name controlloy
     * @brief metodo controllo che la coordinata y del protagonista non scenda
     * sotto il valore di 400
     */
    public void controlloy() {
        if (ypos < 400) {
            ypos = 400;
        }
    }

    /**
     * @name gestioneostacolifissi
     * @brief metodo per andare a gestire il collocamento degli ostacoli fissi
     * lungo la strada. Metodo utilizzato nel thread_ostacolifissi
     */
    public void gestioneostacolifissi() {
        y1pos += 25;
        y2pos += 25;

        if (y1pos > 700) {
            cxpos1++;
            if (cxpos1 > 4) {
                cxpos1 = 0;
            }
            cxpos1 = util.RandomRange(0, 4);
            cypos1 = util.RandomRange(0, 4);
            y1pos = carypos[cypos1];

        }
        if (y2pos > 700) {
            cxpos2++;
            if (cxpos2 > 4) {
                cxpos2 = 0;
            }

            cxpos2 = util.RandomRange(0, 4);
            cypos2 = util.RandomRange(0, 4);
            y2pos = carypos[cypos2];

        }

        if (cxpos1 < 2 && cxpos2 < 2) {
            if (cxpos1 == 0 && cxpos2 == 1) {

                cxpos2++;
            } else if (cxpos1 == 1 && cxpos2 == 0) {
                cxpos1++;
                cxpos2++;
            }
        }
    }

    /**
     * @name gestioneostacolimobili
     * @brief Metodo per andare gestire il movimento degli ostacoli
     * mobili.Metodo che verrà poi utilizzato nel Thread_ostacolomobili
     */
    public void gestioneostacolimobili() {
        y4pos += 40;
        y5pos += 40;
        if (y4pos > 700) {
            cxpos4++;
            if (cxpos4 > 4) {
                cxpos4 = 0;
            }
            cxpos4 = util.RandomRange(0, 4);
            cypos4 = util.RandomRange(0, 4);
            y4pos = carypos[cypos4];

        }
        if (y5pos > 700) {
            cxpos5++;
            if (cxpos5 > 4) {
                cxpos5 = 0;
            }

            cxpos5 = util.RandomRange(0, 4);
            cypos5 = util.RandomRange(0, 4);
            y5pos = carypos[cypos5];

        }

        if (cxpos4 == cxpos5 && cypos4 > -100 && cypos5 > -100) {

            cxpos4 -= 1;
            if (cxpos4 < 0) {
                cxpos4 += 2;
            }
        }

        if (cxpos4 < 2 && cxpos5 < 2) {
            if (cxpos4 == 0 && cxpos5 == 0) {
                cxpos4++;
            } else if (cxpos4 == 0 && cxpos5 == 1) {
                cxpos4++;
                cxpos5++;
            }
        }
    }

    /**
     * @name gameover
     * @brief metodo per andare a controllare il gameover
     */
    public void gameover() {
        if ((y1pos < ypos && y1pos + 175 > ypos && carxpos[cxpos1] == xpos) || (y2pos < ypos && y2pos + 175 > ypos && carxpos[cxpos2] == xpos) || (y4pos < ypos && y4pos + 175 > ypos && carxpos[cxpos4] == xpos) || (y5pos < ypos && y5pos + 175 > ypos && carxpos[cxpos5] == xpos) || (ypos < y1pos && ypos + 175 > y1pos && carxpos[cxpos1] == xpos) || (ypos < y2pos && ypos + 175 > y2pos && carxpos[cxpos2] == xpos) || (ypos < y4pos && ypos + 175 > y4pos && carxpos[cxpos4] == xpos) || (ypos < y5pos && ypos + 175 > y5pos && carxpos[cxpos5] == xpos)) {

            gameover = true;
            tfine = new Date().getTime();
            timer = tfine - tinizio;

        }

    }

    /**
     * @name gestionecollisioniostacoli
     * @brief metodo per gestire le collisioni tra gli ostacoli lungo la strada.
     * Il metodo è tutto commentato perche funziona a meta. Invece che fermare
     * il movimento dei veicoli una volta in collisione, il metodo aspetta che
     * le macchine s sovrappongano completamentte prima di spostarla, per questo
     * è tutto commentato
     */
    /* 
    public void gestionecollisioniostacoli() {
        if (y1pos< y2pos && y1pos+175> y2pos && carxpos[cxpos1] ==carxpos[cxpos2] ) {
            y1pos=y2pos-175;
        }
        if (y1pos< y4pos && y1pos+175> y4pos && carxpos[cxpos1] ==carxpos[cxpos4] ) {
            y1pos=y4pos-175;
        }
        if (y1pos< y5pos && y1pos +175> y5pos && carxpos[cxpos1] ==carxpos[cxpos5] ) {
            y1pos=y5pos-175;
        }
        if (y2pos < y4pos && y2pos+175> y4pos && carxpos[cxpos2] ==carxpos[cxpos4] ) {
            y2pos=y4pos-175;
        }
        if (y2pos< y5pos && y2pos+175> y5pos && carxpos[cxpos2] ==carxpos[cxpos5] ) {
            y2pos=y5pos-175;
        }
        
        if (y4pos< y5pos && y4pos+175 > y5pos && carxpos[cxpos4] == carxpos[cxpos5]) {
            y4pos=y5pos-175;
        }
    }
     */
    /**
     * @name gestionedelay
     * @brief metodo per andare a gestire il valore del delay durante il gioco
     */
    public void gestionedelay() {
        try {

            TimeUnit.MILLISECONDS.sleep(delay);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        if ((y1pos < ypos && y1pos + 175 > ypos && carxpos[cxpos1] == xpos) || (y2pos < ypos && y2pos + 175 > ypos && carxpos[cxpos2] == xpos) || (y4pos < ypos && y4pos + 175 > ypos && carxpos[cxpos4] == xpos) || (y5pos < ypos && y5pos + 175 > ypos && carxpos[cxpos5] == xpos)) {
            gameover = true;
            tfine = new Date().getTime();
            timer = tfine - tinizio;
        }

    }

    public void setXpos(int xpos) {
        this.xpos = xpos;
    }

    public void setYpos(int ypos) {
        this.ypos = ypos;
    }

    public void setCxpos1(int cxpos1) {
        this.cxpos1 = cxpos1;
    }

    public void setCxpos2(int cxpos2) {
        this.cxpos2 = cxpos2;
    }

    public void setCxpos4(int cxpos4) {
        this.cxpos4 = cxpos4;
    }

    public void setCxpos5(int cxpos5) {
        this.cxpos5 = cxpos5;
    }

    public void setCypos1(int cypos1) {
        this.cypos1 = cypos1;
    }

    public void setCypos2(int cypos2) {
        this.cypos2 = cypos2;
    }

    public void setCypos4(int cypos4) {
        this.cypos4 = cypos4;
    }

    public void setCypos5(int cypos5) {
        this.cypos5 = cypos5;
    }

    public void setY1pos(int y1pos) {
        this.y1pos = y1pos;
    }

    public void setY2pos(int y2pos) {
        this.y2pos = y2pos;
    }

    public void setY4pos(int y4pos) {
        this.y4pos = y4pos;
    }

    public void setY5pos(int y5pos) {
        this.y5pos = y5pos;
    }

    public void setTinizio(long tinizio) {
        this.tinizio = tinizio;
    }

    public void setTfine(long tfine) {
        this.tfine = tfine;
    }

    public void setGameover(boolean gameover) {
        this.gameover = gameover;
    }

    public void setDelay(int delay) {
        this.delay = delay;
    }

    /**
     * @name gestionevelocita
     * @brief metodo che serve mettere un limite massimo alla velocità
     */
    public void gestionevelocita() {
        if (speed > 130) {
            speed = 130;
        }
    }

    /**
     * @name gestionescore
     * @brief metodo che serve a incrementare lo score. Viene utilizzato nel
     * Thread_score
     */
    public void gestionescore() {
        score += 0.5;
    }
}
