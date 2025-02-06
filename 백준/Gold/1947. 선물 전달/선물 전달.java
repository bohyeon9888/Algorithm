import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //완전순열
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int MOD = 1_000_000_000;

        if (N == 1) {
            System.out.println(0);
            return;
        }
        if (N == 2) {
            System.out.println(1);
            return;
        }

        long prev2 = 0;
        long prev1 = 1;
        long current = 0;

        for (int i = 3; i <= N; i++) {
            current = ((i - 1) * (prev1 + prev2)) % MOD;
            prev2 = prev1;
            prev1 = current;
        }

        System.out.println(current);
        sc.close();
    }
}