package cs3500.marblesolitaire;

import java.io.InputStreamReader;

import cs3500.marblesolitaire.controller.MarbleSolitaireControllerImpl;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelImpl;
import cs3500.marblesolitaire.model.hw04.EuropeanSolitaireModelImpl;
import cs3500.marblesolitaire.model.hw04.TriangleSolitaireModelImpl;

/**
 * Constructs and run different models of MarbleSolitaire that is customizable through command line
 * input.
 */
public final class MarbleSolitaire {
  /**
   * Iterates over the args array and process the string in each array to determine which model to
   * create, customize size, row, and col.
   *
   * @param args inputs of program
   */
  public static void main(String[] args) {
    boolean customSize = false;
    boolean customHole = false;
    int model = 1;
    int size = 3;
    int row = 3;
    int col = 3;
    for (int i = 0; i < args.length; i++) {
      switch (args[i]) {
        case "english":
          model = 1;
          break;
        case "european":
          model = 2;
          break;
        case "triangular":
          model = 3;
          break;
        case "-size":
          size = Integer.parseInt(args[i + 1]);
          customSize = true;
          i++;
          break;
        case "-hole":
          row = Integer.parseInt(args[i + 1]);
          col = Integer.parseInt(args[i + 2]);
          customHole = true;
          i += 2;
          break;
        default:
          break;
      }
    }
    new MarbleSolitaireControllerImpl(new InputStreamReader(System.in), System.out).playGame(
            setModel(model, size, row, col, customSize, customHole));
  }


  /**
   * The method determines which model to be create through customized or non-customized inputs
   * passed in. It also determines which constructor to use.
   *
   * @param model      the kind of model
   * @param size       the size of model
   * @param row        the empty row
   * @param col        the empty col
   * @param customSize customized size ?
   * @param customHole customized hole?
   */
  private static MarbleSolitaireModel setModel(int model, int size, int row, int col,
                                               boolean customSize, boolean customHole) {
    if (customSize && customHole) {
      switch (model) {
        case 1:
          return new MarbleSolitaireModelImpl(size, row - 1, col - 1);
        case 2:
          return new EuropeanSolitaireModelImpl(size, row - 1, col - 1);
        case 3:
          return new TriangleSolitaireModelImpl(size, row - 1, col - 1);
        default:
          break;
      }
    } else if (customSize) {
      switch (model) {
        case 1:
          return new MarbleSolitaireModelImpl(size);
        case 2:
          return new EuropeanSolitaireModelImpl(size);
        case 3:
          return new TriangleSolitaireModelImpl(size);
        default:
          break;
      }
    } else if (customHole) {
      switch (model) {
        case 1:
          return new MarbleSolitaireModelImpl(row - 1, col - 1);
        case 2:
          return new EuropeanSolitaireModelImpl(row - 1, col - 1);
        case 3:
          return new TriangleSolitaireModelImpl(row - 1, col - 1);
        default:
          break;
      }
    } else {
      switch (model) {
        case 1:
          return new MarbleSolitaireModelImpl();
        case 2:
          return new EuropeanSolitaireModelImpl();
        case 3:
          return new TriangleSolitaireModelImpl();
        default:
          break;
      }
    }
    throw new IllegalArgumentException("No Arguments");
  }
}


