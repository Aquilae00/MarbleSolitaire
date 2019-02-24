import org.junit.Assert;
import org.junit.Test;

import java.io.Reader;
import java.io.StringReader;

import cs3500.marblesolitaire.controller.MarbleSolitaireController;
import cs3500.marblesolitaire.controller.MarbleSolitaireControllerImpl;
import cs3500.marblesolitaire.model.hw04.TriangleSolitaireModelImpl;

public class TriangleSolitaireControllerTest {
  @Test
  public void testPlayGameDefaultQuit1() {
    StringBuffer out = new StringBuffer();
    Reader in = new StringReader("q");
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(in, out);
    controller.playGame(new TriangleSolitaireModelImpl());
    StringBuilder string = new StringBuilder();
    string.append(
            "    _\n" +
                    "   O O\n" +
                    "  O O O\n" +
                    " O O O O\n" +
                    "O O O O O\n" +
                    "Score: 14\n" +
                    "Game quit!\n" +
                    "State of game when quit:\n" +
                    "    _\n" +
                    "   O O\n" +
                    "  O O O\n" +
                    " O O O O\n" +
                    "O O O O O\n" +
                    "Score: 14\n"
    );
    Assert.assertEquals(string.toString(), out.toString());
  }

  @Test
  public void testPlayGameDefaultQuit2() {
    StringBuffer out = new StringBuffer();
    Reader in = new StringReader("1 q");
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(in, out);
    controller.playGame(new TriangleSolitaireModelImpl());
    StringBuilder string = new StringBuilder();
    string.append(
            "    _\n" +
                    "   O O\n" +
                    "  O O O\n" +
                    " O O O O\n" +
                    "O O O O O\n" +
                    "Score: 14\n" +
                    "Game quit!\n" +
                    "State of game when quit:\n" +
                    "    _\n" +
                    "   O O\n" +
                    "  O O O\n" +
                    " O O O O\n" +
                    "O O O O O\n" +
                    "Score: 14\n"
    );
    Assert.assertEquals(string.toString(), out.toString());
  }

  @Test
  public void testPlayGameDefaultQuit3() {
    StringBuffer out = new StringBuffer();
    Reader in = new StringReader("1 2 q");
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(in, out);
    controller.playGame(new TriangleSolitaireModelImpl());
    StringBuilder string = new StringBuilder();
    string.append(
            "    _\n" +
                    "   O O\n" +
                    "  O O O\n" +
                    " O O O O\n" +
                    "O O O O O\n" +
                    "Score: 14\n" +
                    "Game quit!\n" +
                    "State of game when quit:\n" +
                    "    _\n" +
                    "   O O\n" +
                    "  O O O\n" +
                    " O O O O\n" +
                    "O O O O O\n" +
                    "Score: 14\n"
    );
    Assert.assertEquals(string.toString(), out.toString());
  }

  @Test
  public void testPlayGameDefaultQuit4() {
    StringBuffer out = new StringBuffer();
    Reader in = new StringReader("1 2 3 q");
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(in, out);
    controller.playGame(new TriangleSolitaireModelImpl());
    StringBuilder string = new StringBuilder();
    string.append(
            "    _\n" +
                    "   O O\n" +
                    "  O O O\n" +
                    " O O O O\n" +
                    "O O O O O\n" +
                    "Score: 14\n" +
                    "Game quit!\n" +
                    "State of game when quit:\n" +
                    "    _\n" +
                    "   O O\n" +
                    "  O O O\n" +
                    " O O O O\n" +
                    "O O O O O\n" +
                    "Score: 14\n"
    );
    Assert.assertEquals(string.toString(), out.toString());
  }

  @Test
  public void testPlayGameDefaultMoveUpThenQuit() {
    StringBuffer out = new StringBuffer();
    Reader in = new StringReader("3 1 1 1 q");
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(in, out);
    controller.playGame(new TriangleSolitaireModelImpl());
    StringBuilder string = new StringBuilder();
    string.append(
            "    _\n" +
                    "   O O\n" +
                    "  O O O\n" +
                    " O O O O\n" +
                    "O O O O O\n" +
                    "Score: 14\n" +
                    "    O\n" +
                    "   _ O\n" +
                    "  _ O O\n" +
                    " O O O O\n" +
                    "O O O O O\n" +
                    "Score: 13\n" +
                    "Game quit!\n" +
                    "State of game when quit:\n" +
                    "    O\n" +
                    "   _ O\n" +
                    "  _ O O\n" +
                    " O O O O\n" +
                    "O O O O O\n" +
                    "Score: 13\n");
    Assert.assertEquals(string.toString(), out.toString());
  }

  @Test
  public void testPlayGameDefaultMoveLeftThenQuit() {
    StringBuffer out = new StringBuffer();
    Reader in = new StringReader("3 3 3 1 q");
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(in, out);
    controller.playGame(new TriangleSolitaireModelImpl(2, 0));
    StringBuilder string = new StringBuilder();
    string.append(
            "    O\n" +
                    "   O O\n" +
                    "  _ O O\n" +
                    " O O O O\n" +
                    "O O O O O\n" +
                    "Score: 14\n" +
                    "    O\n" +
                    "   O O\n" +
                    "  O _ _\n" +
                    " O O O O\n" +
                    "O O O O O\n" +
                    "Score: 13\n" +
                    "Game quit!\n" +
                    "State of game when quit:\n" +
                    "    O\n" +
                    "   O O\n" +
                    "  O _ _\n" +
                    " O O O O\n" +
                    "O O O O O\n" +
                    "Score: 13\n");
    Assert.assertEquals(string.toString(), out.toString());
  }

