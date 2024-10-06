import java.util.Arrays;

public class PerfectSum {

    public int perfectSum(int arr[], int n, int sum) {
        if (n == 0) return (sum == 0) ? 1 : 0;  // No elements

        int mod = 1000000007;
        int[] prev = new int[sum + 1];
        prev[0] = 1;  // One way to get sum 0: the empty set

        // Process each element in the array
        for (int i = 0; i < n; i++) {
            int[] cur = new int[sum + 1];
            cur[0] = 1;  // Initialize for empty subset

            // Iterate through all possible sums
            for (int j = 0; j <= sum; j++) {
                int notTake = prev[j];  // Exclude the current element
                int take = 0;

                if (arr[i] <= j) {
                    take = prev[j - arr[i]];  // Include the current element
                }

                // Total ways to form the current sum
                cur[j] = (take + notTake) % mod;
            }

            prev = Arrays.copyOf(cur, cur.length);  // Update for the next iteration
        }

        return prev[sum];  // Return the number of ways to get the target sum
    }

    public static void main(String[] args) {
        PerfectSum ps = new PerfectSum();
        int[] arr = {0, 0, 0, 0, 0, 0, 0, 0, 1};
        int n = arr.length;
        int sum = 1;
        
        int result = ps.perfectSum(arr, n, sum);
        System.out.println("Number of subsets with sum " + sum + ": " + result);
    }
}
