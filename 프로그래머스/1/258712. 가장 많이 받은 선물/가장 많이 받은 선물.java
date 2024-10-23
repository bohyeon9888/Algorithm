import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        
        // 각 친구의 인덱스 저장
        Map<String, Integer> idx = new HashMap<>();
        // 친구 간 주고 받은 선물 수
        int[][] giftRec = new int[friends.length][friends.length + 1];
        // 각 사람의 선물지수
        int[] giftNum = new int[friends.length];
        
        for (int i = 0; i < friends.length; i++) {
            idx.put(friends[i], i);
        }
        
        for (int i = 0; i < gifts.length; i++) {
            String[] arr = gifts[i].split(" ");
            // 선물 준 사람의 인덱스
            int send = idx.get(arr[0]);
            // 선물 받은 사람의 인덱스
            int rec = idx.get(arr[1]);
            
            giftRec[send][rec] += 1;
            giftNum[send] += 1;
            giftNum[rec] -= 1;            
        }
        
        for (int i = 0; i < friends.length; i ++) {
            int cnt = 0;    // 한 사람이 다음 달에 받을 선물 수
            for (int j = 0; j < friends.length; j++) {
                if (giftRec[i][j] > giftRec[j][i]) {
                    cnt ++;
                    continue;
                }
                
                if (giftRec[i][j] == giftRec[j][i] && giftNum[i] > giftNum[j]) {
                    cnt++;
                    continue;
                }
            }
            
            answer = Math.max(answer, cnt);
        }
        
        return answer;
    }
}