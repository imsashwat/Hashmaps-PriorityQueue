package Hashmaps;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Map.Entry;
import java.util.*;

public class HashMaps {

    public static void main(String[] args) {
        
        // create a hashmap
            
        String str = "b,a,b,c,,c,c,d,b,a,,b,c,c,c,d";

        HashMap<Character, String> hm = new HashMap<>();

        for(int i=0; i<str.length();i++) {
            char ch = str.charAt(i);

            if(hm.containsKey(ch)) {
                String of = hm.get(ch);
                String nf = of+1;
                hm.put(ch, nf);
            } else {
                hm.put(ch, 1);
            }
        }

        char mfc = str.charAt(0);
        for(Character key : hm.keySet()) {
            if(hm.get(key) > hm.get(mfc)) {
                mfc = key;
            }
        } 
        System.out.println(mfc); 
        }        
    }