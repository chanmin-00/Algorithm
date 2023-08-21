import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        int[] answer;
        // 버블 정렬 이용
        int min = arr[0];
        
        if(1<arr.length){
            for(int i=0;i<arr.length;i++){
                if(arr[i]<min){
                    min = arr[i];
                }
            }
            answer = new int[arr.length-1];
            ArrayList<Integer> list= new ArrayList<>();
            for(int a : arr){
                if(min!=a) list.add(a);
            }
            for(int i=0;i<answer.length;i++){
                answer[i]=list.get(i);
            }
        }
        else{
            answer = new int[1];
            answer[0] = -1;
        }
        return answer;
    }
}