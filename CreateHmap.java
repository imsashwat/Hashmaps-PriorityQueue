package Hashmaps;
import java.io.*;
import java.util.*;
import java.util.LinkedList;


public class CreateHmap {
    

    public static class HashMap<K, V> {
        private class HMnode {
            K key;
            V value;

            HMnode (K key, V value) {
                this.key = key;
                this.value = value;

            }
        }

        private int size;
        private LinkedList<HMnode>[] buckets;  //linked list ka array 

        public HashMap() {
            initBuckets(4);
            size = 0;
        }

        private void initBuckets(int N) {
            buckets = new LinkedList[N];  //ban gaya array of N size
            for(int bi =0; bi<buckets.length; bi++) {
                buckets[bi] = new LinkedList<>(); //at every index 1 LinkedList is initialised
            } 
        }

        public void put(K key, V value) throws Exception{
            int bi = hashfn(key); //it will return bucketindex
            int di = getIndexwithinBucket(key, bi);
            
            if(di != -1) {
                HMnode node = buckets[bi].get(di);
                node.value = value;
            }

            else {
                HMnode node = new HMnode(key, value);
                buckets[bi].add(node);
                size++;
            }

            double lambda = size*1.0/buckets.length;
            if(lambda > 2.0) {
                rehash();
            }
        }

        private int hashfn(K key) {
            int hc = key.hashCode();  //key ne return kiya hascode
            return Math.abs(hc) % buckets.length;    //modeulus 
        }

        public int getIndexwithinBucket(K key, int bi) {
            int di = 0;

            for(HMnode node: buckets[bi]) {
                if(node.key.equals(key)){
                    return di;
                }
                di++;
            }
            return -1;

        }

        public boolean containsKey(K key) {
            int bi = hashfn(key);
            int di = getIndexwithinBucket(key, bi);

            if(di != -1) {
                return true;
            }

            else {
                return false;
            }
        }

        public V get(K key) {
            int bi = hashfn(key);
            int di = getIndexwithinBucket(key, bi);

            if(di != -1) {
                HMnode node = buckets[bi].get(di);
                return node.value;
            }

            else {
                return null;
            }
        }

        public V remove(K key) {
            int bi = hashfn(key);
            int di = getIndexwithinBucket(key, bi);

            if(di != -1) {
                HMnode node = buckets[bi].remove(di);
                size--; 
                return node.value;
            }

            else {
                return null;
            }
        }

        public int size() {
            return size();
        }

        public ArrayList<K> keySet() {
            ArrayList<K> keys = new ArrayList<>();

            for(int i=0; i<buckets.length; i++) {
                for(HMnode node: buckets[i]) {
                    keys.add(node.key);
                }
            }
            return keys;
        }

        public void rehash() throws Exception {
            LinkedList<HMnode>[] oba = buckets; //new buckets

            initBuckets(oba.length*2);
            size =0;

            for(int i=0; i<oba.length; i++) {  //copy into new from older
                for(HMnode node: oba[i]) {
                    put(node.key, node.value);
                }
            }
        }
    }
}
