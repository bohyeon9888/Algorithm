import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int K = sc.nextInt();
		
		int[] coin = new int[N+1];
		int[] dp = new int[K+1];
		
		dp[0] = 1;
		
		for (int i = 1; i <= N; i++) {
			coin[i] = sc.nextInt();
			for (int j = coin[i]; j <= K; j++) {
				dp[j] += dp[j-coin[i]];
			}
		}
		
		System.out.println(dp[K]);
		sc.close();
	}

}
