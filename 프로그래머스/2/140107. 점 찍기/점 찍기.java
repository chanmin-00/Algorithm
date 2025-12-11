// 원점과의 거리를 나타내는 것이므로 원의 반경 안에 들어야 한다.

class Solution {
    public long solution(int k, int d) {
        long answer = 0;
        
        long maxA = (long) d / (long) k;
        
        long longD = (long) d;
        long longK = (long) k;
        
        for (long a = 0; a <= maxA; a++) {
            long maxY = (long) Math.floor(Math.sqrt((longD * longD) - (a * longK * a * longK)));
            long maxB = maxY / k;
            // System.out.println(maxB);
            
            answer += maxB + 1;
        }
        
        
        return answer;
    }
}