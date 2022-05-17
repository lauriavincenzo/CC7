/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cargame;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sireci
 */
public class Thread_Ostacolifissi extends Thread{
    condivisa c;

    public Thread_Ostacolifissi(condivisa c) {
        this.c = c;
    }

    @Override
    public void run() {
        synchronized (this) {
        while(true){
            
            System.out.println("ostacolofisso");
//            c.incrementopos();
            c.gestioneostacolifissi();
            try {
                sleep(500);
            } catch (InterruptedException ex) {
                Logger.getLogger(Alberi.class.getName()).log(Level.SEVERE, null, ex);
            }
        }     
        }
       
    }
    
}
