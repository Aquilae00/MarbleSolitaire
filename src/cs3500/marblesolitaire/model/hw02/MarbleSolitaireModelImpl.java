package cs3500.marblesolitaire.model.hw02;

import java.util.Arrays;

/**
 * Class implementation of MarbleSolitaireModel
 */
public final class MarbleSolitaireModelImpl implements MarbleSolitaireModel {

  private final int DEFAULT_ARM = 3;

  public MarbleSolitaireModelImpl() {
    this.getGameState();
  }

  public MarbleSolitaireModelImpl(int sRow, int sCol) {

  }

  public MarbleSolitaireModelImpl(int thicc) {

  }

  public MarbleSolitaireModelImpl(int thicc, int row, int col) {

  }
  @Override
  public void move(int fromRow, int fromCol, int toRow, int toCol) throws IllegalArgumentException {

  }

  @Override
  public boolean isGameOver() {
    return false;
  }

  /**
   * Initialize the board in the form of int arrays.
   * <table>
   *   <thead>
   *     <td>Number</td>
   *     <td>String</td>
   *   </thead>
   *   <tr><td>0</td><td>Represents " "</td></tr>
   *   <tr><td>1</td><td>Represents "O"</td></tr>
   *   <tr><td>2</td><td>Represents "_"</td></tr>
   *   <tr><td>3</td><td>Represents "" (Nothing)</td></tr>
   * </table>
   *
   * @return the board in form of int arrays
   */
  public int[][] initBoard() {
    int h_gap = DEFAULT_ARM - 1;
    int front_gap = h_gap * 2;
    int width = front_gap * 2 + h_gap + DEFAULT_ARM;
    int last_slot = width - front_gap;

    int v_gap = DEFAULT_ARM - 1;
    int height = v_gap * 2 + DEFAULT_ARM;
    int[][] board = new int[height][width];

    for (int x = 0; x < width ; ++x) {
      for (int y = 0; y < height; ++y) {
        if (y < v_gap || y >= height - v_gap) {
          if ((x >= front_gap) && (x % 2 == 0) && x < last_slot) {
            board[y][x] = 1;
          }
          else if((x >= front_gap) && !(x % 2 == 0) && x < last_slot) {
            board[y][x] = 0;
          }
          else if (x >= last_slot) {
            board[y][x] = 3;
          }
        }
         else  {
           if (x % 2 == 0) {
             board[y][x] = 1;
           }
           else {
             board[y][x] = 0;
           }
        }
      }
    }
    return board;
  }

  @Override
  public String getGameState() {
    int[][] init_board = this.initBoard();
    StringBuilder string_board = new StringBuilder();
    for (int[] iArray : init_board) {
      for (int i : iArray) {
        switch(i) {
          case 0 :
            string_board.append(" ");
            break;
          case 1 :
            string_board.append("O");
            break;
          case 2 :
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
