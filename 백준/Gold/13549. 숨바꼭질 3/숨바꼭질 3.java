import java.util.*;

public class Main {
    static int size = 200002;
    static int[] arr = new int[size];
    static boolean[] visited = new boolean[size];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();

        bfs(N, K);
        System.out.println(arr[K]);
    }

    private static void bfs(int n, int k) {
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(n);

        while(!q.isEmpty()) {
            int now = q.poll();
            int[] cal = {now*2, now-1, now+1};

            if (now == k) break;

            for (int i = 0; i < 3; i++) {
                int next = cal[i];
                if (next < 0 || next >= size || visited[next]) continue;

                if (i == 0) {
                    arr[next] = arr[now];
                } else {
                    arr[next] = arr[now] + 1;
                }

                visited[next] = true;
                q.offer(next);
            }
        }

    }
}
