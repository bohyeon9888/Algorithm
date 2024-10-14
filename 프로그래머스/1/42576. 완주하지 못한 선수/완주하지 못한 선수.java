import java.util.*;
class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        Map<String, Integer> map = new HashMap<>();
        
        for (String name : participant) {
            map.put(name, map.getOrDefault(name, 0) + 1);
        }
        
        for (String name : completion) {
            int n = map.get(name);
            map.put(name, n-1);
        }
        
        for (String key : map.keySet()) {
            if (map.get(key) != 0) answer = key;
        }
        
        return answer;
    }
}