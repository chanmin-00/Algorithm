// 최종 도착지는 0층
// 구하고자 하는 것, 마법의 돌의 최소값
// 최소값 ---> 최단거리? 문제로 바꿀 수 있지 않을까?
// 최단거리이면 bfs로 풀 수 있을거 같음, 하지만 bfs로 풀면은 탐색공간이 너무 넓어지게 되서 시간초과가 발생한다.
// 문제 풀이를 위한 방법
// 현재 마지막 자릿수가 4 이하면 그냥 1층씩 내려가는게 빠름
// 현재 마지막 자릿수가 6 이상이면 올라갔다가 더 큰 자릿수로 한 번에 내려오는게 나음
// 현재 자릿수가 5이면 다음 자릿수를 보고 판단

// 예를 들어 14층, 이때는 4층 내려가고 10층을 한꺼번에 내려오는게 나음
// 예를 들어 16층, 이때는 4층 올라가고 10층을 2번만에 내려오는게 나음
// 예를 들어 15층, 이때는 5층 내려가고 10층을 한꺼번에 내려오는게 나음
// 예를 들어 65층, 이때는 5층 내려가고 10층을 6번에 내려오는 것보다
//              이때는 5층 올라가고, 70층이 되어서 4번 올라가서 100층을 한번에 내려오는게 나음

// 현재 상황에서 가장 좋은 것을 찾아가는 것이므로 그리디가 적합

import java.io.*;
import java.util.*;

class Solution {
    
    public int solution(int storey) {
        int answer = 0;
        
        while (storey != 0) {
            int finalNum = storey % 10;
            int finalNextNum = (storey / 10) % 10;
            
            if (finalNum >= 6) {
                answer = answer + (10 - finalNum);
                storey = storey / 10 + 1;
            }
            else if (finalNum <= 4) {
                answer = answer + finalNum;
                storey = storey / 10;
            }
            else {
                if (finalNextNum >= 5) {
                    answer = answer + (10 - finalNum);
                    storey = storey / 10 + 1;
                }
                else {
                    answer = answer + finalNum;
                    storey = storey / 10;
                }
            }
            
        }
        
        return answer;
    }
}