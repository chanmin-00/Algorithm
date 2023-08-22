class Solution {
    public String solution(String s) {
        String answer = "";
        String[] sArr = s.split("");
        if(sArr.length%2==1){
            answer = sArr[sArr.length/2];
        }
        else{
            answer = sArr[sArr.length/2-1]+sArr[sArr.length/2];
        }
        return answer;
    }
}