import java.io.Reader;
import java.io.StringReader;

import org.junit.Assert;
import org.junit.Test;

import cs3500.marblesolitaire.controller.MarbleSolitaireController;
import cs3500.marblesolitaire.controller.MarbleSolitaireControllerImpl;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelImpl;

public class ControllerTest {
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
  public void testPlayGameDefaultQuit2() {
    StringBuffer out = new StringBuffer();
    Reader in = new StringReader("1 q");
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
  public void testPlayGameDefaultQuit3() {
    StringBuffer out = new StringBuffer();
    Reader in = new StringReader("1 2 q");
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
  public void testPlayGameDefaultQuit4() {
    StringBuffer out = new StringBuffer();
    Reader in = new StringReader("1 2 3 q");
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
  public void testPlayGameDefaultDoubleMoveThenQuit() {
    StringBuffer out = new StringBuffer();
    Reader in = new StringReader("4 2 4 4 4 5 4 3 q");
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
                    "    O O O\n" +
                    "    O O O\n" +
                    "O O O O O O O\n" +
                    "O _ O _ _ O O\n" +
                    "O O O O O O O\n" +
                    "    O O O\n" +
                    "    O O O\n" +
                    "Score: 30\n" +
                    "Game quit!\n" +
                    "State of game when quit:\n" +
                    "    O O O\n" +
                    "    O O O\n" +
                    "O O O O O O O\n" +
                    "O _ O _ _ O O\n" +
                    "O O O O O O O\n" +
                    "    O O O\n" +
                    "    O O O\n" +
                    "Score: 30\n");
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
                    "Invalid move. Play again. java.lang.IllegalArgumentException:" +
                    " Invalid empty cell position (9,9)\n" +
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
                    "Invalid move. Play again. java.lang.IllegalArgumentException: " +
                    "Invalid empty cell position (9,9)\n" +
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

  @Test(expected = IllegalStateException.class)
  public void testPlayGameDefaultNullInput() {
    StringBuffer out = new StringBuffer();
    Reader in = new StringReader("null");
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(in, out);
    controller.playGame(new MarbleSolitaireModelImpl());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testPlayGameDefaultNullReadable() {
    StringBuffer out = new StringBuffer();
    Reader in = new StringReader("4 2 4 4 q");
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(null, out);
    controller.playGame(new MarbleSolitaireModelImpl());
  }

  @Test(expected = IllegalStateException.class)
  public void testPlayGameDefaultNoTermination() {
    StringBuffer out = new StringBuffer();
    Reader in = new StringReader("4 2 4 4");
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(in, out);
    controller.playGame(new MarbleSolitaireModelImpl());
  }

  @Test
  public void testPlayGameArm5Quit() {
    StringBuffer out = new StringBuffer();
    Reader in = new StringReader("q");
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(in, out);
    controller.playGame(new MarbleSolitaireModelImpl(5));
    StringBuilder string = new StringBuilder();
    string.append(
            "        O O O O O\n" +
                    "        O O O O O\n" +
                    "        O O O O O\n" +
                    "        O O O O O\n" +
                    "O O O O O O O O O O O O O\n" +
                    "O O O O O O O O O O O O O\n" +
                    "O O O O O O _ O O O O O O\n" +
                    "O O O O O O O O O O O O O\n" +
                    "O O O O O O O O O O O O O\n" +
                    "        O O O O O\n" +
                    "        O O O O O\n" +
                    "        O O O O O\n" +
                    "        O O O O O\n" +
                    "Score: 104\n" +
                    "Game quit!\n" +
                    "State of game when quit:\n" +
                    "        O O O O O\n" +
                    "        O O O O O\n" +
                    "        O O O O O\n" +
                    "        O O O O O\n" +
                    "O O O O O O O O O O O O O\n" +
                    "O O O O O O O O O O O O O\n" +
                    "O O O O O O _ O O O O O O\n" +
                    "O O O O O O O O O O O O O\n" +
                    "O O O O O O O O O O O O O\n" +
                    "        O O O O O\n" +
                    "        O O O O O\n" +
                    "        O O O O O\n" +
                    "        O O O O O\n" +
                    "Score: 104\n"
    );
    Assert.assertEquals(string.toString(), out.toString());
  }

  @Test
  public void testPlayGameCustomRCMoveRightThenQuit() {
    StringBuffer out = new StringBuffer();
    Reader in = new StringReader("4 1 4 3 q");
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(in, out);
    controller.playGame(new MarbleSolitaireModelImpl(3, 2));
    StringBuilder string = new StringBuilder();
    string.append(
            "    O O O\n" +
                    "    O O O\n" +
                    "O O O O O O O\n" +
                    "O O _ O O O O\n" +
                    "O O O O O O O\n" +
                    "    O O O\n" +
                    "    O O O\n" +
                    "Score: 32\n" +
                    "    O O O\n" +
                    "    O O O\n" +
                    "O O O O O O O\n" +
                    "_ _ O O O O O\n" +
                    "O O O O O O O\n" +
                    "    O O O\n" +
                    "    O O O\n" +
                    "Score: 31\n" +
                    "Game quit!\n" +
                    "State of game when quit:\n" +
                    "    O O O\n" +
                    "    O O O\n" +
                    "O O O O O O O\n" +
                    "_ _ O O O O O\n" +
                    "O O O O O O O\n" +
                    "    O O O\n" +
                    "    O O O\n" +
                    "Score: 31\n");
    Assert.assertEquals(string.toString(), out.toString());
  }

  @Test
  public void testPlayGameCustomARCQuit() {
    StringBuffer out = new StringBuffer();
    Reader in = new StringReader("q");
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(in, out);
    controller.playGame(new MarbleSolitaireModelImpl(5, 5, 4));
    StringBuilder string = new StringBuilder();
    string.append(
            "        O O O O O\n" +
                    "        O O O O O\n" +
                    "        O O O O O\n" +
                    "        O O O O O\n" +
                    "O O O O O O O O O O O O O\n" +
                    "O O O O _ O O O O O O O O\n" +
                    "O O O O O O O O O O O O O\n" +
                    "O O O O O O O O O O O O O\n" +
                    "O O O O O O O O O O O O O\n" +
                    "        O O O O O\n" +
                    "        O O O O O\n" +
                    "        O O O O O\n" +
                    "        O O O O O\n" +
                    "Score: 104\n" +
                    "Game quit!\n" +
                    "State of game when quit:\n" +
                    "        O O O O O\n" +
                    "        O O O O O\n" +
                    "        O O O O O\n" +
                    "        O O O O O\n" +
                    "O O O O O O O O O O O O O\n" +
                    "O O O O _ O O O O O O O O\n" +
                    "O O O O O O O O O O O O O\n" +
                    "O O O O O O O O O O O O O\n" +
                    "O O O O O O O O O O O O O\n" +
                    "        O O O O O\n" +
                    "        O O O O O\n" +
                    "        O O O O O\n" +
                    "        O O O O O\n" +
                    "Score: 104\n"
    );
    Assert.assertEquals(string.toString(), out.toString());
  }

  @Test
  public void testPlayGameCustomTillGameOver() {
    StringBuffer out = new StringBuffer();
    Reader in = new StringReader("4 6 4 4 6 5 6 3 6 6 6 4 6 5 4 5 4 4 4 6 4 7 4 5 3 4 5 " +
            "4 3 5 5 5 6 4 4 4 3 4 5 4 4 2 4 4 5 4 3 4 2 4 4 4 6 3 4 3 4 3 4 5 3 2 3 4 1 3 3 " +
            "3 3 3 3 5 5 1 5 3 5 6 5 4 5 3 5 5 3 1 5 1 3 5 5 5 4 5 6 5 7 5 7 3 7 5 5 5 2 5 4 " +
            "5 5 5 3 5 1 5 1 3 7 3 7 5 3 6 3 4");
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
                    "Invalid move. Play again. java.lang.IllegalArgumentException: Invalid empty" +
                    " cell position (5,2)\n" +
                    "    O O O\n" +
                    "    O O O\n" +
                    "O O O O O O O\n" +
                    "O O O O _ _ O\n" +
                    "O O O O O O O\n" +
                    "    O O O\n" +
                    "    O O O\n" +
                    "Score: 31\n" +
                    "Invalid move. Play again. java.lang.IllegalArgumentException: Invalid empty " +
                    "cell position (5,3)\n" +
                    "    O O O\n" +
                    "    O O O\n" +
                    "O O O O O O O\n" +
                    "O O O O _ _ O\n" +
                    "O O O O O O O\n" +
                    "    O O O\n" +
                    "    O O O\n" +
                    "Score: 31\n" +
                    "    O O O\n" +
                    "    O O O\n" +
                    "O O O O O O O\n" +
                    "O O O O O _ O\n" +
                    "O O O O _ O O\n" +
                    "    O O _\n" +
                    "    O O O\n" +
                    "Score: 30\n" +
                    "    O O O\n" +
                    "    O O O\n" +
                    "O O O O O O O\n" +
                    "O O O _ _ O O\n" +
                    "O O O O _ O O\n" +
                    "    O O _\n" +
                    "    O O O\n" +
                    "Score: 29\n" +
                    "    O O O\n" +
                    "    O O O\n" +
                    "O O O O O O O\n" +
                    "O O O _ O _ _\n" +
                    "O O O O _ O O\n" +
                    "    O O _\n" +
                    "    O O O\n" +
                    "Score: 28\n" +
                    "Invalid move. Play again. java.lang.IllegalArgumentException: Invalid empty " +
                    "cell position (4,3)\n" +
                    "    O O O\n" +
                    "    O O O\n" +
                    "O O O O O O O\n" +
                    "O O O _ O _ _\n" +
                    "O O O O _ O O\n" +
                    "    O O _\n" +
                    "    O O O\n" +
                    "Score: 28\n" +
                    "    O O O\n" +
                    "    O O O\n" +
                    "O O O O _ O O\n" +
                    "O O O _ _ _ _\n" +
                    "O O O O O O O\n" +
                    "    O O _\n" +
                    "    O O O\n" +
                    "Score: 27\n" +
                    "    O O O\n" +
                    "    O O O\n" +
                    "O O O O _ O O\n" +
                    "O O O O _ _ _\n" +
                    "O O O _ O O O\n" +
                    "    O _ _\n" +
                    "    O O O\n" +
                    "Score: 26\n" +
                    "    O O O\n" +
                    "    O O O\n" +
                    "O O O _ _ O O\n" +
                    "O O O _ _ _ _\n" +
                    "O O O O O O O\n" +
                    "    O _ _\n" +
                    "    O O O\n" +
                    "Score: 25\n" +
                    "    O O O\n" +
                    "    O O O\n" +
                    "O O O _ _ O O\n" +
                    "O _ _ O _ _ _\n" +
                    "O O O O O O O\n" +
                    "    O _ _\n" +
                    "    O O O\n" +
                    "Score: 24\n" +
                    "    O O O\n" +
                    "    O O O\n" +
                    "O O O O _ O O\n" +
                    "O _ _ _ _ _ _\n" +
                    "O O O _ O O O\n" +
                    "    O _ _\n" +
                    "    O O O\n" +
                    "Score: 23\n" +
                    "    O O O\n" +
                    "    O _ O\n" +
                    "O O O _ _ O O\n" +
                    "O _ _ O _ _ _\n" +
                    "O O O _ O O O\n" +
                    "    O _ _\n" +
                    "    O O O\n" +
                    "Score: 22\n" +
                    "    O O O\n" +
                    "    O _ O\n" +
                    "O O O _ _ O O\n" +
                    "O _ O O _ _ _\n" +
                    "O O _ _ O O O\n" +
                    "    _ _ _\n" +
                    "    O O O\n" +
                    "Score: 21\n" +
                    "    O O O\n" +
                    "    O _ O\n" +
                    "O O O _ _ O O\n" +
                    "O _ _ _ O _ _\n" +
                    "O O _ _ O O O\n" +
                    "    _ _ _\n" +
                    "    O O O\n" +
                    "Score: 20\n" +
                    "    O O O\n" +
                    "    O _ O\n" +
                    "O _ _ O _ O O\n" +
                    "O _ _ _ O _ _\n" +
                    "O O _ _ O O O\n" +
                    "    _ _ _\n" +
                    "    O O O\n" +
                    "Score: 19\n" +
                    "    _ O O\n" +
                    "    _ _ O\n" +
                    "O _ O O _ O O\n" +
                    "O _ _ _ O _ _\n" +
                    "O O _ _ O O O\n" +
                    "    _ _ _\n" +
                    "    O O O\n" +
                    "Score: 18\n" +
                    "    _ O O\n" +
                    "    _ _ O\n" +
                    "O _ _ _ O O O\n" +
                    "O _ _ _ O _ _\n" +
                    "O O _ _ O O O\n" +
                    "    _ _ _\n" +
                    "    O O O\n" +
                    "Score: 17\n" +
                    "    _ O O\n" +
                    "    _ _ O\n" +
                    "O _ _ _ O O O\n" +
                    "O _ _ _ O _ _\n" +
                    "_ _ O _ O O O\n" +
                    "    _ _ _\n" +
                    "    O O O\n" +
                    "Score: 16\n" +
                    "    _ O O\n" +
                    "    _ _ O\n" +
                    "O _ _ _ O O O\n" +
                    "O _ _ _ O _ _\n" +
                    "_ _ O O _ _ O\n" +
                    "    _ _ _\n" +
                    "    O O O\n" +
                    "Score: 15\n" +
                    "    _ O O\n" +
                    "    _ _ O\n" +
                    "O _ _ _ O O O\n" +
                    "O _ _ _ O _ _\n" +
                    "_ _ _ _ O _ O\n" +
                    "    _ _ _\n" +
                    "    O O O\n" +
                    "Score: 14\n" +
                    "    _ O O\n" +
                    "    _ _ O\n" +
                    "_ _ _ _ O O O\n" +
                    "_ _ _ _ O _ _\n" +
                    "O _ _ _ O _ O\n" +
                    "    _ _ _\n" +
                    "    O O O\n" +
                    "Score: 13\n" +
                    "Invalid move. Play again. java.lang.IllegalArgumentException: Invalid" +
                    " empty cell position (4,4)\n" +
                    "    _ O O\n" +
                    "    _ _ O\n" +
                    "_ _ _ _ O O O\n" +
                    "_ _ _ _ O _ _\n" +
                    "O _ _ _ O _ O\n" +
                    "    _ _ _\n" +
                    "    O O O\n" +
                    "Score: 13\n" +
                    "    _ O O\n" +
                    "    _ _ O\n" +
                    "_ _ _ _ O O O\n" +
                    "_ _ _ _ _ _ _\n" +
                    "O _ _ _ _ _ O\n" +
                    "    _ _ O\n" +
                    "    O O O\n" +
                    "Score: 12\n" +
                    "Invalid move. Play again. java.lang.IllegalArgumentException: Invalid" +
                    " empty cell position (6,2)\n" +
                    "    _ O O\n" +
                    "    _ _ O\n" +
                    "_ _ _ _ O O O\n" +
                    "_ _ _ _ _ _ _\n" +
                    "O _ _ _ _ _ O\n" +
                    "    _ _ O\n" +
                    "    O O O\n" +
                    "Score: 12\n" +
                    "    _ O O\n" +
                    "    _ _ O\n" +
                    "_ _ _ _ O O O\n" +
                    "_ _ _ _ _ _ _\n" +
                    "O _ _ _ O _ O\n" +
                    "    _ _ _\n" +
                    "    O O _\n" +
                    "Score: 11\n" +
                    "    _ O O\n" +
                    "    _ _ _\n" +
                    "_ _ _ _ _ O O\n" +
                    "_ _ _ _ O _ _\n" +
                    "O _ _ _ O _ O\n" +
                    "    _ _ _\n" +
                    "    O O _\n" +
                    "Score: 10\n" +
                    "    _ O O\n" +
                    "    _ _ _\n" +
                    "_ _ _ _ O O O\n" +
                    "_ _ _ _ _ _ _\n" +
                    "O _ _ _ _ _ O\n" +
                    "    _ _ _\n" +
                    "    O O _\n" +
                    "Score: 9\n" +
                    "    O _ _\n" +
                    "    _ _ _\n" +
                    "_ _ _ _ O O O\n" +
                    "_ _ _ _ _ _ _\n" +
                    "O _ _ _ _ _ O\n" +
                    "    _ _ _\n" +
                    "    O O _\n" +
                    "Score: 8\n" +
                    "    O _ _\n" +
                    "    _ _ _\n" +
                    "_ _ _ _ O O O\n" +
                    "_ _ _ _ _ _ _\n" +
                    "O _ _ _ _ _ O\n" +
                    "    _ _ _\n" +
                    "    _ _ O\n" +
                    "Score: 7\n" +
                    "Game over!\n" +
                    "    O _ _\n" +
                    "    _ _ _\n" +
                    "_ _ _ O _ _ O\n" +
                    "_ _ _ _ _ _ _\n" +
                    "O _ _ _ _ _ O\n" +
                    "    _ _ _\n" +
                    "    _ _ O\n" +
                    "Score: 6\n");
    Assert.assertEquals(string.toString(), out.toString());
  }
}
