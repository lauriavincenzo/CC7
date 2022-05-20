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
 * @class Thread_alberi
 * @brief thread per gestire la collocazione degli alberi lungo i lati della strada
 * 
 */
public class Thread_alberi extends Thread {
    ///oggetti che servono a richiamare i metodi di condivisa e main
      giocoseparato cg;
      condivisa c;
      
///costruttore parametrico per inizializzare gli oggetti passati
    public Thread_alberi(giocoseparato cg, condivisa c) {
        this.cg = cg;
        this.c = c;
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
            int time = util.RandomRange(200,500);
//            System.out.println("incremento");
//            c.incrementopos();
            c.riposizionamentoAlberi();
            try {
                sleep(time);
            } catch (InterruptedException ex) {
                Logger.getLogger(Thread_alberi.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    }
     
      
}
