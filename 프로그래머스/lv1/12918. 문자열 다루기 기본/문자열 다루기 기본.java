class Solution {
    public boolean solution(String s) {
        boolean answer = false;
        boolean lengt = false;
        boolean alpha = false;
        int beforelen = s.length();
        int afterlen = 0;
        
        if(s.length()==4 || s.length()==6) lengt = true;

        s=s.replaceAll("[^0-9]","");
        afterlen = s.length();
        
        if(afterlen==beforelen) alpha = true;
        
        if(lengt&&alpha) answer = true;
        
        return answer;
    }
}