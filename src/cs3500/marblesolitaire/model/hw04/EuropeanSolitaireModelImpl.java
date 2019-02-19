package cs3500.marblesolitaire.model.hw04;

import cs3500.marblesolitaire.model.hw02.Coding;

public class EuropeanSolitaireModelImpl extends AbstractSolitaireModel {

  public EuropeanSolitaireModelImpl() {
    this(DEFAULT_ARM, DEFAULT_SROW, DEFAULT_SCOL);
  }

  public EuropeanSolitaireModelImpl(int armLength) {
    this(armLength, DEFAULT_SROW, DEFAULT_SCOL);
  }

  public EuropeanSolitaireModelImpl(int row, int col) {
    this(DEFAULT_ARM, row, col);
  }

  public EuropeanSolitaireModelImpl(int armLength, int row, int col) {
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
    variant = 0;
    invariant = this.arm;

    v_gap = this.arm - 1;
    height = v_gap * 2 + this.arm;

    if (row == DEFAULT_SROW && col == DEFAULT_SCOL) {
      this.scol = this.arm + this.arm / 2 - 1;
      this.srow = this.arm - 1 + this.arm / 2;
    } else {
      this.srow = row;
      this.scol = col;
    }
    this.board_state = initBoard();

  }
}
