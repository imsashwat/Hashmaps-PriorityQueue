package Hashmaps;
import java.io.*;
import java.util.*;


public class medianPriorityQueue {
    
    public static class median {
        PriorityQueue<Integer> left;
        PriorityQueue<Integer> right;

        public median() {
            left = new PriorityQueue<>(Collections.reverseOrder());
            right = new PriorityQueue<>();
        }

        public void add(int val) {

        }

        public int remove() {

        }

        public int peek() {
            if(left.size() >= right.size()) {
                
            }
        }
    }
}
