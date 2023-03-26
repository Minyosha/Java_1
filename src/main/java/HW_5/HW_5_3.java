//На шахматной доске расставить 8 ферзей так, чтобы они не били друг друга.

package HW_5;

public class HW_5_3 {
    public static void main(String[] args) {
        int[] queens = new int[8];
        findPosition(0, queens);


        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                if (queens[row] == col) {
                    System.out.print("X");
                    System.out.print(" ");
                    System.out.print(" ");
                } else {
                    System.out.print("o");
                    System.out.print(" ");
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }


    private static boolean findPosition(int row, int[] queens) {
        if (row == 8) {
            return true;
        }
        for (int col = 0; col < 8; col++) {
            boolean isSafe = true;
            for (int i = 0; i < row; i++) {
                if (queens[i] == col || queens[i] == col - row + i || queens[i] == col + row - i) {
                    isSafe = false;
                    break;
                }
            }
            if (isSafe) {
                queens[row] = col;
                if (findPosition(row + 1, queens)) {
                    return true;
                }
            }
        }
        return false;
    }
}
