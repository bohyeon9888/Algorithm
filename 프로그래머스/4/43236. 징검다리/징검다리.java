import java.util.*;

class Solution {
    public int solution(int distance, int[] rocks, int n) {
        int answer = 0;
        
        Arrays.sort(rocks);
        
        int left = 1;
        int right = distance;
        // 출발지점과 도착지점, 바위 간 거리의 개수
        // int num = (rocks.length - (n - 1)) / 2 + 2;
        
        int min = Integer.MAX_VALUE;
        while (left <= right) {
            int mid = (left + right) / 2;
            int prev = 0;
            // 없애야 하는 바위
            int cnt = 0;
            
            for (int i = 0; i < rocks.length; i++) {
                if (rocks[i] - prev < mid) {
                    cnt++;
                    continue;
                }
                
                prev = rocks[i];
            }
            
            if (distance - prev < mid) cnt++; 
            
            if (cnt <= n) {
                answer = Math.max(mid, answer);
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        
        return answer;
    }
}