import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            int[] time = new int[N+1];
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                time[j] = Integer.parseInt(st.nextToken());
            }

            List<Integer>[] graph = new ArrayList[N+1];
            int[] degree = new int[N+1];
            for (int j = 1; j <= N; j++) {
                graph[j] = new ArrayList<>();
            }

            for (int h = 0; h < K; h++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                graph[x].add(y);
                degree[y]++;
            }

            int W = Integer.parseInt(br.readLine());

            // 위상정렬 시작
            Queue<Integer> q = new LinkedList<>();
            int[] dp = new int[N+1];

            for (int j = 1; j <= N; j++) {
                if (degree[j] == 0) {
                    q.offer(j);   // 초기 상태인 자식부터 시작
                    dp[j] = time[j];
                }
            }

            while (!q.isEmpty()) {
                int cur = q.poll();

                for (int next : graph[cur]) {
                    dp[next] = Math.max(dp[next], dp[cur] + time[next]); // 최대 시간 갱신
                    degree[next]--;

                    if (degree[next] == 0) {
                        q.add(next);
                    }
                }
            }

            sb.append(dp[W]).append("\n");
        }

        System.out.println(sb);
    }
}
