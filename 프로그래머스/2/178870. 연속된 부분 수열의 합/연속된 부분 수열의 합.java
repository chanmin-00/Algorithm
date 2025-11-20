import java.io.*;
import java.util.*;

// 오름차순으로 정렬된 수열이다.
// 누적합 문제이다.
// 2차원 배열로 푸니까 메모리초과가 난다.
// 그러면 1차원 배열로 바꿔서 누적합으로
// 근데 또 이중 반복문으로 시간초과가 난다.
// 그러면 1중 반복문으로 풀어야 한다.
// 정렬되어 있다는 것을 이용하자.

class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        int N = sequence.length;
        
        int[] prefixSum = new int[N + 1];
        prefixSum[1] = sequence[0];
        
        int minLen = Integer.MAX_VALUE;
        
        for (int i=2;i<=N;i++){
            prefixSum[i] = prefixSum[i - 1] + sequence[i -1];
        }
        
        // two 포인터 방식을 이용하자.
        int leftIndex = 1;
        int rightIndex = 1;
        
        // 처음부터 시작해서
        // 좌우 인덱스를 하나씩 움직이면서 시작하자
        // 왼쪽부터 시작을 하기 때문에 길이가 같은 것은 고려할 필요 없음
        // 가장 먼저 찾게 되는게 가장 왼쪽 인덱스이기 때문에
        while (true) {
            int sum = prefixSum[rightIndex] - prefixSum[leftIndex - 1];
            
            if (sum == k) {
                if (minLen > (rightIndex - leftIndex + 1)) {
                    minLen = rightIndex - leftIndex + 1;
                    answer[0] = leftIndex - 1;
                    answer[1] = rightIndex - 1;
                }
            
                leftIndex++;
            }
            else if (sum > k) {
                leftIndex++;    
            }
            else if (sum < k)
                rightIndex++;
                if (rightIndex > N) {
                    break;
                }
            }

    
        return answer;
    }
}