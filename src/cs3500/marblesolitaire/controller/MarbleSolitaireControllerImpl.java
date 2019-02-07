package cs3500.marblesolitaire.controller;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.NoSuchElementException;
import java.util.Scanner;

import javax.imageio.IIOException;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelImpl;

/*
TODO:
1. Remove throws IOException on playGame method
2. Testing the method
3. Throw catch for Readable and Appendable
 */
public class MarbleSolitaireControllerImpl implements MarbleSolitaireController {
  private final Readable rd;
  private final Appendable ap;

  public MarbleSolitaireControllerImpl(Readable rd, Appendable ap) throws IllegalArgumentException {
    if (rd == null || ap == null) {
      throw new IllegalArgumentException("Constructor Error");
    }
    this.rd = rd;
    this.ap = ap;
  }

  private void outputCondition(Output o, MarbleSolitaireModel model) {
    try {
      switch (o) {
        case Over:
          this.ap.append("Game quit!" + "\n");
          this.ap.append("State of game when quit:" + "\n");
          this.ap.append(model.getGameState() + "\n");
          this.ap.append(String.format("Score: %s", model.getScore()) + "\n");
          break;
        default:
      }
    }
    catch (IOException e){
      throw new IllegalStateException();
    }
  }

//  private void inputCheck(int[] arr, int ind,MarbleSolitaireModel model) throws IOException {
//    Scanner scan = new Scanner(this.rd);
//    String scan1;
//    boolean done = false;
//    while (!done) {
//      scan1 = scan.next();
//      if (scan1.equals("Q") || scan1.equals("q")) {
//        outputCondition(Output.Over, model);
//        return;
//      }
//      try {
//        if (Integer.parseInt(scan1) < 0) {
//          throw new IllegalArgumentException();
//        }
//        arr[ind] = Integer.parseInt(scan1);
//        done = true;
//      } catch (NumberFormatException n) {
//        this.ap.append("Invalid input. Enter a new input \n");
//
//      } catch (IllegalArgumentException e) {
//        this.ap.append("Invalid input. Enter a new input \n");
//
//      }
//    }
//  }
  @Override
  public void playGame(MarbleSolitaireModel model) {
    try {
      if (model == null) {
        throw new IllegalArgumentException("Model can't be null");
      }
      int[] arr = new int[4];
      String scan1;
      Scanner scan = new Scanner(this.rd);
      boolean game_over = model.isGameOver();
      while (!game_over) {
        this.ap.append(model.getGameState() + "\n");
        this.ap.append(String.format("Score: %s", model.getScore()) + "\n");
        while (!game_over) {
          for (int i = 0; i < arr.length; i++) {
            boolean done = false;
            while (!done) {
              scan1 = scan.next();
              if (scan1.equals("Q") || scan1.equals("q")) {
                outputCondition(Output.Over, model);
                return;
              } else {
                try {
                  if (Integer.parseInt(scan1) < 0) {
                    throw new IllegalArgumentException();
                  }
                  arr[i] = Integer.parseInt(scan1);
                  done = true;
                } catch (NumberFormatException n) {
                  this.ap.append("Invalid input. Enter a new input \n");
                } catch (IllegalArgumentException e) {
                  this.ap.append("Invalid input. Enter a new input \n");
                }
              }
            }
          }
          try {
            model.move(arr[0] - 1, arr[1] - 1, arr[2] - 1, arr[3] - 1);
          } catch (IllegalArgumentException a) {
            this.ap.append(String.format("Invalid move. Play again. %s", a) + "\n");
          }
        }

      }
        outputCondition(Output.Over, model);

    } catch (IOException e) {
      throw new IllegalStateException();
    }
    catch (NoSuchElementException e) {
      throw new IllegalStateException();
    }
  }
}

class test {
  public static void main(String[] args) {
      new MarbleSolitaireControllerImpl(new InputStreamReader(System.in), System.out).playGame(new MarbleSolitaireModelImpl());
  }
}
