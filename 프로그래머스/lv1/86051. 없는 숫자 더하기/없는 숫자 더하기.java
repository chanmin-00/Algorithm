class Solution {
    public int solution(int[] numbers) {
        int answer = 0;
        int[] num = {0,0,0,0,0,0,0,0,0,0};
        
        for(int i=0;i<numbers.length;i++){
            num[numbers[i]]+=1;
        }
        for(int i=0;i<num.length;i++){
            if(num[i]==0){
                answer+=i;
            }
        }
        
        
        return answer;
    }
}