class Solution {
    public int solution(int left, int right) {
        int answer = 0;
        int count = 0;
        
        for(int i=left;i<right+1;i++){
            for(int j=1;j<i+1;j++){ // i 약수 세기
                if(i%j==0){
                    count++;
                }
            }
            if(count%2==0){
                answer+=i;
            }
            else{
                answer-=i;
            }
            count=0;
        }
        return answer;
    }
}