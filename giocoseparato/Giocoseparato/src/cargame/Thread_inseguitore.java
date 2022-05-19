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
 */
public class Thread_inseguitore extends Thread {

    condivisa c;
    giocoseparato gs;

    public Thread_inseguitore(condivisa c, giocoseparato gs) {
        this.c = c;
        this.gs = gs;
    }

    @Override
    public void run() {
        synchronized (this) {
            while (true) {
                int time = util.RandomRange(200, 500);
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
