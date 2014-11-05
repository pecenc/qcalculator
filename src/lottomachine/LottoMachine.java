/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package lottomachine;

import java.util.ArrayList;
import java.util.Hashtable;

/**
 *
 * @author Tkai
 */
public class LottoMachine {

    /**
     * @param args the command line arguments
     */
    static Hashtable<Integer, ArrayList> totalComb = new Hashtable<Integer, ArrayList>();
    static int num_pick = 6;
    static int num_range = 49;
    static int[] num_select;
            
    public static void main(String[] args) {
        // TODO code application logic here
        populateSelect();
    }
    
    public static void populateSelect(){
        num_select = new int[num_range];
        for(int i = 0 ; i < num_range ; i++)
            num_select[i] = i+1;
    }
}
