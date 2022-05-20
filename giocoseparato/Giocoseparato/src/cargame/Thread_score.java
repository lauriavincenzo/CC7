/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cargame;

import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sireci
 * @class Thread_score
 * @brief thread per gestire l'incremento del punteggio durante la partita
 * 
 */
public class Thread_score extends Thread{
    ///oggetti che servono a richiamare i metodi di condivisa e main
    condivisa c;
    giocoseparato gs;
    ///costruttore parametrico per inizializzare gli oggetti passati
    public Thread_score(condivisa c, giocoseparato gs) {
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
        while(true){
            c.gestionescore();
            if ((c.getSpeed() > 49) && (c.getSpeed() < 70)) {
                    try {
                        sleep(450);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Thread_ostacolimobili.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else if ((c.getSpeed() > 69) && (c.getSpeed() < 90)) {
                    try {
                        sleep(350);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Thread_ostacolimobili.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else if ((c.getSpeed() > 89) && (c.getSpeed() < 110)) {
                    try {
                        sleep(250);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Thread_ostacolimobili.class.getName()).log(Level.SEVERE, null, ex);
                    }

                } else if ((c.getSpeed() > 109) && (c.getSpeed() < 131)) {
                    try {
                        sleep(150);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Thread_ostacolimobili.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
        }     
        }
    }
    
}
