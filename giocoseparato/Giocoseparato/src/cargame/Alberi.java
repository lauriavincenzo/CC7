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
public class Alberi extends Thread {
      CarGame cg;
      condivisa c;
      

    public Alberi(CarGame cg, condivisa c) {
        this.cg = cg;
        this.c = c;
    }

    @Override
    public void run() {
        while(c.riposizionamentoAlberi()>=0){
            int time = util.RandomRange(500,1000);
            try {
                sleep(time);
            } catch (InterruptedException ex) {
                Logger.getLogger(Alberi.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
     
      
}
