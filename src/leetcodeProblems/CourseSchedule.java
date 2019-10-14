package leetcodeProblems;

import java.util.*;

//207. Course Schedule TOPOLOGICAL SORT/ DFS
public class CourseSchedule {

    public static void main(String[] args) {
        System.out.println(canFinish(2, new int[][]{{1, 0}}));
        System.out.println(canFinish(3, new int[][]{{1, 0}, {0, 2}, {2, 1}}));
    }

    public static boolean canFinish(int numCourses, int[][] prerequisites) {

        Map<Integer, List<Integer>> graph = new HashMap<>();

        for (int i = 0; i < numCourses; i++) {
            List<Integer> temp = new ArrayList<>();
            graph.put(i, temp);
        }

        for (int i = 0; i < prerequisites.length; i++) {
            List temp = graph.get(prerequisites[i][1]);
            temp.add(prerequisites[i][0]);
            graph.put(prerequisites[i][1], temp);
        }


        for (Map.Entry<Integer, List<Integer>> entry : graph.entrySet()) {
            Integer pNode = entry.getKey();
            List<Integer> temp = entry.getValue();
            boolean[] visited = new boolean[numCourses]; //default false
            if (temp.size() == 0) {
                continue;
            }

            if (checkCycle(pNode, pNode, visited, graph)) {
                return false;       //Cycle is present so Not Possible
            }
        }


        return true;            //Possible
    }

    public static boolean checkCycle(Integer pNode, Integer cnode, boolean[] visited, Map<Integer, List<Integer>> graph) {
        if (visited[pNode] == true && pNode == cnode) { //reached Starting Node
            return true;
        }

        if (visited[pNode]) {
            return false;
        }
        visited[pNode] = true;


        List<Integer> set = graph.get(pNode);

        boolean flag = false;
        for (Integer i : set) {

            flag = flag || checkCycle(i, cnode, visited, graph);

        }
        return flag;
    }

}

