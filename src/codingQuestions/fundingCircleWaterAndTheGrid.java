package codingQuestions;

import java.io.*;
import java.util.PriorityQueue;

public class fundingCircleWaterAndTheGrid {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] nk = br.readLine().split(" ");

        int M = Integer.parseInt(nk[0]);

        int N = Integer.parseInt(nk[1]);

        int[][] input = new int[M][N];

        for (int i = 0; i < M; i++) {

            String in = br.readLine();
            for (int j = 0; j < N; j++) {
                if (in.charAt(j) == '.') {
                    input[i][j] = 0;
                } else {
                    input[i][j] = 1;
                }
            }

        }

        int res = 0;
        for (int i = 0; i < M; i++) {
            dfs(input, i, 0);
            dfs(input, i, N - 1);
        }

        for (int j = 0; j < N; j++) {
            dfs(input, 0, j);
            dfs(input, M - 1, j);
        }

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (input[i][j] == 0) {
                    res++;
                }
            }
        }

        System.out.println(res);

    }


    public static void dfs(int[][] a, int i, int j) {
        int m = a.length;
        int n = a[0].length;

        if (i < 0 || i >= m || j < 0 || j >= n || a[i][j] != 0)
            return;

        a[i][j] = 1;

        dfs(a, i - 1, j);
        dfs(a, i + 1, j);
        dfs(a, i, j - 1);
        dfs(a, i, j + 1);
    }


}
