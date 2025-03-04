import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] meat = new int[N][2];
        int total = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(st.nextToken());
            int price = Integer.parseInt(st.nextToken());

            meat[i][0] = weight;
            meat[i][1] = price;
            total += weight;
        }

        if (total < M) {
            System.out.println(-1);
            return;
        }

        Arrays.sort(meat, (o1, o2) -> {
            if (o1[1] == o2[1]) {
                return o2[0] - o1[0];
            } else {
                return o1[1] - o2[1];
            }
        });

        int maxCost = 0;
        int totalCost = 0;
        int sum = 0;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            sum += meat[i][0];

            if (maxCost != meat[i][1]) {
                totalCost = maxCost = meat[i][1];
            } else {
                totalCost += meat[i][1];
            }

            if (sum >= M) {
                min = Math.min(min, totalCost);
            }
        }

        System.out.println(min);
    }
}
