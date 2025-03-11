import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(findZeroSumTriplets());
    }

    static long findZeroSumTriplets() {
        Arrays.sort(arr); // 정렬 (O(N log N))
        long count = 0;

        for (int i = 0; i < N - 2; i++) {
            int left = i + 1;
            int right = N - 1;

            while (left < right) {
                int sum = arr[i] + arr[left] + arr[right];

                if (sum == 0) { // 정답 찾음
                    if (arr[left] == arr[right]) {
                        // 같은 값이 여러 개 있으면 조합의 경우의 수 추가
                        int num = right - left + 1;
                        count += (num * (num - 1)) / 2; // nC2 조합 공식
                        break;
                    }

                    // 중복된 left 값 개수 세기
                    int leftCount = 1;
                    while (left + 1 < right && arr[left] == arr[left + 1]) {
                        left++;
                        leftCount++;
                    }

                    // 중복된 right 값 개수 세기
                    int rightCount = 1;
                    while (right - 1 > left && arr[right] == arr[right - 1]) {
                        right--;
                        rightCount++;
                    }

                    // 서로 다른 leftCount, rightCount의 조합 추가
                    count += (long) leftCount * rightCount;

                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return count;
    }
}
