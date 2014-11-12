/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package lottomachine;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
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
    static Hashtable<Integer, LottoSet> totalComb = new Hashtable<Integer, LottoSet>();
    static int num_pick = 2;//6;
    static int num_range = 6;//49;
    static int[] num_select;
    static int counter = 0;
    static String fileName = "totalCombinations.txt";
    static File file = new File(fileName);
            
    public static void main(String[] args) {
        
        if(!file.exists()){
            populateSelect();
            generateSelect();
            outputTotalComb();
            System.out.println("Total number of combinations: "+counter);
        }else{
            
        }
        
        
    }
    
    public static void populateSelect(){
        num_select = new int[num_range];
        for(int i = 0 ; i < num_range ; i++)
            num_select[i] = i+1;
        
        //for(int i = 0 ; i < num_range ; i++)
        //    System.out.println(num_select[i]);
    }
    
    private static void generateSelect(){
        int[] data = new int[num_pick];
        generateSelectUtil(0, data, 0);
    }

    private static void generateSelectUtil(int index, int[] data, int i){
        if(index==num_pick){
            counter++;
            ArrayList input = new ArrayList();
            for(int j=0 ; j<num_pick ; j++){
                //data[j];
                //System.out.print(data[j]+" ");
                input.add(data[j]);
            }
            //System.out.println();
            LottoSet toPutIn = new LottoSet(counter, input);
            totalComb.put(counter, toPutIn);
            
            for(int j=0;j<num_pick;j++)
                System.out.print(input.get(j));
            System.out.println();
            System.out.println("-->"+counter+"..."+toPutIn.getArray().toString());
            System.out.println("-->"+counter+"..."+totalComb.get(counter).getArray().toString());
            
            return;
        }
        
        if(i>=num_range)
            return;
        
        data[index] = num_select[i];
        generateSelectUtil(index+1, data, i+1);
        generateSelectUtil(index, data, i+1);
    }
    
    private static void outputTotalComb(){
        try{
            file.createNewFile();
            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
            
            for(int i=1 ; i<=counter ; i++){
                bw.write(totalComb.get(i).getArray().toString());
                System.out.println(i+"..."+totalComb.get(i).getArray().toString());
                bw.newLine();
            }
            bw.close();
            System.out.println(fileName+" -- Done.");
        } catch(IOException e){
            e.printStackTrace();
        }
        
    }
    
}
