import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[][] flowers = new int[N][2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int sm = Integer.parseInt(st.nextToken());
            int sd = Integer.parseInt(st.nextToken());
            int em = Integer.parseInt(st.nextToken());
            int ed = Integer.parseInt(st.nextToken());

            flowers[i][0] = sm * 100 + sd;
            flowers[i][1] = em * 100 + ed;
        }

        Arrays.sort(flowers, (o1, o2) -> {
            if(o1[0] == o2[0]) return o2[1] - o1[1];
            return o1[0] - o2[0];
        });

        int startDay = 301;
        int endDay = 1201;
        int cnt = 0;
        int max = 0;
        int idx = 0;
        while (startDay < endDay) {
            boolean isFind = false;

            for (int i = idx; i < N; i++) {
                if (flowers[i][0] > startDay) break;

                if (flowers[i][0] <= startDay && max < flowers[i][1]) {
                    isFind = true;
                    max = flowers[i][1];
                    idx = i+1;
                }
            }

            if (isFind) {
                startDay = max;
                cnt++;
            } else break;
        }

        if (max < endDay) System.out.println(0);
        else System.out.println(cnt);
    }
}
