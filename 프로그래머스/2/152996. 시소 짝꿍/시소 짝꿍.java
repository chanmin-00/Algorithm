import java.util.*;
import java.io.*;

class Solution {
    public long solution(int[] weights) {
        long answer = 0;
        Map<Double, Long> map = new HashMap<>();
        
        for (int w : weights) {
            
            // 현재 무게와 파트너가 될 수 있는 값들
            // 파트너가 될 수 있는 것들의 무게 원본
            double[] partners = {
                w * 1.0, // 같은 무게면 항상 파트너
                (w * 2.0) / 3,
                (w * 2.0) / 4,
                (w * 3.0) / 2,
                (w * 3.0) / 4,
                (w * 4.0) / 2,
                (w * 4.0) / 3
            };
            
            for (double partner : partners) {
                if (map.containsKey(partner)) {
                    answer += map.get(partner);
                }
            }
            
            map.put(w * 1.0, map.getOrDefault(w * 1.0, 0L) + 1);
        }
        
        return answer;
    }
}