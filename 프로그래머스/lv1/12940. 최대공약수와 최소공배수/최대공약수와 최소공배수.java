class Solution {
    public int[] solution(int n, int m) {
        int[] answer = new int[2];
        int minNM = 0;
        // 최대 공약수 구하기
        int max = 0; // 최대공약수 max
        if(n<=m) minNM=n;
        else minNM = m;
        for(int i=1;i<=minNM;i++){
            if(n%i==0 && m%i==0) max=i;
        }
        // 최소 공배수 구하기
        // 나눗셈을 이용한 최소공배수 구하기
        int min = 1; // 최소공배수 min
        for(int i=2;i<=minNM;i++){
            if(n%i==0&&m%i==0){
                n/=i;
                m/=i;
                min *= i;
                i--;
                
            }
        }
        min *=n;
        min *=m;
        
        answer[0]=max;
        answer[1]=min;
        return answer;
    }
}