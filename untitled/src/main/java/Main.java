import netscape.javascript.JSObject;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;

public class Main {
    public static Random rd = new Random();

    public static void main(String[] args) throws IOException {
        int minPower = 7;
        int maxPower = 15;


        JSONArray testDataArray = new JSONArray();
        for (int i = minPower; i < maxPower + 1; i++) {
            int n = (int) Math.pow(2, i);
            int[][] sampleArrays = {
                    randomArray(n),
                    increasingOrderArray(n),
                    decreasingOrderArray(n),
                    repeatedValuesArray(n)
            };
            JSONObject size = new JSONObject();
            size.put("size", i);
            JSONArray samples = new JSONArray();
            for (int j = 0; j < sampleArrays.length; j++) {

                JSONObject testCase = new JSONObject();

                long[] selectionSortResult = testSelectionSort( decreasingOrderArray(n));
                JSONObject selectionSortDetails = new JSONObject();
                selectionSortDetails.put("algo", "selectionSort");
                selectionSortDetails.put("time", selectionSortResult[0]);
                selectionSortDetails.put("comparison", selectionSortResult[1]);

                long[] insertionSortResult = testInsertionSort( decreasingOrderArray(n));
                JSONObject insertionSortDetails = new JSONObject();
                insertionSortDetails.put("algo", "insertionSort");
                insertionSortDetails.put("time", insertionSortResult[0]);
                insertionSortDetails.put("comparison", insertionSortResult[1]);

                long[] mergeSortResult = testMergeSort( decreasingOrderArray(n));
                JSONObject mergeSortDetails = new JSONObject();
                mergeSortDetails.put("algo", "mergeSort");
                mergeSortDetails.put("time", mergeSortResult[0]);
                mergeSortDetails.put("comparison", mergeSortResult[1]);

                long[] shellSortResult = testShellSort( decreasingOrderArray(n));
                JSONObject shellSortDetails = new JSONObject();
                shellSortDetails.put("algo", "shellSort");
                shellSortDetails.put("time", shellSortResult[0]);
                shellSortDetails.put("comparison", shellSortResult[1]);

                JSONArray testDetails = new JSONArray();

                testDetails.add(selectionSortDetails);
                testDetails.add(insertionSortDetails);
                testDetails.add(mergeSortDetails);
                testDetails.add(shellSortDetails);
                testCase.put("results", testDetails);

                samples.add(testCase);
            }
            ;
            size.put("samples", samples);
            testDataArray.add(size);
        }

        FileWriter fw = new FileWriter("results.json");
        fw.write(testDataArray.toJSONString());
        fw.flush();
    }

    public static int[] randomArray(int n) {
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = rd.nextInt();
        }
        return arr;
    }

    public static int[] increasingOrderArray(int n) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i;
        }
        return arr;
    }

    public static int[] decreasingOrderArray(int n) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = n - i;
        }
        return arr;
    }

    public static int[] repeatedValuesArray(int n) {
        int[] chooseFrom = {1, 2, 3};
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            int nextRandomIdx = rd.nextInt(0, 2);
            arr[i] = chooseFrom[nextRandomIdx];

        }
        return arr;
    }

    public static long[] testSelectionSort(int[] sample) {
        long startTime = System.currentTimeMillis();
        long c = SelectionSort.sort(sample);
        long finishTime = System.currentTimeMillis();

        return new long[]{finishTime - startTime, c};
    }

    public static long[] testInsertionSort(int[] sample) {
        long startTime = System.currentTimeMillis();
        long c = InsertionSort.sort(sample);
        long finishTime = System.currentTimeMillis();

        return new long[]{finishTime - startTime, c};
    }

    public static long[] testMergeSort(int[] sample) {
        long startTime = System.currentTimeMillis();
        long c = MergeSort.sort(sample, sample.length);
        long finishTime = System.currentTimeMillis();

        return new long[]{finishTime - startTime, c};
    }

    public static long[] testShellSort(int[] sample) {
        long startTime = System.currentTimeMillis();
        long c = ShellSort.sort(sample);
        long finishTime = System.currentTimeMillis();

        return new long[]{finishTime - startTime, c};
    }
}
