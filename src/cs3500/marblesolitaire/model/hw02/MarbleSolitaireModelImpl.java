package cs3500.marblesolitaire.model.hw02;

import java.util.Arrays;

/**
 * Class implementation of MarbleSolitaireModel
 */
public final class MarbleSolitaireModelImpl implements MarbleSolitaireModel {
  private Coding[][] board_state;
  private int arm, srow, scol;
  private int front_gap = this.arm - 1;
  private int width = front_gap * 2 + this.arm + 2;
  private int last_slot = width - front_gap;

  private int v_gap = this.arm - 1;
  private int height = v_gap * 2 + this.arm + 2;
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
    this.scol = DEFAULT_SCOL;
    this.srow = DEFAULT_SROW;
    this.board_state = initBoard();
    if (sRow >= height
            || sCol < front_gap && sRow < v_gap
            || sCol < front_gap && sRow >= height - v_gap
            || sCol >= width - front_gap && sRow < v_gap
            || sCol >= width - front_gap && sRow >= height - v_gap
            || this.board_state[sRow][sCol] == Coding.Invalid) {
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
    this.scol = DEFAULT_SCOL;
    this.srow = DEFAULT_SROW;
    this.board_state = initBoard();

    if (row >= this.height
            || col < front_gap && row < v_gap
            || col < front_gap && row >= height - v_gap
            || col >= width - front_gap && row < v_gap
            || col >= width - front_gap && row >= height - v_gap
            || thicc % 2 == 0
            || this.board_state[row][col] == Coding.Invalid) {
      throw new IllegalArgumentException(String.format("Invalid empty cell position (%s,%s)", row, col));
    }
    this.srow = row;
    this.scol = col;
    this.board_state = initBoard();
    this.getGameState();
  }

  @Override
  public void move(int fromRow, int fromCol, int toRow, int toCol) throws IllegalArgumentException {
    int jumped_over_v = (toCol + fromCol) / 2;
    int jumped_over_h = (toRow + fromRow) / 2;

    if (toRow >= height
            || toCol < front_gap && toRow < v_gap
            || toCol < front_gap && toRow >= height - v_gap
            || toCol >= width - front_gap && toRow < v_gap
            || toCol >= width - front_gap && toRow >= height - v_gap
            || Math.abs(toRow - fromRow) == 1 && Math.abs(toCol - fromCol) == 1
            || this.board_state[toRow][toCol] != Coding.Empty
            || Math.abs(toRow - fromRow) != 2 && Math.abs(toRow - fromRow) != 0
            || Math.abs(toCol - fromCol) != 4 && Math.abs(toCol - fromCol) != 0 ) {
      throw new IllegalArgumentException(String.format("Invalid empty cell position (%s,%s)", toRow, toCol));
    }
    /**
     * !!!IMPORTANT!!!
     * Prove this !
     * !Jump_over
     */
    if (this.board_state[fromRow][fromCol] == Coding.Marbles
            && Math.abs(toRow - fromRow) <= 2
            && Math.abs(toCol - fromCol) <= 4
            && this.board_state[toRow][toCol] == Coding.Empty) {
      if (toRow == fromRow) {
        this.board_state[toRow][jumped_over_v] = Coding.Empty;
      }
      if (toCol == fromCol) {
        this.board_state[jumped_over_h][toCol] = Coding.Empty;
      }
      this.board_state[fromRow][fromCol] = Coding.Empty;
      this.board_state[toRow][toCol] = Coding.Marbles;
    }
  }

  @Override
  public boolean isGameOver() {
    return false;
  }

//  @Override
//  public boolean isGameOver() {
//    for (int[] iArray : this.board_state) {
//      for (int i : iArray) {
//        int i
//        if (this.board_state[fromRow][fromCol] == 1
//                && Math.abs(toRow - fromRow) <= 2
//                && Math.abs(toCol - fromCol) <= 4
//                && this.board_state[toRow][toCol] == 2) {
//          if (toRow == fromRow) {
//            this.board_state[toRow][jumped_over_v] = 2;
//          }
//          if (toCol == fromCol) {
//            this.board_state[jumped_over_h][toCol] = 2;
//          }
//          this.board_state[fromRow][fromCol] = 2;
//          this.board_state[toRow][toCol] = 1;
//        }
//
//        }
//      }
//    }
//  }

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
  public Coding[][] initBoard() {
    Coding[][] board = new Coding[7][7];

    for (int x = 0; x < width; ++x) {
      for (int y = 0; y < height; ++y) {
        if (y < v_gap || y >= height - v_gap) {
          if ((x >= front_gap)&& x < last_slot) {
            board[y][x] = Coding.Marbles;
          } else if (x < front_gap || x >= last_slot) {
            board[y][x] = Coding.Invalid;
          }
        } else {
          board[x][y] = Coding.Marbles;
        }
      }
    }
    board[this.srow][this.scol] = Coding.Empty;
    return board;
  }

  @Override
  public String getGameState() {
    StringBuilder string_board = new StringBuilder();
    for (Coding[] iArray : this.board_state) {
      for (Coding c : iArray) {
        switch (c) {
          case Invalid:
            string_board.append(" ");
            break;
          case Marbles:
            string_board.append("O");
            break;
          case Empty:
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
    int score = 0;
    for (Coding[] iArray : this.board_state) {
      for (Coding c : iArray) {
        if (c == Coding.Marbles) {
          score += 1;
        }
      }
    }
    return score;
  }
}
