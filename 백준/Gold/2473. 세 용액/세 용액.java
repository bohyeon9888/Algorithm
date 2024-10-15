import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		long[] liquid = new long[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			liquid[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(liquid);
		
		long[] ans = new long[3];
		long min = Long.MAX_VALUE;
		
		// 투 포인터 사용
		for (int i = 0; i < N; i++) {
			int left = i+1;
			int right = N-1;
			
			while(left < right) {
				long sum = liquid[i] + liquid[left] + liquid[right];
				if (Math.abs(sum) < min) {				
					min = Math.abs(sum);
					ans[0] = liquid[i];
					ans[1] = liquid[left];
					ans[2] = liquid[right];
				}
				
				if (sum > 0) right--;
				else left++;
			}
		}
		
		System.out.println(ans[0] + " " + ans[1] + " " + ans[2]);
	}
}
