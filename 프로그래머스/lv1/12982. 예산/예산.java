import java.util.*;

class Solution {
    public int solution(int[] d, int budget) {
        int answer = 0;
        int tmp = 0;
        
        // 1. d 배열 오름차순 정렬
        Arrays.sort(d);
        // 2. 앞에서 부터 n개씩 뽑아서 더해보기
        for(int i=0;i<d.length;i++){
            int sum = 0;
            for(int j=0;j<d.length-i;j++){
                sum+=d[j];
            }
            if(sum<=budget){
                tmp = d.length-i;
                break;
            }
        }
        
        
        
        return answer = tmp;
    }
}