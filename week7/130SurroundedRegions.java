public class Solution {
    public void solve(char[][] board) {
        Queue keep = new LinkedList<Pair>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (i == 0 || i == board.length - 1 || j == 0 || j == board[0].length - 1) {
                    if (board[i][j] == 'O') {
                        keep.offer(new Pair(i, j));
                    }
                }
            }
        }
        int[] directionX = {1, -1, 0, 0};
        int[] directionY = {0, 0, 1, -1};
        while (!keep.isEmpty()) {
            Pair cur = (Pair)keep.poll();
            int x = cur.x;
            int y = cur.y;
            board[x][y] = 'K';
            for (int i = 0; i < 4; i++) {
                int xx = x + directionX[i];
                int yy = y + directionY[i];
                if (xx >= 0 && xx < board.length && yy >=0 && yy < board[0].length) {
                    if (board[xx][yy] == 'O') {
                        keep.offer(new Pair(xx, yy));
                    }
                }
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                switch(board[i][j]) {
                    case 'K':
                        board[i][j] = 'O';
                        break;
                    case 'O':
                        board[i][j] = 'X';
                }
                
            }
        }
    }
    class Pair {
        int x;
        int y;
        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}