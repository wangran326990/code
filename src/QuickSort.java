public class QuickSort {
    public void quickSort(int [] lst) {
        /* Sorts an array in the ascending order in O(n log n) time */
        int n = lst.length;
        qSort(lst, 0, n - 1);
    }

    private void qSort(int [] lst, int lo, int hi) {
        if (lo < hi) {
            int p = partition(lst, lo, hi);
            qSort(lst, lo, p - 1);
            qSort(lst, p + 1, hi);
        }
    }

    private int partition(int[] lst,  int lo, int hi) {
        int pivot = lst[hi];
        int i = lo;
        for (int j = lo; j < hi; ++j) {
            if (lst[j] < pivot) {
                int tmp = lst[i];
                lst[i] = lst[j];
                lst[j] = tmp;
                i++;
            }
        }
        int tmp = lst[i];
        lst[i] = lst[hi];
        lst[hi] = tmp;
        return i;
    }
}
