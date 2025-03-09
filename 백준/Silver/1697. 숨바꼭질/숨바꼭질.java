import java.io.*;
import java.util.*;

public class Main {
	static int size = 200002;
	static int[] dp = new int[size];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		bfs(N, K);

		System.out.println(dp[K]);
	}

	private static void bfs(int n, int k) {
		Queue<Integer> now = new LinkedList<Integer>();

		now.offer(n);

		while (!now.isEmpty()) {
			int what = now.poll();
			int[] cal = { what + 1, what - 1, what * 2 };

			if (what == k)
				break;
			
			for (int d = 0; d < 3; d++) {
				int next = cal[d];

				if (next < 0 || next >= size || dp[next] != 0)
					continue;

				now.offer(next);
				dp[next] = dp[what] + 1;

			}
		}
	}

}
