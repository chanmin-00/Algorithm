class Solution {
    public int solution(int[] absolutes, boolean[] signs) {
        int answer =0;
        
        for(int i=0;i<signs.length;i++){
            if(signs[i]){
                answer+=(absolutes[i])*1;
            }
            else{
                answer+=(absolutes[i])*(-1);
            }
        }
        return answer;
    }
}