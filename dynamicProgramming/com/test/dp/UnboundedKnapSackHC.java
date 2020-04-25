package com.test.dp;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class UnboundedKnapSackHC {

    // Complete the unboundedKnapsack function below.
    static int unboundedKnapsack(int k, int[] arr) {

        Integer[][] dp = new Integer[arr.length][k + 1];
        return unBoundknapsackRecursive(dp, arr, k, 0 );

    }
private static  int unBoundknapsackRecursive(Integer[][] dp, int[] weights, int capacity, int currentIndex) {
        // base checks
        if (capacity <= 0 || currentIndex >= weights.length)
          return 0;

        if(dp[currentIndex][capacity] != null)
            return dp[currentIndex][capacity];
        // recursive call after choosing the element at the currentIndex
        // if the weight of the element at currentIndex exceeds the capacity, we shouldn't process this
        int profit1 = 0;
        if( weights[currentIndex] <= capacity )
            profit1 = weights[currentIndex] + unBoundknapsackRecursive(dp,weights,
                    capacity - weights[currentIndex], currentIndex);

        // recursive call after excluding the element at the currentIndex
        int profit2 = unBoundknapsackRecursive(dp, weights, capacity, currentIndex + 1);
        
        dp[currentIndex][capacity] = Math.max(profit1, profit2);
        
        return dp[currentIndex][capacity];
      }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        
        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int result = unboundedKnapsack(k, arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
