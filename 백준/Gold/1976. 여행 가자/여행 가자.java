
import java.io.*;
import java.util.StringTokenizer;

public class Main {
	static int n, m;
	static int[] parents;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());

		// union-find 알고리즘, 부모 노드 집합
		parents = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			parents[i] = i;
		}

		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= n; j++) {
				int tmp = Integer.parseInt(st.nextToken());
				if (tmp == 1)
					// 연결된 도시끼리 합치기
					union(i, j);
			}
		}

		st = new StringTokenizer(br.readLine());
		// 여행 계획 시작점
		int start = find(Integer.parseInt(st.nextToken()));
		for (int i = 0; i < m - 1; i++) {
			// 시작 다음 목적지들
			int plan = Integer.parseInt(st.nextToken());
			// 목적지들의 parent가 시작점과 같은지 확인, 안 같으면 no 출력
			if (start != find(plan)) {
				System.out.println("NO");
				return;
			}
		}
		
		System.out.println("YES");

	}

	private static void union(int i, int j) {
		i = find(i);
		j = find(j);

		// 더 큰수의 부모를 작은 수의 부모로 바꿈
		if (i < j)
			parents[j] = i;
		else
			parents[i] = j;
	}

	private static int find(int i) {
		if (i == parents[i])
			return i;

		int next = find(parents[i]);
		return next;
	}
}
