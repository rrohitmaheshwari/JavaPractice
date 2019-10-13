package codingQuestions;

import java.util.HashSet;
import java.util.Set;

public class coloredLoop {
    public static void main(String[] args) {
        char[][] map = {
                {'A', 'A', 'A', 'A'},
                {'D', 'A', 'B', 'A'},
                {'D', 'A', 'A', 'A'}
        };

//        char[][] map = {
//                {'B', 'B', 'A', 'A'},
//                {'B', 'A', 'C', 'A'},
//                {'B', 'A', 'A', 'A'}
//        };
        solve(3, 4, map);

    }


    public static void solve(int n, int m, char map[][]) {


        for (int x = 0; x < n; x++) {
            for (int y = 0; y < m; y++) {
                boolean visited[][] = new boolean[n][m];
                DFS(map, x, y, n, m, x, y, visited, x, y, map[x][y]);
            }
        }
        System.out.println("No");

    }

    public static void DFS(char[][] grid, int x, int y, int n, int m, int ex, int ey, boolean visited[][], int p1, int p2, char t) {


        if (x >= n || y >= m || x < 0 || y < 0 || grid[x][y] != t) {
            return;
        }


        if (x == ex && y == ey && visited[x][y]) {
            System.out.println("Yes");
            System.exit(0);
        }

        if (visited[x][y]) {
            return;
        }


        visited[x][y] = true;
        if (!(x + 1 == p1 && y == p2))
            DFS(grid, x + 1, y, n, m, ex, ey, visited, x, y, t);
        if (!(x == p1 && y + 1 == p2))
            DFS(grid, x, y + 1, n, m, ex, ey, visited, x, y, t);
        if (!(x - 1 == p1 && y == p2))
            DFS(grid, x - 1, y, n, m, ex, ey, visited, x, y, t);
        if (!(x == p1 && y - 1 == p2))
            DFS(grid, x, y - 1, n, m, ex, ey, visited, x, y, t);
    }
}
