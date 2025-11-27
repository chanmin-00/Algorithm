import java.util.*;
import java.io.*;

public class Solution {
	
	public static class Node {
		int index;
		int value;
		
		public Node (int index, int value) {
			this.index = index;
			this.value = value;
		}
	}
	
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        int len = numbers.length;
        
        Stack<Node> stack = new Stack<>();
        stack.push(new Node(0, numbers[0]));
        
        int currentIndex = 1;
        
        while (!stack.isEmpty()) {
        	if (currentIndex == len) {
        		break;
        	}
        	
        	Node topNode = stack.pop();
        	
        	if (topNode.value < numbers[currentIndex]) {
        		answer[topNode.index] = numbers[currentIndex];
        		
        		while (!stack.isEmpty() && stack.peek().value < numbers[currentIndex]) {
        			Node outOfNode = stack.pop();
        			answer[outOfNode.index] = numbers[currentIndex];
        		}
        		
        		stack.push(new Node(currentIndex, numbers[currentIndex]));
        		
        		currentIndex++;
        	}
        	else {
        		stack.push(topNode);
        		stack.push(new Node(currentIndex, numbers[currentIndex]));
        		
        		currentIndex++;
        	}
        }
        
        for (int i = 0;i < len;i ++) {
        	if (answer[i] == 0) {
        		answer[i] = -1;
        	}
        }
        
        
        return answer;
    }

}
