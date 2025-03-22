import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		int min = Integer.MAX_VALUE;
		int a = 0;
		int b = 0;
		
		int sum = 0;
		int lo = 0;
		int hi = arr.length - 1;
		while (lo < hi) {
			sum = arr[lo] + arr[hi];
			if (Math.abs(sum) < min) {
				min = Math.abs(sum);
				a = arr[lo];
				b = arr[hi];
			}
			
			if (sum > 0) hi--;
			else lo++;
		}
		
		System.out.println(a + " " + b);
	}
}
