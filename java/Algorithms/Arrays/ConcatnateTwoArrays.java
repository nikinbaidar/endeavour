import java.util.Arrays;

public class ConcatnateTwoArrays {

    private static int[] MergeArrays(int[] a, int[] b ) {

        int [] merged = new int[a.length + b.length];

        for (int i=0; i<a.length; i++){
            merged[i] = a[i];
        }

        for (int i=0; i<b.length; i++){
            merged[i+a.length] = b[i];
        }


        return merged;
    }

    public static void main(String[] args) {

        int [] a = {1, 2, 3};
        int [] b = {5, 8, 9};

        ConcatnateTwoArrays obj = new ConcatnateTwoArrays();

        int [] merged = obj.MergeArrays(a, b);

        System.out.println(Arrays.toString(merged));
    }
}
