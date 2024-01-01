/**
 * Quick find
 * O ( 1 ) for find
 * O( n ) for initialization
 * O( n^2 ) for union
 */


package dynamicConnectivity;

import java.util.Scanner;

public class QuickFindEager {

    private static int[] arr;

    public QuickFindEager(int n) {
        arr = new int[n];
        for(int i =0 ; i < n ; i++){
            arr[i] = i;
        }
    }

    public static boolean connected(int p, int q){
        return arr[p] == arr[q];
    }

    public static void union(int p, int q){
        int pid = arr[p];
        int qid = arr[q];
        for(int i = 0; i < arr.length; i++ ){
            if(arr[i] == pid) arr[i] = qid;
        }
    }

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter total number of nodes");
        int n = scan.nextInt();
        QuickFindEager eager = new QuickFindEager(n);

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
