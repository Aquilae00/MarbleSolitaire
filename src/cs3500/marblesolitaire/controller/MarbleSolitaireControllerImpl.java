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

//  private void movement(int num1, int num2, int num3, int num4, MarbleSolitaireModel model) {
//    try {
//      model.move(num1, num2, num3, num4);
//    } catch (IllegalArgumentException a) {
//      this.ap.append(String.format("Invalid move. Play again. %s", a) + "\n");
//      scan.next();
//    }
//  }
  @Override
  public void playGame(MarbleSolitaireModel model) throws IOException {
    if (model == null) {
      throw new IllegalArgumentException("Model can't be null");
    }
    int num1, num2, num3, num4;
    String scan1, scan2, scan3, scan4;
    Scanner scan = new Scanner(this.rd);
    this.ap.append(model.getGameState() + "\n");
    this.ap.append(String.format("Score: %s", model.getScore()) + "\n");
    if (!model.isGameOver()) {
      scan1 = scan.next();
      scan2 = scan.next();
      scan3 = scan.next();
      scan4 = scan.next();

      if (scan1.equals("q") || scan1.equals("Q")
              || scan2.equals("q") || scan2.equals("Q")
              || scan3.equals("q") || scan3.equals("Q")
              || scan4.equals("q") || scan4.equals("Q")) {
        outputCondition(Output.Over,model);
      } else {
        num1 = Integer.parseInt(scan1);
        num2 = Integer.parseInt(scan2);
        num3 = Integer.parseInt(scan3);
        num4 = Integer.parseInt(scan4);
        try {
          model.move(num1, num2, num3, num4);
        } catch (IllegalArgumentException a) {
          this.ap.append(String.format("Invalid move. Play again. %s", a) + "\n");
          this.playGame(model);
        }
        this.playGame(model);
      }
    } else {
      outputCondition(Output.Over,model);
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
