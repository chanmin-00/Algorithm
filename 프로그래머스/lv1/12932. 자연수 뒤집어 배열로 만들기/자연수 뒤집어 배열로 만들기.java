class Solution {
    public int[] solution(long n) {
        int[] answer;
        Long nLong = Long.valueOf(n);
        String[] nString = nLong.toString().split("");
        answer = new int[nString.length];
        for(int i=nString.length-1,j=0;i>=0;i--,j++){
            answer[j]=Integer.parseInt(nString[i]);
        }
        return answer;
    }
}