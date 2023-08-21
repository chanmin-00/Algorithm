class Solution {
    public String solution(String phone_number) {
        String answer = "";
        int length = phone_number.length();
        StringBuilder sb = new StringBuilder("");
        String tmp = phone_number.substring(length-4);
        
        for(int i=0;i<length-4;i++){
            sb.append("*");
        }
        sb.append(tmp);
        
        return answer=sb.toString();
    }
}