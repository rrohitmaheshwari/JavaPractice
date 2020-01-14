package codingQuestions;

import java.util.*;

public class spreadFill {

    public static void main(String[] args) {
        Integer[][] grid = {{0, 1, 1, 0, 1}, {0, 1, 0, 1, 0}, {0, 0, 0, 0, 1}, {0, 1, 0, 0, 0}};
        System.out.println(minimumHours(grid.length, grid[0].length, twoDArrayToList(grid)));


    }

    public static List<List<Integer>> twoDArrayToList(Integer[][] twoDArray) {
        List<List<Integer>> list = new ArrayList<>();
        for (Integer[] array : twoDArray) {
            List<Integer> temp = new ArrayList<>();
            temp.addAll(Arrays.asList(array));
            list.add(temp);
        }
        return list;
    }

    static int minimumHours(int rows, int collumn, List<List<Integer>> grid) {
        Queue<int[]> queueOfOnes = new LinkedList<>();
        int target = rows * collumn;
        int cnt = 0, res = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < collumn; j++) {
                if (grid.get(i).get(j) == 1) {
                    queueOfOnes.offer(new int[]{i, j});
                    cnt++;
                }
            }
        }
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        while (!queueOfOnes.isEmpty()) {
            int size = queueOfOnes.size();
            if (cnt == target)
                return res;
            for (int i = 0; i < size; i++) {
                int[] cur = queueOfOnes.poll();
                for (int[] dirObj : directions) {
                    int ni = cur[0] + dirObj[0];
                    int nj = cur[1] + dirObj[1];
                    if (ni >= 0 && ni < rows && nj >= 0 && nj < collumn && grid.get(ni).get(nj) == 0) {
                        cnt++;
                        queueOfOnes.offer(new int[]{ni, nj});

                        grid.get(ni).set(nj, 1);
                    }
                }
            }
            res++;
        }
        return -1;
    }
}
