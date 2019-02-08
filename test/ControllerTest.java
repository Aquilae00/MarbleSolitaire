import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringReader;

import org.junit.Assert;
import org.junit.Test;

import cs3500.marblesolitaire.controller.MarbleSolitaireController;
import cs3500.marblesolitaire.controller.MarbleSolitaireControllerImpl;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelImpl;

class test {
  public static void main(String[] args) {
    new MarbleSolitaireControllerImpl(new InputStreamReader(System.in), System.out).playGame(new MarbleSolitaireModelImpl(5));
  }
}

public class ControllerTest {
  public ControllerTest() {
  }

  @Test
  public void testPlayGameDefaultQuit() {
    StringBuffer out = new StringBuffer();
    Reader in = new StringReader("q");
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(in, out);
    controller.playGame(new MarbleSolitaireModelImpl());
    StringBuilder string = new StringBuilder();
    string.append(
            "    O O O\n" +
                    "    O O O\n" +
                    "O O O O O O O\n" +
                    "O O O _ O O O\n" +
                    "O O O O O O O\n" +
                    "    O O O\n" +
                    "    O O O\n" +
                    "Score: 32\n" +
                    "Game quit!\n" +
                    "State of game when quit:\n" +
                    "    O O O\n" +
                    "    O O O\n" +
                    "O O O O O O O\n" +
                    "O O O _ O O O\n" +
                    "O O O O O O O\n" +
                    "    O O O\n" +
                    "    O O O\n" +
                    "Score: 32\n"
    );
    Assert.assertEquals(string.toString(), out.toString());
  }
  @Test
  public void testPlayGameDefaultMoveUpThenQuit() {
    StringBuffer out = new StringBuffer();
    Reader in = new StringReader("6 4 4 4 q");
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(in, out);
    controller.playGame(new MarbleSolitaireModelImpl());
    StringBuilder string = new StringBuilder();
    string.append(
            "    O O O\n" +
                    "    O O O\n" +
                    "O O O O O O O\n" +
                    "O O O _ O O O\n" +
                    "O O O O O O O\n" +
                    "    O O O\n" +
                    "    O O O\n" +
                    "Score: 32\n" +
                    "    O O O\n" +
                    "    O O O\n" +
                    "O O O O O O O\n" +
                    "O O O O O O O\n" +
                    "O O O _ O O O\n" +
                    "    O _ O\n" +
                    "    O O O\n" +
                    "Score: 31\n" +
                    "Game quit!\n" +
                    "State of game when quit:\n" +
                    "    O O O\n" +
                    "    O O O\n" +
                    "O O O O O O O\n" +
                    "O O O O O O O\n" +
                    "O O O _ O O O\n" +
                    "    O _ O\n" +
                    "    O O O\n" +
                    "Score: 31\n"
    );
    Assert.assertEquals(string.toString(), out.toString());
  }

  @Test
  public void testPlayGameDefaultMoveDownThenQuit() {
    StringBuffer out = new StringBuffer();
    Reader in = new StringReader("2 4 4 4 q");
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(in, out);
    controller.playGame(new MarbleSolitaireModelImpl());
    StringBuilder string = new StringBuilder();
    string.append(
            "    O O O\n" +
                    "    O O O\n" +
                    "O O O O O O O\n" +
                    "O O O _ O O O\n" +
                    "O O O O O O O\n" +
                    "    O O O\n" +
                    "    O O O\n" +
                    "Score: 32\n" +
                    "    O O O\n" +
                    "    O _ O\n" +
                    "O O O _ O O O\n" +
                    "O O O O O O O\n" +
                    "O O O O O O O\n" +
                    "    O O O\n" +
                    "    O O O\n" +
                    "Score: 31\n" +
                    "Game quit!\n" +
                    "State of game when quit:\n" +
                    "    O O O\n" +
                    "    O _ O\n" +
                    "O O O _ O O O\n" +
                    "O O O O O O O\n" +
                    "O O O O O O O\n" +
                    "    O O O\n" +
                    "    O O O\n" +
                    "Score: 31\n"
    );
    Assert.assertEquals(string.toString(), out.toString());
  }

  @Test
  public void testPlayGameDefaultMoveRightThenQuit() {
    StringBuffer out = new StringBuffer();
    Reader in = new StringReader("4 2 4 4 q");
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(in, out);
    controller.playGame(new MarbleSolitaireModelImpl());
    StringBuilder string = new StringBuilder();
    string.append(
            "    O O O\n" +
                    "    O O O\n" +
                    "O O O O O O O\n" +
                    "O O O _ O O O\n" +
                    "O O O O O O O\n" +
                    "    O O O\n" +
                    "    O O O\n" +
                    "Score: 32\n" +
                    "    O O O\n" +
                    "    O O O\n" +
                    "O O O O O O O\n" +
                    "O _ _ O O O O\n" +
                    "O O O O O O O\n" +
                    "    O O O\n" +
                    "    O O O\n" +
                    "Score: 31\n" +
                    "Game quit!\n" +
                    "State of game when quit:\n" +
                    "    O O O\n" +
                    "    O O O\n" +
                    "O O O O O O O\n" +
                    "O _ _ O O O O\n" +
                    "O O O O O O O\n" +
                    "    O O O\n" +
                    "    O O O\n" +
                    "Score: 31\n");
    Assert.assertEquals(string.toString(), out.toString());
  }

