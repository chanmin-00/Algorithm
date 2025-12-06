import java.util.*;
import java.io.*;

// 가장 최근에 멈춘 과제부터 시작을 한다 -> 이것은 스택
// endTime이 아니라 playTime이구나

class Solution {
    
    public static class Homework {
        String name; // 과제의 이름
        int start; // 과제의 시작 시간
        int playTime; // 과제의 종료 시간
        
        public Homework(String name, int start, int playTime) {
            this.name = name;
            this.start = start;
            this.playTime = playTime;
        }
    }
    
    public String[] solution(String[][] plans) {
        int planCount = plans.length;
        String[] answer = new String[planCount];
        
        List<Homework> workList = new ArrayList<>();
        Stack<Homework> workStack = new Stack<>(); // 멈춘 과제 목록 정보를 저장하고 있어야 함
        
        
        for (int i = 0; i < planCount; i++) {
            String name = plans[i][0];
            String[] time = plans[i][1].split(":");
            int start = Integer.parseInt(time[0]) * 60 + Integer.parseInt(time[1]);
            int playTime = Integer.parseInt(plans[i][2]);
            
            workList.add(new Homework(name, start, playTime));
        }
        
        Collections.sort(workList, (w1, w2) -> {
            return w1.start - w2.start;
        });
        
        int answerIndex = 0;
        
        workStack.push(workList.get(0)); // 기존에 진행 중이던 과제
        int nowTime = workList.get(0).start;
        
        for (int i = 1; i < workList.size(); i++) {
            Homework nowHomework;
            
            while(!workStack.isEmpty()) {
                nowHomework = workStack.peek();
                
                if (nowTime + nowHomework.playTime <= workList.get(i).start) {
                    answer[answerIndex] = nowHomework.name;
                    answerIndex++;
                    
                    workStack.pop();
                    nowTime = nowTime + nowHomework.playTime;
                }
                else {
                    workStack.pop();
                    
                    nowHomework.playTime = nowHomework.playTime + nowTime - workList.get(i).start;
                    workStack.push(nowHomework);
                    break;
                }
            }
            
            nowTime = workList.get(i).start;
            workStack.push(workList.get(i));
            
        }
        
        for (int i = answerIndex; i < planCount ; i++) {
            answer[i] = workStack.pop().name;
        }
        
        return answer;
    }
}