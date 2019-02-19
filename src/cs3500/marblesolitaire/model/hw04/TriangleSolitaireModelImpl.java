package cs3500.marblesolitaire.model.hw04;

import cs3500.marblesolitaire.model.hw02.Coding;

public class TriangleSolitaireModelImpl extends  AbstractSolitaireModel{
  public TriangleSolitaireModelImpl(){
    this(5,0,0);
  }

  public TriangleSolitaireModelImpl(int armLength) {
    this(armLength,0,0);
  }

  public TriangleSolitaireModelImpl(int row,int col) {
    this(5,row,col);
  }

  public TriangleSolitaireModelImpl(int armLength, int row, int col) {
    if (armLength < 0
            || armLength % 2 == 0
            || row < 0
            || col < 0) {
      throw new IllegalArgumentException("Invalid Input");
    }

    this.arm = armLength;
    front_gap = this.arm - 1;
    width = this.arm;
    last_slot = width - front_gap;
    variant = 0;
    invariant = this.arm;

    v_gap = this.arm - 1;
    height = this.arm;
    this.srow = row;
    this.scol = col;
    this.board_state = initBoard();
  }

  @Override
  protected Coding[][] initBoard() {
    Coding[][] board = new Coding[height][width];
    for (int y = 0; y < height; ++y) {
      for (int x = 0; x < width; ++x) {
        if (x < last_slot + (variant % invariant) ) {
          board[y][x] = Coding.Marbles;
        } else if (x >= last_slot) {
          board[y][x] = Coding.OutofBound;
        }
      }
      variant++;
    }
    board[this.srow][this.scol] = Coding.Empty;
    return board;
  }

  @Override
  public String getGameState() {
    StringBuilder string_board = new StringBuilder();
    int num1;
    int num2 = width - last_slot + (variant % invariant) + 2;
    for (int x = 0; x < width; ++x) {
      num1 = num2;
      for (int y = 0; y < height; ++y) {

        switch (this.board_state[x][y]) {
          case Invalid:
            string_board.append("  ");
            break;
          case Marbles:

              while(num1 != 0) {
                string_board.append(" ");
                num1--;
              }
            if (y < width - 1 && (this.board_state[x][y + 1] == Coding.Marbles
                    || this.board_state[x][y + 1] == Coding.Empty)) {
              string_board.append("O ");
            }
            else {
              string_board.append("O");
            }
            break;
          case Empty:
            while(num1 != 0) {
              string_board.append(" ");
              num1--;
            }
            if (y < width - 1 && (this.board_state[x][y + 1] == Coding.Marbles
                    || this.board_state[x][y + 1] == Coding.Empty)) {
              string_board.append("_ ");
            }
            else {
              string_board.append("_");
            }
            break;
          default:
        }
      }
      num2--;
      if (x < height - 1) {
        string_board.append("\n");
      }
    }
    return string_board.toString();
  }

  protected boolean isInvalidMove(int fromRow, int fromCol, int toRow, int toCol) {
    return toRow < 0
            || toCol < 0
            || fromCol < 0
            || fromRow < 0
            || toRow > height - 1
            || toCol > width - 1
            || fromCol > width - 1
            || fromRow > height - 1
            || Math.abs(toRow - fromRow) == 1 && Math.abs(toCol - fromCol) == 1
            || this.board_state[toRow][toCol] != Coding.Empty
            || this.board_state[fromRow][fromCol] != Coding.Marbles
            || Math.abs(toRow - fromRow) != 2 && Math.abs(toRow - fromRow) != 0
            || Math.abs(toCol - fromCol) != 2 && Math.abs(toCol - fromCol) != 0;
  }

  @Override
  public void move(int fromRow, int fromCol, int toRow, int toCol) throws IllegalArgumentException {
    int jumped_over_v = (toCol + fromCol) / 2;
    int jumped_over_h = (toRow + fromRow) / 2;

    if (isInvalidMove(fromRow, fromCol, toRow, toCol)) {
      throw new IllegalArgumentException(String.format("Invalid empty cell position (%s,%s)",
              toRow, toCol));
    }

    if (this.board_state[fromRow][fromCol] == Coding.Marbles
            && Math.abs(toRow - fromRow) <= 2
            && Math.abs(toCol - fromCol) <= 2
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
    boolean condition = true;
    for (int x = 0; x < width; x++) {
      for (int y = 0; y < height; y++) {
        if (board_state[x][y] == Coding.Marbles) {
          condition = condition && !(x < last_slot
                  && board_state[x + 2][y] == Coding.Empty
                  && board_state[x + 1][y] == Coding.Marbles);
          condition = condition && !(x > 1
                  && board_state[x - 2][y] == Coding.Empty
                  && board_state[x - 1][y] == Coding.Marbles);
          condition = condition && !(y < last_slot
                  && board_state[x][y + 2] == Coding.Empty
                  && board_state[x][y + 1] == Coding.Marbles);
          condition = condition && !(y > 1
                  && board_state[x][y - 2] == Coding.Empty
                  && board_state[x][y - 1] == Coding.Marbles);
          condition = condition && !(y > 1
                  && board_state[x - 2][y - 2] == Coding.Empty
                  && board_state[x - 1][y - 1] == Coding.Marbles);
          condition = condition && !(y < last_slot
                  && board_state[x + 2][y + 2] == Coding.Empty
                  && board_state[x + 1][y + 1] == Coding.Marbles);
        }
      }
    }
    return condition;
  }
}