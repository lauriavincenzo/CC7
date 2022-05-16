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
 * @author sireci_edoardo
 */
public class Thread_ostacolimobili extends Thread{
    condivisa c;

    public Thread_ostacolimobili(condivisa c) {
        this.c = c;
    }
    
    @Override
    public void run() {
        synchronized (this) {
            while(true){
            int time = util.RandomRange(300,700);
            System.out.println("ostacolellomonello");
//            c.incrementopos();
            c.gestioneostacolimobili();
            try {
                sleep(time);
            } catch (InterruptedException ex) {
                Logger.getLogger(Alberi.class.getName()).log(Level.SEVERE, null, ex);
            }
        }     
        } 
        }
       
   }
       
