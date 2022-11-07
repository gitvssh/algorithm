package algorithm.module.sort;

public class InsertionSort {
    public static void insertionSort(int[] a) {
        insertionSort(a, a.length);
    }

    public static void insertionSort(int[] a, int n) {
        for (int i = 1; i < n; i++) {
            int target = a[i];
            int j = i - 1;
            while (j >= 0 && a[j] > target) {
                a[j + 1] = a[j];
                j--;
            }
            a[j + 1] = target;
        }
        while(n > 0) {
            System.out.println(a[n - 1]);
            n--;
        }
    }
}
