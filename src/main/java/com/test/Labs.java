package com.test;

import java.util.*;

public class Labs {
    public static void main(String[] args) {
//        int[][] adjacencyMatrix = {
//                {0, 1, 1, 0, 0, 1, 0, 0, 0}, // A
//                {1, 0, 0, 0, 0, 1, 0, 0, 0}, // B
//                {1, 0, 0, 0, 0, 1, 1, 0, 0}, // C
//                {0, 0, 0, 0, 1, 0, 0, 0, 1}, // D
//                {0, 0, 0, 1, 0, 0, 0, 0, 1}, // E
//                {1, 1, 0, 0, 0, 0, 0, 1, 0}, // F
//                {0, 0, 1, 0, 0, 0, 0, 1, 0}, // G
//                {0, 0, 1, 0, 0, 1, 1, 0, 0}, // H
//                {0, 0, 0, 1, 1, 0, 0, 0, 0}  // I
//        };
//
//        int[][] adjacencyMatrix2 = {
//                {0, 1, 1, 0, 0, 0, 0, 0, 0, 0}, // A
//                {1, 0, 1, 0, 0, 0, 0, 0, 0, 0}, // B
//                {1, 1, 0, 0, 0, 0, 0, 0, 0, 0}, // C
//                {0, 0, 0, 0, 1, 1, 0, 0, 0, 0}, // D
//                {0, 0, 0, 1, 0, 1, 0, 0, 0, 0}, // E
//                {0, 0, 0, 1, 1, 0, 0, 0, 0, 0}, // F
//                {0, 0, 0, 0, 0, 0, 0, 1, 1, 0}, // G
//                {0, 0, 0, 0, 0, 0, 1, 0, 1, 0}, // H
//                {0, 0, 0, 0, 0, 0, 1, 1, 0, 0}, // I
//                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}  // J
//        };
//
//        Map<Integer, List<Integer>> res = componentListBFS(adjacencyMatrix);
//        for (Map.Entry<Integer, List<Integer>> entry : res.entrySet()) {
//            System.out.println(entry.getKey() + " -> " + entry.getValue());
//        }

        List<Integer> list = Arrays.asList(3, 5, 4, 1, 2, 5, 3, 4, 3, 2, 1, 1, 2, 4, 2, 3, 4, 5, 3, 1,
                2, 5, 4, 5, 4, 1, 1, 5, 3, 1, 4, 5, 2, 3, 2, 5, 2, 5, 2, 2,
                1, 5, 3, 2, 5, 1, 2, 4, 3, 1, 5, 1, 3, 3, 5);

        System.out.println(birthday(list, 18, 6));
    }

    public static int birthday(List<Integer> s, int d, int m) {
        int sum = 0;
        for(int i=0; i< m; i++) {
            sum += s.get(i);
        }
        int counter = 0;
        if(sum == d) {
            counter++;
        }
        for(int i = 1; i<s.size() - m + 1 ; i++) {
            sum -= s.get(i-1);
            sum += s.get(i+m-1);
            if(sum == d) {
                counter++;
            }
        }
        return counter;
    }

    public static Map<Integer, List<Integer>> componentListBFS(int[][] matrix) {
        Map<Integer, List<Integer>> result = new HashMap<>();
        int component = 0;
        int[] visited = new int[matrix.length];

        for (int start = 0; start < matrix.length; start++) {
            if (visited[start] == 0) {
                component++;
                Queue<Integer> queue = new LinkedList<>();
                queue.add(start);
                visited[start] = component;
                while (!queue.isEmpty()) {
                    int visiting = queue.poll();
                    for (int i = 0; i < matrix.length; i++) {
                        if (matrix[visiting][i] == 1 && visited[i] == 0) {
                            queue.add(i);
                            visited[i] = component;
                        }
                    }
                }
            }
        }
        for (int i = 1; i <= component; i++) {
            result.put(i, new ArrayList<>());
        }
        for (int i = 0; i < visited.length; i++) {
            result.get(visited[i]).add(i);
        }
        return result;
    }
}
