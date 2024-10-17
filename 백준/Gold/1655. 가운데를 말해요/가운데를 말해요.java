import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        PriorityQueue<Integer> maxPQ = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> minPQ = new PriorityQueue<>();

        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();

            if (maxPQ.size() == minPQ.size()) {
                maxPQ.add(num);

                if (!minPQ.isEmpty() && minPQ.peek() < maxPQ.peek()) {
                    minPQ.add(maxPQ.poll());
                    maxPQ.add(minPQ.poll());
                }
            } else {
                minPQ.add(num);

                if (maxPQ.peek() > minPQ.peek()) {
                    minPQ.add(maxPQ.poll());
                    maxPQ.add(minPQ.poll());
                }
            }
            sb.append(maxPQ.peek()).append("\n");
        }

        System.out.println(sb);
    }
}