package cs3500.marblesolitaire.model.hw02;

import java.util.ArrayList;

/**
 * Class implementation of MarbleSolitaireModel.
 */
public final class MarbleSolitaireModelImpl implements MarbleSolitaireModel {
  private Coding[][] board_state;
  private int arm;
  private int srow;
  private int scol;
  private int front_gap;
  private int width;
  private int last_slot;
  private int v_gap;
  private int height;
  private static final int DEFAULT_ARM = 3;
  private static final int DEFAULT_SROW = 3;
  private static final int DEFAULT_SCOL = 3;

  /**
   * Initialize values of front_gap, width, last_slot, v_gap, and height.
   */
  private void init() {
    front_gap = this.arm - 1;
    width = front_gap * 2 + this.arm;
    last_slot = width - front_gap;

    v_gap = this.arm - 1;
    height = v_gap * 2 + this.arm;
  }

  /**
   * Creation of a board with empty marbles.
   *
   * @param s string for constructing a zero board
   */
  public MarbleSolitaireModelImpl(String s) {
    if (s.equals("Zero")) {
      this.arm = DEFAULT_ARM;
      this.srow = DEFAULT_SROW;
      this.scol = DEFAULT_SCOL;
      this.init();
      this.board_state = initBoardEmpty();
    }
  }

  /**
   * Constructs a Marble Solitaire Model using default values.
   */
  public MarbleSolitaireModelImpl() {
    this(DEFAULT_ARM, DEFAULT_SROW, DEFAULT_SCOL);
  }

  /**
   * Constructs a Marble Solitaire Model and initialize the game board so that the arm thickness is
   * 3 and the empty slot is at the position (sRow, sCol).
   *
   * @param sRow the y axis of empty slot
   * @param sCol the x axis of empty slot
   * @throws IllegalArgumentException if position is invalid
   */
  public MarbleSolitaireModelImpl(int sRow, int sCol) {
    this(DEFAULT_ARM, sRow, sCol);
  }

  /**
   * Constructs a Marble Solitaire Model and initialize a game board with the empty slot at the
   * center.
   *
   * @param thicc the arm thickness
   * @throws IllegalArgumentException if the arm thickness is not a positive odd number
   */
  public MarbleSolitaireModelImpl(int thicc) {
    this(thicc, DEFAULT_SROW, DEFAULT_SCOL);
  }

  /**
   * Constructs a Marble Solitaire Model take in the arm thickness, row and column of the empty slot
   * in that order.
   *
   * @param thicc the arm thickness
   * @param row   the y axis of empty slot
   * @param col   the x axis of empty slot
   * @throws IllegalArgumentException if the arm thickness is not a positive odd number, or the
   *                                  empty cell position is invalid
   */
  public MarbleSolitaireModelImpl(int thicc, int row, int col) {
    if (thicc < 0
            || thicc % 2 == 0
            || row < 0
            || col < 0) {
      throw new IllegalArgumentException("Invalid Input");
    }

    this.arm = thicc;
    this.init();

    if (row == DEFAULT_SROW && col == DEFAULT_SCOL) {
      this.scol = this.arm + this.arm / 2 - 1;
      this.srow = this.arm - 1 + this.arm / 2;

    } else {
      this.srow = row;
      this.scol = col;

    }

    if (srow >= this.height
            || scol < front_gap && srow < v_gap
            || scol < front_gap && srow >= height - v_gap
            || scol >= width - front_gap && srow < v_gap
            || scol >= width - front_gap && srow >= height - v_gap) {
      throw new IllegalArgumentException(String.format("Invalid empty cell position (%s,%s)",
              srow, scol));
    }

    this.board_state = initBoard();
    this.getGameState();
  }

  private boolean isInvalidMove(int fromRow, int fromCol, int toRow, int toCol) {
    return toRow >= height
            || toRow < 0
            || toCol < 0
            || fromCol < 0
            || fromRow < 0
            || toRow > height - 1
            || toCol > width - 1
            || fromCol > width - 1
            || fromRow > height - 1
            || toCol < front_gap && toRow < v_gap
            || toCol < front_gap && toRow >= height - v_gap
            || toCol >= width - front_gap && toRow < v_gap
            || toCol >= width - front_gap && toRow >= height - v_gap
            || Math.abs(toRow - fromRow) == 1 && Math.abs(toCol - fromCol) == 1
            || this.board_state[toRow][toCol] != Coding.Empty
            || this.board_state[fromRow][fromCol] != Coding.Marbles
            || Math.abs(toRow - fromRow) != 2 && Math.abs(toRow - fromRow) != 0
            || Math.abs(toCol - fromCol) != 2 && Math.abs(toCol - fromCol) != 0;
  }

