public class SelectionSort {
    public static long sort(int arr[]) {
        long                                     c = 0;
        for (int i = 0; i < arr.length; i++) {
            int min_idx = i;
            c++;
            for (int j = 0; j < arr.length - i; j++) {
                c++;
                int curr_idx = i+j;
                if ( arr[curr_idx]< arr[min_idx]) {
                    c++;
                    min_idx = curr_idx;
                }
            }
            Utils.swap(arr, i,min_idx);
        }
        return c;
    }
}
