import org.junit.Assert;
import org.junit.Test;

import java.io.Reader;
import java.io.StringReader;

import cs3500.marblesolitaire.controller.MarbleSolitaireController;
import cs3500.marblesolitaire.controller.MarbleSolitaireControllerImpl;
import cs3500.marblesolitaire.model.hw04.EuropeanSolitaireModelImpl;

public class EuropeanSolitaireController {
  @Test
  public void testPlayGameDefaultQuit1() {
    StringBuffer out = new StringBuffer();
    Reader in = new StringReader("q");
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(in, out);
    controller.playGame(new EuropeanSolitaireModelImpl());
    StringBuilder string = new StringBuilder();
    string.append(
            "    O O O\n" +
                    "  O O O O O\n" +
                    "O O O O O O O\n" +
                    "O O O _ O O O\n" +
                    "O O O O O O O\n" +
                    "  O O O O O\n" +
                    "    O O O\n" +
                    "Score: 36\n" +
                    "Game quit!\n" +
                    "State of game when quit:\n" +
                    "    O O O\n" +
                    "  O O O O O\n" +
                    "O O O O O O O\n" +
                    "O O O _ O O O\n" +
                    "O O O O O O O\n" +
                    "  O O O O O\n" +
                    "    O O O\n" +
                    "Score: 36\n"
    );
    Assert.assertEquals(string.toString(), out.toString());
  }

  @Test
  public void testPlayGameDefaultQuit2() {
    StringBuffer out = new StringBuffer();
    Reader in = new StringReader("1 q");
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(in, out);
    controller.playGame(new EuropeanSolitaireModelImpl());
    StringBuilder string = new StringBuilder();
    string.append(
            "    O O O\n" +
                    "  O O O O O\n" +
                    "O O O O O O O\n" +
                    "O O O _ O O O\n" +
                    "O O O O O O O\n" +
                    "  O O O O O\n" +
                    "    O O O\n" +
                    "Score: 36\n" +
                    "Game quit!\n" +
                    "State of game when quit:\n" +
                    "    O O O\n" +
                    "  O O O O O\n" +
                    "O O O O O O O\n" +
                    "O O O _ O O O\n" +
                    "O O O O O O O\n" +
                    "  O O O O O\n" +
                    "    O O O\n" +
                    "Score: 36\n"
    );
    Assert.assertEquals(string.toString(), out.toString());
  }

  @Test
  public void testPlayGameDefaultQuit3() {
    StringBuffer out = new StringBuffer();
    Reader in = new StringReader("1 2 q");
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(in, out);
    controller.playGame(new EuropeanSolitaireModelImpl());
    StringBuilder string = new StringBuilder();
    string.append(
            "    O O O\n" +
                    "  O O O O O\n" +
                    "O O O O O O O\n" +
                    "O O O _ O O O\n" +
                    "O O O O O O O\n" +
                    "  O O O O O\n" +
                    "    O O O\n" +
                    "Score: 36\n" +
                    "Game quit!\n" +
                    "State of game when quit:\n" +
                    "    O O O\n" +
                    "  O O O O O\n" +
                    "O O O O O O O\n" +
                    "O O O _ O O O\n" +
                    "O O O O O O O\n" +
                    "  O O O O O\n" +
                    "    O O O\n" +
                    "Score: 36\n"
    );
    Assert.assertEquals(string.toString(), out.toString());
  }

  @Test
  public void testPlayGameDefaultQuit4() {
    StringBuffer out = new StringBuffer();
    Reader in = new StringReader("1 2 3 q");
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(in, out);
    controller.playGame(new EuropeanSolitaireModelImpl());
    StringBuilder string = new StringBuilder();
    string.append(
            "    O O O\n" +
                    "  O O O O O\n" +
                    "O O O O O O O\n" +
                    "O O O _ O O O\n" +
                    "O O O O O O O\n" +
                    "  O O O O O\n" +
                    "    O O O\n" +
                    "Score: 36\n" +
                    "Game quit!\n" +
                    "State of game when quit:\n" +
                    "    O O O\n" +
                    "  O O O O O\n" +
                    "O O O O O O O\n" +
                    "O O O _ O O O\n" +
                    "O O O O O O O\n" +
                    "  O O O O O\n" +
                    "    O O O\n" +
                    "Score: 36\n"
    );
    Assert.assertEquals(string.toString(), out.toString());
  }

