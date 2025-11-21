import java.io.*;
import java.util.*;
import java.lang.*;

// minerals의 정해진 순서대로 캐야 함
// picks는 각각 곡갱이의 개수
// 최소한의 피로도로 광물을 캐야함
// 한 번 사용한 곡갱이의 개수를 다 사용할 때까지 다 캐야 함
// 그러면 총 6가지의 경우의 수

// 5가지의 구간을 가진다. 하나의 곡갱이로 캘 수 있는 개수가 최대 5개이기 때문
// 캐기 어려운 다이아몬드를 많이 가지고 있을 수록, 즉, 어려운 난이도일 수록 좋은 곡갱이로 캐야 한다.
// 즉 그리디?

class Solution {
    public int solution(int[] picks, String[] minerals) {
        int answer = 0;
        
        int pickCnt = (picks[0] + picks[1] + picks[2]) * 5; // 곡갱이로 캘수 있는 총 구간 개수
        int groupCnt = Math.min(pickCnt, minerals.length);
        
        // 5구간씩 묶어서 난이도 계산
        List<int[]> groupList = new ArrayList<>();
        
        for (int i=0;i<groupCnt;i+=5) {
            int dia = 0;
            int iron = 0;
            int stone = 0;
            
            for (int j=i;j<Math.min(i + 5, groupCnt);j++) {
                if (minerals[j].equals("diamond")) {
                    dia++;
                }
                if (minerals[j].equals("iron")) {
                    iron++;
                }
                if (minerals[j].equals("stone")) {
                    stone++;
                }
            }
            groupList.add(new int[]{dia, iron, stone});
        }
        
        // 돌 곡갱이로 캤을 때 기준으로 피로도가 높은 순으로 내림차순 정렬한다.
        // 그러면 피로도가 높은 것부터 좋은 곡갱이로 캐면 된다.
        groupList.sort((a, b) -> {
            int costA = a[0] * 25 +  a[1] * 5 + a[0];
            int costB = b[0] * 25 +  b[1] * 5 + b[0];
            return costB - costA;
        });
            
        // 이제 정렬된 것을 가지고 좋은 곡갱이부터 적용시킨다. 즉 다이아몬드부터
        // 즉 groupList의 앞에서부터 다이아부터 적용시켜나감
        int pickIndex = 0;
        for (int[] group : groupList) {
            
            // 사용 가능한 곡갱이 찾기
            while (pickIndex < 3 && picks[pickIndex] == 0) {
                pickIndex++;
            }
            
            picks[pickIndex]--; // 곡갱이 개수 줄이기
            
            if (pickIndex == 0) {
                answer += (group[0] * 1 + group[1] * 1 + group[2] * 1);
            }
            else if (pickIndex == 1) {
                answer += group[0] * 5 + group[1] + group[2];
            }
            else {
                answer += group[0] * 25 + group[1]  * 5 + group[2];
            }
        }        
        
        return answer;
        
    
    }
}