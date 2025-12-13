class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        
        for (int i = 1; i < triangle.length; i++) {
            for (int j = 0; j < triangle[i].length; j++) {
                int original = triangle[i][j];
                
                if (j != triangle[i].length - 1 && j > 0) {
                    triangle[i][j] = Math.max(triangle[i - 1][j - 1], triangle[i - 1][j]);
                }
                else if (j == 0) {
                    triangle[i][j] = triangle[i - 1][j];
                }
                else if (j == triangle[i].length - 1) {
                    triangle[i][j] = triangle[i - 1][j - 1];
                }

                triangle[i][j] += original;
                
                answer = Math.max(answer, triangle[i][j]);
            }
        }
        
        return answer;
    }
}