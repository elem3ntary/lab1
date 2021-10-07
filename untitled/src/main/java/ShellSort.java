public class ShellSort {
    public static long sort(int arr[]) {
        long c = 0;
        int n = arr.length;

        for (int gap = n/2; gap > 0; gap /= 2)
        {
            c++;
            for (int i = gap; i < n; i += 1)
            {
                c++;
                int temp = arr[i];

                int j;
                for (j = i; j >= gap && arr[j - gap] > temp; j -= gap) {
                    arr[j] = arr[j - gap];
                    c++;
                }

                arr[j] = temp;
            }
        }
        return c;
    }
}
