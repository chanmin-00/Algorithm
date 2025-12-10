// 이중 반복문으로 돌리면 무조건 시간초과가 난다
// 이거를 단일 반복문으로 해결해야 함
// 수학적으로 접근을 해야 한다.

class Solution {
    public long solution(int r1, int r2) {
        long answer = 0L;
        
        long longR1 = (long) r1;
        long longR2 = (long) r2;
        
        for (long x = 1; x <= longR2; x++) {
            // x가 1일 때 반지름이 r1이기 위해서 필요한 Y값을 올림하면 최소 Y값이 나오게 된다.
            long minY = 0;
            if (r1 > x) {
                minY = (long) Math.ceil((Math.sqrt((longR1 * longR1) - (x * x))));
            }
            // x가 r1보다 커지게 되면 MinY는 무조건 0임 일단 다 포함이 되기 때문
        
            
            long maxY = (long) Math.floor(Math.sqrt((longR2 * longR2) - (x * x)));
            
            answer += (maxY - minY + 1);

            // System.out.println(maxY - minY + 1);
        }
        
        answer = 4 * answer;
        
        return answer;
    }
}