import java.io.*;

public class Main {
    static int T;
    static char[] init, target;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        init = br.readLine().toCharArray();
        target = br.readLine().toCharArray();

        int result1 = simulate(false); // 첫 번째 전구를 누르지 않는 경우
        int result2 = simulate(true);  // 첫 번째 전구를 누르는 경우

        // 둘 다 불가능하면 -1, 가능하면 최소 클릭 수 출력
        if (result1 == -1 && result2 == -1) {
            System.out.println(-1);
        } else if (result1 == -1) {
            System.out.println(result2);
        } else if (result2 == -1) {
            System.out.println(result1);
        } else {
            System.out.println(Math.min(result1, result2));
        }
    }

    static int simulate(boolean pressFirst) {
        char[] lights = init.clone();
        int count = 0;

        // 첫 번째 전구를 누르는 경우
        if (pressFirst) {
            toggle(lights, 0);
            count++;
        }

        // i번째 전구를 목표 상태와 맞추기 위해 i-1번째 전구를 토글
        for (int i = 1; i < T; i++) {
            if (lights[i - 1] != target[i - 1]) {
                toggle(lights, i);
                count++;
            }
        }

        // 목표 상태와 동일한지 확인
        if (new String(lights).equals(new String(target))) {
            return count;
        } else {
            return -1;
        }
    }

    static void toggle(char[] arr, int idx) {
        // idx-1, idx, idx+1을 변경
        for (int i = idx - 1; i <= idx + 1; i++) {
            if (i >= 0 && i < T) {
                arr[i] = (arr[i] == '0') ? '1' : '0';
            }
        }
    }
}
