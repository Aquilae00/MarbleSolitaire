package cs3500.marblesolitaire.model.hw04;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;

public class EuropeanSolitaireModelImpl extends AbstractSolitaireModel {

  public EuropeanSolitaireModelImpl(int armLength,int row, int col) {
    if (armLength < 0
            || armLength % 2 == 0
            || row < 0
            || col < 0) {
      throw new IllegalArgumentException("Invalid Input");
    }
    this.arm = armLength;
    super.init(Model.European);
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
