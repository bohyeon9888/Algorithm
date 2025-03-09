import java.util.*;

public class Main {
    static int min = Integer.MAX_VALUE;
    static int ways;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        bfs(N, K);
        System.out.println(min);
        System.out.println(ways);
    }

    private static void bfs(int N, int K) {
        int size = 100001;
        int[] pos = new int[size];

        Queue<Integer> q = new ArrayDeque<>();
        q.offer(N);

        while (!q.isEmpty()) {
            int cur = q.poll();
            int[] move = {cur-1, cur+1, cur*2};

//            if (min < pos[cur]) continue;
            if (min >= pos[cur] && cur == K) {
                ways++;
                min = pos[cur];
            }

            for (int next : move) {
                if (next >= 0 && next < size) {
                    if (pos[next] == 0 || pos[next] >= pos[cur] + 1) {
                        pos[next] = pos[cur] + 1;
                        q.offer(next);
                    }
                }
            }
        }
    }
}
