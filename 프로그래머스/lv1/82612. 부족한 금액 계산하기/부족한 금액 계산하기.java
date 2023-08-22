class Solution {
    public long solution(int price, int money, int count) {
        long answer = -1;
        long total = 0;
        
        for(int i=1;i<count+1;i++){ // 총 이용료 계산
            total+=price*i;
        }
        
        if(money<total){
            answer = total - money;
        }
        else return 0;

        return answer;
    }
}