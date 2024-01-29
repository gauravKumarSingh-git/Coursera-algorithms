import edu.princeton.cs.algs4.Insertion;

import java.util.Arrays;
import java.util.Comparator;

public class MergeSort{
    private static final int CUTOFF = 7;

    private static <T extends Comparable<? super T>> void merge(T[] a, T[] aux, int lo, int mid, int hi){
//        for(int i = lo; i<= hi; i++){
//            aux[i] = a[i];
//        }
        int i = lo, j = mid+1;
        for(int k = lo; k <= hi; k++){
            if(i > mid)                 aux[k] = a[j++];
            else if(j > hi)             aux[k] = a[i++];
            else if(less(a[i], a[j]))   aux[k] = a[i++];
            else                        aux[k] = a[j++];
        }
    }

    private static <T extends Comparable<? super T>> void sort(T[] a, T[] aux, int lo, int hi){
//        if(hi <= lo + CUTOFF - 1){
//            Insertion.sort(a, lo, hi);
//            return;
//        }
        if(hi <= lo) return;
        int mid = lo + (hi - lo)/2;
        sort(aux, a, lo, mid);
        sort(aux, a, mid+1, hi);
        if(!less(a[mid+1], a[mid])) return;
        merge(a, aux, lo, mid, hi);
    }

    private static <T extends Comparable<? super T>> boolean less(T t, T t1) {
        return t.compareTo(t1) <= 0;
    }

    public static <T extends Comparable<? super T>> void sort(T[] a){
//        T[] aux = (T[]) new Object[a.length];
        T[] aux = Arrays.copyOf(a, a.length);
        sort(a, aux, 0, a.length-1);
    }
}
