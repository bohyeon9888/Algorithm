
import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static long M, max;
    static int[] times;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 입국할 사람 수
        M = Integer.parseInt(st.nextToken()); // 심사대 개수
        times = new int[N];

        for (int i = 0; i < N; i++) {
            times[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, times[i]);
        }

         Arrays.sort(times);

        System.out.println(binarySearch());
    }

    static long binarySearch() {
        long left = 0; // 최소 시간
        long right = M * max; // 최악의 경우
        long answer = Long.MAX_VALUE;

        while (left <= right) {
            long mid = (left + right) / 2;
            long sum = 0;

            // 현재 mid 시간 동안 각 심사대에서 처리할 수 있는 사람 수 계산
            for (int time : times) {
                long cur = mid / time;
                if (sum >= M) break; // N명을 넘으면 더 탐색할 필요 없음
                sum += cur;
            }

            // N명 이상 처리 가능 → 시간을 더 줄일 수 있음
            if (sum >= M) {
                answer = Math.min(answer, mid);
                right = mid - 1;
            }
            // N명 미만 처리 가능 → 시간을 더 늘려야 함
            else {
                left = mid + 1;
            }
        }

        return answer;
    }
}