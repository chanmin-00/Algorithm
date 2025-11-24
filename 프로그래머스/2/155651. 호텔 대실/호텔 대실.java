import java.io.*;
import java.util.*;

// List나 Set 등을 순회할 때는 중간에 값을 추가하거나 삭제하지 말자!!, 순회의 노선이 변경되게 된다.
// Set은 중복을 허용하지 않는다는 점을 유의하자!
class Solution {
    
    static class Time {
        int start;
        int end;
    
        public Time (String str1, String str2) {
            String[] arr1 = str1.split(":");
            String[] arr2 = str2.split(":");
        
            start = Integer.parseInt(arr1[0]) * 60 + Integer.parseInt(arr1[1]);
            end = Integer.parseInt(arr2[0]) * 60 + Integer.parseInt(arr2[1]);
        }
    
    }
    
    public int solution(String[][] book_time) {
        int answer = 0;
        int bookTimeLen = book_time.length;
        
        List<Time> timeList = new ArrayList<>();
        
        for (int i = 0;i < bookTimeLen; i++) {
            String str1 = book_time[i][0];
            String str2 = book_time[i][1];
            
            timeList.add(new Time(str1, str2));
        }
        
        Collections.sort(timeList, (t1, t2) -> t1.start - t2.start);
        
        Queue<Integer> minQueue = new PriorityQueue<>(); // 최소 힙
        // 큐의 사이즈가 현재 사용하고 있는 방의 개수라고 할 수 있다.
        
        for (Time time : timeList) {
            // 현재 시간대에서 사용할 수 있는 방을 확인하자.
            // 사용 가능한 모든 방들을 일단 비우자.
            while (!minQueue.isEmpty() && minQueue.peek() + 10 <= time.start) {
                minQueue.poll();
            }
            
            // 새로운 종료 시간을 넣는다.
            minQueue.offer(time.end);
            
            answer = Math.max(answer, minQueue.size());
        }
        
        
        return answer;
    }
}