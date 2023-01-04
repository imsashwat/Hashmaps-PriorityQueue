package Hashmaps;
import java.util.*;
import java.io.*;

public class largestConsecSeqence {
    
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[] arr = new int[n];

        for(int i=0; i<arr.length; i++) {
            arr[i] = scn.nextInt();

        }

        HashMap<Integer, Boolean> map = new HashMap<>();
        for(int val: arr) {
            map.put(val, true);
        }

        for(int val: arr) {
            if(map.containsKey(val-1)){
                map.put(val, false);
            }
        }

        int msp = 0; //max val jo start point h or array mai bhi pehle occur ho rhi h
        int ml = 0; //jo max val h uski length kitni h jb tk vo seq follow kr rha h

        for(int val: arr) {
            //ab map ki vo vales jo true h (they are a beginning point for a seq)
            if(map.get(val) == true) {
                int tl = 1;  //temp length until finalized for this current key
                int tsp = val; //temporary start point key h current 

                while(map.containsKey(tsp + val)) {
                    tl++;
                }

                if(tl>ml) {
                    msp = tsp;
                    ml = tl;
                }
            }
        }

        for(int i =msp; i<ml; i++) {
            System.out.println("-" + msp);
        }
    }
}
