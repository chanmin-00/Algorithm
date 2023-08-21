class Solution {
    public long solution(int a, int b) {
        long answer = 0;
        long cnt = 0;
        if(a<b){
            cnt = (long) b - (long) (a-1);
            answer = ((long) b + (long) a) * cnt / 2;
        }
        else if(b<a){
            cnt = (long) a - (long) (b-1);
            answer = ((long) b + (long) a) * cnt / 2;
        }
        else return (long) a;
        return answer;
    }
}