import java.util.*;

public class Solution {
    public int solution(int n) {
        int answer = 0;
        int ntmp = n;
        int sum = 0;
        while(ntmp!=0){
            sum += ntmp%10;
            ntmp /= 10;
        }
        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("Hello Java");
        System.out.println(sum);
        
        return answer=sum;
    }
}