  @Test
  public void testPlayGameDefaultMoveUpThenQuit() {
    StringBuffer out = new StringBuffer();
    Reader in = new StringReader("6 4 4 4 q");
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(in, out);
    controller.playGame(new EuropeanSolitaireModelImpl());
    StringBuilder string = new StringBuilder();
    string.append(
            "    O O O\n" +
                    "  O O O O O\n" +
                    "O O O O O O O\n" +
                    "O O O _ O O O\n" +
                    "O O O O O O O\n" +
                    "  O O O O O\n" +
                    "    O O O\n" +
                    "Score: 36\n" +
                    "    O O O\n" +
                    "  O O O O O\n" +
                    "O O O O O O O\n" +
                    "O O O O O O O\n" +
                    "O O O _ O O O\n" +
                    "  O O _ O O\n" +
                    "    O O O\n" +
                    "Score: 35\n" +
                    "Game quit!\n" +
                    "State of game when quit:\n" +
                    "    O O O\n" +
                    "  O O O O O\n" +
                    "O O O O O O O\n" +
                    "O O O O O O O\n" +
                    "O O O _ O O O\n" +
                    "  O O _ O O\n" +
                    "    O O O\n" +
                    "Score: 35\n"
    );
    Assert.assertEquals(string.toString(), out.toString());
  }

  @Test
  public void testPlayGameDefaultMoveDownThenQuit() {
    StringBuffer out = new StringBuffer();
    Reader in = new StringReader("2 4 4 4 q");
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(in, out);
    controller.playGame(new EuropeanSolitaireModelImpl());
    StringBuilder string = new StringBuilder();
    string.append(
            "    O O O\n" +
                    "  O O O O O\n" +
                    "O O O O O O O\n" +
                    "O O O _ O O O\n" +
                    "O O O O O O O\n" +
                    "  O O O O O\n" +
                    "    O O O\n" +
                    "Score: 36\n" +
                    "    O O O\n" +
                    "  O O _ O O\n" +
                    "O O O _ O O O\n" +
                    "O O O O O O O\n" +
                    "O O O O O O O\n" +
                    "  O O O O O\n" +
                    "    O O O\n" +
                    "Score: 35\n" +
                    "Game quit!\n" +
                    "State of game when quit:\n" +
                    "    O O O\n" +
                    "  O O _ O O\n" +
                    "O O O _ O O O\n" +
                    "O O O O O O O\n" +
                    "O O O O O O O\n" +
                    "  O O O O O\n" +
                    "    O O O\n" +
                    "Score: 35\n"
    );
    Assert.assertEquals(string.toString(), out.toString());
  }

  @Test
  public void testPlayGameDefaultMoveRightThenQuit() {
    StringBuffer out = new StringBuffer();
    Reader in = new StringReader("4 2 4 4 q");
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(in, out);
    controller.playGame(new EuropeanSolitaireModelImpl());
    StringBuilder string = new StringBuilder();
    string.append(
            "    O O O\n" +
                    "  O O O O O\n" +
                    "O O O O O O O\n" +
                    "O O O _ O O O\n" +
                    "O O O O O O O\n" +
                    "  O O O O O\n" +
                    "    O O O\n" +
                    "Score: 36\n" +
                    "    O O O\n" +
                    "  O O O O O\n" +
                    "O O O O O O O\n" +
                    "O _ _ O O O O\n" +
                    "O O O O O O O\n" +
                    "  O O O O O\n" +
                    "    O O O\n" +
                    "Score: 35\n" +
                    "Game quit!\n" +
                    "State of game when quit:\n" +
                    "    O O O\n" +
                    "  O O O O O\n" +
                    "O O O O O O O\n" +
                    "O _ _ O O O O\n" +
                    "O O O O O O O\n" +
                    "  O O O O O\n" +
                    "    O O O\n" +
                    "Score: 35\n");
    Assert.assertEquals(string.toString(), out.toString());
  }

  @Test
  public void testPlayGameDefaultMoveLeftThenQuit() {
    StringBuffer out = new StringBuffer();
    Reader in = new StringReader("4 6 4 4 q");
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(in, out);
    controller.playGame(new EuropeanSolitaireModelImpl());
    StringBuilder string = new StringBuilder();
    string.append(
            "    O O O\n" +
                    "  O O O O O\n" +
                    "O O O O O O O\n" +
                    "O O O _ O O O\n" +
                    "O O O O O O O\n" +
                    "  O O O O O\n" +
                    "    O O O\n" +
                    "Score: 36\n" +
                    "    O O O\n" +
                    "  O O O O O\n" +
                    "O O O O O O O\n" +
                    "O O O O _ _ O\n" +
                    "O O O O O O O\n" +
                    "  O O O O O\n" +
                    "    O O O\n" +
                    "Score: 35\n" +
                    "Game quit!\n" +
                    "State of game when quit:\n" +
                    "    O O O\n" +
                    "  O O O O O\n" +
                    "O O O O O O O\n" +
                    "O O O O _ _ O\n" +
                    "O O O O O O O\n" +
                    "  O O O O O\n" +
                    "    O O O\n" +
                    "Score: 35\n");
    Assert.assertEquals(string.toString(), out.toString());
  }
}
