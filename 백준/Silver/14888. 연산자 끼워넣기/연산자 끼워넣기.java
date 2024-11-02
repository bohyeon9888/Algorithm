import java.io.*;
import java.util.*;

public class Main {
	static int n;
	static int[] nums, cal;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		nums = new int[n];
		cal = new int[n-1];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) nums[i] = Integer.parseInt(st.nextToken());
		
		int[] input = new int[4];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; i++) input[i] = Integer.parseInt(st.nextToken());
		
		permu(input, 0);
		
		System.out.println(max + "\n" + min);
	}

	private static void permu(int[] input, int cnt) {
		if (cnt == n-1) {
			calculate();
			return;
		}
		
		for (int i = 0; i < 4; i++) {
			if (input[i] > 0) {
				cal[cnt] = i;
				input[i]--;
				permu(input, cnt+1);
				input[i]++;
			}
		}
	}

	static int min = Integer.MAX_VALUE;
	static int max = Integer.MIN_VALUE;
	private static void calculate() {
		int idx = 0;
		int nIdx = 0;
		int tmp = 0;
		
		while (idx < n-1 && nIdx < n) {
			int now = cal[idx];
			if (nIdx > 0) {
				tmp = operator(now, tmp, nums[nIdx]);
			} else {
				tmp = operator(now, nums[nIdx], nums[++nIdx]);
			}
			idx++;
			nIdx++;
		}
		
		max = Math.max(tmp, max);
		min = Math.min(tmp, min);
	}

	private static int operator(int now, int i, int j) {
		int ans = 0;
		if (now == 0) ans = i + j;
		else if (now == 1) ans = i - j;
		else if (now == 2) ans = i * j;
		else if (now == 3) ans = i / j;
		
		return ans;
	}
}
