import java.util.Arrays;

public class MergeSort {

    public static double abs(double n) {
        if (n < 0)
            return (n * -1.0);
        return n;
    }

    public static int [] merge(int[] a, int[] b) {

        /* This function assumes the arrays a and b are sorted */

        int n = a.length + b.length;

        int [] merged = new int[n];

        int pa = 0;
        int pb = 0;

        for(int i = 0; i < n ; i++) {
            if (pa < a.length && (pb >= b.length || a[pa] <= b[pb])) {
                merged[i] = a[pa];
                pa++;
            }
            else {
                merged[i] = b[pb];
                pb++;
            }

        }

        return merged;
    }

    public static  int [] mergeSort(int[] a) {

        if (a.length == 1) {
            return a;
        }

        int n = a.length;


        int breakpoint = n / 2 ;
        int remaining = n - breakpoint;

        int [] left = new int[breakpoint];
        int [] right = new int[remaining];


        for (int i=0; i<breakpoint; i++) {
            left[i] = a[i];
        }

        for (int j=0; j<remaining; j++)
            right[j] = a[breakpoint + j];

        /* Recursively split and merge */
        left = mergeSort(left);
        right = mergeSort(right);

        int [] sorted = merge(left, right);

        return sorted;

    }

    public static void main(String[] args) {
        int [] c = {6 , 5, 1, 3, 4, 0, 10, 12, 13};

        MergeSort x = new MergeSort();

        int [] sorted = x.mergeSort(c);

        System.out.println(Arrays.toString(sorted));
    }


}
