package cs3500.marblesolitaire.model.hw02;

import cs3500.marblesolitaire.model.hw04.AbstractSolitaireModel;

/**
 * Class implementation of MarbleSolitaireModel.
 */
public final class MarbleSolitaireModelImpl extends AbstractSolitaireModel {



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
   * @param armLength the arm thickness
   * @param row        the y axis of empty slot
   * @param col        the x axis of empty slot
   * @throws IllegalArgumentException if the arm thickness is not a positive odd number, or the
   *                                  empty cell position is invalid
   */
  public MarbleSolitaireModelImpl(int armLength, int row, int col) {
    if (armLength < 0
            || armLength % 2 == 0
            || row < 0
            || col < 0) {
      throw new IllegalArgumentException("Invalid Input");
    }
    this.arm = armLength;
    front_gap = this.arm - 1;
    width = 3 * this.arm - 2;
    last_slot = width - front_gap;
    edge_gap = this.arm - 1;
    last_slot_edge = last_slot;

    v_gap = this.arm - 1;
    height = v_gap * 2 + this.arm;
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
  }
}
