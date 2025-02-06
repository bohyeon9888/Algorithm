import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());

        int[] dp = new int[H + 1];
        dp[0] = 1;

        for (int i = 0; i < N; i++) {
            List<Integer> blocks = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()) {
                blocks.add(Integer.parseInt(st.nextToken()));
            }

            int[] nextDP = dp.clone(); // 기존 dp를 복사 (업데이트를 동시에 하면 중복 사용될 수 있음)
            for (int h = 0; h <= H; h++) {
                if (dp[h] > 0) { // 현재 높이를 만들 수 있는 경우
                    for (int b : blocks) {
                        if (h + b <= H) {
                            nextDP[h + b] = (nextDP[h + b] + dp[h]) % 10007;
                        }
                    }
                }
            }
            dp = nextDP;
        }

        System.out.println(dp[H]);

    }
}