  @Test
  public void testPlayGameDefaultMoveRightThenQuit() {
    StringBuffer out = new StringBuffer();
    Reader in = new StringReader("3 1 3 3 q");
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(in, out);
    controller.playGame(new TriangleSolitaireModelImpl(2, 2));
    StringBuilder string = new StringBuilder();
    string.append(
            "    O\n" +
                    "   O O\n" +
                    "  O O _\n" +
                    " O O O O\n" +
                    "O O O O O\n" +
                    "Score: 14\n" +
                    "    O\n" +
                    "   O O\n" +
                    "  _ _ O\n" +
                    " O O O O\n" +
                    "O O O O O\n" +
                    "Score: 13\n" +
                    "Game quit!\n" +
                    "State of game when quit:\n" +
                    "    O\n" +
                    "   O O\n" +
                    "  _ _ O\n" +
                    " O O O O\n" +
                    "O O O O O\n" +
                    "Score: 13\n");
    Assert.assertEquals(string.toString(), out.toString());
  }

  @Test
  public void testPlayGameDefaultMoveDownThenQuit() {
    StringBuffer out = new StringBuffer();
    Reader in = new StringReader("1 1 3 1 q");
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(in, out);
    controller.playGame(new TriangleSolitaireModelImpl(2, 0));
    StringBuilder string = new StringBuilder();
    string.append(
            "    O\n" +
                    "   O O\n" +
                    "  _ O O\n" +
                    " O O O O\n" +
                    "O O O O O\n" +
                    "Score: 14\n" +
                    "    _\n" +
                    "   _ O\n" +
                    "  O O O\n" +
                    " O O O O\n" +
                    "O O O O O\n" +
                    "Score: 13\n" +
                    "Game quit!\n" +
                    "State of game when quit:\n" +
                    "    _\n" +
                    "   _ O\n" +
                    "  O O O\n" +
                    " O O O O\n" +
                    "O O O O O\n" +
                    "Score: 13\n");
    Assert.assertEquals(string.toString(), out.toString());
  }

  @Test
  public void testPlayGameDefaultMoveGameOver() {
    StringBuffer out = new StringBuffer();
    Reader in = new StringReader("3 1 1 1 3 3 3 1 1 1 3 3 4" +
            " 4 2 2 5 3 3 3 5 2 3 2 2 2 4 4 5 5 3 3 4 1 2 1 2 1 4 3 3 3 5 3 5 3 5 5 q");
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(in, out);
    controller.playGame(new TriangleSolitaireModelImpl());
    StringBuilder string = new StringBuilder();
    string.append(
            "    _\n" +
                    "   O O\n" +
                    "  O O O\n" +
                    " O O O O\n" +
                    "O O O O O\n" +
                    "Score: 14\n" +
                    "    O\n" +
                    "   _ O\n" +
                    "  _ O O\n" +
                    " O O O O\n" +
                    "O O O O O\n" +
                    "Score: 13\n" +
                    "    O\n" +
                    "   _ O\n" +
                    "  O _ _\n" +
                    " O O O O\n" +
                    "O O O O O\n" +
                    "Score: 12\n" +
                    "    _\n" +
                    "   _ _\n" +
                    "  O _ O\n" +
                    " O O O O\n" +
                    "O O O O O\n" +
                    "Score: 11\n" +
                    "    _\n" +
                    "   _ O\n" +
                    "  O _ _\n" +
                    " O O O _\n" +
                    "O O O O O\n" +
                    "Score: 10\n" +
                    "    _\n" +
                    "   _ O\n" +
                    "  O _ O\n" +
                    " O O _ _\n" +
                    "O O _ O O\n" +
                    "Score: 9\n" +
                    "    _\n" +
                    "   _ O\n" +
                    "  O O O\n" +
                    " O _ _ _\n" +
                    "O _ _ O O\n" +
                    "Score: 8\n" +
                    "    _\n" +
                    "   _ _\n" +
                    "  O O _\n" +
                    " O _ _ O\n" +
                    "O _ _ O O\n" +
                    "Score: 7\n" +
                    "    _\n" +
                    "   _ _\n" +
                    "  O O O\n" +
                    " O _ _ _\n" +
                    "O _ _ O _\n" +
                    "Score: 6\n" +
                    "    _\n" +
                    "   O _\n" +
                    "  _ O O\n" +
                    " _ _ _ _\n" +
                    "O _ _ O _\n" +
                    "Score: 5\n" +
                    "    _\n" +
                    "   _ _\n" +
                    "  _ _ O\n" +
                    " _ _ O _\n" +
                    "O _ _ O _\n" +
                    "Score: 4\n" +
                    "    _\n" +
                    "   _ _\n" +
                    "  _ _ _\n" +
                    " _ _ _ _\n" +
                    "O _ O O _\n" +
                    "Score: 3\n" +
                    "Game over!\n" +
                    "    _\n" +
                    "   _ _\n" +
                    "  _ _ _\n" +
                    " _ _ _ _\n" +
                    "O _ _ _ O\n" +
                    "Score: 2\n");
    Assert.assertEquals(string.toString(), out.toString());
  }

}

