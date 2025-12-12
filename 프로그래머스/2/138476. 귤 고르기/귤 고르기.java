import java.io.*;
import java.util.*;

class Solution {
    
    static class Tangerine {
        int size;
        int cnt;
    
        public Tangerine (int size, int cnt) {
            this.size = size;
            this.cnt = cnt;
        }
    }
    
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        int tmpK = 0;
        
        List<Tangerine> tList = new ArrayList<>();
        HashMap<Integer, Integer> tMap = new HashMap<>();
        
        for (int i = 0; i < tangerine.length; i++) {
            if (tMap.containsKey(tangerine[i])) {
                tMap.put(tangerine[i], tMap.get(tangerine[i]) + 1);
            }
            else {
                tMap.put(tangerine[i], 1);
            }
        }
        
        Set<Integer> keySet = tMap.keySet();
        for (Integer key : keySet) {
            tList.add(new Tangerine(key, tMap.get(key)));
        }
        
        // 귤의 개수가 많은 순으로 내림차순
        Collections.sort(tList, (t1, t2) -> {
           return t2.cnt -  t1.cnt;
        });
        
        for (int i = 0; i < tList.size(); i++) {
            tmpK += tList.get(i).cnt;
            answer += 1;
            
            if (tmpK >= k) {
                break;
            }
        }
        
        return answer;
    }
}