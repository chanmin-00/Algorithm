import java.io.*;
import java.util.*;

// 조건 중 하나를 만족을 해야 한다.
// 공약수인 것과 공약수가 아닌 것, 가장 큰 양의 정수 a
class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        
        // 정렬
        Arrays.sort(arrayA);
        Arrays.sort(arrayB);
        
        HashSet<Integer> aSet = new HashSet<>(); // a의 모든 숫자를 나눌 수 있는 수의 집합
        HashSet<Integer> tmpASet = new HashSet<>();
        
        HashSet<Integer> bSet = new HashSet<>(); // b의 모든 숫자를 나눌 수 있는 수의 집합
        HashSet<Integer> tmpBSet = new HashSet<>();
        
        // A의 약수부터 구하기
        for (int i = 2; i <= arrayA[0]; i++) {
            if (arrayA[0] % i == 0) {
                tmpASet.add(i);
            }
        }
        
        for (Integer value : tmpASet) {
            boolean flag = true;
            
            for (int i = 0;i < arrayA.length; i++) {
                if (arrayA[i] % value != 0) {
                    flag = false;
                    break;
                }
            }
            
            if (flag == true) {
                aSet.add(value);
            }
        }
        
        // B의 약수 구하기
        for (int i = 2; i <= arrayB[0]; i++) {
            if (arrayB[0] % i == 0) {
                tmpBSet.add(i);
            }
        }
        
        for (Integer value : tmpBSet) {
            boolean flag = true;
            
            for (int i = 0;i < arrayB.length; i++) {
                if (arrayB[i] % value != 0) {
                    flag = false;
                    break;
                }
            }
            
            if (flag == true) {
                bSet.add(value);
            }
        }
        
        // a의 모든 숫자를 나눌 수 있고, b의 모든 숫자를 나눌 수 없는 경우
        for (Integer value : aSet) {
            boolean flag = true;
            for (int i = 0; i < arrayB.length; i++) {
                if (arrayB[i] % value == 0) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                answer = Math.max(answer, value);
            }
        }
        
        // B에는 포함되고, A에 포함 안되는거 찾기
        for (Integer value : bSet) {
            boolean flag = true;
            for (int i = 0; i < arrayA.length; i++) {
                if (arrayA[i] % value == 0) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                answer = Math.max(answer, value);
            }
        }
        
        return answer;
    }
}