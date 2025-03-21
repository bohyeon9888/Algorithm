import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] p1 = {1, 2, 3, 4, 5};
        int[] p2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] p3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        int[] people = new int[4];        
        
        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == p1[i % p1.length]) people[1]++;
            if (answers[i] == p2[i % p2.length]) people[2]++;
            if (answers[i] == p3[i % p3.length]) people[3]++;
        }
        
        int max = Math.max(people[1], Math.max(people[2], people[3]));
        
        List<Integer> maxList = new ArrayList<>();
        for (int i = 1; i <= 3; i++) {
            if (max == people[i]) maxList.add(i);
        }
        
        int[] answer = maxList.stream().mapToInt(i -> i).toArray();
        Arrays.sort(answer);
        
        return answer;
    }
}