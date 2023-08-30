package other.torq_codility_interview;

public class MatrixChallenge {
    public static void main(String[] args) {
        String[] strArr = {
                "(1,2,3,4,5,6,7,8,1)",
                "(x,x,x,x,x,x,x,x,x)",
                "(X,X,X,X,X,X,X,X,X)",
                "(1,x,x,x,x,x,x,x,x)",
                "(X,X,X,X,X,X,X,X,X)",
                "(x,x,x,x,x,x,x,x,x)",
                "(X,X,X,X,X,X,X,X,X)",
                "(x,x,X,X,X,X,X,X,X)",
                "(X,X,X,X,X,X,X,X,X)"
        };

        String result = validateSudokuBoard(strArr);
        System.out.println(result);
    }

    public static String validateSudokuBoard(String[] strArr) {
        int[][] board = parseInput(strArr);

        if (isValidSudoku(board)) {
            return "legal";
        } else {
            return findErrorQuadrants(board);
        }
    }

    // Helper method to parse the input and create a 2D Sudoku board
    private static int[][] parseInput(String[] strArr) {
        int[][] board = new int[9][9];

        for (int i = 0; i < 9; i++) {
            String row = strArr[i].replaceAll("[\\s()]", "");
            row = row.replace(",", "");
            for (int j = 0; j < 9; j++) {
                char c = row.charAt(j);
                if (c == 'X' || c == 'x') {
                    board[i][j] = 0; // Represent empty cells as 0
                } else {
                    board[i][j] = Character.getNumericValue(c);
                }
            }
        }
        return board;
    }

    // Helper method to check if a Sudoku board is valid
    private static boolean isValidSudoku(int[][] board) {
        // Check rows and columns
        for (int i = 0; i < 9; i++) {
            boolean[] rowCheck = new boolean[10];
            boolean[] colCheck = new boolean[10];
            for (int j = 0; j < 9; j++) {
                int rowVal = board[i][j];
                int colVal = board[j][i];

                if (rowVal != 0 && rowCheck[rowVal]) return false;
                if (colVal != 0 && colCheck[colVal]) return false;

                rowCheck[rowVal] = true;
                colCheck[colVal] = true;
            }
        }

        // Check 3x3 sub-grids
        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                boolean[] subGridCheck = new boolean[10];
                for (int k = i; k < i + 3; k++) {
                    for (int l = j; l < j + 3; l++) {
                        int val = board[k][l];
                        if (val != 0 && subGridCheck[val]) return false;
                        subGridCheck[val] = true;
                    }
                }
            }
        }

        return true;
    }

    // Helper method to find error quadrants
    private static String findErrorQuadrants(int[][] board) {
        StringBuilder errors = new StringBuilder();

        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                boolean[] subGridCheck = new boolean[10];
                for (int k = i; k < i + 3; k++) {
                    for (int l = j; l < j + 3; l++) {
                        int val = board[k][l];
                        if (val != 0 && subGridCheck[val]) {
                            if (errors.length() > 0) {
                                errors.append(",");
                            }
                            int quadrant = (i / 3) * 3 + (j / 3) + 1;
                            errors.append(quadrant);
                            break; // Only add each quadrant once
                        }
                        subGridCheck[val] = true;
                    }
                }
            }
        }

        return errors.toString();
    }
}

