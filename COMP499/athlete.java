package COMP499;
import java.util.*;

public class athlete {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextInt()) {
            int n = sc.nextInt();
            if (n == -1) break; // termination line

            int[] nums = new int[n];
            for (int i = 0; i < n; i++) nums[i] = sc.nextInt();

            int[] dp = new int[n];        // length of LIS ending at i
            int[] prev = new int[n];      // predecessor index for i in chosen LIS
            Arrays.fill(dp, 1);
            Arrays.fill(prev, -1);

            // Standard O(n^2) LIS with tie-breaking on predecessors
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < i; j++) {
                    if (nums[j] < nums[i]) {
                        int cand = dp[j] + 1;
                        if (cand > dp[i]) {
                            dp[i] = cand;
                            prev[i] = j;
                        } else if (cand == dp[i]) {
                            // Tie-break on the predecessor chain: choose smaller j
                            // so that earlier indices are preferred when lengths tie
                            if (prev[i] == -1 || j < prev[i]) {
                                prev[i] = j;
                            }
                        }
                    }
                }
            }

            // Find best end index with smallest i for max length
            int max = 0, end = -1;
            for (int i = 0; i < n; i++) {
                if (dp[i] > max) {
                    max = dp[i];
                    end = i;
                } else if (dp[i] == max && end != -1 && i < end) {
                    // smallest last index tie-break
                    end = i;
                }
            }

            // Backtrack indices; this already respects the second-to-last, etc. tie-breaks
            Deque<Integer> idx = new ArrayDeque<>();
            for (int i = end; i != -1; i = prev[i]) idx.addFirst(i);

            // Print in required format: "k: i1 i2 ... ik"
            StringBuilder sb = new StringBuilder();
            sb.append(max).append(": ");
            boolean first = true;
            for (int i : idx) {
                if (!first) sb.append(' ');
                sb.append(i);
                first = false;
            }
            System.out.println(sb.toString());
        }

        sc.close();
    }
}
