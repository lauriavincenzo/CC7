/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cargame;

import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sireci
 * @class Thread_ostacolimobili
 * @brief thread per andare a gestire il movimento degli ostacoli mobili
 * 
 */
public class Thread_ostacolimobili extends Thread {
    ///oggetti che servono a richiamare i metodi di condivisa e main
    condivisa c;
    giocoseparato gs;
    ///costruttore parametrico per inizializzare gli oggetti passati
    public Thread_ostacolimobili(condivisa c, giocoseparato gs) {
        this.c = c;
        this.gs = gs;
    }
    /**
     * @name run
     * @brief metodo che fa andare il thread all'infinito una volta partito, salvo altri controlli che servono a fermarlo
     * 
     */
    @Override
    public void run() {
        synchronized (this) {
            while (true) {

                System.out.println("ostacolellomonello");
//            c.incrementopos();
                c.gestioneostacolimobili();
                if ((c.getSpeed() > 49) && (c.getSpeed() < 70)) {
                    try {
                        sleep(350);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Thread_ostacolimobili.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else if ((c.getSpeed() > 69) && (c.getSpeed() < 90)) {
                    try {
                        sleep(250);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Thread_ostacolimobili.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else if ((c.getSpeed() > 89) && (c.getSpeed() < 110)) {
                    try {
                        sleep(150);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Thread_ostacolimobili.class.getName()).log(Level.SEVERE, null, ex);
                    }

                } else if ((c.getSpeed() > 109) && (c.getSpeed() < 131)) {
                    try {
                        sleep(100);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Thread_ostacolimobili.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

            }
        }
    }
}
