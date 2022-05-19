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
 */
public class Thread_Ostacolifissi extends Thread{
    condivisa c;
    giocoseparato gs;
    public Thread_Ostacolifissi(condivisa c,giocoseparato gs) {
        this.c = c;
        this.gs=gs;
    }

    @Override
    public void run() {
        synchronized (this) {
        while(true){
            
            System.out.println("ostacolofisso");
//            c.incrementopos();
            c.gestioneostacolifissi();
            if ((c.getSpeed() > 49) && (c.getSpeed() < 70)) {
                    try {
                        sleep(350);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Thread_ostacolimobili.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else if ((c.getSpeed() > 69) && (c.getSpeed() < 90)) {
                    try {
                        sleep(300);
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
                        sleep(200);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Thread_ostacolimobili.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
        }     
        }
       
    }
    
}
