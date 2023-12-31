/**
 * Quick find
 * O ( n ) for find
 * O( n ) for initialization
 * O( n ) for union
 * Trees can get very tall
 */
package unionFind;

import java.util.Scanner;

public class QuickUnion {
    private static int[] id;

    public QuickUnion(int n) {
        id = new int[n];
        for(int i =0 ; i < n ; i++){
            id[i] = i;
        }
    }

    public static int root(int i){
        while(id[i] != i){
            i = id[i];
        }
        return i;
    }

    public static boolean connected(int p , int q){
        return root(p) == root(q);
    }

    public static void union(int p, int q){
        id[root(p)] = root(q);
    }

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter total number of nodes");
        int n = scan.nextInt();
        QuickUnion eager = new QuickUnion(n);

        int choice = 0;
        while(choice != 3){
            System.out.println("Enter your choice : ");
            System.out.println("1. Check connected");
            System.out.println("2. Enter union");
            System.out.println("3. Exit");
            choice = scan.nextInt();
            if(choice == 1){
                System.out.println("Enter p and q");
                int p = scan.nextInt();
                int q = scan.nextInt();
                System.out.println(p + " and " + q + (connected(p, q)? " are connected" : " are not connected"));
            }
            if(choice == 2){
                System.out.println("Enter p and q");
                int p = scan.nextInt();
                int q = scan.nextInt();
                union(p, q);
                System.out.println("Connected " +  p + " and " +  q);
            }
        }
    }
}
