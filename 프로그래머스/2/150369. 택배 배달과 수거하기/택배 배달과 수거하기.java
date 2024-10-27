class Solution {
    
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long ans = 0;
        int deliv = 0;
        int pick = 0;
        
        // 뒤부터 탐색해야 시간초과 X
        for (int i = n-1; i >= 0; i--) {
            int cnt = 0;    // 각 집을 방문해야 하는 횟수
            
            if (deliveries[i] > 0 || pickups[i] > 0) {
                
                // 배달, 수거 둘 중 하나만 있어도 방문해야 하므로 방문 횟수 추가 및 배달, 수거 용량 늘려주기
                while (deliv < deliveries[i] || pick < pickups[i]) {
                    deliv += cap;
                    pick += cap;
                    cnt += 1;
                }

                // 현재 집에서 배달해야 할 것과 수거해야 할 것을 각각 빼줌
                deliv -= deliveries[i];
                pick -= pickups[i];

                // 정답에 집 거리의 왕복 방문 횟수만큼 곱해서 더해주기
                ans += (i+1) * cnt * 2;
            }
        }
        
        return ans;
    }
}