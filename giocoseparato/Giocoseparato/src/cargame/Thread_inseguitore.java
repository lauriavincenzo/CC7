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
 * @author sireci_edoardo
 * @class Thread_inseguitore
 * @brief thread per andare a gestire il movimento dell'inseguitore
 * 
 */
public class Thread_inseguitore extends Thread {
    ///oggetti che servono a richiamare i metodi di condivisa e main
    condivisa c;
    giocoseparato gs;
    ///costruttore parametrico per inizializzare gli oggetti passati
    public Thread_inseguitore(condivisa c, giocoseparato gs) {
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
                int time = util.RandomRange(300, 500);
                c.inseguitore();
                try {
                    sleep(time);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Thread_alberi.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }  
}
