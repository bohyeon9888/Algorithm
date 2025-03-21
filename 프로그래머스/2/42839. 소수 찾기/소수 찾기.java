import java.util.*;

class Solution {
    Set<Integer> set = new HashSet<>();
    boolean[] check;
    
    public int solution(String numbers) {
        check = new boolean[numbers.length()];
        for (int i = 0; i < numbers.length(); i++) {
            dfs(numbers, "", i+1);
        }
        
        int answer = 0;
        for (Integer num : set) {
            System.out.println(num);
            if (isPrime(num)) answer++;
        }
        
        return answer;
    }
    
    public void dfs (String numbers, String tmp, int cnt) {
        if (tmp.length() == cnt) {
            set.add(Integer.parseInt(tmp));
        }
        
        for (int i = 0; i < numbers.length(); i++) {
            if (!check[i]) {
                check[i] = true;
                tmp += numbers.charAt(i);
                dfs(numbers, tmp, cnt);
                check[i] = false;
                tmp = tmp.substring(0, tmp.length() - 1);
            }
        }
    }
    
    public boolean isPrime(Integer num) {
        if (num < 2) return false;
        if (num == 2) return true;
        if (num % 2 == 0) return false;
        
        for (int i = 3; i * i <= num; i += 2) {
            if (num % i == 0) return false;
        }
        
        return true;
    }
}