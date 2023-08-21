class Solution {
    public int solution(String s) {
        int answer = 0;
        String numtmp = s.replaceAll("[^0-9]","");
        String plmitmp = s.replaceAll("[0-9]","");
        
        if(plmitmp.equals("-")){
            answer = Integer.valueOf(numtmp)*-1;
        }
        else answer = Integer.valueOf(numtmp);
        
        return answer;
    }
}