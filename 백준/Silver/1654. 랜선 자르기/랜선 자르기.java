import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int K = Integer.parseInt(st.nextToken());
		int[] lan = new int[K];
		int N = Integer.parseInt(st.nextToken());
		
		long max = 0;
		for (int i = 0; i < K; i++) {
			lan[i] = Integer.parseInt(br.readLine());
			max = Math.max(max, lan[i]);
		}
		
		max++;	// 최대 길이를 찾으려면 +1 해줘야 해당하는 최대 길이를 찾을 수 있음
		
		long min = 0;
		long mid = 0;
		
		while (min < max) {
			mid = (min + max) / 2;
			
			long cnt = 0;
			for (int i = 0; i < K; i++) cnt += (lan[i] / mid);
			
			if (cnt < N) {
				max = mid;
			} else {
				min = mid + 1;
			}
		}
		
		System.out.println(min - 1);
	}
}
