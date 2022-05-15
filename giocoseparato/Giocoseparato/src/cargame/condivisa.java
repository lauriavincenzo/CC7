/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cargame;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author sireci_edoardo
 */
public class condivisa {

    public int vett[];
    private int num1 = 400;
    private int movimentostrada;
    private int xpos;
    private int ypos;
    private int carxpos[];
    private int carypos[];
    private int cxpos1, cxpos2, cxpos3;
    private int cypos1, cypos2, cypos3;
    private int y1pos, y2pos, y3pos;
    private long timer;
    private long tinizio, tfine;
    private boolean gameover = false;
    private int delay = 100;
    int speed, score;

    public condivisa() {
        vett = new int[]{400, -200, -500, 100, -300, 500};
        num1 = util.RandomRange(0, 499);
        movimentostrada = 0;
        ypos = 700;
        xpos = 300;
        carxpos = new int[]{100, 200, 300, 400, 500};
        carypos = new int[]{-240, -480, -720, -960, -1200};
        cxpos1 = 0;
        cxpos2 = 2;
        cxpos3 = 4;
        cypos1 = util.RandomRange(0, 4);
        cypos2 = util.RandomRange(0, 4);
        cypos3 = util.RandomRange(0, 4);
        y1pos = carypos[cypos1];
        y2pos = carypos[cypos2];
        y3pos = carypos[cypos3];
        tinizio = new Date().getTime();
        speed = 50;
        score = 0;

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

    public int riposizionamentoAlberi() {

        if (vett[0] > 700) {
            num1 = util.RandomRange(0, 499);
            vett[0] = -num1;
            return vett[0];
        }
        if (vett[1] > 700) {
            num1 = util.RandomRange(0, 499);
            vett[1] = -num1;
            return vett[1];
        }
        if (vett[2] > 700) {
            num1 = util.RandomRange(0, 499);
            vett[2] = -num1;
            return vett[2];
        }
        if (vett[3] > 700) {
            num1 = util.RandomRange(0, 499);
            vett[3] = -num1;
            return vett[3];
        }
        if (vett[4] > 700) {
            num1 = util.RandomRange(0, 499);
            vett[4] = -num1;
            return vett[4];
        }
        if (vett[5] > 700) {
            num1 = util.RandomRange(0, 499);
            vett[5] = -num1;
            return vett[5];
        }
        return -1;
    }

    public void incrementopos() {
        vett[0] += 50;
        vett[1] += 50;
        vett[2] += 50;
        vett[3] += 50;
        vett[4] += 50;
        vett[5] += 50;

    }

    public int getMovimentostrada() {
        return movimentostrada;
    }

    public void setMovimentostrada(int movimentostrada) {
        this.movimentostrada = movimentostrada;
    }

    public int getY1pos() {
        return y1pos;
    }

    public int getY2pos() {
        return y2pos;
    }

    public int getY3pos() {
        return y3pos;
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

    public int getScore() {
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

    public int getCxpos3() {
        return cxpos3;
    }

    public int getCypos1() {
        return cypos1;
    }

    public int getCypos2() {
        return cypos2;
    }

    public int getCypos3() {
        return cypos3;
    }

    public void decrementoy() {
        ypos -= 40;
    }

    public void controlloy() {
        if (ypos < 500) {
            ypos = 500;
        }
    }

    public void gestioneostacolifissi() {
        y1pos += 50;
        y2pos += 50;
        y3pos += 50;
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
        if (y3pos > 700) {
            cxpos3++;
            if (cxpos3 > 4) {
                cxpos3 = 0;
            }

            cxpos3 = util.RandomRange(0, 4);
            cypos3 = util.RandomRange(0, 4);
            y3pos = carypos[cypos3];

        }
        if (cxpos1 == cxpos2 && cypos1 > -100 && cypos2 > -100) {

            cxpos1 -= 1;
            if (cxpos1 < 0) {
                cxpos1 += 2;
            }
        }
        if (cxpos1 == cxpos3 && cypos1 > -100 && cypos3 > -100) {
            cxpos3 -= 1;
            if (cxpos3 < 0) {
                cxpos3 += 2;
            }
        }
        if (cxpos2 == cxpos3 && cypos3 > -100 && cypos2 > -100) {
            cxpos2 -= 1;
            if (cxpos2 < 0) {
                cxpos2 += 2;
            }
        }
        if (cxpos1 < 2 && cxpos2 < 2 && cxpos3 < 2) {
            if (cxpos1 == 0 && cxpos2 == 0 && cxpos3 == 1) {
                cxpos3++;
                cxpos2++;
            } else if (cxpos1 == 0 && cxpos2 == 1 && cxpos3 == 0) {
                cxpos3++;
                cxpos2++;
            } else if (cxpos1 == 1 && cxpos2 == 0 && cxpos3 == 0) {
                cxpos1++;
                cxpos2++;
            }
        }
    }

    public void gameover() {
        if (y1pos < ypos && y1pos + 175 > ypos && carxpos[cxpos1] == xpos) {
            gameover = true;
            tfine = new Date().getTime();
            timer = tfine - tinizio;
        }
        if (y2pos < ypos && y2pos + 175 > ypos && carxpos[cxpos2] == xpos) {
            gameover = true;
            tfine = new Date().getTime();
            timer = tfine - tinizio;
        }
        if (y3pos < ypos && y3pos + 175 > ypos && carxpos[cxpos3] == xpos) {
            gameover = true;
            tfine = new Date().getTime();
            timer = tfine - tinizio;
        }

        if (ypos < y1pos && ypos + 175 > y1pos && carxpos[cxpos1] == xpos) {
            gameover = true;
            tfine = new Date().getTime();
            timer = tfine - tinizio;
        }
        if (ypos < y2pos && ypos + 175 > y2pos && carxpos[cxpos2] == xpos) {
            gameover = true;
            tfine = new Date().getTime();
            timer = tfine - tinizio;
        }
        if (ypos < y3pos && ypos + 175 > y3pos && carxpos[cxpos3] == xpos) {
            gameover = true;
            tfine = new Date().getTime();
            timer = tfine - tinizio;
        }

    }

    public void gestionedelay() {
        try {

            TimeUnit.MILLISECONDS.sleep(delay);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        if (y1pos < ypos && y1pos + 175 > ypos && carxpos[cxpos1] == xpos) {
            gameover = true;
            tfine = new Date().getTime();
            timer = tfine - tinizio;
        }
        if (y2pos < ypos && y2pos + 175 > ypos && carxpos[cxpos2] == xpos) {
            gameover = true;
            tfine = new Date().getTime();
            timer = tfine - tinizio;
        }
        if (y3pos < ypos && y3pos + 175 > ypos && carxpos[cxpos3] == xpos) {
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
    public void setCxpos3(int cxpos3) {
        this.cxpos3 = cxpos3;
    }

    public void setCypos1(int cypos1) {
        this.cypos1 = cypos1;
    }

    public void setCypos2(int cypos2) {
        this.cypos2 = cypos2;
    }
    public void setCypos3(int cypos3) {
        this.cypos3 = cypos3;
    }

    public void setY1pos(int y1pos) {
        this.y1pos = y1pos;
    }

    public void setY2pos(int y2pos) {
        this.y2pos = y2pos;
    }
    public void setY3pos(int y3pos) {
        this.y3pos = y3pos;
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

    public void gestionevelocita() {
        if (speed > 130) {
            speed = 130;
        }
    }

    public void gestionescore() {
        if (score % 50 == 0) {
            score -= 10;
            if (delay < 100) {
                delay = 100;
            }
        }
    }

}
