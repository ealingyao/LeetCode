/**
 * Created by Ealing on 4/2/18.
 */
public class keyBoardandChoose {
    private static char[][] buildKeyBoard(int n) {
        char[][] board = new char[26/n+1][n];
        char ch = 'a';
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (ch <= 'z') {
                    board[i][j] = ch;
                    ch++;
                } else {
                    return board;
                }
            }
        }
        return board;
    }

    private static String createPath(char[][] board, String s) {
        int[] pos = {0,0};
        StringBuilder sb = new StringBuilder();
        int n = board[0].length;
        for (char c: s.toCharArray()) {
            int row = (c-'a')/n;
            int col = (c-'a')%n;

            while (pos[0] < row) {
                sb.append('D');
                pos[0]++;
            }

            while (pos[0] > row) {
                sb.append('U');
                pos[0]--;
            }

            while (pos[1] < col) {
                sb.append('R');
                pos[1]++;
            }

            while (pos[1] > col) {
                sb.append('L');
                pos[1]--;
            }

            if (pos[0] == row && pos[1] == col) {
                sb.append('*');
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        char[][] board = buildKeyBoard(5);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j]);
            }
            System.out.print("\n");
        }
        System.out.print(createPath(board, "big"));
    }
}
