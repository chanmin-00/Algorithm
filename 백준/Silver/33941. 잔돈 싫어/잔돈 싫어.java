import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
       BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

       int N = Integer.parseInt(reader.readLine()); // 교통카드의 개수
       int[] arr = new int[N + 1];

       for (int i = 1; i <= N; i++) {
          arr[i] = Integer.parseInt(reader.readLine());
       }

       // dp를 다음과 같이 생각한다.
       // n번째 카드까지 고려했을 때, i번째 카드의 나머지가 j일때 최대인 경우
       long[][] dp = new long[N + 1][500];
       
       // -1로 초기화 (불가능한 상태 표시)
       for (int i = 0; i <= N; i++) {
          Arrays.fill(dp[i], -1);
       }
       
       dp[0][0] = 0; // 초기 상태: 아무것도 선택 안함

       for (int i = 1; i <= N; i++) {
          for (int j = 0; j < 500; j++) {

             // 1. i번째 카드를 선택하지 않는 경우
             if (dp[i - 1][j] != -1) {
                dp[i][j] = Math.max(dp[i][j], dp[i - 1][j]);
             }

             // 2. i번째 카드를 선택하는 경우
             if (arr[i] >= 500 && arr[i] < 20000) {

                int refund = arr[i] - 500; // 실제 환불 금액
                int now = refund % 500; // 환불 금액의 나머지
                int prev = (j - now + 500) % 500; // 이전에 필요한 나머지

                if (dp[i - 1][prev] != -1) {
                   dp[i][j] = Math.max(dp[i][j], dp[i - 1][prev] + refund);
                }
             }
          }
       }

       System.out.println(dp[N][0] == -1 ? 0 : dp[N][0]);
    }
}