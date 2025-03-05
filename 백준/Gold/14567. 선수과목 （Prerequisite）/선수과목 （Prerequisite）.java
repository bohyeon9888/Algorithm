import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static List<Integer>[] graph;
    static int[] inDegree, semester;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 과목 수
        M = Integer.parseInt(st.nextToken()); // 선수 조건 개수

        graph = new ArrayList[N + 1];
        inDegree = new int[N + 1];  // 진입 차수 배열
        semester = new int[N + 1];  // 각 과목을 수강하는 최소 학기 수

        for (int i = 1; i <= N; i++) graph[i] = new ArrayList<>();

        // 그래프 및 진입 차수 초기화
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            graph[A].add(B); // A → B (A를 들어야 B를 들을 수 있음)
            inDegree[B]++;   // B의 진입 차수 증가
        }

        topologicalSort();

        // 결과 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            sb.append(semester[i]).append(" ");
        }
        System.out.println(sb.toString().trim());
    }

    static void topologicalSort() {
        Queue<Integer> queue = new LinkedList<>();

        // 선수 과목이 없는 과목(진입 차수 0)을 먼저 큐에 추가
        for (int i = 1; i <= N; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
                semester[i] = 1; // 선수 과목이 없으면 1학기부터 시작 가능
            }
        }

        while (!queue.isEmpty()) {
            int cur = queue.poll(); // 현재 학기에서 수강할 수 있는 과목

            for (int next : graph[cur]) {
                inDegree[next]--; // 진입 차수 감소

                // 진입 차수가 0이 되면 큐에 추가
                if (inDegree[next] == 0) {
                    queue.add(next);
                    semester[next] = semester[cur] + 1; // 현재 과목보다 한 학기 뒤에 들을 수 있음
                }
            }
        }
    }
}
