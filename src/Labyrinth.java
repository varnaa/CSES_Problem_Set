//import java.util.*;
//import java.io.*;
//
//public class Labyrinth {
//
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//
//    }
//
//        public static String findPath(int sr, int sc, int dr, int dc, char[][] grid){
//            Deque<int[]> queue = new ArrayDeque<>();
//            boolean[][] visited = new boolean[rowLength][colLength];
//            int[][] directions = {{0,1}, {1,0}, {-1,0}, {0,-1}};
//            queue.offer(new int[] {sr, sc, 0});
//            visited[sr][sc] = true;
//
//            while(!queue.isEmpty()){
//                int currentSize = queue.size();
//                for(int i=0; i<currentSize; i++){
//                    int[] current  = queue.poll();
//
//                    if(current[0] == dr && current[1] == dc){
//                        System.out.println("YES");
//                        System.out.println("");
//                    }
//                }
//            }
//}
