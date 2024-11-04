import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int K = sc.nextInt();
		long number = 1000000000L;
		
		int[][] dp = new int[K+1][N+1];
		
		Arrays.fill(dp[1], 1);
		
		for (int i = 1; i <= K; i++) dp[i][0] = 1;
		
		for (int i = 2; i <= K; i++) {
			for (int j = 1; j <= N; j++) {
				dp[i][j] = dp[i-1][j]+dp[i][j-1];
				dp[i][j] %= number;
			}
		}
		
		System.out.println(dp[K][N]);
		sc.close();
	}
}
