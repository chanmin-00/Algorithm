class Solution {
    public int solution(int num) {
        int answer = 0;
        int count = 0;
        long num1 = (long) num;
        
        if(num1==1) return 0;
        
        while(num1!=1){
            if(num1%2==0){
                num1/=2;
            }
            else{
                num1 = num1*3 + 1;
            }
            count++;
            if(count==500&&num1!=1){
                count = -1;
                break;
            }
        }
        
        
        return answer = count;
    }
}
