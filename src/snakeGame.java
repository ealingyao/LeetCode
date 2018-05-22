import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Ealing on 4/9/18.
 */
public class snakeGame {
    public static int minDiceThrows(int[] moves, int N) {
        boolean[] visited = new boolean[N];
        Queue<Node> queue = new LinkedList<>();
        int minThrow = N;

        queue.add(new Node(0, 0));
        visited[0] = true;

        while (!queue.isEmpty()) {
            Node cur = queue.remove();

            if (cur.index == N-1) {
                minThrow = cur.dis;
                break;
            }

            for (int j = cur.index+1; (j <= cur.index+6 && j < N); j++) {
                if (!visited[j]) {
                    visited[j] = true;

                    int newDis = cur.dis+1;
                    int newIndex = (moves[j] == -1)? j:moves[j];

                    queue.add(new Node(newIndex, newDis));
                }
            }
        }

        return minThrow;
    }
//    public static int minDiceThrows(int[] moves, int N) {
//        boolean[] visited = new boolean[N];
//        Queue<Node> queue = new LinkedList<>();
//        int minDis = N;
//
//        visited[0] = true;
//        queue.offer(new Node(0, 0));
//
//        while (!queue.isEmpty()) {
//            Node cur = queue.remove();
//
//            if (cur.index == N-1) {
//                minDis = cur.dis;
//                break;
//            }
//
//            for (int j = cur.index+1; (j <= cur.index+6) && (j < N); j++) {
//                if (!visited[j]) {
//                    visited[j] = true;
//                    int newDis = cur.dis+1;
//                    int newIndex = (moves[j] != -1)? moves[j]:j;
//
//                    queue.add(new Node(newIndex, newDis));
//                }
//            }
//        }
//
//        return minDis;
//    }

    static class Node {
        int index;
        int dis;
        public Node (int index, int dis) {
            this.index = index;
            this.dis = dis;
        }
    }

    public static void main(String[] args) {
        int[] moves = new int[30];
        Arrays.fill(moves, -1);

        // Ladders
        moves[2] = 21;
        moves[4] = 7;
        moves[10] = 25;
        moves[19] = 28;

        // Snakes
        moves[26] = 0;
        moves[20] = 8;
        moves[16] = 3;
        moves[18] = 6;

        System.out.print(minDiceThrows(moves, 30));
    }
}
