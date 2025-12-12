import java.util.*;
import java.io.*;

// 모두 낮은 경우가 한 번이라도 있는 경우
// 이중 반복문으로 무조건 시간초과가 난다.
// 단일 반복문으로 푸는 방법을 찾아야 함
// 첫번째 점수로 내림차순을 일단 먼저 하면, 두 번째 값만 단일 반복문으로 체크를 하면 된다.
// 첫번째 점수로 이미 정렬을 했기 때문에 이후에 두번째 값이 지금까지 최댓값보다 작으면
// 무조건 두 수 중 나보다 두 개다큰게 있다는 것을 의미
class Solution {
    
    public int solution(int[][] scores) {
        int wanhoScore1 = scores[0][0];
        int wanhoScore2 = scores[0][1];
        int wanhoSum = wanhoScore1 + wanhoScore2;
    
        // 1. 첫 번째 점수 내림차순 정렬 (같으면 두 번째 점수 오름차순)
        Arrays.sort(scores, (a, b) -> {
            if (a[0] == b[0]) return a[1] - b[1];
            return b[0] - a[0];
        });
    
        int maxScore2 = 0;
        int rank = 1;
    
        for (int[] score : scores) {
        
            // 2. 두 번째 점수가 지금까지 최댓값보다 작으면 탈락
            if (score[1] < maxScore2) {
                // 완호가 탈락한 경우
                if (score[0] == wanhoScore1 && score[1] == wanhoScore2) {
                    return -1;
                }
            
                continue;  // 이 사람은 인센티브 못 받음
        }
        
        // 3. 두 번째 점수 최댓값 갱신
        maxScore2 = Math.max(maxScore2, score[1]);
        
        // 4. 완호보다 합이 크면 순위 증가
        if (score[0] + score[1] > wanhoSum) {
            rank++;
        }
    }
    
    return rank;
    }
}