  private boolean isInvalidPos(int row, int col) {
    this.init();
    return col < front_gap && row < v_gap
            || col < front_gap && row >= height - v_gap
            || col >= width - front_gap && row < v_gap
            || col >= width - front_gap && row >= height - v_gap;
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

//  @Override
//  public boolean isGameOver() {
//    ArrayList<Integer> arr = new ArrayList<>();
//    for (int x = 0; x < width; ++x) {
//      for (int y = 0; y < height; ++y) {
//        if (this.board_state[x][y] == Coding.Marbles) {
//          if (x < v_gap || x >= height - v_gap) {
//            if (x != height - 1 && y != last_slot - 1) {
//              if (this.board_state[x + 1][y] == Coding.Invalid
//                      && this.board_state[x][y + 1] == Coding.Invalid) {
//                arr.add(1);
//              } else {
//                arr.add(0);
//              }
//            } else if (y == last_slot - 1 && x != height - 1) {
//              if (this.board_state[x + 1][y] == Coding.Invalid
//                      && this.board_state[x][y - 1] == Coding.Invalid) {
//                arr.add(1);
//              } else {
//                arr.add(0);
//              }
//            } else if (x == height - 1 && y != last_slot) {
//              if (this.board_state[x - 1][y] == Coding.Invalid
//                      && this.board_state[x][y + 1] == Coding.Invalid) {
//                arr.add(1);
//              } else {
//                arr.add(0);
//              }
//            } else {
//              if (this.board_state[x - 1][y] == Coding.Invalid
//                      && this.board_state[x][y - 1] == Coding.Invalid) {
//                arr.add(1);
//              } else {
//                arr.add(0);
//              }
//            }
//          } else {
//            if (y == 0 && y < front_gap && x == v_gap) {
//              if (this.board_state[x + 1][y] == Coding.Invalid
//                      && this.board_state[x][y + 1] == Coding.Invalid) {
//                arr.add(1);
//              } else {
//                arr.add(0);
//              }
//            } else if (y == 0 && y < front_gap && x > v_gap) {
//              if (this.board_state[x - 1][y] == Coding.Invalid
//                      && this.board_state[x][y + 1] == Coding.Invalid) {
//                arr.add(1);
//              } else {
//                arr.add(0);
//              }
//            } else if (y == width - 1 && y > last_slot - 1 && x == v_gap) {
//              if (this.board_state[x + 1][y] == Coding.Invalid
//                      && this.board_state[x][y - 1] == Coding.Invalid) {
//                arr.add(1);
//              } else {
//                arr.add(0);
//              }
//            } else if (y == width - 1 && y > last_slot - 1 && x > v_gap) {
//              if (this.board_state[x - 1][y] == Coding.Invalid
//                      && this.board_state[x][y - 1] == Coding.Invalid) {
//                arr.add(1);
//              } else {
//                arr.add(0);
//              }
//            } else {
//              if (this.board_state[x - 1][y] == Coding.Invalid
//                      && this.board_state[x][y - 1] == Coding.Invalid
//                      && this.board_state[x + 1][y] == Coding.Invalid
//                      && this.board_state[x][y + 1] == Coding.Invalid) {
//                arr.add(1);
//              } else {
//                arr.add(0);
//              }
//            }
//          }
//        }
//      }
//    }
//    return !arr.contains(0);
//  }

  public boolean isGameOver() {
    ArrayList<Integer> arr = new ArrayList<>();
    for (int x = 0; x < width; ++x) {
      for (int y = 0; y < height; ++y) {
        if (this.board_state[x][y] == Coding.Marbles) {
          if (isInvalidMove(x, y, x + 2, y)
                  || isInvalidMove(x, y, x - 2, y)
                  || isInvalidMove(x, y, x, y + 2)
                  || isInvalidMove(x, y, x, y - 2)) {
            arr.add(0);
          } else {
            arr.add(1);
          }
        }
      }
    }
    return !arr.contains(0);
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
  private Coding[][] initBoard() {
    Coding[][] board = new Coding[height][width];
    for (int x = 0; x < width; ++x) {
      for (int y = 0; y < height; ++y) {
        if (y < v_gap || y >= height - v_gap) {
          if ((x >= front_gap) && x < last_slot) {
            board[y][x] = Coding.Marbles;
          } else if (x < front_gap) {
            board[y][x] = Coding.Invalid;
          } else if (x >= last_slot) {
            board[y][x] = Coding.OutofBound;
          }
        } else {
          board[y][x] = Coding.Marbles;
        }
      }
    }
    board[this.srow][this.scol] = Coding.Empty;
    return board;
  }

  @Override
  public String getGameState() {
    StringBuilder string_board = new StringBuilder();
    for (int x = 0; x < width; ++x) {
      for (int y = 0; y < height; ++y) {
        switch (this.board_state[x][y]) {
          case Invalid:
            string_board.append("  ");
            break;
          case Marbles:
            if (x < v_gap || x >= height - v_gap) {
              if (y < last_slot - 1) {
                string_board.append("O ");
              } else {
                string_board.append("O");
              }
            } else if (y == width - 1) {
              string_board.append("O");
            } else {
              string_board.append("O ");
            }
            break;
          case Empty:
            if (x < v_gap || x >= height - v_gap) {
              if (y < last_slot - 1) {
                string_board.append("_ ");
              } else {
                string_board.append("_");
              }
            } else if (y == width - 1) {
              string_board.append("_");
            } else {
              string_board.append("_ ");
            }
            break;
          default:
        }
      }
      if (x < height - 1) {
        string_board.append("\n");
      }
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

  /**
   * Empty board construction. Initialize the board in the form of int arrays.
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
   * @return An Empty Board
   */
  private Coding[][] initBoardEmpty() {
    Coding[][] board = new Coding[height][width];
    for (int x = 0; x < width; ++x) {
      for (int y = 0; y < height; ++y) {
        if (y < v_gap || y >= height - v_gap) {
          if ((x >= front_gap) && x < last_slot) {
            board[y][x] = Coding.Empty;
          } else if (x < front_gap) {
            board[y][x] = Coding.Invalid;
          } else if (x >= last_slot) {
            board[y][x] = Coding.OutofBound;
          }
        } else {
          board[y][x] = Coding.Empty;
        }
      }
    }
    board[this.srow][this.scol] = Coding.Empty;
    return board;
  }
}
