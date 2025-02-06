import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String magic = sc.next();
        String devilBridge = sc.next();
        String angelBridge = sc.next();
        int L = magic.length(); // 마법 문자열 길이
        int N = devilBridge.length(); // 다리 길이

        long[][][] dp = new long[L][N][2]; // dp[i][j][b]: i번째 magic을 j번째 다리에서 찾을 경우의 수

        // 초기값 설정 (magic[0]과 일치하는 경우)
        for (int j = 0; j < N; j++) {
            if (devilBridge.charAt(j) == magic.charAt(0)) {
                dp[0][j][0] = 1; // 악마 다리에서 시작
            }
            if (angelBridge.charAt(j) == magic.charAt(0)) {
                dp[0][j][1] = 1; // 천사 다리에서 시작
            }
        }

        // DP 진행
        for (int i = 1; i < L; i++) { // magic의 각 문자 탐색
            for (int j = 0; j < N; j++) { // 현재 다리의 위치
                if (devilBridge.charAt(j) == magic.charAt(i)) {
                    for (int k = 0; k < j; k++) { // 이전 문자는 반드시 왼쪽에서 가져와야 함
                        dp[i][j][0] += dp[i - 1][k][1]; // 천사 다리에서 온 경우
                    }
                }
                if (angelBridge.charAt(j) == magic.charAt(i)) {
                    for (int k = 0; k < j; k++) {
                        dp[i][j][1] += dp[i - 1][k][0]; // 악마 다리에서 온 경우
                    }
                }
            }
        }

        // 최종 정답 계산 (마지막 magic 문자까지 올 수 있는 경우의 수 합)
        long result = 0;
        for (int j = 0; j < N; j++) {
            result += dp[L - 1][j][0] + dp[L - 1][j][1]; // 두 다리에서 끝나는 경우 합산
        }

        System.out.println(result);
        sc.close();
    }
}
