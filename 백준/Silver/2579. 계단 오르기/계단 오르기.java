import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int[] stair = new int[301];
		int[] dp = new int[301];
		
		for (int i = 1; i <= n; i++) stair[i] = sc.nextInt();
		
		dp[1] = stair[1];
		dp[2] = stair[1]  + stair[2];
		dp[3] = Math.max(stair[1], stair[2]) + stair[3];
		
		for (int i = 4; i <= n; i++) {
			dp[i] = Math.max(stair[i-1]+dp[i-3], dp[i-2]) + stair[i];
		}
		
		System.out.println(dp[n]);
		sc.close();
	}
}
