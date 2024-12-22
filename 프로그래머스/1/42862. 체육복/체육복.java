import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n - lost.length;

        Arrays.sort(lost);
        Arrays.sort(reserve);

        // Step 1: 도난당한 학생이 여벌 체육복을 가진 경우 우선 처리
        Set<Integer> reserves = Arrays.stream(reserve)
                                      .boxed()
                                      .collect(Collectors.toSet());
        Set<Integer> lostSet = Arrays.stream(lost)
                                     .boxed()
                                     .collect(Collectors.toSet());

        for (Iterator<Integer> iterator = lostSet.iterator(); iterator.hasNext();) {
            int student = iterator.next();
            if (reserves.contains(student)) {
                reserves.remove(student);
                iterator.remove(); // lostSet에서 제거
                answer++;
            }
        }

        // Step 2: 체육복 빌려주기
        for (int student : lostSet) {
            if (reserves.contains(student - 1)) {
                reserves.remove(student - 1);
                answer++;
            } else if (reserves.contains(student + 1)) {
                reserves.remove(student + 1);
                answer++;
            }
        }
        
        return answer;
    }
}