class Solution {
    public long solution(int[] sequence) {
        long answer = 0;
        int[] startPlus = new int[sequence.length];
        int[] startMinus = new int[sequence.length];
        boolean buhoFlag = true;
        
        for (int i = 0; i < sequence.length; i++) {
            if (buhoFlag) {
                startPlus[i] = sequence[i];
                startMinus[i] = sequence[i] * -1;
                
                buhoFlag = false;
            }
            else {
                startPlus[i] = sequence[i] * -1;
                startMinus[i] = sequence[i]; 
                
                buhoFlag = true;
            }
            
        }
        
        // 이제부터는 연속 부분 수열의 최댓값을 구하기 문제로 바뀜
        // 1. startPlus 배열부터
        long current = 0L;
        long sum = 0L;
        for (int i = 0;i < sequence.length; i++) {
            current += (long) startPlus[i];
            if (current > 0) {
                sum = Math.max(current, sum);
            }
            else {
                current = 0L;
            }
        }
        
        answer = Math.max(sum, answer);
        current = 0L;
        sum = 0L;
        for (int i = 0;i < sequence.length; i++) {
            current += (long) startMinus[i];
            if (current > 0) {
                sum = Math.max(current, sum);
            }
            else {
                current = 0L;
            }
        }
        
        answer = Math.max(sum, answer);
        
        return answer;
    }
}