public class InsertionSort {
    public static long sort(int arr[]){
        long c = 0;
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            for (int j = i; j > 0 && arr[j] < arr[j - 1]; j--) {
                c++;
                Utils.swap(arr, j, j-1);
            }
            c++;
        }
        return c;
    }
}
