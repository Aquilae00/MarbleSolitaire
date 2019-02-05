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

  @Override
  public void playGame(MarbleSolitaireModel model) throws IOException {
    if (model == null) {
      throw new IllegalArgumentException("Model can't be null");
    }
    int num1, num2, num3, num4;
    Scanner scan = new Scanner(this.rd);
    this.ap.append(model.getGameState() + "\n");
    this.ap.append(String.format("Score: %s", model.getScore()) + "\n");
    if (!model.isGameOver()) {
      String next = scan.next();
      switch (next) {
        case "q":
          this.ap.append("Game quit!" + "\n");
          this.ap.append("State of the game when quit:" + "\n");
          this.ap.append(model.getGameState() + "\n");
          this.ap.append(String.format("Score: %s", model.getScore()) + "\n");
          break;
        case "Q":
          this.ap.append("Game quit!" + "\n");
          this.ap.append("State of the game when quit:" + "\n");
          this.ap.append(model.getGameState() + "\n");
          this.ap.append(String.format("Score: %s", model.getScore()) + "\n");
        default:
          num1 = Integer.valueOf(next);
          num2 = scan.nextInt();
          num3 = scan.nextInt();
          num4 = scan.nextInt();
          try {
            model.move(num1, num2, num3, num4);
          } catch (IllegalArgumentException a) {
            this.ap.append(String.format("Invalid move. Play again. %s", a) + "\n");
            this.playGame(model);
          }
          this.playGame(model);
      }
    } else {
      this.ap.append("Game over!" + "\n");
      this.ap.append(model.getGameState() + "\n");
      this.ap.append(String.format("Score: %s", model.getScore()));
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
