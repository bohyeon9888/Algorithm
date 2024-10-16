import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[(N*(N+1)/2) + 1];
		int[] dp = new int[(N*(N+1)/2) + 1];
		
		int idx = 1;
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j <= i; j++) {
				arr[idx] = Integer.parseInt(st.nextToken());
				idx++;
			}
		}
		
		int max = 0;
		idx = 1;
		dp[1] = arr[1];
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= i; j++) {
				if (i == N) {
					max = Math.max(max, dp[idx]);
					idx++;
				} else {					
					dp[idx + i] = Math.max(dp[idx] + arr[idx + i], dp[idx + i]);
					dp[idx + i + 1] = Math.max(dp[idx] + arr[idx + i + 1], dp[idx + i + 1]);
					idx++;
				}
			}
		}
		
		System.out.println(max);
	}
}
