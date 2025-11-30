import java.util.*;
import java.io.*;

// 람다식을 정렬을 하기 위해서는 리턴값이 음수 또는 양수이어야 한다.

class Solution {
    
    public static class Node {
        int colValue;
        int primaryKeyValue;
        int rowIndex;
        
        public Node (int colValue, int primaryKeyValue, int rowIndex) {
            this.colValue = colValue;
            this.primaryKeyValue = primaryKeyValue;
            this.rowIndex = rowIndex;
        }
    }
    
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        int answer = 0;
        List<Node> nodeList = new ArrayList<>();
        
        int dataRow = data.length;
        int dataCol = data[0].length;
        int[][] sortedData = new int[dataRow][dataCol];
        
        for (int i = 0;i < dataRow; i++) {
            nodeList.add(new Node(data[i][col - 1], data[i][0], i));
        }
        
        // 정렬할려고 하면 결과가 양수 또는 음수가 나와야 한다.
        // 람다식을 활용한 정렬하기, 결과값은 음수 또는 양수가 나오게
        Collections.sort(nodeList, (n1, n2) -> {
            if (n1.colValue !=  n2.colValue) {
                return n1.colValue - n2.colValue; // 오름차순
            }
            else {
                return n2.primaryKeyValue - n1.primaryKeyValue;
            }
        });
        
        for (int i = 0;i < dataRow; i++) {
            int currentIndex = nodeList.get(i).rowIndex;
            for (int j = 0;j < dataCol; j++) {
                sortedData[i][j] = data[currentIndex][j];
                // System.out.print(sortedData[i][j] + " ");
            }
            // System.out.println();
        }
        
        for (int i = row_begin;i <= row_end; i++) {
            int sum = 0;
            for (int j = 0;j < dataCol; j++) {
                sum += sortedData[i - 1][j] % i;
            }
            
            if (answer == 0) {
                answer = sum;
            }
            else {
                // 자바에서의 정수형 간의 xor 연산자는 ^ 를 활용할 수 있다.
                answer = answer ^ sum;
            }
        }
        
        
        
        return answer;
    }
}