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
    static int RandomRange(int min, int max) {
        return(int)(Math.random()*(max-min+1)+min);
    }
}
