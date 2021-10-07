public class MergeSort {
    public static long sort(int a[], int n) {
        long c = 0;
        if (n < 2) {
            return 1;
        }
        int mid = n / 2;
        int[] l = new int[mid];
        int[] r = new int[n - mid];

        for (int i = 0; i < mid; i++) {
            c++;
            l[i] = a[i];
        }
        for (int i = mid; i < n; i++) {
            c++;
            r[i - mid] = a[i];
        }
        c += sort(l, mid);
        c += sort(r, n - mid);

        c += merge(a, l, r, mid, n - mid);
        return c;
    }

    public static long merge(
            int[] a, int[] l, int[] r, int left, int right) {
        int i = 0, j = 0, k = 0;
        long c = 0;
        while (i < left && j < right) {
            if (l[i] <= r[j]) {
                a[k++] = l[i++];
            } else {
                a[k++] = r[j++];
            }
            c++;
        }
        while (i < left) {
            a[k++] = l[i++];
            c++;
        }
        while (j < right) {
            a[k++] = r[j++];
            c++;
        }

        return c;
    }

}
