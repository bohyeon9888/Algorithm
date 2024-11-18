import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        boolean[] prime = new boolean[n + 1];
        prime[0] = prime[1] = true;

        for (int i = 2; i * i <= n; i++) {
            if (!prime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    prime[j] = true;
                }
            }
        }

        List<Integer> primeList = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (!prime[i]) primeList.add(i);
        }

        int sum = 0;
        int start = 0, end = 0, cnt = 0;
        while(true) {
            if (sum >= n) {
                sum -= primeList.get(start++);
            } else if (end == primeList.size()) break;
            else {
                sum += primeList.get(end++);
            }

            if (sum == n) cnt++;
        }
        System.out.println(cnt);
    }
}