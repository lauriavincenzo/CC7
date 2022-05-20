/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cargame;

/**
 *
 * @author sireci_edoardo
 */
public class util {
    /**
     * @name randomrange
     * @brief metodo che da un valore random
     * @param1 min, di tipo intero, sarebbe il valore minimo del range da cui prendere un valore random
     * @param2 max, di tipo intero, sarebbe il valore massimo del range da cui prendere un valore random
     */
    static int RandomRange(int min, int max) {
        return(int)(Math.random()*(max-min+1)+min);
    }
}
