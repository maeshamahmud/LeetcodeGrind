package COMP499;
import java.util.*;

public class coinChange {
    // Actual coin change DP method
    public static int coinChangeSolver(int[] coins, int m) {
        int[] dp = new int[m+1];
        Arrays.fill(dp, m+1);
        dp[0] = 0;

        for (int i = 1; i <= m; i++) {
            for (int c : coins) {
                if (i - c >= 0) {
                    dp[i] = Math.min(dp[i], dp[i - c] + 1);
                }
            }
        }

        return dp[m] > m ? -1 : dp[m];
    }

    // Entry point
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt(); // amount
        int n = sc.nextInt(); // number of coins
        int[] coins = new int[n];
        for (int i = 0; i < n; i++) {
            coins[i] = sc.nextInt();
        }

        int ans = coinChangeSolver(coins, m);
        System.out.println(ans);
        sc.close();
    }
}
