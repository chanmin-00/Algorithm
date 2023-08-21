class Solution {
    boolean solution(String s) {
        boolean answer = true;
        s = s.toUpperCase();
        int pcnt = 0;
        int ycnt = 0;
        
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='P') pcnt++;
            else if(s.charAt(i)=='Y') ycnt++;
        }
        
        if(pcnt==ycnt) answer = true;
        else if(pcnt!=ycnt) answer = false;

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println(s);

        return answer;
    }
}