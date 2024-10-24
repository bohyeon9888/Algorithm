import java.util.*;

class Solution {
    int[][] dices;
    int n;
    int[] answer;
    List<Integer> choice;
    List<Integer> listA;
    List<Integer> listB;
    
    public int[] solution(int[][] dice) {
        
        n = dice.length;
        choice = new ArrayList<>();
        
        dices = new int[n][];
        for (int i = 0; i < n; i++) {
            dices[i] = Arrays.copyOf(dice[i], dice[i].length);
        }
        
        answer = new int[n/2];
        combi(0, 0);
        
        return answer;
    }
    
    int max = 0;
    public void combi(int start, int cnt) {
        if (cnt == n/2) {
            int win = cal();
            if (max < win) {
                max = win;
                for (int i = 0; i < n/2; i++) {
                    answer[i] = choice.get(i) + 1;
                }
            }
            
            return;
        }
        
        for (int i = start; i < n; i++) {
            choice.add(i);
            combi(i + 1, cnt + 1);
            choice.remove(choice.size() - 1);
        }
    }
    
    public int cal() {
        int win = 0;
        
        makeList();
        
        Collections.sort(listB);
        for (int i = 0; i < listA.size(); i++) {
            int now = listA.get(i);
            
            int left = 0;
            int right = listB.size() - 1;
            
            int cnt = 0;
            while(left <= right) {
                int mid = (left + right) / 2;
                
                if (listB.get(mid) < now) {
                    left = mid + 1;
                    cnt = Math.max(cnt, mid);
                } else right = mid - 1;
            }
            
            if (cnt > 0) win += (cnt + 1);
        }
        
        return win;
    }
    
    public void makeList() {
        listA = new ArrayList<>();
        listB = new ArrayList<>();
        
        int[][] diceA = new int[n/2][6];
        int[][] diceB = new int[n/2][6];
        int a = 0, b = 0;
        
        for (int i = 0; i < n; i ++) {
            if (choice.contains(i)) { // A 주사위 모음
                diceA[a] = dices[i];
                a++;
            } else {    // B 주사위 모음
                diceB[b] = dices[i];
                b++;
            }
        }
        
        saveSum(0, 0, diceA, listA);
        saveSum(0, 0, diceB, listB);
    }
    
    public void saveSum(int depth, int sum, int[][] dice, List<Integer> list) {
        if (depth == n/2) {
            list.add(sum);
            return;
        }
        
        for (int i = 0; i < 6; i++) {
            saveSum(depth + 1, sum + dice[depth][i], dice, list);
        }
    }
}