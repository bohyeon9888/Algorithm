
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 사용할 수 있는 서로 다른 문자 개수
        String str = br.readLine();

        int[] count = new int[26]; // 알파벳 개수 저장
        int left = 0, right = 0, ans = 0, unique = 0;

        while (right < str.length()) {
            // 새로운 문자 추가
            int rightChar = str.charAt(right) - 'a';
            if (count[rightChar] == 0) unique++; // 새로운 문자 추가되면 종류 증가
            count[rightChar]++;
            right++;

            // 만약 서로 다른 문자의 개수가 N개를 초과하면 left 이동
            while (unique > N) {
                int leftChar = str.charAt(left) - 'a';
                count[leftChar]--;
                if (count[leftChar] == 0) unique--; // 문자가 완전히 빠지면 개수 감소
                left++;
            }

            // 최대 길이 갱신
            ans = Math.max(ans, right - left);
        }

        System.out.println(ans);
    }
}
