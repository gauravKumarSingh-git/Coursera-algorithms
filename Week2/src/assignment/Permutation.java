//package assignment;

import edu.princeton.cs.algs4.StdIn;

public class Permutation {
    public static void main(String[] args){
        RandomizedQueue<String> randomQueue = new RandomizedQueue<>();
        int k = Integer.parseInt(args[0]);
        while(!StdIn.isEmpty()){
            String s = StdIn.readString();
            randomQueue.enqueue(s);
        }

        while(k > 0){
            System.out.println(randomQueue.dequeue());
            k--;
        }

    }
}
