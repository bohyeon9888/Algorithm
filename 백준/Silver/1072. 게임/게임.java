import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        int z = (int) ((long) y * 100 / x);

        int cnt = -1;
        int left = 0;
        int right = 1000000000;
        while (left <= right) {
            int mid = (right + left) / 2;
            int newCnt = (int) ((long) (y + mid) * 100 / (x + mid));

            if (newCnt != z) {
                cnt = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(cnt);
    }
}