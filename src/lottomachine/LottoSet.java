/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package lottomachine;

import java.util.ArrayList;

/**
 *
 * @author Tkai
 */
public class LottoSet implements Comparable<LottoSet> {
    static int sum;
    static ArrayList<Integer> nums;
    static int id;
    
    public LottoSet(int inputId, ArrayList<Integer> inputArray){
        nums = inputArray;
        id = inputId;
        calculateSum();
    }
    
    private void calculateSum(){
        sum=0;
        for(int i=0;i<nums.size();i++)
            sum += nums.get(i);
    }
    
    public int getSum(){
        return sum;
    }
    
    public int getId(){
        return id;
    }
    
    public ArrayList<Integer> getArray(){
        return nums;
    }

    @Override
    public int compareTo(LottoSet t) {
        if(this.getSum() > t.getSum()) return 1;
        else if (this.getSum() == t.getSum()) return 0;
        else return -1;
    }
    
    public void printContent(){
        for(int i=0 ; i<nums.size() ; i++)
            System.out.print(nums.get(i).toString()+", ");
        System.out.print("sum:"+sum);
        System.out.println();
    }
}