  @Test
  public void testPlayGameDefaultMoveLeftThenQuit() {
    StringBuffer out = new StringBuffer();
    Reader in = new StringReader("4 6 4 4 q");
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(in, out);
    controller.playGame(new MarbleSolitaireModelImpl());
    StringBuilder string = new StringBuilder();
    string.append(
            "    O O O\n" +
                    "    O O O\n" +
                    "O O O O O O O\n" +
                    "O O O _ O O O\n" +
                    "O O O O O O O\n" +
                    "    O O O\n" +
                    "    O O O\n" +
                    "Score: 32\n" +
                    "    O O O\n" +
                    "    O O O\n" +
                    "O O O O O O O\n" +
                    "O O O O _ _ O\n" +
                    "O O O O O O O\n" +
                    "    O O O\n" +
                    "    O O O\n" +
                    "Score: 31\n" +
                    "Game quit!\n" +
                    "State of game when quit:\n" +
                    "    O O O\n" +
                    "    O O O\n" +
                    "O O O O O O O\n" +
                    "O O O O _ _ O\n" +
                    "O O O O O O O\n" +
                    "    O O O\n" +
                    "    O O O\n" +
                    "Score: 31\n");
    Assert.assertEquals(string.toString(), out.toString());
  }

  @Test
  public void testPlayGameDefaultInvalidFixThenQuit() {
    StringBuffer out = new StringBuffer();
    Reader in = new StringReader("4 2 r 4 4 q");
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(in, out);
    controller.playGame(new MarbleSolitaireModelImpl());
    StringBuilder string = new StringBuilder();
    string.append(
            "    O O O\n" +
                    "    O O O\n" +
                    "O O O O O O O\n" +
                    "O O O _ O O O\n" +
                    "O O O O O O O\n" +
                    "    O O O\n" +
                    "    O O O\n" +
                    "Score: 32\n" +
                    "Invalid input. Enter a new input\n" +
                    "    O O O\n" +
                    "    O O O\n" +
                    "O O O O O O O\n" +
                    "O _ _ O O O O\n" +
                    "O O O O O O O\n" +
                    "    O O O\n" +
                    "    O O O\n" +
                    "Score: 31\n" +
                    "Game quit!\n" +
                    "State of game when quit:\n" +
                    "    O O O\n" +
                    "    O O O\n" +
                    "O O O O O O O\n" +
                    "O _ _ O O O O\n" +
                    "O O O O O O O\n" +
                    "    O O O\n" +
                    "    O O O\n" +
                    "Score: 31\n");
    Assert.assertEquals(string.toString(), out.toString());
  }

  @Test
  public void testPlayGameDefaultInvalidMoveThenQuit() {
    StringBuffer out = new StringBuffer();
    Reader in = new StringReader("4 2 10 10 q");
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(in, out);
    controller.playGame(new MarbleSolitaireModelImpl());
    StringBuilder string = new StringBuilder();
    string.append(
            "    O O O\n" +
                    "    O O O\n" +
                    "O O O O O O O\n" +
                    "O O O _ O O O\n" +
                    "O O O O O O O\n" +
                    "    O O O\n" +
                    "    O O O\n" +
                    "Score: 32\n" +
                    "Invalid move. Play again. java.lang.IllegalArgumentException: Invalid empty cell position (9,9)\n" +
                    "    O O O\n" +
                    "    O O O\n" +
                    "O O O O O O O\n" +
                    "O O O _ O O O\n" +
                    "O O O O O O O\n" +
                    "    O O O\n" +
                    "    O O O\n" +
                    "Score: 32\n" +
                    "Game quit!\n" +
                    "State of game when quit:\n" +
                    "    O O O\n" +
                    "    O O O\n" +
                    "O O O O O O O\n" +
                    "O O O _ O O O\n" +
                    "O O O O O O O\n" +
                    "    O O O\n" +
                    "    O O O\n" +
                    "Score: 32\n");
    Assert.assertEquals(string.toString(), out.toString());
  }

  @Test
  public void testPlayGameDefaultInvalidMoveFixThenQuit() {
    StringBuffer out = new StringBuffer();
    Reader in = new StringReader("4 2 10 10 4 2 4 4 q");
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(in, out);
    controller.playGame(new MarbleSolitaireModelImpl());
    StringBuilder string = new StringBuilder();
    string.append(
            "    O O O\n" +
                    "    O O O\n" +
                    "O O O O O O O\n" +
                    "O O O _ O O O\n" +
                    "O O O O O O O\n" +
                    "    O O O\n" +
                    "    O O O\n" +
                    "Score: 32\n" +
                    "Invalid move. Play again. java.lang.IllegalArgumentException: Invalid empty cell position (9,9)\n" +
                    "    O O O\n" +
                    "    O O O\n" +
                    "O O O O O O O\n" +
                    "O O O _ O O O\n" +
                    "O O O O O O O\n" +
                    "    O O O\n" +
                    "    O O O\n" +
                    "Score: 32\n" +
                    "    O O O\n" +
                    "    O O O\n" +
                    "O O O O O O O\n" +
                    "O _ _ O O O O\n" +
                    "O O O O O O O\n" +
                    "    O O O\n" +
                    "    O O O\n" +
                    "Score: 31\n" +
                    "Game quit!\n" +
                    "State of game when quit:\n" +
                    "    O O O\n" +
                    "    O O O\n" +
                    "O O O O O O O\n" +
                    "O _ _ O O O O\n" +
                    "O O O O O O O\n" +
                    "    O O O\n" +
                    "    O O O\n" +
                    "Score: 31\n");
    Assert.assertEquals(string.toString(), out.toString());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testPlayGameDefaultNullModel() {
    StringBuffer out = new StringBuffer();
    Reader in = new StringReader("4 2 4 4 q");
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(in, out);
    controller.playGame(null);
  }
  @Test (expected = IllegalStateException.class)
  public void testPlayGameDefaultNullInput() {
    StringBuffer out = new StringBuffer();
    Reader in = new StringReader("null");
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(in, out);
    controller.playGame(new MarbleSolitaireModelImpl());
  }
}
