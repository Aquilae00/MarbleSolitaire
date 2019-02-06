package cs3500.marblesolitaire.controller;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelImpl;

/*
TODO:
1. Remove throws IOException on playGame method
2. Testing the method
3. Throw catch for Readable and Appendable
 */
public class MarbleSolitaireControllerImpl implements MarbleSolitaireController {
  final Readable rd;
  final Appendable ap;

  public MarbleSolitaireControllerImpl(Readable rd, Appendable ap) {
    if (rd == null || ap == null) {
      throw new IllegalArgumentException("Constructor Error");
    }
    this.rd = rd;
    this.ap = ap;
  }

  private void outputCondition(Output o, MarbleSolitaireModel model) throws IOException {
    switch (o) {
      case Over:
        this.ap.append("Game quit!" + "\n");
        this.ap.append("State of the game when quit:" + "\n");
        this.ap.append(model.getGameState() + "\n");
        this.ap.append(String.format("Score: %s", model.getScore()) + "\n");
        break;
      default:
    }
  }

  @Override
  public void playGame(MarbleSolitaireModel model) throws IOException {
    if (model == null) {
      throw new IllegalArgumentException("Model can't be null");
    }
    int[] arr = new int[4];
    String scan1;
    Scanner scan = new Scanner(this.rd);
    this.ap.append(model.getGameState() + "\n");
    this.ap.append(String.format("Score: %s", model.getScore()) + "\n");
    if (!model.isGameOver()) {
      for (int i = 0; i < arr.length; i++) {
        scan1 = scan.next();
        if (scan1.equals("Q") || scan1.equals("q")) {
          outputCondition(Output.Over, model);
          System.exit(0);
        }
        try {
          if (Integer.parseInt(scan1) < 0) {
            throw new IllegalArgumentException();
          }
          arr[i] = Integer.parseInt(scan1);
        } catch (NumberFormatException n) {
          this.ap.append("Invalid input. Enter a new input \n");
          arr[i] = Integer.parseInt(scan.next());
        } catch (IllegalArgumentException e) {
          this.ap.append("Invalid input. Enter a new input \n");
          arr[i] = Integer.parseInt(scan.next());
        }
      }
      try {
        model.move(arr[0] - 1, arr[1] - 1, arr[2] - 1, arr[3] - 1);
      } catch (IllegalArgumentException a) {
        this.ap.append(String.format("Invalid move. Play again. %s", a) + "\n");
        this.playGame(model);
      }
      this.playGame(model);
    } else {
      outputCondition(Output.Over, model);
    }
  }
}

class test {
  public static void main(String[] args) {
    try {
      new MarbleSolitaireControllerImpl(new InputStreamReader(System.in), System.out).playGame(new MarbleSolitaireModelImpl());
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
