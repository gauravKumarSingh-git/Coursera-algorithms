import java.util.Comparator;

public class MergeSort{

    private static <T extends Comparable<? super T>> void merge(T[] a, T[] aux, int lo, int mid, int hi){
        for(int i = lo; i<= hi; i++){
            aux[i] = a[i];
        }
        int i = lo, j = mid+1;
        for(int k = lo; k <= hi; k++){
            if(i > mid)                 a[k] = aux[j++];
            else if(j > hi)             a[k] = aux[i++];
            else if(less(aux[i], aux[j]))   a[k] = aux[i++];
            else                        a[k] = aux[j++];
        }
    }

    private static <T extends Comparable<? super T>> void sort(T[] a, T[] aux, int lo, int hi){
        if(hi <= lo) return;
        int mid = lo + (hi - lo)/2;
        sort(a, aux, lo, mid);
        sort(a, aux, mid+1, hi);
        merge(a, aux, lo, mid, hi);
    }

    private static <T extends Comparable<? super T>> boolean less(T t, T t1) {
        return t.compareTo(t1) <= 0;
    }

    public static <T extends Comparable<? super T>> void sort(T[] a, T[] aux){
//        T[] aux2 = (T[]) new Object[a.length];
        sort(a, aux, 0, a.length-1);
    }
}
