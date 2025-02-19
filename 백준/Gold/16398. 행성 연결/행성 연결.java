import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] cost;
    static int[] parent;

    static class Edge implements Comparable<Edge> {
        int from, to, weight;

        public Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return this.weight - o.weight; // 간선 비용 기준 정렬
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        cost = new int[N][N];
        parent = new int[N];

        List<Edge> edges = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            parent[i] = i;
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                cost[i][j] = Integer.parseInt(st.nextToken());
                if (i < j) edges.add(new Edge(i, j, cost[i][j])); // 중복 간선 방지
            }
        }

        Collections.sort(edges);

        long total = 0;
        int edgeCnt = 0;
        for (Edge e : edges) {
            if (union(e.from, e.to)) {
                total += e.weight;
                edgeCnt++;
                if (edgeCnt == N - 1) break;
            }
        }

        System.out.println(total);
    }

    static int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    static boolean union(int x, int y) {
        int a = find(x);
        int b = find(y);
        if (a == b) return false;
        parent[b] = a;
        return true;
    }
}
