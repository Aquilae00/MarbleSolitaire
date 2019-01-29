package cs3500.marblesolitaire.model.hw02;

import java.util.Arrays;

/**
 * Class implementation of MarbleSolitaireModel
 */
public final class MarbleSolitaireModelImpl implements MarbleSolitaireModel {
    private int[][] board_state;
    private int arm, srow, scol;
    private static final int DEFAULT_ARM = 3;
    private static final int DEFAULT_SROW = 3;
    private static final int DEFAULT_SCOL = 6;

    public MarbleSolitaireModelImpl() {
        this.arm = DEFAULT_ARM;
        this.srow = DEFAULT_SROW;
        this.scol = DEFAULT_SCOL;
        this.board_state = initBoard();
        this.getGameState();
    }

    public MarbleSolitaireModelImpl(int sRow, int sCol) {
        this.arm = DEFAULT_ARM;
        int h_gap = this.arm - 1;
        int front_gap = h_gap * 2;
        int width = front_gap * 2 + h_gap + this.arm;

        int v_gap = this.arm - 1;
        int height = v_gap * 2 + this.arm;

        if (sRow >= height
                || sCol < front_gap && sRow < v_gap
                || sCol < front_gap && sRow >= height - v_gap
                || sCol >= width - front_gap && sRow < v_gap
                || sCol >= width - front_gap && sRow >= height - v_gap) {
            throw new IllegalArgumentException(String.format("Invalid empty cell position (%s,%s)", sRow, sCol));
        }
        this.srow = sRow;
        this.scol = sCol;
        this.board_state = initBoard();
        this.getGameState();
    }

    public MarbleSolitaireModelImpl(int thicc) {
        if (thicc % 2 == 0) {
            throw new IllegalArgumentException("Enter Odd Arm Thickness");
        }
        this.arm = thicc;
        this.srow = this.arm - 1 + this.arm / 2;
        this.scol = (this.arm - 1) * 2 + (this.arm - 1) / 2 + this.arm / 2;
        this.board_state = initBoard();
        this.getGameState();
    }

    public MarbleSolitaireModelImpl(int thicc, int row, int col) {
        this.arm = thicc;
        int h_gap = this.arm - 1;
        int front_gap = h_gap * 2;
        int width = front_gap * 2 + h_gap + this.arm;

        int v_gap = this.arm - 1;
        int height = v_gap * 2 + this.arm;

        if (row >= height
                || col < front_gap && row < v_gap
                || col < front_gap && row >= height - v_gap
                || col >= width - front_gap && row < v_gap
                || col >= width - front_gap && row >= height - v_gap
                || thicc % 2 == 0) {
            throw new IllegalArgumentException(String.format("Invalid empty cell position (%s,%s)", row, col));
        }
        this.srow = row;
        this.scol = col;
        this.board_state = initBoard();
        this.getGameState();
    }

    @Override
    public void move(int fromRow, int fromCol, int toRow, int toCol) throws IllegalArgumentException {
        int h_gap = this.arm - 1;
        int front_gap = h_gap * 2;
        int width = front_gap * 2 + h_gap + this.arm;

        int v_gap = this.arm - 1;
        int height = v_gap * 2 + this.arm;
        int jumped_over_v = Math.abs(toCol - fromCol);
        int jumped_over_h = Math.abs(toRow - fromRow);

        if (toRow >= height
                || toCol < front_gap && toRow < v_gap
                || toCol < front_gap && toRow >= height - v_gap
                || toCol >= width - front_gap && toRow < v_gap
                || toCol >= width - front_gap && toRow >= height - v_gap
                || Math.abs(toRow - fromRow) == 1 && Math.abs(toCol - fromCol) == 1
                || this.board_state[toRow][toCol] != 2) {
            throw new IllegalArgumentException(String.format("Invalid empty cell position (%s,%s)", toRow, toCol));
        }

        /**
         * !!!IMPORTANT!!!
         * Prove this !
         * !Jump_over
         */
        if(this.board_state[fromRow][fromCol] == 1
        && Math.abs(toRow - fromRow) == 2
        && Math.abs(toCol - fromCol) == 4
        && this.board_state[toRow][toCol] == 2
        && this.board_state[jumped_over_v][jumped_over_h] == 1
        && this.board_state[fromRow][fromCol + 2] == 1)
        this.board_state[fromRow][fromCol] = 0;
    }

    @Override
    public boolean isGameOver() {
        return false;
    }

    /**
     * Initialize the board in the form of int arrays.
     * <table>
     * <thead>
     * <td>Number</td>
     * <td>String</td>
     * </thead>
     * <tr><td>0</td><td>Represents " "</td></tr>
     * <tr><td>1</td><td>Represents "O"</td></tr>
     * <tr><td>2</td><td>Represents "_"</td></tr>
     * <tr><td>3</td><td>Represents "" (Nothing)</td></tr>
     * </table>
     *
     * @return the board in form of int arrays
     */
    public int[][] initBoard() {
        int h_gap = this.arm - 1;
        int front_gap = h_gap * 2;
        int width = front_gap * 2 + h_gap + this.arm;
        int last_slot = width - front_gap;

        int v_gap = this.arm - 1;
        int height = v_gap * 2 + this.arm;
        int[][] board = new int[height][width];

        for (int x = 0; x < width; ++x) {
            for (int y = 0; y < height; ++y) {
                if (y < v_gap || y >= height - v_gap) {
                    if ((x >= front_gap) && (x % 2 == 0) && x < last_slot) {
                        board[y][x] = 1;
                    } else if ((x >= front_gap) && !(x % 2 == 0) && x < last_slot) {
                        board[y][x] = 0;
                    } else if (x >= last_slot) {
                        board[y][x] = 3;
                    }
                } else {
                    if (x % 2 == 0) {
                        board[y][x] = 1;
                    } else {
                        board[y][x] = 0;
                    }
                }
            }
        }
        board[this.srow][this.scol] = 2;
        return board;
    }

    @Override
    public String getGameState() {
        StringBuilder string_board = new StringBuilder();
        for (int[] iArray : this.board_state) {
            for (int i : iArray) {
                switch (i) {
                    case 0:
                        string_board.append(" ");
                        break;
                    case 1:
                        string_board.append("O");
                        break;
                    case 2:
                        string_board.append("_");
                        break;

                }
            }
            string_board.append("\n");
        }
        return string_board.toString();
    }

    @Override
    public int getScore() {
        return 0;
    }
}
