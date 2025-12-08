// DP?로 푸는 것 같다. 
// 현재 수를 num으로 prevNum + n, prevNum * 2, prevNum * 3 중 최소 연산으로 하면 된다.

import java.util.*;
import java.io.*;

class Solution {
    public int solution(int x, int y, int n) {
        int answer = 0;
        int[] dp = new int[y + 1];    
        
        for (int i = x;i <= y;i++) {
            dp[i] = -1;
        }
        
        dp[x] = 0;
        
        for (int i = x + 1;i <= y; i++) {
            int num1 = 0;
            int num2 = 0;
            int num3 = 0;
            
            if (i >= n) {
                num1 = i - n; 
            }
            if (i % 2 == 0) {
                num2 = i / 2;
            }
            if (i % 3 == 0) {
                num3 = i / 3;
            }
            
            if (num1 >= x) {
                if (dp[num1] == -1 && dp[i] == -1) {
                    dp[i] = -1;
                }
                else if (dp[num1] != -1) {
                    if (dp[i] == -1) {
                        dp[i] = dp[num1] + 1;
                    }
                    else {
                        dp[i] = Math.min(dp[i], dp[num1] + 1);
                    }
                }
                
            }
            
            if (num2 >= x) {
                if (dp[num2] == -1 && dp[i] == -1) {
                    dp[i] = -1;
                }
                else if (dp[num2] != -1) {
                    if (dp[i] == -1) {
                        dp[i] = dp[num2] + 1;
                    }
                    else {
                        dp[i] = Math.min(dp[i], dp[num2] + 1);
                    }
                }     
            }
            
            if (num3 >= x) {
                if (dp[num3] == -1 && dp[i] == -1) {
                    dp[i] = -1;
                }
                else if (dp[num3] != -1) {
                    if (dp[i] == -1) {
                        dp[i] = dp[num3] + 1;
                    }
                    else {
                        dp[i] = Math.min(dp[i], dp[num3] + 1);
                    }
                }     
            }
        }
        
        answer = dp[y];
    
        return answer;
        
    }
}